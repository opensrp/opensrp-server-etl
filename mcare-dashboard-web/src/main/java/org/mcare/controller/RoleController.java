package org.mcare.controller;

import javax.validation.Valid;

import org.mcare.acl.entity.Permission;
import org.mcare.acl.entity.Role;
import org.mcare.acl.service.impl.PermissionServiceImpl;
import org.mcare.acl.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleController {
	
	@Autowired
	private Permission permission;
	
	@Autowired
	private PermissionServiceImpl permissionService;
	
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	@Autowired
	private Role role;
	
	@RequestMapping(value = "role/add", method = RequestMethod.GET)
	public ModelAndView getRole(Model model) {
		
		model.addAttribute("role", new Role());
		model.addAttribute("permissions", permissionService.findAll("Permission"));
		return new ModelAndView("role/add", "command", role);
	}
	
	@RequestMapping(value = "/role/add", method = RequestMethod.POST)
	public ModelAndView addRole(@RequestParam(value = "permissions", required = false) int[] permissions,
	                            @ModelAttribute("role") @Valid Role role, BindingResult binding, ModelMap model) {
		
		role.setPermissions(roleServiceImpl.serPermissions(permissions));
		roleServiceImpl.save(role);
		return new ModelAndView("redirect:/role/add");
	}
	
}
