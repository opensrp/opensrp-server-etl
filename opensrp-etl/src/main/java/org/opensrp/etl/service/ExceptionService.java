package org.opensrp.etl.service;

import static org.opensrp.etl.util.AllConstants.CASE_ID;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ExceptionEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ExceptionService implements RegisterService<ExceptionEntity> {
	
	private static final Logger logger = Logger.getLogger(ExceptionService.class);
	
	@Autowired
	private ExceptionEntity exceptionEntity;
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public ExceptionService() {
	}
	
	@Transactional
	public ExceptionEntity generatedEntityAndSave(JSONObject doc, String message, String benificiaryType) {
		try {
			exceptionEntity.setCaseId(doc.getString("caseId"));
			exceptionEntity.setBenificiaryType(benificiaryType);
			exceptionEntity.setErrorMessage(message);
			exceptionEntity.setInstanceId(doc.getString("INSTANCEID"));
			exceptionEntity.setDocId(doc.getString("_id"));
			save(exceptionEntity);
		}
		catch (JSONException e) {
			logger.error(e);
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
		
		ExceptionEntity existingExceptionEntity = findByCaseId(exceptionEntity.getCaseId());
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
	
	@Transactional
	@Override
	public void update(ExceptionEntity exceptionEntity) {
		commonDatabaseRepository.update(exceptionEntity);
	}
	
	@Override
	public ExceptionEntity findById(int id) {
		return null;
	}
	
	@Transactional
	@Override
	public ExceptionEntity findByCaseId(String caseId) {
		return commonDatabaseRepository.findByKey(caseId, CASE_ID, ExceptionEntity.class);
	}
}
