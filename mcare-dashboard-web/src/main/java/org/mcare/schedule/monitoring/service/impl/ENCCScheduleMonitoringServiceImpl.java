package org.mcare.schedule.monitoring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.schedule.monitoring.service.ScheduleMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ENCCScheduleMonitoringServiceImpl implements ScheduleMonitoringService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Transactional
	@Override
	public List<Object[]> getData(String provider) {
		String scheduleName = "Essential Newborn Care Checklist";
		String userType = "FD";
		String caseId = "";
		String sqlQuery = "select fwbnfchildname,fwbnfname,jivitahhid,gobhhid,mauza_para,fwwomnid,fwwombid, "
		        + "date(birth_date),case_id,(select concat_ws(',',alert_status,expiry_date,is_action_active,visit_code) "
		        + "from action where action.case_id=child.case_id and action.schedule_name=:scheduleName "
		        + "order by action.id desc limit 1 )  from child  where child.provider=:provider and user_type=:userType "
		        + " and date_part('days', now()-birth_date)<=43 order by child.id desc ";
		
		return databaseRepositoryImpl.executeSelectQuery(provider, caseId, scheduleName, userType, sqlQuery);
	}
	
	@Transactional
	@Override
	public List<Object[]> getSubmittedScheduleData(String provider, String caseId) {
		String userType = "";
		String scheduleName = "";
		String sqlQuery = "select c.provider,e.fwenccdate, e.enccname,e.encc_current_formstatus from child as c  "
		        + "join encc as e on c.case_id=e.relationalid where provider=:provider and "
		        + "c.case_id=:case_id order by e.id asc";
		return databaseRepositoryImpl.executeSelectQuery(provider, caseId, scheduleName, userType, sqlQuery);
	}
}
