package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ANCEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ANCService;
import org.springframework.beans.factory.annotation.Autowired;

public class ANCDataConverterService implements DataConverterService {
	
	@Autowired
	private ANCService ancService;
	
	@Autowired
	private ANCEntity ancEntity;
	
	public ANCDataConverterService() {
		
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		try {
			JSONObject data = new JSONObject(doc.getString("data"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		ancService.save(ancEntity);
	}
	
}
