package org.mcare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.schedule.monitoring.ScheduleMonitoring;
import org.mcare.schedule.monitoring.service.impl.ANCScheduleMonitoringServiceImpl;
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
	
	@Autowired
	private ANCScheduleMonitoringServiceImpl ancScheduleMonitoringServiceImpl;
	
	@RequestMapping(value = "/fwa/anc/monitoring.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		
		String provider = request.getParameter("provider");
		
		/*for (Object[] objects : data) {
			System.err.println("objects:" + objects.length);
			for (int i = 0; i < objects.length; i++) {
				System.err.println("" + objects[i]);
			}
			
		}*/
		List<Object[]> data = new ArrayList<Object[]>();
		
		if (provider != null) {
			data = scheduleMonitoring.getData(provider, "");
			
			session.setAttribute("provider", provider);
			session.setAttribute("ancScheduleMonitoringServiceImpl", ancScheduleMonitoringServiceImpl);
		} else {
			data = new ArrayList<Object[]>();
			
			session.setAttribute("provider", "");
		}
		session.setAttribute("data", data);
		providerServiceImpl.setProviderAttribute(session);
		return "schedule-monitoring/index";
	}
}
