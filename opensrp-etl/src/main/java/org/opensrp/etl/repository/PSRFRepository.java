package org.opensrp.etl.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.PSRFEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PSRFRepository implements RegisterRepository<PSRFEntity> {
	
	private SessionFactory sessionFactory;
	
	public PSRFRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(PSRFEntity psrfEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(psrfEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(PSRFEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(PSRFEntity t) {
		// TODO Auto-generated method stub
		
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
		listPsrfCr.add(Restrictions.eq("relationalId", relationalId));
		listPsrfCr.add(Restrictions.eq("today", today));
		List<PSRFEntity> listPsrf = listPsrfCr.list();
		return listPsrf.size() > 0 ? listPsrf.get(0) : null;
	}
	
	@Override
	public PSRFEntity findByCaseId(String caseID) {
		// TODO Auto-generated method stub
		return null;
	}
}
