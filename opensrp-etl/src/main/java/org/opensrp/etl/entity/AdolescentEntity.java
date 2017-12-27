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
@Table(name = "adolescent")
public class AdolescentEntity {
	
	private static final AdolescentEntity INSTANCE = new AdolescentEntity();
	
	public AdolescentEntity() {
		
	}

	public static AdolescentEntity getInstance() {
		return INSTANCE;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adolescent_id_seq")
	@SequenceGenerator(name = "adolescent_id_seq", sequenceName = "adolescent_id_seq", allocationSize = 1)

	private long id;
	
	private Long clientVersion;
	
	private Long serverVersion;
	
	private Long version;
	
	@Column(name="end_time")
	private Date end;
	
	private Date start;
	
	@Temporal(TemporalType.DATE)
	private Date Today;
	
	private String INSTANCEID;

	private String _id;

	private String changes;
	
	private String Met;
	
	private String Visit_Status;

	@Temporal(TemporalType.DATE)
	private Date Visit_Date;
	
	@Temporal(TemporalType.DATE)
	private Date adolescent_today;
	
	private Date received_time;

	private Integer Councelling;

	private String Confirm_Info;
	
	private String Comment;
	
	private String existing_Couple_No;
	
	private String existing_Premature_Birth;
	
	private String existing_Child_Father;
	
	private String existing_Mem_Mobile_Number;
	
	private String existing_Mem_BRID;
	
	private String existing_Mem_F_Name;
	
	private String existing_ELCO_NID;
	
	private String existing_Final_Vill;
	
	private String existing_Member_Birth_Date;
	
	private String existing_ELCO_BRID;
	
	private String existing_HR;
	
	private String existing_Child_Mother;
	
	private String existing_Mauzapara;
	
	private String existing_GoB_HHID;
	
	private String relationalid;
	
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

	public Date getEnd() {
		return end;
	}

	public void setend(Date end) {
		this.end = end;
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

	public Date getStart() {
		return start;
	}

	public void setstart(Date start) {
		this.start = start;
	}

	@Temporal(TemporalType.DATE)
	public Date getToday() {
		return Today;
	}

	public void setToday(Date today) {
		Today = today;
	}

	public String getChanges() {
		return changes;
	}

	public void setchanges(String changes) {
		this.changes = changes;
	}

	public Date getReceived_time() {
		return received_time;
	}

	public void setreceived_time(Date received_time) {
		this.received_time = received_time;
	}

	public String getMet() {
		return Met;
	}

	public void setMet(String met) {
		Met = met;
	}

	public String getVisit_Status() {
		return Visit_Status;
	}

	public void setVisit_Status(String visit_Status) {
		Visit_Status = visit_Status;
	}

	@Temporal(TemporalType.DATE)
	public Date getVisit_Date() {
		return Visit_Date;
	}

	public void setVisit_Date(Date visit_Date) {
		Visit_Date = visit_Date;
	}

	public Long getVersion() {
		return version;
	}

	public void setversion(Long version) {
		this.version = version;
	}

	@Temporal(TemporalType.DATE)
	public Date getAdolescent_today() {
		return adolescent_today;
	}

	public void setadolescent_today(Date adolescent_today) {
		this.adolescent_today = adolescent_today;
	}

	public String getConfirm_Info() {
		return Confirm_Info;
	}

	public void setConfirm_Info(String confirm_Info) {
		Confirm_Info = confirm_Info;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Integer getCouncelling() {
		return Councelling;
	}

	public void setCouncelling(Integer councelling) {
		Councelling = councelling;
	}

	public String getExisting_Couple_No() {
		return existing_Couple_No;
	}

	public void setexisting_Couple_No(String existing_Couple_No) {
		this.existing_Couple_No = existing_Couple_No;
	}

	public String getExisting_Premature_Birth() {
		return existing_Premature_Birth;
	}

	public void setexisting_Premature_Birth(String existing_Premature_Birth) {
		this.existing_Premature_Birth = existing_Premature_Birth;
	}

	public String getExisting_Child_Father() {
		return existing_Child_Father;
	}

	public void setexisting_Child_Father(String existing_Child_Father) {
		this.existing_Child_Father = existing_Child_Father;
	}

	public String getExisting_Mem_Mobile_Number() {
		return existing_Mem_Mobile_Number;
	}

	public void setexisting_Mem_Mobile_Number(String existing_Mem_Mobile_Number) {
		this.existing_Mem_Mobile_Number = existing_Mem_Mobile_Number;
	}

	public String getExisting_Mem_BRID() {
		return existing_Mem_BRID;
	}

	public void setexisting_Mem_BRID(String existing_Mem_BRID) {
		this.existing_Mem_BRID = existing_Mem_BRID;
	}

	public String getExisting_Mem_F_Name() {
		return existing_Mem_F_Name;
	}

	public void setexisting_Mem_F_Name(String existing_Mem_F_Name) {
		this.existing_Mem_F_Name = existing_Mem_F_Name;
	}

	public String getExisting_ELCO_NID() {
		return existing_ELCO_NID;
	}

	public void setexisting_ELCO_NID(String existing_ELCO_NID) {
		this.existing_ELCO_NID = existing_ELCO_NID;
	}

	public String getExisting_Final_Vill() {
		return existing_Final_Vill;
	}

	public void setexisting_Final_Vill(String existing_Final_Vill) {
		this.existing_Final_Vill = existing_Final_Vill;
	}

	public String getExisting_Member_Birth_Date() {
		return existing_Member_Birth_Date;
	}

	public void setexisting_Member_Birth_Date(String existing_Member_Birth_Date) {
		this.existing_Member_Birth_Date = existing_Member_Birth_Date;
	}

	public String getExisting_ELCO_BRID() {
		return existing_ELCO_BRID;
	}

	public void setexisting_ELCO_BRID(String existing_ELCO_BRID) {
		this.existing_ELCO_BRID = existing_ELCO_BRID;
	}

	public String getExisting_HR() {
		return existing_HR;
	}

	public void setexisting_HR(String existing_HR) {
		this.existing_HR = existing_HR;
	}

	public String getExisting_Child_Mother() {
		return existing_Child_Mother;
	}

	public void setexisting_Child_Mother(String existing_Child_Mother) {
		this.existing_Child_Mother = existing_Child_Mother;
	}

	public String getExisting_Mauzapara() {
		return existing_Mauzapara;
	}

	public void setexisting_Mauzapara(String existing_Mauzapara) {
		this.existing_Mauzapara = existing_Mauzapara;
	}

	public String getExisting_GoB_HHID() {
		return existing_GoB_HHID;
	}

	public void setexisting_GoB_HHID(String existing_GoB_HHID) {
		this.existing_GoB_HHID = existing_GoB_HHID;
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

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
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