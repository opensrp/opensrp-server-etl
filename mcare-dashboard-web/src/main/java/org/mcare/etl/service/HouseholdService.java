package org.mcare.etl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.mcare.etl.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdService implements RegisterService<HouseholdEntity> {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public HouseholdService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(HouseholdEntity householdEntity) {
		HouseholdEntity existingHouseholdEntity = findByCaseId(householdEntity.caseId);
		if (existingHouseholdEntity == null) {
			databaseRepositoryImpl.save(householdEntity);
		} else {
			if (delete(existingHouseholdEntity))
				databaseRepositoryImpl.save(householdEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(HouseholdEntity householdEntity) {
		return databaseRepositoryImpl.delete(householdEntity);
		
	}
	
	@Transactional
	@Override
	public void update(HouseholdEntity householdEntity) {
		databaseRepositoryImpl.update(householdEntity);
		
	}
	
	@Override
	public HouseholdEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public HouseholdEntity findByCaseId(String caseId) {
		return databaseRepositoryImpl.findByKey(caseId,caseId, HouseholdEntity.class);
	}
	
	public List<HouseholdEntity> list() {
		//householdRepository.
		return null;
		
	}
}
