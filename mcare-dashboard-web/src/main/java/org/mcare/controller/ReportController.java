package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.common.util.PaginationHelperUtil;
import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.ChildEntity;
import org.mcare.params.builder.SearchBuilder;
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
	private SearchBuilder searchBuilder;

	public ReportController() {
	}

	@RequestMapping(value = "/reportCount.html", method = RequestMethod.GET)
	public String showReport(HttpServletRequest request, HttpSession session, Model model) {
		searchBuilder = paginationHelperUtil.setParams(request, session);

		Class<ChildEntity> entityClassName = ChildEntity.class;
		paginationUtil.createPagination(request, session, entityClassName);

		List<Object> result = (List<Object>) reportService.findAllANC1Data(searchBuilder);
		session.setAttribute("ANC1List", result);

		List<Object> result2 = (List<Object>) reportService.findAllANC2Data(searchBuilder);
		session.setAttribute("ANC2List", result2);

		List<Object> result3 = (List<Object>) reportService.findAllANC3Data(searchBuilder);
		session.setAttribute("ANC3List", result3);

		List<Object> result4 = (List<Object>) reportService.findAllANC4Data(searchBuilder);
		session.setAttribute("ANC4List", result4);

		return "report/report";
	}
}
