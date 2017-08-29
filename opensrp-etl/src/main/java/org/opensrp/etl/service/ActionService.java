package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.ActionEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.ActionRepository;

public class ActionService implements RegisterService<ActionEntity> {
	
	private ActionRepository actionRepository;
	
	public ActionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(ActionEntity actionEntity) {
		actionRepository.save(actionEntity);
		
	}
	
	@Override
	public void delete(ActionEntity t) {
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
	
	@Override
	public ActionEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
