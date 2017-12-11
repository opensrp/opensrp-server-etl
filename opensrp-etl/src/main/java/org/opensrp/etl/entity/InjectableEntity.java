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
@Table(name = "injectable")
public class InjectableEntity {

	private static final InjectableEntity INSTANCE = new InjectableEntity();

	private InjectableEntity() {
		// TODO Auto-generated constructor stub
	}

	public static InjectableEntity getInstance() {
		return INSTANCE;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "injectable_id_seq")
	@SequenceGenerator(name = "injectable_id_seq", sequenceName = "injectable_id_seq", allocationSize = 1)

	private long id;

	private Long clientVersion;

	private Long serverVersion;

	private Long version;

	@Column(name="end_time")
	private Date end;

	private Date start;

	@Temporal(TemporalType.DATE)
	private Date Today;
	
	private String changes;
	
	private String Visit_Status;

	private Integer existing_Dose_No;

	private Integer Todays_Dose_No;

	private Integer Side_Effects;

	private Integer Is_Due;

	private Integer Is_Post_Due;
	
	private Long existing_Mem_NID;
	
	private Long existing_ELCO_Mobile_Number;

	private Long existing_Mem_BRID;

	@Temporal(TemporalType.DATE)
	private Date Visit_Date;

	@Temporal(TemporalType.DATE)
	private Date injectable_Today;

	private Date received_time;

	@Temporal(TemporalType.DATE)
	private Date Injection_Date;

	@Temporal(TemporalType.DATE)
	private Date Next_Injection_Date;

	@Temporal(TemporalType.DATE)
	private Date Format_Next_Injection_Date;

	@Temporal(TemporalType.DATE)
	private Date existing_Injection_Date;

	private String existing_TT_Count;
	
	private String existing_location;

	private String existing_District;
	
	private String existing_GPS;

	private String existing_Ward;

	private String existing_Country;

	private String existing_Mauzapara;

	private String existing_Final_Vill;

	private String existing_Subunit;

	private String existing_GoB_HHID;

	private String existing_Couple_No;

	private String existing_HoH_F_Name;

	private String existing_Division;

	private String existing_Upazilla;
	
	private String existing_Spouse_Name;

	private String existing_Union;

	private String existing_Mem_F_Name;

	private String Previoud_Dose_Inject;

	private String Woman_Met;

	private String Confirm_Info;

	private String injectable_current_formStatus;

	private String Note_SE1;

	private String Note_SE2;

	private String Note_SE3;

	private String Note_SE4;
	
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

	public Long getVersion() {
		return version;
	}

