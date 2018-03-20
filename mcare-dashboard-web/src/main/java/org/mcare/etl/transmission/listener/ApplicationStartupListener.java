package org.mcare.etl.transmission.listener;

import java.sql.SQLException;

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

		if(event.getApplicationContext().getParent() != null) {
			System.out.println(CommonConstant.MCARE.name() + " Application Stating............"
					+ event.getApplicationContext().getId());
			try {
				defaultSystemSettingService.saveDefaultAppSetting();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
