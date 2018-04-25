package org.mcare.etl.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.ANCEntity;
import org.mcare.etl.entity.ActionEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ANCService implements RegisterService<ANCEntity> {

	private static final Logger logger = Logger.getLogger(ANCService.class);

	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;

	public ANCService() {
	}

	@Transactional
	@Override
	public void save(ANCEntity ancEntity) throws Exception {
		ANCEntity existingancEntity = findByCaseIdAndToday(ancEntity.getRelationalid(), ancEntity.getToday());

		if (existingancEntity == null) {
			databaseRepositoryImpl.save(ancEntity);
			dataCorrectInActionTable(ancEntity);
		}
	}

	private void dataCorrectInActionTable(ANCEntity ancEntity) {
		List<ActionEntity> actionEntityList = findAllActionByCaseIdAndVisitCode(ancEntity.getRelationalid()
				, ancEntity.getAncName());

		logger.error("actionEntityList: " + actionEntityList.size());

		if(actionEntityList != null) {
			for(ActionEntity actionEntity : actionEntityList) {
				if(actionEntity.getAlertStatus().equalsIgnoreCase("upcoming")  
						&& actionEntity.getIsActionActive() == true) {
					logger.info("actionEntity case id: " + actionEntity.getCaseId());
					updateIsActionActive(ancEntity.getRelationalid(), ancEntity.getAncName(), "upcoming", false);
				} else if(!actionEntity.getAlertStatus().equalsIgnoreCase("upcoming")  
						&& actionEntity.getIsActionActive() == false) {
					logger.info("else if actionEntity case id: " + actionEntity.getCaseId());
					updateIsActionActive(ancEntity.getRelationalid(), ancEntity.getAncName()
							, actionEntity.getAlertStatus(), true);
				} else {
					logger.info("else actionEntity case id: " + actionEntity.getCaseId());
				}
			}
		}
	}

	private void updateIsActionActive(String relationalid, String ancName,
			String alertStatus, boolean isActionActive) {
		databaseRepositoryImpl.updateIsActionActive(relationalid, ancName, alertStatus, isActionActive);
	}

	private List<ActionEntity> findAllActionByCaseIdAndVisitCode(
			String relationalid, String ancName) {
		return databaseRepositoryImpl.findAllActionByCaseIdAndVisitCode(relationalid, ancName);
	}

	@Transactional
	@Override
	public boolean delete(ANCEntity ancEntity) {
		return databaseRepositoryImpl.delete(ancEntity);
	}

	@Transactional
	@Override
	public void update(ANCEntity ancEntity) {
		databaseRepositoryImpl.update(ancEntity);
	}

	@Override
	public ANCEntity findById(int id) {
		return null;
	}

	@Transactional
	@Override
	public ANCEntity findByCaseId(String caseId) {
		return null;
	}

	@Transactional
	public ANCEntity findByCaseIdAndToday(String relationalId, Date today) {
		return databaseRepositoryImpl.findByCaseIdAndToday(relationalId, today, ANCEntity.class);
	}

	@Transactional
	public List<ANCEntity> findAllByCaseId(String caseId) {
		return databaseRepositoryImpl.findAllByCaseId(caseId, "ANCEntity");
	}
}
