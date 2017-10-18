package org.opensrp.etl.service;

import java.util.Date;

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
		PSRFEntity existingPSRFEntity = findByCaseIdAndToday(psrfEntity.getRelationalId(), psrfEntity.getToday());
		if (existingPSRFEntity == null) {
			psrfRepository.save(psrfEntity);
		} else {
			if (delete(existingPSRFEntity))
				psrfRepository.save(psrfEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(PSRFEntity psrfEntity) {
		return psrfRepository.delete(psrfEntity);
		
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
	public PSRFEntity findByCaseIdAndToday(String relationalId, Date today) {
		return psrfRepository.findByCaseIdAndToday(relationalId, today);
	}
	
	@Override
	public PSRFEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