	public void setversion(Long version) {
		this.version = version;
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

	@Temporal(TemporalType.DATE)
	public Date getInjectable_Today() {
		return injectable_Today;
	}

	public void setinjectable_Today(Date injectable_Today) {
		this.injectable_Today = injectable_Today;
	}

	public Date getReceived_time() {
		return received_time;
	}

	public void setreceived_time(Date received_time) {
		this.received_time = received_time;
	}

	@Temporal(TemporalType.DATE)
	public Date getInjection_Date() {
		return Injection_Date;
	}

	public void setInjection_Date(Date injection_Date) {
		Injection_Date = injection_Date;
	}

	@Temporal(TemporalType.DATE)
	public Date getNext_Injection_Date() {
		return Next_Injection_Date;
	}

	public void setNext_Injection_Date(Date next_Injection_Date) {
		Next_Injection_Date = next_Injection_Date;
	}

	@Temporal(TemporalType.DATE)
	public Date getFormat_Next_Injection_Date() {
		return Format_Next_Injection_Date;
	}

	public void setFormat_Next_Injection_Date(Date format_Next_Injection_Date) {
		Format_Next_Injection_Date = format_Next_Injection_Date;
	}

	@Temporal(TemporalType.DATE)
	public Date getExisting_Injection_Date() {
		return existing_Injection_Date;
	}

	public void setexisting_Injection_Date(Date existing_Injection_Date) {
		this.existing_Injection_Date = existing_Injection_Date;
	}

	public Integer getExisting_Dose_No() {
		return existing_Dose_No;
	}

	public void setexisting_Dose_No(Integer existing_Dose_No) {
		this.existing_Dose_No = existing_Dose_No;
	}

	public Integer getTodays_Dose_No() {
		return Todays_Dose_No;
	}

	public void setTodays_Dose_No(Integer todays_Dose_No) {
		Todays_Dose_No = todays_Dose_No;
	}

	public Integer getSide_Effects() {
		return Side_Effects;
	}

	public void setSide_Effects(Integer side_Effects) {
		Side_Effects = side_Effects;
	}

	public Integer getIs_Due() {
		return Is_Due;
	}

	public void setIs_Due(Integer is_Due) {
		Is_Due = is_Due;
	}

	public Integer getIs_Post_Due() {
		return Is_Post_Due;
	}

	public void setIs_Post_Due(Integer is_Post_Due) {
		Is_Post_Due = is_Post_Due;
	}

	public Long getExisting_Mem_NID() {
		return existing_Mem_NID;
	}

	public void setexisting_Mem_NID(Long existing_Mem_NID) {
		this.existing_Mem_NID = existing_Mem_NID;
	}

	public Long getExisting_ELCO_Mobile_Number() {
		return existing_ELCO_Mobile_Number;
	}

	public void setexisting_ELCO_Mobile_Number(Long existing_ELCO_Mobile_Number) {
		this.existing_ELCO_Mobile_Number = existing_ELCO_Mobile_Number;
	}

	public Long getExisting_Mem_BRID() {
		return existing_Mem_BRID;
	}

	public void setexisting_Mem_BRID(Long existing_Mem_BRID) {
		this.existing_Mem_BRID = existing_Mem_BRID;
	}

	public String getExisting_TT_Count() {
		return existing_TT_Count;
	}

	public void setexisting_TT_Count(String existing_TT_Count) {
		this.existing_TT_Count = existing_TT_Count;
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

	public String getExisting_GPS() {
		return existing_GPS;
	}

	public void setexisting_GPS(String existing_GPS) {
		this.existing_GPS = existing_GPS;
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

	public String getExisting_GoB_HHID() {
		return existing_GoB_HHID;
	}

	public void setexisting_GoB_HHID(String existing_GoB_HHID) {
		this.existing_GoB_HHID = existing_GoB_HHID;
	}

	public String getExisting_Couple_No() {
		return existing_Couple_No;
	}

	public void setexisting_Couple_No(String existing_Couple_No) {
		this.existing_Couple_No = existing_Couple_No;
	}

	public String getExisting_HoH_F_Name() {
		return existing_HoH_F_Name;
	}

	public void setexisting_HoH_F_Name(String existing_HoH_F_Name) {
		this.existing_HoH_F_Name = existing_HoH_F_Name;
	}

	public String getExisting_Division() {
		return existing_Division;
	}

	public void setexisting_Division(String existing_Division) {
		this.existing_Division = existing_Division;
	}

	public String getExisting_Upazilla() {
		return existing_Upazilla;
	}

	public void setexisting_Upazilla(String existing_Upazilla) {
		this.existing_Upazilla = existing_Upazilla;
	}

	public String getExisting_Spouse_Name() {
		return existing_Spouse_Name;
	}

	public void setexisting_Spouse_Name(String existing_Spouse_Name) {
		this.existing_Spouse_Name = existing_Spouse_Name;
	}

	public String getExisting_Union() {
		return existing_Union;
	}

	public void setexisting_Union(String existing_Union) {
		this.existing_Union = existing_Union;
	}

	public String getExisting_Mem_F_Name() {
		return existing_Mem_F_Name;
	}

	public void setexisting_Mem_F_Name(String existing_Mem_F_Name) {
		this.existing_Mem_F_Name = existing_Mem_F_Name;
	}

	public String getPrevioud_Dose_Inject() {
		return Previoud_Dose_Inject;
	}

	public void setPrevioud_Dose_Inject(String previoud_Dose_Inject) {
		Previoud_Dose_Inject = previoud_Dose_Inject;
	}

	public String getWoman_Met() {
		return Woman_Met;
	}

	public void setWoman_Met(String woman_Met) {
		Woman_Met = woman_Met;
	}

	public String getConfirm_Info() {
		return Confirm_Info;
	}

	public void setConfirm_Info(String confirm_Info) {
		Confirm_Info = confirm_Info;
	}

	public String getInjectable_current_formStatus() {
		return injectable_current_formStatus;
	}

	public void setinjectable_current_formStatus(
			String injectable_current_formStatus) {
		this.injectable_current_formStatus = injectable_current_formStatus;
	}

	public String getNote_SE1() {
		return Note_SE1;
	}

	public void setNote_SE1(String note_SE1) {
		Note_SE1 = note_SE1;
	}

	public String getNote_SE2() {
		return Note_SE2;
	}

	public void setNote_SE2(String note_SE2) {
		Note_SE2 = note_SE2;
	}

	public String getNote_SE3() {
		return Note_SE3;
	}

	public void setNote_SE3(String note_SE3) {
		Note_SE3 = note_SE3;
	}

	public String getNote_SE4() {
		return Note_SE4;
	}

	public void setNote_SE4(String note_SE4) {
		Note_SE4 = note_SE4;
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
}
