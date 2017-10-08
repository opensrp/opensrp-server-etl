package org.opensrp.etl.transmission.listener;

import java.util.List;

import org.ektorp.ViewResult;
import org.ektorp.ViewResult.Row;
import org.json.JSONException;
import org.opensrp.etl.entity.MarkerEntity;
import org.opensrp.etl.repository.SourceDBRepository;
import org.opensrp.etl.service.MarkerService;
import org.opensrp.etl.transmission.service.TransmissionServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:application-etl-context.xml", "classpath:application-couchdb-context.xml" })
public class TransmissionListenerTest {
	
	@Autowired
	private TransmissionServiceFactory transmissionServiceFactory;
	
	@Autowired
	private SourceDBRepository sourceDBRepository;
	
	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private MarkerEntity markerEntity;
	
	//@Test
	@SuppressWarnings("unchecked")
	public void dataListenerTest() throws JSONException {
		try {
			System.out.println("ETL process started transmission from source couchDB!!!");
			markerEntity = markerService.findById(1);
			ViewResult vr = sourceDBRepository.allData(0);
			List<Row> rows = vr.getRows();
			/*		Collections.sort(rows);
					sort(rows);*/
			/*
			for (Row row : rows) {
				JSONObject jsonData = new JSONObject(row.getValue());
				long currentDocumentTimeStamp = Long.parseLong(jsonData.getString("timeStamp"));
				System.out.println("currentDocumentTimeStamp:" + currentDocumentTimeStamp);
				if (markerEntity.getTimeStamp() <= currentDocumentTimeStamp) {
					transmissionServiceFactory.getTransmissionType(jsonData.getString("type"))
					        .convertDataJsonToEntity(jsonData);
				}
				if (markerEntity.getTimeStamp() < currentDocumentTimeStamp) {
					markerEntity.setTimeStamp(currentDocumentTimeStamp);
					markerService.update(markerEntity);
				}
				
			}*/
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
