package org.mcare.api;

import org.mcare.api.service.impl.BNFVisitActivity;
import org.mcare.api.service.impl.PSRFVisitActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitActivityApiService {
	
	@Autowired
	private PSRFVisitActivity psrfVisitActivity;
	
	@Autowired
	private BNFVisitActivity bnfVisitActivity;
	
	public void doPSRFVisitActivities(String caseId) {
		psrfVisitActivity.inactiveMotherWithPSRFAndANCAndPNCAndBNFByCaseId(caseId);
	}
	
	public void doBNFVisitActivities(String caseId, String visitCode) {
		if ("0".equalsIgnoreCase(visitCode)) {
			bnfVisitActivity.inactiveMotherAndChildAndRelatedActionExceptPSRFByCaseId(caseId);
		} else {
			bnfVisitActivity.inactiveMotherAndChildWithRelatedActionByCaseId(caseId);
		}
		
	}
}
