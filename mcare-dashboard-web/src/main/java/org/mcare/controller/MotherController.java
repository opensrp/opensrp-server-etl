package org.mcare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.common.util.PaginationHelperUtil;
import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.MotherEntity;
import org.mcare.etl.service.HouseholdService;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MotherController {
	
	@Autowired
	private HouseholdService householdService;
	
	@Autowired
	private PaginationUtil paginationUtil;
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	private ProviderServiceImpl providerServiceImpl;
	
	@Autowired
	private SearchBuilder searchBuilder;
	
	@Autowired
	private PaginationHelperUtil paginationHelperUtil;
	
	public MotherController() {
		
	}
	
	@RequestMapping(value = "/mother.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		String search = "";
		search = (String) request.getParameter("search");
		if (search != null) {
			searchBuilder = paginationHelperUtil.setParams(request, session);
			
		} else {
			searchBuilder = searchBuilder.clear();
		}
		PaginationHelperUtil.getPaginationLink(request, session);
		Class<MotherEntity> entityClassName = MotherEntity.class;
		paginationUtil.pagination(request, session, searchBuilder, entityClassName, model);
		return "mother/index";
	}
	
	/*@RequestMapping(value = "/{id}/view.html", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		
		HouseholdEntity household = householdService.findById(id);
		System.err.println("" + household.getDivision());
		model.addAttribute("household", household);
		return "household/view";
		
	}*/
}
