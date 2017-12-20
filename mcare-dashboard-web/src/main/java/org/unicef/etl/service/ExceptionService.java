package org.unicef.etl.service;

import javax.transaction.Transactional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.etl.entity.ExceptionEntity;
import org.unicef.etl.interfaces.RegisterService;
import org.unicef.etl.repository.CommonDatabaseRepository;

@Service
public class ExceptionService implements RegisterService<ExceptionEntity> {
	
	@Autowired
	private ExceptionEntity exceptionEntity;
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public ExceptionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public ExceptionEntity generatedEntityAndSave(JSONObject doc, String message, String benificiaryType) {
		try {
			exceptionEntity.setCaseId(doc.getString("caseId"));
			exceptionEntity.setBenificiaryType(benificiaryType);
			exceptionEntity.setErrorMessage(message);
			if (doc.has("INSTANCEID")) {
				exceptionEntity.setInstanceId(doc.getString("INSTANCEID"));
			} else {
				exceptionEntity.setInstanceId("");
			}
			exceptionEntity.setDocId(doc.getString("_id"));
			save(exceptionEntity);
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exceptionEntity;
		
	}
	
	@Transactional
	public ExceptionEntity generatedEntityAndSaveForAction(JSONObject doc, String message, String benificiaryType)
	    throws JSONException {
		exceptionEntity.setCaseId(doc.getString("caseID"));
		exceptionEntity.setBenificiaryType(benificiaryType);
		exceptionEntity.setErrorMessage(message);
		exceptionEntity.setInstanceId("");
		exceptionEntity.setDocId(doc.getString("_id"));
		save(exceptionEntity);
		return exceptionEntity;
		
	}
	
	@Transactional
	@Override
	public void save(ExceptionEntity exceptionEntity) {
		
		ExceptionEntity existingExceptionEntity = findBybaseEntityId(exceptionEntity.getCaseId());
		if (existingExceptionEntity == null) {
			commonDatabaseRepository.save(exceptionEntity);
		} else {
			if (delete(existingExceptionEntity))
				commonDatabaseRepository.save(exceptionEntity);
			
		}
		
	}
	
	@Transactional
	@Override
	public boolean delete(ExceptionEntity exceptionEntity) {
		return commonDatabaseRepository.delete(exceptionEntity);
	}
	
	@Override
	public void update(ExceptionEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ExceptionEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public ExceptionEntity findBybaseEntityId(String caseId) {
		
		return commonDatabaseRepository.findByKey(caseId, "caseId", ExceptionEntity.class);
	}
	
}
