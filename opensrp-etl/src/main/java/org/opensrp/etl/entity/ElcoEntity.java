package org.opensrp.etl.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "elco")
public class ElcoEntity extends CommonEntity {
	
	private ElcoEntity() {
		// TODO Auto-generated constructor stub
	}
	
	private static final ElcoEntity INSTANCE = new ElcoEntity();
	
	public static ElcoEntity getInstance() {
		return INSTANCE;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elco_id_seq")
	@SequenceGenerator(name = "elco_id_seq", sequenceName = "elco_id_seq", allocationSize = 1)
	private int id;
	
	private String FWCWOMSTRMEN;
	
	private String FWCWOMSTER;
	
	private String FWCWOMHUSALV;
	
	private String FWCWOMHUSLIV;
	
	private String FWCWOMHUSSTR;
	
	private String GOBHHID;
	
	private String JiVitAHHID;
	
	@Temporal(TemporalType.DATE)
	private Date FWCENDATE;
	
	private String FWCENSTAT;
	
	private String FWWOMANYID;
	
	private String FWWOMNID;
	
	private String FWWOMRETYPENID;
	
	private String FWWOMRETYPENID_CONCEPT;
	
	private String FWWOMBID;
	
	private String FWWOMRETYPEBID;
	
	private String FWWOMRETYPEBID_CONCEPT;
	
	private String FWHUSNAME;
	
	private String FWWOMAGE;
	
	private String FWDISPLAYAGE;
	
	private String FWWOMSTRMEN;
	
	private String FWWOMHUSALV;
	
	private String FWWOMHUSSTR;
	
	private String FWWOMHUSLIV;
	
	private String FWELIGIBLE;
	
	private String FWELIGIBLE2;
	
	private String FWWOMGOBHHID;
	
	private String FWPSRPREGSTS;//getting from details
	
	private String relationalId;//getting from details
	
	/*	@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "household_id", referencedColumnName = "id")
		private HouseholdEntity household;*/
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFWCWOMSTRMEN() {
		return FWCWOMSTRMEN;
	}
	
	public void setFWCWOMSTRMEN(String fWCWOMSTRMEN) {
		FWCWOMSTRMEN = fWCWOMSTRMEN;
	}
	
	public String getFWCWOMSTER() {
		return FWCWOMSTER;
	}
	
	public void setFWCWOMSTER(String fWCWOMSTER) {
		FWCWOMSTER = fWCWOMSTER;
	}
	
	public String getFWCWOMHUSALV() {
		return FWCWOMHUSALV;
	}
	
	public void setFWCWOMHUSALV(String fWCWOMHUSALV) {
		FWCWOMHUSALV = fWCWOMHUSALV;
	}
	
	public String getFWCWOMHUSLIV() {
		return FWCWOMHUSLIV;
	}
	
	public void setFWCWOMHUSLIV(String fWCWOMHUSLIV) {
		FWCWOMHUSLIV = fWCWOMHUSLIV;
	}
	
	public String getFWCWOMHUSSTR() {
		return FWCWOMHUSSTR;
	}
	
	public void setFWCWOMHUSSTR(String fWCWOMHUSSTR) {
		FWCWOMHUSSTR = fWCWOMHUSSTR;
	}
	
	public String getGOBHHID() {
		return GOBHHID;
	}
	
	public void setGOBHHID(String gOBHHID) {
		GOBHHID = gOBHHID;
	}
	
	public String getJiVitAHHID() {
		return JiVitAHHID;
	}
	
	public void setJiVitAHHID(String jiVitAHHID) {
		JiVitAHHID = jiVitAHHID;
	}
	
	public Date getFWCENDATE() {
		return FWCENDATE;
	}
	
	public void setFWCENDATE(Date fWCENDATE) {
		FWCENDATE = fWCENDATE;
	}
	
	public String getFWCENSTAT() {
		return FWCENSTAT;
	}
	
	public void setFWCENSTAT(String fWCENSTAT) {
		FWCENSTAT = fWCENSTAT;
	}
	
	public String getFWWOMANYID() {
		return FWWOMANYID;
	}
	
	public void setFWWOMANYID(String fWWOMANYID) {
		FWWOMANYID = fWWOMANYID;
	}
	
	public String getFWWOMNID() {
		return FWWOMNID;
	}
	
	public void setFWWOMNID(String fWWOMNID) {
		FWWOMNID = fWWOMNID;
	}
	
	public String getFWWOMRETYPENID() {
		return FWWOMRETYPENID;
	}
	
	public void setFWWOMRETYPENID(String fWWOMRETYPENID) {
		FWWOMRETYPENID = fWWOMRETYPENID;
	}
	
	public String getFWWOMRETYPENID_CONCEPT() {
		return FWWOMRETYPENID_CONCEPT;
	}
	
	public void setFWWOMRETYPENID_CONCEPT(String fWWOMRETYPENID_CONCEPT) {
		FWWOMRETYPENID_CONCEPT = fWWOMRETYPENID_CONCEPT;
	}
	
	public String getFWWOMBID() {
		return FWWOMBID;
	}
	
	public void setFWWOMBID(String fWWOMBID) {
		FWWOMBID = fWWOMBID;
	}
	
	public String getFWWOMRETYPEBID() {
		return FWWOMRETYPEBID;
	}
	
	public void setFWWOMRETYPEBID(String fWWOMRETYPEBID) {
		FWWOMRETYPEBID = fWWOMRETYPEBID;
	}
	
	public String getFWWOMRETYPEBID_CONCEPT() {
		return FWWOMRETYPEBID_CONCEPT;
	}
	
	public void setFWWOMRETYPEBID_CONCEPT(String fWWOMRETYPEBID_CONCEPT) {
		FWWOMRETYPEBID_CONCEPT = fWWOMRETYPEBID_CONCEPT;
	}
	
	public String getFWHUSNAME() {
		return FWHUSNAME;
	}
	
	public void setFWHUSNAME(String fWHUSNAME) {
		FWHUSNAME = fWHUSNAME;
	}
	
	public String getFWWOMAGE() {
		return FWWOMAGE;
	}
	
	public void setFWWOMAGE(String fWWOMAGE) {
		FWWOMAGE = fWWOMAGE;
	}
	
	public String getFWDISPLAYAGE() {
		return FWDISPLAYAGE;
	}
	
	public void setFWDISPLAYAGE(String fWDISPLAYAGE) {
		FWDISPLAYAGE = fWDISPLAYAGE;
	}
	
	public String getFWWOMSTRMEN() {
		return FWWOMSTRMEN;
	}
	
	public void setFWWOMSTRMEN(String fWWOMSTRMEN) {
		FWWOMSTRMEN = fWWOMSTRMEN;
	}
	
	public String getFWWOMHUSALV() {
		return FWWOMHUSALV;
	}
	
	public void setFWWOMHUSALV(String fWWOMHUSALV) {
		FWWOMHUSALV = fWWOMHUSALV;
	}
	
	public String getFWWOMHUSSTR() {
		return FWWOMHUSSTR;
	}
	
	public void setFWWOMHUSSTR(String fWWOMHUSSTR) {
		FWWOMHUSSTR = fWWOMHUSSTR;
	}
	
	public String getFWWOMHUSLIV() {
		return FWWOMHUSLIV;
	}
	
	public void setFWWOMHUSLIV(String fWWOMHUSLIV) {
		FWWOMHUSLIV = fWWOMHUSLIV;
	}
	
	public String getFWELIGIBLE() {
		return FWELIGIBLE;
	}
	
	public void setFWELIGIBLE(String fWELIGIBLE) {
		FWELIGIBLE = fWELIGIBLE;
	}
	
	public String getFWELIGIBLE2() {
		return FWELIGIBLE2;
	}
	
	public void setFWELIGIBLE2(String fWELIGIBLE2) {
		FWELIGIBLE2 = fWELIGIBLE2;
	}
	
	public String getFWWOMGOBHHID() {
		return FWWOMGOBHHID;
	}
	
	public void setFWWOMGOBHHID(String fWWOMGOBHHID) {
		FWWOMGOBHHID = fWWOMGOBHHID;
	}
	
	public String getFWPSRPREGSTS() {
		return FWPSRPREGSTS;
	}
	
	public void setFWPSRPREGSTS(String fWPSRPREGSTS) {
		FWPSRPREGSTS = fWPSRPREGSTS;
	}
	
	public String getRelationalId() {
		return relationalId;
	}
	
	public void setRelationalId(String relationalId) {
		this.relationalId = relationalId;
	}
	
	/*	public HouseholdEntity getHousehold() {
			return household;
		}
		
		public void setHousehold(HouseholdEntity household) {
			this.household = household;
		}*/
	
}
