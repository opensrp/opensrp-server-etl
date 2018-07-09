/**
 * @author proshanto (proshanto123@gmail.com)
 */
package org.opensrp.acl.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name = "team_member", schema = "core")
public class TeamMember {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_member_id_seq")
	@SequenceGenerator(name = "team_member_id_seq", sequenceName = "team_member_id_seq", allocationSize = 1)
	private int id;
	
	@NotEmpty(message = "Team Member name can't be empty")
	@Column(name = "name")
	private String name;
	
	@Column(name = "uuid")
	private String uuid;
	
	@Column(name = "identifier")
	private String identifier;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "team_member_location", schema = "core", joinColumns = { @JoinColumn(name = "team_member_id") }, inverseJoinColumns = { @JoinColumn(name = "location_id") })
	private Set<Location> locations = new HashSet<Location>();
	
	@ManyToOne()
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private User person;
	
	@Column(name = "is_data_provider")
	private String isDataProvider;
	
	@ManyToOne()
	@JoinColumn(name = "team_id", referencedColumnName = "id")
	private Team team;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	@UpdateTimestamp
	private Date updated = new Date();
	
	@ManyToOne()
	@JoinColumn(name = "creator_id", referencedColumnName = "id")
	private User creator;
	
	public int getId() {
		return id;
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
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public Set<Location> getLocations() {
		return locations;
	}
	
	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}
	
	public User getPerson() {
		return person;
	}
	
	public void setPerson(User person) {
		this.person = person;
	}
	
	public String getIsDataProvider() {
		return isDataProvider;
	}
	
	public void setIsDataProvider(String isDataProvider) {
		this.isDataProvider = isDataProvider;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public User getCreator() {
		return creator;
	}
	
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
}
