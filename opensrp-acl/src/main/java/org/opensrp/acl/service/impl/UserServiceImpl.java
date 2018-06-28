package org.opensrp.acl.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.opensrp.acl.entity.Role;
import org.opensrp.acl.entity.User;
import org.opensrp.acl.openmrs.service.impl.OpenMRSUserAPIService;
import org.opensrp.acl.service.AclService;
import org.opensrp.common.repository.impl.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements AclService {
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private DatabaseRepositoryImpl repository;
	
	@Autowired
	private OpenMRSUserAPIService openMRSUserAPIService;
	
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public <T> long save(T t) throws Exception {
		User user = (User) t;
		long createdUser = 0;
		Set<Role> roles = user.getRoles();
		boolean isProvider = roleServiceImpl.isProvider(roles);
		if (isProvider) {
			String uuid = openMRSUserAPIService.add(openMRSUserAPIService.generateUserJsonObject(user));
			if (uuid != null) {
				user.setUuid(uuid);
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				createdUser = repository.save(user);
			} else {
				logger.error("No uuid found for user:" + user.getUsername());
			}
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			createdUser = repository.save(user);
		}
		
		return createdUser;
	}
	
	@Transactional
	@Override
	public <T> int update(T t) {
		return repository.update(t);
	}
	
	@Transactional
	@Override
	public <T> boolean delete(T t) {
		return repository.delete(t);
	}
	
	@Transactional
	@Override
	public <T> T findById(int id, String fieldName, Class<?> className) {
		return repository.findById(id, fieldName, className);
		
	}
	
	@Transactional
	@Override
	public <T> T findByKey(String value, String fieldName, Class<?> className) {
		return repository.findByKey(value, fieldName, className);
	}
	
	@Transactional
	@Override
	public <T> List<T> findAll(String tableClass) {
		return repository.findAll(tableClass);
	}
	
	@Transactional
	public Set<Role> setRoles(int[] selectedRoles) {
		Set<Role> roles = new HashSet<Role>();
		if (selectedRoles != null) {
			for (int roleId : selectedRoles) {
				logger.debug("adding roleId: " + roleId);
				Role role = repository.findById(roleId, "id", Role.class);
				roles.add(role);
			}
		}
		return roles;
	}
	
	public boolean isPasswordMatched(User account) {
		return passwordEncoder.matches(account.getRetypePassword(), passwordEncoder.encode(account.getPassword()));
	}
	
	public boolean isUserAlreadyExist(User account) {
		return repository.findByUserName(account.getUsername(), "username", User.class);
	}
	
}
