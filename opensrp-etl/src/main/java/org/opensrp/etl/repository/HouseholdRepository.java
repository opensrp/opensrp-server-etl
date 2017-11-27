package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
		try {
			System.err.println("looooooooo");
			getSession().save(entity);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean delete(HouseholdEntity householdEntity) {
		
		Query query = getSession().createQuery("delete HouseholdEntity where id = :ID");
		query.setParameter("ID", householdEntity.getId());
		int result = query.executeUpdate();
		
		if (result == 1) {
			return true;
		} else {
			return false;
		}
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
		
		return listHousehold.size() > 0 ? (HouseholdEntity) listHousehold.get(0) : null;
	}
	
	public List<HouseholdEntity> list() {
		getSession();
		return null;
		//getSession().
	}
	
}
