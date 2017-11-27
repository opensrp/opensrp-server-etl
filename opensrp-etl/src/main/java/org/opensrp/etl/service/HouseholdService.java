package org.opensrp.etl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.HouseholdEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdService implements RegisterService<HouseholdEntity> {
	
	@Autowired
	private HouseholdRepository householdRepository;
	
	public HouseholdService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(HouseholdEntity householdEntity) {
		
		HouseholdEntity existingHouseholdEntity = findByCaseId(householdEntity.getCaseId());
		if (existingHouseholdEntity == null) {
			householdRepository.save(householdEntity);
		} else {
			if (delete(existingHouseholdEntity))
				householdRepository.save(householdEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(HouseholdEntity householdEntity) {
		return householdRepository.delete(householdEntity);
		
	}
	
	@Transactional
	@Override
	public void update(HouseholdEntity householdEntity) {
		householdRepository.update(householdEntity);
		
	}
	
	@Override
	public HouseholdEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public HouseholdEntity findByCaseId(String caseId) {
		return householdRepository.findByCaseId(caseId);
	}
	
	public List<HouseholdEntity> list() {
		//householdRepository.
		return null;
		
	}
}
