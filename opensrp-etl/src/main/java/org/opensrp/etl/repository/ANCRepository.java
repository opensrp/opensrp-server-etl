package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.ANCEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ANCRepository implements RegisterRepository<ANCEntity> {
	
	private SessionFactory sessionFactory;
	
	public ANCRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(ANCEntity ancEntity) {
		System.out.println("Class: ANCRepository Method: save");
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(ancEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(ANCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(ANCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ANCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public ANCEntity findByCaseId(String caseId) {
		Criteria listANCCr = getSession().createCriteria(ANCEntity.class);
		listANCCr.add(Restrictions.eq("caseId", caseId));
		List<ANCEntity> listANC = listANCCr.list();
		System.out.println("size: " + listANC.size());
		return (ANCEntity) listANC.get(0);
	}
	
}
