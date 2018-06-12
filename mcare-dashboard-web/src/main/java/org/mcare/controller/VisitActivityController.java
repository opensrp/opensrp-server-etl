package org.mcare.controller;

import org.apache.log4j.Logger;
import org.mcare.api.VisitActivityApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/rest/api")
public class VisitActivityController {
	
	private static final Logger logger = Logger.getLogger(VisitActivityController.class);
	
	@Autowired
	private VisitActivityApiService visitActivityApiService;
	
	@RequestMapping(headers = { "Accept=application/json" }, value = "/psrf", method = RequestMethod.GET)
	public ResponseEntity<String> getRequestForPSRFVisitActivity(@RequestParam String caseid) {
		logger.info("get request for mother at case id:" + caseid);
		try {
			visitActivityApiService.doPSRFVisitActivities(caseid);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new Gson().toJson(""), HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ResponseEntity<>(new Gson().toJson(caseid), HttpStatus.OK);
	}
	
	@RequestMapping(headers = { "Accept=application/json" }, value = "/bnf", method = RequestMethod.GET)
	public ResponseEntity<String> getRequestForBNFVisitActivity(@RequestParam String caseid, @RequestParam String visitCode) {
		logger.info("get request for child at relationalid:" + caseid);
		try {
			visitActivityApiService.doBNFVisitActivities(caseid, visitCode);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new Gson().toJson(""), HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>(new Gson().toJson(caseid), HttpStatus.OK);
	}
	
}
