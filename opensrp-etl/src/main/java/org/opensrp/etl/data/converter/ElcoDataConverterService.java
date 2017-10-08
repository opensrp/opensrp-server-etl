package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ElcoEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ElcoService;
import org.springframework.beans.factory.annotation.Autowired;

public class ElcoDataConverterService implements DataConverterService {
	
	@Autowired
	private ElcoEntity elcoEntity;
	
	@Autowired
	private ElcoService elcoService;
	
	public ElcoDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		
		try {
			System.out.println("ElcoDataConverterService convertData");
			elcoEntity.setBirthDate(doc.getString("FWBIRTHDATE"));
			elcoEntity.setCaseId(doc.getString("caseId"));
			elcoEntity.setClientVersion(doc.getLong("clientVersion"));
			elcoEntity.setCountry(doc.getString("FWWOMCOUNTRY"));
			elcoEntity.setDistrict(doc.getString("FWWOMDISTRICT"));
			elcoEntity.setDivision(doc.getString("FWWOMDIVISION"));
			elcoEntity.setELCO(Integer.parseInt(doc.getString("ELCO")));
			elcoEntity.setEnd(doc.getString("END"));
			elcoEntity.setExternalUserId(doc.getString("external_user_ID"));
			elcoEntity.setFirstName(doc.getString("FWWOMFNAME"));
			//elcoEntity.setFormName(doc.getString("form_name"));
			elcoEntity.setGender(doc.getString("FWGENDER"));
			elcoEntity.setGOBHHID(doc.getString("GOBHHID"));
			elcoEntity.setGps(doc.getString("FWWOMGPS"));
			elcoEntity.setInstanceId(doc.getString("INSTANCEID"));
			elcoEntity.setJiVitAHHID(doc.getString("JiVitAHHID"));
			elcoEntity.setLastName(doc.getString("FWWOMLNAME"));
			elcoEntity.setLocationId(doc.getString("LOCATIONID"));
			elcoEntity.setMauzaPara(doc.getString("FWWOMMAUZA_PARA"));
			elcoEntity.setProvider(doc.getString("PROVIDERID"));
			elcoEntity.setRegistrationDate(doc.getString("WomanREGDATE"));
			elcoEntity.setStart(doc.getString("START"));
			elcoEntity.setSubmissionTime(doc.getLong("SUBMISSIONDATE"));
			elcoEntity.setSubunit(doc.getString("FWWOMSUBUNIT"));
			elcoEntity.setToday(doc.getString("TODAY"));
			elcoEntity.setUnion(doc.getString("FWWOMUNION"));
			elcoEntity.setUpazila(doc.getString("FWWOMUPAZILLA"));
			elcoEntity.setUserType(doc.getString("user_type"));
			elcoEntity.setWard(doc.getString("FWWOMWARD"));
			elcoEntity.setFWCWOMSTRMEN(doc.getString("FWCWOMSTRMEN"));
			elcoEntity.setFWCWOMSTER(doc.getString("FWCWOMSTER"));
			//elcoEntity.setFWCWOMHUSALV(doc.getString("FWCWOMHUSALV"));
			elcoEntity.setFWCWOMHUSLIV(doc.getString("FWCWOMHUSLIV"));
			elcoEntity.setFWCWOMHUSSTR(doc.getString("FWCWOMHUSSTR"));
			//elcoEntity.setIsClosed(doc.getString("isClosed"));
			elcoEntity.setExistingElCO(Integer.parseInt(doc.getString("existing_ELCO")));
			//elcoEntity.setFWCENDATE(doc.getString("FWCENDATE"));
			//elcoEntity.setFWCENSTAT(doc.getString("FWCENSTAT"));
			elcoEntity.setFWWOMANYID(doc.getString("FWWOMANYID"));
			elcoEntity.setFWWOMNID(doc.getString("FWWOMNID"));
			elcoEntity.setFWWOMRETYPENID(doc.getString("FWWOMRETYPENID"));
			elcoEntity.setFWWOMRETYPENID_CONCEPT(doc.getString("FWWOMRETYPENID_CONCEPT"));
			elcoEntity.setFWWOMBID(doc.getString("FWWOMBID"));
			//elcoEntity.setFWWOMRETYPEBID(doc.getString("FWWOMRETYPEBID"));
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
			JSONObject details = new JSONObject(doc.getString("details"));
			elcoEntity.setFWPSRPREGSTS(details.getString("relationalid"));
			elcoEntity.setUpdated();
			elcoEntity.setCreated();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		elcoService.save(elcoEntity);
	}
	
}
