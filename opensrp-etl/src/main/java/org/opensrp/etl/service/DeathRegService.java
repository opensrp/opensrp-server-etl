package org.opensrp.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.DeathRegEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.DeathRegRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DeathRegService implements RegisterService<DeathRegEntity> {

	@Autowired
	private DeathRegRepository deathRegRepository;

	public DeathRegService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	@Override
	public void save(DeathRegEntity deathRegEntity) {
		DeathRegEntity existingDeathRegEntity = findByCaseIdAndToday(deathRegEntity.getRelationalid(),
				deathRegEntity.getDeath_today());

		if (existingDeathRegEntity == null) {
			deathRegRepository.save(deathRegEntity);
		} else {
			if (delete(existingDeathRegEntity))
				deathRegRepository.save(deathRegEntity);
		}
	}

	@Transactional
	@Override
	public boolean delete(DeathRegEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public void update(DeathRegEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DeathRegEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeathRegEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public DeathRegEntity findByCaseIdAndToday(String relationalId, Date death_today) {
		return deathRegRepository.findByCaseIdAndToday(relationalId, death_today);
	}
}
