package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ANCEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ANCService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.util.Keys;
import org.springframework.beans.factory.annotation.Autowired;

public class ANCDataConverterService implements DataConverterService {

    @Autowired
    private ANCService ancService;

    @Autowired
    private ANCEntity ancEntity;

    @Autowired
    private DataConverter dataConverter;

    @Autowired
    private ExceptionService exceptionService;

    public ANCDataConverterService() {

    }

    @Autowired
    public void setANCEntity(ANCEntity ancEntity) {
        this.ancEntity = ancEntity;
    }

    @Override
    public void convertToEntityAndSave(JSONObject doc) throws JSONException {

        Class<ANCEntity> className = ANCEntity.class;
        Object ancObject = ancEntity;

        JSONObject anc1VisitDoc = new JSONObject(doc.getString("ANCVisit1")
                .toString());

        if (anc1VisitDoc.length() != 0) {
            ancEntity = (ANCEntity) dataConverter.convert(anc1VisitDoc,
                    className, ancObject);
            ancEntity.setAncName(Keys.ANC1.name());
            ancEntity.set_id(doc.getString("_id"));
            ancEntity.setrelationalid(doc.getString("caseId"));
            try {
                ancService.save(ancEntity);
            } catch (Exception e) {
                exceptionService.generatedEntityAndSaveForAction(doc, e
                        .fillInStackTrace().toString(), "anc1");
            }
        }
        JSONObject anc2VisitDoc = new JSONObject(doc.getJSONObject("ANCVisit2")
                .toString());

        if (anc2VisitDoc.length() != 0) {
            ancEntity = (ANCEntity) dataConverter.convert(anc2VisitDoc,
                    className, ancObject);
            ancEntity.setAncName(Keys.ANC2.name());
            ancEntity.set_id(doc.getString("_id"));
            ancEntity.setrelationalid(doc.getString("caseId"));
            try {
                ancService.save(ancEntity);
            } catch (Exception e) {
                exceptionService.generatedEntityAndSaveForAction(doc, e
                        .fillInStackTrace().toString(), "anc2");
            }
        }
        JSONObject anc3VisitDoc = new JSONObject(doc.getJSONObject("ANCVisit3")
                .toString());

        if (anc3VisitDoc.length() != 0) {
            ancEntity = (ANCEntity) dataConverter.convert(anc3VisitDoc,
                    className, ancObject);
            ancEntity.setAncName(Keys.ANC3.name());
            ancEntity.set_id(doc.getString("_id"));
            ancEntity.setrelationalid(doc.getString("caseId"));
            try {
                ancService.save(ancEntity);
            } catch (Exception e) {
                exceptionService.generatedEntityAndSaveForAction(doc, e
                        .fillInStackTrace().toString(), "anc3");
            }
        }
        JSONObject anc4VisitDoc = new JSONObject(doc.getJSONObject("ANCVisit4")
                .toString());

        if (anc4VisitDoc.length() != 0) {
            ancEntity = (ANCEntity) dataConverter.convert(anc4VisitDoc,
                    className, ancObject);
            ancEntity.setAncName(Keys.ANC4.name());
            ancEntity.set_id(doc.getString("_id"));
            ancEntity.setrelationalid(doc.getString("caseId"));
            try {
                ancService.save(ancEntity);
            } catch (Exception e) {
                exceptionService.generatedEntityAndSaveForAction(doc, e
                        .fillInStackTrace().toString(), "anc4");
            }
        }
    }

}
