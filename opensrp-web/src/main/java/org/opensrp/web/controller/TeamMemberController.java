/**
 * @author proshanto
 * */

package org.opensrp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONException;
import org.opensrp.acl.entity.TeamMember;
import org.opensrp.acl.service.impl.LocationServiceImpl;
import org.opensrp.acl.service.impl.TeamMemberServiceImpl;
import org.opensrp.web.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "team/teammember")
@Controller
public class TeamMemberController {
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	private TeamMemberServiceImpl teamMemberServiceImpl;
	
	@Autowired
	private TeamMember teamMember;
	
	@Autowired
	private PaginationUtil paginationUtil;
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_ROLE')")
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public String locationList(HttpServletRequest request, HttpSession session, Model model) {
		Class<TeamMember> entityClassName = TeamMember.class;
		paginationUtil.createPagination(request, session, entityClassName);
		return "team-member/index";
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public ModelAndView saveLocation(ModelMap model, HttpSession session) throws JSONException {
		model.addAttribute("teamMember", new TeamMember());
		String locationName = "";
		
		session.setAttribute("locationList", locationServiceImpl.list().toString());
		teamMemberServiceImpl.setSessionAttribute(session, teamMember, locationName);
		return new ModelAndView("team-member/add", "command", teamMember);
		
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "/add.html", method = RequestMethod.POST)
	public ModelAndView saveLocation(@RequestParam(value = "person", required = false) int personId,
	                                 @RequestParam(value = "personName") String personName,
	                                 @RequestParam(value = "team") int teamId,
	                                 @RequestParam(value = "locationList[]", required = false) int[] locations,
	                                 @ModelAttribute("teamMember") @Valid TeamMember teamMember, BindingResult binding,
	                                 ModelMap model, HttpSession session) throws Exception {
		teamMember = teamMemberServiceImpl.setCreatorLocationAndPersonAndTeamAttributeInLocation(teamMember, personId,
		    teamId, locations);
		
		if (!teamMemberServiceImpl.isPersonAndIdentifierExists(model, teamMember)) {
			//teamMemberServiceImpl.save(teamMember);
			System.err.println("okk");
			
		} else {
			teamMemberServiceImpl.setSessionAttribute(session, teamMember, personName);
			return new ModelAndView("/team-member/add");
		}
		
		return new ModelAndView("redirect:/team/teammember/list.html");
		
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "/{id}/edit.html", method = RequestMethod.GET)
	public ModelAndView editLocation(ModelMap model, HttpSession session, @PathVariable("id") int id) {
		TeamMember teamMember = teamMemberServiceImpl.findById(id, "id", TeamMember.class);
		model.addAttribute("id", id);
		model.addAttribute("teamMember", teamMember);
		//String locationName = locationServiceImpl.makeLocationName(team.getLocation());
		String personName = teamMember.getPerson().getUsername();
		teamMemberServiceImpl.setSessionAttribute(session, teamMember, personName);
		return new ModelAndView("team-member/edit", "command", teamMember);
		
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_ROLE')")
	@RequestMapping(value = "/{id}/edit.html", method = RequestMethod.POST)
	public ModelAndView editLocation(@RequestParam(value = "person", required = false) int personId,
	                                 @RequestParam(value = "personName") String personName,
	                                 @RequestParam(value = "team") int teamId,
	                                 @RequestParam(value = "locationList[]", required = false) int[] locations,
	                                 @ModelAttribute("team") @Valid TeamMember teamMember, BindingResult binding,
	                                 ModelMap model, HttpSession session, @PathVariable("id") int id) throws Exception {
		teamMember.setId(id);
		teamMember = teamMemberServiceImpl.setCreatorLocationAndPersonAndTeamAttributeInLocation(teamMember, personId,
		    teamId, locations);
		if (!teamMemberServiceImpl.isPersonAndIdentifierExists(model, teamMember)) {
			
			teamMemberServiceImpl.update(teamMember);
			
		} else {
			
			teamMemberServiceImpl.setSessionAttribute(session, teamMember, personName);
			return new ModelAndView("/team-member/edit");
		}
		
		return new ModelAndView("redirect:/team/teammember/list.html");
		
	}
}
