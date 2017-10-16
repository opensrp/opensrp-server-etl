/**
 * 
 */
package org.opensrp.web.controller;

import org.opensrp.etl.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author proshanto
 */
@Controller
@RequestMapping("/household")
public class HouseholdController {
	
	@Autowired
	private HouseholdService householdService;
	
	public String list(Model model) {
		
		model.addAttribute("name", "Tom");
		return "/benificiary/household/list";
		
	}
}
