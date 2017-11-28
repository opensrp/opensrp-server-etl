/**
 * 
 */
package com.proshanto.spring.controller;

import org.mcare.acl.service.DatabaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author proshanto
 */
@Controller
public class HomeController {
	
	@Autowired
	private DatabaseServiceImpl userService;
	@RequestMapping("/")
	public String showview(Model model) {
		userService.test();
		model.addAttribute("name", "Tom");
		model.addAttribute("formatted", "<b>blue</b>");
		return "index";
	}
	
	@RequestMapping("/example")
	public String showHome(Model model) {
		model.addAttribute("name", "Tom from Home page");
		model.addAttribute("formatted", "<b>Home</b>");
		return "index";
	}
	
}
