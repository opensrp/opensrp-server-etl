package org.mcare.api.service.impl;

import java.util.List;

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
		ChildEntity child = (ChildEntity) databaseServiceImpl.findByKey(caseId, "relationalId", ChildEntity.class);
		
		try {
			psrfVisitActivityServiceImpl.inactiveMotherWithPSRFAndANCAndPNCAndBNFActionByCaseId(caseId);
			if (child != null) {
				String childCaseId = child.caseId;
				child.setvoidStatus(VoidStatus.FALSEREPORT.status());
				child.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(child);
				inactiveENCCVisitByCaseId(childCaseId);
				inactiveAllActionByCaseId(childCaseId);
				logger.info("updated child at case id :" + childCaseId);
			}
			
		}
		catch (Exception e) {
			logger.error("does not update record at relation id :" + caseId + ", message:" + e.getMessage());
		}
		
	}
	
	public void inactiveChildByCaseId(String caseId) {
		
	}
	
	public void inactiveMotherAndChildAndRelatedActionExceptPSRFByCaseId(String caseId) {
		ChildEntity child = (ChildEntity) databaseServiceImpl.findByKey(caseId, "relationalId", ChildEntity.class);
		
		try {
			
			if (child != null) {
				String childCaseId = child.caseId;
				child.setvoidStatus(VoidStatus.FALSEREPORT.status());
				child.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
				databaseServiceImpl.update(child);
				logger.info("updated child at case id :" + childCaseId);
				inactiveENCCVisitByCaseId(childCaseId);
				inactiveAllActionByCaseId(childCaseId);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("does not update record at relation id :" + caseId);
		}
		
		try {
			psrfVisitActivityServiceImpl.inactiveMotherWithANCAndPNCAndBNFActionByCaseId(caseId);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void inactiveENCCVisitByCaseId(String relationalId) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<ENCCEntity> enccEntities = (List<ENCCEntity>) databaseServiceImpl.findAllByKey(relationalId, "relationalId",
		    ENCCEntity.class);
		if (enccEntities != null) {
			if (enccEntities.size() != 0) {
				for (ENCCEntity enccEntity : enccEntities) {
					if (enccEntity != null) {
						enccEntity.setvoidStatus(VoidStatus.FALSEREPORT.status());
						enccEntity.setvoidRemarks(VoidRemarks.FALSEREPORTREMARKS.remarks());
						databaseServiceImpl.update(enccEntity);
						logger.info("updated encc at relational id :" + relationalId);
					} else {
						logger.error("does not update encc  at case id :" + relationalId);
					}
				}
				
			}
		} else {
			logger.info("no anc record found at relational id :" + relationalId);
		}
		
	}
	
}
