package org.mcare.acl.util;

import org.apache.log4j.Logger;
import org.mcare.acl.entity.Account;
import org.mcare.acl.entity.Role;
import org.mcare.acl.permission.CustomPermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthenticationManagerUtil {

	private static final Logger logger = Logger.getLogger(AuthenticationManagerUtil.class);

	public static boolean isPermitted(String permissionName){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomPermissionEvaluator customPermissionEvaluator = new CustomPermissionEvaluator();		
		return customPermissionEvaluator.hasPermission(auth, "returnObject", permissionName);		
	}

	// static method to return logged in user
	public static Account getLoggedInUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account user = (Account) auth.getPrincipal();
		logger.info("\nLogger-in User :"+user.toString()+"\n");
		return user;
	}

	// static method to return logged in user roles
	public static List<String> getLoggedInUserRoles(){
		Account user = getLoggedInUser();
		List<String> roleList = new ArrayList<String>();
		Set<Role> roles =user.getRoles();
		for(Role role : roles){
			logger.info("\nLogger-in User role :"+role.toString()+"\n");
			String roleName = role.getName();
			if(roleName!= null && !roleName.isEmpty()){
				roleList.add(roleName);
			}
		}
		logger.info("\nLogger-in User roleList :"+roleList.toString()+"\n");
		return roleList;
	}

	public static boolean isFPI() {
		List<String> roleList = getLoggedInUserRoles();
		if(roleList.contains("FPI")){
			logger.info("\nIsFPI :"+"True\n");
			return true;
		}
		logger.info("\nIsFPI :"+"False\n");
		return false;
	}

	public static boolean isAdmin() {
		List<String> roleList = getLoggedInUserRoles();
		if(roleList.contains("ROLE_ADMIN")){
			logger.info("\nIsAdmin :"+"True\n");
			return true;
		}
		logger.info("\nIsAdmin :"+"False\n");
		return false;
	}

	public static String getFPIUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
}
