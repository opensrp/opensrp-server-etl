package org.opensrp.etl.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.common.interfaces.DatabaseRepository;
import org.opensrp.etl.entity.FilterCriteria;
import org.opensrp.etl.entity.MIS1ReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDatabaseRepository implements DatabaseRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CommonDatabaseRepository() {
		
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
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAllByCriteria(Class<?> className, FilterCriteria filtercriteria) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		boolean hasPrerequisite = false;
		if (filtercriteria != null) {
			System.out.println("FilterCriteria: " + filtercriteria.toString());
			if (filtercriteria.getYear() != null && !filtercriteria.getYear().isEmpty()) {
				criteria.add(Restrictions.eq("reporting_year", filtercriteria.getYear()));
				System.out.println("set criteria year");
			}
			
			if (filtercriteria.getMonth() != null && !filtercriteria.getMonth().isEmpty()) {
				criteria.add(Restrictions.eq("reporting_month", filtercriteria.getMonth()));
				System.out.println("set criteria month");
			}
			if (filtercriteria.getDivision() != null && !filtercriteria.getDivision().isEmpty()) {
				criteria.add(Restrictions.eq("reporting_division", filtercriteria.getDivision()));
				System.out.println("set criteria division");
				hasPrerequisite = true;
			}
			if (hasPrerequisite && (filtercriteria.getDistrict() != null && !filtercriteria.getDistrict().isEmpty())) {
				criteria.add(Restrictions.eq("reporting_district", filtercriteria.getDistrict()));
				System.out.println("set criteria district");
				hasPrerequisite = true;
			} else {
				hasPrerequisite = false;
			}
			if (hasPrerequisite && (filtercriteria.getUpazilla() != null && !filtercriteria.getUpazilla().isEmpty())) {
				criteria.add(Restrictions.eq("reporting_upazilla", filtercriteria.getUpazilla()));
				System.out.println("set criteria upazilla");
				hasPrerequisite = true;
			} else {
				hasPrerequisite = false;
			}
			
			if (hasPrerequisite && (filtercriteria.getUnionname() != null && !filtercriteria.getUnionname().isEmpty())) {
				criteria.add(Restrictions.eq("reporting_union", filtercriteria.getUnionname()));
				System.out.println("set criteria unionname");
				hasPrerequisite = true;
			} else {
				hasPrerequisite = false;
			}
			
			if (hasPrerequisite && (filtercriteria.getWard() != null && !filtercriteria.getWard().isEmpty())) {
				criteria.add(Restrictions.eq("reporting_ward", filtercriteria.getWard()));
				System.out.println("set criteria ward");
				hasPrerequisite = true;
			} else {
				hasPrerequisite = false;
			}
			
			if (hasPrerequisite && (filtercriteria.getUnit() != null && !filtercriteria.getUnit().isEmpty())) {
				criteria.add(Restrictions.eq("reporting_unit", filtercriteria.getUnit()));
				System.out.println("set criteria unit");
				hasPrerequisite = true;
			}
			
			if (filtercriteria.getProvider() != null && !filtercriteria.getProvider().isEmpty()) {
				criteria.add(Restrictions.eq("reporting_provider", filtercriteria.getProvider()));
				System.out.println("set criteria provider");
			}
			
		}
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		System.out.println("result: " + result.toString());
		session.close();
		
		if (result.size() <= 0) {
			int misId = generateMISReport(filtercriteria);
			if (misId != -1) {
				result = findById(misId, MIS1ReportEntity.class);
				System.out.println("result: " + result.toString());
			}
		}
		
		return result;
	}
	
	public <T> List<T> checkEmptyCriteria(FilterCriteria filterCriteria) {
		List<T> list = new ArrayList<T>();
		String s = "missing filter criteria: ";
		list.add((T) s);
		if (filterCriteria.getDivision() == null) {
			list.add((T) "division");
		}
		if (filterCriteria.getDistrict() == null) {
			list.add((T) "district");
		}
		if (filterCriteria.getUpazilla() == null) {
			list.add((T) "upazilla");
		}
		if (filterCriteria.getUnionname() == null) {
			list.add((T) "unionname");
		}
		if (filterCriteria.getWard() == null) {
			list.add((T) "ward");
		}
		if (filterCriteria.getUnit() == null) {
			list.add((T) "unit");
		}
		if (filterCriteria.getMonth() == null) {
			list.add((T) "month");
		}
		if (filterCriteria.getYear() == null) {
			list.add((T) "month");
		}
		if (filterCriteria.getProvider() == null) {
			list.add((T) "month");
		}
		return list;
	}
	
	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		System.out.println("finding key:" + value);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq(fieldName, value));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}
	
	public <T> List<T> findById(int Id, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq("id", Id));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (result.size() > 0 ? result : null);
	}
	
	public <T> T findByCaseIdAndToday(String relationalId, Date today, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq("relationalid", relationalId));
		criteria.add(Restrictions.eq("Today", today));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}
	
	public <T> T findByCaseIdAndToday(String keyName, String relationalId, Date today, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq("relationalid", relationalId));
		criteria.add(Restrictions.eq(keyName, today));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}
	
	public <T> T findByCaseIdAndName(String keyName, String relationalId, String name, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq("relationalid", relationalId));
		criteria.add(Restrictions.eq(keyName, name));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}
	
	public <T> T findByBaseEntityIdAndServerVersion(String baseEntityId, long serverVersion, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq("baseEntityId", baseEntityId));
		criteria.add(Restrictions.eq("serverVersion", serverVersion));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}
	
	public <T> T findByRelationalIdAndServerVersion(String relationalid, long serverVersion, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq("relationalid", relationalid));
		criteria.add(Restrictions.eq("serverVersion", serverVersion));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}
	
	public int isActionExist(String baseEntityId, String visitCode, String alertStatus, Date startDate) {
		Session session = sessionFactory.openSession();
		int actionExist = 0;
		try {
			String hql = "select A.baseEntityId from " + "ActionEntity A " + "where A.baseEntityId = :base_entity_id "
			        + "and A.visitCode = :visit_code " + "and A.alertStatus = :alert_status "
			        + " and A.startDate = :start_date";
			Query query = session.createQuery(hql);
			query.setParameter("base_entity_id", baseEntityId);
			query.setParameter("visit_code", visitCode);
			query.setParameter("alert_status", alertStatus);
			query.setParameter("start_date", startDate);
			actionExist = query.list().size();
			session.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return actionExist;
	}
	
	public int generateMISReport(FilterCriteria filter) {
		Session session = sessionFactory.openSession();
		int Id = -1;
		try {
			String hql = "SELECT * FROM generate_mis_report(:division,:district"
			        + ",:upazilla,:unionname,:ward,:unit,:currentM,:currentY,:provider) m";
			
			if (filter.getDivision() != null && filter.getDistrict() != null && filter.getUpazilla() != null
			        && filter.getUnionname() != null && filter.getWard() != null && filter.getUnit() != null
			        && filter.getMonth() != null && filter.getYear() != null && filter.getProvider() != null) {
				Query query = session.createSQLQuery(hql).setParameter("division", filter.getDivision())
				        .setParameter("district", filter.getDistrict()).setParameter("upazilla", filter.getUpazilla())
				        .setParameter("unionname", filter.getUnionname()).setParameter("ward", filter.getWard())
				        .setParameter("unit", filter.getUnit()).setParameter("currentM", filter.getMonth())
				        .setParameter("currentY", filter.getYear()).setParameter("provider", filter.getProvider());
				List results = query.list();
				Id = (Integer) results.get(0);
			}
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return Id;
	}
	
	public int isEventExist(String baseEntityId, long version) {
		Session session = sessionFactory.openSession();
		int eventExist = 0;
		try {
			String hql = "select E.baseEntityId from " + "EventEntity E " + "where E.baseEntityId = :base_entity_id "
			        + "and E.version = :version ";
			Query query = session.createQuery(hql);
			query.setParameter("base_entity_id", baseEntityId);
			query.setParameter("version", version);
			System.out.println("query: " + query);
			eventExist = query.list().size();
			session.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return eventExist;
	}
}
