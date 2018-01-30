/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package org.mcare.acl.service;

import static org.springframework.util.Assert.notNull;

import java.io.Serializable;
import java.util.List;

import org.mcare.acl.entity.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Hibernate-based {@link AccountDao} implementation.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Repository("accountDao")
public class HbnAccountDao extends AbstractHbnDao<Account> implements AccountDao {
	
	/* (non-Javadoc)
	 * @see com.springinpractice.ch07.dao.AccountDao#getByUsername(java.lang.String)
	 */
	@Override
	public Account getByUsername(String username) {
		notNull(username, "username can't be null");
		return (Account) getSession().getNamedQuery("account.byUsername").setParameter("username", username).uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		notNull(username, "username can't be null");
		Account account = getByUsername(username);
		System.err.println("username:" + username);
		if (account == null) {
			throw new UsernameNotFoundException("No user with username " + username);
		}
		return account;
	}
	
	@Override
	public void create(Account t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Account get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Account load(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void update(Account t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Account t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean exists(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}
}
