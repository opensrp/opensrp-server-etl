package org.opensrp.etl.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		System.out.println("Class: PSRFRepository Method: save");
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
	
}
