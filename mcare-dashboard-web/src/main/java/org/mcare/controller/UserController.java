package org.mcare.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.mcare.acl.entity.Account;
import org.mcare.acl.entity.ActiveUser;
import org.mcare.acl.entity.ActiveUserStore;
import org.mcare.acl.entity.Permission;
import org.mcare.acl.entity.Role;
import org.mcare.acl.entity.UsageHistory;
import org.mcare.acl.service.impl.RoleServiceImpl;
import org.mcare.acl.service.impl.UsageHistoryServiceImpl;
import org.mcare.acl.service.impl.UserServiceImpl;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

/**
 * @author proshanto
 */

@Controller
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	private static final String ATTRIBUTE_PASSWORD_NOT_MATCH = "passwordNotMatch";
	
	private static final String ATTRIBUTE_UNIQUE_USER = "unique";
	
	private static final String MESSAGE_PASSWORD_NOT_MATCHED = "Password Does not match";
	
	private static final String MESSAGE_DUPLICATE_USER_NAME = "User name alreday taken";
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	@Autowired
	private Account account;
	
	@Autowired
	private Permission permission;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
    private UsageHistoryServiceImpl usageHistoryServiceImpl;
	
	@Autowired
    private ActiveUserStore activeUserStore;

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_USER')")
	@RequestMapping(value = "/user.html", method = RequestMethod.GET)
	public String userList(Model model) {
		List<Account> users = userServiceImpl.findAll("Account");
		logger.debug("users list size: " + users.size());
		model.addAttribute("users", users);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "user/index";
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_USER')")
	@RequestMapping(value = "/user/add.html", method = RequestMethod.GET)
	public ModelAndView saveUser(Model model, HttpSession session) {
		int[] selectedRoles = null;
		model.addAttribute("account", new Account());
		setSelectedRolesAttributes(selectedRoles, session);
		return new ModelAndView("user/add", "command", account);
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_WRITE_USER')")
	@RequestMapping(value = "/user/add.html", method = RequestMethod.POST)
	public ModelAndView saveUser(@RequestParam(value = "roles", required = false) int[] roles,
	                             @Valid @ModelAttribute("account") Account account, BindingResult binding, ModelMap model,
	                             HttpSession session) {
		if (checkValidations(account, roles, session, model)) {
			return new ModelAndView("redirect:/user.html");
		} else {
			return new ModelAndView("/user/add");
		}
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_UPDATE_USER')")
	@RequestMapping(value = "/user/{id}/edit.html", method = RequestMethod.GET)
	public ModelAndView editUser(Model model, HttpSession session, @PathVariable("id") int id) {
		Account account = findAccountById(id);
		model.addAttribute("account", account);
		model.addAttribute("id", id);
		setSelectedRolesAttributes(getSelectedRoles(account), session);
		return new ModelAndView("user/edit", "command", account);
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_UPDATE_USER')")
	@RequestMapping(value = "/user/{id}/edit.html", method = RequestMethod.POST)
	public ModelAndView editUser(@RequestParam(value = "roles", required = false) int[] roles,
	                             @Valid @ModelAttribute("account") Account account, BindingResult binding, ModelMap model,
	                             HttpSession session, @PathVariable("id") int id) {
		account.setRoles(userServiceImpl.setRoles(roles));
		account.setId(id);
		account.setEnabled(true);
		userServiceImpl.update(account);
		return new ModelAndView("redirect:/user.html");
		
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_UPDATE_PASSWORD')")
	@RequestMapping(value = "/user/{id}/password.html", method = RequestMethod.GET)
	public ModelAndView editPassword(Model model, HttpSession session, @PathVariable("id") int id) {
		Account account = findAccountById(id);
		model.addAttribute("account", account);
		return new ModelAndView("user/password", "command", account);
	}
	
	@PostAuthorize("hasPermission(returnObject, 'PERM_UPDATE_PASSWORD')")
	@RequestMapping(value = "/user/{id}/password.html", method = RequestMethod.POST)
	public ModelAndView editPassword(@Valid @ModelAttribute("account") Account account, BindingResult binding,
	                                 ModelMap model, HttpSession session, @PathVariable("id") int id) {
		Account gettingAccount = findAccountById(id);
		if (userServiceImpl.isPasswordMatched(account)) {
			account.setId(id);
			account.setEnabled(true);
			account.setPassword(passwordEncoder.encode(account.getPassword()));
			account.setRoles(gettingAccount.getRoles());
			userServiceImpl.update(account);
		} else {
			setPasswordNotMatchedAttribute(model);
			return new ModelAndView("user/password", "command", gettingAccount);
		}
		return new ModelAndView("redirect:/user.html");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
	    System.out.println("login");
	    
		return "user/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        logger.info("log out time:" + dateFormat.format(date) + ", auth: " + auth.hashCode());
        
        //UsageHistory usageHistory = usageHistoryServiceImpl.findByKey(auth.getName(), "userName", UsageHistory.class);
        UsageHistory usageHistory = new UsageHistory();
        ActiveUser activeUser = activeUserStore.getActiveUserByUsername(auth.getName());
        
        usageHistory.setUserName(activeUser.getUserName());
        usageHistory.setLoginTime(activeUser.getLoginTime());
        usageHistory.setLoginDate(activeUser.getLoginDate());
        
        logger.info("activeUser.getUserName():" + activeUser.getUserName());
        
        long difference = date.getTime() - activeUser.getLoginTime().getTime();
        difference = difference/(1000 * 60);
        
        System.out.println("duration: " + difference);
        
        usageHistory.setDuration((int)difference);
        usageHistory.setDay(activeUser.getDay());
        usageHistory.setLogoutTime(date);
        
        
        try {
            usageHistoryServiceImpl.save(usageHistory);
            activeUserStore.getUsers().remove(activeUser);
            System.out.println("active users: " + activeUserStore.getUsers().size());
        } catch (Exception e) {
            e.printStackTrace();
        }

		return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	private boolean checkValidations(Account account, int[] roles, HttpSession session, ModelMap model) {
		try {
			if (userServiceImpl.isPasswordMatched(account) && !userServiceImpl.isUserAlreadyExist(account)) {
				account.setEnabled(true);
				account.setPassword(passwordEncoder.encode(account.getPassword()));
				account.setRoles(userServiceImpl.setRoles(roles));
				userServiceImpl.save(account);
				return true;
			} else {
				setSelectedRolesAttributes(roles, session);
				if (!userServiceImpl.isPasswordMatched(account) && userServiceImpl.isUserAlreadyExist(account)) {
					setPasswordNotMatchedAttribute(model);
					setUniqueUserAttribute(model);
				} else if (userServiceImpl.isUserAlreadyExist(account)) {
					setUniqueUserAttribute(model);
				} else {
					setPasswordNotMatchedAttribute(model);
				}
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}
	}
	
	private int[] getSelectedRoles(Account account) {
		int[] selectedRoles = new int[200];
		Set<Role> getRoles = account.getRoles();
		int i = 0;
		for (Role role : getRoles) {
			selectedRoles[i] = role.getId();
			i++;
		}
		return selectedRoles;
	}
	
	private Account findAccountById(int id) {
		Account account = userServiceImpl.findById(id, "id", Account.class);
		return account;
	}
	
	private void setPasswordNotMatchedAttribute(ModelMap model) {
		model.addAttribute(ATTRIBUTE_PASSWORD_NOT_MATCH, MESSAGE_PASSWORD_NOT_MATCHED);
	}
	
	private void setUniqueUserAttribute(ModelMap model) {
		model.addAttribute(ATTRIBUTE_UNIQUE_USER, MESSAGE_DUPLICATE_USER_NAME);
	}
	
	private void setSelectedRolesAttributes(int[] roles, HttpSession session) {
		session.setAttribute("roles", databaseServiceImpl.findAll("Role"));
		session.setAttribute("selectedRoles", roles);
	}
}
