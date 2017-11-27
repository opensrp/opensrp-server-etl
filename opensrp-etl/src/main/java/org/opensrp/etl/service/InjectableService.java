package org.opensrp.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.InjectableEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.InjectableRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InjectableService implements RegisterService<InjectableEntity>{

	@Autowired
	private InjectableRepository injectableRepository;

	@Transactional
	@Override
	public void save(InjectableEntity injectableEntity) {
		InjectableEntity existinginjectableEntity = findByCaseIdAndToday(injectableEntity.getRelationalid(),
				injectableEntity.getToday());
		if (existinginjectableEntity == null) {
			injectableRepository.save(injectableEntity);
		} else {
			if (delete(existinginjectableEntity))
				injectableRepository.save(injectableEntity);
		}
		
	}

	private InjectableEntity findByCaseIdAndToday(String relationalid,
			Date today) {
		return injectableRepository.findByCaseIdAndToday(relationalid, today);
	}

	@Override
	public boolean delete(InjectableEntity injectableEntity) {
		return injectableRepository.delete(injectableEntity);
	}

	@Override
	public void update(InjectableEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InjectableEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InjectableEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
