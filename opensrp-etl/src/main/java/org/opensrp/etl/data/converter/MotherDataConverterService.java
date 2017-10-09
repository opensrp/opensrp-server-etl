package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.MotherEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.MotherService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class MotherDataConverterService implements DataConverterService {
	
	@Autowired
	private MotherEntity motherEntity;
	
	@Autowired
	private MotherToANCConverter motherToANCConverter;
	
	@Autowired
	private MotherToPNCConverter motherToPNCConverter;
	
	@Autowired
	private MotherService motherService;
	
	public MotherDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		try {
			System.out.println("Class:MotherDataConverterService, Method:convertData");
			//? motherEntity.setBirthDate(doc.getString("FWBIRTHDATE"));
			
			motherEntity.setCaseId(doc.getString("caseId"));
			motherEntity.setClientVersion(doc.getLong("clientVersion"));
			//motherEntity.setCountry(doc.getString("FWWOMCOUNTRY"));
			motherEntity.setDistrict(doc.getString("FWWOMDISTRICT"));
			//motherEntity.setDivision(doc.getString("FWWOMDIVISION"));
			motherEntity.setDivision(doc.getString("FWWOMUPAZILLA"));
			
			//motherEntity.setExternalUserId(doc.getString("external_user_ID"));
			motherEntity.setFirstName(doc.getString("mother_first_name"));
			//motherEntity.setFormName(doc.getString("form_name"));
			
			motherEntity.setInstanceId(doc.getString("INSTANCEID"));
			// ? motherEntity.setLocationId(doc.getString("LOCATIONID"));
			motherEntity.setMauzaPara(doc.getString("mother_mauza"));
			motherEntity.setProvider(doc.getString("PROVIDERID"));
			motherEntity.setSubmissionTime(doc.getLong("SUBMISSIONDATE"));
			motherEntity.setSubunit(doc.getString("FWWOMSUBUNIT"));
			motherEntity.setUnion(doc.getString("FWWOMUNION"));
			motherEntity.setUpazila(doc.getString("FWWOMUPAZILLA"));
			motherEntity.setWard(doc.getString("FWWOMWARD"));
			motherEntity.setMotherGOBHHID(doc.getString("mother_gobhhid"));
			motherEntity.setMotherJIVIHID(doc.getString("mother_jivhhid"));
			motherEntity.setMotherHusname(doc.getString("mother_husname"));
			motherEntity.setMotherWomNID(doc.getString("mother_wom_nid"));
			motherEntity.setMotherWomBID(doc.getString("mother_wom_bid"));
			motherEntity.setMotherWomAge(doc.getString("mother_wom_age"));
			
			JSONObject details = new JSONObject(doc.getString("details"));
			motherEntity.setMotherValid(details.getString("mother_valid"));
			motherEntity.setFWVG(doc.getString("FWVG"));
			motherEntity.setFWHRP(doc.getString("FWHRP"));
			motherEntity.setFWHR_PSR(doc.getString("FWHR_PSR"));
			motherEntity.setFWFLAGVALUE(doc.getString("FWFLAGVALUE"));
			motherEntity.setFWSORTVALUE(doc.getString("FWSORTVALUE"));
			// ? motherEntity.setMotherWomLMP(doc.getString("mother_wom_lmp"));
			motherEntity.setRelationalId(doc.getString("relationalid"));
			motherEntity.setIsClosed(doc.getString("isClosed"));
			
			motherEntity.setStart(DateUtil.getDateTimeFromString(doc.getString("START")));
			motherEntity.setEnd(DateUtil.getDateTimeFromString(doc.getString("END")));
			motherEntity.setToday(DateUtil.getDateFromString(doc.getString("TODAY")));
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		motherService.save(motherEntity);
		motherToANCConverter.ancVisitSave(doc);
		motherToPNCConverter.pncVisitSave(doc);
		
	}
	
}
