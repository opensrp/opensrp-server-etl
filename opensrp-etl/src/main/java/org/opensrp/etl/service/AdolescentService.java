package org.opensrp.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.AdolescentEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.AdolescentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdolescentService implements RegisterService<AdolescentEntity>{

	@Autowired
	private AdolescentRepository adolescentRepository;

	public AdolescentService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	@Override
	public void save(AdolescentEntity adolescentEntity) {
		AdolescentEntity existingadolescentEntity = findByCaseIdAndToday(adolescentEntity.getRelationalid(),
				adolescentEntity.getToday());
		if (existingadolescentEntity == null) {
			adolescentRepository.save(adolescentEntity);
		} else {
			if (delete(existingadolescentEntity))
				adolescentRepository.save(adolescentEntity);
		}
		
	}

	private AdolescentEntity findByCaseIdAndToday(String relationalid,
			Date today) {
		return adolescentRepository.findByCaseIdAndToday(relationalid, today);
	}

	@Override
	public boolean delete(AdolescentEntity adolescentEntity) {
		return adolescentRepository.delete(adolescentEntity);
	}

	@Override
	public void update(AdolescentEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdolescentEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdolescentEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
