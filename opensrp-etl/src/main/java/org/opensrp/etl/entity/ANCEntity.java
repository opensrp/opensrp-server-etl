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
@Table(name = "anc")
public class ANCEntity {
	
	public ANCEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "anc_id_seq")
	@SequenceGenerator(name = "anc_id_seq", sequenceName = "anc_id_seq", allocationSize = 1)
	private long id;
	
	private String ancName;

	@Column(name = "doc_id")
	private String _id;

	@Column(name = "end_time")
	private Date end;

	private Date start;

	private Date received_time;

	@Temporal(TemporalType.DATE)
	private Date today;

	private Integer Visit_Status;

	@Temporal(TemporalType.DATE)
	private Date Visit_Date;

	private Integer Is_Reffered;

	private Integer Preg_Status;

	private String existing_Caesarean;

	private String existing_Age_Youngest_Child;
	
	private String existing_Mem_Marital_Status;
	
	private String existing_ELCO_Mobile_Number;
	
	private String existing_Bleeding;
	
	private Integer IFA_Received;
	
	private String existing_Heavy_Blood_Flow;
	
	@Temporal(TemporalType.DATE)
	private Date ANC_Expired_Date;
	
	private String existing_Final_Vill;
	
	private String yn_dk_label;
	
	private String existing_Gravida;
	
	private String Confirm_Info;

	private Integer Is_Post_Due;
	
	private String existing_ELCO_BRID;
	
	@Temporal(TemporalType.DATE)
	private Date existing_EDD;
	
	private String Met;
	
	private String existing_Birth_Outcome;
	
	private String existing_Mauzapara;
	
	private String Convulsions;
	
	private String Is_On_Time;
	
	private String existing_TT_Count;
	
	private String existing_Dead_Child;
	
	private String existing_GoB_HHID;
	
	private String existing_Couple_No;
	
	private String Symptoms;
	
	private String existing_Spouse_Name;
	
	private String Is_Critical;
	
	private String Is_Expired;
	
	private String existing_ELCO;
	
	private String existing_Height;
	
	private String ELCO;
	
	private String existing_Marriage_Life;
	
	private String Headache_Blur_Vision;
	
	private String existing_Mem_F_Name;
	
	private String existing_Risky_Preg;
	
	private String anc_current_formStatus;
	
	@Temporal(TemporalType.DATE)
	private Date ANC_Post_Due_Date;
	
	private String existing_Gestational_Age;

	private String existing_Prolong_Delivery;
	
	private String existing_HoH_F_Name;
	
	private String Prolonged_Delivery;
	
	private String existing_Total_Child_Alive;
	
	private String Not_Eligible;
	
	@Temporal(TemporalType.DATE)
	private Date existing_LMP;
	
	private String Position_Child_During_Delivery;
	
	private String Menstruation;
	
	private String High_Fever;

	public long getId() {
		return id;
	}

	@Temporal(TemporalType.DATE)
	private Date ANC_Due_Date;
	
	private String relationalid;

	public String getAncName() {
		return ancName;
	}
	
	public void setAncName(String ancName) {
		this.ancName = ancName;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getExisting_Age_Youngest_Child() {
		return existing_Age_Youngest_Child;
	}
	
	public void setexisting_Age_Youngest_Child(String existing_Age_Youngest_Child) {
		this.existing_Age_Youngest_Child = existing_Age_Youngest_Child;
	}
	
	public String getExisting_Mem_Marital_Status() {
		return existing_Mem_Marital_Status;
	}
	
	public void setexisting_Mem_Marital_Status(String existing_Mem_Marital_Status) {
		this.existing_Mem_Marital_Status = existing_Mem_Marital_Status;
	}
	
	public String getExisting_ELCO_Mobile_Number() {
		return existing_ELCO_Mobile_Number;
	}
	
	public void setexisting_ELCO_Mobile_Number(String existing_ELCO_Mobile_Number) {
		this.existing_ELCO_Mobile_Number = existing_ELCO_Mobile_Number;
	}
	
	public String getExisting_Bleeding() {
		return existing_Bleeding;
	}
	
	public void setexisting_Bleeding(String existing_Bleeding) {
		this.existing_Bleeding = existing_Bleeding;
	}
	
	public Integer getIFA_Received() {
		return IFA_Received;
	}
	
	public void setIFA_Received(Integer iFA_Received) {
		IFA_Received = iFA_Received;
	}
	
	public String getExisting_Heavy_Blood_Flow() {
		return existing_Heavy_Blood_Flow;
	}
	
	public void setexisting_Heavy_Blood_Flow(String existing_Heavy_Blood_Flow) {
		this.existing_Heavy_Blood_Flow = existing_Heavy_Blood_Flow;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getANC_Expired_Date() {
		return ANC_Expired_Date;
	}
	
	public void setANC_Expired_Date(Date aNC_Expired_Date) {
		ANC_Expired_Date = aNC_Expired_Date;
	}
	
	public String getExisting_Final_Vill() {
		return existing_Final_Vill;
	}
	
	public void setexisting_Final_Vill(String existing_Final_Vill) {
		this.existing_Final_Vill = existing_Final_Vill;
	}
	
	public String getYn_dk_label() {
		return yn_dk_label;
	}
	
	public void setyn_dk_label(String yn_dk_label) {
		this.yn_dk_label = yn_dk_label;
	}
	
	public String getExisting_Gravida() {
		return existing_Gravida;
	}
	
	public void setexisting_Gravida(String existing_Gravida) {
		this.existing_Gravida = existing_Gravida;
	}
	
	public String getConfirm_Info() {
		return Confirm_Info;
	}
	
	public void setConfirm_Info(String confirm_Info) {
		Confirm_Info = confirm_Info;
	}
	
	public Integer getVisit_Status() {
		return Visit_Status;
	}
	
	public void setVisit_Status(Integer visit_Status) {
		Visit_Status = visit_Status;
	}
	
	public Integer getIs_Post_Due() {
		return Is_Post_Due;
	}
	
	public void setIs_Post_Due(Integer is_Post_Due) {
		Is_Post_Due = is_Post_Due;
	}
	
	public String getexisting_ELCO_BRID() {
		return existing_ELCO_BRID;
	}
	
	public void setexisting_ELCO_BRID(String existing_ELCO_BRID) {
		this.existing_ELCO_BRID = existing_ELCO_BRID;
	}
	
	public Date getExisting_EDD() {
		return existing_EDD;
	}
	
	@Temporal(TemporalType.DATE)
	public void setexisting_EDD(Date existing_EDD) {
		this.existing_EDD = existing_EDD;
	}
	
	public String getMet() {
		return Met;
	}
	
	public void setMet(String met) {
		Met = met;
	}
	
	public String getExisting_Caesarean() {
		return existing_Caesarean;
	}
	
	public void setexisting_Caesarean(String existing_Caesarean) {
		this.existing_Caesarean = existing_Caesarean;
	}
	
	public String getExisting_Birth_Outcome() {
		return existing_Birth_Outcome;
	}
	
	public void setexisting_Birth_Outcome(String existing_Birth_Outcome) {
		this.existing_Birth_Outcome = existing_Birth_Outcome;
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
	
	public String getConvulsions() {
		return Convulsions;
	}
	
	public void setConvulsions(String convulsions) {
		Convulsions = convulsions;
	}
	
	public String getIs_On_Time() {
		return Is_On_Time;
	}
	
	public void setIs_On_Time(String is_On_Time) {
		Is_On_Time = is_On_Time;
	}
	
	public String getExisting_TT_Count() {
		return existing_TT_Count;
	}
	
	public void setexisting_TT_Count(String existing_TT_Count) {
		this.existing_TT_Count = existing_TT_Count;
	}
	
	public String getExisting_Dead_Child() {
		return existing_Dead_Child;
	}
	
	public void setexisting_Dead_Child(String existing_Dead_Child) {
		this.existing_Dead_Child = existing_Dead_Child;
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
	
	public String getExisting_Couple_No() {
		return existing_Couple_No;
	}
	
	public void setexisting_Couple_No(String existing_Couple_No) {
		this.existing_Couple_No = existing_Couple_No;
	}
	
	public String getSymptoms() {
		return Symptoms;
	}
	
	public void setSymptoms(String symptoms) {
		Symptoms = symptoms;
	}
	
	public Integer getIs_Reffered() {
		return Is_Reffered;
	}
	
	public void setIs_Reffered(Integer is_Reffered) {
		Is_Reffered = is_Reffered;
	}
	
	public String getExisting_Spouse_Name() {
		return existing_Spouse_Name;
	}
	
	public void setexisting_Spouse_Name(String existing_Spouse_Name) {
		this.existing_Spouse_Name = existing_Spouse_Name;
	}
	
	public String getIs_Critical() {
		return Is_Critical;
	}
	
	public void setIs_Critical(String is_Critical) {
		Is_Critical = is_Critical;
	}
	
	public String getIs_Expired() {
		return Is_Expired;
	}
	
	public void setIs_Expired(String is_Expired) {
		Is_Expired = is_Expired;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getToday() {
		return today;
	}
	
	public void settoday(Date today) {
		this.today = today;
	}
	
	public Integer getPreg_Status() {
		return Preg_Status;
	}
	
	public void setPreg_Status(Integer preg_Status) {
		Preg_Status = preg_Status;
	}
	
	public String getExisting_ELCO() {
		return existing_ELCO;
	}
	
	public void setexisting_ELCO(String existing_ELCO) {
		this.existing_ELCO = existing_ELCO;
	}
	
	public String getExisting_Height() {
		return existing_Height;
	}
	
	public void setexisting_Height(String existing_Height) {
		this.existing_Height = existing_Height;
	}
	
	public String getELCO() {
		return ELCO;
	}
	
	public void setELCO(String eLCO) {
		ELCO = eLCO;
	}
	
	public String getExisting_Marriage_Life() {
		return existing_Marriage_Life;
	}
	
	public void setexisting_Marriage_Life(String existing_Marriage_Life) {
		this.existing_Marriage_Life = existing_Marriage_Life;
	}
	
	public String getHeadache_Blur_Vision() {
		return Headache_Blur_Vision;
	}
	
	public void setHeadache_Blur_Vision(String headache_Blur_Vision) {
		Headache_Blur_Vision = headache_Blur_Vision;
	}
	
	public String getExisting_Mem_F_Name() {
		return existing_Mem_F_Name;
	}
	
	public void setexisting_Mem_F_Name(String existing_Mem_F_Name) {
		this.existing_Mem_F_Name = existing_Mem_F_Name;
	}
	
	public String getExisting_Risky_Preg() {
		return existing_Risky_Preg;
	}
	
	public void setexisting_Risky_Preg(String existing_Risky_Preg) {
		this.existing_Risky_Preg = existing_Risky_Preg;
	}
	
	public String getAnc_current_formStatus() {
		return anc_current_formStatus;
	}
	
	public void setanc_current_formStatus(String anc_current_formStatus) {
		this.anc_current_formStatus = anc_current_formStatus;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getANC_Post_Due_Date() {
		return ANC_Post_Due_Date;
	}
	
	public void setANC_Post_Due_Date(Date aNC_Post_Due_Date) {
		ANC_Post_Due_Date = aNC_Post_Due_Date;
	}
	
	public String getExisting_Gestational_Age() {
		return existing_Gestational_Age;
	}
	
	public void setexisting_Gestational_Age(String existing_Gestational_Age) {
		this.existing_Gestational_Age = existing_Gestational_Age;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setend(Date end) {
		this.end = end;
	}
	
	public String getExisting_Prolong_Delivery() {
		return existing_Prolong_Delivery;
	}
	
	public void setexisting_Prolong_Delivery(String existing_Prolong_Delivery) {
		this.existing_Prolong_Delivery = existing_Prolong_Delivery;
	}
	
	public Date getReceived_time() {
		return received_time;
	}
	
	public void setreceived_time(Date received_time) {
		this.received_time = received_time;
	}
	
	public String getExisting_HoH_F_Name() {
		return existing_HoH_F_Name;
	}
	
	public void setexisting_HoH_F_Name(String existing_HoH_F_Name) {
		this.existing_HoH_F_Name = existing_HoH_F_Name;
	}
	
	public String getProlonged_Delivery() {
		return Prolonged_Delivery;
	}
	
	public void setProlonged_Delivery(String prolonged_Delivery) {
		Prolonged_Delivery = prolonged_Delivery;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getVisit_Date() {
		return Visit_Date;
	}
	
	public void setVisit_Date(Date visit_Date) {
		Visit_Date = visit_Date;
	}
	
	public String getExisting_Total_Child_Alive() {
		return existing_Total_Child_Alive;
	}
	
	public void setexisting_Total_Child_Alive(String existing_Total_Child_Alive) {
		this.existing_Total_Child_Alive = existing_Total_Child_Alive;
	}
	
	public String getNot_Eligible() {
		return Not_Eligible;
	}
	
	public void setNot_Eligible(String not_Eligible) {
		Not_Eligible = not_Eligible;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getExisting_LMP() {
		return existing_LMP;
	}
	
	@Temporal(TemporalType.DATE)
	public void setexisting_LMP(Date existing_LMP) {
		this.existing_LMP = existing_LMP;
	}
	
	public String getPosition_Child_During_Delivery() {
		return Position_Child_During_Delivery;
	}
	
	public void setPosition_Child_During_Delivery(String position_Child_During_Delivery) {
		Position_Child_During_Delivery = position_Child_During_Delivery;
	}
	
	public String getMenstruation() {
		return Menstruation;
	}
	
	public void setMenstruation(String menstruation) {
		Menstruation = menstruation;
	}
	
	public String getHigh_Fever() {
		return High_Fever;
	}
	
	public void setHigh_Fever(String high_Fever) {
		High_Fever = high_Fever;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getANC_Due_Date() {
		return ANC_Due_Date;
	}
	
	public void setANC_Due_Date(Date aNC_Due_Date) {
		ANC_Due_Date = aNC_Due_Date;
	}
}
