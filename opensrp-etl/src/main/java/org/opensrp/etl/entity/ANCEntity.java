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
@Table(name = "anc")
public class ANCEntity {
	
	public ANCEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "anc_id_seq")
	@SequenceGenerator(name = "anc_id_seq", sequenceName = "anc_id_seq", allocationSize = 1)
	private int id;
	
	private String ancName;
	
	@Temporal(TemporalType.DATE)
	private Date FWANCDATE;
	
	private String anc_current_formStatus;
	
	private String FWCONFIRMATION;
	
	private String FWGESTATIONALAGE;
	
	@Temporal(TemporalType.DATE)
	private Date FWEDD;
	
	private String FWANCREMSTS;
	
	private String FWANCINT;
	
	private String FWANCKNWPRVDR;
	
	private String FWANCANM;
	
	private String FWANCHBP;
	
	private String FWANCDBT;
	
	private String FWANCTHY;
	
	private String FWANCPROB;
	
	private String FWANCHEAD;
	
	private String FWBPCLOCOFDEL;
	
	private String FWBPCASSTLAB;
	
	private String FWBPCTRNSPRT;
	
	private String FWBPCBLDGRP;
	
	private String FWBPCBLDDNR;
	
	private String FWBPCFINARGMT;
	
	private String mauza;
	
	private String FWVG;
	
	private String FWHR_PSR;
	
	private String FWHRP;
	
	private String existing_ELCO;
	
	private String FWANCBLRVIS;
	
	private String FWANCSWLNG;
	
	private String FWANCCONVL;
	
	private String FWANCBLD;
	
	private String FWANCDS1;
	
	private String FWANCDS2;
	
	private String FWANCDS3;
	
	private String FWANCDS4;
	
	private String FWANCDS5;
	
	private String FWANCDS6;
	
	private String FWDANGERVALUE;
	
	private String FWNOTELIGIBLE;
	
	private String ELCO;
	
	private String FWHR_ANC;
	
	private String FWFLAGVALUE;
	
	private String FWSORTVALUE;
	
	private String user_type;
	
	private String external_user_ID;
	
	private String relationalid;
	
	private String FW_GOBHHID;
	
	private String FW_JiVitAHHID;
	
	private String FW_WOMBID;
	
	private String FW_WOMNID;
	
	private String FW_WOMFNAME;
	
	private String FW_HUSNAME;
	
	@Temporal(TemporalType.DATE)
	private Date MOTHER_REFERENCE_DATE;
	
	@Temporal(TemporalType.DATE)
	private Date REFERENCE_DATE;
	
	private long clientVersion;
	
	private String received_time;
	
	private long timeStamp;
	
	private Date start;
	
	@Column(name = "end_time")
	private Date end;
	
	@Temporal(TemporalType.DATE)
	private Date today;
	
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
	
	public String getAncName() {
		return ancName;
	}
	
	public void setAncName(String ancName) {
		this.ancName = ancName;
	}
	
	public Date getFWANCDATE() {
		return FWANCDATE;
	}
	
	public void setFWANCDATE(Date fWANCDATE) {
		FWANCDATE = fWANCDATE;
	}
	
	public String getAnc_current_formStatus() {
		return anc_current_formStatus;
	}
	
	public void setAnc_current_formStatus(String anc_current_formStatus) {
		this.anc_current_formStatus = anc_current_formStatus;
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
	
	public Date getFWEDD() {
		return FWEDD;
	}
	
	public void setFWEDD(Date fWEDD) {
		FWEDD = fWEDD;
	}
	
	public String getFWANCREMSTS() {
		return FWANCREMSTS;
	}
	
	public void setFWANCREMSTS(String fWANCREMSTS) {
		FWANCREMSTS = fWANCREMSTS;
	}
	
	public String getFWANCINT() {
		return FWANCINT;
	}
	
	public void setFWANCINT(String fWANCINT) {
		FWANCINT = fWANCINT;
	}
	
	public String getFWANCKNWPRVDR() {
		return FWANCKNWPRVDR;
	}
	
	public void setFWANCKNWPRVDR(String fWANCKNWPRVDR) {
		FWANCKNWPRVDR = fWANCKNWPRVDR;
	}
	
	public String getFWANCANM() {
		return FWANCANM;
	}
	
	public void setFWANCANM(String fWANCANM) {
		FWANCANM = fWANCANM;
	}
	
	public String getFWANCHBP() {
		return FWANCHBP;
	}
	
	public void setFWANCHBP(String fWANCHBP) {
		FWANCHBP = fWANCHBP;
	}
	
	public String getFWANCDBT() {
		return FWANCDBT;
	}
	
	public void setFWANCDBT(String fWANCDBT) {
		FWANCDBT = fWANCDBT;
	}
	
	public String getFWANCTHY() {
		return FWANCTHY;
	}
	
	public void setFWANCTHY(String fWANCTHY) {
		FWANCTHY = fWANCTHY;
	}
	
	public String getFWANCPROB() {
		return FWANCPROB;
	}
	
	public void setFWANCPROB(String fWANCPROB) {
		FWANCPROB = fWANCPROB;
	}
	
	public String getFWANCHEAD() {
		return FWANCHEAD;
	}
	
	public void setFWANCHEAD(String fWANCHEAD) {
		FWANCHEAD = fWANCHEAD;
	}
	
	public String getFWBPCLOCOFDEL() {
		return FWBPCLOCOFDEL;
	}
	
	public void setFWBPCLOCOFDEL(String fWBPCLOCOFDEL) {
		FWBPCLOCOFDEL = fWBPCLOCOFDEL;
	}
	
	public String getFWBPCASSTLAB() {
		return FWBPCASSTLAB;
	}
	
	public void setFWBPCASSTLAB(String fWBPCASSTLAB) {
		FWBPCASSTLAB = fWBPCASSTLAB;
	}
	
	public String getFWBPCTRNSPRT() {
		return FWBPCTRNSPRT;
	}
	
	public void setFWBPCTRNSPRT(String fWBPCTRNSPRT) {
		FWBPCTRNSPRT = fWBPCTRNSPRT;
	}
	
	public String getFWBPCBLDGRP() {
		return FWBPCBLDGRP;
	}
	
	public void setFWBPCBLDGRP(String fWBPCBLDGRP) {
		FWBPCBLDGRP = fWBPCBLDGRP;
	}
	
	public String getFWBPCBLDDNR() {
		return FWBPCBLDDNR;
	}
	
	public void setFWBPCBLDDNR(String fWBPCBLDDNR) {
		FWBPCBLDDNR = fWBPCBLDDNR;
	}
	
	public String getFWBPC1FINARGMT() {
		return FWBPCFINARGMT;
	}
	
	public void setFWBPC1FINARGMT(String fWBPC1FINARGMT) {
		FWBPCFINARGMT = fWBPC1FINARGMT;
	}
	
	public String getMauza() {
		return mauza;
	}
	
	public void setMauza(String mauza) {
		this.mauza = mauza;
	}
	
	public String getFWVG() {
		return FWVG;
	}
	
	public void setFWVG(String fWVG) {
		FWVG = fWVG;
	}
	
	public String getFWHR_PSR() {
		return FWHR_PSR;
	}
	
	public void setFWHR_PSR(String fWHR_PSR) {
		FWHR_PSR = fWHR_PSR;
	}
	
	public String getFWHRP() {
		return FWHRP;
	}
	
	public void setFWHRP(String fWHRP) {
		FWHRP = fWHRP;
	}
	
	public String getExisting_ELCO() {
		return existing_ELCO;
	}
	
	public void setExisting_ELCO(String existing_ELCO) {
		this.existing_ELCO = existing_ELCO;
	}
	
	public String getFWANCBLRVIS() {
		return FWANCBLRVIS;
	}
	
	public void setFWANCBLRVIS(String fWANCBLRVIS) {
		FWANCBLRVIS = fWANCBLRVIS;
	}
	
	public String getFWANCSWLNG() {
		return FWANCSWLNG;
	}
	
	public void setFWANCSWLNG(String fWANCSWLNG) {
		FWANCSWLNG = fWANCSWLNG;
	}
	
	public String getFWANCCONVL() {
		return FWANCCONVL;
	}
	
	public void setFWANCCONVL(String fWANCCONVL) {
		FWANCCONVL = fWANCCONVL;
	}
	
	public String getFWANCBLD() {
		return FWANCBLD;
	}
	
	public void setFWANCBLD(String fWANCBLD) {
		FWANCBLD = fWANCBLD;
	}
	
	public String getFWANCDS1() {
		return FWANCDS1;
	}
	
	public void setFWANCDS1(String fWANCDS1) {
		FWANCDS1 = fWANCDS1;
	}
	
	public String getFWANCDS2() {
		return FWANCDS2;
	}
	
	public void setFWANCDS2(String fWANCDS2) {
		FWANCDS2 = fWANCDS2;
	}
	
	public String getFWANCDS3() {
		return FWANCDS3;
	}
	
	public void setFWANCDS3(String fWANCDS3) {
		FWANCDS3 = fWANCDS3;
	}
	
	public String getFWANCDS4() {
		return FWANCDS4;
	}
	
	public void setFWANCDS4(String fWANCDS4) {
		FWANCDS4 = fWANCDS4;
	}
	
	public String getFWANCDS5() {
		return FWANCDS5;
	}
	
	public void setFWANCDS5(String fWANCDS5) {
		FWANCDS5 = fWANCDS5;
	}
	
	public String getFWANCDS6() {
		return FWANCDS6;
	}
	
	public void setFWANCDS6(String fWANCDS6) {
		FWANCDS6 = fWANCDS6;
	}
	
	public String getFWDANGERVALUE() {
		return FWDANGERVALUE;
	}
	
	public void setFWDANGERVALUE(String fWDANGERVALUE) {
		FWDANGERVALUE = fWDANGERVALUE;
	}
	
	public String getFWNOTELIGIBLE() {
		return FWNOTELIGIBLE;
	}
	
	public void setFWNOTELIGIBLE(String fWNOTELIGIBLE) {
		FWNOTELIGIBLE = fWNOTELIGIBLE;
	}
	
	public String getELCO() {
		return ELCO;
	}
	
	public void setELCO(String eLCO) {
		ELCO = eLCO;
	}
	
	public String getFWHR_ANC() {
		return FWHR_ANC;
	}
	
	public void setFWHR_ANC(String fWHR_ANC) {
		FWHR_ANC = fWHR_ANC;
	}
	
	public String getFWFLAGVALUE() {
		return FWFLAGVALUE;
	}
	
	public void setFWFLAGVALUE(String fWFLAGVALUE) {
		FWFLAGVALUE = fWFLAGVALUE;
	}
	
	public String getFWSORTVALUE() {
		return FWSORTVALUE;
	}
	
	public void setFWSORTVALUE(String fWSORTVALUE) {
		FWSORTVALUE = fWSORTVALUE;
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
	
	public String getRelationalid() {
		return relationalid;
	}
	
	public void setRelationalid(String relationalid) {
		this.relationalid = relationalid;
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
	
	public Date getMOTHER_REFERENCE_DATE() {
		return MOTHER_REFERENCE_DATE;
	}
	
	public void setMOTHER_REFERENCE_DATE(Date mOTHER_REFERENCE_DATE) {
		MOTHER_REFERENCE_DATE = mOTHER_REFERENCE_DATE;
	}
	
	public Date getREFERENCE_DATE() {
		return REFERENCE_DATE;
	}
	
	public void setREFERENCE_DATE(Date rEFERENCE_DATE) {
		REFERENCE_DATE = rEFERENCE_DATE;
	}
	
	public String getFWBPCFINARGMT() {
		return FWBPCFINARGMT;
	}
	
	public void setFWBPCFINARGMT(String fWBPCFINARGMT) {
		FWBPCFINARGMT = fWBPCFINARGMT;
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
	
	public long getClientVersion() {
		return clientVersion;
	}
	
	public void setClientVersion(long clientVersion) {
		this.clientVersion = clientVersion;
	}
	
	public String getReceived_time() {
		return received_time;
	}
	
	public void setReceived_time(String received_time) {
		this.received_time = received_time;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
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
