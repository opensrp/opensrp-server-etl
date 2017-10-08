package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.HouseholdEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HouseholdRepository implements RegisterRepository<HouseholdEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public HouseholdRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
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
	
	@Override
	public void delete(HouseholdEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(HouseholdEntity householdEntity) {
		getSession().update(householdEntity);
		
	}
	
	@Override
	public HouseholdEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public HouseholdEntity findByCaseId(String caseId) {
		Criteria listHouseholdCr = getSession().createCriteria(HouseholdEntity.class);
		listHouseholdCr.add(Restrictions.eq("caseId", caseId));
		List<HouseholdEntity> listHousehold = listHouseholdCr.list();
		System.out.println("size: " + listHousehold.size());
		return listHousehold.size() > 0 ? (HouseholdEntity) listHousehold.get(0) : null;
	}
	
}
