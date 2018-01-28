package org.opensrp.etl.data.converter;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.PSRFEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.PSRFService;
import org.springframework.beans.factory.annotation.Autowired;

public class PSRFDataConverterService implements DataConverterService {
	
	private static final Logger logger = Logger.getLogger(PSRFDataConverterService.class);
	
	@Autowired
	private PSRFEntity psrfEntity;
	
	@Autowired
	private PSRFService psrfService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		JSONArray psrfs = new JSONArray();
		psrfs = doc.getJSONArray("elco_Followup");
		
		for (int i = 0; i < psrfs.length(); i++) {
			JSONObject psrf = psrfs.getJSONObject(i);
			Class<PSRFEntity> className = PSRFEntity.class;
			Object object = new PSRFEntity();
			psrfEntity = (PSRFEntity) dataConverter.convert(psrf, className, object);
			
			try {
				psrfEntity.setrelationalid(doc.getString("caseId"));
				psrfEntity.set_id(doc.getString("_id"));
				psrfEntity.setINSTANCEID(doc.getString("INSTANCEID"));
				psrfService.save(psrfEntity);
			}
			catch (Exception e) {
				logger.error(e);
				exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "psrf");
			}
		}
	}
}
