package org.mcare.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.PNCEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PNCService implements RegisterService<PNCEntity> {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public PNCService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(PNCEntity pncEntity) {
		PNCEntity existingpncEntity = findByCaseIdAndToday(pncEntity.getRelationalid(), pncEntity.getToday());
		if (existingpncEntity == null) {
			databaseRepositoryImpl.save(pncEntity);
		} else {
			if (delete(existingpncEntity))
				databaseRepositoryImpl.save(pncEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(PNCEntity ancEntity) {
		return databaseRepositoryImpl.delete(ancEntity);
	}
	
	@Transactional
	@Override
	public void update(PNCEntity pncEntity) {
		databaseRepositoryImpl.update(pncEntity);
		
	}
	
	@Override
	public PNCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public PNCEntity findByCaseId(String caseId) {
		return null;
	}
	
	@Transactional
	public PNCEntity findByCaseIdAndToday(String relationalId, Date today) {
		return databaseRepositoryImpl.findByCaseIdAndToday(relationalId, today, PNCEntity.class);
	}
}
