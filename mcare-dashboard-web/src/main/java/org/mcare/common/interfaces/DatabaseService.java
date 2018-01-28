package org.mcare.common.interfaces;

import java.util.List;

public interface DatabaseService {
	
	public <T> long save(T t);
	
	public <T> int delete(T t);
	
	public <T> T findById(int id, String fieldName, Class<?> className);
	
	public <T> T findByKey(String value, String fieldName, Class<?> className);
	
	public <T> List<T> findAll(String tableClass);
}
