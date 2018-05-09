package org.mcare.common.repository.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.mcare.common.interfaces.DatabaseRepository;
import org.mcare.etl.entity.ANCEntity;
import org.mcare.etl.entity.ActionEntity;
import org.mcare.etl.entity.BNFEntity;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.etl.entity.PNCEntity;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseRepositoryImpl implements DatabaseRepository {

	private static final Logger logger = Logger.getLogger(DatabaseRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public DatabaseRepositoryImpl() {

	}

	public void test() {
		logger.debug("sessionFactory:" + sessionFactory);
	}

	@Override
	public <T> long save(T t) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		long returnValue = -1;
		try {
			tx = session.beginTransaction();
			session.save(t);
			logger.info("saved successfully: " + t.getClass().getName());
			returnValue = 1;
			if (!tx.wasCommitted())
				tx.commit();
		}
		catch (HibernateException e) {
			returnValue = -1;
			tx.rollback();
			throw new Exception(e.getMessage());
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
			logger.info("updated successfully");
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
			logger.info("deleting: " + t.getClass().getName());
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
	public <T> T findById(int id, String fieldName, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq(fieldName, id));
		List<T> result = criteria.list();
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}

	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq(fieldName, value));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}

	@SuppressWarnings("unchecked")
	public boolean findByUserName(String value, String fieldName, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq(fieldName, value));
		List<Object> result = criteria.list();
		session.close();
		return (result.size() > 0 ? true : false);
	}

	public <T> T findByCaseIdAndToday(String relationalId, Date today, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq("relationalId", relationalId));
		criteria.add(Restrictions.eq("today", today));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}

	public <T> T findByCaseIdAndBNFDate(String relationalId, Date bnfdate, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq("relationalId", relationalId));
		criteria.add(Restrictions.eq("FWBNFDATE", bnfdate));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (T) (result.size() > 0 ? (T) result.get(0) : null);
	}

	public ActionEntity getAction(String caseId, String visitCode, String alertStatus, Date startDate) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ActionEntity.class);
		criteria.add(Restrictions.eq("visitCode", visitCode));
		criteria.add(Restrictions.eq("caseId", caseId));
		criteria.add(Restrictions.eq("alertStatus", alertStatus));
		criteria.add(Restrictions.eq("startDate", startDate));
		@SuppressWarnings("unchecked")
		List<ActionEntity> actions = criteria.list();
		session.close();
		if (actions.size() == 0) {
			return null;
		}
		return (ActionEntity) actions.get(0);
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
			logger.error("error:" + e.getMessage());
		}
		finally {
			session.close();
		}

		return (List<T>) result;
	}

	public <T> List<T> findAllByKey(String value, String fieldName, Class<?> className) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(className);
		criteria.add(Restrictions.eq(fieldName, value));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (List<T>) (result.size() > 0 ? (List<T>) result : null);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> list(int result, int offsetreal, Class<?> entityClassName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(entityClassName);
		criteria.setFirstResult(offsetreal);
		criteria.setMaxResults(result);
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
	public <T> List<T> search(SearchBuilder searchBuilder, int result, int offsetreal, Class<?> entityClassName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(entityClassName);

		if (searchBuilder.getDivision() != null && !searchBuilder.getDivision().isEmpty()) {
			criteria.add(Restrictions.eq("division", searchBuilder.getDivision().toUpperCase()));
		}
		if (searchBuilder.getDistrict() != null && !searchBuilder.getDistrict().isEmpty()) {

			criteria.add(Restrictions.eq("district", searchBuilder.getDistrict().toUpperCase()));
		}
		if (searchBuilder.getUpazila() != null && !searchBuilder.getUpazila().isEmpty()) {

			criteria.add(Restrictions.eq("upazila", searchBuilder.getUpazila()));
		}
		if (searchBuilder.getUnion() != null && !searchBuilder.getUnion().isEmpty()) {
			criteria.add(Restrictions.eq("union", searchBuilder.getUnion()));
		}
		if (searchBuilder.getWard() != null && !searchBuilder.getWard().isEmpty()) {
			criteria.add(Restrictions.eq("ward", searchBuilder.getWard()));
		}
		if (searchBuilder.getMauzapara() != null && !searchBuilder.getMauzapara().isEmpty()) {
			criteria.add(Restrictions.eq("mauzaPara", searchBuilder.getMauzapara()));
		}
		if (searchBuilder.getSubunit() != null && !searchBuilder.getSubunit().isEmpty()) {
			criteria.add(Restrictions.eq("subunit", searchBuilder.getSubunit()));
		}

		if (searchBuilder.getProvider() != null && !searchBuilder.getProvider().isEmpty()) {
			criteria.add(Restrictions.eq("provider", searchBuilder.getProvider()));
		}
		if (searchBuilder.getName() != null && !searchBuilder.getName().isEmpty()) {
			criteria.add(Restrictions.ilike("firstName", searchBuilder.getName().toUpperCase(), MatchMode.ANYWHERE));
		}
		criteria.setFirstResult(offsetreal);
		criteria.setMaxResults(result);
		criteria.addOrder(Order.desc("created"));

		List<T> products = null;
		try {
			products = (List<T>) criteria.list();
			session.close();
		}
		catch (Exception e) {
			logger.error(e);
		}

		return products;
	}

	public int countBySearch(SearchBuilder searchBuilder, Class<?> entityClassName) {
		Session session = sessionFactory.openSession();
		int count = 0;
		Criteria criteria = session.createCriteria(entityClassName);
		try {

			if (searchBuilder.getDivision() != null && !searchBuilder.getDivision().isEmpty()) {

				criteria.add(Restrictions.eq("division", searchBuilder.getDivision().toUpperCase()));
			}
			if (searchBuilder.getDistrict() != null && !searchBuilder.getDistrict().isEmpty()) {

				criteria.add(Restrictions.eq("district", searchBuilder.getDistrict().toUpperCase()));
			}
			if (searchBuilder.getUpazila() != null && !searchBuilder.getUpazila().isEmpty()) {

				criteria.add(Restrictions.eq("upazila", searchBuilder.getUpazila()));
			}
			if (searchBuilder.getUnion() != null && !searchBuilder.getUnion().isEmpty()) {
				criteria.add(Restrictions.eq("union", searchBuilder.getUnion()));
			}
			if (searchBuilder.getWard() != null && !searchBuilder.getWard().isEmpty()) {
				criteria.add(Restrictions.eq("ward", searchBuilder.getWard()));
			}
			if (searchBuilder.getMauzapara() != null && !searchBuilder.getMauzapara().isEmpty()) {
				criteria.add(Restrictions.eq("mauzaPara", searchBuilder.getMauzapara()));
			}
			if (searchBuilder.getSubunit() != null && !searchBuilder.getSubunit().isEmpty()) {
				criteria.add(Restrictions.eq("subunit", searchBuilder.getSubunit()));
			}
			if (searchBuilder.getProvider() != null && !searchBuilder.getProvider().isEmpty()) {
				criteria.add(Restrictions.eq("provider", searchBuilder.getProvider()));
			}
			if (searchBuilder.getName() != null && !searchBuilder.getName().isEmpty()) {
				criteria.add(Restrictions.ilike("firstName", searchBuilder.getName(), MatchMode.ANYWHERE));
			}
			count = criteria.list().size();
			session.close();
		}
		catch (Exception e) {
			session.close();
		}

		return count;
	}

	@SuppressWarnings("unchecked")
	public List<ActionEntity> findAllPendingChildVisits(String caseId, String provider) {
		Session session = sessionFactory.openSession();
		List<ActionEntity> result = null;

		try {
			Query query = session.createQuery("from ActionEntity where caseId = :case_id "
					+ "and provider = :provider_id "
					+ "and isActionActive = :is_action_active "
					+ "and visitCode LIKE :visit_code ");
			query.setParameter("case_id", caseId);
			query.setParameter("provider_id", provider);
			query.setParameter("is_action_active", true);
			query.setParameter("visit_code", "encc%");
			result = query.list();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<ActionEntity> findAllPendingMotherVisits(String caseId, List<ANCEntity> anclist
			, List<PNCEntity> pnclist, List<BNFEntity> bnflist) {
		Session session = sessionFactory.openSession();
		List<ActionEntity> result = null;

		try {
			String hql = "FROM ActionEntity where caseId = '" + caseId + "'"
					+ " and isActionActive = true "
					+ " and (visitCode LIKE :visit_code_anc "
					+ " or visitCode LIKE :visit_code_pnc "
					+ " or (visitCode = :visit_code_bnf ";

			if(bnflist != null && !bnflist.isEmpty()) {
				for(BNFEntity bnf : bnflist) {
					hql = hql + " and ( visitCode = :visit_code_bnf and startDate > '" + bnf.getStart() + "') " ;
				}
			}
			hql = hql + "))";

			if(anclist != null && !anclist.isEmpty()) {
				for(ANCEntity anc : anclist) {
					hql = hql + " and not visitCode = '" + anc.getAncName() + "'";
				}
			}

			if(pnclist != null && !pnclist.isEmpty()) {
				for(PNCEntity pnc : pnclist) {
					hql = hql + " and not visitCode = '" + pnc.getPncName() + "'";
				}
			}

			Query query = session.createQuery(hql);
			query.setParameter("visit_code_anc", "anc%");
			query.setParameter("visit_code_pnc", "pnc%");
			query.setParameter("visit_code_bnf", "BirthNotificationPregnancyStatusFollowUp");
			result = query.list();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> executeSelectQuery(String sqlQuery, String paramName, int paramValue) {
		Session session = sessionFactory.openSession();
		List<Object[]> results = null;
		try {
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.setParameter(paramName, paramValue);
			results = query.list();
			session.close();
		}
		catch (Exception e) {
			session.close();
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> executeSelectQuery(String provider, String caseId, String scheduleName, String userType,
			String sqlQuery) {

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);

		if (!provider.isEmpty()) {
			query.setParameter("provider", provider);
		}
		if (!caseId.isEmpty()) {
			query.setParameter("case_id", caseId);
		}
		if (!scheduleName.isEmpty()) {
			query.setParameter("scheduleName", scheduleName);
		}
		if (!userType.isEmpty()) {
			query.setParameter("userType", userType);
		}
		List<Object[]> results = query.list();

		return results;
	}

	public <T> List<T> findAllActionByCaseIdAndVisitCode(String relationalid, String ancName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ActionEntity.class);
		criteria.add(Restrictions.eq("caseId", relationalid));
		criteria.add(Restrictions.eq("visitCode", ancName));
		@SuppressWarnings("unchecked")
		List<T> result = criteria.list();
		session.close();
		return (List<T>) (result.size() > 0 ? (List<T>) result : null);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getDataFromSQLFunction(String procedureName, String params) {
		Session session = sessionFactory.openSession();
		List<T> aggregatedData = null;
		try {
			String hql = "select * from " + procedureName + "(" + params + ")";
			Query query = session.createSQLQuery(hql);
			aggregatedData = query.list();
			logger.info("data fetched successfully from " + procedureName + ", aggregated data size: "
					+ aggregatedData.size());
			session.close();
		}
		catch (Exception e) {
			logger.error("Data fetch from " + procedureName + " error:" + e.getMessage());
		}
		return aggregatedData;
	}
}
