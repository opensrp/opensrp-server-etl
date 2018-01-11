package org.mcare.etl.transmission.listener;

import java.util.List;

import org.ektorp.ViewResult;
import org.ektorp.ViewResult.Row;
import org.json.JSONException;
import org.json.JSONObject;
import org.mcare.etl.entity.MarkerEntity;
import org.mcare.etl.interfaces.TransmissionServices;
import org.mcare.etl.repository.SourceDBRepository;
import org.mcare.etl.service.MarkerService;
import org.mcare.etl.transmission.service.TransmissionServiceFactory;
import org.mcare.etl.util.CommonConstant;
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
	
	//private static final Logger logger = Logger.getLogger(TransmissionListener.class);
	
	@Autowired
	private TransmissionServiceFactory transmissionServiceFactory;
	
	@Autowired
	private SourceDBRepository sourceDBRepository;
	
	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private MarkerEntity markerEntity;
	
	private TransmissionServices transmissionServices;
	
	public void dataListener() throws JSONException {
		markerEntity = markerService.findByName(CommonConstant.MCARE.name());
		ViewResult vr = sourceDBRepository.allData(markerEntity.getTimeStamp());
		List<Row> rows = vr.getRows();
		int rowCount = rows.size();
		System.out.println("rows:" + rowCount);
		for (Row row : rows) {
			JSONObject jsonData = new JSONObject(row.getValue());
			long currentDocumentTimeStamp = Long.parseLong(jsonData.getString("timeStamp"));
			transmissionServices = transmissionServiceFactory.getTransmissionType(jsonData.getString("type"));
			if (transmissionServices != null) {
				transmissionServiceFactory.getTransmissionType(jsonData.getString("type")).convertDataJsonToEntity(jsonData);
				if (markerEntity.getTimeStamp() < currentDocumentTimeStamp) {
					markerEntity.setTimeStamp(currentDocumentTimeStamp);
					markerService.update(markerEntity);
				}
				rowCount--;
				System.out.println("mcare etl process running rowCount:" + rowCount);
			}
			
		}
		
	}
}
