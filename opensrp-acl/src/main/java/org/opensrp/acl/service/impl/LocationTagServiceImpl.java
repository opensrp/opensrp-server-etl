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
import org.opensrp.acl.entity.LocationTag;
import org.opensrp.acl.entity.User;
import org.opensrp.acl.openmrs.service.impl.OpenMRSTagAPIService;
import org.opensrp.acl.service.AclService;
import org.opensrp.common.repository.impl.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LocationTagServiceImpl implements AclService {
	
	private static final Logger logger = Logger.getLogger(LocationTagServiceImpl.class);
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private OpenMRSTagAPIService openMRSTagAPIService;
	
	public LocationTagServiceImpl() {
		
	}
	
	@Transactional
	@Override
	public <T> long save(T t) throws Exception {
		LocationTag locationTag = (LocationTag) t;
		String uuid = openMRSTagAPIService.add(locationTag);
		long createdTag = 0;
		if (!uuid.isEmpty()) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User creator = (User) databaseRepositoryImpl.findByKey(auth.getName(), "username", User.class);
			locationTag.setCreator(creator);
			locationTag.setUuid(uuid);
			createdTag = databaseRepositoryImpl.save(t);
		} else {
			logger.error("No uuid found for user:" + locationTag.getName());
			// TODO
		}
		
		return createdTag;
	}
	
	@Transactional
	@Override
	public <T> int update(T t) throws JSONException {
		LocationTag locationTag = (LocationTag) t;
		int updatedTag = 0;
		String uuid = openMRSTagAPIService.update(locationTag, locationTag.getUuid());
		if (!uuid.isEmpty()) {
			updatedTag = databaseRepositoryImpl.update(locationTag);
		} else {
			logger.error("No uuid found for user:" + locationTag.getName());
			// TODO
		}
		return updatedTag;
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
	
	public Map<Integer, String> getLocationTagListAsMap() {
		List<LocationTag> locationTags = findAll("LocationTag");
		Map<Integer, String> locationsTagMap = new HashMap<Integer, String>();
		for (LocationTag locationTag : locationTags) {
			locationsTagMap.put(locationTag.getId(), locationTag.getName());
			
		}
		
		return locationsTagMap;
	}
}
