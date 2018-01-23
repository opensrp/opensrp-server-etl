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
@Table(name = "child")
public class ChildEntity {
	
	private static final ChildEntity INSTANCE = new ChildEntity();
	
	public ChildEntity() {
	}
	
	public static ChildEntity getInstance() {
		return INSTANCE;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "child_id_seq")
	@SequenceGenerator(name = "child_id_seq", sequenceName = "child_id_seq", allocationSize = 1)
	private long id;
	
	private Long version;
	
	private Long clientVersion;
	
	private Long serverVersion;
	
	private Integer Diseases_Prob;
	
	private Integer Visit_Status;
	
	private String Vaccines;
	
	private String existing_Mem_BRID;
	
	private String existing_Mem_Mobile_Number;
	
	private String existing_ELCO_NID;
	
	private String INSTANCEID;
	
	private String _id;
	
	private String Met;
	
	private String changes;
	
	private String existing_HR;
	
	private String Note;
	
	private String existing_Final_Vill;
	
	private String Confirm_Info;
	
	private String Child_Vaccination;
	
	private String existing_ELCO_BRID;
	
	private String existing_Child_Mother;
	
	private String existing_Mauzapara;
	
	private String BCG;
	
	private String existing_GoB_HHID;
	
	private String existing_Child_Father;
	
	private String child_current_form_status;
	
	private String existing_Premature_Birth;
	
	private String existing_Couple_No;
	
	private String Has_Referred;
	
	private String existing_Mem_F_Name;
	
	private String Detail_Diseases_Prob;
	
	private String relationalid;
	
	private Date received_time;
	
	private Date start;
	
	@Column(name = "end_time")
	private Date end;
	
	@Temporal(TemporalType.DATE)
	private Date Today;
	
	@Temporal(TemporalType.DATE)
	private Date existing_Member_Birth_Date;
	
	@Temporal(TemporalType.DATE)
	private Date Visit_Date;
	
	@Temporal(TemporalType.DATE)
	private Date child_today;
	
	@Temporal(TemporalType.DATE)
	private Date OPV0;
	
	@Temporal(TemporalType.DATE)
	private Date OPV1;
	
	@Temporal(TemporalType.DATE)
	private Date OPV2;
	
	@Temporal(TemporalType.DATE)
	private Date OPV3;
	
	@Temporal(TemporalType.DATE)
	private Date DOO_35;
	
	@Temporal(TemporalType.DATE)
	private Date DOO_56;
	
	@Temporal(TemporalType.DATE)
	private Date DOO_266;
	
	@Temporal(TemporalType.DATE)
	private Date DOO_441;
	
	@Temporal(TemporalType.DATE)
	private Date PCV1;
	
	@Temporal(TemporalType.DATE)
	private Date PCV2;
	
	@Temporal(TemporalType.DATE)
	private Date PCV3;
	
	@Temporal(TemporalType.DATE)
	private Date Penta1;
	
	@Temporal(TemporalType.DATE)
	private Date Penta2;
	
	@Temporal(TemporalType.DATE)
	private Date Penta3;
	
	@Temporal(TemporalType.DATE)
	private Date Measles1;
	
	@Temporal(TemporalType.DATE)
	private Date Measles2;
	
	@Temporal(TemporalType.DATE)
	private Date IPV;
	
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
	
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public String getExisting_Child_Father() {
		return existing_Child_Father;
	}
	
	public void setexisting_Child_Father(String existing_Child_Father) {
		this.existing_Child_Father = existing_Child_Father;
	}
	
	public String getChild_current_form_status() {
		return child_current_form_status;
	}
	
