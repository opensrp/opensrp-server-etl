package org.opensrp.etl.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.BNFEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BNFRepository implements RegisterRepository<BNFEntity> {
	
	private SessionFactory sessionFactory;
	
	public BNFRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(BNFEntity bnfEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(bnfEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean delete(BNFEntity t) {
		return true;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(BNFEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public BNFEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	public BNFEntity findByCaseIdAndToday(String relationalId, Date FWBNFDATE) {
		Criteria listPsrfCr = getSession().createCriteria(BNFEntity.class);
		listPsrfCr.add(Restrictions.eq("relationalId", relationalId));
		listPsrfCr.add(Restrictions.eq("FWBNFDATE", FWBNFDATE));
		List<BNFEntity> listPsrf = listPsrfCr.list();
		return listPsrf.size() > 0 ? listPsrf.get(0) : null;
	}
	
	@Override
	public BNFEntity findByCaseId(String caseId) {
		Criteria listBNFCr = getSession().createCriteria(BNFEntity.class);
		listBNFCr.add(Restrictions.eq("caseId", caseId));
		List<BNFEntity> listBNF = listBNFCr.list();
		System.out.println("size: " + listBNF.size());
		return listBNF.size() > 0 ? (BNFEntity) listBNF.get(0) : null;
	}
}
