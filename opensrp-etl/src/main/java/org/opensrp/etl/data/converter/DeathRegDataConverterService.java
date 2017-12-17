package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.DeathRegEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.DeathRegService;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeathRegDataConverterService implements DataConverterService {

    @Autowired
    private DeathRegEntity deathRegEntity;

    @Autowired
    private DeathRegService deathRegService;

    @Autowired
    private DataConverter dataConverter;

    @Autowired
    private ExceptionService exceptionService;

    public DeathRegDataConverterService() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void convertToEntityAndSave(JSONObject doc) throws JSONException {
        JSONObject deathReg = doc.getJSONObject("DeathReg");
        Class<DeathRegEntity> className = DeathRegEntity.class;
        Object object = deathRegEntity;
        deathRegEntity = (DeathRegEntity) dataConverter.convert(deathReg,
                className, object);
        deathRegEntity.setRelationalid(doc.getString("caseId"));
        try {
            deathRegService.save(deathRegEntity);
        } catch (Exception e) {
            exceptionService.generatedEntityAndSaveForAction(doc, e
                    .fillInStackTrace().toString(), "deathReg");
        }

    }

}
