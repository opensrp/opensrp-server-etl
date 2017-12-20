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
@Table(name = "psrf")
public class PSRFEntity {
	
	public PSRFEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "psrf_id_seq")
	@SequenceGenerator(name = "psrf_id_seq", sequenceName = "psrf_id_seq", allocationSize = 1)
	private long id;

	@Temporal(TemporalType.DATE)
	private Date today;

	@Column(name="end_time")
	private Date end;

	private Date start;

	private Date Received_Time;

	private Long version;

	private Long clientVersion;

	private Long serverVersion;

	private Integer Visit_Status;

	private Integer Birth_Control;

	private Integer Using_FP;

	private Integer Preg_Status;

    private Integer Total_Child_Alive;

	private Integer Gestational_Age;

	private Integer ELCO_Followup_Logic;

	private Integer Want_Change;

	private Integer Age_Youngest_Child;

	private Integer Married_Life;

	private Integer existing_Couple_No;

	private Integer Mother_Age;

	private Integer Mother_GoB_HHID;

	private Integer TT_Count;

	private Integer TT_Status;

	private Integer Gravida;

	private Integer Risky_Preg;

	private Integer Height;

	private Integer Eligible;

	private Integer Has_Changed;

	private Integer Mother_Valid;

	private Integer ELCO;

	private Integer Not_ELCO;

	private Long existing_ELCO_Mobile_Number;

	private Long Mother_NID;

	private Long existing_ELCO_NID;

	private Date Next_Injection_Date;

    private Date Permanent_M_Date;

	@Temporal(TemporalType.DATE)
	private Date Calc_EDD;

	@Temporal(TemporalType.DATE)
	private Date Mother_LMP;

	@Temporal(TemporalType.DATE)
	private Date Calc_FP_Given_Date;

	@Temporal(TemporalType.DATE)
	private Date Injection_Date;

	@Temporal(TemporalType.DATE)
	private Date Marriage_Date;

	@Temporal(TemporalType.DATE)
	private Date Cond_Given_Date;

	@Temporal(TemporalType.DATE)
	private Date LMP;

	@Temporal(TemporalType.DATE)
	private Date ELCO_Date;

	@Temporal(TemporalType.DATE)
	private Date Pill_Given_Date;

    @Temporal(TemporalType.DATE)
    private Date Format_Cond_Given_Date;

    private Date Format_Pill_Given_Date;

    private Date Format_Injection_Date;

    private Date Format_Permanent_M_Date;

    private String TT_Dose;

    private String Pill_Given_No;

    private String Cond_Given_No;

    private String Is_Eligible_Injectables;

	private String changes;

	private String Want_FP_Commodities;
	
	private String existing_Mem_Marital_Status;

	private String Child_Alive_Boy;

	private String existing_location;

	private String Current_Form_Status;

	private String Refer;

	private String existing_Final_Vill;

	private String yn_dk_label;

	private String Confirm_Info;

	private String Mother_BRID;

	private String Refer_FWV;

	private String Changed_FP_Method;

	private String Mother_Mauzapara;
	
	private String existing_Mauzapara;

	private String Want_To_Use;

	private String Source_BC_Product;
	
	private String existing_Final_Dist;

	private String existing_ELCO;
	
	private String Preg_Note;

	private String Prolong_Delivery;
	
	private String Not_Preg_Note;

	private String Provide_Pills_Condoms;
	
	private String Last_FP_Method;
	
	private String Type_Implant;
	
	private String existing_Calc_Age_Confirm;

	private String Injetable;
	
	private String Select_FP_Method;

	private String Wom_Met;

	private String Heavy_Blood_Flow;
	
	private String Caesarean;
	
	private String Counselling;
	
	private String Mother_Hus_Name;
	
	private String existing_ELCO_BRID;
	
	private String Discuss_With_Fam;
	
	private String PW;
	
	private String Last_Pregnancy;
	
	private String existing_Final_Union;
	
	private String Bleeding;
	
	private String Format_Next_Injection_Date;
	
	private String existing_GoB_HHID;
	
	private String Type_Oral_Pill;
	
	private String existing_Spouse_Name;
	
	private String Eligible_Injectables;
	
	private String Child_Alive_Girl;
	
	private String Birth_Outcome;

	private String Live_Birth;
	
	private String existing_Mem_F_Name;

	private String existing_HoH_F_Name;

	private String Pregnancy_Reg;
	
	private String Dead_Child;

	private String Mother_F_Name;

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

	@Temporal(TemporalType.DATE)
	public Date getCalc_EDD() {
		return Calc_EDD;
	}

	public void setCalc_EDD(Date calc_EDD) {
		Calc_EDD = calc_EDD;
	}

	public String getWant_FP_Commodities() {
		return Want_FP_Commodities;
	}

	public void setWant_FP_Commodities(String want_FP_Commodities) {
		Want_FP_Commodities = want_FP_Commodities;
	}

	public String getExisting_Mem_Marital_Status() {
		return existing_Mem_Marital_Status;
	}

	public void setexisting_Mem_Marital_Status(String existing_Mem_Marital_Status) {
		this.existing_Mem_Marital_Status = existing_Mem_Marital_Status;
	}

	public String getChild_Alive_Boy() {
		return Child_Alive_Boy;
	}

	public void setChild_Alive_Boy(String child_Alive_Boy) {
		Child_Alive_Boy = child_Alive_Boy;
	}

	public String getExisting_location() {
		return existing_location;
	}

	public void setexisting_location(String existing_location) {
		this.existing_location = existing_location;
	}

	public Integer getGestational_Age() {
		return Gestational_Age;
	}

	public void setGestational_Age(Integer gestational_Age) {
		Gestational_Age = gestational_Age;
	}

	public String getCurrent_Form_Status() {
		return Current_Form_Status;
	}

	public void setCurrent_Form_Status(String current_Form_Status) {
		Current_Form_Status = current_Form_Status;
	}

	public Integer getELCO_Followup_Logic() {
		return ELCO_Followup_Logic;
	}

	public void setELCO_Followup_Logic(Integer eLCO_Followup_Logic) {
		ELCO_Followup_Logic = eLCO_Followup_Logic;
	}

	public String getRefer() {
		return Refer;
	}

	public void setRefer(String refer) {
		Refer = refer;
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

	public String getYn_dk_label() {
		return yn_dk_label;
	}

	public void setyn_dk_label(String yn_dk_label) {
		this.yn_dk_label = yn_dk_label;
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

	public String getMother_BRID() {
		return Mother_BRID;
	}

	public void setMother_BRID(String mother_BRID) {
		Mother_BRID = mother_BRID;
	}

	public Integer getWant_Change() {
		return Want_Change;
	}

	public void setWant_Change(Integer want_Change) {
		Want_Change = want_Change;
	}

	public Integer getAge_Youngest_Child() {
		return Age_Youngest_Child;
	}

	public void setAge_Youngest_Child(Integer age_Youngest_Child) {
		Age_Youngest_Child = age_Youngest_Child;
	}

	public String getRefer_FWV() {
		return Refer_FWV;
	}

	public void setRefer_FWV(String refer_FWV) {
		Refer_FWV = refer_FWV;
	}

	public String getChanged_FP_Method() {
		return Changed_FP_Method;
	}

	public void setChanged_FP_Method(String changed_FP_Method) {
		Changed_FP_Method = changed_FP_Method;
	}

	@Temporal(TemporalType.DATE)
	public Date getCalc_FP_Given_Date() {
		return Calc_FP_Given_Date;
	}

	public void setCalc_FP_Given_Date(Date calc_FP_Given_Date) {
		Calc_FP_Given_Date = calc_FP_Given_Date;
	}

	public Integer getTotal_Child_Alive() {
		return Total_Child_Alive;
	}

	public void setTotal_Child_Alive(Integer total_Child_Alive) {
		Total_Child_Alive = total_Child_Alive;
	}

	public String getMother_Mauzapara() {
		return Mother_Mauzapara;
	}

	public void setMother_Mauzapara(String mother_Mauzapara) {
		Mother_Mauzapara = mother_Mauzapara;
	}

	public Date getReceived_Time() {
		return Received_Time;
	}

	public void setReceived_Time(Date received_Time) {
		Received_Time = received_Time;
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
	
	public String getWant_To_Use() {
		return Want_To_Use;
	}

	public void setWant_To_Use(String want_To_Use) {
		Want_To_Use = want_To_Use;
	}

	public Integer getMarried_Life() {
		return Married_Life;
	}

	public void setMarried_Life(Integer married_Life) {
		Married_Life = married_Life;
	}

	public Date getFormat_Injection_Date() {
		return Format_Injection_Date;
	}

	public void setFormat_Injection_Date(Date format_Injection_Date) {
		Format_Injection_Date = format_Injection_Date;
	}

	public Integer getExisting_Couple_No() {
		return existing_Couple_No;
	}

	public void setexisting_Couple_No(Integer existing_Couple_No) {
		this.existing_Couple_No = existing_Couple_No;
	}

	public String getSource_BC_Product() {
		return Source_BC_Product;
	}

	public void setSource_BC_Product(String source_BC_Product) {
		Source_BC_Product = source_BC_Product;
	}

	public Integer getMother_Age() {
		return Mother_Age;
	}

	public void setMother_Age(Integer mother_Age) {
		Mother_Age = mother_Age;
	}

	public String getExisting_Final_Dist() {
		return existing_Final_Dist;
	}

	public void setexisting_Final_Dist(String existing_Final_Dist) {
		this.existing_Final_Dist = existing_Final_Dist;
	}

	public Integer getMother_GoB_HHID() {
		return Mother_GoB_HHID;
	}

	public void setMother_GoB_HHID(Integer mother_GoB_HHID) {
		Mother_GoB_HHID = mother_GoB_HHID;
	}

	public Integer getTT_Count() {
		return TT_Count;
	}

	public void setTT_Count(Integer tT_Count) {
		TT_Count = tT_Count;
	}

	@Temporal(TemporalType.DATE)
	public Date getMother_LMP() {
		return Mother_LMP;
	}

	public void setMother_LMP(Date mother_LMP) {
		Mother_LMP = mother_LMP;
	}

	public Integer getTT_Status() {
		return TT_Status;
	}

	public void setTT_Status(Integer tT_Status) {
		TT_Status = tT_Status;
	}

	public String getExisting_ELCO() {
		return existing_ELCO;
	}

	public void setexisting_ELCO(String existing_ELCO) {
		this.existing_ELCO = existing_ELCO;
	}

	public String getPreg_Note() {
		return Preg_Note;
	}

	public void setPreg_Note(String preg_Note) {
		Preg_Note = preg_Note;
	}

	public Integer getELCO() {
		return ELCO;
	}

	public void setELCO(Integer eLCO) {
		ELCO = eLCO;
	}

	public Long getVersion() {
		return version;
	}

	public void setversion(Long version) {
		this.version = version;
	}

	public String getTT_Dose() {
		return TT_Dose;
	}

	public void setTT_Dose(String tT_Dose) {
		TT_Dose = tT_Dose;
	}

	public String getProlong_Delivery() {
		return Prolong_Delivery;
	}

	public void setProlong_Delivery(String prolong_Delivery) {
		Prolong_Delivery = prolong_Delivery;
	}

	public Date getPermanent_M_Date() {
		return Permanent_M_Date;
	}

	public void setPermanent_M_Date(Date permanent_M_Date) {
		Permanent_M_Date = permanent_M_Date;
	}

	public Long getExisting_ELCO_NID() {
		return existing_ELCO_NID;
	}

	public void setexisting_ELCO_NID(Long existing_ELCO_NID) {
		this.existing_ELCO_NID = existing_ELCO_NID;
	}

	public String getNot_Preg_Note() {
		return Not_Preg_Note;
	}

	public void setNot_Preg_Note(String not_Preg_Note) {
		Not_Preg_Note = not_Preg_Note;
	}

	public Date getEnd() {
		return end;
	}

	public void setend(Date end) {
		this.end = end;
	}

	public String getProvide_Pills_Condoms() {
		return Provide_Pills_Condoms;
	}

	public void setProvide_Pills_Condoms(String provide_Pills_Condoms) {
		Provide_Pills_Condoms = provide_Pills_Condoms;
	}

	public Integer getGravida() {
		return Gravida;
	}

	public void setGravida(Integer gravida) {
		Gravida = gravida;
	}

	public String getPill_Given_No() {
		return Pill_Given_No;
	}

	public void setPill_Given_No(String pill_Given_No) {
		Pill_Given_No = pill_Given_No;
	}

	public String getLast_FP_Method() {
		return Last_FP_Method;
	}

	public void setLast_FP_Method(String last_FP_Method) {
		Last_FP_Method = last_FP_Method;
	}

	public Date getFormat_Permanent_M_Date() {
		return Format_Permanent_M_Date;
	}

	public void setFormat_Permanent_M_Date(Date format_Permanent_M_Date) {
		Format_Permanent_M_Date = format_Permanent_M_Date;
	}

	public String getType_Implant() {
		return Type_Implant;
	}

	public void setType_Implant(String type_Implant) {
		Type_Implant = type_Implant;
	}

	public String getExisting_Calc_Age_Confirm() {
		return existing_Calc_Age_Confirm;
	}

	public void setexisting_Calc_Age_Confirm(String existing_Calc_Age_Confirm) {
		this.existing_Calc_Age_Confirm = existing_Calc_Age_Confirm;
	}

	public Date getNext_Injection_Date() {
		return Next_Injection_Date;
	}

	public void setNext_Injection_Date(Date next_Injection_Date) {
		Next_Injection_Date = next_Injection_Date;
	}

	public Date getFormat_Pill_Given_Date() {
		return Format_Pill_Given_Date;
	}

	public void setFormat_Pill_Given_Date(Date format_Pill_Given_Date) {
		Format_Pill_Given_Date = format_Pill_Given_Date;
	}

	@Temporal(TemporalType.DATE)
	public Date getInjection_Date() {
		return Injection_Date;
	}

	public void setInjection_Date(Date injection_Date) {
		Injection_Date = injection_Date;
	}

	@Temporal(TemporalType.DATE)
	public Date getMarriage_Date() {
		return Marriage_Date;
	}

	public void setMarriage_Date(Date marriage_Date) {
		Marriage_Date = marriage_Date;
	}

	public Long getExisting_ELCO_Mobile_Number() {
		return existing_ELCO_Mobile_Number;
	}

	public void setexisting_ELCO_Mobile_Number(Long existing_ELCO_Mobile_Number) {
		this.existing_ELCO_Mobile_Number = existing_ELCO_Mobile_Number;
	}

	public String getIs_Eligible_Injectables() {
		return Is_Eligible_Injectables;
	}

	public void setIs_Eligible_Injectables(String is_Eligible_Injectables) {
		Is_Eligible_Injectables = is_Eligible_Injectables;
	}

	public String getInjetable() {
		return Injetable;
	}

	public void setInjetable(String injetable) {
		Injetable = injetable;
	}

	public String getSelect_FP_Method() {
		return Select_FP_Method;
	}

	public void setSelect_FP_Method(String select_FP_Method) {
		Select_FP_Method = select_FP_Method;
	}

	public Integer getBirth_Control() {
		return Birth_Control;
	}

	public void setBirth_Control(Integer birth_Control) {
		Birth_Control = birth_Control;
	}

	public String getWom_Met() {
		return Wom_Met;
	}

	public void setWom_Met(String wom_Met) {
		Wom_Met = wom_Met;
	}

	public String getCond_Given_No() {
		return Cond_Given_No;
	}

	public void setCond_Given_No(String cond_Given_No) {
		Cond_Given_No = cond_Given_No;
	}

	@Temporal(TemporalType.DATE)
	public Date getPill_Given_Date() {
		return Pill_Given_Date;
	}

	public void setPill_Given_Date(Date pill_Given_Date) {
		Pill_Given_Date = pill_Given_Date;
	}

	public String getHeavy_Blood_Flow() {
		return Heavy_Blood_Flow;
	}

	public void setHeavy_Blood_Flow(String heavy_Blood_Flow) {
		Heavy_Blood_Flow = heavy_Blood_Flow;
	}

	public Integer getRisky_Preg() {
		return Risky_Preg;
	}

	public void setRisky_Preg(Integer risky_Preg) {
		Risky_Preg = risky_Preg;
	}

	public String getCaesarean() {
		return Caesarean;
	}

	public void setCaesarean(String caesarean) {
		Caesarean = caesarean;
	}

	public String getCounselling() {
		return Counselling;
	}

	public void setCounselling(String counselling) {
		Counselling = counselling;
	}

	public String getMother_Hus_Name() {
		return Mother_Hus_Name;
	}

	public void setMother_Hus_Name(String mother_Hus_Name) {
		Mother_Hus_Name = mother_Hus_Name;
	}

	public Long getServerVersion() {
		return serverVersion;
	}

	public void setserverVersion(Long serverVersion) {
		this.serverVersion = serverVersion;
	}

	public Integer getHeight() {
		return Height;
	}

	public void setHeight(Integer height) {
		Height = height;
	}

	public String getExisting_ELCO_BRID() {
		return existing_ELCO_BRID;
	}

	public void setexisting_ELCO_BRID(String existing_ELCO_BRID) {
		this.existing_ELCO_BRID = existing_ELCO_BRID;
	}

	public String getDiscuss_With_Fam() {
		return Discuss_With_Fam;
	}

	public void setDiscuss_With_Fam(String discuss_With_Fam) {
		Discuss_With_Fam = discuss_With_Fam;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getLast_Pregnancy() {
		return Last_Pregnancy;
	}

	public void setLast_Pregnancy(String last_Pregnancy) {
		Last_Pregnancy = last_Pregnancy;
	}

	@Temporal(TemporalType.DATE)
	public Date getToday() {
		return today;
	}

	public void settoday(Date today) {
		this.today = today;
	}

	public String getExisting_Final_Union() {
		return existing_Final_Union;
	}

	public void setexisting_Final_Union(String existing_Final_Union) {
		this.existing_Final_Union = existing_Final_Union;
	}

	public String getBleeding() {
		return Bleeding;
	}

	public void setBleeding(String bleeding) {
		Bleeding = bleeding;
	}

	public String getFormat_Next_Injection_Date() {
		return Format_Next_Injection_Date;
	}

	public void setFormat_Next_Injection_Date(String format_Next_Injection_Date) {
		Format_Next_Injection_Date = format_Next_Injection_Date;
	}

	public String getExisting_GoB_HHID() {
		return existing_GoB_HHID;
	}

	public void setexisting_GoB_HHID(String existing_GoB_HHID) {
		this.existing_GoB_HHID = existing_GoB_HHID;
	}

	@Temporal(TemporalType.DATE)
	public Date getFormat_Cond_Given_Date() {
		return Format_Cond_Given_Date;
	}

	public void setFormat_Cond_Given_Date(Date format_Cond_Given_Date) {
		Format_Cond_Given_Date = format_Cond_Given_Date;
	}

	public String getType_Oral_Pill() {
		return Type_Oral_Pill;
	}

	public void setType_Oral_Pill(String type_Oral_Pill) {
		Type_Oral_Pill = type_Oral_Pill;
	}

	public Integer getUsing_FP() {
		return Using_FP;
	}

	public void setUsing_FP(Integer using_FP) {
		Using_FP = using_FP;
	}

	public Integer getHas_Changed() {
		return Has_Changed;
	}

	public void setHas_Changed(Integer has_Changed) {
		Has_Changed = has_Changed;
	}

	@Temporal(TemporalType.DATE)
	public Date getELCO_Date() {
		return ELCO_Date;
	}

	public void setELCO_Date(Date eLCO_Date) {
		ELCO_Date = eLCO_Date;
	}

	public String getExisting_Spouse_Name() {
		return existing_Spouse_Name;
	}

	public void setexisting_Spouse_Name(String existing_Spouse_Name) {
		this.existing_Spouse_Name = existing_Spouse_Name;
	}

	public String getEligible_Injectables() {
		return Eligible_Injectables;
	}

	public void setEligible_Injectables(String eligible_Injectables) {
		Eligible_Injectables = eligible_Injectables;
	}

	public String getChild_Alive_Girl() {
		return Child_Alive_Girl;
	}

	public void setChild_Alive_Girl(String child_Alive_Girl) {
		Child_Alive_Girl = child_Alive_Girl;
	}

	public String getBirth_Outcome() {
		return Birth_Outcome;
	}

	public void setBirth_Outcome(String birth_Outcome) {
		Birth_Outcome = birth_Outcome;
	}

	@Temporal(TemporalType.DATE)
	public Date getCond_Given_Date() {
		return Cond_Given_Date;
	}

	public void setCond_Given_Date(Date cond_Given_Date) {
		Cond_Given_Date = cond_Given_Date;
	}

	public Integer getPreg_Status() {
		return Preg_Status;
	}

	public void setPreg_Status(Integer preg_Status) {
		Preg_Status = preg_Status;
	}

	public String getLive_Birth() {
		return Live_Birth;
	}

	public void setLive_Birth(String live_Birth) {
		Live_Birth = live_Birth;
	}

	public String getExisting_Mem_F_Name() {
		return existing_Mem_F_Name;
	}

	public void setexisting_Mem_F_Name(String existing_Mem_F_Name) {
		this.existing_Mem_F_Name = existing_Mem_F_Name;
	}

	public Long getMother_NID() {
		return Mother_NID;
	}

	public void setMother_NID(Long mother_NID) {
		Mother_NID = mother_NID;
	}

	public Integer getEligible() {
		return Eligible;
	}

	public void setEligible(Integer eligible) {
		Eligible = eligible;
	}

	@Temporal(TemporalType.DATE)
	public Date getLMP() {
		return LMP;
	}

	public void setLMP(Date lMP) {
		LMP = lMP;
	}

	public String getExisting_HoH_F_Name() {
		return existing_HoH_F_Name;
	}

	public void setexisting_HoH_F_Name(String existing_HoH_F_Name) {
		this.existing_HoH_F_Name = existing_HoH_F_Name;
	}

	public Integer getMother_Valid() {
		return Mother_Valid;
	}

	public void setMother_Valid(Integer mother_Valid) {
		Mother_Valid = mother_Valid;
	}

	public String getPregnancy_Reg() {
		return Pregnancy_Reg;
	}

	public void setPregnancy_Reg(String pregnancy_Reg) {
		Pregnancy_Reg = pregnancy_Reg;
	}

	public String getDead_Child() {
		return Dead_Child;
	}

	public void setDead_Child(String dead_Child) {
		Dead_Child = dead_Child;
	}

	public String getMother_F_Name() {
		return Mother_F_Name;
	}

	public void setMother_F_Name(String mother_F_Name) {
		Mother_F_Name = mother_F_Name;
	}

	public Integer getNot_ELCO() {
		return Not_ELCO;
	}

	public void setNot_ELCO(Integer not_ELCO) {
		Not_ELCO = not_ELCO;
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

	public void setRelationalid(String relationalid) {
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
	
	@Override
	public String toString() {
		return "PSRFEntity [id=" + id + ", Calc_EDD=" + Calc_EDD
				+ ", Want_FP_Commodities=" + Want_FP_Commodities
				+ ", existing_Mem_Marital_Status="
				+ existing_Mem_Marital_Status + ", Child_Alive_Boy="
				+ Child_Alive_Boy + ", existing_location=" + existing_location
				+ ", Gestational_Age=" + Gestational_Age
				+ ", Current_Form_Status=" + Current_Form_Status
				+ ", ELCO_Followup_Logic=" + ELCO_Followup_Logic + ", Refer="
				+ Refer + ", existing_Final_Vill=" + existing_Final_Vill
				+ ", clientVersion=" + clientVersion + ", yn_dk_label="
				+ yn_dk_label + ", Confirm_Info=" + Confirm_Info
				+ ", Visit_Status=" + Visit_Status + ", Mother_BRID="
				+ Mother_BRID + ", Want_Change=" + Want_Change
				+ ", Age_Youngest_Child=" + Age_Youngest_Child + ", Refer_FWV="
				+ Refer_FWV + ", Changed_FP_Method=" + Changed_FP_Method
				+ ", Calc_FP_Given_Date=" + Calc_FP_Given_Date
				+ ", Total_Child_Alive=" + Total_Child_Alive
				+ ", Mother_Mauzapara=" + Mother_Mauzapara + ", Received_Time="
				+ Received_Time + ", existing_Mauzapara=" + existing_Mauzapara
				+ ", start=" + start + ", Want_To_Use=" + Want_To_Use
				+ ", Married_Life=" + Married_Life + ", Format_Injection_Date="
				+ Format_Injection_Date + ", existing_Couple_No="
				+ existing_Couple_No + ", Source_BC_Product="
				+ Source_BC_Product + ", Mother_Age=" + Mother_Age
				+ ", existing_Final_Dist=" + existing_Final_Dist
				+ ", Mother_GoB_HHID=" + Mother_GoB_HHID + ", TT_Count="
				+ TT_Count + ", Mother_LMP=" + Mother_LMP + ", TT_Status="
				+ TT_Status + ", existing_ELCO=" + existing_ELCO
				+ ", Preg_Note=" + Preg_Note + ", ELCO=" + ELCO + ", version="
				+ version + ", TT_Dose=" + TT_Dose + ", Prolong_Delivery="
				+ Prolong_Delivery + ", Permanent_M_Date=" + Permanent_M_Date
				+ ", existing_ELCO_NID=" + existing_ELCO_NID
				+ ", Not_Preg_Note=" + Not_Preg_Note + ", end=" + end
				+ ", Provide_Pills_Condoms=" + Provide_Pills_Condoms
				+ ", Gravida=" + Gravida + ", Pill_Given_No=" + Pill_Given_No
				+ ", Last_FP_Method=" + Last_FP_Method
				+ ", Format_Permanent_M_Date=" + Format_Permanent_M_Date
				+ ", Type_Implant=" + Type_Implant
				+ ", existing_Calc_Age_Confirm=" + existing_Calc_Age_Confirm
				+ ", Next_Injection_Date=" + Next_Injection_Date
				+ ", Format_Pill_Given_Date=" + Format_Pill_Given_Date
				+ ", Injection_Date=" + Injection_Date + ", Marriage_Date="
				+ Marriage_Date + ", existing_ELCO_Mobile_Number="
				+ existing_ELCO_Mobile_Number + ", Is_Eligible_Injectables="
				+ Is_Eligible_Injectables + ", Injetable=" + Injetable
				+ ", Select_FP_Method=" + Select_FP_Method + ", Birth_Control="
				+ Birth_Control + ", Wom_Met=" + Wom_Met + ", Cond_Given_No="
				+ Cond_Given_No + ", Pill_Given_Date=" + Pill_Given_Date
				+ ", Heavy_Blood_Flow=" + Heavy_Blood_Flow + ", Risky_Preg="
				+ Risky_Preg + ", Caesarean=" + Caesarean + ", Counselling="
				+ Counselling + ", Mother_Hus_Name=" + Mother_Hus_Name
				+ ", serverVersion=" + serverVersion + ", Height=" + Height
				+ ", existing_ELCO_BRID=" + existing_ELCO_BRID
				+ ", Discuss_With_Fam=" + Discuss_With_Fam + ", PW=" + PW
				+ ", Last_Pregnancy=" + Last_Pregnancy + ", today=" + today
				+ ", existing_Final_Union=" + existing_Final_Union
				+ ", Bleeding=" + Bleeding + ", Format_Next_Injection_Date="
				+ Format_Next_Injection_Date + ", existing_GoB_HHID="
				+ existing_GoB_HHID + ", Format_Cond_Given_Date="
				+ Format_Cond_Given_Date + ", Type_Oral_Pill=" + Type_Oral_Pill
				+ ", Using_FP=" + Using_FP + ", Has_Changed=" + Has_Changed
				+ ", ELCO_Date=" + ELCO_Date + ", existing_Spouse_Name="
				+ existing_Spouse_Name + ", Eligible_Injectables="
				+ Eligible_Injectables + ", Child_Alive_Girl="
				+ Child_Alive_Girl + ", Birth_Outcome=" + Birth_Outcome
				+ ", Cond_Given_Date=" + Cond_Given_Date + ", Preg_Status="
				+ Preg_Status + ", Live_Birth=" + Live_Birth
				+ ", existing_Mem_F_Name=" + existing_Mem_F_Name
				+ ", Mother_NID=" + Mother_NID + ", Eligible=" + Eligible
				+ ", LMP=" + LMP + ", existing_HoH_F_Name="
				+ existing_HoH_F_Name + ", Mother_Valid=" + Mother_Valid
				+ ", Pregnancy_Reg=" + Pregnancy_Reg + ", Dead_Child="
				+ Dead_Child + ", Mother_F_Name=" + Mother_F_Name
				+ ", Not_ELCO=" + Not_ELCO + ", changes=" + changes
				+ ", relationalid=" + relationalid + "]";
	}
	
}
