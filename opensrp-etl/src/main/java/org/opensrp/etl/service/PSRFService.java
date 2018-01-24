package org.opensrp.etl.service;

import static org.opensrp.etl.util.AllConstants.PSRF_TODAY;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.PSRFEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PSRFService implements RegisterService<PSRFEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public PSRFService() {
	}
	
	@Transactional
	@Override
	public void save(PSRFEntity psrfEntity) {
		PSRFEntity existingPSRFEntity = findByCaseIdAndToday(psrfEntity.getRelationalid(), psrfEntity.getToday());
		
		if (existingPSRFEntity == null) {
			commonDatabaseRepository.save(psrfEntity);
		} else {
			if (delete(existingPSRFEntity))
				commonDatabaseRepository.save(psrfEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(PSRFEntity psrfEntity) {
		return commonDatabaseRepository.delete(psrfEntity);
	}
	
	@Transactional
	@Override
	public void update(PSRFEntity psrfEntity) {
		commonDatabaseRepository.update(psrfEntity);
	}
	
	@Override
	public PSRFEntity findById(int id) {
		return null;
	}
	
	@Override
	public PSRFEntity findByCaseId(String caseId) {
		return null;
	}
	
	@Transactional
	public PSRFEntity findByCaseIdAndToday(String relationalId, Date today) {
		return commonDatabaseRepository.findByCaseIdAndToday(PSRF_TODAY, relationalId, today, PSRFEntity.class);
	}
	
}
