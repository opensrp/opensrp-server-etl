package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
		session.save(motherEntity);
		
	}
	
	@Override
	public boolean delete(MotherEntity motherEntity) {
		Query query = getSession().createQuery("delete MotherEntity where id = :ID");
		query.setParameter("ID", motherEntity.getId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
		
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
		return lisFilterMother.size() > 0 ? (MotherEntity) lisFilterMother.get(0) : null;
	}
}
