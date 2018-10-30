package org.mcare.acl.listener;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mcare.acl.entity.ActiveUser;
import org.mcare.acl.entity.ActiveUserStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author nursat
 *
 */
public class SessionTimerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(SessionTimerInterceptor.class);

    @Autowired
    private HttpSession session;

    @Autowired
    private ActiveUserStore activeUserStore;

    public SessionTimerInterceptor() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Executed before actual handler is executed
     **/
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String userName = "";
        if (auth != null) {
            userName = auth.getName();
            logger.info("Prehandle: " + auth.getName());
        }

        for (ActiveUser ac : activeUserStore.getUsers()) {
            if (ac.getUserName().equalsIgnoreCase(userName)) {
                ac.setLastActiveTime(new Date());
            }
        }

        return true;
    }

    /**
     * Executed before after handler is executed
     **/
    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView model) throws Exception {
        //logger.info("Post handle method - check execution time of handling");
    }
}
