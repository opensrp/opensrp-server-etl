package org.opensrp.etl.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.PSRFEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PSRFRepository implements RegisterRepository<PSRFEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PSRFRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(PSRFEntity psrfEntity) {
		System.err.println("save");
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(psrfEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean delete(PSRFEntity psrfEntity) {
		Query query = getSession().createQuery("delete PSRFEntity where id = :ID");
		query.setParameter("ID", psrfEntity.getId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public void update(PSRFEntity psrfEntity) {
		getSession().update(psrfEntity);
		
	}
	
	@Override
	public PSRFEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	public PSRFEntity findByCaseIdAndToday(String relationalId, Date today) {
		Criteria listPsrfCr = getSession().createCriteria(PSRFEntity.class);
		listPsrfCr.add(Restrictions.eq("relationalid", relationalId));
		listPsrfCr.add(Restrictions.eq("today", today));
		List<PSRFEntity> listPsrf = listPsrfCr.list();
		return listPsrf.size() > 0 ? (PSRFEntity) listPsrf.get(0) : null;
	}
	
	@Override
	public PSRFEntity findByCaseId(String caseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public int calculateBirthControlMethodUsages(int birth_control) {
		String sql = "SELECT * FROM psrf WHERE birth_control = :Birth_Control";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(PSRFEntity.class);
		query.setParameter("Birth_Control", birth_control);
		List results = query.list();
		int count = results.size();
		System.out.print("birth control: " + count);
		return count;
	}

}
