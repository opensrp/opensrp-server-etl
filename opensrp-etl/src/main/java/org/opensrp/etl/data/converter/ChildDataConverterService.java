package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ChildEntity;
import org.opensrp.etl.entity.MotherEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ChildService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.MotherService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildDataConverterService implements DataConverterService {
	
	@Autowired
	private ChildEntity childEntity;
	
	@Autowired
	private ChildService childService;
	
	@Autowired
	private MotherService motherService;
	
	@Autowired
	private ChildToENCCConverter childToENCCConverter;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		
		try {
			JSONObject details = new JSONObject(doc.getString("details"));
			
			childEntity.setBirthDate(DateUtil.getDateFromString(details, "FWBNFDOB"));
			
			childEntity.setClientVersion(doc.getLong("clientVersion"));
			childEntity.setSubmissionTime(doc.getLong("SUBMISSIONDATE"));
			childEntity.setEnd(DateUtil.getDateTimeFromString(doc, "END"));
			childEntity.setStart(DateUtil.getDateTimeFromString(doc, "START"));
			childEntity.setToday(DateUtil.getDateFromString(doc, "TODAY"));
			childEntity.setRegistrationDate(DateUtil.getDateFromString(doc, "TODAY"));
			childEntity.setUserType(doc.getString("user_type"));
			childEntity.setCaseId(doc.getString("caseId"));
			childEntity.setInstanceId(doc.getString("INSTANCEID"));
			childEntity.setGps("");
			childEntity.setFirstName(details.getString("FWBNFCHILDNAME"));
			childEntity.setLastName("");
			childEntity.setProvider(doc.getString("PROVIDERID"));
			childEntity.setExternalUserId(details.getString("external_user_ID"));
			childEntity.setDivision("");
			childEntity.setCountry("");
			childEntity.setCurrentFormStatus("");
			if (doc.has("district"))
				childEntity.setDistrict(doc.getString("district"));
			if (doc.has("mouzaPara"))
				childEntity.setMauzaPara(doc.getString("mouzaPara"));
			if (doc.has("unit"))
				
				childEntity.setSubunit(doc.getString("unit"));
			if (doc.has("union"))
				childEntity.setUnion(doc.getString("union"));
			if (doc.has("upazilla"))
				childEntity.setUpazila(doc.getString("upazilla"));
			if (details.has("ward"))
				childEntity.setWard(details.getString("ward"));
			childEntity.setFWBNFCHLDVITSTS(details.getString("FWBNFCHLDVITSTS"));
			childEntity.setFWBNFNAME(details.getString("FWBNFNAME"));
			childEntity.setGender(details.getString("FWBNFGEN"));
			childEntity.setFWWOMFNAME(details.getString("FWWOMFNAME"));
			childEntity.setMotherWomAge(details.getString("mother_wom_age"));
			childEntity.setFWBNFCHILDNAME(details.getString("FWBNFCHILDNAME"));
			childEntity.setFWWOMBID(details.getString("FWWOMBID"));
			
			childEntity.setWBNFDOB(DateUtil.getDateFromString(details, "FWBNFDOB"));
			
			childEntity.setGOBHHID(details.getString("GOBHHID"));
			childEntity.setJIVITAHHID(details.getString("JiVitAHHID"));
			childEntity.setFWBNFNAMECHECK(details.getString("FWBNFNAMECHECK"));
			
			childEntity.setReceivedTime(DateUtil.getDateFromString(details, "received_time"));
			childEntity.setFWWOMNID(details.getString("FWWOMNID"));
			childEntity.setReferenceDate(DateUtil.getDateFromString(details, "referenceDate"));
			childEntity.setFWHUSNAME(details.getString("FWHUSNAME"));
			childEntity.setIsClosed(doc.getString("isClosed"));
			childEntity.setRelationalId(details.getString("relationalid"));
			MotherEntity mother = motherService.findByCaseId(details.getString("relationalid"));
			
			childService.save(childEntity);
			childToENCCConverter.enccVisitSave(doc);
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "child");
		}
		
	}
}
