package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.common.util.PaginationHelperUtil;
import org.mcare.common.util.PaginationUtil;
import org.mcare.reports.service.ReportSearchBuilder;
import org.mcare.reports.service.ReportService;
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
	private PaginationUtil paginationUtil;

	@Autowired
	private PaginationHelperUtil paginationHelperUtil;

	@Autowired
	private ReportSearchBuilder reportSearchBuilder;

	public ReportController() {
	}

	@RequestMapping(value = "/reportCount.html", method = RequestMethod.GET)
	public String showReport(HttpServletRequest request, HttpSession session, Model model) {
		reportSearchBuilder = paginationHelperUtil.setParamsForReport(request, session);
		paginationUtil.setProviderAttribute(session);
		paginationUtil.setParentDataAttribute(session);

		System.err.println("list of counts from procedure");

		List<Object> allList = (List<Object>) reportService.findFormWiseReport(reportSearchBuilder);
		session.setAttribute("allList", allList);

		System.err.println("set session allList");

		return "report/report";
	}
}
