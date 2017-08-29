package org.opensrp.etl.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opensrp.etl.entity.PNCEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PNCRepository implements RegisterRepository<PNCEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PNCRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(PNCEntity pncEntity) {
		System.out.println("Class: PNCRepository Method: save");
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(pncEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(PNCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(PNCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public PNCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
