package org.opensrp.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.data.converter.MemberDataConverterService;
import org.opensrp.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberTransmissionService implements TransmissionServices {
	
	@Autowired
	private MemberDataConverterService memberDataConverterService;
	
	public MemberTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		
		memberDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}
