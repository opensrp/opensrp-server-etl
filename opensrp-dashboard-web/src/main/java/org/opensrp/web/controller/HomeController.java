/**
 * 
 */
package org.opensrp.web.controller;

import org.opensrp.report.service.DemoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sohel
 */
@Controller
public class HomeController {
	
	@Autowired
	private DemoTest demoTest;
	
	@RequestMapping("/")
	public String showHome(Model model) {
		demoTest.setName("OpenSRP ETL!!");
		return "home";
	}
}
