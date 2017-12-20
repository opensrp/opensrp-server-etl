package org.unicef.etl.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "event")
@TypeDef(name = "MyJsonType", typeClass = MyJsonType.class)
public class EventEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
	@SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq", allocationSize = 1)
	private int id;
	
	@Column(name = "document_id")
	private String _id;
	
	@Column(name = "base_entity_id")
	public String baseEntityId;
	
	@Column(name = "location_id")
	public String locationId;
	
	@Column(name = "server_version")
	private long serverVersion;
	
	@Column(name = "version")
	private long version;
	
	@Column(name = "entity_type")
	public String entityType;
	
	@Column(name = "event_type")
	public String eventType;
	
	@Column(name = "provider_id")
	public String providerId;
	
	@Column(name = "duration")
	public long duration;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	@UpdateTimestamp
	private Date updated = new Date();
	
	@Temporal(TemporalType.DATE)
	@Column(name = "event_date")
	private Date eventDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_created")
	private Date dateCreated;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_edited")
	private Date dateEdited;
	
	@Column(name = "observations")
	@Type(type = "MyJsonType")
	private Map<String, String> obs;
	
	public String get_id() {
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getBaseEntityId() {
		return baseEntityId;
	}
	
	public void setBaseEntityId(String baseEntityId) {
		this.baseEntityId = baseEntityId;
	}
	
	public long getServerVersion() {
		return serverVersion;
	}
	
	public void setServerVersion(long serverVersion) {
		this.serverVersion = serverVersion;
	}
	
	public long getVersion() {
		return version;
	}
	
	public void setVersion(long version) {
		this.version = version;
	}
	
	public String getEntityType() {
		return entityType;
	}
	
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	
	public String getEventType() {
		return eventType;
	}
	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public String getProviderId() {
		return providerId;
	}
	
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
	public long getDuration() {
		return duration;
	}
	
	public void setDuration(long duration) {
		this.duration = duration;
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
	
	public Date getEventDate() {
		return eventDate;
	}
	
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Date getDateEdited() {
		return dateEdited;
	}
	
	public void setDateEdited(Date dateEdited) {
		this.dateEdited = dateEdited;
	}
	
	public String getLocationId() {
		return locationId;
	}
	
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	public Map<String, String> getObs() {
		return obs;
	}
	
	public void setObs(Map<String, String> obs) {
		this.obs = obs;
	}
	
	@Override
	public String toString() {
		return "EventEntity [_id=" + _id + ", baseEntityId=" + baseEntityId + ", locationId=" + locationId
		        + ", serverVersion=" + serverVersion + ", version=" + version + ", entityType=" + entityType + ", eventType="
		        + eventType + ", providerId=" + providerId + ", duration=" + duration + ", created=" + created + ", updated="
		        + updated + ", eventDate=" + eventDate + ", dateCreated=" + dateCreated + ", dateEdited=" + dateEdited + "]";
	}
	
}
