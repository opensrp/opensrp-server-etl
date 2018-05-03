package org.mcare.common.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.interfaces.DatabaseService;
import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl implements DatabaseService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	public DatabaseServiceImpl() {
		
	}
	
	@Transactional
	public void test() {
		System.err.println("" + databaseRepositoryImpl);
		databaseRepositoryImpl.test();
	}
	
	@Transactional
	@Override
	public <T> long save(T t) throws Exception {
		return databaseRepositoryImpl.save(t);
	}
	
	@Transactional
	@Override
	public <T> int delete(T t) {
		return 0;
	}
	
	@Transactional
	@Override
	public <T> T findById(int id, String fieldName, Class<?> className) {
		return databaseRepositoryImpl.findById(id, fieldName, className);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public <T> List<T> findAll(String tableClass) {
		return (List<T>) databaseRepositoryImpl.findAll(tableClass);
	}
	
	@Transactional
	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		return databaseRepositoryImpl.findByKey(value, fieldName, className);
	}
	
	@Transactional
	public int count() {
		return databaseRepositoryImpl.count();
	}
	
	@Transactional
	public <T> List<T> search(SearchBuilder searchBuilder, Integer offset, Integer maxResults, Class<?> entityClassName) {
		return databaseRepositoryImpl.search(searchBuilder, offset, maxResults, entityClassName);
	}
	
	@Transactional
	public int countBySearch(SearchBuilder searchBuilder, Class<?> entityClassName) {
		return databaseRepositoryImpl.countBySearch(searchBuilder, entityClassName);
	}
	
	@Transactional
	public List<Object[]> getQueryData(String provider, String caseId, String scheduleName, String userType, String sqlQuery) {
		return databaseRepositoryImpl.executeSelectQuery(provider, caseId, scheduleName, userType, sqlQuery);
	}
}
