/**
 * 
 */
package org.mcare.acl.service;

import org.mcare.acl.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author proshanto
 */
@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	public UserService() {
		
	}
	
	public void save(UserEntity userEntity) {
		
		databaseServiceImpl.save(userEntity);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Class<UserEntity> className = UserEntity.class;
		UserEntity user = databaseServiceImpl.findByKey(username, "username", className);
		
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		System.err.println("User:" + user.getUsername() + "" + user.getPassword());
		return new MyUserPrincipal(user);
	}
	
}
