package org.mcare.acl.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mcare.acl.entity.Account;
import org.mcare.acl.entity.Permission;
import org.mcare.acl.entity.Role;
import org.mcare.etl.entity.MarkerEntity;
import org.mcare.etl.service.MarkerService;
import org.mcare.etl.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultApplicationSettingService {
	
	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private MarkerEntity markerEntity;
	
	@Autowired
	private PermissionServiceImpl permissionServiceImpl;
	
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public DefaultApplicationSettingService() {
		
	}
	
	public void saveDefaultAppSetting() {
		System.err.println("Calling automatically ...............");
		MarkerEntity entity = new MarkerEntity();
		entity.setName(CommonConstant.MCARE.name());
		entity.setTimeStamp(0);
		
		MarkerEntity markerEntity = markerService.findByName(CommonConstant.MCARE.name());
		if (markerEntity == null) {
			markerService.save(entity);
		}
		
		try {
			permissionServiceImpl.addPermission();
		}
		catch (Exception e) {
			System.err.println("onApplicationEvent:" + e.getMessage());
		}
		String userName = "admin";
		String roleName = "ROLE_ADMIN";
		Role role = new Role();
		role.setName(roleName);
		Role gettingRole = roleServiceImpl.findByKey(role.getName(), "name", Role.class);
		
		try {
			if (gettingRole == null) {
				
				Set<Permission> permissions = new HashSet<Permission>();
				List<Permission> allPermissions = permissionServiceImpl.findAll("Permission");
				for (Permission permission : allPermissions) {
					permissions.add(permission);
				}
				role.setPermissions(permissions);
				roleServiceImpl.save(role);
			}
		}
		catch (Exception e) {
			System.err.println("onApplicationEvent:" + e.getMessage());
		}
		
		Account account = userServiceImpl.findByKey(userName, "username", Account.class);
		Account acc = new Account();
		acc.setUsername(userName);
		acc.setFirstName(userName);
		acc.setLastName(userName);
		acc.setEnabled(true);
		acc.setEmail("admin@yahoo.com");
		acc.setPassword(passwordEncoder.encode("admin"));
		Role existingRole = roleServiceImpl.findByKey(role.getName(), "name", Role.class);
		Set<Role> roles = new HashSet<Role>();
		roles.add(existingRole);
		acc.setRoles(roles);
		try {
			if (account == null) {
				userServiceImpl.save(acc);
			}
		}
		catch (Exception e) {
			System.err.println("onApplicationEvent:" + e.getMessage());
		}
	}
	
}
