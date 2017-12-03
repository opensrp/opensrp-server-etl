package org.mcare.acl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.mcare.common.interfaces.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseRepositoryImpl implements DatabaseRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public DatabaseRepositoryImpl() {
		
	}
	
	public void test() {
		System.err.println("sessionFactory:" + sessionFactory);
	}
	
	@Override
	public <T> long save(T t) {
		Session session = sessionFactory.openSession();
		long returnValue = 0;
		try {
			session.beginTransaction();
			returnValue = (Long) session.save(t);
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			returnValue = 0;
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		return returnValue;
	}
	
	@Override
	public <T> int delete(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T findById(long id, String fieldName, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq(fieldName, id));
		List<T> result = criteria.list();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(String tableClass) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			Query query = session.createQuery("from " + tableClass);
			query.setMaxResults(10);
			result = (List<T>) query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return (List<T>) result;
	}
	
	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq(fieldName, value));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}
	
}
