package org.opensrp.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.data.converter.BNFDataConverterService;
import org.opensrp.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

public class BNFTransmissionService implements TransmissionServices {
	
	@Autowired
	private BNFDataConverterService bnfDataConverterService;
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		bnfDataConverterService.convertToEntityAndSave(doc);
	}
	
}