	public void setchild_current_form_status(String child_current_form_status) {
		this.child_current_form_status = child_current_form_status;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getOPV0() {
		return OPV0;
	}
	
	public void setOPV0(Date oPV0) {
		OPV0 = oPV0;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getOPV1() {
		return OPV1;
	}
	
	public void setOPV1(Date oPV1) {
		OPV1 = oPV1;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getOPV2() {
		return OPV2;
	}
	
	public void setOPV2(Date oPV2) {
		OPV2 = oPV2;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getOPV3() {
		return OPV3;
	}
	
	public void setOPV3(Date oPV3) {
		OPV3 = oPV3;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDOO_35() {
		return DOO_35;
	}
	
	public void setDOO_35(Date dOO_35) {
		DOO_35 = dOO_35;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDOO_56() {
		return DOO_56;
	}
	
	public void setDOO_56(Date dOO_56) {
		DOO_56 = dOO_56;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDOO_266() {
		return DOO_266;
	}
	
	public void setDOO_266(Date dOO_266) {
		DOO_266 = dOO_266;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDOO_441() {
		return DOO_441;
	}
	
	public void setDOO_441(Date dOO_441) {
		DOO_441 = dOO_441;
	}
	
	public String getExisting_Mem_BRID() {
		return existing_Mem_BRID;
	}
	
	public void setexisting_Mem_BRID(String existing_Mem_BRID) {
		this.existing_Mem_BRID = existing_Mem_BRID;
	}
	
	public String getExisting_Mem_Mobile_Number() {
		return existing_Mem_Mobile_Number;
	}
	
	public void setexisting_Mem_Mobile_Number(String existing_Mem_Mobile_Number) {
		this.existing_Mem_Mobile_Number = existing_Mem_Mobile_Number;
	}
	
	public String getExisting_Final_Vill() {
		return existing_Final_Vill;
	}
	
	public void setexisting_Final_Vill(String existing_Final_Vill) {
		this.existing_Final_Vill = existing_Final_Vill;
	}
	
	public Long getClientVersion() {
		return clientVersion;
	}
	
	public void setclientVersion(Long clientVersion) {
		this.clientVersion = clientVersion;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getExisting_Member_Birth_Date() {
		return existing_Member_Birth_Date;
	}
	
	public void setexisting_Member_Birth_Date(Date existing_Member_Birth_Date) {
		this.existing_Member_Birth_Date = existing_Member_Birth_Date;
	}
	
	public Integer getVisit_Status() {
		return Visit_Status;
	}
	
	public void setVisit_Status(Integer visit_Status) {
		Visit_Status = visit_Status;
	}
	
	public String getConfirm_Info() {
		return Confirm_Info;
	}
	
	public void setConfirm_Info(String confirm_Info) {
		Confirm_Info = confirm_Info;
	}
	
	public String getChild_Vaccination() {
		return Child_Vaccination;
	}
	
	public void setChild_Vaccination(String child_Vaccination) {
		Child_Vaccination = child_Vaccination;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getChild_today() {
		return child_today;
	}
	
	public void setchild_today(Date child_today) {
		this.child_today = child_today;
	}
	
	public Long getServerVersion() {
		return serverVersion;
	}
	
	public void setserverVersion(Long serverVersion) {
		this.serverVersion = serverVersion;
	}
	
	public String getExisting_ELCO_BRID() {
		return existing_ELCO_BRID;
	}
	
	public void setexisting_ELCO_BRID(String existing_ELCO_BRID) {
		this.existing_ELCO_BRID = existing_ELCO_BRID;
	}
	
	public String getExisting_Child_Mother() {
		return existing_Child_Mother;
	}
	
	public void setexisting_Child_Mother(String existing_Child_Mother) {
		this.existing_Child_Mother = existing_Child_Mother;
	}
	
	public String getMet() {
		return Met;
	}
	
	public void setMet(String met) {
		Met = met;
	}
	
	public Integer getDiseases_Prob() {
		return Diseases_Prob;
	}
	
	public void setDiseases_Prob(Integer diseases_Prob) {
		Diseases_Prob = diseases_Prob;
	}
	
	public String getExisting_Mauzapara() {
		return existing_Mauzapara;
	}
	
	public void setexisting_Mauzapara(String existing_Mauzapara) {
		this.existing_Mauzapara = existing_Mauzapara;
	}
	
	public Date getStart() {
		return start;
	}
	
	public void setstart(Date start) {
		this.start = start;
	}
	
	public String getBCG() {
		return BCG;
	}
	
	public void setBCG(String bCG) {
		BCG = bCG;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getToday() {
		return Today;
	}
	
	public void setToday(Date today) {
		Today = today;
	}
	
	public String getVaccines() {
		return Vaccines;
	}
	
	public void setVaccines(String vaccines) {
		Vaccines = vaccines;
	}
	
	public String getExisting_GoB_HHID() {
		return existing_GoB_HHID;
	}
	
	public void setexisting_GoB_HHID(String existing_GoB_HHID) {
		this.existing_GoB_HHID = existing_GoB_HHID;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getPCV1() {
		return PCV1;
	}
	
	public void setPCV1(Date pCV1) {
		PCV1 = pCV1;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getPCV2() {
		return PCV2;
	}
	
	public void setPCV2(Date pCV2) {
		PCV2 = pCV2;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getPCV3() {
		return PCV3;
	}
	
	public void setPCV3(Date pCV3) {
		PCV3 = pCV3;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getPenta1() {
		return Penta1;
	}
	
	public void setPenta1(Date penta1) {
		Penta1 = penta1;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getPenta2() {
		return Penta2;
	}
	
	public void setPenta2(Date penta2) {
		Penta2 = penta2;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getPenta3() {
		return Penta3;
	}
	
	public void setPenta3(Date penta3) {
		Penta3 = penta3;
	}
	
	public String getExisting_Premature_Birth() {
		return existing_Premature_Birth;
	}
	
	public void setexisting_Premature_Birth(String existing_Premature_Birth) {
		this.existing_Premature_Birth = existing_Premature_Birth;
	}
	
	public String getExisting_Couple_No() {
		return existing_Couple_No;
	}
	
	public void setexisting_Couple_No(String existing_Couple_No) {
		this.existing_Couple_No = existing_Couple_No;
	}
	
	public Long getVersion() {
		return version;
	}
	
	public void setversion(Long version) {
		this.version = version;
	}
	
	public String getHas_Referred() {
		return Has_Referred;
	}
	
	public void setHas_Referred(String has_Referred) {
		Has_Referred = has_Referred;
	}
	
	public String getExisting_Mem_F_Name() {
		return existing_Mem_F_Name;
	}
	
	public void setexisting_Mem_F_Name(String existing_Mem_F_Name) {
		this.existing_Mem_F_Name = existing_Mem_F_Name;
	}
	
	public String getNote() {
		return Note;
	}
	
	public void setNote(String note) {
		Note = note;
	}
	
	public String getExisting_HR() {
		return existing_HR;
	}
	
	public void setexisting_HR(String existing_HR) {
		this.existing_HR = existing_HR;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getMeasles1() {
		return Measles1;
	}
	
	public void setMeasles1(Date measles1) {
		Measles1 = measles1;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getMeasles2() {
		return Measles2;
	}
	
	public void setMeasles2(Date measles2) {
		Measles2 = measles2;
	}
	
	public String getExisting_ELCO_NID() {
		return existing_ELCO_NID;
	}
	
	public void setexisting_ELCO_NID(String existing_ELCO_NID) {
		this.existing_ELCO_NID = existing_ELCO_NID;
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
	
	@Temporal(TemporalType.DATE)
	public Date getIPV() {
		return IPV;
	}
	
	public void setIPV(Date iPV) {
		IPV = iPV;
	}
	
	public String getDetail_Diseases_Prob() {
		return Detail_Diseases_Prob;
	}
	
	public void setDetail_Diseases_Prob(String detail_Diseases_Prob) {
		Detail_Diseases_Prob = detail_Diseases_Prob;
	}
	
	public String getChanges() {
		return changes;
	}
	
	public void setchanges(String changes) {
		this.changes = changes;
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
