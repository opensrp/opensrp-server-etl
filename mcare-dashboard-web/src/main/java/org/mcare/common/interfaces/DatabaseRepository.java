package org.mcare.common.interfaces;

import java.util.List;

public interface DatabaseRepository {
	
	public <T> int save(T t);
	
	public <T> int delete(T t);
	
	public <T> T findById(int id, String fieldName, Class<?> className);
	
	public <T> List<T> findAll(T t, String tableClass);
	
}
