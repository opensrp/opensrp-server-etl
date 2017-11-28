package org.opensrp.etl.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.InjectableEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterRepositoryImpl<T> implements RegisterRepository<T>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public RegisterRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(T t) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
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
	public T findByCaseId(String caseID) {
		// TODO Auto-generated method stub
		return null;
	}

	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
}
