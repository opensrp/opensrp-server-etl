package org.mcare.etl.service;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.MotherEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotherService implements RegisterService<MotherEntity> {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public MotherService() {
		
	}
	
	@Transactional
	@Override
	public void save(MotherEntity motherEntity) throws Exception {
		MotherEntity existingMotherEntity = findByCaseId(motherEntity.getCaseId());
		if (existingMotherEntity == null) {
			databaseRepositoryImpl.save(motherEntity);
		} else {
			if (delete(existingMotherEntity))
				databaseRepositoryImpl.save(motherEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(MotherEntity motherEntity) {
		return databaseRepositoryImpl.delete(motherEntity);
		
	}
	
	@Transactional
	@Override
	public void update(MotherEntity motherEntity) {
		databaseRepositoryImpl.update(motherEntity);
		
	}
	
	@Override
	public MotherEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public MotherEntity findByCaseId(String caseId) {
		return databaseRepositoryImpl.findByKey(caseId, "caseId", MotherEntity.class);
	}
	
}
