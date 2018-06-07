package org.mcare.api.service.impl;

import org.apache.log4j.Logger;
import org.mcare.api.services.ActionActivityService;
import org.mcare.api.utils.VoidRemarks;
import org.mcare.api.utils.VoidStatus;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.mcare.etl.entity.ChildEntity;
import org.mcare.etl.entity.ENCCEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BNFVisitActivityServiceImpl extends ActionActivityService {
	
	private static final Logger logger = Logger.getLogger(BNFVisitActivityServiceImpl.class);
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	@Autowired
	private PSRFVisitActivityServiceImpl psrfVisitActivityServiceImpl;
	
	public BNFVisitActivityServiceImpl() {
		super();
	}
	
	public void inactiveMotherAndChildWithRelatedActionByCaseId(String caseId) {
		ChildEntity child = (ChildEntity) databaseServiceImpl.findByKey(caseId, "caseId", ChildEntity.class);
		
		System.err.println("child.getRelationalId()" + child.getRelationalId());
		try {
			psrfVisitActivityServiceImpl.inactiveMotherWithPSRFAndANCAndPNCAndBNFActionByCaseId(child.getRelationalId());
			if (child != null) {
				child.setvoidStatus(VoidStatus.FALSEREPORT.status());
				child.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(child);
			}
			inactiveAllActionByCaseId(caseId);
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("does not update record at case id :" + caseId + ", message:" + e.getMessage());
		}
		
	}
	
	public void inactiveChildByCaseId(String caseId) {
		
	}
	
	public void activeMotherAndInactiveChildAndRelatedActionExceptPSRFByCaseId(String caseId) {
		ChildEntity child = (ChildEntity) databaseServiceImpl.findByKey(caseId, "caseId", ChildEntity.class);
		
		try {
			psrfVisitActivityServiceImpl.inactiveMotherWithANCAndPNCAndBNFActionByCaseId(child.getRelationalId());
			if (child != null) {
				child.setvoidStatus(VoidStatus.FALSEREPORT.status());
				child.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(child);
			}
			inactiveENCCVisitByCaseId(caseId);
			inactiveAllActionByCaseId(caseId);
		}
		catch (Exception e) {
			logger.error("does not update record at case id :" + caseId);
		}
	}
	
	void inactiveENCCVisitByCaseId(String caseId) {
		ENCCEntity encc = (ENCCEntity) databaseServiceImpl.findByKey(caseId, "relationalId", ENCCEntity.class);
		
		try {
			if (encc != null) {
				encc.setvoidStatus(VoidStatus.FALSEREPORT.status());
				encc.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(encc);
			}
			
		}
		catch (Exception e) {
			logger.error("does not update encc record at case id :" + caseId);
		}
		
	}
	
}
