package org.opensrp.etl.data.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.InjectableEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.InjectableService;
import org.springframework.beans.factory.annotation.Autowired;

public class InjectableDataConverterService implements DataConverterService{
	
	@Autowired
	private InjectableEntity injectableEntity;
	
	@Autowired
	private InjectableService injectableService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	public InjectableDataConverterService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		JSONArray injectables = new JSONArray();
		injectables = doc.getJSONArray("injecTables");
		
		System.err.println("injecTables size: " + injectables.length());

		for (int i = 0; i < injectables.length(); i++) {
			JSONObject injectable = injectables.getJSONObject(i);
			Class<InjectableEntity> className = InjectableEntity.class;
			Object object = injectableEntity;
			injectableEntity = (InjectableEntity) dataConverter.convert(injectable, className, object);
			injectableEntity.setrelationalid(doc.getString("caseId"));
			try {
				injectableService.save(injectableEntity);
			}
			catch (Exception e) {
				System.err.println("Exception: " + e);
				e.printStackTrace();
			}
			
		}
		
	}

}
