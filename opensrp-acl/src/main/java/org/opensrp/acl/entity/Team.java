/**
 * @author proshanto (proshanto123@gmail.com)
 */
package org.opensrp.acl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "team", schema = "core")
public class Team {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_seq")
	@SequenceGenerator(name = "team_id_seq", sequenceName = "team_id_seq", allocationSize = 1)
	private int id;
	
	@NotEmpty(message = "Team name can't be empty")
	@Column(name = "name")
	private String name;
	
	@Column(name = "uuid")
	private String uuid;
	
	@ManyToOne()
	@JoinColumn(name = "loction_id", referencedColumnName = "id")
	private Location loction;
	
	@ManyToOne()
	@JoinColumn(name = "supervisor_id", referencedColumnName = "id")
	private User superVisor;
	
	@Column(name = "identifier")
	private String identifier;
	
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
	
}
