package org.opensrp.etl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.MarkerEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkerService implements RegisterService<MarkerEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public MarkerService() {
	}
	
	@Transactional
	@Override
	public void save(MarkerEntity markerEntity) {
		commonDatabaseRepository.save(markerEntity);
	}
	
	@Transactional
	@Override
	public boolean delete(MarkerEntity markerEntity) {
		return commonDatabaseRepository.delete(markerEntity);
	}
	
	@Transactional
	@Override
	public void update(MarkerEntity markerEntity) {
		commonDatabaseRepository.update(markerEntity);
	}
	
	@Transactional
	@Override
	public MarkerEntity findById(int id) {
		return null;
	}
	
	@Override
	public MarkerEntity findByCaseId(String caseId) {
		return null;
	}
	
	@Transactional
	public List<MarkerEntity> getAllMarker() {
		return null;
	}
	
	@Transactional
	public MarkerEntity findByName(String name) {
		return commonDatabaseRepository.findByKey(name, "name", MarkerEntity.class);
	}
	
}
