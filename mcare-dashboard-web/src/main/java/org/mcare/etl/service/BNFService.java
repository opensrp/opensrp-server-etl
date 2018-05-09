package org.mcare.etl.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.BNFEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BNFService implements RegisterService<BNFEntity> {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public BNFService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(BNFEntity bnfEntity) throws Exception {
		BNFEntity existingbnfEntity = findByCaseIdAndBNFDate(bnfEntity.getRelationalId(), bnfEntity.getFWBNFDATE());
		if (existingbnfEntity == null) {
			databaseRepositoryImpl.save(bnfEntity);
		} else {
			if (delete(existingbnfEntity))
				databaseRepositoryImpl.save(bnfEntity);
		}
		
	}
	
	@Transactional
	@Override
	public boolean delete(BNFEntity bnfEntity) {
		return databaseRepositoryImpl.delete(bnfEntity);
	}
	
	@Override
	public void update(BNFEntity bnfEntity) {
		databaseRepositoryImpl.update(bnfEntity);
	}
	
	@Override
	public BNFEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public BNFEntity findByCaseIdAndBNFDate(String relationalId, Date FWBNFDATE) {
		return databaseRepositoryImpl.findByCaseIdAndBNFDate(relationalId, FWBNFDATE, BNFEntity.class);
	}
	
	@Override
	public BNFEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public List<BNFEntity> findAllByKey(String caseId) {
		return databaseRepositoryImpl.findAllByKey(caseId, "relationalId", BNFEntity.class);
	}
	
}
