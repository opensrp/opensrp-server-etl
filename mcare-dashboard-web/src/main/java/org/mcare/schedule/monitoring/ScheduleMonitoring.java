package org.mcare.schedule.monitoring;

import java.util.List;

import org.mcare.schedule.monitoring.service.ScheduleMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleMonitoring {
	
	@Autowired
	private ScheduleTypeFactory scheduleTypeFactory;
	
	private ScheduleMonitoringService scheduleMonitoringService;
	
	public List<Object[]> getData(String provider, String scheduleName) {
		scheduleMonitoringService = scheduleTypeFactory.getScheduleTypeService(scheduleName);
		return scheduleMonitoringService.getData(provider);
	}
}
