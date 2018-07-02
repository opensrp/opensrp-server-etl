package org.opensrp.acl.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.opensrp.acl.entity.Location;
import org.opensrp.acl.entity.LocationTag;
import org.opensrp.acl.entity.User;
import org.opensrp.acl.service.AclService;
import org.opensrp.common.repository.impl.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements AclService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public LocationServiceImpl() {
		
	}
	
	@Transactional
	public List<Object[]> getLocationByTagId(int tagId) {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT location.name,location.location_id FROM location left join location_tag_map  on location.location_id =location_tag_map.location_id "
		        + "WHERE location_tag_id=:location_tag_id";
		return databaseRepositoryImpl.executeSelectQuery(sqlQuery, "location_tag_id", tagId);
	}
	
	@Transactional
	public List<Object[]> getChildData(int parentId) {
		String sqlQuery = "SELECT location.name,location.location_id from location where parent_location=:parentId";
		return databaseRepositoryImpl.executeSelectQuery(sqlQuery, "parentId", parentId);
	}
	
	@Transactional
	@Override
	public <T> long save(T t) throws Exception {
		Location location = (Location) t;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User creator = (User) databaseRepositoryImpl.findByKey(auth.getName(), "username", User.class);
		
		Location parentLocation = (Location) databaseRepositoryImpl.findById(location.getParentLocation().getId(), "id",
		    Location.class);
		
		LocationTag locationTag = (LocationTag) databaseRepositoryImpl.findById(location.getLocationTag().getId(), "id",
		    LocationTag.class);
		
		location.setCreator(creator);
		location.setParentLocation(parentLocation);
		location.setLocationTag(locationTag);
		return databaseRepositoryImpl.save(t);
	}
	
	@Transactional
	@Override
	public <T> int update(T t) {
		return databaseRepositoryImpl.update(t);
	}
	
	@Transactional
	@Override
	public <T> boolean delete(T t) {
		return databaseRepositoryImpl.delete(t);
	}
	
	@Transactional
	@Override
	public <T> T findById(int id, String fieldName, Class<?> className) {
		return databaseRepositoryImpl.findById(id, fieldName, className);
	}
	
	@Transactional
	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		return databaseRepositoryImpl.findByKey(value, fieldName, className);
	}
	
	@Transactional
	@Override
	public <T> List<T> findAll(String tableClass) {
		return databaseRepositoryImpl.findAll(tableClass);
	}
}
