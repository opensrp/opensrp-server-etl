package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.NutritionEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NutritionService implements RegisterService<NutritionEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public NutritionService() {
	}
	
	@Transactional
	@Override
	public void save(NutritionEntity nutritionEntity) {
		NutritionEntity existingMotherEntity = findByCaseIdAndServerVersion(nutritionEntity.getRelationalid(),
		    nutritionEntity.getServerVersion());
		if (existingMotherEntity == null) {
			commonDatabaseRepository.save(nutritionEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(NutritionEntity nutritionEntity) {
		return commonDatabaseRepository.delete(nutritionEntity);
	}
	
	@Transactional
	@Override
	public void update(NutritionEntity nutritionEntity) {
		commonDatabaseRepository.update(nutritionEntity);
	}
	
	@Override
	public NutritionEntity findById(int id) {
		return null;
	}
	
	@Override
	public NutritionEntity findByCaseId(String caseId) {
		return null;
	}
	
	@Transactional
	public NutritionEntity findByCaseIdAndServerVersion(String relationalId, Long serverVersion) {
		return commonDatabaseRepository.findByRelationalIdAndServerVersion(relationalId, serverVersion,
		    NutritionEntity.class);
	}
}
