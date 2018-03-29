package org.mcare.etl.service;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.ElcoEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElcoService implements RegisterService<ElcoEntity> {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public ElcoService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(ElcoEntity elcoEntity) throws Exception {
		ElcoEntity existingElcoEntity = findByCaseId(elcoEntity.caseId);
		if (existingElcoEntity == null) {
			databaseRepositoryImpl.save(elcoEntity);
		} else {
			if (delete(existingElcoEntity))
				databaseRepositoryImpl.save(elcoEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(ElcoEntity elcoEntity) {
		return databaseRepositoryImpl.delete(elcoEntity);
		
	}
	
	@Transactional
	@Override
	public void update(ElcoEntity elcoEntity) {
		databaseRepositoryImpl.update(elcoEntity);
		
	}
	
	@Transactional
	@Override
	public ElcoEntity findById(int id) {
		return databaseRepositoryImpl.findById(id, "id", ElcoEntity.class);
		
	}
	
	@Transactional
	@Override
	public ElcoEntity findByCaseId(String caseId) {
		return databaseRepositoryImpl.findByKey(caseId, "caseId", ElcoEntity.class);
	}
	
}