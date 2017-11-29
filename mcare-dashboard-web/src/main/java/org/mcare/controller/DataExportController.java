/**
 * 
 */
package org.mcare.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mcare.data.export.service.DataExportService;
import org.mcare.data.export.service.impl.DataExportServiceFactory;
import org.mcare.data.export.service.impl.FormEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author proshanto
 */
@Controller
public class DataExportController {
	
	@Autowired
	private DataExportServiceFactory dataExportServiceFactory;
	
	private DataExportService dataExportService;
	
	public DataExportController() {
		
	}
	
	@RequestMapping(value = "/log/log.csv", method = RequestMethod.GET)
	public void getLogAsCSV(final HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		String reportName = "CSV_Report_Name.csv";
		response.setHeader("Content-disposition", "attachment;filename=" + reportName);
		
		ArrayList<String> rows = new ArrayList<String>();
		rows.add("Name,Result");
		rows.add("\n");
		
		for (int i = 0; i < 10; i++) {
			rows.add("Java Honk,Success");
			rows.add("\n");
		}
		
		Iterator<String> iter = rows.iterator();
		while (iter.hasNext()) {
			String outputString = (String) iter.next();
			response.getOutputStream().print(outputString);
		}
		
		response.getOutputStream().flush();
		
	}
	
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView dataExportGet(HttpServletResponse response, Model model) {
		
		return new ModelAndView("export/form", "command", new FormEntity());
	}
	
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	public ModelAndView dataExportPost(@ModelAttribute("form") FormEntity form, ModelMap model, HttpServletResponse response) {
		System.err.println("dataExportServiceFactory;"
		        + dataExportServiceFactory.getDataExportServiceWithFormName(form.getFormName()).getData(null, null,
		            "provider"));
		
		dataExportService = dataExportServiceFactory.getDataExportServiceWithFormName(form.getFormName());
		List<Object[]> datas = dataExportService.getData(null, null, "provider");
		dataExportService.export(datas, response);
		System.err.println("form:" + form.getFormName() + "  Start:" + form.getStart());
		return new ModelAndView("redirect:/export");
	}
}
