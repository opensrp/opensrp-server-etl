package org.opensrp.etl.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opensrp.etl.entity.ChildEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildRepository implements RegisterRepository<ChildEntity> {
	
	private SessionFactory sessionFactory;
	
	public ChildRepository() {
		System.out.println("constructor: MotherRepository");
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(ChildEntity childEntity) {
		System.out.println("Class: ChildRepository Method: save");
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
	
}
