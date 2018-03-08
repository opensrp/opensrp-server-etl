package org.mcare.etl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
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
	public void save(ActionEntity actionEntity) throws Exception {
		ActionEntity action = getAction(actionEntity);
		
		if (action == null) {
			databaseRepositoryImpl.save(actionEntity);
		} else {
			if (delete(action))
				databaseRepositoryImpl.save(actionEntity);
		}
	}
	
	@Transactional
	public ActionEntity getAction(ActionEntity actionEntity) {
		return databaseRepositoryImpl.getAction(actionEntity.getCaseID(), actionEntity.getVisitCode(),
		    actionEntity.getAlertStatus(), actionEntity.getStartDate());
		
	}
	
	@Transactional
	@Override
	public boolean delete(ActionEntity t) {
		return databaseRepositoryImpl.delete(t);
		
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
		return databaseRepositoryImpl.findByKey(caseId, "caseId", ActionEntity.class);
	}

	public List<ActionEntity> findAllByCaseId(String caseId) {
		return databaseRepositoryImpl.findAllByCaseId(caseId, "caseId", ActionEntity.class);
	}
}
