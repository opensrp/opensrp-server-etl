package org.mcare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.mcare.acl.entity.Account;
import org.mcare.acl.entity.Permission;
import org.mcare.acl.service.impl.UserServiceImpl;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author proshanto
 */

@Controller
public class UserController {
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	@Autowired
	private Account account;
	
	@Autowired
	private Permission permission;
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/")
	public String showView(Model model) {
		
		/*Class<UserEntity> className = UserEntity.class;
		userEntity.setName("user");
		databaseServiceImpl.save(userEntity);
		List<UserEntity> users = databaseServiceImpl.findAll(userEntity, "UserEntity");
		for (UserEntity userEntity : users) {
			System.err.println("" + userEntity.getName());
		}

		UserEntity user = databaseServiceImpl.findById(1, "id", className);
		System.err.println("UserName:::" + user.getName());
		model.addAttribute("name", "Tom");
		model.addAttribute("formatted", "<b>blue</b>");*/
		return "user/home";
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public ModelAndView getUser(Model model) {
		
		model.addAttribute("account", new Account());
		return new ModelAndView("user/add", "command", account);
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("account") Account account, BindingResult binding, ModelMap model) {
		if (binding.hasErrors()) {
			System.out.println("error in validation");
			return new ModelAndView("/user/add");
		} else {
			userService.registerNewUserAccount(account);
			System.out.println("password match: " + userService.isValid(account));
			return new ModelAndView("redirect:/login");
		}
	}
	
	@RequestMapping(value = "user/permission", method = RequestMethod.GET)
	public ModelAndView getPermission(Model model) {
		model.addAttribute("permission", new Permission());
		return new ModelAndView("user/permission", "command", permission);
	}
	
	@RequestMapping(value = "/user/permission", method = RequestMethod.POST)
	public ModelAndView addPermission(@ModelAttribute("permission") @Valid Permission permission, BindingResult binding,
	                                  ModelMap model) {
		userService.managePermissions(permission);
		return new ModelAndView("redirect:/user/permission");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "user/login";
	}
	
	@RequestMapping(value = "/user/administration", method = RequestMethod.GET)
	public String administrationPage() {
		return "user/administration";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
