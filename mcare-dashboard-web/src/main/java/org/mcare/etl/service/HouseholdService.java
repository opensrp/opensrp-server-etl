package org.mcare.etl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.mcare.params.builder.SearchBuilder;
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
			System.out.println("existingHouseholdEntity is null saving");
			databaseRepositoryImpl.save(householdEntity);
		} else {
			System.out.println("existingHouseholdEntity exists");
			if (delete(existingHouseholdEntity)) {
				System.out.println("delete successfull  now saving");
				databaseRepositoryImpl.save(householdEntity);
			}
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
		return databaseRepositoryImpl.findByKey(caseId, "caseId", HouseholdEntity.class);
	}
	
	public List<HouseholdEntity> list() {
		//householdRepository.
		return null;
		
	}
	
	@Transactional
	public List<Object> list(Integer offset, Integer maxResults, Class<?> entityClassName) {
		return databaseRepositoryImpl.list(offset, maxResults, entityClassName);
	}
	
	@Transactional
	public int count() {
		return databaseRepositoryImpl.count();
	}
	
	@Transactional
	public List<Object> search(SearchBuilder searchBuilder, Integer offset, Integer maxResults, Class<?> entityClassName) {
		return databaseRepositoryImpl.search(searchBuilder, offset, maxResults, entityClassName);
	}
}
