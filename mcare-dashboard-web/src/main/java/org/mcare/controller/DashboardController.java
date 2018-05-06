package org.mcare.controller;

import java.util.Iterator;
import java.util.List;

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
	public String showView(Model model) {
		List<Object> dashboardDataCountList = (List<Object>) databaseServiceImpl.getDataFromSQLFunction(
		    "fn_dashboard_data_count", "");
		String type = "";
		String totalCount = "";
		String thisMonthCount = "";
		String lastSevenDaysCount = "";
		String todaysCount = "";
		Iterator<Object> formWiseAggregatedListIterator = dashboardDataCountList.iterator();
		while (formWiseAggregatedListIterator.hasNext()) {
			Object[] formWiseObject = (Object[]) formWiseAggregatedListIterator.next();
			type = String.valueOf(formWiseObject[0]);
			totalCount = String.valueOf(formWiseObject[1]);
			thisMonthCount = String.valueOf(formWiseObject[2]);
			lastSevenDaysCount = String.valueOf(formWiseObject[3]);
			todaysCount = String.valueOf(formWiseObject[4]);
		}
		
		logger.info("Data:" + type + ": " + totalCount + " :" + thisMonthCount + " : " + lastSevenDaysCount + ": "
		        + todaysCount);
		return "home";
	}
}
