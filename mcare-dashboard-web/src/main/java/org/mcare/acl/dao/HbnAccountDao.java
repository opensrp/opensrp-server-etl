/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package org.mcare.acl.dao;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.mcare.acl.entity.Account;
import org.mcare.acl.entity.ActiveUser;
import org.mcare.acl.entity.ActiveUserStore;
import org.mcare.acl.service.impl.UsageHistoryServiceImpl;
import org.mcare.acl.dao.AbstractHbnDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDao")
public class HbnAccountDao extends AbstractHbnDao<Account> implements AccountDao {

    private static final Logger logger = Logger.getLogger(HbnAccountDao.class);

    @Autowired
    private UsageHistoryServiceImpl usageHistoryServiceImpl;

    @Autowired
    private ActiveUserStore activeUserStore;

    @Override
    public Account getByUsername(String username) {
        return (Account) getSession().getNamedQuery("account.byUsername").setParameter("username", username).uniqueResult();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Account account = null;
        try {
            account = getByUsername(username);
            logger.info("username:" + account.getAuthorities().toString());

            logger.info("username:" + account.hashCode());


            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            logger.info("log in time:" + dateFormat.format(date));

            ActiveUser activeUser = new ActiveUser();
            activeUser.setUserName(account.getUsername());
            activeUser.setLoginTime(date);
            activeUser.setLoginDate(date);
            activeUser.setDay(getDayOfWeek());

            usageHistoryServiceImpl.save(activeUser);
            List<ActiveUser> users = activeUserStore.getUsers();
            users.add(activeUser);

            System.out.println("active users: " + users.size());



        } catch (Exception e) {
            logger.error("account null: " + e);
        }
        return account;
    }

    private String getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int dayInNumber = calendar.get(Calendar.DAY_OF_WEEK);
        String day = "";
        switch (dayInNumber) {
        case Calendar.SUNDAY:
            day = "Sunday";
            break;
        case Calendar.MONDAY:
            day = "Monday";
            break;
        case Calendar.TUESDAY:
            day = "Tuesday";
            break;
        case Calendar.WEDNESDAY:
            day = "Wednesday";
            break;
        case Calendar.THURSDAY:
            day = "Thursday";
            break;
        case Calendar.FRIDAY:
            day = "Friday";
            break;
        case Calendar.SATURDAY:
            day = "Saturday";
            break;
        }
        return day;
    }

    @Override
    public void create(Account t) {
    }

    @Override
    public Account get(Serializable id) {
        return null;
    }

    @Override
    public Account load(Serializable id) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public void update(Account t) {
    }

    @Override
    public void delete(Account t) {
    }

    @Override
    public void deleteById(Serializable id) {
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean exists(Serializable id) {
        return false;
    }
}
