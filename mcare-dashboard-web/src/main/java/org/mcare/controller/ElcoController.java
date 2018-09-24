package org.mcare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.common.util.ControllerUtil;
import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.ElcoEntity;
import org.mcare.etl.service.ElcoService;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ElcoController {
	
	private static final String ELCO = "Elco";

	private static final String ELCO_HTML = "elco.html";

	@Autowired
	private ElcoService elcoService;
	
	@Autowired
	private PaginationUtil paginationUtil;
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	private ProviderServiceImpl providerServiceImpl;
	
	@Autowired
	private SearchBuilder searchBuilder;

	public ElcoController() {
		
	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_ELCO_LIST')")
	@RequestMapping(value = "/elco.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		ControllerUtil.setSessionAttributes(session, ELCO_HTML, ELCO);
		Class<ElcoEntity> entityClassName = ElcoEntity.class;
		paginationUtil.createPagination(request, session, entityClassName);
		return "elco/index";
	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_ELCO')")
	@RequestMapping(value = "elco/{id}/view.html", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		ElcoEntity elco = elcoService.findById(id);
		session.setAttribute("title", "Elco Details");
		model.addAttribute("household", elco);
		return "elco/view";
	}
}