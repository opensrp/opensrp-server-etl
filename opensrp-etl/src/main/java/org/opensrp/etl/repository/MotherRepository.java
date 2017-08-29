package org.opensrp.etl.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opensrp.etl.entity.MotherEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MotherRepository implements RegisterRepository<MotherEntity> {
	
	private SessionFactory sessionFactory;
	
	public MotherRepository() {
		System.out.println("constructor: MotherRepository");
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(MotherEntity motherEntity) {
		System.out.println("Class: MotherRepository Method: save");
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(motherEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(MotherEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(MotherEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public MotherEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
