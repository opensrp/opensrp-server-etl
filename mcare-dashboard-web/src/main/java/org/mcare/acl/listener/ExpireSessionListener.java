package org.mcare.acl.listener;

import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.mcare.acl.entity.ActiveUser;
import org.mcare.acl.entity.ActiveUserStore;
import org.mcare.acl.entity.UsageHistory;
import org.mcare.acl.service.impl.UsageHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

/**
 * @author nursat
 *
 */
@Service
@EnableScheduling
@Configuration
@EnableAsync
public class ExpireSessionListener {
    private static final int EXPIRE_MINUTES = 30;

    private static final Logger logger = Logger.getLogger(ExpireSessionListener.class);

    @Autowired
    private ActiveUserStore activeUserStore;

    @Autowired
    private UsageHistoryServiceImpl usageHistoryServiceImpl;

    public ExpireSessionListener() {
    }

    public void sessionListener() throws Exception {
        logger.info("listening to session");

        if (activeUserStore.getUsers() != null  && !activeUserStore.getUsers().isEmpty()) {
            Iterator<ActiveUser> iter = activeUserStore.getUsers().iterator();

            while (iter.hasNext()) {
                ActiveUser ac = iter.next();

                logger.info("logged in users: " + ac.getLastActiveTime());
                if (isNotActive(ac.getLastActiveTime())) {
                    saveExpiredSessionUser(ac);
                    iter.remove();
                    activeUserStore.getUsers().remove(ac);
                    logger.info("active users: " + activeUserStore.getUsers().size());
                }
            }
        }
    }

    /**
     * @param ac
     */
    private void saveExpiredSessionUser(ActiveUser activeUser) {
        UsageHistory usageHistory = new UsageHistory();
        usageHistory.setUserName(activeUser.getUserName());
        usageHistory.setLoginTime(activeUser.getLoginTime());
        usageHistory.setLoginDate(activeUser.getLoginDate());

        logger.info("saving activeUser.getUserName():" + activeUser.getUserName());

        Date date = new Date();
        long difference = date.getTime() - activeUser.getLoginTime().getTime();
        difference = difference/(1000 * 60);

        System.out.println("duration: " + difference);

        usageHistory.setDuration((int)difference);
        usageHistory.setDay(activeUser.getDay());
        usageHistory.setLogoutTime(date);

        try {
            usageHistoryServiceImpl.save(usageHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * {@link #isNotActive(Date) isNotActive}
     * check if whether any user is inactive more than session expiring time or not
     * @param lastActiveTime
     * @return boolean
     */
    private boolean isNotActive(Date lastActiveTime) {
        Date currentTime = new Date();
        long difference = currentTime.getTime() - lastActiveTime.getTime();
        difference = difference/(1000 * 60);

        if (difference > EXPIRE_MINUTES) {
            System.out.println("not active for 2 minutes");
            return true;
        }
        return false;
    }

}
