package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.ChildEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildRepository implements RegisterRepository<ChildEntity> {
	
	private SessionFactory sessionFactory;
	
	public ChildRepository() {
		
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(ChildEntity childEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(childEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(ChildEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(ChildEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ChildEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public ChildEntity findByCaseId(String caseId) {
		Criteria listChildCr = getSession().createCriteria(ChildEntity.class);
		listChildCr.add(Restrictions.eq("caseId", caseId));
		List<ChildEntity> listChild = listChildCr.list();
		System.out.println("size: " + listChild.size());
		return (ChildEntity) listChild.get(0);
	}
}
