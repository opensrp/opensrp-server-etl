package org.opensrp.web.controller;

import java.util.ArrayList;

import org.opensrp.etl.report.FamilyPlanningReport;
import org.opensrp.etl.report.MIS1Report;
import org.opensrp.etl.repository.PSRFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MisReportController {
	
	@Autowired
	private PSRFRepository psrfRepository;

	@RequestMapping("/misreport")
	public String getAllMisReport() {
		
		System.out.println("calling mis report services");
		//JSONObject doc = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");

		MISReport mis = new MISReport();
		mis.setFc("1");
		mis.setFp("2");
		System.out.println("misreport:" + mis.toString());
		return mis.toString();
	}

	@ResponseBody
	@RequestMapping("/misreport/familyplanning")
	public MIS1Report getMIS1Report() {
		FamilyPlanningReport fpr = new FamilyPlanningReport();
		fpr.setNewPillUsages(psrfRepository.calculateBirthControlMethodUsages(1));
		fpr.setOldCondomUsages(psrfRepository.calculateBirthControlMethodUsages(5));
		MIS1Report mr = new MIS1Report();
		mr.setFamilyPlanningReport(fpr);
//		ArrayList<FamilyPlanningReport> arList = new ArrayList<FamilyPlanningReport>();
//		arList.add(fpr);
		return mr;
	}
}