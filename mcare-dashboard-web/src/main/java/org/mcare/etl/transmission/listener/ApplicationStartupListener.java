package org.mcare.etl.transmission.listener;

import org.mcare.acl.service.impl.DefaultApplicationSettingService;
import org.mcare.etl.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private DefaultApplicationSettingService defaultSystemSettingService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println(CommonConstant.MCARE.name() + "Application Stating............"
		        + event.getApplicationContext().getId());
		defaultSystemSettingService.saveDefaultAppSetting();
	}
}
