package org.mcare.etl.transmission.service;

import org.json.JSONObject;
import org.mcare.etl.data.converter.ElcoDataConverterService;
import org.mcare.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

public class ElcoTransmissionService implements TransmissionServices {
	
	@Autowired
	private ElcoDataConverterService elcoDataConverterService;
	
	public ElcoTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws Exception {
		elcoDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}