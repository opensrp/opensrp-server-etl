package org.mcare.schedule.monitoring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.schedule.monitoring.service.ScheduleMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PNCScheduleMonitoringServiceImpl implements ScheduleMonitoringService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Transactional
	@Override
	public List<Object[]> getData(String provider) {
		String scheduleName = "Post Natal Care Reminder Visit";
		String userType = "FD";
		String caseId = "";
		String sqlQuery = "select first_name, motherhusname,motherjivihid,mothergobhhid,mauza_para,"
		        + "motherwomnid,motherwombid,fwbnfdtoo,"
		        + "case_id,(select concat_ws(',',alert_status,expiry_date,is_action_active,visit_code) "
		        + "from action where action.case_id=mother.case_id and action.schedule_name=:scheduleName "
		        + "order by action.id desc limit 1 ),"
		        + "fwbnfsts from mother join bnf on mother.case_id=bnf.relationalid  "
		        + "where mother.provider=:provider and  date_part('days', now()-bnf.fwbnfdtoo)<=43 and bnf.user_type=:userType "
		        + " order by bnf.id desc ";
		
		return databaseRepositoryImpl.executeSelectQuery(provider, caseId, scheduleName, userType, sqlQuery);
	}
	
	@Transactional
	@Override
	public List<Object[]> getSubmittedScheduleData(String provider, String caseId) {
		String userType = "";
		String scheduleName = "";
		String sqlQuery = "select m.provider,p.fwpncdate, p.pncname,p.pnc_current_formstatus from mother as m  "
		        + "join pnc as p on m.case_id=p.relationalid where provider=:provider and "
		        + "m.case_id=:case_id order by p.id asc";
		return databaseRepositoryImpl.executeSelectQuery(provider, caseId, scheduleName, userType, sqlQuery);
	}
}
