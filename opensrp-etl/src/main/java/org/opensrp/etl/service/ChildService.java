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
		ChildEntity existingCHildEntity = findByCaseId(childEntity.caseId);
		if (existingCHildEntity == null) {
			childRepository.save(childEntity);
		} else {
			if (delete(existingCHildEntity))
				childRepository.save(childEntity);
			
		}
	}
	
	@Transactional
	@Override
	public boolean delete(ChildEntity childEntity) {
		return childRepository.delete(childEntity);
		
	}
	
	@Transactional
	@Override
	public void update(ChildEntity childEntity) {
		childRepository.delete(childEntity);
		
	}
	
	@Override
	public ChildEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public ChildEntity findByCaseId(String caseId) {
		return childRepository.findByCaseId(caseId);
	}
	
}
