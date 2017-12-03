package org.mpower.etl.service;

import java.text.ParseException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.etl.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:couchdb-connection-context.xml", 
	"classpath:etl-bean-context.xml", 
	"classpath:hibernate-hbm.xml", 
	"classpath:listener-context.xml", 
	"classpath:mvc-context.xml" })
public class HouseholdServiceTest {
	
	@Autowired
	private HouseholdService householdService;
	

	@Test
	public void saveTest() throws ParseException {
		String caseId = "e599f590-4e10-408d-b3f3-ebdf4d3b69c3";
		HouseholdEntity he = new HouseholdEntity();
		he = householdService.findByCaseId(caseId);
		System.out.println(he.toString());
		householdService.update(he);
/*		HouseholdEntity he = new HouseholdEntity();
		he.setCaseId(caseId
		householdService.save(he);*/
	}
	
}
