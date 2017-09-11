package org.opensrp.etl.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opensrp.etl.entity.ActionEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionRepository implements RegisterRepository<ActionEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ActionRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public void actionRepositoryPrint() {
		System.out.println("Class:ActionRepository, method: actionRepositoryPrint");
	}
	
	@Override
	public void save(ActionEntity actionEntity) {
		System.out.println("Class: ActionRepository Method: save");
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
	
	public int findActionByCaseId(String caseId, String visitCode, String alertStatus, String startDate) {
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
			System.out.println("number of  action fetched from database: " + actionExist);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
		return actionExist;
	}
	
}
