/**
 * 
 */
package org.opensrp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sohel
 */
@Controller
public class HomeController {
	
	@ResponseBody
	@RequestMapping("/")
	public String showHome(Model model) {
		return "OpenSRP ETL!!";
	}
}
