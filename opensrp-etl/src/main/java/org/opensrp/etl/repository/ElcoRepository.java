package org.opensrp.etl.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opensrp.etl.entity.ElcoEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ElcoRepository implements RegisterRepository<ElcoEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ElcoRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public void addElco(ElcoEntity p) {
		Session session = this.sessionFactory.getCurrentSession();
		
		try {
			session.save(p);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Phone saved successfully, Phone Details=" + p);
	}
	
	@Override
	public void save(ElcoEntity elcoEntity) {
		System.out.println("Class: ElcoRepository Method: save: " + elcoEntity);
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(elcoEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(ElcoEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(ElcoEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ElcoEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
