package org.mcare.acl.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.mcare.acl.dao.AccountDao;
import org.mcare.acl.entity.Account;
import org.mcare.acl.entity.Role;
import org.mcare.acl.service.AclService;
import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements AclService {
	
	@Autowired
	private DatabaseRepositoryImpl repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AccountDao accountDao;
	
	@Transactional
	public void registerNewUserAccount(Account account) throws Exception {
		try {
			account.setEnabled(true);
			account.setPassword(passwordEncoder.encode(account.getPassword()));
			save(account);
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	private boolean emailExist(String email) {
		Account account = repository.findByKey(email, "email", Account.class);
		if (account != null) {
			return true;
		}
		return false;
	}
	
	@Transactional
	@Override
	public <T> long save(T t) throws Exception {
		return repository.save(t);
	}
	
	@Transactional
	@Override
	public <T> int update(T t) {
		return repository.update(t);
	}
	
	@Transactional
	@Override
	public <T> boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Transactional
	@Override
	public <T> T findById(int id, String fieldName, Class<?> className) {
		// TODO Auto-generated method stub
		return repository.findById(id, fieldName, className);
		
	}
	
	@Transactional
	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public <T> List<T> findAll(String tableClass) {
		// TODO Auto-generated method stub
		return repository.findAll(tableClass);
	}
	
	@Transactional
	public Set<Role> setRoles(int[] selectedRoles) {
		Set<Role> roles = new HashSet<Role>();
		if (selectedRoles != null) {
			for (int roleId : selectedRoles) {
				System.err.println(roleId);
				Role role = repository.findById(roleId, "id", Role.class);
				roles.add(role);
			}
		}
		return roles;
	}

	public boolean isPasswordMatched(Account account) {
		return passwordEncoder.matches(account.getRetypePassword(), passwordEncoder.encode(account.getPassword()));
	}
}
