package org.opensrp.etl.service;

import org.opensrp.etl.entity.PSRFEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.PSRFRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PSRFService implements RegisterService<PSRFEntity> {
	
	@Autowired
	private PSRFRepository psrfRepository;
	
	public PSRFService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(PSRFEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(PSRFEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(PSRFEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public PSRFEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PSRFEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
