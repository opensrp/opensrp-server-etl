package org.mcare.api;

import org.mcare.api.service.impl.BNFVisitActivityServiceImpl;
import org.mcare.api.service.impl.PSRFVisitActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitActivityApiService {
	
	@Autowired
	private PSRFVisitActivityServiceImpl psrfVisitActivity;
	
	@Autowired
	private BNFVisitActivityServiceImpl bnfVisitActivity;
	
	public void doPSRFVisitActivities(String caseId) {
		psrfVisitActivity.inactiveMotherWithPSRFAndANCAndPNCAndBNFActionByCaseId(caseId);
	}
	
	public void doBNFVisitActivities(String caseId, String visitCode) {
		if ("0".equalsIgnoreCase(visitCode)) {
			System.err.println("visitCode::" + visitCode);
			bnfVisitActivity.activeMotherAndInactiveChildAndRelatedActionExceptPSRFByCaseId(caseId);
		} else {
			System.err.println("visitCode:::" + visitCode);
			bnfVisitActivity.inactiveMotherAndChildWithRelatedActionByCaseId(caseId);
		}
		
	}
}
