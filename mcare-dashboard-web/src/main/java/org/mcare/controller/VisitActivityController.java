package org.mcare.controller;

import org.mcare.api.VisitActivityApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")
public class VisitActivityController {
	
	@Autowired
	private VisitActivityApiService visitActivityApiService;
	
	@RequestMapping(value = "/psrf", method = RequestMethod.POST)
	public void postRequestForPSRFVisitActivity(@PathVariable("caseid") String caseId) {
		visitActivityApiService.doPSRFVisitActivities(caseId);
	}
	
	@RequestMapping(value = "/bnf", method = RequestMethod.POST)
	public void postRequestForBNFVisitActivity(@PathVariable("caseid") String caseid,
	                                           @PathVariable("visitcode") String visitCode, @RequestBody String caseId) {
		visitActivityApiService.doBNFVisitActivities(caseId, visitCode);
	}
	
}
