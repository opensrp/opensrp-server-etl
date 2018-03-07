package org.mcare.etl.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.ChildEntity;
import org.mcare.etl.entity.ENCCEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ENCCService implements RegisterService<ENCCEntity> {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public ENCCService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(ENCCEntity enccEntity) throws Exception {
		ENCCEntity existingEnccEntity = findByCaseIdAndToday(enccEntity.getRelationalId(), enccEntity.getToday());
		if (existingEnccEntity == null) {
			databaseRepositoryImpl.save(enccEntity);
		} else {
			if (delete(existingEnccEntity))
				databaseRepositoryImpl.save(enccEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(ENCCEntity enccEntity) {
		return databaseRepositoryImpl.delete(enccEntity);
		
	}
	
	@Override
	public void update(ENCCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ENCCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public ENCCEntity findByCaseIdAndToday(String relationalId, Date today) {
		return databaseRepositoryImpl.findByCaseIdAndToday(relationalId, today, ENCCEntity.class);
	}
	
	@Override
	public ENCCEntity findByCaseId(String caseId) {
		return databaseRepositoryImpl.findByKey(caseId, "caseId", ENCCEntity.class);
	}

	public List<ENCCEntity> findByRelationalId(String caseId) {
		return databaseRepositoryImpl.findAllByCaseId(caseId, "relationalId", ENCCEntity.class);
	}
	
}
