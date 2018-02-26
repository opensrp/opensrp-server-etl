package org.mcare.acl.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.mcare.acl.entity.Permission;
import org.mcare.acl.service.AclService;
import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements AclService {
	
	@Autowired
	private DatabaseRepositoryImpl repository;
	
	public RoleServiceImpl() {
		
	}
	
	@Transactional
	@Override
	public <T> long save(T t) throws Exception {
		return repository.save(t);
	}
	
	@Transactional
	@Override
	public <T> int update(T t) {
		// TODO Auto-generated method stub
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
	
	public Set<Permission> serPermissions(int[] selectedPermissions) {
		Set<Permission> permissions = new HashSet<Permission>();
		if (selectedPermissions != null) {
			for (int permissionId : selectedPermissions) {
				Permission permission = repository.findById(permissionId, "id", Permission.class);
				permissions.add(permission);
			}
		}
		return permissions;
	}
	
}
