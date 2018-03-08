package org.mcare.etl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.ChildEntity;
import org.mcare.etl.entity.ENCCEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService implements RegisterService<ChildEntity> {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public ChildService() {
		
	}
	
	@Transactional
	@Override
	public void save(ChildEntity childEntity) throws Exception {
		ChildEntity existingCHildEntity = findByCaseId(childEntity.caseId);
		if (existingCHildEntity == null) {
			databaseRepositoryImpl.save(childEntity);
		} else {
			if (delete(existingCHildEntity))
				databaseRepositoryImpl.save(childEntity);
			
		}
	}
	
	@Transactional
	@Override
	public boolean delete(ChildEntity childEntity) {
		return databaseRepositoryImpl.delete(childEntity);
		
	}
	
	@Transactional
	@Override
	public void update(ChildEntity childEntity) {
		databaseRepositoryImpl.delete(childEntity);
		
	}
	
	@Override
	public ChildEntity findById(int id) {
		return databaseRepositoryImpl.findById(id, "id", ChildEntity.class);
	}
	
	@Transactional
	@Override
	public ChildEntity findByCaseId(String caseId) {
		return databaseRepositoryImpl.findByKey(caseId, "caseId", ChildEntity.class);
	}
	
	@Transactional
	public List<ChildEntity> findAll() {
		return databaseRepositoryImpl.findAll(ChildEntity.class);
	}
	
}
