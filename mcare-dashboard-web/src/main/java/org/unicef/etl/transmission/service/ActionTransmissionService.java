package org.unicef.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.etl.data.converter.ActionDataConverterService;
import org.unicef.etl.interfaces.TransmissionServices;
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
