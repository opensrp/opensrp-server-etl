package org.mcare.acl.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mcare.acl.entity.Role;
import org.mcare.acl.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserPrincipal implements UserDetails {
	
	/**
     * 
     */
	private static final long serialVersionUID = 3251639910137714093L;
	
	private UserEntity user;
	
	public MyUserPrincipal(UserEntity user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<Role> roles = null;
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			/*role.getPrivileges().stream()
			 .map(p -> new SimpleGrantedAuthority(p.getName()))
			 .forEach(authorities::add);*/
		}
		
		return null;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		System.err.println("data:" + user.getUsername());
		return user.getPassword();
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
