package org.mcare.acl.service;

import java.util.List;

import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.mcare.common.interfaces.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements DatabaseService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public ProviderServiceImpl() {
		
	}
	
	@Override
	public <T> long save(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public <T> int delete(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public <T> T findById(long id, String fieldName, Class<?> className) {
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
		return databaseRepositoryImpl.findAll(tableClass);
		
	}
	
}
