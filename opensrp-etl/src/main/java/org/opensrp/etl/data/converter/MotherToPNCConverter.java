/**
 * 
 */
package org.opensrp.etl.data.converter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.PNCEntity;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.PNCService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author proshanto
 * @author sohel
 */
public class MotherToPNCConverter {
	
	private static final Logger logger = Logger.getLogger(MotherToPNCConverter.class);
	
	private static final String PNC = "PNC";
	
	private static final String PNC_Visit_One = "pncVisitOne";
	
	private static final String PNC_Visit_Two = "pncVisitTwo";
	
	private static final String PNC_Visit_Three = "pncVisitThree";
	
	private ArrayList<String> pncKeys = new ArrayList<String>();
	
	private Map<String, String> pncVisitKeyMap = new HashMap<String, String>();
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private PNCEntity pncEntity;
	
	@Autowired
	private PNCService pncService;
	
	private void setPNCKeys() {
		pncKeys.add("pncName");
		pncKeys.add("FWPNCDATE");
		pncKeys.add("FWPNCREMSTS");
		pncKeys.add("FWPNCINT");
		pncKeys.add("FWPNCKNWPRVDR");
		pncKeys.add("FWPNCFVR");
		pncKeys.add("FWPNCTEMP");
		pncKeys.add("FWPNCDNGRSIGN");
		pncKeys.add("FWPNCDELCOMP");
		pncKeys.add("pnc_current_formStatus");
		pncKeys.add("FWPNCDELTYPE");
		
		pncKeys.add("user_type");
		pncKeys.add("external_user_ID");
		pncKeys.add("relationalid");
		pncKeys.add("GOBHHID");
		pncKeys.add("JiVitAHHID");
		pncKeys.add("FWWOMBID");
		pncKeys.add("FWWOMNID");
		pncKeys.add("FWWOMFNAME");
		pncKeys.add("FWHUSNAME");
		pncKeys.add("FWBNFDTOO");
		pncKeys.add("FWCONFIRMATION");
		pncKeys.add("FWBNFSTS");
		pncKeys.add("start");
		pncKeys.add("end");
		pncKeys.add("today");
		pncKeys.add("received_time");
		
	}
	
	private Map<String, String> getpncVisitKeys(String visitNo) {
		for (String pncKey : pncKeys) {
			if (pncKey.toUpperCase().contains(PNC)) {
				String pnc = pncKey.substring(pncKey.toUpperCase().indexOf(PNC), pncKey.toUpperCase().indexOf(PNC) + 3);
				pncVisitKeyMap.put(pncKey, pncKey.replaceFirst(pnc, pnc.concat(visitNo)));
			} else {
				pncVisitKeyMap.put(pncKey, pncKey);
			}
		}
		return pncVisitKeyMap;
	}
	
	public void pncVisitSave(JSONObject mdoc) throws JSONException {
		setPNCKeys();
		try {
			if (mdoc.has(PNC_Visit_One) && mdoc.isNull(PNC_Visit_One) || mdoc.getJSONObject(PNC_Visit_One).length() == 0) {
				logger.debug("pncVisitOne does not exist caseId:" + mdoc.getString("caseId"));
			} else {
				
				JSONObject pncVisitOne = new JSONObject(mdoc.getString(PNC_Visit_One));
				Map<String, String> pncVisitKeyMap = new HashMap<String, String>();
				pncVisitKeyMap = getpncVisitKeys("1");
				pncEntity.setPncName(PNC_Visit_One);
				pncService.save(convertTopncEntity(pncVisitOne, pncVisitKeyMap));
				logger.debug("pncVisitOne saved successfully entity: " + pncEntity.toString());
			}
			
			if (mdoc.has(PNC_Visit_Two) && mdoc.isNull(PNC_Visit_Two) || mdoc.getJSONObject(PNC_Visit_Two).length() == 0) {
				logger.debug("pncVisitTwo does not exist caseId:" + mdoc.getString("caseId"));
			} else {
				
				JSONObject pncVisitOne = new JSONObject(mdoc.getString(PNC_Visit_Two));
				Map<String, String> pncVisitKeyMap = new HashMap<String, String>();
				pncVisitKeyMap = getpncVisitKeys("2");
				pncEntity.setPncName(PNC_Visit_Two);
				pncService.save(convertTopncEntity(pncVisitOne, pncVisitKeyMap));
				logger.debug("pncVisitTwo saved successfully entity: " + pncEntity.toString());
			}
			
			if (mdoc.has(PNC_Visit_Three) && mdoc.isNull(PNC_Visit_Three)
			        || mdoc.getJSONObject(PNC_Visit_Three).length() == 0) {
				logger.debug("pncVisitThree does not exist caseId:" + mdoc.getString("caseId"));
			} else {
				
				JSONObject pncVisit = new JSONObject(mdoc.getString(PNC_Visit_Three));
				Map<String, String> pncVisitKeyMap = new HashMap<String, String>();
				pncVisitKeyMap = getpncVisitKeys("3");
				pncEntity.setPncName(PNC_Visit_Three);
				pncService.save(convertTopncEntity(pncVisit, pncVisitKeyMap));
				
			}
			
		}
		catch (JSONException e) {
			exceptionService.generatedEntityAndSave(mdoc, e.fillInStackTrace().toString(), "pnc");
		}
		catch (ParseException e) {
			exceptionService.generatedEntityAndSave(mdoc, e.fillInStackTrace().toString(), "pnc");
		}
		
	}
	
