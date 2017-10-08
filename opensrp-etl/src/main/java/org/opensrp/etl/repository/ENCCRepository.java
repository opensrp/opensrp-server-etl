package org.opensrp.etl.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opensrp.etl.entity.ENCCEntity;
import org.opensrp.etl.interfaces.RegisterRepository;

public class ENCCRepository implements RegisterRepository<ENCCEntity> {
	
	private SessionFactory sessionFactory;
	
	public ENCCRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(ENCCEntity enccEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(enccEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(ENCCEntity t) {
		// TODO Auto-generated method stub
		
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
	
	@Override
	public ENCCEntity findByCaseId(String caseID) {
		String hql = "from " + "ENCCEntity E " + " where E.caseID = :case_id";
		Query query = getSession().createQuery(hql);
		query.setParameter("case_id", caseID);
		return (ENCCEntity) query.uniqueResult();
	}
	
}
