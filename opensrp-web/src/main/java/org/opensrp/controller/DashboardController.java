package org.opensrp.controller;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.opensrp.common.service.impl.DatabaseServiceImpl;
import org.opensrp.connector.openmrs.service.impl.OpenmrsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	private static final Logger logger = Logger.getLogger(DashboardController.class);
	
	private Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	@Autowired
	private OpenmrsRoleService openmrsRoleService;
	
	@RequestMapping("/")
	public String showHome(Model model, HttpSession session) {
		openmrsRoleService.get();
		return "home";
	}
	
}
