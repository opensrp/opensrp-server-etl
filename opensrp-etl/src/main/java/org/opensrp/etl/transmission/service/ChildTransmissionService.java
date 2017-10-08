package org.opensrp.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.data.converter.ChildDataConverterService;
import org.opensrp.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildTransmissionService implements TransmissionServices {
	
	@Autowired
	private ChildDataConverterService childDataConverterService;
	
	public ChildTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		childDataConverterService.convertToEntityAndSave(doc);
	}
	
}
