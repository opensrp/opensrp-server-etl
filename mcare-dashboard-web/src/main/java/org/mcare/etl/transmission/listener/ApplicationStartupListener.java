package org.mcare.etl.transmission.listener;

import org.mcare.etl.entity.MarkerEntity;
import org.mcare.etl.service.MarkerService;
import org.mcare.etl.util.CommonConstant;
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
		System.out.println(CommonConstant.MCARE.name() + "Application Stating............"
		        + event.getApplicationContext().getId());
		MarkerEntity entity = new MarkerEntity();
		entity.setName(CommonConstant.MCARE.name());
		entity.setTimeStamp(0);
		MarkerEntity markerEntity = markerService.findByName(CommonConstant.MCARE.name());
		if (markerEntity == null) {
			markerService.save(entity);
		}
	}
}
