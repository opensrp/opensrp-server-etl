/**
 * @author proshanto
 * */

package org.opensrp.acl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.opensrp.acl.entity.Location;
import org.opensrp.acl.entity.LocationTag;
import org.opensrp.acl.entity.User;
import org.opensrp.acl.openmrs.service.impl.OpenMRSLocationAPIService;
import org.opensrp.acl.service.AclService;
import org.opensrp.common.repository.impl.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements AclService {
	
	private static final Logger logger = Logger.getLogger(LocationServiceImpl.class);
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private OpenMRSLocationAPIService openMRSLocationAPIService;
	
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
		String uuid = openMRSLocationAPIService.add(location);
		long createdLocation = 0;
		if (!uuid.isEmpty()) {
			location.setUuid(uuid);
			createdLocation = databaseRepositoryImpl.save(location);
		} else {
			logger.error("No uuid found for user:" + location.getName());
			// TODO
		}
		return createdLocation;
	}
	
	@Transactional
	@Override
	public <T> int update(T t) throws JSONException {
		Location location = (Location) t;
		int updatedLocation = 0;
		String uuid = openMRSLocationAPIService.update(location, location.getUuid());
		if (!uuid.isEmpty()) {
			updatedLocation = databaseRepositoryImpl.update(location);
		} else {
			logger.error("No uuid found for user:" + location.getName());
			// TODO
		}
		return updatedLocation;
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
	
	public Location setCreatorParentLocationTagAttributeInLocation(Location location, int parentLocationId, int tagId) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User creator = (User) databaseRepositoryImpl.findByKey(auth.getName(), "username", User.class);
		
		Location parentLocation = (Location) databaseRepositoryImpl.findById(parentLocationId, "id", Location.class);
		LocationTag locationTag = (LocationTag) databaseRepositoryImpl.findById(tagId, "id", LocationTag.class);
		
		location.setCreator(creator);
		location.setParentLocation(parentLocation);
		location.setLocationTag(locationTag);
		
		return location;
	}
	
	public Map<Integer, String> getLocationTreeAsMap() {
		List<Location> locations = findAll("Location");
		Map<Integer, String> locationTreeAsMap = new HashMap<Integer, String>();
		for (Location location : locations) {
			locationTreeAsMap.put(location.getId(), location.getName());
			
		}
		return locationTreeAsMap;
	}
}
