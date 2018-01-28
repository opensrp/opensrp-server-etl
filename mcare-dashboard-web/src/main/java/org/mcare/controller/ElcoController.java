package org.mcare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.service.ProviderServiceImpl;
import org.mcare.common.util.PaginationHelperUtil;
import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.ElcoEntity;
import org.mcare.etl.service.HouseholdService;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ElcoController {
	
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
	
	public ElcoController() {
		
	}
	
	@RequestMapping(value = "/elco.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		String search = "";
		search = (String) request.getParameter("search");
		if (search != null) {
			searchBuilder = paginationHelperUtil.setParams(request, session);
			
		} else {
			searchBuilder = searchBuilder.clear();
		}
		PaginationHelperUtil.getPaginationLink(request, session);
		Class<ElcoEntity> entityClassName = ElcoEntity.class;
		paginationUtil.pagination(request, session, searchBuilder, entityClassName, model);
		return "elco/index";
	}
	
	/*@RequestMapping(value = "/{id}/view.html", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		
		HouseholdEntity household = householdService.findById(id);
		System.err.println("" + household.getDivision());
		model.addAttribute("household", household);
		return "household/view";
		
	}*/
}
