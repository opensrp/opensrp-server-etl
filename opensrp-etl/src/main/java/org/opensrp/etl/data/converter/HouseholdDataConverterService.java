package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.HouseholdEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.HouseholdService;
import org.opensrp.etl.util.DateUtil;
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
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) {
		String caseID = "";
		try {
			caseID = doc.getString("caseId");
			householdEntity.setBirthDate(DateUtil.getDateFromString(doc.getString("FWHOHBIRTHDATE")));
			householdEntity.setCaseId(doc.getString("caseId"));
			householdEntity.setClientVersion(doc.getLong("clientVersion"));
			householdEntity.setCountry(doc.getString("FWCOUNTRY"));
			householdEntity.setCurrentFormStatus(doc.getString("current_formStatus"));
			householdEntity.setDistrict(doc.getString("FWDISTRICT"));
			householdEntity.setDivision(doc.getString("FWDIVISION"));
			householdEntity.setELCO(Integer.parseInt(doc.getString("ELCO")));
			householdEntity.setEnd(DateUtil.getDateTimeFromString(doc.getString("END")));
			householdEntity.setExternalUserId(doc.getString("external_user_ID"));
			householdEntity.setFirstName(doc.getString("FWHOHFNAME"));
			householdEntity.setFormName(doc.getString("form_name"));
			householdEntity.setFWNHHMBRNUM(doc.getString("FWNHHMBRNUM"));
			householdEntity.setFWNHHMWRA(doc.getString("FWNHHMWRA"));
			householdEntity.setGender(doc.getString("FWHOHGENDER"));
			householdEntity.setGps(doc.getString("FWNHHHGPS"));
			householdEntity.setInstanceId(doc.getString("INSTANCEID"));
			householdEntity.setFWJIVHHID(doc.getString("FWJIVHHID"));
			householdEntity.setLastName(doc.getString("FWHOHLNAME"));
			householdEntity.setMauzaPara(doc.getString("FWMAUZA_PARA"));
			householdEntity.setProvider(doc.getString("PROVIDERID"));
			householdEntity.setRegistrationDate(DateUtil.getDateFromString(doc.getString("FWNHREGDATE")));
			householdEntity.setStart(DateUtil.getDateTimeFromString(doc.getString("START")));
			householdEntity.setSubmissionTime(doc.getLong("SUBMISSIONDATE"));
			householdEntity.setSubunit(doc.getString("FWSUBUNIT"));
			householdEntity.setToday(DateUtil.getDateFromString(doc.getString("TODAY")));
			householdEntity.setUnion(doc.getString("FWUNION"));
			householdEntity.setUpazila(doc.getString("FWUPAZILLA"));
			householdEntity.setUserType(doc.getString("user_type"));
			householdEntity.setWard(doc.getString("FWWARD"));
			householdEntity.setFWGOBHHID(doc.getString("FWGOBHHID"));
			JSONObject details = new JSONObject(doc.getString("details"));
			householdEntity.setReceivedTime(DateUtil.getDateTimeFromString(details.getString("received_time")));
			householdService.save(householdEntity);
		}
		catch (JSONException e) {
			System.out.println("Could not transfer data caseId:" + caseID);
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
