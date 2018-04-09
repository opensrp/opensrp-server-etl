package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.common.util.PaginationHelperUtil;
import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.ChildEntity;
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

		Class<ChildEntity> entityClassName = ChildEntity.class;
		paginationUtil.createPagination(request, session, entityClassName);

		setListToSession(session);

		return "report/report";
	}

	private void setListToSession(HttpSession session) {
		System.err.println("count list from procedure");
		List<Object> allList = (List<Object>) reportService.findCountReport(reportSearchBuilder);
		System.err.println("set session allList");
		session.setAttribute("allList", allList);
	}
}
