package org.opensrp.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.data.converter.MotherDataConverterService;
import org.opensrp.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

public class MotherTransmissionService implements TransmissionServices {
	
	@Autowired
	private MotherDataConverterService motherDataConverterService;
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		
		motherDataConverterService.convertToEntityAndSave(doc);
	}
	
}
