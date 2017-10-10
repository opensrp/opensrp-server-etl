package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.ElcoEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.ElcoRepository;
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
			System.out.println("update elco entity:" + existingElcoEntity.toString());
			update(existingElcoEntity);
		}
	}
	
	@Override
	public void delete(ElcoEntity t) {
		// TODO Auto-generated method stub
		
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
