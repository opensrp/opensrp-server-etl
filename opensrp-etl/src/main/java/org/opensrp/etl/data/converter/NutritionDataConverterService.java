package org.opensrp.etl.data.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.NutritionEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;

public class NutritionDataConverterService implements DataConverterService {
	
	@Autowired
	private NutritionEntity nutritionEntity;
	
	@Autowired
	private NutritionService nutritionService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	public NutritionDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		JSONArray nutritions = new JSONArray();
		nutritions = doc.getJSONArray("nutrition");

		for (int i = 0; i < nutritions.length(); i++) {
			JSONObject nutrition = nutritions.getJSONObject(i);
			Class<NutritionEntity> className = NutritionEntity.class;
			Object object = nutritionEntity;
			nutritionEntity = (NutritionEntity) dataConverter.convert(nutrition, className, object);
			nutritionEntity.setRelationalid(doc.getString("caseId"));
			nutritionEntity.setDoc_id(doc.getString("_id"));
			try {
                nutritionService.save(nutritionEntity);
            } catch (Exception e) {
                exceptionService.generatedEntityAndSave(doc, e
                        .fillInStackTrace().toString(), "nutrition");
            }
			
		}
	}
}
