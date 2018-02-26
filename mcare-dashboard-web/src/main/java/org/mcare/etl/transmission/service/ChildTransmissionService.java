package org.mcare.etl.transmission.service;

import org.json.JSONObject;
import org.mcare.etl.data.converter.ChildDataConverterService;
import org.mcare.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildTransmissionService implements TransmissionServices {
	
	@Autowired
	private ChildDataConverterService childDataConverterService;
	
	public ChildTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws Exception {
		childDataConverterService.convertToEntityAndSave(doc);
	}
	
}
