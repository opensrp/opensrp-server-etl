package org.opensrp.etl.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opensrp.etl.entity.MarkerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:application-etl-context.xml", "classpath:application-couchdb-context.xml" })
public class MarkerServiceTest {
	
	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private MarkerEntity markerEntity;
	
	public void updateTest() {
		
		markerEntity = markerService.findById(4);
		markerService.delete(markerEntity);
		
	}
	
	@Test
	public void getCurrentTimeStampFromMarkerTest() {
		// TODO Auto-generated method stub
		System.out.println("timeStamp:" + markerService.getCurrentTimeStampFromMarker());
		
	}
	
}
