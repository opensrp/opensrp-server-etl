package org.opensrp.etl.service;

import static org.opensrp.etl.util.AllConstants.CHILD_TODAY;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.ChildEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildService implements RegisterService<ChildEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public ChildService() {
		
	}
	
	@Transactional
	@Override
	public void save(ChildEntity childEntity) {
		ChildEntity existingCHildEntity = findByCaseIdAndToday(childEntity.getRelationalid(), childEntity.getChild_today());
		
		if (existingCHildEntity == null) {
			commonDatabaseRepository.save(childEntity);
		} else {
			if (delete(existingCHildEntity))
				commonDatabaseRepository.save(childEntity);
			
		}
	}
	
	@Transactional
	@Override
	public boolean delete(ChildEntity childEntity) {
		return commonDatabaseRepository.delete(childEntity);
	}
	
	@Transactional
	@Override
	public void update(ChildEntity childEntity) {
		commonDatabaseRepository.update(childEntity);
	}
	
	@Override
	public ChildEntity findById(int id) {
		return null;
	}
	
	@Override
	public ChildEntity findByCaseId(String caseId) {
		return null;
	}
	
	@Transactional
	public ChildEntity findByCaseIdAndToday(String caseId, Date today) {
		return commonDatabaseRepository.findByCaseIdAndToday(CHILD_TODAY, caseId, today, ChildEntity.class);
	}
}
