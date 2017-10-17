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
@Table(name = "child")
public class ChildEntity extends CommonEntity {
	
	private static final ChildEntity INSTANCE = new ChildEntity();
	
	private ChildEntity() {
		
	}
	
	public static ChildEntity getInstance() {
		return INSTANCE;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "child_id_seq")
	@SequenceGenerator(name = "child_id_seq", sequenceName = "child_id_seq", allocationSize = 1)
	private int id;
	
	private String isClosed;
	
	private String FWBNFCHLDVITSTS;//details
	
	private String FWBNFNAME;//details
	
	private String FWWOMFNAME;//details
	
	@Column(name = "mother_wom_age")
	//details
	private String motherWomAge;
	
	private String FWBNFCHILDNAME;//details
	
	private String FWWOMBID;//details
	
	@Temporal(TemporalType.DATE)
	@Column(name = "reference_date")
	private Date referenceDate;//details
	
	@Temporal(TemporalType.DATE)
	private Date WBNFDOB;//details
	
	private String GOBHHID;//details
	
	private String JIVITAHHID;//details
	
	private String FWBNFNAMECHECK;//details
	
	private String FWWOMNID;//details
	
	private String FWHUSNAME;//details
	
	@Column(name = "relational_id")
	private String relationalId;//details
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mother_id", referencedColumnName = "id")
	private MotherEntity mother;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIsClosed() {
		return isClosed;
	}
	
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	
	public String getFWBNFCHLDVITSTS() {
		return FWBNFCHLDVITSTS;
	}
	
	public void setFWBNFCHLDVITSTS(String fWBNFCHLDVITSTS) {
		FWBNFCHLDVITSTS = fWBNFCHLDVITSTS;
	}
	
	public String getFWBNFNAME() {
		return FWBNFNAME;
	}
	
	public void setFWBNFNAME(String fWBNFNAME) {
		FWBNFNAME = fWBNFNAME;
	}
	
	public String getFWWOMFNAME() {
		return FWWOMFNAME;
	}
	
	public void setFWWOMFNAME(String fWWOMFNAME) {
		FWWOMFNAME = fWWOMFNAME;
	}
	
	public String getMotherWomAge() {
		return motherWomAge;
	}
	
	public void setMotherWomAge(String motherWomAge) {
		this.motherWomAge = motherWomAge;
	}
	
	public String getFWBNFCHILDNAME() {
		return FWBNFCHILDNAME;
	}
	
	public void setFWBNFCHILDNAME(String fWBNFCHILDNAME) {
		FWBNFCHILDNAME = fWBNFCHILDNAME;
	}
	
	public String getFWWOMBID() {
		return FWWOMBID;
	}
	
	public void setFWWOMBID(String fWWOMBID) {
		FWWOMBID = fWWOMBID;
	}
	
	public Date getReferenceDate() {
		return referenceDate;
	}
	
	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}
	
	public Date getWBNFDOB() {
		return WBNFDOB;
	}
	
	public void setWBNFDOB(Date wBNFDOB) {
		WBNFDOB = wBNFDOB;
	}
	
	public String getGOBHHID() {
		return GOBHHID;
	}
	
	public void setGOBHHID(String gOBHHID) {
		GOBHHID = gOBHHID;
	}
	
	public String getJIVITAHHID() {
		return JIVITAHHID;
	}
	
	public void setJIVITAHHID(String jIVITAHHID) {
		JIVITAHHID = jIVITAHHID;
	}
	
	public String getFWBNFNAMECHECK() {
		return FWBNFNAMECHECK;
	}
	
	public void setFWBNFNAMECHECK(String fWBNFNAMECHECK) {
		FWBNFNAMECHECK = fWBNFNAMECHECK;
	}
	
	public String getFWWOMNID() {
		return FWWOMNID;
	}
	
	public void setFWWOMNID(String fWWOMNID) {
		FWWOMNID = fWWOMNID;
	}
	
	public String getFWHUSNAME() {
		return FWHUSNAME;
	}
	
	public void setFWHUSNAME(String fWHUSNAME) {
		FWHUSNAME = fWHUSNAME;
	}
	
	public String getRelationalId() {
		return relationalId;
	}
	
	public void setRelationalId(String relationalId) {
		this.relationalId = relationalId;
	}
	
	public MotherEntity getMother() {
		return mother;
	}
	
	public void setMother(MotherEntity mother) {
		this.mother = mother;
	}
	
}
