package org.opensrp.etl.data.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.BNFEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.BNFService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class BNFDataConverterService implements DataConverterService {
	
	@Autowired
	private BNFEntity bnfEntity;
	
	@Autowired
	private BNFService bnfService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	public BNFDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject mother) throws JSONException {
		JSONArray bnfs = new JSONArray();
		bnfs = mother.getJSONArray("bnfVisitDetails");
		for (int i = 0; i < bnfs.length(); i++) {
			JSONObject doc = bnfs.getJSONObject(i);
			try {
				
				bnfEntity.setFWBNFDATE(DateUtil.getDateFromString(doc, "FWBNFDATE"));
				bnfEntity.setBnf_current_formStatus(doc.getString("bnf_current_formStatus"));
				
				bnfEntity.setFWCONFIRMATION(doc.getString("FWCONFIRMATION"));
				
				bnfEntity.setFWGESTATIONALAGE(doc.getString("FWGESTATIONALAGE"));
				
				bnfEntity.setFWEDD(doc.getString("FWEDD"));
				
				bnfEntity.setFWBNFSTS(doc.getString("FWBNFSTS"));
				
				bnfEntity.setFWDISPLAYTEXT(doc.getString("FWDISPLAYTEXT1"));
				
				bnfEntity.setFWBNFWOMVITSTS(doc.getString("FWBNFWOMVITSTS"));
				
				bnfEntity.setFWBNFDTOO(DateUtil.getDateFromString(doc, "FWBNFDTOO"));
				
				bnfEntity.setFWBNFLB(doc.getString("FWBNFLB"));
				
				bnfEntity.setFWBNFSMSRSN(doc.getString("FWBNFSMSRSN"));
				if (mother.has("user_type"))
					bnfEntity.setUser_type(mother.getString("user_type"));
				if (mother.has("external_user_ID"))
					bnfEntity.setExternal_user_ID(mother.getString("external_user_ID"));
				
				bnfEntity.setReceived_time(DateUtil.getDateTimeFromString(doc, "received_time"));
				bnfEntity.setClientVersion(Long.parseLong(doc.getString("clientVersion")));
				bnfEntity.setTimeStamp(Long.parseLong(doc.getString("timeStamp")));
				bnfEntity.setExternal_user_ID(doc.getString("external_user_ID"));
				bnfEntity.setUser_type(doc.getString("user_type"));
				bnfEntity.setRelationalId(mother.getString("caseId"));
				bnfEntity.setProvider(mother.getString("PROVIDERID"));
				bnfEntity.setToday(DateUtil.getDateFromString(mother, "TODAY"));
				bnfEntity.setStart(DateUtil.getDateTimeFromString(mother, "START"));
				bnfEntity.setEnd(DateUtil.getDateTimeFromString(mother, "END"));
				
				bnfService.save(bnfEntity);
			}
			catch (Exception e) {
				exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "bnf");
			}
			
		}
	}
}
