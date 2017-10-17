package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.PNCEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PNCRepository implements RegisterRepository<PNCEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PNCRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(PNCEntity pncEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(pncEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean delete(PNCEntity t) {
		return true;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(PNCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public PNCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public PNCEntity findByCaseId(String caseId) {
		Criteria listPNCCr = getSession().createCriteria(PNCEntity.class);
		listPNCCr.add(Restrictions.eq("caseId", caseId));
		List<PNCEntity> listPNC = listPNCCr.list();
		System.out.println("size: " + listPNC.size());
		return listPNC.size() > 0 ? (PNCEntity) listPNC.get(0) : null;
	}
}
