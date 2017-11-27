package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.NutritionEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NutritionRepository implements RegisterRepository<NutritionEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public NutritionRepository() {
		
	}
	
	@Override
	public void save(NutritionEntity nutritionEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(nutritionEntity);
		
	}
	
	@Override
	public boolean delete(NutritionEntity nutritionEntity) {
		Query query = getSession().createQuery("delete NutritionEntity where id = :ID");
		query.setParameter("ID", nutritionEntity.getId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public void update(NutritionEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public NutritionEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	public NutritionEntity findByCaseIdAndServerVersion(String relationalId, Long serverVersion) {
		Criteria listMotherCr = getSession().createCriteria(NutritionEntity.class);
		listMotherCr.add(Restrictions.eq("relationalid", relationalId));
		listMotherCr.add(Restrictions.eq("serverVersion", serverVersion));
		List<NutritionEntity> lisFilterMother = listMotherCr.list();
		return lisFilterMother.size() > 0 ? (NutritionEntity) lisFilterMother.get(0) : null;
	}
	
	@Override
	public NutritionEntity findByCaseId(String caseID) {
		// TODO Auto-generated method stub
		return null;
	}
}
