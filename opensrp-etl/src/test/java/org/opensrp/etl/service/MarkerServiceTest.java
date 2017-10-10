package org.opensrp.etl.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:application-etl-context.xml", "classpath:application-couchdb-context.xml" })
public class MarkerServiceTest {
	
	@Autowired
	private MarkerService markerService;
	
	@Test
	public void getCurrentTimeStampFromMarkerTest() {
		// TODO Auto-generated method stub
		//System.out.println("timeStamp:" + markerService.getCurrentTimeStampFromMarker());
		
	}
	
}
