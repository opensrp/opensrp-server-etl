package org.opensrp.etl.data.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.PSRFEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.PSRFService;
import org.springframework.beans.factory.annotation.Autowired;

public class PSRFDataConverterService implements DataConverterService {

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
			Object object = psrfEntity;
			psrfEntity = (PSRFEntity) dataConverter.convert(psrf, className, object);		
			psrfEntity.setRelationalid(doc.getString("caseId"));
			try {
				psrfService.save(psrfEntity);
			} catch (Exception e) {
			    exceptionService.generatedEntityAndSaveForAction(doc, e
                        .fillInStackTrace().toString(), "psrf");
			}
		}
	}
}
