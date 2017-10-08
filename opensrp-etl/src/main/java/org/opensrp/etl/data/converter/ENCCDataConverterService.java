package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ENCCEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ENCCService;
import org.springframework.beans.factory.annotation.Autowired;

public class ENCCDataConverterService implements DataConverterService {
	
	@Autowired
	private ENCCEntity enccEntity;
	
	@Autowired
	private ENCCService enccService;
	
	public ENCCDataConverterService() {
		
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		
		try {
			JSONObject data = new JSONObject(doc.getString("data"));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		enccService.save(enccEntity);
	}
	
}
