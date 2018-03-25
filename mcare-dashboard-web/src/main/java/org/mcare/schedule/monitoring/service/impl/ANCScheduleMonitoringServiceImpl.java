package org.mcare.schedule.monitoring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.schedule.monitoring.service.ScheduleMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ANCScheduleMonitoringServiceImpl implements ScheduleMonitoringService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Transactional
	@Override
	public List<Object[]> getData(String provider, String scheduleName) {
		
		String sqlQuery = "select first_name, motherhusname,motherjivihid,mothergobhhid,mauza_para,motherwomnid,motherwombid,"
		        + "motherwomlmp,round(date_part('days', now()-mother.motherwomlmp)/7),id ,(select concat_ws(',',alert_status,expiry_date,is_action_active,visit_code) "
		        + "from action where action.case_id=mother.case_id and action.schedule_name='Ante Natal Care Reminder Visit' "
		        + "order by action.id desc limit 1 ) from mother where provider=:provider and "
		        + "  date_part('days', now()-mother.motherwomlmp)<308 and NOT EXISTS"
		        + "(SELECT 1 FROM action  WHERE mother.case_id = action.case_id AND"
		        + " action.schedule_name = 'Post Natal Care Reminder Visit')  ";
		/*String sqlQuery = "SELECT DISTINCT ON (a.case_id) m.id,  m.first_name, m.motherhusname,m.motherjivihid,"
		        + "m.mothergobhhid,m.mauza_para,m.motherwomnid,m.motherwombid, "
		        + "m.motherwomlmp,round(date_part('days', now()-m.motherwomlmp)/7)"
		        + ",a.expiry_date, a.alert_status, a.is_action_active,round(date_part('days', now()-m.motherwomlmp)/7)"
		        + " FROM   mother m LEFT   JOIN action a USING (case_id) "
		        + "where a.schedule_name='Ante Natal Care Reminder Visit' and m.provider=:provider and "
		        + "date_part('days', now()-m.motherwomlmp)<308 and NOT EXISTS  (SELECT 1 FROM action as ac "
		        + "WHERE m.case_id = ac.case_id AND ac.schedule_name = 'Post Natal Care Reminder Visit')"
		        + "ORDER  BY a.case_id,  a.id desc;";*/
		
		return databaseRepositoryImpl.executeSelectQuery(provider, scheduleName, sqlQuery);
	}
}
