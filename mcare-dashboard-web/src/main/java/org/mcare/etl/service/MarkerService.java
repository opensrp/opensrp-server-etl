package org.mcare.etl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.mcare.etl.entity.MarkerEntity;
import org.mcare.etl.interfaces.RegisterService;
import org.mcare.etl.repository.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkerService implements RegisterService<MarkerEntity> {
	
	@Autowired
	private MarkerRepository markerRepository;
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public MarkerService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(MarkerEntity markerEntity) {
		markerRepository.save(markerEntity);
		
	}
	
	@Transactional
	@Override
	public boolean delete(MarkerEntity markerEntity) {
		return markerRepository.delete(markerEntity);
		
	}
	
	@Transactional
	@Override
	public void update(MarkerEntity markerEntity) {
		markerRepository.update(markerEntity);
		
	}
	
	@Transactional
	@Override
	public MarkerEntity findById(int id) {
		return markerRepository.findById(id);
	}
	
	@Override
	public MarkerEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public List<MarkerEntity> getAllMarker() {
		return markerRepository.getAllMarker();
	}
	
	@Transactional
	public long getCurrentTimeStampFromMarker() {
		
		// TODO Auto-generated method stub
		return markerRepository.getCurrentTimeStampFromMarker();
	}
	
	@Transactional
	public MarkerEntity findByName(String name) {
		// TODO Auto-generated method stub
		return databaseRepositoryImpl.findByKey(name, "name", MarkerEntity.class);
	}
	
}
