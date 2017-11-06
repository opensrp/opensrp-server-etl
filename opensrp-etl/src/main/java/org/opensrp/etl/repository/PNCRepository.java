package org.opensrp.etl.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.PNCEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PNCRepository implements RegisterRepository<PNCEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PNCRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(PNCEntity pncEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(pncEntity);
		
	}
	
	@Override
	public boolean delete(PNCEntity pncEntity) {
		Query query = getSession().createQuery("delete PNCEntity where id = :ID");
		query.setParameter("ID", pncEntity.getId());
		int result = query.executeUpdate();
		
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void update(PNCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public PNCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public PNCEntity findByCaseId(String caseId) {
		Criteria listPNCCr = getSession().createCriteria(PNCEntity.class);
		listPNCCr.add(Restrictions.eq("caseId", caseId));
		List<PNCEntity> listPNC = listPNCCr.list();
		
		return listPNC.size() > 0 ? (PNCEntity) listPNC.get(0) : null;
	}
	
	public PNCEntity findByCaseIdAndToday(String relationalId, Date today) {
		Criteria listPsrfCr = getSession().createCriteria(PNCEntity.class);
		listPsrfCr.add(Restrictions.eq("relationalid", relationalId));
		listPsrfCr.add(Restrictions.eq("today", today));
		List<PNCEntity> listPsrf = listPsrfCr.list();
		
		return listPsrf.size() > 0 ? listPsrf.get(0) : null;
	}
}
