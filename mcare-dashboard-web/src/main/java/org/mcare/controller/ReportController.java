package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mcare.acl.entity.UsageHistory;
import org.mcare.acl.service.impl.UsageHistoryServiceImpl;
import org.mcare.common.util.SearchUtil;
import org.mcare.reports.service.ReportService;
import org.mcare.reports.service.SearchFilterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author nursat
 *
 */

@Controller
public class ReportController {

    private static final Logger logger = Logger.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;

    @Autowired
    private SearchUtil searchUtil;

    @Autowired
    private SearchFilterBuilder searchFilterBuilder;

    @Autowired
    private UsageHistoryServiceImpl usageHistoryServiceImpl;

    public ReportController() {
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_READ_REPORT')")
    @RequestMapping(value = "/formWiseReport.html", method = RequestMethod.GET)
    public String showFormWiseReport(HttpServletRequest request, HttpSession session, Model model) {
        logger.info("In showFormWiseReport");
        searchFilterBuilder = searchUtil.setParamsForReport(request, session);
        searchUtil.setProviderAttribute(session);
        searchUtil.setDivisionAttribute(session);
        List<Object> formWiseAggregatedList = (List<Object>) reportService.findFormWiseReport(searchFilterBuilder);
        session.setAttribute("formWiseAggregatedList", formWiseAggregatedList);
        searchUtil.setSelectedfilter(request, session);

        return "report/formWiseReport";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_READ_REPORT')")
    @RequestMapping(value = "/providerWiseReport.html", method = RequestMethod.GET)
    public String showProviderWiseReport(HttpServletRequest request, HttpSession session, Model model) {
        logger.info("In showProviderWiseReport");
        searchFilterBuilder = searchUtil.setParamsForReport(request, session);
        searchUtil.setFormAttribute(session);
        searchUtil.setDivisionAttribute(session);
        List<Object> providerWiseAggregatedList = (List<Object>) reportService.findProviderWiseReport(searchFilterBuilder);
        session.setAttribute("providerWiseAggregatedList", providerWiseAggregatedList);
        searchUtil.setSelectedfilter(request, session);

        return "report/providerWiseReport";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_READ_REPORT')")
    @RequestMapping(value = "/usageHistoryReport.html", method = RequestMethod.GET)
    public String showUsageHistoryReport(HttpServletRequest request, HttpSession session, Model model) {
        logger.info("In usageHistoryReport");
        searchFilterBuilder = searchUtil.setParamsForReport(request, session);
        searchUtil.setFormAttribute(session);
        searchUtil.setDivisionAttribute(session);
        List<UsageHistory> usageHistoryList = usageHistoryServiceImpl.findAll("UsageHistory");
        session.setAttribute("usageHistoryList", usageHistoryList);
        searchUtil.setSelectedfilter(request, session);

        return "report/usageHistoryReport";
    }

}
