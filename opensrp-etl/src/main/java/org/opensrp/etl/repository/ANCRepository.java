package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.ANCEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class ANCRepository implements RegisterRepository<ANCEntity> {

    @Autowired
	private SessionFactory sessionFactory;

    @Autowired
    private ExceptionService exceptionService;

	public ANCRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(ANCEntity ancEntity) {
		try {
            getSession().save(ancEntity);
        } catch (Exception e) {
            exceptionService.generatedEntityAndSave(ancEntity
                    .getRelationalid(), e.fillInStackTrace().toString(),
                    "ANCRepository", ancEntity.getINSTANCEID(),
                    ancEntity.get_id());
        }
		
	}
	
	@Override
	public boolean delete(ANCEntity ancEntity) {
		Query query = getSession().createQuery("delete ANCEntity where id = :ID");
		query.setParameter("ID", ancEntity.getId());
		int result = query.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void update(ANCEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ANCEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public ANCEntity findByCaseId(String caseId) {
		Criteria listANCCr = getSession().createCriteria(ANCEntity.class);
		listANCCr.add(Restrictions.eq("caseId", caseId));
		List<ANCEntity> listANC = listANCCr.list();
		return listANC.size() > 0 ? (ANCEntity) listANC.get(0) : null;
	}
	
	public ANCEntity findByCaseIdAndName(String relationalId, String name) {
		Criteria listPsrfCr = getSession().createCriteria(ANCEntity.class);
		listPsrfCr.add(Restrictions.eq("relationalid", relationalId));
		listPsrfCr.add(Restrictions.eq("ancName", name));
		List<ANCEntity> listPsrf = listPsrfCr.list();
		
		return listPsrf.size() > 0 ? listPsrf.get(0) : null;
	}
	
}
