package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.ChildEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildService implements RegisterService<ChildEntity> {
	
	@Autowired
	private ChildRepository childRepository;
	
	public ChildService() {
		
	}
	
	@Transactional
	@Override
	public void save(ChildEntity childEntity) {
		System.out.println("Class:ChildService, Method:save");
		childRepository.save(childEntity);
	}
	
	@Override
	public void delete(ChildEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(ChildEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ChildEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ChildEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
