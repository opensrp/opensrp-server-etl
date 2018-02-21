package org.mcare.acl.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.acl.dao.AccountDao;
import org.mcare.acl.entity.Account;
import org.mcare.acl.entity.Permission;
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
	public void registerNewUserAccount(Account account) {
		if (emailExist(account.getEmail())) {
			System.out.println("Account already exist");
		} else {
			//account.setUsername(account.getUsername());
			//account.setFirstName(account.getFirstName());
			//account.setLastName(account.getLastName());
			//account.setEmail(account.getEmail());
			account.setEnabled(true);
			account.setPassword(passwordEncoder.encode(account.getPassword()));
			//account.setRetypePassword(account.getRetypePassword());
			System.err.println("Account:" + account.toString());
			repository.save(account);
		}
	}
	
	@Transactional
	public void managePermissions(Permission permission) {
		permission.setName(permission.getName());
		repository.save(permission);
	}
	
	private boolean emailExist(String email) {
		Account account = repository.findByKey(email, "email", Account.class);
		if (account != null) {
			return true;
		}
		return false;
	}
	
	public String isValid(Account account) {
		return String.valueOf(passwordEncoder.matches(account.getRetypePassword(), account.getPassword()));
	}
	
	@Override
	public <T> long save(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public <T> int update(T t) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public <T> List<T> findAll(String tableClass) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
