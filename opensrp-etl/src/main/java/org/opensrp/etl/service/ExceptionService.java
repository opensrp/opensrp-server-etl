package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ExceptionEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.ExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ExceptionService implements RegisterService<ExceptionEntity> {
	
	@Autowired
	private ExceptionEntity exceptionEntity;
	
	@Autowired
	private ExceptionRepository exceptionRepository;
	
	public ExceptionService() {
		// TODO Auto-generated constructor stub
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
		
		ExceptionEntity existingExceptionEntity = findByCaseId(exceptionEntity.getCaseId());
		if (existingExceptionEntity == null) {
			exceptionRepository.save(exceptionEntity);
		} else {
			if (delete(existingExceptionEntity))
				exceptionRepository.save(exceptionEntity);
			
		}
		
	}
	
	@Transactional
	@Override
	public boolean delete(ExceptionEntity exceptionEntity) {
		return exceptionRepository.delete(exceptionEntity);
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
	public ExceptionEntity findByCaseId(String caseId) {
		
		return exceptionRepository.findByCaseId(caseId);
	}
	
}
