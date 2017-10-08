package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.ActionEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionRepository implements RegisterRepository<ActionEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ActionRepository() {
		// TODO Auto-generated constructor stub
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public void save(ActionEntity actionEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(actionEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(ActionEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(ActionEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ActionEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int isActionExist(String caseId, String visitCode, String alertStatus, String startDate) {
		Session session = this.sessionFactory.getCurrentSession();
		int actionExist = 0;
		try {
			String hql = "select A.caseID from " + "ActionEntity A " + "where A.caseID = :case_id "
			        + "and A.visitCode = :visit_code " + "and A.alertStatus = :alert_status "
			        + " and A.startDate = :start_date";
			Query query = session.createQuery(hql);
			query.setParameter("case_id", caseId);
			query.setParameter("visit_code", visitCode);
			query.setParameter("alert_status", alertStatus);
			query.setParameter("start_date", startDate);
			actionExist = query.list().size();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
		return actionExist;
	}
	
	@Override
	public ActionEntity findByCaseId(String caseId) {
		Criteria listActionCr = getSession().createCriteria(ActionEntity.class);
		listActionCr.add(Restrictions.eq("caseId", caseId));
		List<ActionEntity> listAction = listActionCr.list();
		System.out.println("size: " + listAction.size());
		return (ActionEntity) listAction.get(0);
	}
}
