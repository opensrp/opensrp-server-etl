/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package org.opensrp.acl.service;

import org.opensrp.acl.entity.Account;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface AccountService {
	
	Account getAccountByUsername(String username);
}
