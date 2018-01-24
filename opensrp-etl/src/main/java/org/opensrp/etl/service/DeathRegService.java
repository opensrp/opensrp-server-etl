package org.opensrp.etl.service;

import static org.opensrp.etl.util.AllConstants.DEATH_TODAY;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.DeathRegEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DeathRegService implements RegisterService<DeathRegEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public DeathRegService() {
	}
	
	@Transactional
	@Override
	public void save(DeathRegEntity deathRegEntity) {
		DeathRegEntity existingDeathRegEntity = findByCaseIdAndToday(deathRegEntity.getRelationalid(),
		    deathRegEntity.getDeath_today());
		
		if (existingDeathRegEntity == null) {
			commonDatabaseRepository.save(deathRegEntity);
		} else {
			if (delete(existingDeathRegEntity))
				commonDatabaseRepository.save(deathRegEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(DeathRegEntity deathRegEntity) {
		return commonDatabaseRepository.delete(deathRegEntity);
	}
	
	@Transactional
	@Override
	public void update(DeathRegEntity deathRegEntity) {
		commonDatabaseRepository.update(deathRegEntity);
	}
	
	@Override
	public DeathRegEntity findById(int id) {
		return null;
	}
	
	@Override
	public DeathRegEntity findByCaseId(String caseId) {
		return null;
	}
	
	@Transactional
	public DeathRegEntity findByCaseIdAndToday(String relationalId, Date death_today) {
		return commonDatabaseRepository.findByCaseIdAndToday(DEATH_TODAY, relationalId, death_today, DeathRegEntity.class);
	}
}
