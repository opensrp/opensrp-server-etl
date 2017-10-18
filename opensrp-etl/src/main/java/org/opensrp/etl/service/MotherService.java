package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.MotherEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.MotherRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MotherService implements RegisterService<MotherEntity> {
	
	@Autowired
	private MotherRepository motherRepository;
	
	public MotherService() {
		
	}
	
	@Transactional
	@Override
	public void save(MotherEntity motherEntity) {
		MotherEntity existingMotherEntity = findByCaseId(motherEntity.getCaseId());
		if (existingMotherEntity == null) {
			motherRepository.save(motherEntity);
		} else {
			if (delete(existingMotherEntity))
				motherRepository.save(motherEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(MotherEntity motherEntity) {
		return motherRepository.delete(motherEntity);
		
	}
	
	@Transactional
	@Override
	public void update(MotherEntity motherEntity) {
		motherRepository.update(motherEntity);
		
	}
	
	@Override
	public MotherEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public MotherEntity findByCaseId(String caseId) {
		return motherRepository.findByCaseId(caseId);
	}
	
}
