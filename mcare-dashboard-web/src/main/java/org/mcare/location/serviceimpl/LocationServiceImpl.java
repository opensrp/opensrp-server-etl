package org.mcare.location.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.mcare.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public LocationServiceImpl() {
		
	}
	
	@Transactional
	@Override
	public List<Object[]> getParentData() {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT location.name,location.location_id FROM location left join location_tag_map  on location.location_id =location_tag_map.location_id "
		        + "WHERE location_tag_id=:location_tag_id";
		return databaseRepositoryImpl.executeSelectQuery(sqlQuery, "location_tag_id", 1);
	}
	
	@Transactional
	@Override
	public List<Object[]> getChildData(int parentId) {
		String sqlQuery = "SELECT location.name,location.location_id from location where parent_location=:parentId";
		return databaseRepositoryImpl.executeSelectQuery(sqlQuery, "parentId", parentId);
	}
	
}
