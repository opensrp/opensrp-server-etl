package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.NutritionEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NutritionService implements RegisterService<NutritionEntity> {
	
	@Autowired
	private NutritionRepository nutritionRepository;
	
	public NutritionService() {
		
	}
	
	@Transactional
	@Override
	public void save(NutritionEntity nutritionEntity) {
		NutritionEntity existingMotherEntity = findByCaseIdAndServerVersion(nutritionEntity.getRelationalid(),
		    nutritionEntity.getServerVersion());
		if (existingMotherEntity == null) {
			nutritionRepository.save(nutritionEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(NutritionEntity nutritionEntity) {
		return nutritionRepository.delete(nutritionEntity);
		
	}
	
	@Transactional
	@Override
	public void update(NutritionEntity nutritionEntity) {
		nutritionRepository.update(nutritionEntity);
		
	}
	
	@Override
	public NutritionEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public NutritionEntity findByCaseIdAndServerVersion(String relationalId, Long serverVersion) {
		return nutritionRepository.findByCaseIdAndServerVersion(relationalId, serverVersion);
	}
	
	@Override
	public NutritionEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
