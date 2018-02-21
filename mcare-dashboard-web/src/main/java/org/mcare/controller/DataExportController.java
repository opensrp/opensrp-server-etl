/**
 * 
 */
package org.mcare.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mcare.acl.entity.ProviderEntity;
import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.common.util.DateUtil;
import org.mcare.common.util.FormName;
import org.mcare.data.export.entity.DataExportEntity;
import org.mcare.data.export.service.DataExportService;
import org.mcare.data.export.service.impl.DataExportServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

/**
 * @author proshanto
 */
@Controller
//@RestController
public class DataExportController {
	
	@Autowired
	private DataExportServiceFactory dataExportServiceFactory;
	
	private DataExportService dataExportService;
	
	@Autowired
	private ProviderEntity providerEntity;
	
	@Autowired
	private ProviderServiceImpl providerServiceImpl;
	
	public DataExportController() {
		
	}
	
	@RequestMapping(value = "/search")
	public ResponseEntity<String> getExportRequest(final HttpServletResponse response, @RequestParam String start,
	                                               String end, String provider, String formName, Model model)
	    throws ParseException {
		
		String reportName = null;
		dataExportService = dataExportServiceFactory.getDataExportServiceWithFormName(formName);
		Date startDate = DateUtil.parseDate(start);
		Date endDate = DateUtil.parseDate(end);
		List<Object[]> datas = dataExportService.getData(startDate, endDate, provider, formName);
		reportName = dataExportService.createCSVAndSave(datas, response, formName);
		return new ResponseEntity<String>(new Gson().toJson(reportName), HttpStatus.OK);
		
	}
	
	/*@RequestMapping(value = "/log", method = RequestMethod.GET)
	public HttpServletResponse getLogAsCSV(final HttpServletResponse response, @RequestParam String roleName)
	    throws IOException {
		System.err.println("welcome :" + roleName);
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
		return response;
	}
	*/
	
	@RequestMapping(value = "/export/list", method = RequestMethod.GET)
	public String dataExportGetList(Model model) {
		List<DataExportEntity> exports = providerServiceImpl.findAll("DataExportEntity");
		System.err.println("" + exports.toString());
		model.addAttribute("exports", exports);
		return "export/list";
	}
	
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public String dataExportGet(Model model) {
		model.addAttribute("formNames", FormName.values());
		
		List<ProviderEntity> providers = providerServiceImpl.findAll("ProviderEntity");
		model.addAttribute("providers", providers);
		
		return "export/exportForm";
	}
	
	/*@RequestMapping(value = "/export", method = RequestMethod.POST)
	public ModelAndView dataExportPost(@ModelAttribute("form") FormEntity form, ModelMap model, HttpServletResponse response) {
		System.err.println("dataExportServiceFactory;"
		        + dataExportServiceFactory.getDataExportServiceWithFormName(form.getFormName()).getData(null, null,
		            "provider"));
		
		dataExportService = dataExportServiceFactory.getDataExportServiceWithFormName(form.getFormName());
		List<Object[]> datas = dataExportService.getData(null, null, "provider");
		dataExportService.export(datas, response);
		System.err.println("form:" + form.getFormName() + "  Start:" + form.getStart());
		return new ModelAndView("redirect:/export");
	}*/
	
}
