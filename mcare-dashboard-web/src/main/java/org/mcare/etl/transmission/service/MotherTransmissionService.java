package org.mcare.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.mcare.etl.data.converter.MotherDataConverterService;
import org.mcare.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MotherTransmissionService implements TransmissionServices {
	
	@Autowired
	private MotherDataConverterService motherDataConverterService;
	
	public MotherTransmissionService(){
		
	}
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		
		motherDataConverterService.convertToEntityAndSave(doc);
	}
	
}
