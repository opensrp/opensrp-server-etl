package org.opensrp.etl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "encc")
public class ENCCEntity {
	
	public ENCCEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "encc_id_seq")
	@SequenceGenerator(name = "encc_id_seq", sequenceName = "encc_id_seq", allocationSize = 1)
	private int id;
	
	private String FWENCCDATE;
	
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
	
	private String REFERENCE_DATE;
	
	private String START_DATE;
	
	private String END_DATE;
	
	private long clientVersion;
	
	private String received_time;
	
	private long timeStamp;
	
	private String enccName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "child_id", referencedColumnName = "id")
	private ChildEntity child;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFWENCCDATE() {
		return FWENCCDATE;
	}
	
	public void setFWENCCDATE(String fWENCCDATE) {
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
	
	public String getREFERENCE_DATE() {
		return REFERENCE_DATE;
	}
	
	public void setREFERENCE_DATE(String rEFERENCE_DATE) {
		REFERENCE_DATE = rEFERENCE_DATE;
	}
	
	public String getSTART_DATE() {
		return START_DATE;
	}
	
	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	
	public String getEND_DATE() {
		return END_DATE;
	}
	
	public void setEND_DATE(String eND_DATE) {
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
	
	public ChildEntity getChild() {
		return child;
	}
	
	public void setChild(ChildEntity child) {
		this.child = child;
	}
	
}
