package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.service.impl.ProviderServiceImpl;
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
	
	@Autowired
	private ProviderServiceImpl providerServiceImpl;
	
	@RequestMapping(value = "/fwa/anc/monitoring.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		
		String provider = request.getParameter("provider");
		
		/*for (Object[] objects : data) {
			System.err.println("objects:" + objects.length);
			for (int i = 0; i < objects.length; i++) {
				System.err.println("" + objects[i]);
			}
			
		}*/
		
		if (provider != null) {
			List<Object[]> data = scheduleMonitoring.getData(provider, "");
			session.setAttribute("data", data);
			System.err.println("data:" + data.size());
			session.setAttribute("provider", provider);
		} else {
			
			providerServiceImpl.setProviderAttribute(session);
			
			session.setAttribute("provider", "");
		}
		return "schedule-monitoring/index";
	}
}
