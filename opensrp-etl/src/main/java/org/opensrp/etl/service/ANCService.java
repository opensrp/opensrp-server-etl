package org.opensrp.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.ANCEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.ANCRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ANCService implements RegisterService<ANCEntity> {
	
	@Autowired
	private ANCRepository ancRepository;
	
	public ANCService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(ANCEntity ancEntity) {
		ANCEntity existingancEntity = findByCaseIdAndToday(ancEntity.getRelationalid(), ancEntity.getToday());
		if (existingancEntity == null) {
			ancRepository.save(ancEntity);
		} else {
			if (delete(existingancEntity))
				ancRepository.save(ancEntity);
		}
		
	}
	
	@Transactional
	@Override
	public boolean delete(ANCEntity ancEntity) {
		return ancRepository.delete(ancEntity);
	}
	
	@Override
	public void update(ANCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ANCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public ANCEntity findByCaseId(String caseId) {
		return ancRepository.findByCaseId(caseId);
	}
	
	@Transactional
	public ANCEntity findByCaseIdAndToday(String relationalId, Date today) {
		return ancRepository.findByCaseIdAndToday(relationalId, today);
	}
}
