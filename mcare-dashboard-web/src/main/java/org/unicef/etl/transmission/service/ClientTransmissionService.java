package org.unicef.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.etl.data.converter.ClientDataConverterService;
import org.unicef.etl.interfaces.TransmissionServices;

@Service
public class ClientTransmissionService implements TransmissionServices {
	
	@Autowired
	private ClientDataConverterService clientDataConverterService;
	
	public ClientTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		clientDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}
