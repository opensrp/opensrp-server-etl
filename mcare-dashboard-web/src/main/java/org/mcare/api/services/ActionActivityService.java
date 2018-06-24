package org.mcare.api.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mcare.api.utils.ScheduleName;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.mcare.etl.entity.ActionEntity;
import org.mcare.etl.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ActionActivityService {
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	@Autowired
	private ActionService actionService;
	
	protected void inactivePSRFActionByCaseId(String caseId) {
		Map<String, String> fieldValues = new HashMap<String, String>();
		fieldValues.put("caseId", caseId);
		fieldValues.put("scheduleName", ScheduleName.psrf.schedule());
		List<ActionEntity> action = databaseServiceImpl.findAllByKeys(fieldValues, ActionEntity.class);
		databaseServiceImpl.updateListOfData(action);
		
	}
	
	protected void inactiveANCActionByCaseId(String caseId) {
		Map<String, String> fieldValues = new HashMap<String, String>();
		fieldValues.put("caseId", caseId);
		fieldValues.put("scheduleName", ScheduleName.anc.schedule());
		List<ActionEntity> action = databaseServiceImpl.findAllByKeys(fieldValues, ActionEntity.class);
		databaseServiceImpl.updateListOfData(action);
	}
	
	protected void inactiveBNFActionByCaseId(String caseId) {
		Map<String, String> fieldValues = new HashMap<String, String>();
		fieldValues.put("caseId", caseId);
		fieldValues.put("scheduleName", ScheduleName.bnf.schedule());
		List<ActionEntity> action = databaseServiceImpl.findAllByKeys(fieldValues, ActionEntity.class);
		databaseServiceImpl.updateListOfData(action);
	}
	
	protected void inactivePNCActionByCaseId(String caseId) {
		Map<String, String> fieldValues = new HashMap<String, String>();
		fieldValues.put("caseId", caseId);
		fieldValues.put("scheduleName", ScheduleName.pnc.schedule());
		List<ActionEntity> action = databaseServiceImpl.findAllByKeys(fieldValues, ActionEntity.class);
		databaseServiceImpl.updateListOfData(action);
	}
	
	protected void inactiveENCCActionByCaseId(String caseId) {
		Map<String, String> fieldValues = new HashMap<String, String>();
		fieldValues.put("caseId", caseId);
		fieldValues.put("scheduleName", ScheduleName.encc.schedule());
		List<ActionEntity> action = databaseServiceImpl.findAllByKeys(fieldValues, ActionEntity.class);
		databaseServiceImpl.updateListOfData(action);
	}
	
	protected void inactiveAllActionByCaseId(String caseId) {
		Map<String, String> fieldValues = new HashMap<String, String>();
		fieldValues.put("caseId", caseId);
		List<ActionEntity> action = databaseServiceImpl.findAllByKeys(fieldValues, ActionEntity.class);
		if (action != null) {
			if (action.size() != 0) {
				databaseServiceImpl.updateListOfData(action);
			}
		} else {
			
		}
	}
	
}
