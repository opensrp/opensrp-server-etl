/**
 * 
 */
package org.mcare.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mcare.acl.entity.ProviderEntity;
import org.mcare.acl.service.ProviderServiceImpl;
import org.mcare.common.util.DateUtil;
import org.mcare.common.util.FormName;
import org.mcare.data.export.entity.DataExportEntity;
import org.mcare.data.export.service.DataExportService;
import org.mcare.data.export.service.impl.DataExportServiceFactory;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.etl.service.HouseholdService;
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
	
	@Autowired
	private HouseholdService householdService;
	
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/household.html", method = RequestMethod.GET)
	public String lisst(HttpServletRequest request, HttpSession session) {
		System.err.println("start:" + System.currentTimeMillis());
		
		String offset = (String) request.getParameter("offSet");
		// result is number of record displayed on each page
		int result = 10;
		// size is the total number of record present in DB
		int size;
		Class<HouseholdEntity> entityClassName = HouseholdEntity.class;
		List<Integer> pageList = new ArrayList<Integer>();
		List<HouseholdEntity> data;
		/*in the beginning we set page number zero
		*/if (offset != null) {
			int offsetreal = Integer.parseInt(offset);
			offsetreal = offsetreal * 10;
			data = householdService.list(result, offsetreal, entityClassName);
			if (session.getAttribute("size") == null) {
				size = householdService.count();
				session.setAttribute("size", size / 10);
			}
			
		} else {
			data = householdService.list(result, 0, entityClassName);
			size = householdService.count();
			/*if total record are divisible by 10 then we set page list 
			 * size one less than total size to avoid empty last page i.e if total record are 1220 then page list
			 *  size will be 121 because here we are taking page list size from 0-121 which is 122 pages*/
			if ((size % result) == 0) {
				session.setAttribute("size", (size / 10) - 1);
			} else {
				session.setAttribute("size", size / 10);
			}
		}
		
		/*when user click on any page number then this part will be executed. 
		 * else part will be executed on load i.e first time on page*/
		System.err.println("Size:" + session.getAttribute("size"));
		if (offset != null) {
			int listsize = Integer.parseInt(session.getAttribute("size").toString());
			if (Integer.parseInt(offset) < 6) {
				if (listsize >= 10) {
					for (int i = 1; i <= 9; i++) {
						pageList.add(i);
					}
				} else {
					for (int i = 1; i <= listsize; i++) {
						pageList.add(i);
					}
				}
				
			} else {
				if (listsize >= 10 && Integer.parseInt(offset) - 5 > 0) {
					List<Integer> temp = new ArrayList<Integer>();
					for (int i = Integer.parseInt(offset); i > Integer.parseInt(offset) - 5; i--) {
						temp.add(i);
					}
					for (int i = temp.size() - 1; i >= 0; i--) {
						pageList.add(temp.get(i));
					}
				}
				if (listsize >= 10 && Integer.parseInt(offset) + 5 < listsize) {
					for (int i = Integer.parseInt(offset) + 1; i < Integer.parseInt(offset) + 5; i++) {
						pageList.add(i);
					}
				} else if (listsize >= 10) {
					for (int i = Integer.parseInt(offset) + 1; i < listsize; i++) {
						pageList.add(i);
					}
				}
			}
		} else {
			int listsize = Integer.parseInt(session.getAttribute("size").toString());
			if (listsize >= 10) {
				for (int i = 1; i <= 10; i++) {
					pageList.add(i);
				}
			} else {
				for (int i = 1; i <= listsize; i++) {
					pageList.add(i);
				}
			}
		}
		session.setAttribute("pageList", pageList);
		session.setAttribute("productList", data);
		
		return "household/index";
	}
}
