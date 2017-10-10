package org.opensrp.etl.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opensrp.etl.entity.ActionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:application-etl-context.xml", "classpath:application-couchdb-context.xml" })
public class ActionServiceTest {
	
	@Autowired
	private ActionService actionService;
	
	@Autowired
	private ActionEntity actionEntity;
	
	@Test
	public void findByCaseIdTest() {
		/*System.out.println(
		    "findByCaseIdTest: " + actionService.findByCaseId("cdb1db77-010d-42c6-a785-d3c0d2ad9017").toString());*/
	}
	
}
