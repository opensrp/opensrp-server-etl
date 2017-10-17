package org.opensrp.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.BNFEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.BNFRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
		BNFEntity existingPSRFEntity = findByCaseIdAndToday(bnffEntity.getRelationalId(), bnffEntity.getFWBNFDATE());
		
		if (existingPSRFEntity == null) {
			bnfRepository.save(bnffEntity);
		} else {
			System.out.println("update household entity:" + existingPSRFEntity.toString());
			update(existingPSRFEntity);
		}
		
	}
	
	@Override
	public boolean delete(BNFEntity t) {
		return true;
		// TODO Auto-generated method stub
		
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
