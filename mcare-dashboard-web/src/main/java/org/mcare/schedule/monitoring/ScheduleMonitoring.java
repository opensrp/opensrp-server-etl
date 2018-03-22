package org.mcare.schedule.monitoring;

import java.util.List;

import org.mcare.schedule.monitoring.service.impl.MotherScheduleMonitoringServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleMonitoring {
	
	@Autowired
	private MotherScheduleMonitoringServiceImpl motherScheduleMonitoringServiceImpl;
	
	public List<Object[]> getData(String provider, String scheduleName) {
		return motherScheduleMonitoringServiceImpl.getData(provider, scheduleName);
	}
	
}