	private PNCEntity convertTopncEntity(JSONObject pncVisit, Map<String, String> pncVisitKeyMap) throws ParseException,
	    JSONException {
		
		pncEntity.setFWPNCDATE(DateUtil.getDateFromString(pncVisit, pncVisitKeyMap.get("FWPNCDATE")));
		
		if (pncVisit.has(pncVisitKeyMap.get("pnc_current_formStatus"))) {
			pncEntity.setPnc_current_formStatus(pncVisit.getString(pncVisitKeyMap.get("pnc_current_formStatus")));
		} else {
			pncEntity.setPnc_current_formStatus("");
		}
		if (pncVisit.has(pncVisitKeyMap.get("FWPNCREMSTS"))) {
			pncEntity.setFWPNCREMSTS(pncVisit.getString(pncVisitKeyMap.get("FWPNCREMSTS")));
		} else {
			pncEntity.setFWPNCREMSTS("");
		}
		if (pncVisit.has(pncVisitKeyMap.get("FWPNCINT"))) {
			pncEntity.setFWPNCINT(pncVisit.getString(pncVisitKeyMap.get("FWPNCINT")));
		} else {
			pncEntity.setFWPNCINT("");
		}
		if (pncVisit.has(pncVisitKeyMap.get("FWPNCKNWPRVDR"))) {
			pncEntity.setFWPNCKNWPRVDR(pncVisit.getString(pncVisitKeyMap.get("FWPNCKNWPRVDR")));
		} else {
			pncEntity.setFWPNCKNWPRVDR("");
		}
		if (pncVisit.has(pncVisitKeyMap.get("FWPNCFVR"))) {
			pncEntity.setFWPNCFVR(pncVisit.getString(pncVisitKeyMap.get("FWPNCFVR")));
		} else {
			pncEntity.setFWPNCFVR("");
		}
		if (pncVisit.has(pncVisitKeyMap.get("FWPNCTEMP"))) {
			pncEntity.setFWPNCTEMP(pncVisit.getString(pncVisitKeyMap.get("FWPNCTEMP")));
		} else {
			pncEntity.setFWPNCTEMP("");
		}
		if (pncVisit.has(pncVisitKeyMap.get("FWPNCDNGRSIGN"))) {
			pncEntity.setFWPNCDNGRSIGN(pncVisit.getString(pncVisitKeyMap.get("FWPNCDNGRSIGN")));
		} else {
			pncEntity.setFWPNCDNGRSIGN("");
		}
		
		if (pncVisit.has(pncVisitKeyMap.get("FWPNCDELCOMP"))) {
			pncEntity.setFWPNCDELCOMP(pncVisit.getString(pncVisitKeyMap.get("FWPNCDELCOMP")));
		} else {
			pncEntity.setFWPNCDELCOMP("");
		}
		if (pncVisit.has(pncVisitKeyMap.get("FWPNCDELTYPE"))) {
			pncEntity.setFWPNCDELTYPE(pncVisit.getString(pncVisitKeyMap.get("FWPNCDELTYPE")));
		} else {
			pncEntity.setFWPNCDELTYPE("");
		}
		
		pncEntity.setUser_type(pncVisit.getString(pncVisitKeyMap.get("user_type")));
		
		pncEntity.setRelationalid(pncVisit.getString(pncVisitKeyMap.get("relationalid")).trim());
		pncEntity.setFW_GOBHHID(pncVisit.getString(pncVisitKeyMap.get("GOBHHID")));
		pncEntity.setFW_JiVitAHHID(pncVisit.getString(pncVisitKeyMap.get("JiVitAHHID")));
		pncEntity.setFW_WOMBID(pncVisit.getString(pncVisitKeyMap.get("FWWOMBID")));
		pncEntity.setFW_WOMNID(pncVisit.getString(pncVisitKeyMap.get("FWWOMNID")));
		pncEntity.setFW_WOMFNAME(pncVisit.getString(pncVisitKeyMap.get("FWWOMFNAME")));
		pncEntity.setFW_HUSNAME(pncVisit.getString(pncVisitKeyMap.get("FWHUSNAME")));
		pncEntity.setFWBNFDTOO(pncVisit.getString(pncVisitKeyMap.get("FWBNFDTOO")));
		pncEntity.setFWCONFIRMATION(pncVisit.getString(pncVisitKeyMap.get("FWCONFIRMATION")));
		pncEntity.setFWBNFSTS(pncVisit.getString(pncVisitKeyMap.get("FWBNFSTS")));
		
		pncEntity.setStart(DateUtil.getDateTimeFromString(pncVisit, pncVisitKeyMap.get("start")));
		pncEntity.setEnd(DateUtil.getDateTimeFromString(pncVisit, pncVisitKeyMap.get("end")));
		pncEntity.setToday(DateUtil.getDateFromString(pncVisit, pncVisitKeyMap.get("today")));
		if (pncVisit.has("received_time")) {
			pncEntity.setReceived_time(pncVisit.getString(pncVisitKeyMap.get("received_time")));
		} else {
			pncEntity.setReceived_time(null);
		}
		
		return pncEntity;
		
	}
	
}
