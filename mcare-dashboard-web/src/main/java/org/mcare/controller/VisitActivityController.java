package org.mcare.controller;

import org.mcare.api.VisitActivityApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")
public class VisitActivityController {
	
	@Autowired
	private VisitActivityApiService visitActivityApiService;
	
	@RequestMapping(value = "/psrf", method = RequestMethod.GET)
	public void postRequestForPSRFVisitActivity(@RequestParam String caseid) {
		System.err.println("aseId:" + caseid);
		visitActivityApiService.doPSRFVisitActivities(caseid);
	}
	
	@RequestMapping(value = "/bnf", method = RequestMethod.GET)
	public void postRequestForBNFVisitActivity(@RequestParam String caseid, @RequestParam String visitCode) {
		visitActivityApiService.doBNFVisitActivities(caseid, visitCode);
	}
	
}
