package org.opensrp.etl.data.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ChildEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ChildService;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildDataConverterService implements DataConverterService {
	
	@Autowired
	private ChildEntity childEntity;
	
	@Autowired
	private ChildService childService;
	
	@Autowired
	private ExceptionService exceptionService;

	@Autowired
	private DataConverter dataConverter;

	public ChildDataConverterService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		JSONArray childArray = new JSONArray();
		childArray = doc.getJSONArray("child_vaccine");

		for (int i = 0; i < childArray.length(); i++) {
			JSONObject child = childArray.getJSONObject(i);
			Class<ChildEntity> className = ChildEntity.class;
			Object object = childEntity;
			childEntity = (ChildEntity) dataConverter.convert(child, className, object);
			childEntity.setrelationalid(doc.getString("caseId"));
			try {
				childService.save(childEntity);
			} catch (Exception e) {
			    exceptionService.generatedEntityAndSave(doc, e
	                    .fillInStackTrace().toString(), "child");
			}
		}
	}
}
