/**
 * 
 */
package org.mcare.etl.transmission.service;

import org.json.JSONObject;
import org.mcare.etl.data.converter.PSRFDataConverterService;
import org.mcare.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sohel
 */
public class PSRFTransmissionService implements TransmissionServices {
	
	@Autowired
	private PSRFDataConverterService psrfDataConverterService;
	
	public PSRFTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws Exception {
		psrfDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}
