package org.mcare.etl.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.mcare.etl.entity.ENCCEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ENCCService implements RegisterService<ENCCEntity> {

	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;

	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;

	public ENCCService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	@Override
	public void save(ENCCEntity enccEntity) throws Exception {
		ENCCEntity existingEnccEntity = findByCaseIdAndToday(enccEntity.getRelationalId(), enccEntity.getToday());
		if (existingEnccEntity == null) {
			databaseRepositoryImpl.save(enccEntity);
			databaseServiceImpl.actionCorrectionForAnachronousSubmission(enccEntity.getRelationalId()
					, enccEntity.getEnccName(), enccEntity.getEncc_current_formStatus());
		}
	}

	@Transactional
	@Override
	public boolean delete(ENCCEntity enccEntity) {
		return databaseRepositoryImpl.delete(enccEntity);
	}

	@Transactional
	@Override
	public void update(ENCCEntity enccEntity) {
		databaseRepositoryImpl.update(enccEntity);
	}

	@Override
	public ENCCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public ENCCEntity findByCaseIdAndToday(String relationalId, Date today) {
		return databaseRepositoryImpl.findByCaseIdAndToday(relationalId, today, ENCCEntity.class);
	}

	@Transactional
	@Override
	public ENCCEntity findByCaseId(String caseId) {
		return databaseRepositoryImpl.findByKey(caseId, "caseId", ENCCEntity.class);
	}

	@Transactional
	public List<ENCCEntity> findByRelationalId(String caseId) {
		return databaseRepositoryImpl.findAllByCaseId(caseId, "relationalId", ENCCEntity.class);
	}

}
