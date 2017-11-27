package org.mcare.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.mcare.etl.data.converter.ActionDataConverterService;
import org.mcare.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
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
