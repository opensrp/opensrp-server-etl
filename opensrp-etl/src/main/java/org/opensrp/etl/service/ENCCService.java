package org.opensrp.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.ENCCEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.ENCCRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ENCCService implements RegisterService<ENCCEntity> {
	
	@Autowired
	private ENCCRepository enccRepository;
	
	public ENCCService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(ENCCEntity enccEntity) {
		ENCCEntity existingEnccEntity = findByCaseIdAndToday(enccEntity.getRelationalId(), enccEntity.getToday());
		if (existingEnccEntity == null) {
			enccRepository.save(enccEntity);
		} else {
			if (delete(existingEnccEntity))
				enccRepository.save(enccEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(ENCCEntity enccEntity) {
		return enccRepository.delete(enccEntity);
		
	}
	
	@Override
	public void update(ENCCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ENCCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public ENCCEntity findByCaseIdAndToday(String relationalId, Date today) {
		
		return enccRepository.findByCaseIdAndToday(relationalId, today);
	}
	
	@Override
	public ENCCEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
