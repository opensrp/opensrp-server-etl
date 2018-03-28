package org.mcare.schedule.monitoring;

import org.mcare.schedule.monitoring.service.ScheduleMonitoringService;
import org.mcare.schedule.monitoring.service.impl.ANCScheduleMonitoringServiceImpl;
import org.mcare.schedule.monitoring.service.impl.ENCCScheduleMonitoringServiceImpl;
import org.mcare.schedule.monitoring.service.impl.PNCScheduleMonitoringServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTypeFactory {
	
	@Autowired
	private ANCScheduleMonitoringServiceImpl ancScheduleMonitoringServiceImpl;
	
	@Autowired
	private PNCScheduleMonitoringServiceImpl pncScheduleMonitoringServiceImpl;
	
	@Autowired
	private ENCCScheduleMonitoringServiceImpl enccScheduleMonitoringServiceImpl;
	
	private ScheduleMonitoringService scheduleMonitoringService;
	
	public ScheduleMonitoringService getScheduleTypeService(String scheduleName) {
		if ("ANC".equalsIgnoreCase(scheduleName)) {
			scheduleMonitoringService = ancScheduleMonitoringServiceImpl;
		} else if ("PNC".equalsIgnoreCase(scheduleName)) {
			scheduleMonitoringService = pncScheduleMonitoringServiceImpl;
		} else if ("ENCC".equalsIgnoreCase(scheduleName)) {
			scheduleMonitoringService = enccScheduleMonitoringServiceImpl;
		} else {
			scheduleMonitoringService = null;
		}
		
		return scheduleMonitoringService;
	}
}
