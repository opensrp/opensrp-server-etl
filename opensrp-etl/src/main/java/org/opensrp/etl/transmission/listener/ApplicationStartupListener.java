package org.opensrp.etl.transmission.listener;

import org.apache.log4j.Logger;
import org.opensrp.etl.entity.MarkerEntity;
import org.opensrp.etl.service.MarkerService;
import org.opensrp.etl.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {
	
	private static final Logger logger = Logger.getLogger(ApplicationStartupListener.class);
	
	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private MarkerEntity markerEntity;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info(CommonConstant.DGFP.name() + " Application Stating............ " + event.getApplicationContext().getId());
		markerEntity = markerService.findByName(CommonConstant.DGFP.name());
		if (markerEntity == null) {
			MarkerEntity markerEntityDGFP = new MarkerEntity();
			markerEntityDGFP.setname(CommonConstant.DGFP.name());
			markerEntityDGFP.settimeStamp(0);
			markerService.save(markerEntityDGFP);
		}
		
	}
	
}
