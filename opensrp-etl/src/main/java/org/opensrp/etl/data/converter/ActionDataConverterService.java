package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ActionEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ActionService;
import org.opensrp.etl.service.ExceptionService;
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
            Object object = actionEntity;
            actionEntity = (ActionEntity) dataConverter.convert(doc,
                    className, object);
            actionService.save(actionEntity);
        } catch (Exception e) {
            exceptionService.generatedEntityAndSaveForAction(doc, e
                    .fillInStackTrace().toString(), "action");
        }

    }

}
