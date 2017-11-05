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
@Table(name = "pnc")
public class PNCEntity {
	
	public PNCEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnc_id_seq")
	@SequenceGenerator(name = "pnc_id_seq", sequenceName = "pnc_id_seq", allocationSize = 1)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date FWPNCDATE;//variable
	
	private String FWCONFIRMATION;
	
	private String FWPNCREMSTS;//variable
	
	private String FWPNCINT;//variable
	
	private String FWPNCKNWPRVDR;//variable
	
	private String FWPNCFVR;//variable
	
	private String FWPNCTEMP;//variable
	
	private String FWPNCDNGRSIGN;//variable
	
	private String FWPNCDELTYPE;
	
	private String FWPNCDELCOMP;//variable
	
	private String FW_GOBHHID;
	
	private String FW_JiVitAHHID;
	
	private String FW_WOMBID;
	
	private String FW_WOMNID;
	
	private String FW_WOMFNAME;
	
	private String FW_HUSNAME;
	
	private String FWBNFDTOO;
	
	private String FWBNFSTS;
	
	private Date start;
	
	@Column(name = "end_time")
	private Date end;
	
	@Temporal(TemporalType.DATE)
	private Date today;
	
	private String pnc_current_formStatus;//variable
	
	private String relationalid;
	
	private String user_type;
	
	private String pncName;
	
	private String received_time;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	private Date updated = new Date();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mother_id", referencedColumnName = "id")
	private MotherEntity mother;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFWPNCDATE() {
		return FWPNCDATE;
	}
	
	public void setFWPNCDATE(Date fWPNCDATE) {
		FWPNCDATE = fWPNCDATE;
	}
	
	public String getFWCONFIRMATION() {
		return FWCONFIRMATION;
	}
	
	public void setFWCONFIRMATION(String fWCONFIRMATION) {
		FWCONFIRMATION = fWCONFIRMATION;
	}
	
	public String getFWPNCREMSTS() {
		return FWPNCREMSTS;
	}
	
	public void setFWPNCREMSTS(String fWPNCREMSTS) {
		FWPNCREMSTS = fWPNCREMSTS;
	}
	
	public String getFWPNCINT() {
		return FWPNCINT;
	}
	
	public void setFWPNCINT(String fWPNCINT) {
		FWPNCINT = fWPNCINT;
	}
	
	public String getFWPNCKNWPRVDR() {
		return FWPNCKNWPRVDR;
	}
	
	public void setFWPNCKNWPRVDR(String fWPNCKNWPRVDR) {
		FWPNCKNWPRVDR = fWPNCKNWPRVDR;
	}
	
	public String getFWPNCFVR() {
		return FWPNCFVR;
	}
	
	public void setFWPNCFVR(String fWPNCFVR) {
		FWPNCFVR = fWPNCFVR;
	}
	
	public String getFWPNCTEMP() {
		return FWPNCTEMP;
	}
	
	public void setFWPNCTEMP(String fWPNCTEMP) {
		FWPNCTEMP = fWPNCTEMP;
	}
	
	public String getFWPNCDNGRSIGN() {
		return FWPNCDNGRSIGN;
	}
	
	public void setFWPNCDNGRSIGN(String fWPNCDNGRSIGN) {
		FWPNCDNGRSIGN = fWPNCDNGRSIGN;
	}
	
	public String getFWPNCDELTYPE() {
		return FWPNCDELTYPE;
	}
	
	public void setFWPNCDELTYPE(String fWPNCDELTYPE) {
		FWPNCDELTYPE = fWPNCDELTYPE;
	}
	
	public String getFWPNCDELCOMP() {
		return FWPNCDELCOMP;
	}
	
	public void setFWPNCDELCOMP(String fWPNCDELCOMP) {
		FWPNCDELCOMP = fWPNCDELCOMP;
	}
	
	public String getFW_GOBHHID() {
		return FW_GOBHHID;
	}
	
	public void setFW_GOBHHID(String fW_GOBHHID) {
		FW_GOBHHID = fW_GOBHHID;
	}
	
	public String getFW_JiVitAHHID() {
		return FW_JiVitAHHID;
	}
	
	public void setFW_JiVitAHHID(String fW_JiVitAHHID) {
		FW_JiVitAHHID = fW_JiVitAHHID;
	}
	
	public String getFW_WOMBID() {
		return FW_WOMBID;
	}
	
	public void setFW_WOMBID(String fW_WOMBID) {
		FW_WOMBID = fW_WOMBID;
	}
	
	public String getFW_WOMNID() {
		return FW_WOMNID;
	}
	
	public void setFW_WOMNID(String fW_WOMNID) {
		FW_WOMNID = fW_WOMNID;
	}
	
	public String getFW_WOMFNAME() {
		return FW_WOMFNAME;
	}
	
	public void setFW_WOMFNAME(String fW_WOMFNAME) {
		FW_WOMFNAME = fW_WOMFNAME;
	}
	
	public String getFW_HUSNAME() {
		return FW_HUSNAME;
	}
	
	public void setFW_HUSNAME(String fW_HUSNAME) {
		FW_HUSNAME = fW_HUSNAME;
	}
	
	public String getFWBNFDTOO() {
		return FWBNFDTOO;
	}
	
	public void setFWBNFDTOO(String fWBNFDTOO) {
		FWBNFDTOO = fWBNFDTOO;
	}
	
	public String getFWBNFSTS() {
		return FWBNFSTS;
	}
	
	public void setFWBNFSTS(String fWBNFSTS) {
		FWBNFSTS = fWBNFSTS;
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
	
	public String getPnc_current_formStatus() {
		return pnc_current_formStatus;
	}
	
	public void setPnc_current_formStatus(String pnc_current_formStatus) {
		this.pnc_current_formStatus = pnc_current_formStatus;
	}
	
	public String getRelationalid() {
		return relationalid;
	}
	
	public void setRelationalid(String relationalid) {
		this.relationalid = relationalid;
	}
	
	public String getUser_type() {
		return user_type;
	}
	
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
	public String getPncName() {
		return pncName;
	}
	
	public void setPncName(String pncName) {
		this.pncName = pncName;
	}
	
	public String getReceived_time() {
		return received_time;
	}
	
	public void setReceived_time(String received_time) {
		this.received_time = received_time;
	}
	
	public Date getToday() {
		return today;
	}
	
	public void setToday(Date today) {
		this.today = today;
	}
	
	public MotherEntity getMother() {
		return mother;
	}
	
	public void setMother(MotherEntity mother) {
		this.mother = mother;
	}
	
}
