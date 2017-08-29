package org.opensrp.etl.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.MarkerEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MarkerRepository implements RegisterRepository<MarkerEntity> {
	
	public MarkerRepository() {
		// TODO Auto-generated constructor stub
	}
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void save(MarkerEntity entity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(entity);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(MarkerEntity markerEntity) {
		Session session = getSession();
		session.update(markerEntity);
		
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	public MarkerEntity getMarkerByNameAndType(String name, String type) {
		/*Query query = getSession().createQuery("from marker where name = :name" +
				" where stockCode = :stockCode");
		query.setParameter("name", "household");*/
		Session session = getSession();
		Criteria cr = session.createCriteria(MarkerEntity.class);
		cr.add(Restrictions.eq("name", name));
		cr.add(Restrictions.eq("type", type));
		return (MarkerEntity) cr.list().get(0);
		
	}
	
	@Override
	public void delete(MarkerEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public MarkerEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
