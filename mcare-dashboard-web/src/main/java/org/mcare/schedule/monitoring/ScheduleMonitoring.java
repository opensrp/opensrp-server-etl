package org.mcare.schedule.monitoring;

import java.util.List;

import org.mcare.schedule.monitoring.service.impl.ANCScheduleMonitoringServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleMonitoring {
	
	@Autowired
	private ANCScheduleMonitoringServiceImpl ancScheduleMonitoringServiceImpl;
	
	public List<Object[]> getData(String provider, String scheduleName) {
		
		return ancScheduleMonitoringServiceImpl.getData(provider, scheduleName);
	}
	
}
