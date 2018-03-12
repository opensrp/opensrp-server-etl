package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.ANCEntity;
import org.mcare.etl.entity.ActionEntity;
import org.mcare.etl.entity.MotherEntity;
import org.mcare.etl.service.ANCService;
import org.mcare.etl.service.MotherService;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MotherController {
	
	@Autowired
	private MotherService motherService;

	@Autowired
	private ANCService ancService;

	@Autowired
	private PaginationUtil paginationUtil;
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	private ProviderServiceImpl providerServiceImpl;
	
	public MotherController() {
		
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_MOTHER_LIST')")
	@RequestMapping(value = "/mother.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		Class<MotherEntity> entityClassName = MotherEntity.class;
		paginationUtil.createPagination(request, session, model, entityClassName);
		return "mother/index";
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_MOTHER')")
	@RequestMapping(value = "mother/{id}/view.html", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		MotherEntity household = motherService.findById(id);
		model.addAttribute("household", household);
		return "mother/view";
	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_MOTHER')")
	@RequestMapping(value = "mother/{id}/visits_completed.html", method = RequestMethod.GET)
	public String visits(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		MotherEntity mother = motherService.findById(id);
		session.setAttribute("mother", mother);

		List<ANCEntity> anclist = ancService.findAllCompletedANCVisits(mother.getCaseId());
		session.setAttribute("anclist", anclist);

		if (anclist != null && !anclist.isEmpty()) {
			return "mother/visits";
		} else {
			return "child/notfound";
		}
	}
}
