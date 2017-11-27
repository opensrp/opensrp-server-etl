package org.mcare.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.mcare.etl.entity.PNCEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.mcare.etl.repository.PNCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PNCService implements RegisterService<PNCEntity> {
	
	@Autowired
	private PNCRepository pncRepository;
	
	public PNCService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(PNCEntity pncEntity) {
		PNCEntity existingpncEntity = findByCaseIdAndToday(pncEntity.getRelationalid(), pncEntity.getToday());
		if (existingpncEntity == null) {
			pncRepository.save(pncEntity);
		} else {
			if (delete(existingpncEntity))
				pncRepository.save(pncEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(PNCEntity ancEntity) {
		return pncRepository.delete(ancEntity);
	}
	
	@Transactional
	@Override
	public void update(PNCEntity pncEntity) {
		pncRepository.update(pncEntity);
		
	}
	
	@Override
	public PNCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public PNCEntity findByCaseId(String caseId) {
		return pncRepository.findByCaseId(caseId);
	}
	
	@Transactional
	public PNCEntity findByCaseIdAndToday(String relationalId, Date today) {
		return pncRepository.findByCaseIdAndToday(relationalId, today);
	}
}
