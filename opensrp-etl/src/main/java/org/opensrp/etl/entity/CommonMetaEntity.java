package org.opensrp.etl.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CommonMetaEntity {
	
	private Date date_created;
	
	private Date date_updated;
	
	public Date getDate_created() {
		return date_created;
	}
	
	public void setDate_created() {
		this.date_created = new Date();
	}
	
	public Date getDate_updated() {
		return date_updated;
	}
	
	public void setDate_updated() {
		this.date_updated = new Date();
	}
	
}
