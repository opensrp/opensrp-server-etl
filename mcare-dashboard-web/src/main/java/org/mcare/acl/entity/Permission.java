package org.mcare.acl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_id_seq")
	@SequenceGenerator(name = "permission_id_seq", sequenceName = "permission_id_seq", allocationSize = 1)
	private int id;

	private String name;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Transient
	public String getAuthority() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		GrantedAuthority ga = (GrantedAuthority) o;
		return (getAuthority().equals(ga.getAuthority()));
	}
	
	@Override
	public int hashCode() {
		return getAuthority().hashCode();
	}
	
	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + "]";
	}
	
}
