package org.mcare.acl.service;

import java.util.List;

import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements AclService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public PermissionServiceImpl() {
		
	}
	
	@Override
	public <T> long save(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public <T> int update(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public <T> boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public <T> T findById(int id, String fieldName, Class<?> className) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public <T> List<T> findAll(String tableClass) {
		// TODO Auto-generated method stub
		return databaseRepositoryImpl.findAll("Permission");
	}
}
