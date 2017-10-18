package org.opensrp.etl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class CommonEntity {
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	private String gender;
	
	@Column(name = "case_id")
	public String caseId;
	
	@Column(name = "instance_id")
	private String instanceId;
	
	private String provider;
	
	private Date start;
	
	@Column(name = "end_time")
	private Date end;
	
	@Temporal(TemporalType.DATE)
	private Date today;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "registration_date")
	private Date registrationDate;
	
	private String country;
	
	private String division;
	
	private String district;
	
	private String upazila;
	
	@Column(name = "unions")
	private String union;
	
	private String ward;
	
	private String subunit;
	
	@Column(name = "mauza_para")
	private String mauzaPara;
	
	private String gps;
	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "external_user_id")
	private String externalUserId;
	
	@Column(name = "current_form_status")
	private String currentFormStatus;
	
	@Column(name = "submission_time")
	private long submissionTime;
	
	@Column(name = "client_version")
	private long clientVersion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	private Date updated = new Date();
	
	@Column(name = "received_time")
	private Date receivedTime;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCaseId() {
		return caseId;
	}
	
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	public String getInstanceId() {
		return instanceId;
	}
	
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public Date getToday() {
		return today;
	}
	
	public void setToday(Date today) {
		this.today = today;
	}
	
	public java.util.Date getStart() {
		return start;
	}
	
	public void setStart(java.util.Date start) {
		this.start = start;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getDivision() {
		return division;
	}
	
	public void setDivision(String division) {
		this.division = division;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getUpazila() {
		return upazila;
	}
	
	public void setUpazila(String upazila) {
		this.upazila = upazila;
	}
	
	public String getUnion() {
		return union;
	}
	
	public void setUnion(String union) {
		this.union = union;
	}
	
	public String getWard() {
		return ward;
	}
	
	public void setWard(String ward) {
		this.ward = ward;
	}
	
	public String getSubunit() {
		return subunit;
	}
	
	public void setSubunit(String subunit) {
		this.subunit = subunit;
	}
	
	public String getMauzaPara() {
		return mauzaPara;
	}
	
	public void setMauzaPara(String mauzaPara) {
		this.mauzaPara = mauzaPara;
	}
	
	public String getGps() {
		return gps;
	}
	
	public void setGps(String gps) {
		this.gps = gps;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getExternalUserId() {
		return externalUserId;
	}
	
	public void setExternalUserId(String externalUserId) {
		this.externalUserId = externalUserId;
	}
	
	public String getCurrentFormStatus() {
		return currentFormStatus;
	}
	
	public void setCurrentFormStatus(String currentFormStatus) {
		this.currentFormStatus = currentFormStatus;
	}
	
	public long getSubmissionTime() {
		return submissionTime;
	}
	
	public void setSubmissionTime(long submissionTime) {
		this.submissionTime = submissionTime;
	}
	
	public long getClientVersion() {
		return clientVersion;
	}
	
	public void setClientVersion(long clientVersion) {
		this.clientVersion = clientVersion;
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
	
	public Date getReceivedTime() {
		return receivedTime;
	}
	
	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}
	
	@Override
	public String toString() {
		return "CommonEntity [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", gender="
		        + gender + ", caseId=" + caseId + ", instanceId=" + instanceId + ", provider=" + provider + ", today="
		        + today + ", start=" + start + ", end=" + end + ", registrationDate=" + registrationDate + ", country="
		        + country + ", division=" + division + ", district=" + district + ", upazila=" + upazila + ", union="
		        + union + ", ward=" + ward + ", subunit=" + subunit + ", mauzaPara=" + mauzaPara + ", gps=" + gps
		        + ", userType=" + userType + ", externalUserId=" + externalUserId + ", currentFormStatus="
		        + currentFormStatus + ", submissionTime=" + submissionTime + ", clientVersion=" + clientVersion
		        + ", created=" + created + ", updated=" + updated + ", receivedTime=" + receivedTime + "]";
	}
	
}
