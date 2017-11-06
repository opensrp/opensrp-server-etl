package org.opensrp.etl.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.ENCCEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ENCCRepository implements RegisterRepository<ENCCEntity> {
	
	private SessionFactory sessionFactory;
	
	public ENCCRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(ENCCEntity enccEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(enccEntity);
		
	}
	
	@Override
	public boolean delete(ENCCEntity enccEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete ENCCEntity where id = :ID");
		query.setParameter("ID", enccEntity.getId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public void update(ENCCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ENCCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	public ENCCEntity findByCaseIdAndToday(String relationalId, Date today) {
		Criteria listPsrfCr = getSession().createCriteria(ENCCEntity.class);
		listPsrfCr.add(Restrictions.eq("relationalId", relationalId));
		listPsrfCr.add(Restrictions.eq("today", today));
		List<ENCCEntity> listPsrf = listPsrfCr.list();
		return listPsrf.size() > 0 ? listPsrf.get(0) : null;
	}
	
	@Override
	public ENCCEntity findByCaseId(String caseId) {
		Criteria listENCCCr = getSession().createCriteria(ENCCEntity.class);
		listENCCCr.add(Restrictions.eq("caseId", caseId));
		List<ENCCEntity> lisENCC = listENCCCr.list();
		
		return lisENCC.size() > 0 ? (ENCCEntity) lisENCC.get(0) : null;
	}
	
}
