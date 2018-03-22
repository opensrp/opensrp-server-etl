package org.mcare.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	public ReportController() {
	}

	@RequestMapping(value = "/reportCount.html", method = RequestMethod.GET)
	public String showReport(HttpServletRequest request, HttpSession session, Model model) {
//		Map<String,Object> map = new LinkedHashMap<String,Object>();
//		map.put("ancrv_1", reportService.findScheduledVisits("ancrv_1").get(0));
//		map.put("ancrv_2", reportService.findScheduledVisits("ancrv_2").get(0));
//		map.put("ancrv_3", reportService.findScheduledVisits("ancrv_3").get(0));
//		map.put("ancrv_4", reportService.findScheduledVisits("ancrv_4").get(0));
//
//
//
//		Map<String, ArrayList<Object>> maps = new LinkedHashMap<String, ArrayList<Object>>();
//		ArrayList<Object> anc1List = new ArrayList<Object>();
//		anc1List.add(reportService.findScheduledVisits("ancrv_1").get(0));
//		anc1List.add(reportService.findAllCompletedVisits("anc","ancname", "ancrv_1").get(0));
//
//
//		ArrayList<Object> anc2List = new ArrayList<Object>();
//		anc2List.add(reportService.findScheduledVisits("ancrv_2").get(0));
//		anc2List.add(reportService.findAllCompletedVisits("anc","ancname", "ancrv_2").get(0));
//
//		ArrayList<Object> anc3List = new ArrayList<Object>();
//		anc3List.add(reportService.findScheduledVisits("ancrv_3").get(0));
//		anc3List.add(reportService.findAllCompletedVisits("anc","ancname", "ancrv_3").get(0));
//
//		ArrayList<Object> anc4List = new ArrayList<Object>();
//		anc4List.add(reportService.findScheduledVisits("ancrv_4").get(0));
//		anc4List.add(reportService.findAllCompletedVisits("anc","ancname", "ancrv_4").get(0));
//
//
//		maps.put("ancrv_1", anc1List);
//		maps.put("ancrv_2", anc2List);
//		maps.put("ancrv_3", anc3List);
//		maps.put("ancrv_4", anc4List);
//
//		session.setAttribute("reportList", map);

		//List<Object> data = new ArrayList<Object>();

		//data.add(reportService.findScheduledVisits("ancrv_1").get(0));
		//data.add(reportService.findScheduledVisits("ancrv_2").get(0));
		//data.add(reportService.findScheduledVisits("ancrv_3").get(0));
		//data.add(reportService.findScheduledVisits("ancrv_4").get(0));


		session.setAttribute("ANC1", reportService.findScheduledVisits("ancrv_1").get(0));
		session.setAttribute("ANC2", reportService.findScheduledVisits("ancrv_2").get(0));
		session.setAttribute("ANC3", reportService.findScheduledVisits("ancrv_3").get(0));
		session.setAttribute("ANC4", reportService.findScheduledVisits("ancrv_4").get(0));
		session.setAttribute("ANC1Completed", reportService.findAllCompletedVisits("anc","ancname", "ancrv_1").get(0));

		return "report/report";
	}
}
