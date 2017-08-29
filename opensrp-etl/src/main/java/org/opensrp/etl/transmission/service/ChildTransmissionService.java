package org.opensrp.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.interfaces.TransmissionServices;

public class ChildTransmissionService implements TransmissionServices {
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		System.out.println("Class:ChildTransmissionService, method:sentDataToConvert");
		//return ChildDataConverterService.getInstance().convertData(doc, childRepository, childService);
	}
	
}
