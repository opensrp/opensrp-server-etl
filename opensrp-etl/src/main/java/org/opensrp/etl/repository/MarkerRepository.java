package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.opensrp.etl.entity.MarkerEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MarkerRepository implements RegisterRepository<MarkerEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public MarkerRepository() {
		// TODO Auto-generated constructor stub
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@SuppressWarnings("unchecked")
	public List<MarkerEntity> getAllMarker() {
		return getSession().createQuery("from MarkerEntity").list();
	}
	
	public long getCurrentTimeStampFromMarker() {
		Query query = getSession().createQuery("select M.timeStamp from MarkerEntity M ");
		Criteria cr = getSession()
		        .createCriteria(MarkerEntity.class)
		        .setProjection(
		            Projections.projectionList().add(Projections.property("id"), "id")
		                    .add(Projections.property("timeStamp"), "timeStamp"))
		        .setResultTransformer(Transformers.aliasToBean(MarkerEntity.class));
		List<MarkerEntity> list = cr.list();
		return list.get(0).getTimeStamp();
		
	}
	
	@Override
	public void save(MarkerEntity markerEntity) {
		try {
			getSession().save(markerEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(MarkerEntity markerEntity) {
		getSession().update(markerEntity);
	}
	
	@Override
	public boolean delete(MarkerEntity markerEntity) {
		if (null != markerEntity) {
			getSession().delete(markerEntity);
		}
		return true;
		
	}
	
	@Override
	public MarkerEntity findById(int id) {
		return (MarkerEntity) getSession().get(MarkerEntity.class, id);
	}
	
	@Override
	public MarkerEntity findByCaseId(String caseID) {
		return null;
	}
	
}
