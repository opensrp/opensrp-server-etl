package org.mcare.etl.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.ANCEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ANCService implements RegisterService<ANCEntity> {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public ANCService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(ANCEntity ancEntity) throws Exception {
		ANCEntity existingancEntity = findByCaseIdAndToday(ancEntity.getRelationalid(), ancEntity.getToday());
		if (existingancEntity == null) {
			databaseRepositoryImpl.save(ancEntity);
		} else {
			if (delete(existingancEntity))
				databaseRepositoryImpl.save(ancEntity);
		}
		
	}
	
	@Transactional
	@Override
	public boolean delete(ANCEntity ancEntity) {
		return databaseRepositoryImpl.delete(ancEntity);
	}
	
	@Override
	public void update(ANCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ANCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public ANCEntity findByCaseId(String caseId) {
		return null;
	}
	
	@Transactional
	public ANCEntity findByCaseIdAndToday(String relationalId, Date today) {
		return databaseRepositoryImpl.findByCaseIdAndToday(relationalId, today, ANCEntity.class);
	}

	@Transactional
	public List<ANCEntity> findAllByCaseId(String caseId) {
		return databaseRepositoryImpl.findAllByCaseId(caseId, "ANCEntity");
	}
}