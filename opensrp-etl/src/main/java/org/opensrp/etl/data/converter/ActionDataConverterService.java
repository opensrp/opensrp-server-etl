package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ActionEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ActionService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionDataConverterService implements DataConverterService {

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
            Class<ActionEntity> className = ActionEntity.class;
            Object object = new ActionEntity();
            actionEntity = (ActionEntity) dataConverter.convert(doc, className, object);
            JSONObject data = new JSONObject(doc.getString("data"));
            actionEntity.setProvider(doc.getString("anmIdentifier"));
            actionEntity.setCaseId(doc.getString("caseID"));
            actionEntity.setAlertStatus(data.getString("alertStatus"));
            actionEntity.setVisitCode(data.getString("visitCode"));
            actionEntity.setExpiryDate(DateUtil.getDateFromString(data, "expiryDate"));
            actionEntity.setScheduleName(data.getString("scheduleName"));
            actionEntity.setBeneficiaryType(data.getString("beneficiaryType"));
            actionEntity.setStartDate(DateUtil.getDateFromString(data, "startDate"));
            actionService.save(actionEntity);
        } catch (Exception e) {
            exceptionService.generatedEntityAndSaveForAction(doc, e
                    .fillInStackTrace().toString(), "action");
        }

    }

}
