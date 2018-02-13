package org.mcare.acl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mcare.acl.entity.Account;
import org.mcare.acl.service.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author proshanto
 */

@Controller
public class AclController {
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	@Autowired
	private Account account;
	
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
	public ModelAndView addUser(Model model) {
		model.addAttribute("name", "Tom from Home page");
		model.addAttribute("formatted", "<b>Home</b>");
		return new ModelAndView("user/add", "command", account);
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("user") Account account, ModelMap model) {
		System.err.println("" + account.getUsername());
		account.setUsername(account.getUsername());
		account.setEnabled(true);
		
		account.setPassword(account.getPassword());
		//userService.save(userEntity);
		return new ModelAndView("redirect:/user/add");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "user/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		System.err.println(new StandardPasswordEncoder().encode("admin"));
	    Account account = new Account();
	    model.addAttribute("user", account);
	    return "registration";
	}
}
