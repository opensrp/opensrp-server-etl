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
@Table(name = "encc")
public class ENCCEntity {
	
	public ENCCEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "encc_id_seq")
	@SequenceGenerator(name = "encc_id_seq", sequenceName = "encc_id_seq", allocationSize = 1)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date FWENCCDATE;
	
	private String FWENCCSTS;
	
	private String FWENCCBFINTN;
	
	private String FWENCCPRLCTL;
	
	private String FWENCCDRYWM;
	
	private String FWENCCHDCOV;
	
	private String FWENCCBTHD;
	
	private String FWENCCUMBS;
	
	private String FWENCCDSFVRCLD;
	
	private String FWENCCTEMP;
	
	private String FWENCCDSFOULUMBS;
	
	private String FWENCCDSLIMBLUE;
	
	private String FWENCCDSSKNYLW;
	
	private String FWENCCDSLETH;
	
	private String FWENCCDSDIFBRTH;
	
	private String FWENCCDSCONVL;
	
	private String FWENCCDELCOMP;
	
	private String encc_current_formStatus;
	
	@Temporal(TemporalType.DATE)
	private Date START_DATE;
	
	@Temporal(TemporalType.DATE)
	private Date END_DATE;
	
	@Temporal(TemporalType.DATE)
	private Date today;
	
	private long clientVersion;
	
	private String received_time;
	
	private long timeStamp;
	
	private String relationalId;
	
	private String enccName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	private Date updated = new Date();
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "child_id", referencedColumnName = "id")
	private ChildEntity child;*/
	
	public String getRelationalId() {
		return relationalId;
	}
	
	public void setRelationalId(String relationalId) {
		this.relationalId = relationalId;
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
	
	public Date getFWENCCDATE() {
		return FWENCCDATE;
	}
	
	public void setFWENCCDATE(Date fWENCCDATE) {
		FWENCCDATE = fWENCCDATE;
	}
	
	public String getFWENCCSTS() {
		return FWENCCSTS;
	}
	
	public void setFWENCCSTS(String fWENCCSTS) {
		FWENCCSTS = fWENCCSTS;
	}
	
	public String getFWENCCBFINTN() {
		return FWENCCBFINTN;
	}
	
	public void setFWENCCBFINTN(String fWENCCBFINTN) {
		FWENCCBFINTN = fWENCCBFINTN;
	}
	
	public String getFWENCCPRLCTL() {
		return FWENCCPRLCTL;
	}
	
	public void setFWENCCPRLCTL(String fWENCCPRLCTL) {
		FWENCCPRLCTL = fWENCCPRLCTL;
	}
	
	public String getFWENCCDRYWM() {
		return FWENCCDRYWM;
	}
	
	public void setFWENCCDRYWM(String fWENCCDRYWM) {
		FWENCCDRYWM = fWENCCDRYWM;
	}
	
	public String getFWENCCHDCOV() {
		return FWENCCHDCOV;
	}
	
	public void setFWENCCHDCOV(String fWENCCHDCOV) {
		FWENCCHDCOV = fWENCCHDCOV;
	}
	
	public String getFWENCCBTHD() {
		return FWENCCBTHD;
	}
	
	public void setFWENCCBTHD(String fWENCCBTHD) {
		FWENCCBTHD = fWENCCBTHD;
	}
	
	public String getFWENCCUMBS() {
		return FWENCCUMBS;
	}
	
	public void setFWENCCUMBS(String fWENCCUMBS) {
		FWENCCUMBS = fWENCCUMBS;
	}
	
	public String getFWENCCDSFVRCLD() {
		return FWENCCDSFVRCLD;
	}
	
	public void setFWENCCDSFVRCLD(String fWENCCDSFVRCLD) {
		FWENCCDSFVRCLD = fWENCCDSFVRCLD;
	}
	
	public String getFWENCCTEMP() {
		return FWENCCTEMP;
	}
	
	public void setFWENCCTEMP(String fWENCCTEMP) {
		FWENCCTEMP = fWENCCTEMP;
	}
	
	public String getFWENCCDSFOULUMBS() {
		return FWENCCDSFOULUMBS;
	}
	
	public void setFWENCCDSFOULUMBS(String fWENCCDSFOULUMBS) {
		FWENCCDSFOULUMBS = fWENCCDSFOULUMBS;
	}
	
	public String getFWENCCDSLIMBLUE() {
		return FWENCCDSLIMBLUE;
	}
	
	public void setFWENCCDSLIMBLUE(String fWENCCDSLIMBLUE) {
		FWENCCDSLIMBLUE = fWENCCDSLIMBLUE;
	}
	
	public String getFWENCCDSSKNYLW() {
		return FWENCCDSSKNYLW;
	}
	
	public void setFWENCCDSSKNYLW(String fWENCCDSSKNYLW) {
		FWENCCDSSKNYLW = fWENCCDSSKNYLW;
	}
	
	public String getFWENCCDSLETH() {
		return FWENCCDSLETH;
	}
	
	public void setFWENCCDSLETH(String fWENCCDSLETH) {
		FWENCCDSLETH = fWENCCDSLETH;
	}
	
	public String getFWENCCDSDIFBRTH() {
		return FWENCCDSDIFBRTH;
	}
	
	public void setFWENCCDSDIFBRTH(String fWENCCDSDIFBRTH) {
		FWENCCDSDIFBRTH = fWENCCDSDIFBRTH;
	}
	
	public String getFWENCCDSCONVL() {
		return FWENCCDSCONVL;
	}
	
	public void setFWENCCDSCONVL(String fWENCCDSCONVL) {
		FWENCCDSCONVL = fWENCCDSCONVL;
	}
	
	public String getFWENCCDELCOMP() {
		return FWENCCDELCOMP;
	}
	
	public void setFWENCCDELCOMP(String fWENCCDELCOMP) {
		FWENCCDELCOMP = fWENCCDELCOMP;
	}
	
	public String getEncc_current_formStatus() {
		return encc_current_formStatus;
	}
	
	public void setEncc_current_formStatus(String encc_current_formStatus) {
		this.encc_current_formStatus = encc_current_formStatus;
	}
	
	public Date getSTART_DATE() {
		return START_DATE;
	}
	
	public void setSTART_DATE(Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	
	public Date getEND_DATE() {
		return END_DATE;
	}
	
	public void setEND_DATE(Date eND_DATE) {
		END_DATE = eND_DATE;
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
	
	public String getEnccName() {
		return enccName;
	}
	
	public void setEnccName(String enccName) {
		this.enccName = enccName;
	}
	
}
