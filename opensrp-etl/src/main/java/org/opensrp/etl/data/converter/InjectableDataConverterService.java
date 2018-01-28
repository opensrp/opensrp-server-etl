package org.opensrp.etl.data.converter;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.InjectableEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.InjectableService;
import org.springframework.beans.factory.annotation.Autowired;

public class InjectableDataConverterService implements DataConverterService {
	
	private static final Logger logger = Logger.getLogger(InjectableDataConverterService.class);
	
	@Autowired
	private InjectableEntity injectableEntity;
	
	@Autowired
	private InjectableService injectableService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	public InjectableDataConverterService() {
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		JSONArray injectables = new JSONArray();
		injectables = doc.getJSONArray("injecTables");
		
		for (int i = 0; i < injectables.length(); i++) {
			JSONObject injectable = injectables.getJSONObject(i);
			Class<InjectableEntity> className = InjectableEntity.class;
			Object object = new InjectableEntity();
			injectableEntity = (InjectableEntity) dataConverter.convert(injectable, className, object);
			
			try {
				injectableEntity.setrelationalid(doc.getString("caseId"));
				injectableEntity.set_id(doc.getString("_id"));
				injectableEntity.setINSTANCEID(doc.getString("INSTANCEID"));
				injectableService.save(injectableEntity);
			}
			catch (Exception e) {
				logger.error(e);
				exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "injectable");
			}
			
		}
		
	}
	
}
