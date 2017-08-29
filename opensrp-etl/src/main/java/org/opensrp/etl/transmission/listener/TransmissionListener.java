package org.opensrp.etl.transmission.listener;

import java.util.List;

import org.ektorp.ViewResult;
import org.ektorp.ViewResult.Row;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.repository.SourceDBRepository;
import org.opensrp.etl.transmission.service.TransmissionServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@Configuration
@EnableAsync
public class TransmissionListener {
	
	@Autowired
	private TransmissionServiceFactory transmissionServiceFactory;
	
	@Autowired
	private SourceDBRepository sourceDBRepository;
	
	@SuppressWarnings("unchecked")
	public void dataListener() throws JSONException {
		System.err.println("ok come to listener");
		ViewResult vr = sourceDBRepository.allData(0);
		List<Row> rows = vr.getRows();
		
		for (Row row : rows) {
			JSONObject jsonData = new JSONObject(row.getValue());
			transmissionServiceFactory.getTransmissionType(jsonData.getString("type")).convertDataJsonToEntity(jsonData);
			
		}
		
	}
}
