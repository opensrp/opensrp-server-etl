package org.opensrp.etl.data.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.BNFEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.BNFService;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class BNFDataConverterService implements DataConverterService {
	
	@Autowired
	private BNFEntity bnfEntity;
	
	@Autowired
	private BNFService bnfService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;

	public BNFDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		JSONArray bnfs = new JSONArray();
		bnfs = doc.getJSONArray("bnfVisit");

		for (int i = 0; i < bnfs.length(); i++) {
			JSONObject bnf = bnfs.getJSONObject(i);
			Class<BNFEntity> className = BNFEntity.class;
			Object object = bnfEntity;
			bnfEntity = (BNFEntity) dataConverter.convert(bnf, className, object);
			bnfEntity.setrelationalid(doc.getString("caseId"));
			try {
				bnfService.save(bnfEntity);
			}
			catch (Exception e) {
				exceptionService.generatedEntityAndSave(bnf, e.fillInStackTrace().toString(), "bnf");
			}
			
		}
	}
}
