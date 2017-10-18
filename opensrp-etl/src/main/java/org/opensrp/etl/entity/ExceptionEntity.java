package org.opensrp.etl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "exception")
public class ExceptionEntity {
	
	public ExceptionEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exception_id_seq")
	@SequenceGenerator(name = "exception_id_seq", sequenceName = "exception_id_seq", allocationSize = 1)
	private int id;
	
	@Column(name = "doc_id")
	private String docId;
	
	@Column(name = "benificiary_type")
	private String benificiaryType;
	
	@Column(name = "case_id")
	private String caseId;
	
	//@Type(type = "text")
	@Column(name = "error_message")
	private String errorMessage;
	
	@Column(name = "instance_id")
	private String instanceId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	private Date updated = new Date();
	
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
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBenificiaryType() {
		return benificiaryType;
	}
	
	public void setBenificiaryType(String benificiaryType) {
		this.benificiaryType = benificiaryType;
	}
	
	public String getCaseId() {
		return caseId;
	}
	
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getInstanceId() {
		return instanceId;
	}
	
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
	public String getDocId() {
		return docId;
	}
	
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
}
