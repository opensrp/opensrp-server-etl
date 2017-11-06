package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		getSession().save(p);
		
	}
	
	@Override
	public void save(ElcoEntity elcoEntity) {
		
		try {
			getSession().save(elcoEntity);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean delete(ElcoEntity elcoEntity) {
		Query query = getSession().createQuery("delete ElcoEntity where id = :ID");
		query.setParameter("ID", elcoEntity.getId());
		int result = query.executeUpdate();
		
		if (result == 1) {
			return true;
		} else {
			return false;
		}
		
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
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public ElcoEntity findByCaseId(String caseId) {
		Criteria listElcoCr = getSession().createCriteria(ElcoEntity.class);
		listElcoCr.add(Restrictions.eq("caseId", caseId));
		List<ElcoEntity> listElco = listElcoCr.list();
		
		return listElco.size() > 0 ? (ElcoEntity) listElco.get(0) : null;
	}
}
