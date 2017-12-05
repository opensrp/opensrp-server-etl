/**
 * 
 */
package org.mcare.data.export.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

/**
 * @author proshanto
 */

@Service
@Entity
@Table(name = "exports")
public class DataExportEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exports_id_seq")
	@SequenceGenerator(name = "exports_id_seq", sequenceName = "exports_id_seq", allocationSize = 1)
	private long id;
	
	private String reportName;
	
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private Date craeted;
	
	private String formName;
	
	@Column(name = "creator")
	private String user;
	
	public DataExportEntity() {
		
	}
	
	public String getReportName() {
		return reportName;
	}
	
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
	public Date getCraeted() {
		return craeted;
	}
	
	public void setCraeted(Date craeted) {
		this.craeted = new Date();
	}
	
	public String getFormName() {
		return formName;
	}
	
	public void setFormName(String formName) {
		this.formName = formName;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "DataExportEntity [id=" + id + ", reportName=" + reportName + ", craeted=" + craeted + ", formName="
		        + formName + ", user=" + user + "]";
	}
	
}
