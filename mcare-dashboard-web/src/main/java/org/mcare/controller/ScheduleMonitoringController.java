package org.mcare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.schedule.monitoring.ScheduleMonitoring;
import org.mcare.schedule.monitoring.service.ScheduleMonitoringService;
import org.mcare.schedule.monitoring.service.impl.ANCScheduleMonitoringServiceImpl;
import org.mcare.schedule.monitoring.service.impl.ENCCScheduleMonitoringServiceImpl;
import org.mcare.schedule.monitoring.service.impl.PNCScheduleMonitoringServiceImpl;
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
	
	@Autowired
	private PNCScheduleMonitoringServiceImpl pncScheduleMonitoringServiceImpl;
	
	@Autowired
	private ENCCScheduleMonitoringServiceImpl enccScheduleMonitoringServiceImpl;
	
	private ScheduleMonitoringService scheduleMonitoringService;
	
	@RequestMapping(value = "/fwa/anc/monitoring.html", method = RequestMethod.GET)
	public String anc(HttpServletRequest request, HttpSession session, Model model) {
		scheduleMonitoringService = ancScheduleMonitoringServiceImpl;
		String provider = request.getParameter("provider");
		
		/*for (Object[] objects : data) {
			System.err.println("objects:" + objects.length);
			for (int i = 0; i < objects.length; i++) {
				System.err.println("" + objects[i]);
			}
			
		}*/
		List<Object[]> data = new ArrayList<Object[]>();
		
		if (provider != null) {
			data = scheduleMonitoring.getData(provider, "ANC");
			session.setAttribute("provider", provider);
			session.setAttribute("scheduleMonitoringService", scheduleMonitoringService);
		} else {
			data = new ArrayList<Object[]>();
			
			session.setAttribute("provider", "");
		}
		session.setAttribute("data", data);
		providerServiceImpl.setProviderAttribute(session);
		return "schedule-monitoring/index";
	}
	
	@RequestMapping(value = "/fwa/pnc/monitoring.html", method = RequestMethod.GET)
	public String pnc(HttpServletRequest request, HttpSession session, Model model) {
		scheduleMonitoringService = pncScheduleMonitoringServiceImpl;
		String provider = request.getParameter("provider");
		
		List<Object[]> data = new ArrayList<Object[]>();
		
		if (provider != null) {
			data = scheduleMonitoring.getData(provider, "PNC");
			session.setAttribute("provider", provider);
			session.setAttribute("scheduleMonitoringService", scheduleMonitoringService);
		} else {
			data = new ArrayList<Object[]>();
			
			session.setAttribute("provider", "");
		}
		session.setAttribute("data", data);
		providerServiceImpl.setProviderAttribute(session);
		return "schedule-monitoring/pnc";
	}
	
	@RequestMapping(value = "/fwa/encc/monitoring.html", method = RequestMethod.GET)
	public String encc(HttpServletRequest request, HttpSession session, Model model) {
		scheduleMonitoringService = enccScheduleMonitoringServiceImpl;
		String provider = request.getParameter("provider");
		
		List<Object[]> data = new ArrayList<Object[]>();
		
		if (provider != null) {
			data = scheduleMonitoring.getData(provider, "ENCC");
			session.setAttribute("provider", provider);
			session.setAttribute("scheduleMonitoringService", scheduleMonitoringService);
		} else {
			data = new ArrayList<Object[]>();
			
			session.setAttribute("provider", "");
		}
		session.setAttribute("data", data);
		providerServiceImpl.setProviderAttribute(session);
		return "schedule-monitoring/encc";
	}
}
