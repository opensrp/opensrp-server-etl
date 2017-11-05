/**
 * 
 */
package org.opensrp.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.data.converter.ANCDataConverterService;
import org.opensrp.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sohel
 */
public class ANCTransmissionService implements TransmissionServices {
	
	@Autowired
	private ANCDataConverterService ancDataConverterService;
	
	public ANCTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		ancDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}
