package org.opensrp.etl.data.converter;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.DeathRegEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.DeathRegService;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeathRegDataConverterService implements DataConverterService {
	
	private static final Logger logger = Logger.getLogger(DeathRegDataConverterService.class);
	
	@Autowired
	private DeathRegEntity deathRegEntity;
	
	@Autowired
	private DeathRegService deathRegService;
	
	@Autowired
	private DataConverter dataConverter;
	
	@Autowired
	private ExceptionService exceptionService;
	
	public DeathRegDataConverterService() {
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		JSONObject deathReg = doc.getJSONObject("DeathReg");
		
		if (deathReg.length() != 0) {
			Class<DeathRegEntity> className = DeathRegEntity.class;
			Object object = new DeathRegEntity();
			deathRegEntity = (DeathRegEntity) dataConverter.convert(deathReg, className, object);
			
			try {
				deathRegEntity.setrelationalid(doc.getString("caseId"));
				deathRegEntity.set_id(doc.getString("_id"));
				deathRegEntity.setINSTANCEID(doc.getString("INSTANCEID"));
				deathRegService.save(deathRegEntity);
			}
			catch (Exception e) {
				logger.error(e);
				exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "deathReg");
			}
		}
		
	}
	
}
