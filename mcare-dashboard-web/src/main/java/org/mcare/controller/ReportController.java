package org.mcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mcare.common.util.PaginationHelperUtil;
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

	private static final Logger logger = Logger.getLogger(ReportController.class);

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
		logger.info("In showFormWiseReport");
		searchFilterBuilder = searchUtil.setParamsForReport(request, session);
		searchUtil.setProviderAttribute(session);
		searchUtil.setDivisionAttribute(session);
		List<Object> formWiseAggregatedList = (List<Object>) reportService.findFormWiseReport(searchFilterBuilder);
		session.setAttribute("formWiseAggregatedList", formWiseAggregatedList);
		setSelectedfilter(request, session);

		return "report/formWiseReport";
	}

	@RequestMapping(value = "/providerWiseReport.html", method = RequestMethod.GET)
	public String showProviderWiseReport(HttpServletRequest request, HttpSession session, Model model) {
		logger.info("In showProviderWiseReport");
		searchFilterBuilder = searchUtil.setParamsForReport(request, session);
		searchUtil.setFormAttribute(session);
		searchUtil.setDivisionAttribute(session);
		List<Object> providerWiseAggregatedList = (List<Object>) reportService.findProviderWiseReport(searchFilterBuilder);
		session.setAttribute("providerWiseAggregatedList", providerWiseAggregatedList);
		setSelectedfilter(request, session);

		return "report/providerWiseReport";
	}

	private void setSelectedfilter(HttpServletRequest request, HttpSession session) {
		Map<String, String> map = new HashMap<>();
		String division = "";
		int divId = 0;
		if (request.getParameterMap().containsKey("division")) {
			division = request.getParameter("division") == null ? "0?" : request.getParameter("division");
			divId = PaginationHelperUtil.getParentId(division);
			map.put("divId", String.valueOf(divId));
		}
		String district = "";
		int distId = 0;
		if (request.getParameterMap().containsKey("district")) {
			district = request.getParameter("district") == null ? "0?" : request.getParameter("district");
			distId = PaginationHelperUtil.getParentId(district);
			map.put("distId", String.valueOf(distId));
		}
		String upazila = "";
		int upzilaId = 0;
		if (request.getParameterMap().containsKey("upazila")) {
			upazila = request.getParameter("upazila") == null ? "0?" : request.getParameter("upazila");
			upzilaId = PaginationHelperUtil.getParentId(upazila);

			map.put("upzilaId", String.valueOf(upzilaId));
		}
		String union = "";
		int unionId = 0;
		if (request.getParameterMap().containsKey("union")) {
			union = request.getParameter("union") == null ? "0?" : request.getParameter("union");
			unionId = PaginationHelperUtil.getParentId(union);
			map.put("unionId", String.valueOf(unionId));
		}

		String ward = "";
		int wardId = 0;
		if (request.getParameterMap().containsKey("ward")) {
			ward = request.getParameter("ward") == null ? "0?" : request.getParameter("ward");
			wardId = PaginationHelperUtil.getParentId(ward);
			map.put("wardId", String.valueOf(wardId));
		}

		String subunit = "";
		int subunitId = 0;
		if (request.getParameterMap().containsKey("subunit")) {
			subunit = request.getParameter("subunit") == null ? "0?" : request.getParameter("subunit");
			subunitId = PaginationHelperUtil.getParentId(subunit);
			map.put("subunitId", String.valueOf(subunitId));
		}
		String mauzapara = "";
		int mauzaparaId = 0;
		if (request.getParameterMap().containsKey("mauzapara")) {
			mauzapara = request.getParameter("mauzapara") == null ? "0?" : request.getParameter("mauzapara");
			mauzaparaId = PaginationHelperUtil.getParentId(mauzapara);
			map.put("mauzaparaId", String.valueOf(mauzaparaId));
		}

		String provider = "";
		if (request.getParameterMap().containsKey("provider")) {
			provider = request.getParameter("provider") == null ? "" : request.getParameter("provider");
			map.put("provider", provider);
		}

		String formName = "";
		if (request.getParameterMap().containsKey("formName")) {
			formName = request.getParameter("formName") == null ? "" : request.getParameter("formName");
			map.put("formName", formName);
		}

		String start = "";
		if (request.getParameterMap().containsKey("start")) {
			start = request.getParameter("start") == null ? "" : request.getParameter("start");
			map.put("start", start);
		}

		String end = "";
		if (request.getParameterMap().containsKey("end")) {
			end = request.getParameter("end") == null ? "" : request.getParameter("end");
			map.put("end", end);
		}

		session.setAttribute("selectedFilter", map);
	}
}
