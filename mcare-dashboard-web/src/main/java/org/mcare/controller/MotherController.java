package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.common.util.ControllerUtil;
import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.ANCEntity;
import org.mcare.etl.entity.ActionEntity;
import org.mcare.etl.entity.BNFEntity;
import org.mcare.etl.entity.MotherEntity;
import org.mcare.etl.entity.PNCEntity;
import org.mcare.etl.service.ANCService;
import org.mcare.etl.service.ActionService;
import org.mcare.etl.service.BNFService;
import org.mcare.etl.service.MotherService;
import org.mcare.etl.service.PNCService;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.reports.MotherReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MotherController {

	private static final String MOTHER = "Mother";

	private static final String MOTHER_HTML = "mother.html";

	@Autowired
	private MotherService motherService;

	@Autowired
	private ANCService ancService;

	@Autowired
	private ActionService actionService;

	@Autowired
	private BNFService bnfService;

	@Autowired
	private PNCService pncService;

	@Autowired
	private PaginationUtil paginationUtil;

	@Autowired
	private LocationServiceImpl locationServiceImpl;

	@Autowired
	private ProviderServiceImpl providerServiceImpl;

	@Autowired
	private MotherReport motherReport;

	public MotherController() {

	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_MOTHER_LIST')")
	@RequestMapping(value = "/mother.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		ControllerUtil.setSessionAttributes(session, MOTHER_HTML, MOTHER);
		Class<MotherEntity> entityClassName = MotherEntity.class;
		paginationUtil.createPagination(request, session, entityClassName);

		//createDetails(session);

		return "mother/index";
	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_MOTHER')")
	@RequestMapping(value = "mother/{id}/view.html", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		MotherEntity household = motherService.findById(id);
		model.addAttribute("household", household);
		session.setAttribute("title", "Mother Details");
		return "mother/view";
	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_MOTHER')")
	@RequestMapping(value = "mother/{id}/visits_pending.html", method = RequestMethod.GET)
	public String visitsPending(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		MotherEntity mother = motherService.findById(id);
		session.setAttribute("mother", mother);
		session.setAttribute("title", "Pending Visits");

		List<ANCEntity> anclist = ancService.findAllByKey(mother.getCaseId());
		List<PNCEntity> pnclist = pncService.findAllByKey(mother.getCaseId());

		List<BNFEntity> bnflist = bnfService.findAllByKey(mother.getCaseId());

		List<ActionEntity> actionlist = actionService.findAllPendingMotherVisits(mother.getCaseId(), anclist
				, pnclist, bnflist);

		session.setAttribute("actionlist", actionlist);

		if (actionlist != null && !actionlist.isEmpty()) {
			return "mother/visits_pending";
		} else {
			return "/notfound";
		}
	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_MOTHER')")
	@RequestMapping(value = "mother/{id}/visits_completed.html", method = RequestMethod.GET)
	public String visitsCompleted(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		MotherEntity mother = motherService.findById(id);
		session.setAttribute("mother", mother);

		List<ANCEntity> anclist = ancService.findAllByKey(mother.getCaseId());
		List<BNFEntity> bnflist = bnfService.findAllByKey(mother.getCaseId());
		List<PNCEntity> pnclist = pncService.findAllByKey(mother.getCaseId());

		session.setAttribute("anclist", anclist);
		session.setAttribute("bnflist", bnflist);
		session.setAttribute("pnclist", pnclist);
		session.setAttribute("title", "Completed Visits");

		if (anclist != null && !anclist.isEmpty()) {
			return "mother/visits_completed";
		} else {
			return "/notfound";
		}
	}


	@RequestMapping(value = "/report.html", method = RequestMethod.GET)
	public String showReport(HttpServletRequest request, HttpSession session, Model model) {
		motherReport.createReport();
		return "mother/report";
	}

}
