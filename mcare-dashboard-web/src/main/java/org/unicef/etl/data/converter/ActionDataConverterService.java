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
			actionEntity.setProvider(doc.getString("anmIdentifier"));
			actionEntity.setCaseID(doc.getString("caseID"));
			actionEntity.setActionType(doc.getString("actionType"));
			actionEntity.setTimeStamp(Long.parseLong(doc.getString("timeStamp")));
			actionEntity.setIsActionActive(Boolean.parseBoolean(doc.getString("isActionActive")));
			actionEntity.setAlertStatus(data.getString("alertStatus"));
			actionEntity.setVisitCode(data.getString("visitCode"));
			actionEntity.setExpiryDate(DateUtil.getDateFromString(data, "expiryDate"));
			actionEntity.setScheduleName(data.getString("scheduleName"));
			actionEntity.setBeneficiaryType(data.getString("beneficiaryType"));
			actionEntity.setStartDate(DateUtil.getDateFromString(data, "startDate"));
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
