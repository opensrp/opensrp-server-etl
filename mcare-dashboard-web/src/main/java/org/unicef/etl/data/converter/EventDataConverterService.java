package org.unicef.etl.data.converter;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.etl.entity.EventEntity;
import org.unicef.etl.interfaces.DataConverterService;
import org.unicef.etl.service.EventService;
import org.unicef.etl.service.ExceptionService;

@Service
public class EventDataConverterService implements DataConverterService {
	
	@Autowired
	private EventEntity eventEntity;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private DataConverter dataConverter;
	
	@Autowired
	private ExceptionService exceptionService;
	
	public EventDataConverterService() {
		
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		
		try {
			Class<EventEntity> className = EventEntity.class;
			Object object = eventEntity;
			eventEntity = (EventEntity) dataConverter.convert(doc, className, object);
			System.out.println("eventEntity: " + eventEntity.toString());
			
			JSONObject obsJson = new JSONObject();
			Map<String, String> obsMap = new HashMap<String, String>();
			JSONArray obs = doc.getJSONArray("obs");
			System.out.println("obs:" + obs.toString());
			for (int i = 0; i < obs.length(); i++) {
				JSONObject obsFields = obs.getJSONObject(i);
				String obsfieldType = obsFields.getString("fieldType");
				JSONArray obsFieldsvaluesAr = obsFields.getJSONArray("values");
				if ("formsubmissionField".equals(obsfieldType)) {
					String obsfieldCode = obsFields.getString("fieldCode");
					obsJson.put(obsfieldCode, obsFieldsvaluesAr.get(0).toString());
					obsMap.put(obsfieldCode, obsFieldsvaluesAr.get(0).toString());
				} else if ("concept".equals(obsfieldType)) {
					String obsfieldCode = obsFields.getString("formSubmissionField");
					obsJson.put(obsfieldCode, obsFieldsvaluesAr.get(0).toString());
					obsMap.put(obsfieldCode, obsFieldsvaluesAr.get(0).toString());
					
				}
				
			}
			
			System.out.println("obsJson: " + obsJson.toString());
			System.out.println("obsMap: " + obsMap.toString());
			eventEntity.setObs(obsMap);
			eventService.save(eventEntity);
		}
		catch (JSONException e) {
			System.out.println("event data converter services: " + e.fillInStackTrace().toString());
			//exceptionService.generatedEntityAndSaveForAction(doc, e.fillInStackTrace().toString(), "event");
		}
		
	}
	
}
