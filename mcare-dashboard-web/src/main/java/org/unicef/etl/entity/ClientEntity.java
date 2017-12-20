package org.unicef.etl.entity;

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "client")
public class ClientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
	@SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", allocationSize = 1)
	private int id;
	
	@Column(name = "document_id")
	private String _id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date birthdate;
	
	@Column(name = "base_entity_id")
	public String baseEntityId;
	
	@Column(name = "server_version")
	private long serverVersion;
	
	@Column(name = "spouse_name")
	public String spouseName;
	
	@Column(name = "household_code")
	public String householdCode;
	
	@Column(name = "address_type")
	public String addressType;
	
	@Column(name = "division")
	public String division;
	
	@Column(name = "district")
	public String district;
	
	@Column(name = "upazila")
	public String upazila;
	
	@Column(name = "client_union")
	public String client_union;
	
	@Column(name = "ward")
	public String ward;
	
	@Column(name = "subunit")
	public String subunit;
	
	@Column(name = "mauzapara")
	public String mauzapara;
	
	@Column(name = "gobhhid")
	public String gobhhid;
	
	@Column(name = "country")
	public String country;
	
	@Column(name = "phone_number")
	public String phoneNumber;
	
	@Column(name = "national_id")
	public String nationalId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	@UpdateTimestamp
	private Date updated = new Date();
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_created")
	private Date dateCreated;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_edited")
	private Date dateEdited;
	
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
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getNationalId() {
		return nationalId;
	}
	
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	
	public String get_id() {
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getSpouseName() {
		return spouseName;
	}
	
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	
	public String getHouseholdCode() {
		return householdCode;
	}
	
	public void setHouseholdCode(String householdCode) {
		this.householdCode = householdCode;
	}
	
	public String getAddressType() {
		return addressType;
	}
	
	public void setAddressType(String addressType) {
		this.addressType = addressType;
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
	
	public String getClient_union() {
		return client_union;
	}
	
	public void setClient_union(String client_union) {
		this.client_union = client_union;
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
	
	public String getMauzapara() {
		return mauzapara;
	}
	
	public void setMauzapara(String mauzapara) {
		this.mauzapara = mauzapara;
	}
	
	public String getGobhhid() {
		return gobhhid;
	}
	
	public void setGobhhid(String gobhhid) {
		this.gobhhid = gobhhid;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "ClientEntity [_id=" + _id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthdate="
		        + birthdate + ", baseEntityId=" + baseEntityId + ", serverVersion=" + serverVersion + ", spouseName="
		        + spouseName + ", householdCode=" + householdCode + ", addressType=" + addressType + ", division=" + division
		        + ", district=" + district + ", upazila=" + upazila + ", client_union=" + client_union + ", ward=" + ward
		        + ", subunit=" + subunit + ", mauzapara=" + mauzapara + ", gobhhid=" + gobhhid + ", country=" + country
		        + ", phoneNumber=" + phoneNumber + ", nationalId=" + nationalId + ", created=" + created + ", updated="
		        + updated + ", dateCreated=" + dateCreated + ", dateEdited=" + dateEdited + "]";
	}
	
}
