package org.opensrp.etl.data.converter;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.BNFEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.BNFService;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class BNFDataConverterService implements DataConverterService {
	
	private static final Logger logger = Logger.getLogger(BNFDataConverterService.class);
	
	@Autowired
	private BNFEntity bnfEntity;
	
	@Autowired
	private BNFService bnfService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	public BNFDataConverterService() {
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		JSONArray bnfs = new JSONArray();
		bnfs = doc.getJSONArray("bnfVisit");
		
		for (int i = 0; i < bnfs.length(); i++) {
			JSONObject bnf = bnfs.getJSONObject(i);
			Class<BNFEntity> className = BNFEntity.class;
			Object object = new BNFEntity();
			bnfEntity = (BNFEntity) dataConverter.convert(bnf, className, object);
			
			try {
				bnfEntity.setrelationalid(doc.getString("caseId"));
				bnfEntity.set_id(doc.getString("_id"));
				bnfEntity.setINSTANCEID(doc.getString("INSTANCEID"));
				bnfService.save(bnfEntity);
			}
			catch (Exception e) {
				logger.error(e);
				exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "bnf");
			}
			
		}
	}
}
