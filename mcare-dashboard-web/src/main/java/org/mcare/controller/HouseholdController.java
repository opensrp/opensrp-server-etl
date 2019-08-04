package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.common.util.ControllerUtil;
import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.etl.service.HouseholdService;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HouseholdController {

	private static final String HOUSEHOLD = "Household";

	private static final String HOUSEHOLD_HTML = "household.html";

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

	public HouseholdController() {

	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_HOUSEHOLD_LIST')")
	@RequestMapping(value = "/household.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		ControllerUtil.setSessionAttributes(session, HOUSEHOLD_HTML, HOUSEHOLD);
		Class<HouseholdEntity> entityClassName = HouseholdEntity.class;
		paginationUtil.createPagination(request, session, entityClassName);
		return "household/index";
	}

	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String getChildLocationList(HttpServletRequest request, HttpSession session, Model model, @RequestParam int id) {
		List<Object[]> parentData = locationServiceImpl.getChildData(id);
		session.setAttribute("data", parentData);
		return "household/location";
	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_HOUSEHOLD')")
	@RequestMapping(value = "household/{id}/view.html", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {

		HouseholdEntity household = householdService.findById(id);
		model.addAttribute("household", household);
		session.setAttribute("title", "Household Details");
		return "household/view";
	}

//	@RequestMapping(value = "location/provider", method = RequestMethod.GET)
//	public String getProviderByLocation() {
//		return
//	}
}
