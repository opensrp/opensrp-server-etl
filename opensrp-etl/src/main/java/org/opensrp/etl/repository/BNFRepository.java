package org.opensrp.etl.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.BNFEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class BNFRepository implements RegisterRepository<BNFEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ExceptionService exceptionService;

	public BNFRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void save(BNFEntity bnfEntity) {
		try {
			getSession().save(bnfEntity);
		} catch (Exception e) {
		    exceptionService.generatedEntityAndSave(bnfEntity
                    .getRelationalid(), e.fillInStackTrace().toString(),
                    "BNFRepository", bnfEntity.getINSTANCEID(),
                    bnfEntity.get_id());
		}

	}

	@Override
	public boolean delete(BNFEntity bnfEntity) {
		Query query = getSession().createQuery("delete BNFEntity where id = :ID");
		query.setParameter("ID", bnfEntity.getId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void update(BNFEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public BNFEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	public BNFEntity findByCaseIdAndToday(String caseId, Date today) {
		Criteria listBnfCr = getSession().createCriteria(BNFEntity.class);
		listBnfCr.add(Restrictions.eq("relationalid", caseId));
		listBnfCr.add(Restrictions.eq("Today", today));
		List<BNFEntity> listBnf = listBnfCr.list();
		return listBnf.size() > 0 ? (BNFEntity) listBnf.get(0) : null;
	}
	
	@Override
	public BNFEntity findByCaseId(String caseId) {
		return null;
	}
}
