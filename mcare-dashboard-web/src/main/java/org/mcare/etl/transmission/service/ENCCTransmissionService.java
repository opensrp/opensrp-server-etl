/**
 * 
 */
package org.mcare.etl.transmission.service;

import org.json.JSONObject;
import org.mcare.etl.data.converter.ENCCDataConverterService;
import org.mcare.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sohel
 */
public class ENCCTransmissionService implements TransmissionServices {
	
	@Autowired
	private ENCCDataConverterService enccDataConverterService;
	
	public ENCCTransmissionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertDataJsonToEntity(JSONObject doc) throws Exception {
		enccDataConverterService.convertToEntityAndSave(doc);
		
	}
	
}
