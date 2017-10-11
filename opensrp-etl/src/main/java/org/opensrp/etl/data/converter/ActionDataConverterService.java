package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ActionEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ActionService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionDataConverterService implements DataConverterService {
	
	@Autowired
	private ActionEntity actionEntity;
	
	@Autowired
	private ActionService actionService;
	
	public ActionDataConverterService() {
		
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		String caseID = "";
		try {
			caseID = doc.getString("caseID");
			JSONObject data = new JSONObject(doc.getString("data"));
			actionEntity.setActionTarget(doc.getString("actionTarget"));
			actionEntity.setProvider(doc.getString("anmIdentifier"));
			actionEntity.setCaseID(doc.getString("caseID"));
			actionEntity.setActionType(doc.getString("actionType"));
			actionEntity.setTimeStamp(Long.parseLong(doc.getString("timeStamp")));
			actionEntity.setIsActionActive(Boolean.parseBoolean(doc.getString("isActionActive")));
			actionEntity.setAlertStatus(data.getString("alertStatus"));
			actionEntity.setVisitCode(data.getString("visitCode"));
			actionEntity.setExpiryDate(DateUtil.getDateFromString(data.getString("expiryDate")));
			actionEntity.setScheduleName(data.getString("scheduleName"));
			actionEntity.setBeneficiaryType(data.getString("beneficiaryType"));
			actionEntity.setStartDate(DateUtil.getDateFromString(data.getString("startDate")));
			actionService.save(actionEntity);
		}
		catch (JSONException e) {
			System.out.println("Could not transfer data caseId: " + caseID);
			e.printStackTrace();
		}
		
	}
	
}
