/**
 * 
 */
package org.mcare.acl.controller;

import org.mcare.acl.entity.UserEntity;
import org.mcare.acl.service.DatabaseServiceImpl;
import org.mcare.acl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private UserEntity userEntity;
	
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
		return "home";
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public ModelAndView addUser(Model model) {
		model.addAttribute("name", "Tom from Home page");
		model.addAttribute("formatted", "<b>Home</b>");
		return new ModelAndView("user/add", "command", userEntity);
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("user") UserEntity userEntity, ModelMap model) {
		System.err.println("" + userEntity.getUsername());
		userEntity.setUsername(userEntity.getUsername());
		userEntity.setEnabled(true);
		
		userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
		userService.save(userEntity);
		return new ModelAndView("redirect:/user/add");
	}
}
