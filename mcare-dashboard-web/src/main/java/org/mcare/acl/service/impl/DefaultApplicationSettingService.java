package org.mcare.acl.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.mcare.acl.entity.Account;
import org.mcare.acl.entity.Permission;
import org.mcare.acl.entity.Role;
import org.mcare.etl.entity.MarkerEntity;
import org.mcare.etl.service.MarkerService;
import org.mcare.etl.util.CommonConstant;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ibatis.common.jdbc.ScriptRunner;

@Service
public class DefaultApplicationSettingService {
	
	private static final Logger logger = Logger.getLogger(DefaultApplicationSettingService.class);
	
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
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	public DefaultApplicationSettingService() {
		
	}
	
	public void saveDefaultAppSetting() throws ClassNotFoundException, SQLException {
		logger.info("saving default settings ...............");
		
		//MarkerEntity Initialization
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
			logger.error("error adding permissions" + e.getMessage());
		}
		
		//Create default admin User
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
			logger.error("error saving roles:" + e.getMessage());
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
			logger.error("error saving default user:" + e.getMessage());
		}
		
		//Execute some location, form and provider SQL script automatically
		String rootPath = "";
		try {
			rootPath = new File(".").getCanonicalPath();
		}
		catch (IOException e) {
			logger.error("error getting rootPath: " + e);
		}
		
		List<String> sqlScriptPaths = Arrays.asList("src/main/resources/scripts/location.sql",
		    "src/main/resources/scripts/location_tag.sql", "src/main/resources/scripts/location_tag_map.sql",
		    "src/main/resources/scripts/provider.sql", "src/main/resources/scripts/form.sql");
		
		Connection con = sessionFactory.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class)
		        .getConnection();
		
		try {
			ScriptRunner sr = new ScriptRunner(con, false, false);
			
			for (String sqlScriptPath : sqlScriptPaths) {
				logger.info("Executing SQL script: " + sqlScriptPath);
				runScript(rootPath + "/" + sqlScriptPath, sr);
			}
		}
		catch (Exception e) {
			logger.error("Failed to Execute script" + " The error is " + e.getMessage());
		}
	}
	
	public void runScript(String aSQLScriptFilePath, ScriptRunner sr) throws FileNotFoundException, IOException,
	    SQLException {
		Reader reader = new BufferedReader(new FileReader(aSQLScriptFilePath));
		sr.runScript(reader);
	}
}
