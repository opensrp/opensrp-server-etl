package org.opensrp.etl.transmission.listener;

import java.util.List;

import org.apache.log4j.Logger;
import org.ektorp.ViewResult;
import org.ektorp.ViewResult.Row;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.MarkerEntity;
import org.opensrp.etl.repository.SourceDBRepository;
import org.opensrp.etl.service.MarkerService;
import org.opensrp.etl.transmission.service.TransmissionServiceFactory;
import org.opensrp.etl.util.CommonConstant;
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
	
	private static final Logger logger = Logger.getLogger(TransmissionListener.class);
	
	@Autowired
	private TransmissionServiceFactory transmissionServiceFactory;
	
	@Autowired
	private SourceDBRepository sourceDBRepository;
	
	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private MarkerEntity markerEntity;
	
	@SuppressWarnings("unchecked")
	public void dataListener() throws JSONException {
		markerEntity = markerService.findByName(CommonConstant.DGFP.name());
		logger.info("DGFP executed!");
		
		if (markerEntity != null) {
			logger.info("DGFP Data transfer started...");
			ViewResult vr = sourceDBRepository.allData(markerEntity.getTimeStamp());
			List<Row> rows = vr.getRows();
			logger.debug("row size: " + rows.size());
			for (Row row : rows) {
				JSONObject jsonData = new JSONObject(row.getValue());
				transmissionServiceFactory.getTransmissionType(jsonData.getString("type")).convertDataJsonToEntity(jsonData);
				
				long currentDocumentTimeStamp = Long.parseLong(jsonData.getString("timeStamp"));
				
				if (markerEntity.getTimeStamp() < currentDocumentTimeStamp) {
					markerEntity.settimeStamp(currentDocumentTimeStamp);
					markerService.update(markerEntity);
				}
			}
			logger.info("DGFP Data transfer completed");
		} else {
			logger.info("DGFP ETL process started, marker not initialized");
		}
	}
}
