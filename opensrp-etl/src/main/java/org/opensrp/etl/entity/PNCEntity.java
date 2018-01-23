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
@Table(name = "pnc")
public class PNCEntity {
	
	public PNCEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnc_id_seq")
	@SequenceGenerator(name = "pnc_id_seq", sequenceName = "pnc_id_seq", allocationSize = 1)
	private long id;
	
	private Integer Visit_Status;
	
	private Integer Has_PNC_Given_On_Time;
	
	private Integer Is_Cleaned;
	
	private Integer Chlorhexidin;
	
	private Integer Breasmilk_Fed;
	
	@Column(name = "doc_id")
	private String _id;
	
	private String High_Fever;
	
	private String Menstruation;
	
	private String INSTANCEID;
	
	private String pncName;
	
	private String Visit_No;
	
	private String existing_Couple_No;
	
	private String existing_Risky_Preg;
	
	private String HR;
	
	private String existing_Mem_F_Name;
	
	private String existing_GoB_HHID;
	
	private String existing_Mauzapara;
	
	private String existing_LMP;
	
	private String existing_Visit_Status;
	
	private String exising_Union;
	
	private String existing_Spouse_Name;
	
	private String existing_ELCO;
	
	private String Calc_On_Time;
	
	private String Confirm_Info;
	
	private String existing_Final_Vill;
	
	private String existing_ELCO_BRID;
	
	private String Convulsions;
	
	private String Met;
	
	private String Is_Post_Due;
	
	private String Symptoms;
	
	private String existing_TT_Count;
	
	private String Headache_Blur_Vision;
	
	private String changes;
	
	private String existing_Total_Child_Alive;
	
	private String existing_Premature_Birth;
	
	private String Not_Bathed;
	
	private String existing_DOO;
	
	private String Is_On_Time;
	
	private String Is_Critical;
	
	private String yn_dk_label;
	
	private String existing_Delivery_Type;
	
	private String Is_Reffered;
	
	private String Comment;
	
	private String existing_Num_Live_Birth;
	
	private String pnc_current_formStatus;
	
	private String Newborn;
	
	private String existing_HoH_F_Name;
	
	private String existing_Where_Delivered;
	
	private String existing_ELCO_Mobile_Number;
	
	private String Is_Expired;
	
	private String relationalid;
	
	private Date received_time;
	
	private Date start;
	
	@Column(name = "end_time")
	private Date end;
	
	@Temporal(TemporalType.DATE)
	private Date today;
	
	@Temporal(TemporalType.DATE)
	private Date Visit_Date;
	
	@Temporal(TemporalType.DATE)
	private Date PNC_Expired_Date;
	
	@Temporal(TemporalType.DATE)
	private Date PNC_Due_Date;
	
	@Temporal(TemporalType.DATE)
	private Date PNC_Post_Due_Date;
	
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
	
	public String getPncName() {
		return pncName;
	}
	
	public void setPncName(String pncName) {
		this.pncName = pncName;
	}
	
	public String getRelationalid() {
		return relationalid;
	}
	
	public void setrelationalid(String relationalid) {
		this.relationalid = relationalid;
	}
	
