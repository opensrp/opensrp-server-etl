package org.opensrp.etl.service;

import javax.transaction.Transactional;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.RegisterRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterServiceImpl<T> implements RegisterService<T>{

	@Autowired
	private RegisterRepositoryImpl registerRepositoryImpl;
	
	public RegisterServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	@Override
	public void save(T entity) {
		registerRepositoryImpl.save(entity);
	}

	@Transactional
	@Override
	public boolean delete(T entity) {
		return registerRepositoryImpl.delete(entity);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findByCaseId(String caseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
