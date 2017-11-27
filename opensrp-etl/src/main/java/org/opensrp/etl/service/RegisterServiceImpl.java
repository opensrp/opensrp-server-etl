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
		System.out.println("saving Object entity");
		registerRepositoryImpl.save(entity);
		//		Object existingEntity = findByCaseIdAndToday(entity.getRelationalid(),
		//				entity.getToday());
		//		if (existingEntity == null) {
		//			injectableRepository.save(entity);
		//		} else {
		//			if (delete(existingEntity))
		//				injectableRepository.save(entity);
		//		}

	}

	@Transactional
	@Override
	public boolean delete(T t) {
		return registerRepositoryImpl.delete(t);
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
