package org.mcare.controller;

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
		session.setAttribute("ANC1", reportService.findScheduledVisits("ancrv_1").get(0));
		session.setAttribute("ANC2", reportService.findScheduledVisits("ancrv_2").get(0));
		session.setAttribute("ANC3", reportService.findScheduledVisits("ancrv_3").get(0));
		session.setAttribute("ANC4", reportService.findScheduledVisits("ancrv_4").get(0));

		session.setAttribute("ANC1Completed", reportService.findAllCompletedVisits("anc","ancname", "ancrv_1").get(0));

		return "report/report";
	}
}
