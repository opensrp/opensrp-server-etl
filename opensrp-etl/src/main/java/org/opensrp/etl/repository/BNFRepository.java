package org.opensrp.etl.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	public void delete(BNFEntity t) {
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
	
	@Override
	public BNFEntity findByCaseId(String caseID) {
		String hql = "from " + "BNFEntity B " + " where B.caseID = :case_id";
		Query query = getSession().createQuery(hql);
		query.setParameter("case_id", caseID);
		return (BNFEntity) query.uniqueResult();
	}
}
