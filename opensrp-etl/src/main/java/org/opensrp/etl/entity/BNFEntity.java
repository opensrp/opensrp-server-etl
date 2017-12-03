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
@Table(name = "bnf")
public class BNFEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bnf_id_seq")
	@SequenceGenerator(name = "bnf_id_seq", sequenceName = "bnf_id_seq", allocationSize = 1)
	private long id;

	private String Outcome_Occured;

	@Column(name="end_time")
	private Date end;

	@Temporal(TemporalType.DATE)
	private Date Today;

	private Date start;

	private long clientVersion;

	private long serverVersion;

	private long version;

	private int Where_Delivered;

	private int Who_Delivered;

	private int Misoprostol_Received;

	private String Mem_F_Name;

	private int Is_PNC;

	private String Misoprostol_Given;

	private long existing_ELCO_Mobile_Number;

	private String Mem_Upazilla;

	private String Mother_Status;

	private String Premature_Birth;

	private String existing_location;

	private String existing_District;

	private String Mem_District;

	private int Count_Misorpostol;

	private int Member_Age;

	private String existing_Final_Vill;

	private String existing_Subunit;

	private String add_child;

	private String Mem_Mauzapara;

	private String Confirm_Info;

	private int Visit_Status;

	private String Mem_Ward;

	private String Mem_Union;

	private String existing_GPS;

	private String Delivery_Type;

	private String existing_EDD;

	private Date Received_Time;

	private String existing_Ward;

	private String existing_Country;

	private String existing_Mauzapara;

	private String DOO;

	private int existing_TT_Count;

	private int Child_Weight;

	private String existing_GoB_HHID;

	private String Mem_GPS;

	private int existing_Couple_No;

	private String Mem_Division;

	private String Child_Vital_Status;

	private String Name_Check;

	private String existing_Spouse_Name;

	private String Mem_L_Name;

	@Temporal(TemporalType.DATE)
	private Date Member_Reg_Date;

	private String existing_Height;

	private String bnf_current_formStatus;

	private long Mem_BRID;

	private String existing_Union;

	private long Member_GoB_HHID;

	private String existing_Mem_F_Name;

	private String Child_Mother;

	private String Mem_Village_Name;

	private String note;

	private String Child_Father;

	private String Mem_Subunit;

	private String Mem_Country;

	private String Member_Gender;

	private String existing_HoH_F_Name;

	private long Retype_Mem_BRID;

	private String existing_Division;

	private String Mem_BRID_Concept;

	private long Mem_Mobile_Number;

	private int Calc_Age;

	private String Reg_Newborn;

	@Temporal(TemporalType.DATE)
	private Date Visit_Date;

	@Temporal(TemporalType.DATE)
	private Date Member_Birth_Date;

	private String existing_Upazilla;

	private String Child_Name;

	private int Num_Live_Birth;

	private String changes;

	private String relationalid;

	public long getId() {
		return id;
	}

	public String getOutcome_Occured() {
		return Outcome_Occured;
	}

	public void setOutcome_Occured(String outcome_Occured) {
		Outcome_Occured = outcome_Occured;
	}

	public Date getEnd() {
		return end;
	}

	public void setend(Date end) {
		this.end = end;
	}

	public String getMem_F_Name() {
		return Mem_F_Name;
	}

	public void setMem_F_Name(String mem_F_Name) {
		Mem_F_Name = mem_F_Name;
	}

	public int getIs_PNC() {
		return Is_PNC;
	}

	public void setIs_PNC(int is_PNC) {
		Is_PNC = is_PNC;
	}

	public String getMisoprostol_Given() {
		return Misoprostol_Given;
	}

	public void setMisoprostol_Given(String misoprostol_Given) {
		Misoprostol_Given = misoprostol_Given;
	}

	public long getExisting_ELCO_Mobile_Number() {
		return existing_ELCO_Mobile_Number;
	}

	public void setexisting_ELCO_Mobile_Number(long existing_ELCO_Mobile_Number) {
		this.existing_ELCO_Mobile_Number = existing_ELCO_Mobile_Number;
	}

	public String getMem_Upazilla() {
		return Mem_Upazilla;
	}

	public void setMem_Upazilla(String mem_Upazilla) {
		Mem_Upazilla = mem_Upazilla;
	}

	public String getMother_Status() {
		return Mother_Status;
	}

	public void setMother_Status(String mother_Status) {
		Mother_Status = mother_Status;
	}

	public String getPremature_Birth() {
		return Premature_Birth;
	}

	public void setPremature_Birth(String premature_Birth) {
		Premature_Birth = premature_Birth;
	}

	public String getExisting_location() {
		return existing_location;
	}

	public void setexisting_location(String existing_location) {
		this.existing_location = existing_location;
	}

	public String getExisting_District() {
		return existing_District;
	}

	public void setexisting_District(String existing_District) {
		this.existing_District = existing_District;
	}

	public String getMem_District() {
		return Mem_District;
	}

	public void setMem_District(String mem_District) {
		Mem_District = mem_District;
	}

	public int getCount_Misorpostol() {
		return Count_Misorpostol;
	}

	public void setCount_Misorpostol(int count_Misorpostol) {
		Count_Misorpostol = count_Misorpostol;
	}

	public int getMember_Age() {
		return Member_Age;
	}

	public void setMember_Age(int member_Age) {
		Member_Age = member_Age;
	}

	public String getExisting_Final_Vill() {
		return existing_Final_Vill;
	}

	public void setexisting_Final_Vill(String existing_Final_Vill) {
		this.existing_Final_Vill = existing_Final_Vill;
	}

	public String getExisting_Subunit() {
		return existing_Subunit;
	}

	public void setexisting_Subunit(String existing_Subunit) {
		this.existing_Subunit = existing_Subunit;
	}

	public long getClientVersion() {
		return clientVersion;
	}

	public void setclientVersion(long clientVersion) {
		this.clientVersion = clientVersion;
	}

	public String getAdd_child() {
		return add_child;
	}

	public void setadd_child(String add_child) {
		this.add_child = add_child;
	}

	public String getMem_Mauzapara() {
		return Mem_Mauzapara;
	}

	public void setMem_Mauzapara(String mem_Mauzapara) {
		Mem_Mauzapara = mem_Mauzapara;
	}

	public String getConfirm_Info() {
		return Confirm_Info;
	}

	public void setConfirm_Info(String confirm_Info) {
		Confirm_Info = confirm_Info;
	}

	public int getVisit_Status() {
		return Visit_Status;
	}

	public void setVisit_Status(int visit_Status) {
		Visit_Status = visit_Status;
	}

	public int getMisoprostol_Received() {
		return Misoprostol_Received;
	}

	public void setMisoprostol_Received(int misoprostol_Received) {
		Misoprostol_Received = misoprostol_Received;
	}

	public String getMem_Ward() {
		return Mem_Ward;
	}

	public void setMem_Ward(String mem_Ward) {
		Mem_Ward = mem_Ward;
	}

	public int getWhere_Delivered() {
		return Where_Delivered;
	}

	public void setWhere_Delivered(int where_Delivered) {
		Where_Delivered = where_Delivered;
	}

	public String getMem_Union() {
		return Mem_Union;
	}

	public void setMem_Union(String mem_Union) {
		Mem_Union = mem_Union;
	}

	public long getServerVersion() {
		return serverVersion;
	}

	public void setserverVersion(long serverVersion) {
		this.serverVersion = serverVersion;
	}

	public String getExisting_GPS() {
		return existing_GPS;
	}

	public void setexisting_GPS(String existing_GPS) {
		this.existing_GPS = existing_GPS;
	}

	public String getDelivery_Type() {
		return Delivery_Type;
	}

	public void setDelivery_Type(String delivery_Type) {
		Delivery_Type = delivery_Type;
	}

	public String getExisting_EDD() {
		return existing_EDD;
	}

	public void setexisting_EDD(String existing_EDD) {
		this.existing_EDD = existing_EDD;
	}

	public Date getReceived_Time() {
		return Received_Time;
	}

	public void setReceived_Time(Date received_Time) {
		Received_Time = received_Time;
	}

	public String getExisting_Ward() {
		return existing_Ward;
	}

	public void setexisting_Ward(String existing_Ward) {
		this.existing_Ward = existing_Ward;
	}

	public String getExisting_Country() {
		return existing_Country;
	}

	public void setexisting_Country(String existing_Country) {
		this.existing_Country = existing_Country;
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

	public String getDOO() {
		return DOO;
	}

	public void setDOO(String dOO) {
		DOO = dOO;
	}

	@Temporal(TemporalType.DATE)
	public Date getToday() {
		return Today;
	}

	public void setToday(Date today) {
		Today = today;
	}

	public int getExisting_TT_Count() {
		return existing_TT_Count;
	}

	public void setexisting_TT_Count(int existing_TT_Count) {
		this.existing_TT_Count = existing_TT_Count;
	}

	public int getChild_Weight() {
		return Child_Weight;
	}

	public void setChild_Weight(int child_Weight) {
		Child_Weight = child_Weight;
	}

	public String getRelationalid() {
		return relationalid;
	}

	public void setrelationalid(String relationalid) {
		this.relationalid = relationalid;
	}

	public String getExisting_GoB_HHID() {
		return existing_GoB_HHID;
	}

	public void setexisting_GoB_HHID(String existing_GoB_HHID) {
		this.existing_GoB_HHID = existing_GoB_HHID;
	}

	public String getMem_GPS() {
		return Mem_GPS;
	}

	public void setMem_GPS(String mem_GPS) {
		Mem_GPS = mem_GPS;
	}

	public int getExisting_Couple_No() {
		return existing_Couple_No;
	}

	public void setexisting_Couple_No(int existing_Couple_No) {
		this.existing_Couple_No = existing_Couple_No;
	}

	public String getMem_Division() {
		return Mem_Division;
	}

	public void setMem_Division(String mem_Division) {
		Mem_Division = mem_Division;
	}

	public String getChild_Vital_Status() {
		return Child_Vital_Status;
	}

	public void setChild_Vital_Status(String child_Vital_Status) {
		Child_Vital_Status = child_Vital_Status;
	}

	public String getName_Check() {
		return Name_Check;
	}

	public void setName_Check(String name_Check) {
		Name_Check = name_Check;
	}

	public String getExisting_Spouse_Name() {
		return existing_Spouse_Name;
	}

	public void setexisting_Spouse_Name(String existing_Spouse_Name) {
		this.existing_Spouse_Name = existing_Spouse_Name;
	}

	public String getMem_L_Name() {
		return Mem_L_Name;
	}

	public void setMem_L_Name(String mem_L_Name) {
		Mem_L_Name = mem_L_Name;
	}

	@Temporal(TemporalType.DATE)
	public Date getMember_Reg_Date() {
		return Member_Reg_Date;
	}

	public void setMember_Reg_Date(Date member_Reg_Date) {
		Member_Reg_Date = member_Reg_Date;
	}

	public String getExisting_Height() {
		return existing_Height;
	}

	public void setexisting_Height(String existing_Height) {
		this.existing_Height = existing_Height;
	}

	public long getVersion() {
		return version;
	}

	public void setversion(long version) {
		this.version = version;
	}

	public String getBnf_current_formStatus() {
		return bnf_current_formStatus;
	}

	public void setbnf_current_formStatus(String bnf_current_formStatus) {
		this.bnf_current_formStatus = bnf_current_formStatus;
	}

	public long getMem_BRID() {
		return Mem_BRID;
	}

	public void setMem_BRID(long mem_BRID) {
		Mem_BRID = mem_BRID;
	}

	public String getExisting_Union() {
		return existing_Union;
	}

	public void setexisting_Union(String existing_Union) {
		this.existing_Union = existing_Union;
	}

	public long getMember_GoB_HHID() {
		return Member_GoB_HHID;
	}

	public void setMember_GoB_HHID(long member_GoB_HHID) {
		Member_GoB_HHID = member_GoB_HHID;
	}

	public String getExisting_Mem_F_Name() {
		return existing_Mem_F_Name;
	}

	public void setexisting_Mem_F_Name(String existing_Mem_F_Name) {
		this.existing_Mem_F_Name = existing_Mem_F_Name;
	}

	public String getChild_Mother() {
		return Child_Mother;
	}

	public void setChild_Mother(String child_Mother) {
		Child_Mother = child_Mother;
	}

	public String getMem_Village_Name() {
		return Mem_Village_Name;
	}

	public void setMem_Village_Name(String mem_Village_Name) {
		Mem_Village_Name = mem_Village_Name;
	}

	public String getNote() {
		return note;
	}

	public void setnote(String note) {
		this.note = note;
	}

	public String getChild_Father() {
		return Child_Father;
	}

	public void setChild_Father(String child_Father) {
		Child_Father = child_Father;
	}

	public String getMem_Subunit() {
		return Mem_Subunit;
	}

	public void setMem_Subunit(String mem_Subunit) {
		Mem_Subunit = mem_Subunit;
	}

	public String getMem_Country() {
		return Mem_Country;
	}

	public void setMem_Country(String mem_Country) {
		Mem_Country = mem_Country;
	}

	public String getMember_Gender() {
		return Member_Gender;
	}

	public void setMember_Gender(String member_Gender) {
		Member_Gender = member_Gender;
	}

	public String getExisting_HoH_F_Name() {
		return existing_HoH_F_Name;
	}

	public void setexisting_HoH_F_Name(String existing_HoH_F_Name) {
		this.existing_HoH_F_Name = existing_HoH_F_Name;
	}

	public long getRetype_Mem_BRID() {
		return Retype_Mem_BRID;
	}

	public void setRetype_Mem_BRID(long retype_Mem_BRID) {
		Retype_Mem_BRID = retype_Mem_BRID;
	}

	public String getExisting_Division() {
		return existing_Division;
	}

	public void setexisting_Division(String existing_Division) {
		this.existing_Division = existing_Division;
	}

	public String getMem_BRID_Concept() {
		return Mem_BRID_Concept;
	}

	public void setMem_BRID_Concept(String mem_BRID_Concept) {
		Mem_BRID_Concept = mem_BRID_Concept;
	}

	public int getWho_Delivered() {
		return Who_Delivered;
	}

	public void setWho_Delivered(int who_Delivered) {
		Who_Delivered = who_Delivered;
	}

	public long getMem_Mobile_Number() {
		return Mem_Mobile_Number;
	}

	public void setMem_Mobile_Number(long mem_Mobile_Number) {
		Mem_Mobile_Number = mem_Mobile_Number;
	}

	public int getCalc_Age() {
		return Calc_Age;
	}

	public void setCalc_Age(int calc_Age) {
		Calc_Age = calc_Age;
	}

	public String getReg_Newborn() {
		return Reg_Newborn;
	}

	public void setReg_Newborn(String reg_Newborn) {
		Reg_Newborn = reg_Newborn;
	}

	@Temporal(TemporalType.DATE)
	public Date getVisit_Date() {
		return Visit_Date;
	}

	public void setVisit_Date(Date visit_Date) {
		Visit_Date = visit_Date;
	}

	@Temporal(TemporalType.DATE)
	public Date getMember_Birth_Date() {
		return Member_Birth_Date;
	}

	public void setMember_Birth_Date(Date member_Birth_Date) {
		Member_Birth_Date = member_Birth_Date;
	}

	public String getExisting_Upazilla() {
		return existing_Upazilla;
	}

	public void setexisting_Upazilla(String existing_Upazilla) {
		this.existing_Upazilla = existing_Upazilla;
	}

	public String getChild_Name() {
		return Child_Name;
	}

	public void setChild_Name(String child_Name) {
		Child_Name = child_Name;
	}

	public int getNum_Live_Birth() {
		return Num_Live_Birth;
	}

	public void setNum_Live_Birth(int num_Live_Birth) {
		Num_Live_Birth = num_Live_Birth;
	}

	public String getChanges() {
		return changes;
	}

	public void setchanges(String changes) {
		this.changes = changes;
	}
}