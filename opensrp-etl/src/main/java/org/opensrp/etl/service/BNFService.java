package org.opensrp.etl.service;

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
	
	@Override
	public void save(BNFEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(BNFEntity t) {
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
	
	@Override
	public BNFEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
