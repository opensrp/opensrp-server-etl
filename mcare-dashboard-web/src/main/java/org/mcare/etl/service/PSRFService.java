package org.mcare.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.mcare.etl.entity.PSRFEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.mcare.etl.repository.PSRFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PSRFService implements RegisterService<PSRFEntity> {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public PSRFService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(PSRFEntity psrfEntity) {
		PSRFEntity existingPSRFEntity = findByCaseIdAndToday(psrfEntity.getRelationalId(), psrfEntity.getToday());
		if (existingPSRFEntity == null) {
			databaseRepositoryImpl.save(psrfEntity);
		} else {
			if (delete(existingPSRFEntity))
				databaseRepositoryImpl.save(psrfEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(PSRFEntity psrfEntity) {
		return databaseRepositoryImpl.delete(psrfEntity);
		
	}
	
	@Transactional
	@Override
	public void update(PSRFEntity psrfEntity) {
		databaseRepositoryImpl.update(psrfEntity);
		
	}
	
	@Override
	public PSRFEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public PSRFEntity findByCaseIdAndToday(String relationalId, Date today) {
		return databaseRepositoryImpl.findByCaseIdAndToday(relationalId, today, PSRFEntity.class);
	}
	
	@Override
	public PSRFEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
