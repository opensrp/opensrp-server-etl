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
@Table(name = "action")
public class ActionEntity {
	
	public ActionEntity() {
		
	}
	
	@Override
	public String toString() {
		return "ActionEntity [id=" + id + ", provider=" + provider + ", caseID=" + caseId + ", startDate=" + startDate
		        + ", beneficiaryType=" + beneficiaryType + ", scheduleName=" + scheduleName + ", expiryDate=" + expiryDate
		        + ", visitCode=" + visitCode + ", alertStatus=" + alertStatus + ", actionTarget=" + actionTarget
		        + ", actionType=" + actionType + ", isActionActive=" + isActionActive + ", timeStamp=" + timeStamp + "]";
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_id_seq")
	@SequenceGenerator(name = "action_id_seq", sequenceName = "action_id_seq", allocationSize = 1)
	private int id;
	
	@Column(name = "provider")
	private String provider;
	
	@Column(name = "case_id")
	private String caseId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "beneficiary_type")
	private String beneficiaryType;
	
	@Column(name = "schedule_name")
	private String scheduleName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "expiry_date")
	private Date expiryDate;
	
	@Column(name = "visit_code")
	private String visitCode;
	
	@Column(name = "alert_status")
	private String alertStatus;
	
	@Column(name = "action_target")
	private String actionTarget;
	
	@Column(name = "action_type")
	private String actionType;
	
	@Column(name = "is_action_active")
	private Boolean isActionActive;
	
	@Column(name = "time_stamp")
	private long timeStamp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	private Date updated = new Date();
	
	public String getCaseId() {
		return caseId;
	}
	
	public void setCaseId(String caseId) {
		this.caseId = caseId;
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public String getCaseID() {
		return caseId;
	}
	
	public void setCaseID(String caseID) {
		this.caseId = caseID;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String getBeneficiaryType() {
		return beneficiaryType;
	}
	
	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}
	
	public String getScheduleName() {
		return scheduleName;
	}
	
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String getVisitCode() {
		return visitCode;
	}
	
	public void setVisitCode(String visitCode) {
		this.visitCode = visitCode;
	}
	
	public String getAlertStatus() {
		return alertStatus;
	}
	
	public void setAlertStatus(String alertStatus) {
		this.alertStatus = alertStatus;
	}
	
	public String getActionTarget() {
		return actionTarget;
	}
	
	public void setActionTarget(String actionTarget) {
		this.actionTarget = actionTarget;
	}
	
	public String getActionType() {
		return actionType;
	}
	
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	public Boolean getIsActionActive() {
		return isActionActive;
	}
	
	public void setIsActionActive(Boolean isActionActive) {
		this.isActionActive = isActionActive;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
