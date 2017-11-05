package org.opensrp.etl.transmission.service;

import org.json.JSONObject;
import org.opensrp.etl.data.converter.HouseholdDataConverterService;
import org.opensrp.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

public class HouseholdTransmissionService implements TransmissionServices {
	
	@Autowired
	private HouseholdDataConverterService householdDataConverterService;
	
	public HouseholdTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) {
		householdDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}
