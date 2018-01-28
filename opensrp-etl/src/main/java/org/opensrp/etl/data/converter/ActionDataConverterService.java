package org.opensrp.etl.data.converter;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ActionEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ActionService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.util.BooleanUtil;
import org.opensrp.etl.util.DateUtil;
import org.opensrp.etl.util.NumbertUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionDataConverterService implements DataConverterService {
	
	private static final Logger logger = Logger.getLogger(ActionDataConverterService.class);
	
	@Autowired
	private ActionEntity actionEntity;
	
	@Autowired
	private ActionService actionService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	public ActionDataConverterService() {
		
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		try {
			actionEntity.setanmIdentifier(doc.getString("anmIdentifier"));
			actionEntity.setCaseId(doc.getString("caseID"));
			actionEntity.setactionTarget(doc.getString("actionTarget"));
			actionEntity.setactionType(doc.getString("actionType"));
			actionEntity.setisActionActive(BooleanUtil.convertToBoolean(doc.getString("isActionActive")));
			actionEntity.settimeStamp(NumbertUtil.convertToLong(doc.getString("timeStamp")));
			JSONObject data = new JSONObject(doc.getString("data"));
			
			actionEntity.setalertStatus(data.getString("alertStatus"));
			actionEntity.setvisitCode(data.getString("visitCode"));
			actionEntity.setexpiryDate(DateUtil.getDateFromString(data, "expiryDate"));
			actionEntity.setscheduleName(data.getString("scheduleName"));
			actionEntity.setbeneficiaryType(data.getString("beneficiaryType"));
			actionEntity.setstartDate(DateUtil.getDateFromString(data, "startDate"));
			actionService.save(actionEntity);
		}
		catch (Exception e) {
			logger.error(e);
			exceptionService.generatedEntityAndSaveForAction(doc, e.fillInStackTrace().toString(), "action");
		}
		
	}
	
}
