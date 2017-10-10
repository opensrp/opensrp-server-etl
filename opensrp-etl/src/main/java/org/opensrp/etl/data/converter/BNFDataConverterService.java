package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.BNFEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.BNFService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class BNFDataConverterService implements DataConverterService {
	
	@Autowired
	private BNFEntity bnfEntity;
	
	@Autowired
	private BNFService bnfService;
	
	public BNFDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		
		bnfEntity.setFWBNFDATE(DateUtil.getDateFromString(doc.getString("FWBNFDATE")));
		
		bnfEntity.setBnf_current_formStatus(doc.getString("bnf_current_formStatus"));
		
		bnfEntity.setFWCONFIRMATION(doc.getString("FWCONFIRMATION"));
		
		bnfEntity.setFWGESTATIONALAGE(doc.getString("FWGESTATIONALAGE"));
		
		bnfEntity.setFWEDD(DateUtil.getDateFromString(doc.getString("FWEDD")));
		
		bnfEntity.setFWBNFSTS(doc.getString("FWBNFSTS"));
		
		bnfEntity.setFWDISPLAYTEXT(doc.getString("FWDISPLAYTEXT"));
		
		bnfEntity.setFWBNFWOMVITSTS(doc.getString("FWBNFWOMVITSTS"));
		
		bnfEntity.setFWBNFDTOO(DateUtil.getDateFromString(doc.getString("FWBNFDTOO")));
		
		bnfEntity.setFWBNFLB(doc.getString("FWBNFLB"));
		
		bnfEntity.setFWBNFSMSRSN(doc.getString("FWBNFSMSRSN"));
		
		bnfEntity.setUser_type(doc.getString("user_type"));
		
		bnfEntity.setExternal_user_ID(doc.getString("external_user_ID"));
		
		bnfEntity.setReceived_time(doc.getString("received_time"));
		
		bnfEntity.setClientVersion(Long.parseLong(doc.getString("clientVersion")));
		
		bnfEntity.setServerVersion(Long.parseLong(doc.getString("serverVersion")));
		
		bnfEntity.setRelationalid(doc.getString("relationalid"));
		
		bnfService.save(bnfEntity);
	}
	
}
