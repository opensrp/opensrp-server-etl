package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.opensrp.etl.entity.ActionEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionService implements RegisterService<ActionEntity> {
	
	private static final Logger logger = Logger.getLogger(ActionService.class);
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public ActionService() {
	}
	
	@Transactional
	@Override
	public void save(ActionEntity actionEntity) {
		if (!isActionExist(actionEntity)) {
			commonDatabaseRepository.save(actionEntity);
		} else {
			logger.info("Action already exists in database!!!");
		}
	}
	
	@Transactional
	public boolean isActionExist(ActionEntity actionEntity) {
		return commonDatabaseRepository.isActionExist(actionEntity.getCaseId(), actionEntity.getVisitCode(),
		    actionEntity.getAlertStatus(), actionEntity.getStartDate()) > 0 ? true : false;
		
	}
	
	@Transactional
	@Override
	public boolean delete(ActionEntity actionEntity) {
		return commonDatabaseRepository.delete(actionEntity);
	}
	
	@Transactional
	@Override
	public void update(ActionEntity actionEntity) {
		commonDatabaseRepository.update(actionEntity);
	}
	
	@Override
	public ActionEntity findById(int id) {
		return null;
	}
	
	@Transactional
	@Override
	public ActionEntity findByCaseId(String caseId) {
		return null;
	}
}
