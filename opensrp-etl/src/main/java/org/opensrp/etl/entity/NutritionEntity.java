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
@Table(name = "nutrition")
public class NutritionEntity {
	
	public NutritionEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nutrition_id_seq")
	@SequenceGenerator(name = "nutrition_id_seq", sequenceName = "nutrition_id_seq", allocationSize = 1)
	private int id;
	
	private String doc_id;
	
	private String existing_TT_Count;
	
	private Long serverVersion;
	
	private String existing_Couple_No;
	
	@Temporal(TemporalType.DATE)
	private Date Visit_Date;
	
	private String existing_Union;
	
	private String changes;
	
	private String existing_Child_Father;
	
	private Date received_time;
	
	private String existing_Mem_F_Name;
	
	private String existing_GoB_HHID;
	
	private String existing_Division;
	
	private String existing_Mauzapara;
	
	private String Supplementary_Food;
	
	@Temporal(TemporalType.DATE)
	private Date Calc_Dob_Confirm;
	
	private String Refer;
	
	private Integer Visit_Status;
	
	private String VitA_Minarals;
	
	private String Mother_Nutrition;
	
	private String IFA_Tablets;
	
	@Column(name = "end_time")
	private Date end;
	
	@Temporal(TemporalType.DATE)
	private Date existing_Injection_Date;
	
	private String Child_Nutrition;
	
	private String relationalid;
	
	private String existing_Upazilla;
	
	private String existing_Ward;
	
	private String Distrinuted_Nutrition;
	
	private String existing_Subunit;
	
	private String existing_Spouse_Name;
	
	private String existing_District;
	
	private String existing_Child_Mother;
	
	private Date start;
	
	@Temporal(TemporalType.DATE)
	private Date existing_Calc_Dob_Confirm;
	
	private String existing_HoH_F_Name;
	
	private String Confirm_Info;
	
	private String existing_Final_Vill;
	
	private String Met;
	
	private String existing_ELCO_Mobile_Number;
	
	private String existing_Country;
	
	public String getDoc_id() {
		return doc_id;
	}
	
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getExisting_TT_Count() {
		return existing_TT_Count;
	}
	
	public void setexisting_TT_Count(String existing_TT_Count) {
		this.existing_TT_Count = existing_TT_Count;
	}
	
	public Long getServerVersion() {
		return serverVersion;
	}
	
	public void setserverVersion(Long serverVersion) {
		this.serverVersion = serverVersion;
	}
	
	public String getExisting_Couple_No() {
		return existing_Couple_No;
	}
	
