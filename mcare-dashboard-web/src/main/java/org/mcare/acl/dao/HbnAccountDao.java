/* 
 * Copyright (c) 2013 Manning Publications Co.
 * 
 * Book: http://manning.com/wheeler/
 * Blog: http://springinpractice.com/
 * Code: https://github.com/springinpractice
 */
package org.mcare.acl.dao;

import java.io.Serializable;
import java.util.List;

import org.mcare.acl.entity.Account;
import org.mcare.acl.dao.AbstractHbnDao;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDao")
public class HbnAccountDao extends AbstractHbnDao<Account> implements AccountDao {

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
			System.out.println("username:" + account.getAuthorities().toString());
		} catch (Exception e) {
			System.err.println("account null: " + e);
		}
		return account;
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
