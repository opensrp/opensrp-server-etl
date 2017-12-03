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
		long returnValue = -1;
		try {
			session.beginTransaction();
			returnValue = (Long) session.save(t);
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			returnValue = -1;
			session.getTransaction().rollback();
		}
		finally {
			session.close();
			session.clear();
			session.evict(session);
		}
		return returnValue;
	}
	
	
	@Override
	public <T> long update(T t) {
		Session session = sessionFactory.openSession();
		long returnValue = -1;
		try {
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
			returnValue = 1;
		}
		catch (HibernateException e) {
			returnValue = -1;
			session.getTransaction().rollback();
		}
		finally {
			session.close();
			session.clear();
			session.evict(session);
		}
		return returnValue;
	}

	@Override
	public <T> boolean delete(T t) {
		Session session = sessionFactory.openSession();
		boolean returnValue = false;
		try {
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
			returnValue = true;
		}
		catch (HibernateException e) {
			returnValue = false;
			session.getTransaction().rollback();
		}
		finally {
			session.close();
			session.clear();
			session.evict(session);
		}
		return returnValue;
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
	public <T> List<T> findAll(T t, String tableClass) {
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
			session.clear();
			session.evict(session);
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
