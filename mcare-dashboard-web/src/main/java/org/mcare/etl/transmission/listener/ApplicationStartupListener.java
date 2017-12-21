package org.mcare.etl.transmission.listener;

import java.util.List;

import org.mcare.etl.entity.MarkerEntity;
import org.mcare.etl.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private MarkerEntity markerEntity;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Application Stating............");
		MarkerEntity entity = new MarkerEntity();
		entity.setName("gg");
		entity.setTimeStamp(111);
		entity.setId(1);
		List<MarkerEntity> markerEntity = markerService.getAllMarker();
		System.err.println("LL:" + markerEntity);
		if (markerEntity.size() == 0) {
			markerService.save(entity);
		}
	}
}
