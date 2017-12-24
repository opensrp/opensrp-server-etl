package org.unicef.acl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name = "provider")
public class ProviderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provider_id_seq")
	@SequenceGenerator(name = "provider_id_seq", sequenceName = "provider_id_seq", allocationSize = 1)
	private long id;
	
	private String provider;
	
	public ProviderEntity() {
		
	}
	
	public long getId() {
		return id;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	@Override
	public String toString() {
		return "ProviderEntity [id=" + id + ", provider=" + provider + "]";
	}
	
}
