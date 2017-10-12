package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ElcoEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ElcoService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class ElcoDataConverterService implements DataConverterService {
	
	@Autowired
	private ElcoEntity elcoEntity;
	
	@Autowired
	private ElcoService elcoService;
	
	@Autowired
	private PSRFDataConverterService psrfDataConverterService;
	
	public ElcoDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		String caseID = "";
		try {
			caseID = doc.getString("caseId");
			JSONObject details = new JSONObject(doc.getString("details"));
			elcoEntity.setBirthDate(DateUtil.getDateFromString(doc.getString("FWBIRTHDATE")));
			elcoEntity.setCaseId(doc.getString("caseId"));
			elcoEntity.setClientVersion(doc.getLong("clientVersion"));
			elcoEntity.setCountry(doc.getString("FWWOMCOUNTRY"));
			elcoEntity.setDistrict(doc.getString("FWWOMDISTRICT"));
			elcoEntity.setDivision(doc.getString("FWWOMDIVISION"));
			elcoEntity.setExternalUserId(doc.getString("external_user_ID"));
			elcoEntity.setFirstName(doc.getString("FWWOMFNAME"));
			elcoEntity.setGender(doc.getString("FWGENDER"));
			elcoEntity.setGOBHHID(doc.getString("GOBHHID"));
			elcoEntity.setGps(doc.getString("FWWOMGPS"));
			elcoEntity.setInstanceId(doc.getString("INSTANCEID"));
			elcoEntity.setJiVitAHHID(doc.getString("JiVitAHHID"));
			elcoEntity.setLastName(doc.getString("FWWOMLNAME"));
			elcoEntity.setMauzaPara(doc.getString("FWWOMMAUZA_PARA"));
			elcoEntity.setProvider(doc.getString("PROVIDERID"));
			elcoEntity.setRegistrationDate(DateUtil.getDateFromString(doc.getString("WomanREGDATE")));
			elcoEntity.setSubmissionTime(doc.getLong("SUBMISSIONDATE"));
			elcoEntity.setSubunit(doc.getString("FWWOMSUBUNIT"));
			elcoEntity.setStart(DateUtil.getDateTimeFromString(details.getString("start")));
			elcoEntity.setEnd(DateUtil.getDateTimeFromString(details.getString("end")));
			elcoEntity.setToday(DateUtil.getDateFromString(details.getString("today")));
			elcoEntity.setUnion(doc.getString("FWWOMUNION"));
			elcoEntity.setUpazila(doc.getString("FWWOMUPAZILLA"));
			elcoEntity.setUserType(doc.getString("user_type"));
			elcoEntity.setWard(doc.getString("FWWOMWARD"));
			if (doc.has("FWCWOMSTRMEN"))
				elcoEntity.setFWCWOMSTRMEN(doc.getString("FWCWOMSTRMEN"));
			if (doc.has("FWCWOMSTER"))
				elcoEntity.setFWCWOMSTER(doc.getString("FWCWOMSTER"));
			if (doc.has("FWCWOMHUSALV"))
				elcoEntity.setFWCWOMHUSALV(doc.getString("FWCWOMHUSALV"));
			if (doc.has("FWCWOMHUSLIV"))
				elcoEntity.setFWCWOMHUSLIV(doc.getString("FWCWOMHUSLIV"));
			if (doc.has("FWCWOMHUSSTR"))
				elcoEntity.setFWCWOMHUSSTR(doc.getString("FWCWOMHUSSTR"));
			if (doc.has("isClosed"))
				elcoEntity.setClosed(doc.getString("isClosed"));
			if (doc.has("FWCENDATE"))
				elcoEntity.setFWCENDATE(DateUtil.getDateFromString(doc.getString("FWCENDATE")));
			if (doc.has("FWCENSTAT"))
				elcoEntity.setFWCENSTAT(doc.getString("FWCENSTAT"));
			if (doc.has("FWWOMANYID"))
				elcoEntity.setFWWOMANYID(doc.getString("FWWOMANYID"));
			if (doc.has("FWWOMNID"))
				elcoEntity.setFWWOMNID(doc.getString("FWWOMNID"));
			if (doc.has("FWWOMRETYPENID"))
				elcoEntity.setFWWOMRETYPENID(doc.getString("FWWOMRETYPENID"));
			if (doc.has("FWWOMRETYPENID_CONCEPT"))
				elcoEntity.setFWWOMRETYPENID_CONCEPT(doc.getString("FWWOMRETYPENID_CONCEPT"));
			if (doc.has("FWWOMBID"))
				elcoEntity.setFWWOMBID(doc.getString("FWWOMBID"));
			if (doc.has("FWWOMRETYPEBID"))
				elcoEntity.setFWWOMRETYPEBID(doc.getString("FWWOMRETYPEBID"));
			if (doc.has("FWWOMRETYPEBID_CONCEPT"))
				elcoEntity.setFWWOMRETYPEBID_CONCEPT(doc.getString("FWWOMRETYPEBID_CONCEPT"));
			elcoEntity.setFWHUSNAME(doc.getString("FWHUSNAME"));
			elcoEntity.setFWWOMAGE(doc.getString("FWWOMAGE"));
			//elcoEntity.setFWDISPLAYAGE(doc.getString("FWDISPLAYAGE"));
			//elcoEntity.setFWWOMSTRMEN(doc.getString("FWWOMSTRMEN"));
			//elcoEntity.setFWWOMHUSALV(doc.getString("FWWOMHUSALV"));
			//elcoEntity.setFWWOMHUSSTR(doc.getString("FWWOMHUSSTR"));
			//elcoEntity.setFWWOMHUSLIV(doc.getString("FWWOMHUSLIV"));
			elcoEntity.setFWELIGIBLE(doc.getString("FWELIGIBLE"));
			elcoEntity.setFWELIGIBLE2(doc.getString("FWELIGIBLE2"));
			elcoEntity.setFWWOMGOBHHID(doc.getString("FWWOMGOBHHID"));
			elcoEntity.setFWPSRPREGSTS(doc.getString("FWPSRPREGSTS"));
			elcoEntity.setRelationalId(details.getString("relationalid"));
			elcoEntity.setReceivedTime(DateUtil.getDateTimeFromString(details.getString("received_time")));
			elcoService.save(elcoEntity);
			psrfDataConverterService.convertToEntityAndSave(doc);
		}
		catch (JSONException e) {
			System.out.println("Could not transfer data caseId: " + caseID);
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
