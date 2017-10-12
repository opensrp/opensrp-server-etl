package org.opensrp.etl.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int id;
	
	private long timeStamp;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mother_id", referencedColumnName = "id")
	private MotherEntity mother;
	
	@Temporal(TemporalType.DATE)
	private Date FWBNFDATE;
	
	private String bnf_current_formStatus;
	
	private String provider;
	
	private String FWCONFIRMATION;
	
	private String FWGESTATIONALAGE;
	
	//@Temporal(TemporalType.DATE)
	private String FWEDD;
	
	private String FWBNFSTS;
	
	private String FWDISPLAYTEXT;
	
	private String FWBNFWOMVITSTS;
	
	@Temporal(TemporalType.DATE)
	private Date FWBNFDTOO;
	
	private String FWBNFLB;
	
	private String FWBNFSMSRSN;
	
	private String user_type;
	
	private String external_user_ID;
	
	private Date received_time;
	
	private long clientVersion;
	
	private String relationalId;//mother id
	
	private Date start;
	
	@Column(name = "end_time")
	private Date end;
	
	@Temporal(TemporalType.DATE)
	private Date today;
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public Date getStart() {
		return start;
	}
	
	public void setStart(Date start) {
		this.start = start;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public Date getToday() {
		return today;
	}
	
	public void setToday(Date today) {
		this.today = today;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public MotherEntity getMother() {
		return mother;
	}
	
	public void setMother(MotherEntity mother) {
		this.mother = mother;
	}
	
	public Date getFWBNFDATE() {
		return FWBNFDATE;
	}
	
	public void setFWBNFDATE(Date fWBNFDATE) {
		FWBNFDATE = fWBNFDATE;
	}
	
	public String getBnf_current_formStatus() {
		return bnf_current_formStatus;
	}
	
	public void setBnf_current_formStatus(String bnf_current_formStatus) {
		this.bnf_current_formStatus = bnf_current_formStatus;
	}
	
	public String getFWCONFIRMATION() {
		return FWCONFIRMATION;
	}
	
	public void setFWCONFIRMATION(String fWCONFIRMATION) {
		FWCONFIRMATION = fWCONFIRMATION;
	}
	
	public String getFWGESTATIONALAGE() {
		return FWGESTATIONALAGE;
	}
	
	public void setFWGESTATIONALAGE(String fWGESTATIONALAGE) {
		FWGESTATIONALAGE = fWGESTATIONALAGE;
	}
	
	public String getFWEDD() {
		return FWEDD;
	}
	
	public void setFWEDD(String fWEDD) {
		FWEDD = fWEDD;
	}
	
	public String getFWBNFSTS() {
		return FWBNFSTS;
	}
	
	public void setFWBNFSTS(String fWBNFSTS) {
		FWBNFSTS = fWBNFSTS;
	}
	
	public String getFWDISPLAYTEXT() {
		return FWDISPLAYTEXT;
	}
	
	public void setFWDISPLAYTEXT(String fWDISPLAYTEXT) {
		FWDISPLAYTEXT = fWDISPLAYTEXT;
	}
	
	public String getFWBNFWOMVITSTS() {
		return FWBNFWOMVITSTS;
	}
	
	public void setFWBNFWOMVITSTS(String fWBNFWOMVITSTS) {
		FWBNFWOMVITSTS = fWBNFWOMVITSTS;
	}
	
	public Date getFWBNFDTOO() {
		return FWBNFDTOO;
	}
	
	public void setFWBNFDTOO(Date fWBNFDTOO) {
		FWBNFDTOO = fWBNFDTOO;
	}
	
	public String getFWBNFLB() {
		return FWBNFLB;
	}
	
	public void setFWBNFLB(String fWBNFLB) {
		FWBNFLB = fWBNFLB;
	}
	
	public String getFWBNFSMSRSN() {
		return FWBNFSMSRSN;
	}
	
	public void setFWBNFSMSRSN(String fWBNFSMSRSN) {
		FWBNFSMSRSN = fWBNFSMSRSN;
	}
	
	public String getUser_type() {
		return user_type;
	}
	
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
	public String getExternal_user_ID() {
		return external_user_ID;
	}
	
	public void setExternal_user_ID(String external_user_ID) {
		this.external_user_ID = external_user_ID;
	}
	
	public Date getReceived_time() {
		return received_time;
	}
	
	public void setReceived_time(Date received_time) {
		this.received_time = received_time;
	}
	
	public long getClientVersion() {
		return clientVersion;
	}
	
	public void setClientVersion(long clientVersion) {
		this.clientVersion = clientVersion;
	}
	
	public String getRelationalId() {
		return relationalId;
	}
	
	public void setRelationalId(String relationalId) {
		this.relationalId = relationalId;
	}
	
}
