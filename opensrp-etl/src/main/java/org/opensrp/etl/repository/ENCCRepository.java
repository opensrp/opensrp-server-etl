package org.opensrp.etl.repository;

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
		System.out.println("Class: ENCCRepository Method: save");
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
	
}
