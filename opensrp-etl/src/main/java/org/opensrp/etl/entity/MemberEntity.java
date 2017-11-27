/**
 * 
 */
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

/**
 * @author proshanto
 */
@Entity
@Table(name = "member")
public class MemberEntity {
	
	public MemberEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_id_seq")
	@SequenceGenerator(name = "member_id_seq", sequenceName = "member_id_seq", allocationSize = 1)
	private int id;
	
	@Column(name = "doc_id")
	private String _id;
	
	private String caseId;
	
	private String INSTANCEID;
	
	private String PROVIDERID;
	
	private String LOCATIONID;
	
	@Temporal(TemporalType.DATE)
	private Date Today;
	
	private Date Start;
	
	@Column(name = "end_time")
	private Date End;
	
	private String relationalid;
	
	private String Member_GoB_HHID;
	
	@Temporal(TemporalType.DATE)
	private Date Member_Reg_Date;
	
	private String Mem_F_Name;
	
	private String Mem_L_Name;
	
	@Temporal(TemporalType.DATE)
	private Date Member_Birth_Date;
	
	private String Member_Age;
	
	private String Calc_Age;
	
	@Temporal(TemporalType.DATE)
	private Date Calc_Dob_Confirm;
	
	private String Calc_Age_Confirm;
	
	private String Birth_Date_Note;
	
	private String Note_age;
	
	private String Member_Gender;
	
	private String Mem_ID_Type;
	
	private String Mem_NID;
	
	private String Mem_BRID;
	
	private String Mem_Mobile_Number;
	
	private String Mem_Marital_Status;
	
	private String Couple_No;
	
	private String Spouse_Name;
	
	private String Wom_Menstruating;
	
	private String Wom_Sterilized;
	
	private String Wom_Hus_Live;
	
	private String Wom_Hus_Alive;
	
	private String Wom_Hus_Sterilized;
	
	private String Eligible;
	
	private String Eligible2;
	
	private String ELCO;
	
	private String ELCO_Note;
	
	private String Mem_Country;
	
	private String Mem_Division;
	
	private String Mem_District;
	
	private String Mem_Upazilla;
	
	private String Mem_Union;
	
	private String Mem_Ward;
	
	private String Mem_Subunit;
	
	private String Mem_Mauzapara;
	
	private String Mem_Village_Name;
	
	private String Mem_GPS;
	
	private String ELCO_ID_Type;
	
	private String ELCO_NID;
	
	private String ELCO_BRID;
	
	private String ELCO_Mobile_Number;
	
	private String Member_Detail;
	
	private String Permanent_Address;
	
	private String Updated_Dist;
	
	private String Updated_Union;
	
	private String Updated_Vill;
	
	private String Final_Dist;
	
	private String Final_Union;
	
	private String Final_Vill;
	
	private String Relation_HoH;
	
	private String Place_Of_Birth;
	
	private String Education;
	
	private String Religion;
	
	private String BD_Citizen;
	
	private String Occupation;
	
