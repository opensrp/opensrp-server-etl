package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.schedule.monitoring.ScheduleMonitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ScheduleMonitoringController {
	
	@Autowired
	private ScheduleMonitoring scheduleMonitoring;
	
	@RequestMapping(value = "/schedule/monitoring.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		List<Object[]> data = scheduleMonitoring.getData("shirina", "");
		System.err.println("data:" + data.size());
		for (Object[] objects : data) {
			System.err.println("objects:" + objects.length);
			for (int i = 0; i < objects.length; i++) {
				System.err.println("" + objects[i]);
			}
			
		}
		model.addAttribute("data", data);
		return "schedule-monitoring/index";
	}
	
}
