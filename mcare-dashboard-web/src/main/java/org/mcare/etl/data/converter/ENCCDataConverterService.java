package org.mcare.etl.data.converter;

import org.json.JSONObject;
import org.mcare.etl.entity.ENCCEntity;
import org.mcare.etl.interfaces.DataConverterService;
import org.mcare.etl.service.ENCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ENCCDataConverterService implements DataConverterService {
	
	@Autowired
	private ENCCEntity enccEntity;
	
	@Autowired
	private ENCCService enccService;
	
	public ENCCDataConverterService() {
		
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws Exception {
		
		try {
			JSONObject data = new JSONObject(doc.getString("data"));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		enccService.save(enccEntity);
	}
	
}
