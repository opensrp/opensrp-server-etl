package org.opensrp.etl.service;

import static org.opensrp.etl.util.AllConstants.CASE_ID;

import java.util.List;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.HouseholdEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdService implements RegisterService<HouseholdEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public HouseholdService() {
	}
	
	@Transactional
	@Override
	public void save(HouseholdEntity householdEntity) {
		
		HouseholdEntity existingHouseholdEntity = findByCaseId(householdEntity.getCaseId());
		if (existingHouseholdEntity == null) {
			commonDatabaseRepository.save(householdEntity);
		} else {
			if (delete(existingHouseholdEntity))
				commonDatabaseRepository.save(householdEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(HouseholdEntity householdEntity) {
		return commonDatabaseRepository.delete(householdEntity);
	}
	
	@Transactional
	@Override
	public void update(HouseholdEntity householdEntity) {
		commonDatabaseRepository.update(householdEntity);
	}
	
	@Override
	public HouseholdEntity findById(int id) {
		return null;
	}
	
	@Transactional
	@Override
	public HouseholdEntity findByCaseId(String caseId) {
		return commonDatabaseRepository.findByKey(caseId, CASE_ID, HouseholdEntity.class);
	}
	
	public List<HouseholdEntity> list() {
		return null;
	}
}
