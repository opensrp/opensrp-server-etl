/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package org.opensrp.acl.dao;

import org.opensrp.acl.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface UserDao extends Dao<User>, UserDetailsService {
	
	User getByUsername(String username);
}
