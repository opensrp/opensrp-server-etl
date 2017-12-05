package org.mcare.etl.service;

import javax.transaction.Transactional;

import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.mcare.etl.entity.ActionEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ActionService implements RegisterService<ActionEntity> {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public ActionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(ActionEntity actionEntity) {
		if (!isActionExist(actionEntity)) {
			databaseRepositoryImpl.save(actionEntity);
		} else {
			System.out.println("Action already exists in database!!!");
		}
		
	}
	
	@Transactional
	public boolean isActionExist(ActionEntity actionEntity) {
		return databaseRepositoryImpl.isActionExist(actionEntity.getCaseID(), actionEntity.getVisitCode(),
		    actionEntity.getAlertStatus(), actionEntity.getStartDate()) > 0 ? true : false;
		
	}
	
	@Override
	public boolean delete(ActionEntity t) {
		return true;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(ActionEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ActionEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public ActionEntity findByCaseId(String caseId) {
		return databaseRepositoryImpl.findByKey(caseId,"caseId", ActionEntity.class);
	}
	
}
