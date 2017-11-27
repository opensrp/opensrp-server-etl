package org.opensrp.etl.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.AdolescentEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdolescentRepository implements RegisterRepository<AdolescentEntity>{

	@Autowired
	private SessionFactory sessionFactory;
	
	public AdolescentRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(AdolescentEntity adolescentEntity) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(adolescentEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean delete(AdolescentEntity adolescentEntity) {
		Query query = getSession().createQuery("delete AdolescentEntity where id = :ID");
		query.setParameter("ID", adolescentEntity.getId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void update(AdolescentEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdolescentEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdolescentEntity findByCaseId(String caseID) {
		// TODO Auto-generated method stub
		return null;
	}

	public AdolescentEntity findByCaseIdAndToday(String relationalid, Date today) {
		Criteria listAdolescentCr = getSession().createCriteria(AdolescentEntity.class);
		listAdolescentCr.add(Restrictions.eq("relationalid", relationalid));
		listAdolescentCr.add(Restrictions.eq("Today", today));
		List<AdolescentEntity> listAdolescent = listAdolescentCr.list();
		return listAdolescent.size() > 0 ? (AdolescentEntity) listAdolescent.get(0) : null;
	}

	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
}
