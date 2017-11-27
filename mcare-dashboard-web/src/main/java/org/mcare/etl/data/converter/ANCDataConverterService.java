package org.mcare.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.mcare.etl.entity.ANCEntity;
import org.mcare.etl.interfaces.DataConverterService;
import org.mcare.etl.service.ANCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
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
