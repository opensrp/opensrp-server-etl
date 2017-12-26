package org.unicef.etl.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.etl.entity.ActionEntity;
import org.unicef.etl.interfaces.RegisterService;
import org.unicef.etl.repository.CommonDatabaseRepository;

@Service
public class ActionService implements RegisterService<ActionEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public ActionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(ActionEntity actionEntity) {
		if (!isActionExist(actionEntity)) {
			commonDatabaseRepository.save(actionEntity);
		} else {
			System.out.println("Action already exists in database!!!");
		}
		
	}
	
	@Transactional
	public boolean isActionExist(ActionEntity actionEntity) {
		return commonDatabaseRepository.isActionExist(actionEntity.getBaseEntityId(), actionEntity.getVisitCode(),
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
	public ActionEntity findBybaseEntityId(String baseEntityId) {
		return commonDatabaseRepository.findByKey(baseEntityId, "baseEntityId", ActionEntity.class);
	}
	
}
