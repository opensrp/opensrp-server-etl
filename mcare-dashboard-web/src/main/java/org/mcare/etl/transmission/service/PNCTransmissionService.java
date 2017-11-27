/**
 * 
 */
package org.mcare.etl.transmission.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.mcare.etl.data.converter.PNCDataConverterService;
import org.mcare.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sohel
 */
public class PNCTransmissionService implements TransmissionServices {
	
	@Autowired
	private PNCDataConverterService pncDataConverterService;
	
	public PNCTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws JSONException {
		
		pncDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}
