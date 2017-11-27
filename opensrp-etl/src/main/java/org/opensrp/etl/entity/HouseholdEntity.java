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
@Table(name = "household")
public class HouseholdEntity {
	
	public HouseholdEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "household_id_seq")
	@SequenceGenerator(name = "household_id_seq", sequenceName = "household_id_seq", allocationSize = 1)
	private int id;
	
	private String caseId;
	
	@Column(name = "doc_id")
	private String _id;
	
	private String INSTANCEID;
	
	private String PROVIDERID;
	
	private String existing_location;
	
	private String existing_Country;
	
	private String existing_Division;
	
	private String existing_District;
	
	private String existing_Upazilla;
	
	private String existing_Union;
	
	private String existing_Ward;
	
	private Date Start;
	
	@Temporal(TemporalType.DATE)
	private Date Today;
	
	@Column(name = "end_time")
	private Date End;
	
	@Temporal(TemporalType.DATE)
	private Date Reg_Date;
	
	private String Village_Name;
	
	private String GoB_HHID;
	
	private String No_Of_Couples;
	
	private String Country;
	
	private String Division;
	
	private String District;
	
	private String Upazilla;
	
	@Column(name = "union_name")
	private String Union;
	
	private String Ward;
	
	private String Subunit;
	
	private String Mauzapara;
	
	private String GPS;
	
	private String HoH_F_Name;
	
	private String HoH_L_Name;
	
	private String HoH_Gender;
	
	private String HoH_Age;
	
	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private Date Calc_HoH_Dob_Confirm;
	
	private String HoH_ID_Type;
	
	private String HoH_NID;
	
	private String HoH_BRID;
	
	private String HoH_Mobile_number;
	
	private String Member_Number;
	
	private String MWRA;
	
	private String Final_ELCO;
	
	private String HH_Status;
	
	public int getId() {
		return id;
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
	
	public String getExisting_location() {
		return existing_location;
	}
	
	public void setExisting_location(String existing_location) {
		this.existing_location = existing_location;
	}
	
	public String getExisting_Country() {
		return existing_Country;
	}
	
	public void setExisting_Country(String existing_Country) {
		this.existing_Country = existing_Country;
	}
	
	public String getExisting_Division() {
		return existing_Division;
	}
	
	public void setExisting_Division(String existing_Division) {
		this.existing_Division = existing_Division;
	}
	
	public String getExisting_District() {
		return existing_District;
	}
	
	public void setExisting_District(String existing_District) {
		this.existing_District = existing_District;
	}
	
	public String getExisting_Upazilla() {
		return existing_Upazilla;
	}
	
	public void setExisting_Upazilla(String existing_Upazilla) {
		this.existing_Upazilla = existing_Upazilla;
	}
	
	public String getExisting_Union() {
		return existing_Union;
	}
	
	public void setExisting_Union(String existing_Union) {
		this.existing_Union = existing_Union;
	}
	
	public String getExisting_Ward() {
		return existing_Ward;
	}
	
	public void setExisting_Ward(String existing_Ward) {
		this.existing_Ward = existing_Ward;
	}
	
	public Date getStart() {
		return Start;
	}
	
	public void setStart(Date start) {
		Start = start;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getToday() {
		return Today;
	}
	
	public void setToday(Date today) {
		Today = today;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getReg_Date() {
		return Reg_Date;
	}
	
	public void setReg_Date(Date reg_Date) {
		Reg_Date = reg_Date;
	}
	
	public String getVillage_Name() {
		return Village_Name;
	}
	
	public void setVillage_Name(String village_Name) {
		Village_Name = village_Name;
	}
	
	public String getGoB_HHID() {
		return GoB_HHID;
	}
	
	public void setGoB_HHID(String goB_HHID) {
		GoB_HHID = goB_HHID;
	}
	
	public Date getEnd() {
		return End;
	}
	
	public void setEnd(Date end) {
		End = end;
	}
	
	public String getNo_Of_Couples() {
		return No_Of_Couples;
	}
	
	public void setNo_Of_Couples(String no_Of_Couples) {
		No_Of_Couples = no_Of_Couples;
	}
	
	public String getCountry() {
		return Country;
	}
	
	public void setCountry(String country) {
		Country = country;
	}
	
	public String getDivision() {
		return Division;
	}
	
	public void setDivision(String division) {
		Division = division;
	}
	
	public String getDistrict() {
		return District;
	}
	
	public void setDistrict(String district) {
		District = district;
	}
	
	public String getUpazilla() {
		return Upazilla;
	}
	
	public void setUpazilla(String upazilla) {
		Upazilla = upazilla;
	}
	
	public String getUnion() {
		return Union;
	}
	
	public void setUnion(String union) {
		Union = union;
	}
	
	public String getWard() {
		return Ward;
	}
	
	public void setWard(String ward) {
		Ward = ward;
	}
	
	public String getSubunit() {
		return Subunit;
	}
	
	public void setSubunit(String subunit) {
		Subunit = subunit;
	}
	
	public String getMauzapara() {
		return Mauzapara;
	}
	
	public void setMauzapara(String mauzapara) {
		Mauzapara = mauzapara;
	}
	
	public String getGPS() {
		return GPS;
	}
	
	public void setGPS(String gPS) {
		GPS = gPS;
	}
	
	public String getHoH_F_Name() {
		return HoH_F_Name;
	}
	
	public void setHoH_F_Name(String hoH_F_Name) {
		HoH_F_Name = hoH_F_Name;
	}
	
	public String getHoH_L_Name() {
		return HoH_L_Name;
	}
	
	public void setHoH_L_Name(String hoH_L_Name) {
		HoH_L_Name = hoH_L_Name;
	}
	
	public String getHoH_Gender() {
		return HoH_Gender;
	}
	
	public void setHoH_Gender(String hoH_Gender) {
		HoH_Gender = hoH_Gender;
	}
	
	public String getHoH_Age() {
		return HoH_Age;
	}
	
	public void setHoH_Age(String hoH_Age) {
		HoH_Age = hoH_Age;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getCalc_HoH_Dob_Confirm() {
		return Calc_HoH_Dob_Confirm;
	}
	
	public void setCalc_HoH_Dob_Confirm(Date calc_HoH_Dob_Confirm) {
		Calc_HoH_Dob_Confirm = calc_HoH_Dob_Confirm;
	}
	
	public String getHoH_ID_Type() {
		return HoH_ID_Type;
	}
	
	public void setHoH_ID_Type(String hoH_ID_Type) {
		HoH_ID_Type = hoH_ID_Type;
	}
	
	public String getHoH_NID() {
		return HoH_NID;
	}
	
	public void setHoH_NID(String hoH_NID) {
		HoH_NID = hoH_NID;
	}
	
	public String getHoH_BRID() {
		return HoH_BRID;
	}
	
	public void setHoH_BRID(String hoH_BRID) {
		HoH_BRID = hoH_BRID;
	}
	
	public String getHoH_Mobile_number() {
		return HoH_Mobile_number;
	}
	
	public void setHoH_Mobile_number(String hoH_Mobile_number) {
		HoH_Mobile_number = hoH_Mobile_number;
	}
	
	public String getMember_Number() {
		return Member_Number;
	}
	
	public void setMember_Number(String member_Number) {
		Member_Number = member_Number;
	}
	
	public String getMWRA() {
		return MWRA;
	}
	
	public void setMWRA(String mWRA) {
		MWRA = mWRA;
	}
	
	public String getFinal_ELCO() {
		return Final_ELCO;
	}
	
	public void setFinal_ELCO(String final_ELCO) {
		Final_ELCO = final_ELCO;
	}
	
	public String getHH_Status() {
		return HH_Status;
	}
	
	public void setHH_Status(String hH_Status) {
		HH_Status = hH_Status;
	}
	
	public String get_id() {
		return _id;
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}
}
