package org.unicef.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.etl.data.converter.EventDataConverterService;
import org.unicef.etl.interfaces.TransmissionServices;

@Service
public class EventTransmissionService implements TransmissionServices {
	
	@Autowired
	private EventDataConverterService eventDataConverterService;
	
	public EventTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		eventDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}
