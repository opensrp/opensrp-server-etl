package org.mcare.etl.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.ExceptionEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService implements RegisterService<ExceptionEntity> {

	private static final Logger logger = Logger.getLogger(ExceptionService.class);

	@Autowired
	private ExceptionEntity exceptionEntity;

	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;

	public ExceptionService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public ExceptionEntity generatedEntityAndSave(JSONObject doc, String message, String benificiaryType) throws Exception {
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
			logger.error("error: " + e);
		}

		return exceptionEntity;

	}

	@Transactional
	public ExceptionEntity generatedEntityAndSaveForAction(JSONObject doc, String message, String benificiaryType)
			throws Exception {
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
	public void save(ExceptionEntity exceptionEntity) throws Exception {

		ExceptionEntity existingExceptionEntity = findByCaseId(exceptionEntity.getCaseId());
		if (existingExceptionEntity == null) {
			databaseRepositoryImpl.save(exceptionEntity);
		} else {
			if (delete(existingExceptionEntity))
				databaseRepositoryImpl.save(exceptionEntity);
		}
	}

	@Transactional
	@Override
	public boolean delete(ExceptionEntity exceptionEntity) {
		return databaseRepositoryImpl.delete(exceptionEntity);
	}

	@Transactional
	@Override
	public void update(ExceptionEntity exceptionEntity) {
		databaseRepositoryImpl.update(exceptionEntity);
	}

	@Override
	public ExceptionEntity findById(int id) {
		return null;
	}

	@Transactional
	@Override
	public ExceptionEntity findByCaseId(String caseId) {

		return databaseRepositoryImpl.findByKey(caseId, "caseId", ExceptionEntity.class);
	}

}
