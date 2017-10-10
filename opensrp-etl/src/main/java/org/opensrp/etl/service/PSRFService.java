package org.opensrp.etl.service;

import javax.transaction.Transactional;

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
	
	@Transactional
	@Override
	public void save(PSRFEntity psrfEntity) {
		PSRFEntity existingPSRFEntity = findByCaseId(psrfEntity.caseId);
		if (existingPSRFEntity == null) {
			psrfRepository.save(psrfEntity);
		} else {
			System.out.println("update household entity:" + existingPSRFEntity.toString());
			update(existingPSRFEntity);
		}
	}
	
	@Override
	public void delete(PSRFEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public void update(PSRFEntity psrfEntity) {
		psrfRepository.update(psrfEntity);
		
	}
	
	@Override
	public PSRFEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public PSRFEntity findByCaseId(String caseId) {
		return psrfRepository.findByCaseId(caseId);
	}
	
}