	public String get_id() {
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getExisting_Couple_No() {
		return existing_Couple_No;
	}
	
	public void setexisting_Couple_No(String existing_Couple_No) {
		this.existing_Couple_No = existing_Couple_No;
	}
	
	public String getExisting_Risky_Preg() {
		return existing_Risky_Preg;
	}
	
	public void setexisting_Risky_Preg(String existing_Risky_Preg) {
		this.existing_Risky_Preg = existing_Risky_Preg;
	}
	
	public String getHR() {
		return HR;
	}
	
	public void setHR(String hR) {
		HR = hR;
	}
	
	public String getExisting_Mem_F_Name() {
		return existing_Mem_F_Name;
	}
	
	public void setexisting_Mem_F_Name(String existing_Mem_F_Name) {
		this.existing_Mem_F_Name = existing_Mem_F_Name;
	}
	
	public String getExisting_GoB_HHID() {
		return existing_GoB_HHID;
	}
	
	public void setexisting_GoB_HHID(String existing_GoB_HHID) {
		this.existing_GoB_HHID = existing_GoB_HHID;
	}
	
	public String getExisting_Mauzapara() {
		return existing_Mauzapara;
	}
	
	public void setexisting_Mauzapara(String existing_Mauzapara) {
		this.existing_Mauzapara = existing_Mauzapara;
	}
	
	public String getExisting_LMP() {
		return existing_LMP;
	}
	
	public void setexisting_LMP(String existing_LMP) {
		this.existing_LMP = existing_LMP;
	}
	
	public Integer getVisit_Status() {
		return Visit_Status;
	}
	
	public void setVisit_Status(Integer visit_Status) {
		Visit_Status = visit_Status;
	}
	
	public Integer getIs_Cleaned() {
		return Is_Cleaned;
	}
	
	public void setIs_Cleaned(Integer is_Cleaned) {
		Is_Cleaned = is_Cleaned;
	}
	
	public String getExisting_Visit_Status() {
		return existing_Visit_Status;
	}
	
	public void setexisting_Visit_Status(String existing_Visit_Status) {
		this.existing_Visit_Status = existing_Visit_Status;
	}
	
	public String getExising_Union() {
		return exising_Union;
	}
	
	public void setexising_Union(String exising_Union) {
		this.exising_Union = exising_Union;
	}
	
	public String getMenstruation() {
		return Menstruation;
	}
	
	public void setMenstruation(String menstruation) {
		Menstruation = menstruation;
	}
	
	public String getExisting_Spouse_Name() {
		return existing_Spouse_Name;
	}
	
	public void setexisting_Spouse_Name(String existing_Spouse_Name) {
		this.existing_Spouse_Name = existing_Spouse_Name;
	}
	
	public String getHigh_Fever() {
		return High_Fever;
	}
	
	public void setHigh_Fever(String high_Fever) {
		High_Fever = high_Fever;
	}
	
	public String getExisting_ELCO() {
		return existing_ELCO;
	}
	
	public void setexisting_ELCO(String existing_ELCO) {
		this.existing_ELCO = existing_ELCO;
	}
	
	public String getCalc_On_Time() {
		return Calc_On_Time;
	}
	
	public void setCalc_On_Time(String calc_On_Time) {
		Calc_On_Time = calc_On_Time;
	}
	
	public Integer getChlorhexidin() {
		return Chlorhexidin;
	}
	
	public void setChlorhexidin(Integer chlorhexidin) {
		Chlorhexidin = chlorhexidin;
	}
	
	public String getConfirm_Info() {
		return Confirm_Info;
	}
	
	public void setConfirm_Info(String confirm_Info) {
		Confirm_Info = confirm_Info;
	}
	
	public String getExisting_Final_Vill() {
		return existing_Final_Vill;
	}
	
	public void setexisting_Final_Vill(String existing_Final_Vill) {
		this.existing_Final_Vill = existing_Final_Vill;
	}
	
	public String getVisit_No() {
		return Visit_No;
	}
	
	public void setVisit_No(String visit_No) {
		Visit_No = visit_No;
	}
	
	public String getExisting_ELCO_BRID() {
		return existing_ELCO_BRID;
	}
	
	public void setexisting_ELCO_BRID(String existing_ELCO_BRID) {
		this.existing_ELCO_BRID = existing_ELCO_BRID;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getPNC_Expired_Date() {
		return PNC_Expired_Date;
	}
	
	public void setPNC_Expired_Date(Date pNC_Expired_Date) {
		PNC_Expired_Date = pNC_Expired_Date;
	}
	
	public String getConvulsions() {
		return Convulsions;
	}
	
	public void setConvulsions(String convulsions) {
		Convulsions = convulsions;
	}
	
	public String getMet() {
		return Met;
	}
	
	public void setMet(String met) {
		Met = met;
	}
	
	public String getIs_Post_Due() {
		return Is_Post_Due;
	}
	
	public void setIs_Post_Due(String is_Post_Due) {
		Is_Post_Due = is_Post_Due;
	}
	
	public String getSymptoms() {
		return Symptoms;
	}
	
	public void setSymptoms(String symptoms) {
		Symptoms = symptoms;
	}
	
	public String getExisting_TT_Count() {
		return existing_TT_Count;
	}
	
	public void setexisting_TT_Count(String existing_TT_Count) {
		this.existing_TT_Count = existing_TT_Count;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getVisit_Date() {
		return Visit_Date;
	}
	
	public void setVisit_Date(Date visit_Date) {
		Visit_Date = visit_Date;
	}
	
	public String getHeadache_Blur_Vision() {
		return Headache_Blur_Vision;
	}
	
	public void setHeadache_Blur_Vision(String headache_Blur_Vision) {
		Headache_Blur_Vision = headache_Blur_Vision;
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
	
	public String getExisting_Total_Child_Alive() {
		return existing_Total_Child_Alive;
	}
	
	public void setexisting_Total_Child_Alive(String existing_Total_Child_Alive) {
		this.existing_Total_Child_Alive = existing_Total_Child_Alive;
	}
	
	public String getExisting_Premature_Birth() {
		return existing_Premature_Birth;
	}
	
	public void setexisting_Premature_Birth(String existing_Premature_Birth) {
		this.existing_Premature_Birth = existing_Premature_Birth;
	}
	
	public String getNot_Bathed() {
		return Not_Bathed;
	}
	
	public void setNot_Bathed(String not_Bathed) {
		Not_Bathed = not_Bathed;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getToday() {
		return today;
	}
	
	public void settoday(Date today) {
		this.today = today;
	}
	
	public String getExisting_DOO() {
		return existing_DOO;
	}
	
	public void setexisting_DOO(String existing_DOO) {
		this.existing_DOO = existing_DOO;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setend(Date end) {
		this.end = end;
	}
	
	public String getIs_On_Time() {
		return Is_On_Time;
	}
	
	public void setIs_On_Time(String is_On_Time) {
		Is_On_Time = is_On_Time;
	}
	
	public String getIs_Critical() {
		return Is_Critical;
	}
	
	public void setIs_Critical(String is_Critical) {
		Is_Critical = is_Critical;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getPNC_Due_Date() {
		return PNC_Due_Date;
	}
	
	public void setPNC_Due_Date(Date pNC_Due_Date) {
		PNC_Due_Date = pNC_Due_Date;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getPNC_Post_Due_Date() {
		return PNC_Post_Due_Date;
	}
	
	public void setPNC_Post_Due_Date(Date pNC_Post_Due_Date) {
		PNC_Post_Due_Date = pNC_Post_Due_Date;
	}
	
	public String getYn_dk_label() {
		return yn_dk_label;
	}
	
	public void setyn_dk_label(String yn_dk_label) {
		this.yn_dk_label = yn_dk_label;
	}
	
	public String getExisting_Delivery_Type() {
		return existing_Delivery_Type;
	}
	
	public void setexisting_Delivery_Type(String existing_Delivery_Type) {
		this.existing_Delivery_Type = existing_Delivery_Type;
	}
	
	public String getIs_Reffered() {
		return Is_Reffered;
	}
	
	public void setIs_Reffered(String is_Reffered) {
		Is_Reffered = is_Reffered;
	}
	
	public String getComment() {
		return Comment;
	}
	
	public void setComment(String comment) {
		Comment = comment;
	}
	
	public String getExisting_Num_Live_Birth() {
		return existing_Num_Live_Birth;
	}
	
	public void setexisting_Num_Live_Birth(String existing_Num_Live_Birth) {
		this.existing_Num_Live_Birth = existing_Num_Live_Birth;
	}
	
	public Date getStart() {
		return start;
	}
	
	public void setstart(Date start) {
		this.start = start;
	}
	
	public String getPnc_current_formStatus() {
		return pnc_current_formStatus;
	}
	
	public void setpnc_current_formStatus(String pnc_current_formStatus) {
		this.pnc_current_formStatus = pnc_current_formStatus;
	}
	
	public Integer getBreasmilk_Fed() {
		return Breasmilk_Fed;
	}
	
	public void setBreasmilk_Fed(Integer breasmilk_Fed) {
		Breasmilk_Fed = breasmilk_Fed;
	}
	
	public String getNewborn() {
		return Newborn;
	}
	
	public void setNewborn(String newborn) {
		Newborn = newborn;
	}
	
	public Integer getHas_PNC_Given_On_Time() {
		return Has_PNC_Given_On_Time;
	}
	
	public void setHas_PNC_Given_On_Time(Integer has_PNC_Given_On_Time) {
		Has_PNC_Given_On_Time = has_PNC_Given_On_Time;
	}
	
	public String getExisting_HoH_F_Name() {
		return existing_HoH_F_Name;
	}
	
	public void setexisting_HoH_F_Name(String existing_HoH_F_Name) {
		this.existing_HoH_F_Name = existing_HoH_F_Name;
	}
	
	public String getExisting_Where_Delivered() {
		return existing_Where_Delivered;
	}
	
	public void setexisting_Where_Delivered(String existing_Where_Delivered) {
		this.existing_Where_Delivered = existing_Where_Delivered;
	}
	
	public String getexisting_ELCO_Mobile_Number() {
		return existing_ELCO_Mobile_Number;
	}
	
	public void setexisting_ELCO_Mobile_Number(String existing_ELCO_Mobile_Number) {
		this.existing_ELCO_Mobile_Number = existing_ELCO_Mobile_Number;
	}
	
	public String getIs_Expired() {
		return Is_Expired;
	}
	
	public void setIs_Expired(String is_Expired) {
		Is_Expired = is_Expired;
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
}
