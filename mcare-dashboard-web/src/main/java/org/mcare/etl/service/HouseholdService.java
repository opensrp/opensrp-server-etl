package org.mcare.etl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdService implements RegisterService<HouseholdEntity> {

	private static final Logger logger = Logger.getLogger(HouseholdService.class);

	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;

	public HouseholdService() {
	}

	@Transactional
	@Override
	public void save(HouseholdEntity householdEntity) throws Exception {
		HouseholdEntity existingHouseholdEntity = findByCaseId(householdEntity.caseId);
		if (existingHouseholdEntity == null) {
			logger.debug("existingHouseholdEntity is null, saving");
			databaseRepositoryImpl.save(householdEntity);
		} else {
			if (delete(existingHouseholdEntity)) {
				logger.debug("existingHouseholdEntity deleted, now saving");
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

	@Transactional
	@Override
	public HouseholdEntity findById(int id) {
		return databaseRepositoryImpl.findById(id, "id", HouseholdEntity.class);
	}

	@Transactional
	@Override
	public HouseholdEntity findByCaseId(String caseId) {
		return databaseRepositoryImpl.findByKey(caseId, "caseId", HouseholdEntity.class);
	}

	public List<HouseholdEntity> list() {
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
	public <T> List<T> search(SearchBuilder searchBuilder, Integer offset, Integer maxResults, Class<?> entityClassName) {
		return databaseRepositoryImpl.search(searchBuilder, offset, maxResults, entityClassName);
	}

	@Transactional
	public int countBySearch(SearchBuilder searchBuilder, Class<?> entityClassName) {
		return databaseRepositoryImpl.countBySearch(searchBuilder, entityClassName);
	}
}