	public String get_id() {
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getCaseId() {
		return caseId;
	}
	
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	public String getINSTANCEID() {
		return INSTANCEID;
	}
	
	public void setINSTANCEID(String iNSTANCEID) {
		INSTANCEID = iNSTANCEID;
	}
	
	public String getPROVIDERID() {
		return PROVIDERID;
	}
	
	public void setPROVIDERID(String pROVIDERID) {
		PROVIDERID = pROVIDERID;
	}
	
	public String getLOCATIONID() {
		return LOCATIONID;
	}
	
	public void setLOCATIONID(String lOCATIONID) {
		LOCATIONID = lOCATIONID;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getToday() {
		return Today;
	}
	
	public void setToday(Date today) {
		Today = today;
	}
	
	public Date getStart() {
		return Start;
	}
	
	public void setStart(Date start) {
		Start = start;
	}
	
	public Date getEnd() {
		return End;
	}
	
	public void setEnd(Date end) {
		End = end;
	}
	
	public String getRelationalid() {
		return relationalid;
	}
	
	public void setRelationalid(String relationalid) {
		this.relationalid = relationalid;
	}
	
	public String getMember_GoB_HHID() {
		return Member_GoB_HHID;
	}
	
	public void setMember_GoB_HHID(String member_GoB_HHID) {
		Member_GoB_HHID = member_GoB_HHID;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getMember_Reg_Date() {
		return Member_Reg_Date;
	}
	
	public void setMember_Reg_Date(Date member_Reg_Date) {
		Member_Reg_Date = member_Reg_Date;
	}
	
	public String getMem_F_Name() {
		return Mem_F_Name;
	}
	
	public void setMem_F_Name(String mem_F_Name) {
		Mem_F_Name = mem_F_Name;
	}
	
	public String getMem_L_Name() {
		return Mem_L_Name;
	}
	
	public void setMem_L_Name(String mem_L_Name) {
		Mem_L_Name = mem_L_Name;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getMember_Birth_Date() {
		return Member_Birth_Date;
	}
	
	public void setMember_Birth_Date(Date member_Birth_Date) {
		Member_Birth_Date = member_Birth_Date;
	}
	
	public String getMember_Age() {
		return Member_Age;
	}
	
	public void setMember_Age(String member_Age) {
		Member_Age = member_Age;
	}
	
	public String getCalc_Age() {
		return Calc_Age;
	}
	
	public void setCalc_Age(String calc_Age) {
		Calc_Age = calc_Age;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getCalc_Dob_Confirm() {
		return Calc_Dob_Confirm;
	}
	
	public void setCalc_Dob_Confirm(Date calc_Dob_Confirm) {
		Calc_Dob_Confirm = calc_Dob_Confirm;
	}
	
	public String getCalc_Age_Confirm() {
		return Calc_Age_Confirm;
	}
	
	public void setCalc_Age_Confirm(String calc_Age_Confirm) {
		Calc_Age_Confirm = calc_Age_Confirm;
	}
	
	public String getBirth_Date_Note() {
		return Birth_Date_Note;
	}
	
	public void setBirth_Date_Note(String birth_Date_Note) {
		Birth_Date_Note = birth_Date_Note;
	}
	
	public String getNote_age() {
		return Note_age;
	}
	
	public void setNote_age(String note_age) {
		Note_age = note_age;
	}
	
	public String getMember_Gender() {
		return Member_Gender;
	}
	
	public void setMember_Gender(String member_Gender) {
		Member_Gender = member_Gender;
	}
	
	public String getMem_ID_Type() {
		return Mem_ID_Type;
	}
	
	public void setMem_ID_Type(String mem_ID_Type) {
		Mem_ID_Type = mem_ID_Type;
	}
	
	public String getMem_NID() {
		return Mem_NID;
	}
	
	public void setMem_NID(String mem_NID) {
		Mem_NID = mem_NID;
	}
	
	public String getMem_BRID() {
		return Mem_BRID;
	}
	
	public void setMem_BRID(String mem_BRID) {
		Mem_BRID = mem_BRID;
	}
	
	public String getMem_Mobile_Number() {
		return Mem_Mobile_Number;
	}
	
	public void setMem_Mobile_Number(String mem_Mobile_Number) {
		Mem_Mobile_Number = mem_Mobile_Number;
	}
	
	public String getMem_Marital_Status() {
		return Mem_Marital_Status;
	}
	
	public void setMem_Marital_Status(String mem_Marital_Status) {
		Mem_Marital_Status = mem_Marital_Status;
	}
	
	public String getCouple_No() {
		return Couple_No;
	}
	
	public void setCouple_No(String couple_No) {
		Couple_No = couple_No;
	}
	
	public String getSpouse_Name() {
		return Spouse_Name;
	}
	
	public void setSpouse_Name(String spouse_Name) {
		Spouse_Name = spouse_Name;
	}
	
	public String getWom_Menstruating() {
		return Wom_Menstruating;
	}
	
	public void setWom_Menstruating(String wom_Menstruating) {
		Wom_Menstruating = wom_Menstruating;
	}
	
	public String getWom_Sterilized() {
		return Wom_Sterilized;
	}
	
	public void setWom_Sterilized(String wom_Sterilized) {
		Wom_Sterilized = wom_Sterilized;
	}
	
	public String getWom_Hus_Live() {
		return Wom_Hus_Live;
	}
	
	public void setWom_Hus_Live(String wom_Hus_Live) {
		Wom_Hus_Live = wom_Hus_Live;
	}
	
	public String getWom_Hus_Alive() {
		return Wom_Hus_Alive;
	}
	
	public void setWom_Hus_Alive(String wom_Hus_Alive) {
		Wom_Hus_Alive = wom_Hus_Alive;
	}
	
	public String getWom_Hus_Sterilized() {
		return Wom_Hus_Sterilized;
	}
	
	public void setWom_Hus_Sterilized(String wom_Hus_Sterilized) {
		Wom_Hus_Sterilized = wom_Hus_Sterilized;
	}
	
	public String getEligible() {
		return Eligible;
	}
	
	public void setEligible(String eligible) {
		Eligible = eligible;
	}
	
	public String getEligible2() {
		return Eligible2;
	}
	
	public void setEligible2(String eligible2) {
		Eligible2 = eligible2;
	}
	
	public String getELCO() {
		return ELCO;
	}
	
	public void setELCO(String eLCO) {
		ELCO = eLCO;
	}
	
	public String getELCO_Note() {
		return ELCO_Note;
	}
	
	public void setELCO_Note(String eLCO_Note) {
		ELCO_Note = eLCO_Note;
	}
	
	public String getMem_Country() {
		return Mem_Country;
	}
	
	public void setMem_Country(String mem_Country) {
		Mem_Country = mem_Country;
	}
	
	public String getMem_Division() {
		return Mem_Division;
	}
	
	public void setMem_Division(String mem_Division) {
		Mem_Division = mem_Division;
	}
	
	public String getMem_District() {
		return Mem_District;
	}
	
	public void setMem_District(String mem_District) {
		Mem_District = mem_District;
	}
	
	public String getMem_Upazilla() {
		return Mem_Upazilla;
	}
	
	public void setMem_Upazilla(String mem_Upazilla) {
		Mem_Upazilla = mem_Upazilla;
	}
	
	public String getMem_Union() {
		return Mem_Union;
	}
	
	public void setMem_Union(String mem_Union) {
		Mem_Union = mem_Union;
	}
	
	public String getMem_Ward() {
		return Mem_Ward;
	}
	
	public void setMem_Ward(String mem_Ward) {
		Mem_Ward = mem_Ward;
	}
	
	public String getMem_Subunit() {
		return Mem_Subunit;
	}
	
	public void setMem_Subunit(String mem_Subunit) {
		Mem_Subunit = mem_Subunit;
	}
	
	public String getMem_Mauzapara() {
		return Mem_Mauzapara;
	}
	
	public void setMem_Mauzapara(String mem_Mauzapara) {
		Mem_Mauzapara = mem_Mauzapara;
	}
	
	public String getMem_Village_Name() {
		return Mem_Village_Name;
	}
	
	public void setMem_Village_Name(String mem_Village_Name) {
		Mem_Village_Name = mem_Village_Name;
	}
	
	public String getMem_GPS() {
		return Mem_GPS;
	}
	
	public void setMem_GPS(String mem_GPS) {
		Mem_GPS = mem_GPS;
	}
	
	public String getELCO_ID_Type() {
		return ELCO_ID_Type;
	}
	
	public void setELCO_ID_Type(String eLCO_ID_Type) {
		ELCO_ID_Type = eLCO_ID_Type;
	}
	
	public String getELCO_NID() {
		return ELCO_NID;
	}
	
	public void setELCO_NID(String eLCO_NID) {
		ELCO_NID = eLCO_NID;
	}
	
	public String getELCO_BRID() {
		return ELCO_BRID;
	}
	
	public void setELCO_BRID(String eLCO_BRID) {
		ELCO_BRID = eLCO_BRID;
	}
	
	public String getELCO_Mobile_Number() {
		return ELCO_Mobile_Number;
	}
	
	public void setELCO_Mobile_Number(String eLCO_Mobile_Number) {
		ELCO_Mobile_Number = eLCO_Mobile_Number;
	}
	
	public String getMember_Detail() {
		return Member_Detail;
	}
	
	public void setMember_Detail(String member_Detail) {
		Member_Detail = member_Detail;
	}
	
	public String getPermanent_Address() {
		return Permanent_Address;
	}
	
	public void setPermanent_Address(String permanent_Address) {
		Permanent_Address = permanent_Address;
	}
	
	public String getUpdated_Dist() {
		return Updated_Dist;
	}
	
	public void setUpdated_Dist(String updated_Dist) {
		Updated_Dist = updated_Dist;
	}
	
	public String getUpdated_Union() {
		return Updated_Union;
	}
	
	public void setUpdated_Union(String updated_Union) {
		Updated_Union = updated_Union;
	}
	
	public String getUpdated_Vill() {
		return Updated_Vill;
	}
	
	public void setUpdated_Vill(String updated_Vill) {
		Updated_Vill = updated_Vill;
	}
	
	public String getFinal_Dist() {
		return Final_Dist;
	}
	
	public void setFinal_Dist(String final_Dist) {
		Final_Dist = final_Dist;
	}
	
	public String getFinal_Union() {
		return Final_Union;
	}
	
	public void setFinal_Union(String final_Union) {
		Final_Union = final_Union;
	}
	
	public String getFinal_Vill() {
		return Final_Vill;
	}
	
	public void setFinal_Vill(String final_Vill) {
		Final_Vill = final_Vill;
	}
	
	public String getRelation_HoH() {
		return Relation_HoH;
	}
	
	public void setRelation_HoH(String relation_HoH) {
		Relation_HoH = relation_HoH;
	}
	
	public String getPlace_Of_Birth() {
		return Place_Of_Birth;
	}
	
	public void setPlace_Of_Birth(String place_Of_Birth) {
		Place_Of_Birth = place_Of_Birth;
	}
	
	public String getEducation() {
		return Education;
	}
	
	public void setEducation(String education) {
		Education = education;
	}
	
	public String getReligion() {
		return Religion;
	}
	
	public void setReligion(String religion) {
		Religion = religion;
	}
	
	public String getBD_Citizen() {
		return BD_Citizen;
	}
	
	public void setBD_Citizen(String bD_Citizen) {
		BD_Citizen = bD_Citizen;
	}
	
	public String getOccupation() {
		return Occupation;
	}
	
	public void setOccupation(String occupation) {
		Occupation = occupation;
	}
	
	public int getId() {
		return id;
	}
	
}
