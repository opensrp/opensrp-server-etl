package org.opensrp.etl.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.opensrp.etl.entity.MemberEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.opensrp.etl.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository implements RegisterRepository<MemberEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ExceptionService exceptionService;

    public MemberRepository() {
        // TODO Auto-generated constructor stub
    }

    public void addElco(MemberEntity p) {
        getSession().save(p);

    }

    @Override
    public void save(MemberEntity memberEntity) {
        try {
            getSession().save(memberEntity);
        } catch (Exception e) {
            exceptionService.generatedEntityAndSave(memberEntity
                    .getRelationalid(), e.fillInStackTrace().toString(),
                    "MemberRepository", memberEntity.getINSTANCEID(),
                    memberEntity.get_id());
        }
    }

    @Override
    public boolean delete(MemberEntity memberEntity) {
        Query query = getSession().createQuery(
                "delete MemberEntity where id = :ID");
        query.setParameter("ID", memberEntity.getId());
        int result = query.executeUpdate();

        if (result == 1) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void update(MemberEntity t) {
        // TODO Auto-generated method stub

    }

    @Override
    public MemberEntity findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    private Session getSession() {
        Session session = this.sessionFactory.getCurrentSession();
        return session;
    }

    @Override
    public MemberEntity findByCaseId(String caseId) {
        Criteria listElcoCr = getSession().createCriteria(MemberEntity.class);
        listElcoCr.add(Restrictions.eq("caseId", caseId));
        List<MemberEntity> listElco = listElcoCr.list();

        return listElco.size() > 0 ? (MemberEntity) listElco.get(0) : null;
    }
}
