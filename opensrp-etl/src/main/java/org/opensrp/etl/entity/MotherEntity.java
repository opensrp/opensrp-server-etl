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
@Table(name = "mother")
public class MotherEntity extends CommonEntity {
	
	public MotherEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mother_id_seq")
	@SequenceGenerator(name = "mother_id_seq", sequenceName = "mother_id_seq", allocationSize = 1)
	private int id;
	
	private String motherGOBHHID;
	
	private String motherJIVIHID;
	
	private String motherHusname;
	
	private String motherWomNID;
	
	private String motherWomBID;
	
	private String motherWomAge;
	
	private String motherValid;
	
	private String FWVG;
	
	private String FWHRP;
	
	private String FWHR_PSR;
	
	private String FWFLAGVALUE;
	
	private String FWSORTVALUE;
	
	@Temporal(TemporalType.DATE)
	private Date motherWomLMP;
	
	private String relationalId;
	
	private String isClosed;
	
	public int getId() {
		return id;
	}
	
	public String getMotherGOBHHID() {
		return motherGOBHHID;
	}
	
	public void setMotherGOBHHID(String motherGOBHHID) {
		this.motherGOBHHID = motherGOBHHID;
	}
	
	public String getMotherJIVIHID() {
		return motherJIVIHID;
	}
	
	public void setMotherJIVIHID(String motherJIVIHID) {
		this.motherJIVIHID = motherJIVIHID;
	}
	
	public String getMotherHusname() {
		return motherHusname;
	}
	
	public void setMotherHusname(String motherHusname) {
		this.motherHusname = motherHusname;
	}
	
	public String getMotherWomNID() {
		return motherWomNID;
	}
	
	public void setMotherWomNID(String motherWomNID) {
		this.motherWomNID = motherWomNID;
	}
	
	public String getMotherWomBID() {
		return motherWomBID;
	}
	
	public void setMotherWomBID(String motherWomBID) {
		this.motherWomBID = motherWomBID;
	}
	
	public String getMotherWomAge() {
		return motherWomAge;
	}
	
	public void setMotherWomAge(String motherWomAge) {
		this.motherWomAge = motherWomAge;
	}
	
	public String getMotherValid() {
		return motherValid;
	}
	
	public void setMotherValid(String motherValid) {
		this.motherValid = motherValid;
	}
	
	public String getFWVG() {
		return FWVG;
	}
	
	public void setFWVG(String fWVG) {
		FWVG = fWVG;
	}
	
	public String getFWHRP() {
		return FWHRP;
	}
	
	public void setFWHRP(String fWHRP) {
		FWHRP = fWHRP;
	}
	
	public String getFWHR_PSR() {
		return FWHR_PSR;
	}
	
	public void setFWHR_PSR(String fWHR_PSR) {
		FWHR_PSR = fWHR_PSR;
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
	
	public Date getMotherWomLMP() {
		return motherWomLMP;
	}
	
	public void setMotherWomLMP(Date motherWomLMP) {
		this.motherWomLMP = motherWomLMP;
	}
	
	public String getRelationalId() {
		return relationalId;
	}
	
	public void setRelationalId(String relationalId) {
		this.relationalId = relationalId;
	}
	
	public String getIsClosed() {
		return isClosed;
	}
	
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	
	@Override
	public String toString() {
		return "MotherEntity [id=" + id + ", motherGOBHHID=" + motherGOBHHID + ", motherJIVIHID=" + motherJIVIHID
		        + ", motherHusname=" + motherHusname + ", motherWomNID=" + motherWomNID + ", motherWomBID=" + motherWomBID
		        + ", motherWomAge=" + motherWomAge + ", motherValid=" + motherValid + ", FWVG=" + FWVG + ", FWHRP=" + FWHRP
		        + ", FWHR_PSR=" + FWHR_PSR + ", FWFLAGVALUE=" + FWFLAGVALUE + ", FWSORTVALUE=" + FWSORTVALUE
		        + ", motherWomLMP=" + motherWomLMP + ", relationalId=" + relationalId + ", isClosed=" + isClosed + "]";
	}
	
}
