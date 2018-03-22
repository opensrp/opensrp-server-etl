package org.mcare.schedule.monitoring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.schedule.monitoring.service.ScheduleMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotherScheduleMonitoringServiceImpl implements ScheduleMonitoringService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Transactional
	@Override
	public List<Object[]> getData(String provider, String scheduleName) {
		
		String sqlQuery = "select * from mother where provider=:provider and "
		        + "  date_part('days', now() -  mother.motherwomlmp)<308  ";
		
		return databaseRepositoryImpl.executeSelectQuery(provider, scheduleName, sqlQuery);
	}
}
