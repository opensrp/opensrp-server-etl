package org.mcare.acl.service;

import java.util.List;

public interface AclService {
	
	public <T> long save(T t);
	
	public <T> int update(T t);
	
	public <T> boolean delete(T t);
	
	public <T> T findById(int id, String fieldName, Class<?> className);
	
	public <T> T findByKey(String value, String fieldName, Class<?> className);
	
	public <T> List<T> findAll(String tableClass);
}
