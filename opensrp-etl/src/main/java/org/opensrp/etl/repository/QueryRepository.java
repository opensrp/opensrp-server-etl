package org.opensrp.etl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opensrp.etl.entity.MemberEntity;
import org.opensrp.etl.entity.PSRFEntity;
import org.opensrp.etl.interfaces.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class QueryRepository implements RegisterRepository<Object> {

    private static final int BIRTH_CONTROL_PILL = 1;
    private static final int BIRTH_CONTROL_CONDOM = 2;
    private static final int BIRTH_CONTROL_INJECTABLE = 3;
    private static final int BIRTH_CONTROL_IUD = 4;
    private static final int BIRTH_CONTROL_IMPLANT = 5;
    private static final int BIRTH_CONTROL_MALE_PERMANENT = 6;
    private static final int BIRTH_CONTROL_FEMALE_PERMANENT = 7;

    public static final int BIRTH_CONTROL_NOT_USING_ANY_METHOD = 99;
    public static final int USING_FAMILY_PLANNING = 0;
    public static final int NOT_USING_FAMILY_PLANNING = 0;

    private static final String MEMBER_GENDER_MALE = "1";
    private static final String MEMBER_GENDER_FEMALE = "2";

    @Autowired
    private SessionFactory sessionFactory;

    public QueryRepository() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void save(Object t) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean delete(Object t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void update(Object t) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object findByCaseId(String caseID) {
        // TODO Auto-generated method stub
        return null;
    }

    private Session getSession() {
        Session session = this.sessionFactory.getCurrentSession();
        return session;
    }

    @Transactional
    public int calculateNewBirthControlMethodUsages(int birth_control,
            String district, int year, int month) {
        String sql = "SELECT * FROM psrf WHERE birth_control = :Birth_Control"
                + " AND EXTRACT(MONTH FROM today) = :month"
                + " AND EXTRACT(YEAR FROM today) = :year";
        List results = getSession().createSQLQuery(sql)
                .addEntity(PSRFEntity.class)
                .setParameter("Birth_Control", birth_control)
                .setParameter("month", month).setParameter("year", year).list();
        int count = results.size();
        return count;
    }

    @Transactional
    public int calculateOldBirthControlMethodUsages(int birth_control) {
        String sql = "SELECT * FROM psrf WHERE birth_control = :Birth_Control";
        List results = getSession().createSQLQuery(sql)
                .addEntity(PSRFEntity.class)
                .setParameter("Birth_Control", birth_control).list();
        int count = results.size();
        return count;
    }

    @Transactional
    public int calculatePermanentMethodUsages() {
        String sql = "SELECT {p.*}, {m.*} FROM psrf p JOIN member m ON (p.relationalid = m.caseId)"
                + " WHERE m.member_gender = :member_gender"
                + " AND p.birth_control = :Birth_Control";
        List results = getSession().createSQLQuery(sql)
                .addEntity("p", PSRFEntity.class)
                .addEntity("m", MemberEntity.class)
                .setParameter("member_gender", MEMBER_GENDER_MALE)
                .setParameter("Birth_Control", BIRTH_CONTROL_MALE_PERMANENT)
                .list();
        int count = results.size();
        return count;
    }

    @Transactional
    public int calculateLeftMethodAndStartedNone() {
        String sql = "SELECT {p1.*}, {p2.*} FROM psrf p1, psrf p2"
                + " WHERE (p1.relationalid = p2.relationalid "
                + " AND (p1.birth_control = :Birth_Control1)"
                + " AND (p2.birth_control = :Birth_Control2 and p2.using_fp = :Using_FP))";
        List results = getSession()
                .createSQLQuery(sql)
                .addEntity("p1", PSRFEntity.class)
                .addEntity("p2", PSRFEntity.class)
                .setParameter("Birth_Control1", BIRTH_CONTROL_PILL)
                .setParameter("Birth_Control2",
                        BIRTH_CONTROL_NOT_USING_ANY_METHOD)
                .setParameter("Using_FP", USING_FAMILY_PLANNING).list();
        int count = results.size();
        return count;
    }

    @Transactional
    public int calculateLeftMethodAndStartedOtherMethod() {
        String sql = "SELECT {p.*}, {m.*} FROM psrf p JOIN member m ON (p.relationalid = m.caseId)"
                + " WHERE m.member_gender = :member_gender"
                + " AND p.birth_control = :Birth_Control";
        List results = getSession().createSQLQuery(sql)
                .addEntity("p", PSRFEntity.class)
                .addEntity("m", MemberEntity.class)
                .setParameter("member_gender", MEMBER_GENDER_MALE)
                .setParameter("Birth_Control", BIRTH_CONTROL_MALE_PERMANENT)
                .list();
        int count = results.size();
        return count;
    }

    @Transactional
    public int calculateNewPillUsages(String district, int year, int month) {
        return calculateNewBirthControlMethodUsages(BIRTH_CONTROL_PILL,
                district, year, month);
    }

    @Transactional
    public int calculateOldCondomUsages() {
        return calculateOldBirthControlMethodUsages(BIRTH_CONTROL_CONDOM);
    }

    @Transactional
    public int calculateleftPillAndStartedNone() {
        return calculateOldBirthControlMethodUsages(BIRTH_CONTROL_PILL);
    }
}
