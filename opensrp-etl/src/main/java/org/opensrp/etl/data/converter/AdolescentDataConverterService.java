package org.opensrp.etl.data.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.AdolescentEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.AdolescentService;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdolescentDataConverterService implements DataConverterService {

    @Autowired
    private AdolescentEntity adolescentEntity;

    @Autowired
    private AdolescentService adolescentService;

    @Autowired
    private ExceptionService exceptionService;

    @Autowired
    private DataConverter dataConverter;

    public AdolescentDataConverterService() {

    }

    @Override
    public void convertToEntityAndSave(JSONObject doc) throws JSONException {
        JSONArray adolescents = new JSONArray();
        adolescents = doc.getJSONArray("adolescent");

        for (int i = 0; i < adolescents.length(); i++) {
            JSONObject adolescent = adolescents.getJSONObject(i);
            Class<AdolescentEntity> className = AdolescentEntity.class;
            Object object = new AdolescentEntity();
            adolescentEntity = (AdolescentEntity) dataConverter.convert(
                    adolescent, className, object);

            try {
                adolescentEntity.setrelationalid(doc.getString("caseId"));
                adolescentEntity.set_id(doc.getString("_id"));
                adolescentEntity.setINSTANCEID(doc.getString("INSTANCEID"));
                adolescentService.save(adolescentEntity);
            } catch (Exception e) {
                exceptionService.generatedEntityAndSave(doc, e
                        .fillInStackTrace().toString(), "adolescent");
            }

        }

    }
}
