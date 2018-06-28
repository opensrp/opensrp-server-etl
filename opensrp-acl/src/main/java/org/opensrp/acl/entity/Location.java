package org.opensrp.acl.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name = "location")
public class Location implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_id_seq")
	@SequenceGenerator(name = "location_id_seq", sequenceName = "location_id_seq", allocationSize = 1)
	private int id;
	
	@NotEmpty(message = "location name can't be empty")
	@Column(name = "name")
	private String name;
	
	@Column(name = "uuid")
	private String uuid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	@UpdateTimestamp
	private Date updated = new Date();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "creator", referencedColumnName = "id")
	private User creator;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_location", referencedColumnName = "id")
	private Location parentLocation;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "location_tag_map", joinColumns = { @JoinColumn(name = "location_id") }, inverseJoinColumns = { @JoinColumn(name = "location_tag_id") })
	private Set<LocationTag> LocationTagMap = new HashSet<LocationTag>();
	
	public int getId() {
		return id;
		
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public User getCreator() {
		return creator;
	}
	
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public Location getParentLocation() {
		return parentLocation;
	}
	
	public void setParentLocation(Location parentLocation) {
		this.parentLocation = parentLocation;
	}
	
	public Set<LocationTag> getLocationTagMap() {
		return LocationTagMap;
	}
	
	public void setLocationTagMap(Set<LocationTag> locationTagMap) {
		LocationTagMap = locationTagMap;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated() {
		this.created = new Date();
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated() {
		this.updated = new Date();
	}
	
	@Override
	@Transient
	public String getAuthority() {
		return name;
	}
	
}
