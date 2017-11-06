package org.opensrp.etl.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.ChildEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildRepository implements RegisterRepository<ChildEntity> {
	
	private SessionFactory sessionFactory;
	
	public ChildRepository() {
		
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void save(ChildEntity childEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(childEntity);
		
	}
	
	@Override
	public boolean delete(ChildEntity childEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete ChildEntity where id = :ID");
		query.setParameter("ID", childEntity.getId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public void update(ChildEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ChildEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public ChildEntity findByCaseId(String caseId) {
		Criteria listChildCr = getSession().createCriteria(ChildEntity.class);
		listChildCr.add(Restrictions.eq("caseId", caseId));
		List<ChildEntity> listChild = new ArrayList<ChildEntity>();
		listChild = listChildCr.list();
		
		return listChild.size() > 0 ? (ChildEntity) listChild.get(0) : null;
	}
}