	public void setexisting_Couple_No(String existing_Couple_No) {
		this.existing_Couple_No = existing_Couple_No;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getVisit_Date() {
		return Visit_Date;
	}
	
	public void setVisit_Date(Date visit_Date) {
		Visit_Date = visit_Date;
	}
	
	public String getExisting_Union() {
		return existing_Union;
	}
	
	public void setexisting_Union(String existing_Union) {
		this.existing_Union = existing_Union;
	}
	
	public String getChanges() {
		return changes;
	}
	
	public void setchanges(String changes) {
		this.changes = changes;
	}
	
	public String getExisting_Child_Father() {
		return existing_Child_Father;
	}
	
	public void setexisting_Child_Father(String existing_Child_Father) {
		this.existing_Child_Father = existing_Child_Father;
	}
	
	public Date getReceived_time() {
		return received_time;
	}
	
	public void setreceived_time(Date received_time) {
		this.received_time = received_time;
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
	
	public String getExisting_Division() {
		return existing_Division;
	}
	
	public void setexisting_Division(String existing_Division) {
		this.existing_Division = existing_Division;
	}
	
	public String getExisting_Mauzapara() {
		return existing_Mauzapara;
	}
	
	public void setexisting_Mauzapara(String existing_Mauzapara) {
		this.existing_Mauzapara = existing_Mauzapara;
	}
	
	public String getSupplementary_Food() {
		return Supplementary_Food;
	}
	
	public void setSupplementary_Food(String supplementary_Food) {
		Supplementary_Food = supplementary_Food;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getCalc_Dob_Confirm() {
		return Calc_Dob_Confirm;
	}
	
	public void setCalc_Dob_Confirm(Date calc_Dob_Confirm) {
		Calc_Dob_Confirm = calc_Dob_Confirm;
	}
	
	public String getRefer() {
		return Refer;
	}
	
	public void setRefer(String refer) {
		Refer = refer;
	}
	
	public Integer getVisit_Status() {
		return Visit_Status;
	}
	
	public void setVisit_Status(Integer visit_Status) {
		Visit_Status = visit_Status;
	}
	
	public String getVitA_Minarals() {
		return VitA_Minarals;
	}
	
	public void setVitA_Minarals(String vitA_Minarals) {
		VitA_Minarals = vitA_Minarals;
	}
	
	public String getMother_Nutrition() {
		return Mother_Nutrition;
	}
	
	public void setMother_Nutrition(String mother_Nutrition) {
		Mother_Nutrition = mother_Nutrition;
	}
	
	public String getIFA_Tablets() {
		return IFA_Tablets;
	}
	
	public void setIFA_Tablets(String iFA_Tablets) {
		IFA_Tablets = iFA_Tablets;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setend(Date end) {
		this.end = end;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getExisting_Injection_Date() {
		return existing_Injection_Date;
	}
	
	public void setexisting_Injection_Date(Date existing_Injection_Date) {
		this.existing_Injection_Date = existing_Injection_Date;
	}
	
	public String getChild_Nutrition() {
		return Child_Nutrition;
	}
	
	public void setChild_Nutrition(String child_Nutrition) {
		Child_Nutrition = child_Nutrition;
	}
	
	public String getRelationalid() {
		return relationalid;
	}
	
	public void setRelationalid(String relationalid) {
		this.relationalid = relationalid;
	}
	
	public String getExisting_Upazilla() {
		return existing_Upazilla;
	}
	
	public void setexisting_Upazilla(String existing_Upazilla) {
		this.existing_Upazilla = existing_Upazilla;
	}
	
	public String getExisting_Ward() {
		return existing_Ward;
	}
	
	public void setexisting_Ward(String existing_Ward) {
		this.existing_Ward = existing_Ward;
	}
	
	public String getDistrinuted_Nutrition() {
		return Distrinuted_Nutrition;
	}
	
	public void setDistrinuted_Nutrition(String distrinuted_Nutrition) {
		Distrinuted_Nutrition = distrinuted_Nutrition;
	}
	
	public String getExisting_Subunit() {
		return existing_Subunit;
	}
	
	public void setexisting_Subunit(String existing_Subunit) {
		this.existing_Subunit = existing_Subunit;
	}
	
	public String getExisting_Spouse_Name() {
		return existing_Spouse_Name;
	}
	
	public void setexisting_Spouse_Name(String existing_Spouse_Name) {
		this.existing_Spouse_Name = existing_Spouse_Name;
	}
	
	public String getExisting_District() {
		return existing_District;
	}
	
	public void setexisting_District(String existing_District) {
		this.existing_District = existing_District;
	}
	
	public String getExisting_Child_Mother() {
		return existing_Child_Mother;
	}
	
	public void setexisting_Child_Mother(String existing_Child_Mother) {
		this.existing_Child_Mother = existing_Child_Mother;
	}
	
	public Date getStart() {
		return start;
	}
	
	public void setstart(Date start) {
		this.start = start;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getExisting_Calc_Dob_Confirm() {
		return existing_Calc_Dob_Confirm;
	}
	
	public void setexisting_Calc_Dob_Confirm(Date existing_Calc_Dob_Confirm) {
		this.existing_Calc_Dob_Confirm = existing_Calc_Dob_Confirm;
	}
	
	public String getExisting_HoH_F_Name() {
		return existing_HoH_F_Name;
	}
	
	public void setexisting_HoH_F_Name(String existing_HoH_F_Name) {
		this.existing_HoH_F_Name = existing_HoH_F_Name;
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
	
	public String getMet() {
		return Met;
	}
	
	public void setMet(String met) {
		Met = met;
	}
	
	public String getExisting_ELCO_Mobile_Number() {
		return existing_ELCO_Mobile_Number;
	}
	
	public void setexisting_ELCO_Mobile_Number(String existing_ELCO_Mobile_Number) {
		this.existing_ELCO_Mobile_Number = existing_ELCO_Mobile_Number;
	}
	
	public String getExisting_Country() {
		return existing_Country;
	}
	
	public void setexisting_Country(String existing_Country) {
		this.existing_Country = existing_Country;
	}
	
}
