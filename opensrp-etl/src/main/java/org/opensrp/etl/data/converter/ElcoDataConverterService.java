package org.opensrp.etl.data.converter;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ElcoEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ElcoService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class ElcoDataConverterService implements DataConverterService {
	
	@Autowired
	private ElcoEntity elcoEntity;
	
	@Autowired
	private ElcoService elcoService;
	
	@Autowired
	private PSRFDataConverterService psrfDataConverterService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	public ElcoDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		String caseID = "";
		try {
			caseID = doc.getString("caseId");
			JSONObject details = new JSONObject(doc.getString("details"));
			elcoEntity.setBirthDate(DateUtil.getDateFromString(doc, "WomanREGDATE"));
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
			elcoEntity.setRegistrationDate(DateUtil.getDateFromString(doc, "WomanREGDATE"));
			elcoEntity.setSubmissionTime(doc.getLong("SUBMISSIONDATE"));
			elcoEntity.setSubunit(doc.getString("FWWOMSUBUNIT"));
			elcoEntity.setStart(DateUtil.getDateTimeFromString(details, "start"));
			elcoEntity.setEnd(DateUtil.getDateTimeFromString(details, "end"));
			elcoEntity.setToday(DateUtil.getDateFromString(details, "today"));
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
			
			if (doc.has("FWCENDATE") && !doc.getString("FWCENDATE").isEmpty()) {
				elcoEntity.setFWCENDATE(DateUtil.getDateFromString(doc, "FWCENDATE"));
			}
			
			if (doc.has("FWCENSTAT")) {
				elcoEntity.setFWCENSTAT(doc.getString("FWCENSTAT"));
			} else {
				elcoEntity.setFWCENSTAT("");
			}
			
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
			if (doc.has("FWDISPLAYAGE")) {
				elcoEntity.setFWDISPLAYAGE(doc.getString("FWDISPLAYAGE"));
			} else {
				elcoEntity.setFWDISPLAYAGE("");
			}
			if (doc.has("FWWOMSTRMEN")) {
				elcoEntity.setFWWOMSTRMEN(doc.getString("FWWOMSTRMEN"));
			} else {
				elcoEntity.setFWWOMSTRMEN("");
			}
			if (doc.has("FWWOMHUSALV")) {
				elcoEntity.setFWWOMHUSALV(doc.getString("FWWOMHUSALV"));
			} else {
				elcoEntity.setFWWOMHUSALV("");
			}
			if (doc.has("FWWOMHUSSTR")) {
				elcoEntity.setFWWOMHUSSTR(doc.getString("FWWOMHUSSTR"));
			} else {
				elcoEntity.setFWWOMHUSSTR("");
			}
			if (doc.has("FWWOMHUSLIV")) {
				elcoEntity.setFWWOMHUSLIV(doc.getString("FWWOMHUSLIV"));
			} else {
				elcoEntity.setFWWOMHUSLIV("");
			}
			elcoEntity.setFWELIGIBLE(doc.getString("FWELIGIBLE"));
			if (doc.has("FWELIGIBLE2")) {
				elcoEntity.setFWELIGIBLE2(doc.getString("FWELIGIBLE2"));
			} else {
				elcoEntity.setFWELIGIBLE2("");
			}
			elcoEntity.setFWWOMGOBHHID(doc.getString("FWWOMGOBHHID"));
			elcoEntity.setFWPSRPREGSTS(doc.getString("FWPSRPREGSTS"));
			elcoEntity.setRelationalId(details.getString("relationalid"));
			elcoEntity.setReceivedTime(DateUtil.getDateTimeFromString(details, "received_time"));
			elcoEntity.setCurrentFormStatus("");
			
			elcoService.save(elcoEntity);
			psrfDataConverterService.convertToEntityAndSave(doc);
		}
		catch (JSONException e) {
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "elco");
		}
		catch (NumberFormatException e) {
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "elco");
		}
		catch (ParseException e) {
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "elco");
		}
		
	}
	
}
