package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	private static final Logger logger = Logger.getLogger(DashboardController.class);
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	@RequestMapping("/")
	public String showView(Model model, HttpSession session) {
		List<Object> dashboardDataCountList = (List<Object>) databaseServiceImpl.getDataFromSQLFunction(
		    "fn_dashboard_data_count", "");
		
		session.setAttribute("dashboardDataCount", dashboardDataCountList);
		return "home";
	}
}
