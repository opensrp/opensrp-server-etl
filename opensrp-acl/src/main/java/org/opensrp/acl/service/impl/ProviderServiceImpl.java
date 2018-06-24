package org.opensrp.acl.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.opensrp.common.interfaces.DatabaseService;
import org.opensrp.common.repository.impl.DatabaseRepositoryImpl;
import org.opensrp.acl.entity.ProviderEntity;
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
		return 0;
	}
	
	@Override
	public <T> int delete(T t) {
		return 0;
	}
	
	@Override
	public <T> T findById(int id, String fieldName, Class<?> className) {
		return null;
	}
	
	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		return null;
	}
	
	@Transactional
	@Override
	public <T> List<T> findAll(String tableClass) {
		return databaseRepositoryImpl.findAll(tableClass);
	}
	
	public void setProviderAttribute(HttpSession session) {
		List<ProviderEntity> providers = findAll("ProviderEntity");
		session.setAttribute("providers", providers);
	}
	
	@Override
	public <T> long update(T t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
