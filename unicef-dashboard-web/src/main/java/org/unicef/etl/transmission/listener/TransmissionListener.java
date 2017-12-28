package org.unicef.etl.transmission.listener;

import java.util.List;

import org.ektorp.ViewResult;
import org.ektorp.ViewResult.Row;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.unicef.etl.entity.MarkerEntity;
import org.unicef.etl.interfaces.TransmissionServices;
import org.unicef.etl.repository.SourceDBRepository;
import org.unicef.etl.service.MarkerService;
import org.unicef.etl.transmission.service.TransmissionServiceFactory;

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
	
	@SuppressWarnings("unchecked")
	public void dataListener() throws JSONException {
		markerEntity = markerService.findById(1);
		ViewResult vr = null;
		if (markerEntity != null) {
			vr = sourceDBRepository.allData(markerEntity.getTimeStamp());
			List<Row> rows = vr.getRows();
			System.err.println("unicef etl process started rows:" + rows.size());
			int rowSize = rows.size();
			for (Row row : rows) {
				try {
					JSONObject jsonData = new JSONObject(row.getValue());
					System.err.println("transfer started:" + rowSize + " ,baseEntityId:" + jsonData.getString("baseEntityId"));
					long currentDocumentTimeStamp = Long.parseLong(jsonData.getString("serverVersion"));
					transmissionServices = transmissionServiceFactory.getTransmissionType(jsonData.getString("type"));
					if (transmissionServices != null) {
						transmissionServiceFactory.getTransmissionType(jsonData.getString("type")).convertDataJsonToEntity(
						    jsonData);
						System.err.println("transfer end:" + rowSize + " ,baseEntityId:" + jsonData.getString("baseEntityId"));
						rowSize--;
						if (markerEntity.getTimeStamp() < currentDocumentTimeStamp) {
							markerEntity.setTimeStamp(currentDocumentTimeStamp);
							markerService.update(markerEntity);
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
					
				}
				
			}
		} else {
			System.err.println("unicef etl process started marker not defined yet!!!!");
		}
	}
}
