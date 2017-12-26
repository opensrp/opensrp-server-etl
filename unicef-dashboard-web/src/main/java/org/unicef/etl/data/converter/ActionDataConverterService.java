package org.unicef.etl.data.converter;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.etl.entity.ActionEntity;
import org.unicef.etl.interfaces.DataConverterService;
import org.unicef.etl.service.ActionService;
import org.unicef.etl.service.ExceptionService;
import org.unicef.etl.util.DateUtil;
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
			actionEntity.setBaseEntityId(doc.getString("baseEntityId"));
			actionEntity.setProviderId(doc.getString("providerId"));
			actionEntity.setActionType(doc.getString("actionType"));
			actionEntity.setTimeStamp(Long.parseLong(doc.getString("timeStamp")));
			actionEntity.setIsActionActive(Boolean.parseBoolean(doc.getString("isActionActive")));
			if (data.has("alertStatus")) {
				actionEntity.setAlertStatus(data.getString("alertStatus"));
			}
			if (data.has("visitCode")) {
				actionEntity.setVisitCode(data.getString("visitCode"));
			}
			
			if (data.has("expiryDate")) {
				actionEntity.setExpiryDate(DateUtil.getDateFromString(data, "expiryDate"));
			}
			
			if (data.has("scheduleName")) {
				actionEntity.setScheduleName(data.getString("scheduleName"));
			}
			
			if (data.has("beneficiaryType")) {
				actionEntity.setBeneficiaryType(data.getString("beneficiaryType"));
			}
			
			if (data.has("startDate")) {
				actionEntity.setStartDate(DateUtil.getDateFromString(data, "startDate"));
			}
			
			if (data.has("completionDate")) {
				actionEntity.setCompletionDate(DateUtil.getDateFromString(data, "completionDate"));
			}			
			
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
