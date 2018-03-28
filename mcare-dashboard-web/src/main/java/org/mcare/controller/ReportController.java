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

		setListToSession(session);

		return "report/report";
	}

	private void setListToSession(HttpSession session) {
		List<Object> ANC1List = (List<Object>) reportService.findAllANC1Data(searchBuilder);
		session.setAttribute("ANC1List", ANC1List);

		List<Object> ANC2List = (List<Object>) reportService.findAllANC2Data(searchBuilder);
		session.setAttribute("ANC2List", ANC2List);

		List<Object> ANC3List = (List<Object>) reportService.findAllANC3Data(searchBuilder);
		session.setAttribute("ANC3List", ANC3List);

		List<Object> ANC4List = (List<Object>) reportService.findAllANC4Data(searchBuilder);
		session.setAttribute("ANC4List", ANC4List);

		List<Object> PNC1List = (List<Object>) reportService.findAllPNC1Data(searchBuilder);
		session.setAttribute("PNC1List", PNC1List);

		List<Object> PNC2List = (List<Object>) reportService.findAllPNC2Data(searchBuilder);
		session.setAttribute("PNC2List", PNC2List);

		List<Object> PNC3List = (List<Object>) reportService.findAllPNC3Data(searchBuilder);
		session.setAttribute("PNC3List", PNC3List);

		List<Object> ENCC1List = (List<Object>) reportService.findAllENCC1Data(searchBuilder);
		session.setAttribute("ENCC1List", ENCC1List);

		List<Object> ENCC2List = (List<Object>) reportService.findAllENCC2Data(searchBuilder);
		session.setAttribute("ENCC2List", ENCC2List);

		List<Object> ENCC3List = (List<Object>) reportService.findAllENCC3Data(searchBuilder);
		session.setAttribute("ENCC3List", ENCC3List);

		List<Object> BNFList = (List<Object>) reportService.findAllBNFData(searchBuilder);
		session.setAttribute("BNFList", BNFList);

		List<Object> PSRFList = (List<Object>) reportService.findAllPSRFData(searchBuilder);
		session.setAttribute("PSRFList", PSRFList);
	}
}
