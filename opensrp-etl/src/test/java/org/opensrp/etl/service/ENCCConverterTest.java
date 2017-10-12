package org.opensrp.etl.service;

import java.text.ParseException;
import java.util.List;

import org.ektorp.ViewResult;
import org.ektorp.ViewResult.Row;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opensrp.etl.entity.MarkerEntity;
import org.opensrp.etl.repository.SourceDBRepository;
import org.opensrp.etl.transmission.service.TransmissionServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:application-etl-context.xml", "classpath:application-couchdb-context.xml" })
public class ENCCConverterTest {
	
	@Autowired
	private TransmissionServiceFactory transmissionServiceFactory;
	
	@Autowired
	private SourceDBRepository sourceDBRepository;
	
	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private MarkerEntity markerEntity;
	
	@Ignore
	@Test
	public void saveTest() throws ParseException, JSONException {
		
		markerEntity = markerService.findById(1);
		ViewResult vr = sourceDBRepository.allData(markerEntity.getTimeStamp());
		List<Row> rows = vr.getRows();
		for (Row row : rows) {
			JSONObject jsonData = new JSONObject(row.getValue());
			long currentDocumentTimeStamp = Long.parseLong(jsonData.getString("timeStamp"));
			
			transmissionServiceFactory.getTransmissionType(jsonData.getString("type")).convertDataJsonToEntity(jsonData);
			if (markerEntity.getTimeStamp() < currentDocumentTimeStamp) {
				markerEntity.setTimeStamp(currentDocumentTimeStamp);
				//markerService.update(markerEntity);
			}
			
		}
	}
	
}
