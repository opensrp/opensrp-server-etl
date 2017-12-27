package org.opensrp.etl.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.DeathRegEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeathRegRepository implements RegisterRepository<DeathRegEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ExceptionService exceptionService;

    public DeathRegRepository() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void save(DeathRegEntity deathRegEntity) {
        try {
            getSession().save(deathRegEntity);
        } catch (Exception e) {
            exceptionService.generatedEntityAndSave(deathRegEntity
                    .getRelationalid(), e.fillInStackTrace().toString(),
                    "DeathRegEntity", deathRegEntity.getINSTANCEID(),
                    deathRegEntity.get_id());
        }

    }

    @Override
    public boolean delete(DeathRegEntity deathRegEntity) {
        Query query = getSession().createQuery(
                "delete DeathRegEntity where id = :ID");
        query.setParameter("ID", deathRegEntity.getId());
        int result = query.executeUpdate();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void update(DeathRegEntity t) {
        // TODO Auto-generated method stub

    }

    @Override
    public DeathRegEntity findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DeathRegEntity findByCaseId(String caseID) {
        // TODO Auto-generated method stub
        return null;
    }

    private Session getSession() {
        Session session = this.sessionFactory.getCurrentSession();
        return session;
    }

    public DeathRegEntity findByCaseIdAndToday(String relationalId,
            Date death_today) {
        Criteria listDeathRegCr = getSession().createCriteria(
                DeathRegEntity.class);
        listDeathRegCr.add(Restrictions.eq("relationalid", relationalId));
        listDeathRegCr.add(Restrictions.eq("death_today", death_today));

        List<DeathRegEntity> listDeathReg = listDeathRegCr.list();

        return listDeathReg.size() > 0 ? (DeathRegEntity) listDeathReg.get(0)
                : null;
    }
}
