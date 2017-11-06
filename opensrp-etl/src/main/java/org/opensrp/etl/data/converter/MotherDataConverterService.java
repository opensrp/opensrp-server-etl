package org.opensrp.etl.data.converter;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.MotherEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
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
	
	@Autowired
	private BNFDataConverterService bnfDataConverterService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	public MotherDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		String caseID = "";
		try {
			caseID = doc.getString("caseId");
			JSONObject details = new JSONObject(doc.getString("details"));
			motherEntity.setCaseId(doc.getString("caseId"));
			motherEntity.setClientVersion(doc.getLong("clientVersion"));
			motherEntity.setDistrict(doc.getString("FWWOMDISTRICT"));
			motherEntity.setDivision(doc.getString("FWWOMUPAZILLA"));
			
			motherEntity.setCountry("BANGLADESH");
			motherEntity.setCurrentFormStatus("");
			if (doc.has("external_user_ID")) {
				motherEntity.setExternalUserId(doc.getString("external_user_ID"));
			} else {
				motherEntity.setExternalUserId("");
			}
			
			motherEntity.setGender("female");
			motherEntity.setGps("");
			motherEntity.setLastName("");
			motherEntity.setFirstName(doc.getString("mother_first_name"));
			motherEntity.setInstanceId(doc.getString("INSTANCEID"));
			motherEntity.setMauzaPara(doc.getString("mother_mauza"));
			motherEntity.setProvider(doc.getString("PROVIDERID"));
			motherEntity.setSubmissionTime(doc.getLong("SUBMISSIONDATE"));
			if (doc.has("FWWOMSUBUNIT"))
				motherEntity.setSubunit(doc.getString("FWWOMSUBUNIT"));
			if (doc.has("FWWOMUNION"))
				motherEntity.setUnion(doc.getString("FWWOMUNION"));
			motherEntity.setUpazila(doc.getString("FWWOMUPAZILLA"));
			if (doc.has("FWWOMWARD"))
				motherEntity.setWard(doc.getString("FWWOMWARD"));
			motherEntity.setMotherGOBHHID(doc.getString("mother_gobhhid"));
			motherEntity.setMotherJIVIHID(doc.getString("mother_jivhhid"));
			motherEntity.setMotherHusname(doc.getString("mother_husname"));
			motherEntity.setMotherWomNID(doc.getString("mother_wom_nid"));
			motherEntity.setMotherWomBID(doc.getString("mother_wom_bid"));
			motherEntity.setMotherWomAge(doc.getString("mother_wom_age"));
			motherEntity.setMotherValid(details.getString("mother_valid"));
			motherEntity.setFWVG(doc.getString("FWVG"));
			motherEntity.setFWHRP(doc.getString("FWHRP"));
			motherEntity.setFWHR_PSR(doc.getString("FWHR_PSR"));
			motherEntity.setFWFLAGVALUE(doc.getString("FWFLAGVALUE"));
			motherEntity.setFWSORTVALUE(doc.getString("FWSORTVALUE"));
			motherEntity.setMotherWomLMP(DateUtil.getDateFromString(details, "LMP"));
			motherEntity.setBirthDate(DateUtil.getDateFromString(details, "birthDate"));
			motherEntity.setRelationalId(doc.getString("relationalid"));
			motherEntity.setIsClosed(doc.getString("isClosed"));
			
			motherEntity.setReceivedTime(DateUtil.getDateTimeFromString(details, "received_time"));
			
			motherEntity.setStart(DateUtil.getDateTimeFromString(doc, "START"));
			
			motherEntity.setEnd(DateUtil.getDateTimeFromString(doc, "END"));
			
			motherEntity.setToday(DateUtil.getDateFromString(doc, "TODAY"));
			motherEntity.setRegistrationDate(DateUtil.getDateFromString(doc, "TODAY"));
			
			if (doc.has("user_type")) {
				motherEntity.setUserType(doc.getString("user_type"));
			} else {
				motherEntity.setUserType("");
			}
			motherService.save(motherEntity);
			
			bnfDataConverterService.convertToEntityAndSave(doc);
			motherToANCConverter.ancVisitSave(doc);
			motherToPNCConverter.pncVisitSave(doc);
		}
		catch (JSONException e) {
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "mother");
		}
		catch (ParseException e) {
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "mother");
		}
		
	}
}
