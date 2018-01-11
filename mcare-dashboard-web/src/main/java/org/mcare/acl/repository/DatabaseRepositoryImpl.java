package org.mcare.acl.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.mcare.common.interfaces.DatabaseRepository;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.params.builder.SearchBuilder;
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
		Transaction tx = null;
		long returnValue = -1;
		try {
			tx = session.beginTransaction();
			session.save(t);
			returnValue = 1;
			if (!tx.wasCommitted())
				tx.commit();
		}
		catch (HibernateException e) {
			returnValue = -1;
			tx.rollback();
		}
		finally {
			session.close();
		}
		return returnValue;
	}
	
	@Override
	public <T> int update(T t) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int returnValue = -1;
		try {
			tx = session.beginTransaction();
			session.update(t);
			if (!tx.wasCommitted())
				tx.commit();
			returnValue = 1;
		}
		catch (HibernateException e) {
			returnValue = -1;
			tx.rollback();
		}
		finally {
			session.close();
		}
		return returnValue;
	}
	
	@Override
	public <T> boolean delete(T t) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean returnValue = false;
		try {
			tx = session.beginTransaction();
			session.delete(t);
			if (!tx.wasCommitted())
				tx.commit();
			returnValue = true;
		}
		catch (HibernateException e) {
			returnValue = false;
			tx.rollback();
		}
		finally {
			session.close();
			
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
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(String tableClass) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			Query query = session.createQuery("from " + tableClass + " t order by t.id desc");
			//query.setFirstResult(0);
			//query.setMaxResults(10);
			result = (List<T>) query.list();
		}
		catch (Exception e) {
			System.out.println("error:" + e.getMessage());
		}
		finally {
			session.close();
		}
		
		return (List<T>) result;
	}
	
	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		System.out.println("finding caseId:" + value);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq(fieldName, value));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		System.out.println("finding result:" + result.toString());
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}
	
	public <T> T findByCaseIdAndToday(String relationalId, Date today, Class<?> className) {
		System.out.println("finding caseId and today relationalId:" + relationalId);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq("relationalId", relationalId));
		criteria.add(Restrictions.eq("today", today));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		System.out.println("finding result:" + result.toString());
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}
	
	public int isActionExist(String caseId, String visitCode, String alertStatus, Date startDate) {
		Session session = sessionFactory.openSession();
		int actionExist = 0;
		try {
			String hql = "select A.caseId from " + "ActionEntity A " + "where A.caseId = :case_id "
			        + "and A.visitCode = :visit_code " + "and A.alertStatus = :alert_status "
			        + " and A.startDate = :start_date";
			Query query = session.createQuery(hql);
			query.setParameter("case_id", caseId);
			query.setParameter("visit_code", visitCode);
			query.setParameter("alert_status", alertStatus);
			query.setParameter("start_date", startDate);
			actionExist = query.list().size();
			session.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
		return actionExist;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> list(int result, int offsetreal, Class<?> entityClassName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(entityClassName);
		criteria.setFirstResult(offsetreal);
		criteria.setMaxResults(result);
		System.err.println("result:" + result + "offsetreal" + offsetreal);
		List<T> products = null;
		try {
			products = (List<T>) criteria.list();
			session.close();
		}
		catch (Exception e) {
			
		}
		
		return products;
	}
	
	public int count() {
		return sessionFactory.openSession().createCriteria(HouseholdEntity.class).list().size();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> executeSelectQuery(String sqlQuery, String paramName, int paramValue) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);
		query.setParameter(paramName, paramValue);
		List<Object[]> results = query.list();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> search(SearchBuilder searchBuilder, int result, int offsetreal, Class<?> entityClassName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(entityClassName);
		
		criteria.setFirstResult(offsetreal);
		criteria.setMaxResults(result);
		System.err.println("result:" + result + "offsetreal" + offsetreal);
		List<T> products = null;
		try {
			products = (List<T>) criteria.list();
			session.close();
		}
		catch (Exception e) {
			
		}
		
		return products;
	}
}
