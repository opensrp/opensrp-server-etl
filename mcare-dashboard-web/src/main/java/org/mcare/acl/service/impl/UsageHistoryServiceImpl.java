package org.mcare.acl.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.mcare.acl.entity.ActiveUser;
import org.mcare.acl.entity.ActiveUserStore;
import org.mcare.acl.entity.ProviderEntity;
import org.mcare.acl.entity.UsageHistory;
import org.mcare.acl.service.AclService;
import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author nursat
 *
 */

@Service
public class UsageHistoryServiceImpl implements AclService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private DatabaseRepositoryImpl repository;

    @Autowired
    private ActiveUserStore activeUserStore;

    public UsageHistoryServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public <T> long save(T t) throws Exception {
        return repository.save(t);
    }

    @Override
    public <T> int update(T t) {
        return repository.update(t);
    }

    @Override
    public <T> boolean delete(T t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T findById(int id, String fieldName, Class<?> className) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T findByKey(String value, String fieldName, Class<?> className) {
        return repository.findByKey(value, fieldName, className);
    }

    @Override
    public <T> List<T> findAll(String tableClass) {
        return repository.findAll(tableClass);
    }

    public void recordUsageHistory(String username) {
        UsageHistory usageHistory = new UsageHistory();
        ActiveUser activeUser = activeUserStore.getActiveUserByUsername(username);
        
        //logger.info("activeUser.getLoginTime(): " + activeUser.getLoginTime());
        
        usageHistory.setUserName(activeUser.getUserName());
        usageHistory.setLoginTime(activeUser.getLoginTime());
        usageHistory.setLoginDate(activeUser.getLoginDate());

        logger.info("activeUser.getUserName():" + username);

        Date date = new Date();
        /* commented out due to nullpointer exception during logout
         * long difference = date.getTime() - activeUser.getLoginTime().getTime();
        difference = difference/(1000 * 60);*/
        
        long difference = 0;

        System.out.println("duration: " + difference);

        usageHistory.setDuration((int)difference);
        usageHistory.setDay(activeUser.getDay());
        usageHistory.setLogoutTime(date);


        try {
            save(usageHistory);
            activeUserStore.getUsers().remove(activeUser);
            System.out.println("recorded usage history, now active users: " + activeUserStore.getUsers().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param startDate
     * @param endDate
     * @param class1
     * @return
     */
    public List<UsageHistory> findAllBetweenStartAndEndDate(Date startDate,
            Date endDate, Class<UsageHistory> class1) {
        return repository.findAllBetweenStartAndEndDate(startDate, endDate, class1);
    }
}
