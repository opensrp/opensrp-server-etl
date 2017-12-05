package org.opensrp.etl.repository;

import java.util.Date;
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
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ChildRepository() {
		
	}
	
	@Override
	public void save(ChildEntity childEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(childEntity);
		//session.merge(childEntity);
		
	}
	
	@Override
	public boolean delete(ChildEntity childEntity) {
		Query query = getSession().createQuery("delete ChildEntity where id = :ID");
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

	public ChildEntity findByCaseIdAndToday(String relationalId, Date today) {
		Criteria listChildCr = getSession().createCriteria(ChildEntity.class);
		listChildCr.add(Restrictions.eq("relationalid", relationalId));
		listChildCr.add(Restrictions.eq("Today", today));

		List<ChildEntity> listChild = listChildCr.list();
		return listChild.size() > 0 ? (ChildEntity) listChild.get(0) : null;
	}

	@Override
	public ChildEntity findByCaseId(String caseId) {
		return null;
	}
}
