package org.opensrp.etl.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:application-etl-context.xml", "classpath:application-couchdb-context.xml" })
public class HouseholdServiceTest {
	
	@Autowired
	private ANCService ancService;
	
	@Test
	public void saveTest() {
		String caseId = "e599f590-4e10-408d-b3f3-ebdf4d3b69c3";
		//System.out.println("findByCaseIdTest: " + ancService.findByCaseId(caseId).toString());
	}
	
}
