package org.mcare.etl.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserRepository(){
		
	}
	
	public void test(){
		System.err.println("sessionFactory:"+sessionFactory);
	}
}
