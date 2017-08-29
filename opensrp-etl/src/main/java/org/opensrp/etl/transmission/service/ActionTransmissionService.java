package org.opensrp.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.data.converter.ActionDataConverterService;
import org.opensrp.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionTransmissionService implements TransmissionServices {
	
	@Autowired
	private ActionDataConverterService actionDataConverterService;
	
	public ActionTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		actionDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}
