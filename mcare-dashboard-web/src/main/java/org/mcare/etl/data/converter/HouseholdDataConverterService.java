package org.mcare.etl.data.converter;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.etl.interfaces.DataConverterService;
import org.mcare.etl.service.ExceptionService;
import org.mcare.etl.service.HouseholdService;
import org.mcare.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdDataConverterService implements DataConverterService {
	
	public HouseholdDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private HouseholdService householdService;
	
	@Autowired
	private HouseholdEntity householdEntity;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) {
		String caseID = "";
		try {
			caseID = doc.getString("caseId");
			
			householdEntity.setBirthDate(DateUtil.getDateFromString(doc, "FWHOHBIRTHDATE"));
			if (doc.has("caseId"))
				householdEntity.setCaseId(doc.getString("caseId"));
			if (doc.has("clientVersion"))
				householdEntity.setClientVersion(doc.getLong("clientVersion"));
			householdEntity.setCountry(doc.getString("FWCOUNTRY"));
			householdEntity.setCurrentFormStatus(doc.getString("current_formStatus"));
			householdEntity.setDistrict(doc.getString("FWDISTRICT"));
			householdEntity.setDivision(doc.getString("FWDIVISION"));
			if ("".equalsIgnoreCase(doc.getString("ELCO")) || "N/A".equalsIgnoreCase(doc.getString("ELCO"))) {
				householdEntity.setELCO(-1);
			} else {
				householdEntity.setELCO(Integer.parseInt(doc.getString("ELCO")));
			}
			
			householdEntity.setEnd(DateUtil.getDateTimeFromString(doc, "END"));
			if (doc.has("external_user_ID"))
				householdEntity.setExternalUserId(doc.getString("external_user_ID"));
			if (doc.has("FWHOHFNAME") && !doc.getString("FWHOHFNAME").isEmpty()) {
				householdEntity.setFirstName(doc.getString("FWHOHFNAME"));
			} else {
				householdEntity.setFirstName("");
			}
			if (doc.has("FWNHHMBRNUM") && !doc.getString("FWNHHMBRNUM").isEmpty()) {
				householdEntity.setFWNHHMBRNUM(doc.getString("FWNHHMBRNUM"));
			} else {
				householdEntity.setFWNHHMBRNUM("");
			}
			
			if (doc.has("FWNHHMWRA") && !doc.getString("FWNHHMWRA").isEmpty()) {
				householdEntity.setFWNHHMWRA(doc.getString("FWNHHMWRA"));
			} else {
				householdEntity.setFWNHHMWRA("");
			}
			
			if (doc.has("FWHOHGENDER") && !doc.getString("FWHOHGENDER").isEmpty()) {
				householdEntity.setGender(doc.getString("FWHOHGENDER"));
			} else {
				householdEntity.setGender("");
			}
			householdEntity.setGps(doc.getString("FWNHHHGPS"));
			householdEntity.setInstanceId(doc.getString("INSTANCEID"));
			householdEntity.setFWJIVHHID(doc.getString("FWJIVHHID"));
			//householdEntity.setLastName(doc.getString("FWHOHLNAME"));
			householdEntity.setMauzaPara(doc.getString("FWMAUZA_PARA"));
			householdEntity.setProvider(doc.getString("PROVIDERID"));
			
			householdEntity.setRegistrationDate(DateUtil.getDateFromString(doc, "FWNHREGDATE"));
			
			householdEntity.setStart(DateUtil.getDateTimeFromString(doc, "START"));
			
			householdEntity.setSubmissionTime(doc.getLong("SUBMISSIONDATE"));
			householdEntity.setSubunit(doc.getString("FWSUBUNIT"));
			
			householdEntity.setToday(DateUtil.getDateFromString(doc, "TODAY"));
			
			householdEntity.setUnion(doc.getString("FWUNION"));
			householdEntity.setUpazila(doc.getString("FWUPAZILLA"));
			householdEntity.setUserType(doc.getString("user_type"));
			householdEntity.setWard(doc.getString("FWWARD"));
			householdEntity.setFWGOBHHID(doc.getString("FWGOBHHID"));
			JSONObject details = new JSONObject(doc.getString("details"));
			householdEntity.setReceivedTime(DateUtil.getDateTimeFromString(details, "received_time"));
			System.out.println("saving household entity");
			householdService.save(householdEntity);
			
		}
		catch (JSONException e) {
			e.printStackTrace();
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "household");
			
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "household");
		}
		catch (ParseException e) {
			e.printStackTrace();
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "household");
		}
	}
}
