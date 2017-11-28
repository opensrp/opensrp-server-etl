package org.opensrp.etl.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.PSRFEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PSRFRepository implements RegisterRepository<PSRFEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PSRFRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(PSRFEntity psrfEntity) {
		System.err.println("save");
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(psrfEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean delete(PSRFEntity psrfEntity) {
		Query query = getSession().createQuery("delete PSRFEntity where id = :ID");
		query.setParameter("ID", psrfEntity.getId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public void update(PSRFEntity psrfEntity) {
		getSession().update(psrfEntity);
		
	}
	
	@Override
	public PSRFEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	public PSRFEntity findByCaseIdAndToday(String relationalId, Date today) {
		Criteria listPsrfCr = getSession().createCriteria(PSRFEntity.class);
		listPsrfCr.add(Restrictions.eq("relationalid", relationalId));
		listPsrfCr.add(Restrictions.eq("today", today));
		List<PSRFEntity> listPsrf = listPsrfCr.list();
		return listPsrf.size() > 0 ? (PSRFEntity) listPsrf.get(0) : null;
	}
	
	@Override
	public PSRFEntity findByCaseId(String caseID) {
		// TODO Auto-generated method stub
		return null;
	}
}