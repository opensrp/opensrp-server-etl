package org.opensrp.etl.service;

import static org.opensrp.etl.util.AllConstants.INJECTABLE_TODAY;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.InjectableEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InjectableService implements RegisterService<InjectableEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	@Transactional
	@Override
	public void save(InjectableEntity injectableEntity) {
		InjectableEntity existinginjectableEntity = findByCaseIdAndToday(injectableEntity.getRelationalid(),
		    injectableEntity.getInjectable_Today());
		if (existinginjectableEntity == null) {
			commonDatabaseRepository.save(injectableEntity);
		} else {
			if (delete(existinginjectableEntity))
				commonDatabaseRepository.save(injectableEntity);
		}
		
	}
	
	@Transactional
	@Override
	public boolean delete(InjectableEntity injectableEntity) {
		return commonDatabaseRepository.delete(injectableEntity);
	}
	
	@Transactional
	@Override
	public void update(InjectableEntity injectableEntity) {
		commonDatabaseRepository.update(injectableEntity);
	}
	
	@Override
	public InjectableEntity findById(int id) {
		return null;
	}
	
	@Override
	public InjectableEntity findByCaseId(String caseId) {
		return null;
	}
	
	@Transactional
	private InjectableEntity findByCaseIdAndToday(String relationalid, Date today) {
		return commonDatabaseRepository.findByCaseIdAndToday(INJECTABLE_TODAY, relationalid, today, InjectableEntity.class);
	}
}
