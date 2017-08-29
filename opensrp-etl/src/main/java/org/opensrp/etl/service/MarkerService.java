package org.opensrp.etl.service;

import org.opensrp.etl.entity.MarkerEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkerService implements RegisterService<MarkerEntity> {
	
	@Autowired
	private MarkerRepository markerRepository;
	
	public MarkerService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(MarkerEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(MarkerEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(MarkerEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public MarkerEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public MarkerEntity findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
