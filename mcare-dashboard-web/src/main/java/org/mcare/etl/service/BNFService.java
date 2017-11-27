package org.mcare.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.mcare.etl.entity.BNFEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.mcare.etl.repository.BNFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BNFService implements RegisterService<BNFEntity> {
	
	@Autowired
	private BNFRepository bnfRepository;
	
	public BNFService() {
		// TODO Auto-generated constructor stub
	}
	
	public void setBnfRepository(BNFRepository bnfRepository) {
		this.bnfRepository = bnfRepository;
	}
	
	@Transactional
	@Override
	public void save(BNFEntity bnffEntity) {
		BNFEntity existingbnfEntity = findByCaseIdAndToday(bnffEntity.getRelationalId(), bnffEntity.getFWBNFDATE());
		if (existingbnfEntity == null) {
			bnfRepository.save(bnffEntity);
		} else {
			if (delete(existingbnfEntity))
				bnfRepository.save(bnffEntity);
		}
		
	}
	
	@Transactional
	@Override
	public boolean delete(BNFEntity bnffEntity) {
		return bnfRepository.delete(bnffEntity);
	}
	
	@Override
	public void update(BNFEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public BNFEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public BNFEntity findByCaseIdAndToday(String relationalId, Date FWBNFDATE) {
		return bnfRepository.findByCaseIdAndToday(relationalId, FWBNFDATE);
	}
	
	@Override
	public BNFEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
