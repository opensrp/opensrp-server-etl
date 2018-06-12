package org.mcare.api.service.impl;

import java.util.List;

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
	
	public void inactiveMotherWithPSRFAndANCAndPNCAndBNFActionByCaseId(String caseId) throws Exception {
		MotherEntity mother = (MotherEntity) databaseServiceImpl.findByKey(caseId, "caseId", MotherEntity.class);
		
		if (mother != null) {
			mother.setvoidStatus(VoidStatus.FALSEREPORT.status());
			mother.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
			databaseServiceImpl.update(mother);
			inactiveANCVisitByCaseId(caseId);
			inactiveBNFVisitBycaseId(caseId);
			inactivePNCVisitByCaseId(caseId);
			inactiveAllActionByCaseId(caseId);
			logger.info("updated mother at case id :" + caseId);
		} else {
			logger.error("does not update record at case id :" + caseId);
		}
		
	}
	
	public void inactiveMotherWithANCAndPNCAndBNFActionByCaseId(String caseId) throws Exception {
		MotherEntity mother = (MotherEntity) databaseServiceImpl.findByKey(caseId, "caseId", MotherEntity.class);
		
		if (mother != null) {
			mother.setvoidStatus(VoidStatus.FALSEREPORT.status());
			mother.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
			databaseServiceImpl.update(mother);
			inactiveANCVisitByCaseId(caseId);
			inactiveBNFVisitBycaseId(caseId);
			inactivePNCVisitByCaseId(caseId);
			
			inactiveANCActionByCaseId(caseId);
			inactiveBNFActionByCaseId(caseId);
			inactivePNCActionByCaseId(caseId);
			logger.info("updated mother at case id :" + caseId);
		} else {
			logger.error("does not update record at case id :" + caseId);
		}
		
	}
	
	void inactiveMotherByCaseId(String caseId) {
		
	}
	
	void inactivePSRFVisitByCaseId(String caseId) throws Exception {
		@SuppressWarnings("unchecked")
		List<PSRFEntity> psrfEntities = (List<PSRFEntity>) databaseServiceImpl.findAllByKey(caseId, "relationalId",
		    PSRFEntity.class);
		
		if (psrfEntities.size() != 0) {
			for (PSRFEntity psrfEntity : psrfEntities) {
				if (psrfEntity != null) {
					psrfEntity.setvoidStatus(VoidStatus.FALSEREPORT.status());
					psrfEntity.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
					databaseServiceImpl.update(psrfEntity);
					logger.info("updated psrf record at  id :" + caseId);
				} else {
					logger.error("does not update psrf record at  id :" + caseId);
				}
			}
			
		}
		
	}
	
	void inactiveANCVisitByCaseId(String caseId) throws Exception {
		@SuppressWarnings("unchecked")
		List<ANCEntity> ancEntities = (List<ANCEntity>) databaseServiceImpl.findAllByKey(caseId, "relationalId",
		    ANCEntity.class);
		
		if (ancEntities.size() != 0) {
			for (ANCEntity ancEntity : ancEntities) {
				if (ancEntity != null) {
					ancEntity.setvoidStatus(VoidStatus.FALSEREPORT.status());
					ancEntity.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
					databaseServiceImpl.update(ancEntity);
					logger.info("updated anc record at case id :" + caseId);
				} else {
					logger.error("does not update anc record at case id :" + caseId);
					
				}
			}
			
		}
		
	}
	
	void inactiveBNFVisitBycaseId(String caseId) {
		@SuppressWarnings("unchecked")
		List<BNFEntity> bnfEntities = (List<BNFEntity>) databaseServiceImpl.findAllByKey(caseId, "relationalId",
		    BNFEntity.class);
		
		try {
			if (bnfEntities.size() != 0) {
				for (BNFEntity bnfEntity : bnfEntities) {
					if (bnfEntity != null) {
						bnfEntity.setvoidStatus(VoidStatus.FALSEREPORT.status());
						bnfEntity.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
						databaseServiceImpl.update(bnfEntity);
					} else {
						logger.error("does not update bnf record at case id :" + caseId);
					}
				}
				
			}
			
		}
		catch (Exception e) {
			logger.error("does not update bnf record at case id :" + caseId);
		}
	}
	
	void inactivePNCVisitByCaseId(String caseId) throws Exception {
		@SuppressWarnings("unchecked")
		List<PNCEntity> pncEntities = (List<PNCEntity>) databaseServiceImpl.findAllByKey(caseId, "relationalId",
		    PNCEntity.class);
		
		if (pncEntities.size() != 0) {
			for (PNCEntity pncEntity : pncEntities) {
				if (pncEntity != null) {
					pncEntity.setvoidStatus(VoidStatus.FALSEREPORT.status());
					pncEntity.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
					databaseServiceImpl.update(pncEntity);
				} else {
					logger.error("does not update pnc record at case id :" + caseId);
				}
			}
			
		}
		
	}
}
