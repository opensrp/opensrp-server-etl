package org.unicef.etl.transmission.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.unicef.etl.entity.MarkerEntity;
import org.unicef.etl.service.MarkerService;
import org.unicef.etl.util.CommonConstant;

@Component
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private MarkerEntity markerEntity;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println(
		    CommonConstant.UNICEF.name() + "Application Stating............" + event.getApplicationContext().getId());
		markerEntity = markerService.findByName(CommonConstant.UNICEF.name());
		if (markerEntity == null) {
			MarkerEntity markerEntityUnicef = new MarkerEntity();
			markerEntityUnicef.setName(CommonConstant.UNICEF.name());
			markerEntityUnicef.setTimeStamp(0);
			markerService.save(markerEntityUnicef);
		}
		
		markerEntity = markerService.findByName(CommonConstant.ACTIONS.name());
		if (markerEntity == null) {
			MarkerEntity markerEntityActions = new MarkerEntity();
			markerEntityActions.setName(CommonConstant.ACTIONS.name());
			markerEntityActions.setTimeStamp(0);
			markerService.save(markerEntityActions);
		}
	}
	
}
