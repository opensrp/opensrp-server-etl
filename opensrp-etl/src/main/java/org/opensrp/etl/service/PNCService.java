package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.PNCEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.PNCRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PNCService implements RegisterService<PNCEntity> {
	
	@Autowired
	private PNCRepository pncRepository;
	
	public PNCService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(PNCEntity pncEntity) {
		pncRepository.save(pncEntity);
		
	}
	
	@Override
	public void delete(PNCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(PNCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public PNCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PNCEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
