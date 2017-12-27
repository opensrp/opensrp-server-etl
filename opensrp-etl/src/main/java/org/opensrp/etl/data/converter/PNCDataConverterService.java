package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.PNCEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.PNCService;
import org.opensrp.etl.util.Keys;
import org.springframework.beans.factory.annotation.Autowired;

public class PNCDataConverterService implements DataConverterService {

    @Autowired
    private PNCEntity pncEntity;

    @Autowired
    private PNCService pncService;

    @Autowired
    private DataConverter dataConverter;

    @Autowired
    private ExceptionService exceptionService;

    public PNCDataConverterService() {

    }

    @Autowired
    public void setPNCEntity(PNCEntity pncEntity) {
        this.pncEntity = pncEntity;
    }

    @Override
    public void convertToEntityAndSave(JSONObject doc) throws JSONException {

        Class<PNCEntity> PNCEntity = PNCEntity.class;
        Object ancObject = new PNCEntity();

        JSONObject pnc1VisitDoc = new JSONObject(doc.getString("PNCVisit1")
                .toString());

        if (pnc1VisitDoc.length() != 0) {
            pncEntity = (PNCEntity) dataConverter.convert(pnc1VisitDoc,
                    PNCEntity, ancObject);

            try {
                pncEntity.setPncName(Keys.PNC1.name());
                pncEntity.set_id(doc.getString("_id"));
                pncEntity.setrelationalid(doc.getString("caseId"));
                pncEntity.setINSTANCEID(doc.getString("INSTANCEID"));
                pncService.save(pncEntity);
            } catch (Exception e) {
                exceptionService.generatedEntityAndSave(doc, e
                        .fillInStackTrace().toString(), "pnc1");
            }
        }
        JSONObject pnc2VisitDoc = new JSONObject(doc.getJSONObject("PNCVisit2")
                .toString());

        if (pnc2VisitDoc.length() != 0) {
            pncEntity = (PNCEntity) dataConverter.convert(pnc2VisitDoc,
                    PNCEntity, ancObject);

            try {
                pncEntity.setPncName(Keys.PNC2.name());
                pncEntity.set_id(doc.getString("_id"));
                pncEntity.setrelationalid(doc.getString("caseId"));
                pncEntity.setINSTANCEID(doc.getString("INSTANCEID"));
                pncService.save(pncEntity);
            } catch (Exception e) {
                exceptionService.generatedEntityAndSave(doc, e
                        .fillInStackTrace().toString(), "pnc2");
            }

        }
        JSONObject pnc3VisitDoc = new JSONObject(doc.getJSONObject("PNCVisit3")
                .toString());

        if (pnc3VisitDoc.length() != 0) {
            pncEntity = (PNCEntity) dataConverter.convert(pnc3VisitDoc,
                    PNCEntity, ancObject);

            try {
                pncEntity.setPncName(Keys.PNC3.name());
                pncEntity.set_id(doc.getString("_id"));
                pncEntity.setrelationalid(doc.getString("caseId"));
                pncEntity.setINSTANCEID(doc.getString("INSTANCEID"));
                pncService.save(pncEntity);
            } catch (Exception e) {
                exceptionService.generatedEntityAndSave(doc, e
                        .fillInStackTrace().toString(), "pnc3");
            }
        }
        JSONObject pnc4VisitDoc = new JSONObject(doc.getJSONObject("PNCVisit4")
                .toString());

        if (pnc4VisitDoc.length() != 0) {
            pncEntity = (PNCEntity) dataConverter.convert(pnc4VisitDoc,
                    PNCEntity, ancObject);

            try {
                pncEntity.setPncName(Keys.PNC4.name());
                pncEntity.set_id(doc.getString("_id"));
                pncEntity.setrelationalid(doc.getString("caseId"));
                pncEntity.setINSTANCEID(doc.getString("INSTANCEID"));
                pncService.save(pncEntity);
            } catch (Exception e) {
                exceptionService.generatedEntityAndSave(doc, e
                        .fillInStackTrace().toString(), "pnc4");
            }
        }
    }
}
