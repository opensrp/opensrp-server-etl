package org.mcare.api.service.impl;

import org.apache.log4j.Logger;
import org.mcare.api.services.ActionActivityService;
import org.mcare.api.utils.VoidRemarks;
import org.mcare.api.utils.VoidStatus;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.mcare.etl.entity.ANCEntity;
import org.mcare.etl.entity.BNFEntity;
import org.mcare.etl.entity.MotherEntity;
import org.mcare.etl.entity.PNCEntity;
import org.mcare.etl.entity.PSRFEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PSRFVisitActivityServiceImpl extends ActionActivityService {
	
	private static final Logger logger = Logger.getLogger(PSRFVisitActivityServiceImpl.class);
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	public PSRFVisitActivityServiceImpl() {
		
	}
	
	public void inactiveMotherWithPSRFAndANCAndPNCAndBNFActionByCaseId(String caseId) {
		MotherEntity mother = (MotherEntity) databaseServiceImpl.findByKey(caseId, "caseId", MotherEntity.class);
		
		try {
			if (mother != null) {
				mother.setvoidStatus(VoidStatus.FALSEREPORT.status());
				mother.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(mother);
			}
			inactivePSRFVisitByCaseId(caseId);
			System.err.println("visitCode:::");
			inactiveANCVisitByCaseId(caseId);
			inactiveBNFVisitBycaseId(caseId);
			inactivePNCVisitByCaseId(caseId);
			
			inactiveAllActionByCaseId(caseId);
		}
		catch (Exception e) {
			logger.error("does not update record at case id :" + caseId);
		}
		
	}
	
	public void inactiveMotherWithANCAndPNCAndBNFActionByCaseId(String caseId) {
		MotherEntity mother = (MotherEntity) databaseServiceImpl.findByKey(caseId, "caseId", MotherEntity.class);
		
		try {
			if (mother != null) {
				mother.setvoidStatus(VoidStatus.FALSEREPORT.status());
				mother.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(mother);
			}
			
			inactiveANCVisitByCaseId(caseId);
			inactiveBNFVisitBycaseId(caseId);
			inactivePNCVisitByCaseId(caseId);
			
			inactiveANCActionByCaseId(caseId);
			inactiveBNFActionByCaseId(caseId);
			inactivePNCActionByCaseId(caseId);
		}
		catch (Exception e) {
			logger.error("does not update record at case id :" + caseId);
		}
	}
	
	void inactiveMotherByCaseId(String caseId) {
		
	}
	
	void inactivePSRFVisitByCaseId(String caseId) {
		PSRFEntity psrf = (PSRFEntity) databaseServiceImpl.findByKey(caseId, "relationalId", PSRFEntity.class);
		System.err.println("psrf" + psrf);
		try {
			if (psrf != null) {
				psrf.setvoidStatus(VoidStatus.FALSEREPORT.status());
				psrf.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(psrf);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("does not update psrf record at case id :" + caseId);
		}
		
	}
	
	void inactiveANCVisitByCaseId(String caseId) {
		ANCEntity anc = (ANCEntity) databaseServiceImpl.findByKey(caseId, "relationalId", ANCEntity.class);
		
		try {
			if (anc != null) {
				anc.setvoidStatus(VoidStatus.FALSEREPORT.status());
				anc.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(anc);
			}
			
		}
		catch (Exception e) {
			logger.error("does not update anc record at case id :" + caseId);
		}
		
	}
	
	void inactiveBNFVisitBycaseId(String caseId) {
		BNFEntity bnf = (BNFEntity) databaseServiceImpl.findByKey(caseId, "relationalId", BNFEntity.class);
		
		try {
			if (bnf != null) {
				bnf.setvoidStatus(VoidStatus.FALSEREPORT.status());
				bnf.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(bnf);
			}
			
		}
		catch (Exception e) {
			logger.error("does not update bnf record at case id :" + caseId);
		}
	}
	
	void inactivePNCVisitByCaseId(String caseId) {
		PNCEntity pnc = (PNCEntity) databaseServiceImpl.findByKey(caseId, "relationalId", PNCEntity.class);
		
		try {
			if (pnc != null) {
				pnc.setvoidStatus(VoidStatus.FALSEREPORT.status());
				pnc.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(pnc);
			}
			
		}
		catch (Exception e) {
			logger.error("does not update pnc record at case id :" + caseId);
		}
	}
}
