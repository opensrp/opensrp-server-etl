package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.ENCCEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ENCCRepository implements RegisterRepository<ENCCEntity> {
	
	private SessionFactory sessionFactory;
	
	public ENCCRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(ENCCEntity enccEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(enccEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		} // TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(ENCCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(ENCCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ENCCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public ENCCEntity findByCaseId(String caseId) {
		Criteria listENCCCr = getSession().createCriteria(ENCCEntity.class);
		listENCCCr.add(Restrictions.eq("caseId", caseId));
		List<ENCCEntity> lisENCC = listENCCCr.list();
		System.out.println("size: " + lisENCC.size());
		return lisENCC.size() > 0 ? (ENCCEntity) lisENCC.get(0) : null;
	}
	
}
