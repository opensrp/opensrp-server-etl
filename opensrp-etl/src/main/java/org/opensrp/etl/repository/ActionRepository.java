package org.opensrp.etl.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opensrp.etl.entity.ActionEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionRepository implements RegisterRepository<ActionEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ActionRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public void actionRepositoryPrint() {
		System.out.println("Class:ActionRepository, method: actionRepositoryPrint");
	}
	
	@Override
	public void save(ActionEntity actionEntity) {
		System.out.println("Class: ActionRepository Method: save");
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(actionEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(ActionEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(ActionEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ActionEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
