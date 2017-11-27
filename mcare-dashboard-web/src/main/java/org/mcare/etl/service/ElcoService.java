package org.mcare.etl.service;

import javax.transaction.Transactional;

import org.mcare.etl.entity.ElcoEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.mcare.etl.repository.ElcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElcoService implements RegisterService<ElcoEntity> {
	
	@Autowired
	private ElcoRepository elcoRepository;
	
	public ElcoService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(ElcoEntity elcoEntity) {
		ElcoEntity existingElcoEntity = findByCaseId(elcoEntity.caseId);
		if (existingElcoEntity == null) {
			elcoRepository.save(elcoEntity);
		} else {
			if (delete(existingElcoEntity))
				elcoRepository.save(elcoEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(ElcoEntity elcoEntity) {
		return elcoRepository.delete(elcoEntity);
		
	}
	
	@Transactional
	@Override
	public void update(ElcoEntity elcoEntity) {
		elcoRepository.update(elcoEntity);
		
	}
	
	@Override
	public ElcoEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public ElcoEntity findByCaseId(String caseId) {
		return elcoRepository.findByCaseId(caseId);
	}
	
}
