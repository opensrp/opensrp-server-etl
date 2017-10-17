package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.MotherEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MotherRepository implements RegisterRepository<MotherEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public MotherRepository() {
		
	}
	
	@Override
	public void save(MotherEntity motherEntity) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(motherEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean delete(MotherEntity t) {
		return true;
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
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public MotherEntity findByCaseId(String caseId) {
		Criteria listMotherCr = getSession().createCriteria(MotherEntity.class);
		listMotherCr.add(Restrictions.eq("caseId", caseId));
		List<MotherEntity> lisFilterMother = listMotherCr.list();
		System.out.println("size: " + lisFilterMother.size());
		return lisFilterMother.size() > 0 ? (MotherEntity) lisFilterMother.get(0) : null;
	}
}
