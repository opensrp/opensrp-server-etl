package org.mcare.acl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mcare.acl.entity.Account;
import org.mcare.acl.service.DatabaseServiceImpl;
import org.mcare.acl.service.UserService;
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
	
	@Autowired
	private UserService userService;

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
		System.err.println("password: " + new StandardPasswordEncoder().encode("xyz"));

		model.addAttribute("account", new Account());
		return new ModelAndView("user/add", "command", account);
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("account") Account account, ModelMap model) {
		userService.registerNewUserAccount(account);
		return new ModelAndView("redirect:/user/login");
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

//	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
//	public String showRegistrationForm(WebRequest request, Model model) {
//		
//	    Account account = new Account();
//	    model.addAttribute("user", account);
//	    return "user/registration";
//	}
	
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("registration", "account", account);
	}

	
	
//	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
//	public ModelAndView submit(Account account) {
//		System.out.println("in submit method");
//		
//		service.registerNewUserAccount(account);
//	    
//	    
//		
//		// Do something with the submitted User
//		String url = "/household.html";
//		return new ModelAndView(new RedirectView(url));
//	}

	
//	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
//	public ModelAndView registerUserAccount(
//	  @ModelAttribute("user") Account account, 
//	  WebRequest request) {
//	     
//	    User registered = new User();
//
//	        registered = createUserAccount(account, result);
//
//	        return new ModelAndView("login", "account", account);
//	}
//
//	private User createUserAccount(Account account) {
//	    User registered = null;
//	    try {
//	        registered = service.registerNewUserAccount(account);
//	    } catch (EmailExistsException e) {
//	        return null;
//	    }
//	    return registered;
//	}
}
