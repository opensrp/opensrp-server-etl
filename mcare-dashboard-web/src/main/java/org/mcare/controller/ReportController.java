package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.common.util.SearchUtil;
import org.mcare.reports.service.ReportService;
import org.mcare.reports.service.SearchFilterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;

	@Autowired
	private SearchUtil searchUtil;

	@Autowired
	private SearchFilterBuilder searchFilterBuilder;

	public ReportController() {
	}

	@RequestMapping(value = "/formWiseReport.html", method = RequestMethod.GET)
	public String showFormWiseReport(HttpServletRequest request, HttpSession session, Model model) {
		searchFilterBuilder = searchUtil.setParamsForReport(request, session);
		searchUtil.setProviderAttribute(session);
		searchUtil.setDivisionAttribute(session);
		List<Object> formWiseAggregatedList = (List<Object>) reportService.findFormWiseReport(searchFilterBuilder);
		session.setAttribute("formWiseAggregatedList", formWiseAggregatedList);
		return "report/formWiseReport";
	}
}
