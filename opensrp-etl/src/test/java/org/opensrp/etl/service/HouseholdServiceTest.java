package org.opensrp.etl.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opensrp.etl.entity.HouseholdEntity;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:application-etl-context.xml", "classpath:application-couchdb-context.xml" })
public class HouseholdServiceTest {
	
	@Autowired
	private ANCService ancService;
	@Autowired
	private HouseholdService householdService;
	@Test
	public void saveTest() throws ParseException {
		String caseId = "e599f590-4e10-408d-b3f3-ebdf4d3b69c3";
		//System.out.println("findByCaseIdTest: " + ancService.findByCaseId(caseId).toString());
		HouseholdEntity he= new HouseholdEntity();
		he.setCaseId("Cwaseer");
		String today="1998-12-29 40:00:00";  
		String start="1998-12-29 23:37:50";
		he.setToday(DateUtil.getDateFromString(today));
		he.setStart(DateUtil.getDateTimeFromString(start));
	
		householdService.save(he);
	}
	
}
