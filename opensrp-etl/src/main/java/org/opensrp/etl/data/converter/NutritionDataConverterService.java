package org.opensrp.etl.data.converter;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.NutritionEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;

public class NutritionDataConverterService implements DataConverterService {
	
	private static final Logger logger = Logger.getLogger(NutritionDataConverterService.class);
	
	@Autowired
	private NutritionEntity nutritionEntity;
	
	@Autowired
	private NutritionService nutritionService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	public NutritionDataConverterService() {
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		JSONArray nutritions = new JSONArray();
		nutritions = doc.getJSONArray("nutrition");
		
		for (int i = 0; i < nutritions.length(); i++) {
			JSONObject nutrition = nutritions.getJSONObject(i);
			Class<NutritionEntity> className = NutritionEntity.class;
			Object object = new NutritionEntity();
			nutritionEntity = (NutritionEntity) dataConverter.convert(nutrition, className, object);
			
			try {
				nutritionEntity.setrelationalid(doc.getString("caseId"));
				nutritionEntity.setDoc_id(doc.getString("_id"));
				nutritionEntity.setINSTANCEID(doc.getString("INSTANCEID"));
				nutritionService.save(nutritionEntity);
			}
			catch (Exception e) {
				logger.error(e);
				exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "nutrition");
			}
			
		}
	}
}
