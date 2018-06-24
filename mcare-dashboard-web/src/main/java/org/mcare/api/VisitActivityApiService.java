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
	
	/**
	 * 03: বয়সের কারনে মাসিক একেবারে উঠে গেছে Women Menopausal, 04: মহিলা স্থায়ী পদ্ধতি গ্রহণ করেছেন
	 * Woman Sterilized, 44: স্বামী স্থায়ী পদ্ধতি গ্রহণ করেছেন Husband Sterilized, 05:
	 * তালাকপ্রাপ্তা/আলাদা থাকেন Divorced / Separated, 08: মহিলা মারা গেছেন Woman Died, 88: স্বামী
	 * মারা গেছেন Husband Died, 999: DMC ONLY DMC ONLY
	 * 
	 * @throws Exception
	 */
	public void doPSRFVisitActivities(String caseId) throws Exception {
		psrfVisitActivity.inactiveMotherWithPSRFAndANCAndPNCAndBNFActionByCaseId(caseId);
	}
	
	/**
	 * 0: মহিলার গর্ভবতী হওয়ার তথ্যটি ভুল ছিল False pregnancy report ,3: জীবিত বাচ্চা জন্ম দিয়েছেন
	 * Woman had live birth, 4: গর্ভনষ্ট হয়েছে / মৃতবাচ্চা প্রসব হয়েছে Miscarriage / Stillbirth, 8:
	 * বাচ্চা জন্ম দেওয়ার আগেই মহিলা মারা গেছেন Woman died before birth, 999: DMC ONLY DMC ONLY
	 **/
	public void doBNFVisitActivities(String caseId, String visitCode) {
		if ("0".equalsIgnoreCase(visitCode)) {
			bnfVisitActivity.inactiveMotherAndChildAndRelatedActionExceptPSRFByCaseId(caseId);
		} else {
			bnfVisitActivity.inactiveMotherAndChildWithRelatedActionByCaseId(caseId);
		}
		
	}
}
