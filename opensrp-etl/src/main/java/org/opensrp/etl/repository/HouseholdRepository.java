package org.opensrp.etl.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opensrp.etl.entity.HouseholdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HouseholdRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public HouseholdRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public void save(HouseholdEntity entity) {
		
		Session session = this.sessionFactory.getCurrentSession();
		System.err.println("dd: " + session + "+ entity:" + entity.toString());
		try {
			session.save(entity);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(HouseholdEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	public void update(HouseholdEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	public HouseholdEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
