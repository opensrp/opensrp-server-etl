package org.opensrp.etl.service;

import static org.opensrp.etl.util.AllConstants.PNC_NAME;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.PNCEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PNCService implements RegisterService<PNCEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public PNCService() {
	}
	
	@Transactional
	@Override
	public void save(PNCEntity pncEntity) {
		PNCEntity existingpncEntity = findByCaseIdAndName(pncEntity.getRelationalid(), pncEntity.getPncName());
		if (existingpncEntity == null) {
			commonDatabaseRepository.save(pncEntity);
		} else {
			if (delete(existingpncEntity))
				commonDatabaseRepository.save(pncEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(PNCEntity ancEntity) {
		return commonDatabaseRepository.delete(ancEntity);
	}
	
	@Transactional
	@Override
	public void update(PNCEntity pncEntity) {
		commonDatabaseRepository.update(pncEntity);
	}
	
	@Override
	public PNCEntity findById(int id) {
		return null;
	}
	
	@Transactional
	@Override
	public PNCEntity findByCaseId(String caseId) {
		return null;
	}
	
	@Transactional
	public PNCEntity findByCaseIdAndName(String relationalId, String name) {
		return commonDatabaseRepository.findByCaseIdAndName(PNC_NAME, relationalId, name, PNCEntity.class);
	}
}
