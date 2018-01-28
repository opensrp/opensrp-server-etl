package org.opensrp.etl.data.converter;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ChildEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ChildService;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildDataConverterService implements DataConverterService {
	
	private static final Logger logger = Logger.getLogger(ChildDataConverterService.class);
	
	@Autowired
	private ChildEntity childEntity;
	
	@Autowired
	private ChildService childService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	public ChildDataConverterService() {
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		JSONArray childArray = new JSONArray();
		childArray = doc.getJSONArray("child_vaccine");
		
		for (int i = 0; i < childArray.length(); i++) {
			JSONObject child = childArray.getJSONObject(i);
			Class<ChildEntity> className = ChildEntity.class;
			Object object = new ChildEntity();
			childEntity = (ChildEntity) dataConverter.convert(child, className, object);
			
			try {
				childEntity.setrelationalid(doc.getString("caseId"));
				childEntity.set_id(doc.getString("_id"));
				childEntity.setINSTANCEID(doc.getString("INSTANCEID"));
				childService.save(childEntity);
			}
			catch (Exception e) {
				logger.error(e);
				exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "child");
			}
		}
	}
}
