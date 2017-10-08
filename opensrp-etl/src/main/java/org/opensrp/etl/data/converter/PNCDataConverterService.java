package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.PNCEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.PNCService;
import org.springframework.beans.factory.annotation.Autowired;

public class PNCDataConverterService implements DataConverterService {
	
	@Autowired
	private PNCEntity pncEntity;
	
	@Autowired
	private PNCService pncService;
	
	public PNCDataConverterService() {
		
	}
	
	@Autowired
	public void setPNCEntity(PNCEntity pncEntity) {
		this.pncEntity = pncEntity;
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		
		try {
			JSONObject data = new JSONObject(doc.getString("data"));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		pncService.save(pncEntity);
	}
	
}
