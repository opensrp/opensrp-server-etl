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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "deathReg")
public class DeathRegEntity {
	
	private static final DeathRegEntity INSTANCE = new DeathRegEntity();
	
	public DeathRegEntity() {
	}
	
	public static DeathRegEntity getInstance() {
		return INSTANCE;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deathReg_id_seq")
	@SequenceGenerator(name = "deathReg_id_seq", sequenceName = "deathReg_id_seq", allocationSize = 1)
	private long id;
	
	private Long clientVersion;
	
	private Long serverVersion;
	
	private Integer Deceased_Age_Group;
	
	private Integer Deceased_Age;
	
	private String INSTANCEID;
	
	private String _id;
	
	private String changes;
	
	private String Confirm_Info;
	
	private String Date_Death;
	
	private String Gender_Deceased;
	
	private String Reason_Death;
	
	private String existing_GoB_HHID;
	
	private String existing_Mem_F_Name;
	
	private String existing_Child_Mother;
	
	private String existing_Child_Father;
	
	private String existing_Final_Vill;
	
	private String existing_Mem_Mobile_Number;
	
	private String existing_Couple_No;
	
	private String existing_Spouse_Name;
	
	private String existing_Member_Gender;
	
	private String existing_ELCO_NID;
	
	private String existing_ELCO_BRID;
	
	private String existing_Mem_BRID;
	
	private String existing_Mauzapara;
	
	private String relationalid;
	
	private Date received_time;
	
	private Date start;
	
	@Column(name = "end_time")
	private Date end;
	
	@Temporal(TemporalType.DATE)
	private Date death_today;
	
	@Temporal(TemporalType.DATE)
	private Date Visit_Date;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	@UpdateTimestamp
	private Date updated = new Date();
	
	public long getId() {
		return id;
	}
	
	public Long getClientVersion() {
		return clientVersion;
	}
	
	public void setclientVersion(Long clientVersion) {
		this.clientVersion = clientVersion;
	}
	
	public Long getServerVersion() {
		return serverVersion;
	}
	
	public void setserverVersion(Long serverVersion) {
		this.serverVersion = serverVersion;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setend(Date end) {
		this.end = end;
	}
	
	public Date getStart() {
		return start;
	}
	
	public void setstart(Date start) {
		this.start = start;
	}
	
	public String getChanges() {
		return changes;
	}
	
	public void setchanges(String changes) {
		this.changes = changes;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDeath_today() {
		return death_today;
	}
	
	public void setdeath_today(Date death_today) {
		this.death_today = death_today;
	}
	
	public Date getReceived_time() {
		return received_time;
	}
	
	public void setreceived_time(Date received_time) {
		this.received_time = received_time;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getVisit_Date() {
		return Visit_Date;
	}
	
	public void setVisit_Date(Date visit_Date) {
		Visit_Date = visit_Date;
	}
	
	public String getConfirm_Info() {
		return Confirm_Info;
	}
	
	public void setConfirm_Info(String confirm_Info) {
		Confirm_Info = confirm_Info;
	}
	
	public String getDate_Death() {
		return Date_Death;
	}
	
	public void setDate_Death(String date_Death) {
		Date_Death = date_Death;
	}
	
	public String getGender_Deceased() {
		return Gender_Deceased;
	}
	
	public void setGender_Deceased(String gender_Deceased) {
		Gender_Deceased = gender_Deceased;
	}
	
	public Integer getDeceased_Age_Group() {
		return Deceased_Age_Group;
	}
	
	public void setDeceased_Age_Group(Integer deceased_Age_Group) {
		Deceased_Age_Group = deceased_Age_Group;
	}
	
	public Integer getDeceased_Age() {
		return Deceased_Age;
	}
	
	public void setDeceased_Age(Integer deceased_Age) {
		Deceased_Age = deceased_Age;
	}
	
	public String getReason_Death() {
		return Reason_Death;
	}
	
	public void setReason_Death(String reason_Death) {
		Reason_Death = reason_Death;
	}
	
	public String getExisting_GoB_HHID() {
		return existing_GoB_HHID;
	}
	
	public void setexisting_GoB_HHID(String existing_GoB_HHID) {
		this.existing_GoB_HHID = existing_GoB_HHID;
	}
	
	public String getExisting_Mem_F_Name() {
		return existing_Mem_F_Name;
	}
	
	public void setexisting_Mem_F_Name(String existing_Mem_F_Name) {
		this.existing_Mem_F_Name = existing_Mem_F_Name;
	}
	
	public String getExisting_Child_Mother() {
		return existing_Child_Mother;
	}
	
	public void setexisting_Child_Mother(String existing_Child_Mother) {
		this.existing_Child_Mother = existing_Child_Mother;
	}
	
	public String getExisting_Child_Father() {
		return existing_Child_Father;
	}
	
	public void setexisting_Child_Father(String existing_Child_Father) {
		this.existing_Child_Father = existing_Child_Father;
	}
	
	public String getExisting_Final_Vill() {
		return existing_Final_Vill;
	}
	
	public void setexisting_Final_Vill(String existing_Final_Vill) {
		this.existing_Final_Vill = existing_Final_Vill;
	}
	
	public String getExisting_Mem_Mobile_Number() {
		return existing_Mem_Mobile_Number;
	}
	
	public void setexisting_Mem_Mobile_Number(String existing_Mem_Mobile_Number) {
		this.existing_Mem_Mobile_Number = existing_Mem_Mobile_Number;
	}
	
	public String getExisting_Couple_No() {
		return existing_Couple_No;
	}
	
	public void setexisting_Couple_No(String existing_Couple_No) {
		this.existing_Couple_No = existing_Couple_No;
	}
	
	public String getExisting_Spouse_Name() {
		return existing_Spouse_Name;
	}
	
	public void setexisting_Spouse_Name(String existing_Spouse_Name) {
		this.existing_Spouse_Name = existing_Spouse_Name;
	}
	
	public String getExisting_Member_Gender() {
		return existing_Member_Gender;
	}
	
	public void setexisting_Member_Gender(String existing_Member_Gender) {
		this.existing_Member_Gender = existing_Member_Gender;
	}
	
	public String getExisting_ELCO_NID() {
		return existing_ELCO_NID;
	}
	
	public void setexisting_ELCO_NID(String existing_ELCO_NID) {
		this.existing_ELCO_NID = existing_ELCO_NID;
	}
	
	public String getExisting_ELCO_BRID() {
		return existing_ELCO_BRID;
	}
	
	public void setexisting_ELCO_BRID(String existing_ELCO_BRID) {
		this.existing_ELCO_BRID = existing_ELCO_BRID;
	}
	
	public String getExisting_Mem_BRID() {
		return existing_Mem_BRID;
	}
	
	public void setexisting_Mem_BRID(String existing_Mem_BRID) {
		this.existing_Mem_BRID = existing_Mem_BRID;
	}
	
	public String getExisting_Mauzapara() {
		return existing_Mauzapara;
	}
	
	public void setexisting_Mauzapara(String existing_Mauzapara) {
		this.existing_Mauzapara = existing_Mauzapara;
	}
	
	public String getRelationalid() {
		return relationalid;
	}
	
	public void setrelationalid(String relationalid) {
		this.relationalid = relationalid;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public String getINSTANCEID() {
		return INSTANCEID;
	}
	
	public void setINSTANCEID(String iNSTANCEID) {
		INSTANCEID = iNSTANCEID;
	}
	
	public String get_id() {
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}
}
