package org.mcare.etl.data.converter;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;
import org.mcare.etl.entity.ActionEntity;
import org.mcare.etl.interfaces.DataConverterService;
import org.mcare.etl.service.ActionService;
import org.mcare.etl.service.ExceptionService;
import org.mcare.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionDataConverterService implements DataConverterService {
	
	@Autowired
	private ActionEntity actionEntity;
	
	@Autowired
	private ActionService actionService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	public ActionDataConverterService() {
		
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		
		try {
			
			JSONObject data = new JSONObject(doc.getString("data"));
			actionEntity.setActionTarget(doc.getString("actionTarget"));
			actionEntity.setProvider(doc.getString("anmIdentifier"));
			actionEntity.setCaseID(doc.getString("caseID"));
			actionEntity.setActionType(doc.getString("actionType"));
			actionEntity.setTimeStamp(Long.parseLong(doc.getString("timeStamp")));
			actionEntity.setIsActionActive(Boolean.parseBoolean(doc.getString("isActionActive")));
			if ("expired".equalsIgnoreCase(data.getString("alertStatus"))) {
				actionEntity.setExpiryDate(DateUtil.getDateFromString(data, "startDate"));
				actionEntity.setStartDate(DateUtil.getDateFromString(data, "startDate"));
			} else {
				actionEntity.setExpiryDate(DateUtil.getDateFromString(data, "expiryDate"));
				actionEntity.setStartDate(DateUtil.getDateFromString(data, "startDate"));
			}
			
			actionEntity.setAlertStatus(data.getString("alertStatus"));
			
			actionEntity.setVisitCode(data.getString("visitCode"));
			
			actionEntity.setScheduleName(data.getString("scheduleName"));
			actionEntity.setBeneficiaryType(data.getString("beneficiaryType"));
			
			actionService.save(actionEntity);
		}
		catch (JSONException e) {
			exceptionService.generatedEntityAndSaveForAction(doc, e.fillInStackTrace().toString(), "action");
		}
		catch (ParseException e) {
			exceptionService.generatedEntityAndSaveForAction(doc, e.fillInStackTrace().toString(), "action");
		}
		
	}
	
}
