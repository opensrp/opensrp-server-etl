package org.opensrp.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MisReportController {
	
	@RequestMapping("/misreport")
	public String getAllMisReport() {
		
		System.out.println("calling mis report services");
		return null;
	}

}
