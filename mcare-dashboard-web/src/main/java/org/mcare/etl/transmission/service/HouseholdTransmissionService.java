package org.mcare.etl.transmission.service;

import org.json.JSONObject;
import org.mcare.etl.data.converter.HouseholdDataConverterService;
import org.mcare.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdTransmissionService implements TransmissionServices {
	
	@Autowired
	private HouseholdDataConverterService householdDataConverterService;
	
	public HouseholdTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws Exception {
		householdDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}
