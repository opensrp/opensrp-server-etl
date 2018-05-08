package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.mcare.common.util.SearchUtil;
import org.mcare.params.builder.SearchBuilder;
import org.mcare.visualization.DataVisualization;
import org.mcare.visualization.utils.VisualizeDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
	
	private static final Logger logger = Logger.getLogger(DashboardController.class);
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	@Autowired
	private SearchUtil searchUtil;
	
	@Autowired
	private SearchBuilder searchBuilder;
	
	@Autowired
	private DataVisualization dataVisualization;
	
	@RequestMapping("/")
	public String showHome(Model model, HttpSession session) {
		List<Object> dashboardDataCountList = (List<Object>) databaseServiceImpl.getDataFromSQLFunction(
		    "fn_dashboard_data_count", "");
		
		session.setAttribute("dashboardDataCount", dashboardDataCountList);
		return "home";
	}
	
	@RequestMapping(value = "visualize/household.html", method = RequestMethod.GET)
	public String visualizeHousehold(HttpServletRequest request, Model model, HttpSession session) {
		model.addAttribute("title", "Household search criteria");
		searchBuilder = searchUtil.generateSearchBuilderParams(request, session);
		searchUtil.setProviderAttribute(session);
		searchUtil.setDivisionAttribute(session);
		searchUtil.setSelectedfilter(request, session);
		logger.info("SS:" + searchBuilder.toString());
		List<Object[]> data = dataVisualization.getData(VisualizeDataType.household.name(), searchBuilder);
		System.err.println("" + data.toString());
		for (Object[] row : data) {
			System.err.println("" + row[0] + ": " + row[1]);
		}
		return "visualize/household";
		
	}
}
