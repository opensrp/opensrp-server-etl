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
import org.opensrp.etl.entity.ANCEntity;
import org.opensrp.etl.service.ANCService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.util.ANCType;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sohel
 * @author proshanto
 */
public class MotherToANCConverter {
	
	private static final Logger logger = Logger.getLogger(MotherToANCConverter.class);
	
	private static final String ANC = "ANC";
	
	private static final String ANC_Visit_One = "ancVisitOne";
	
	private static final String ANC_Visit_Two = "ancVisitTwo";
	
	private static final String ANC_Visit_Three = "ancVisitThree";
	
	private static final String ANC_Visit_Four = "ancVisitFour";
	
	private ArrayList<String> ancKeys = new ArrayList<String>();
	
	private Map<String, String> ancVisitKeyMap = new HashMap<String, String>();
	
	@Autowired
	private ANCEntity ancEntity;
	
	@Autowired
	private ANCService ancService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	private void setANCKeys() {
		ancKeys.add("ancName");
		
		ancKeys.add("FWANCDATE");
		
		ancKeys.add("anc_current_formStatus");
		
		ancKeys.add("FWCONFIRMATION");
		
		ancKeys.add("FWGESTATIONALAGE");
		
		ancKeys.add("FWEDD");
		
		ancKeys.add("FWANCREMSTS");
		
		ancKeys.add("FWANCINT");
		
		ancKeys.add("FWANCKNWPRVDR");
		
		ancKeys.add("FWANCANM");
		
		ancKeys.add("FWANCHBP");
		
		ancKeys.add("FWANCDBT");
		
		ancKeys.add("FWANCTHY");
		
		ancKeys.add("FWANCPROB");
		
		ancKeys.add("FWANCHEAD");
		
		ancKeys.add("FWBPC1LOCOFDEL");
		
		ancKeys.add("FWBPC1ASSTLAB");
		
		ancKeys.add("FWBPC1TRNSPRT");
		
		ancKeys.add("FWBPC1BLDGRP");
		
		ancKeys.add("FWBPC1BLDDNR");
		
		ancKeys.add("FWBPC1FINARGMT");
		
		ancKeys.add("mauza");
		
		ancKeys.add("FWVG");
		
		ancKeys.add("FWHR_PSR");
		
		ancKeys.add("FWHRP");
		
		ancKeys.add("existing_ELCO");
		
		ancKeys.add("FWANCBLRVIS");
		
		ancKeys.add("FWANCSWLNG");
		
		ancKeys.add("FWANCCONVL");
		
		ancKeys.add("FWANCBLD");
		
		ancKeys.add("FWANCDS1");
		
		ancKeys.add("FWANCDS2");
		
		ancKeys.add("FWANCDS3");
		
		ancKeys.add("FWANCDS4");
		
		ancKeys.add("FWANCDS5");
		
		ancKeys.add("FWANCDS6");
		
		ancKeys.add("FWDANGERVALUE");
		
		ancKeys.add("FWNOTELIGIBLE");
		
		ancKeys.add("ELCO");
		
		ancKeys.add("FWHR_ANC");
		
		ancKeys.add("FWFLAGVALUE");
		
		ancKeys.add("FWSORTVALUE");
		
		ancKeys.add("user_type");
		
		ancKeys.add("external_user_ID");
		
		ancKeys.add("relationalid");
		
		ancKeys.add("GOBHHID");
		
		ancKeys.add("JiVitAHHID");
		
		ancKeys.add("FWWOMBID");
		
		ancKeys.add("FWWOMNID");
		
		ancKeys.add("FWWOMFNAME");
		
		ancKeys.add("FWHUSNAME");
		
		ancKeys.add("MOTHER_REFERENCE_DATE");
		
		ancKeys.add("REFERENCE_DATE");
		
		ancKeys.add("start");
		
		ancKeys.add("end");
		
		ancKeys.add("today");
		
		ancKeys.add("clientVersion");
		
		ancKeys.add("received_time");
		
		ancKeys.add("timeStamp");
	}
	
	private Map<String, String> getANCVisitKeys(String visitNo) {
		for (String ancKey : ancKeys) {
			if (ancKey.toUpperCase().contains(ANC)) {
				String anc = ancKey.substring(ancKey.toUpperCase().indexOf(ANC), ancKey.toUpperCase().indexOf(ANC) + 3);
				ancVisitKeyMap.put(ancKey, ancKey.replaceFirst(anc, anc.concat(visitNo)));
			} else {
				ancVisitKeyMap.put(ancKey, ancKey);
			}
		}
		return ancVisitKeyMap;
	}
	
	public void ancVisitSave(JSONObject mdoc) throws JSONException, ParseException {
		setANCKeys();
		try {
			
			if (mdoc.has(ANC_Visit_One) && mdoc.isNull(ANC_Visit_One) || mdoc.getJSONObject(ANC_Visit_One).length() == 0) {
				
			} else {
				JSONObject ancVisitOne = new JSONObject(mdoc.getString(ANC_Visit_One));
				Map<String, String> ancVisitKeyMap = new HashMap<String, String>();
				ancVisitKeyMap = getANCVisitKeys("1");
				ancEntity.setAncName(ANC_Visit_One);
				ancService.save(convertToAncEntity(ancVisitOne, ancVisitKeyMap, ANCType.anc1_current_formStatus.name()));
				
			}
			
			if (mdoc.has(ANC_Visit_Two) && mdoc.isNull(ANC_Visit_Two) || mdoc.getJSONObject(ANC_Visit_Two).length() == 0) {
				logger.debug("ancVisitTwo does not exist caseId:" + mdoc.getString("caseId"));
			} else {
				JSONObject ancVisitOne = new JSONObject(mdoc.getString(ANC_Visit_Two));
				Map<String, String> ancVisitKeyMap = new HashMap<String, String>();
				ancVisitKeyMap = getANCVisitKeys("2");
				ancEntity.setAncName(ANC_Visit_Two);
				ancService.save(convertToAncEntity(ancVisitOne, ancVisitKeyMap, ANCType.ANC2_current_formStatus.name()));
				
			}
			if (mdoc.has(ANC_Visit_Three) && mdoc.isNull(ANC_Visit_Three)
			        || mdoc.getJSONObject(ANC_Visit_Three).length() == 0) {
				
			} else {
				JSONObject ancVisit = new JSONObject(mdoc.getString(ANC_Visit_Three));
				Map<String, String> ancVisitKeyMap = new HashMap<String, String>();
				ancVisitKeyMap = getANCVisitKeys("3");
				ancEntity.setAncName(ANC_Visit_Three);
				ancService.save(convertToAncEntity(ancVisit, ancVisitKeyMap, ANCType.ANC3_current_formStatus.name()));
				
			}
			if (mdoc.has(ANC_Visit_Four) && mdoc.isNull(ANC_Visit_Four) || mdoc.getJSONObject(ANC_Visit_Four).length() == 0) {
				logger.debug("ancVisitFour does not exist caseId:" + mdoc.getString("caseId"));
			} else {
				JSONObject ancVisit = new JSONObject(mdoc.getString(ANC_Visit_Four));
				Map<String, String> ancVisitKeyMap = new HashMap<String, String>();
				ancVisitKeyMap = getANCVisitKeys("4");
				ancEntity.setAncName(ANC_Visit_Four);
				ancService.save(convertToAncEntity(ancVisit, ancVisitKeyMap, ANCType.ANC4_current_formStatus.name()));
				
			}
		}
		catch (JSONException e) {
			exceptionService.generatedEntityAndSave(mdoc, e.fillInStackTrace().toString(), "anc");
		}
		catch (ParseException e) {
			exceptionService.generatedEntityAndSave(mdoc, e.fillInStackTrace().toString(), "anc");
		}
		
	}
	
	private ANCEntity convertToAncEntity(JSONObject ancVisit, Map<String, String> ancVisitKeyMap, String anc_current_status)
	    throws ParseException, JSONException {
		
		ancEntity.setFWANCDATE(DateUtil.getDateFromString(ancVisit, ancVisitKeyMap.get("FWANCDATE")));
		
		ancEntity.setAnc_current_formStatus(ancVisit.getString(anc_current_status));
		ancEntity.setFWCONFIRMATION(ancVisit.getString(ancVisitKeyMap.get("FWCONFIRMATION")));
		ancEntity.setFWGESTATIONALAGE(ancVisit.getString(ancVisitKeyMap.get("FWGESTATIONALAGE")));
		ancEntity.setFWEDD(ancVisit.getString(ancVisitKeyMap.get("FWEDD")));
		ancEntity.setFWANCREMSTS(ancVisit.getString(ancVisitKeyMap.get("FWANCREMSTS")));
		ancEntity.setFWANCINT(ancVisit.getString(ancVisitKeyMap.get("FWANCINT")));
		ancEntity.setFWANCANM(ancVisit.getString(ancVisitKeyMap.get("FWANCANM")));
		ancEntity.setFWANCHBP(ancVisit.getString(ancVisitKeyMap.get("FWANCHBP")));
		ancEntity.setFWANCDBT(ancVisit.getString(ancVisitKeyMap.get("FWANCDBT")));
		ancEntity.setFWANCTHY(ancVisit.getString(ancVisitKeyMap.get("FWANCTHY")));
		ancEntity.setFWANCPROB(ancVisit.getString(ancVisitKeyMap.get("FWANCPROB")));
		ancEntity.setFWANCHEAD(ancVisit.getString(ancVisitKeyMap.get("FWANCHEAD")));
		ancEntity.setFWBPCLOCOFDEL(ancVisit.getString(ancVisitKeyMap.get("FWBPC1LOCOFDEL")));
		ancEntity.setFWBPCASSTLAB(ancVisit.getString(ancVisitKeyMap.get("FWBPC1ASSTLAB")));
		ancEntity.setFWBPCTRNSPRT(ancVisit.getString(ancVisitKeyMap.get("FWBPC1TRNSPRT")));
		ancEntity.setFWBPCBLDGRP(ancVisit.getString(ancVisitKeyMap.get("FWBPC1BLDGRP")));
		ancEntity.setFWBPCBLDDNR(ancVisit.getString(ancVisitKeyMap.get("FWBPC1BLDDNR")));
		ancEntity.setFWBPC1FINARGMT(ancVisit.getString(ancVisitKeyMap.get("FWBPC1FINARGMT")));
		ancEntity.setMauza(ancVisit.getString(ancVisitKeyMap.get("mauza")));
		ancEntity.setFWVG(ancVisit.getString(ancVisitKeyMap.get("FWVG")));
		ancEntity.setFWHR_PSR(ancVisit.getString(ancVisitKeyMap.get("FWHR_PSR")));
		ancEntity.setFWHRP(ancVisit.getString(ancVisitKeyMap.get("FWHRP")));
		ancEntity.setExisting_ELCO(ancVisit.getString(ancVisitKeyMap.get("existing_ELCO")));
		ancEntity.setFWANCBLRVIS(ancVisit.getString(ancVisitKeyMap.get("FWANCBLRVIS")));
		ancEntity.setFWANCSWLNG(ancVisit.getString(ancVisitKeyMap.get("FWANCSWLNG")));
		ancEntity.setFWANCCONVL(ancVisit.getString(ancVisitKeyMap.get("FWANCCONVL")));
		ancEntity.setFWANCBLD(ancVisit.getString(ancVisitKeyMap.get("FWANCBLD")));
		ancEntity.setFWANCDS1(ancVisit.getString(ancVisitKeyMap.get("FWANCDS1")));
		ancEntity.setFWANCDS2(ancVisit.getString(ancVisitKeyMap.get("FWANCDS2")));
		ancEntity.setFWANCDS3(ancVisit.getString(ancVisitKeyMap.get("FWANCDS3")));
		ancEntity.setFWANCDS4(ancVisit.getString(ancVisitKeyMap.get("FWANCDS4")));
		ancEntity.setFWANCDS5(ancVisit.getString(ancVisitKeyMap.get("FWANCDS5")));
		ancEntity.setFWANCDS6(ancVisit.getString(ancVisitKeyMap.get("FWANCDS6")));
		ancEntity.setFWDANGERVALUE(ancVisit.getString(ancVisitKeyMap.get("FWDANGERVALUE")));
		ancEntity.setFWNOTELIGIBLE(ancVisit.getString(ancVisitKeyMap.get("FWNOTELIGIBLE")));
		
		ancEntity.setFWHR_ANC(ancVisit.getString(ancVisitKeyMap.get("FWHR_ANC")));
		ancEntity.setFWFLAGVALUE(ancVisit.getString(ancVisitKeyMap.get("FWFLAGVALUE")));
		ancEntity.setFWSORTVALUE(ancVisit.getString(ancVisitKeyMap.get("FWSORTVALUE")));
		ancEntity.setUser_type(ancVisit.getString(ancVisitKeyMap.get("user_type")));
		ancEntity.setExternal_user_ID(ancVisit.getString(ancVisitKeyMap.get("external_user_ID")));
		ancEntity.setRelationalid(ancVisit.getString(ancVisitKeyMap.get("relationalid")));
		ancEntity.setFW_GOBHHID(ancVisit.getString(ancVisitKeyMap.get("GOBHHID")));
		ancEntity.setFW_JiVitAHHID(ancVisit.getString(ancVisitKeyMap.get("JiVitAHHID")));
		if (ancVisit.has("FWWOMBID"))
			ancEntity.setFWWOMBID(ancVisit.getString(ancVisitKeyMap.get("FWWOMBID")));
		if (ancVisit.has("FWWOMNID"))
			ancEntity.setFWWOMNID(ancVisit.getString(ancVisitKeyMap.get("FWWOMNID")));
		if (ancVisit.has("FWWOMFNAME"))
			ancEntity.setFWWOMFNAME(ancVisit.getString(ancVisitKeyMap.get("FWWOMFNAME")));
		if (ancVisit.has("FWHUSNAME"))
			ancEntity.setFWHUSNAME(ancVisit.getString(ancVisitKeyMap.get("FWHUSNAME")));
		
		ancEntity.setStart(DateUtil.getDateTimeFromString(ancVisit, ancVisitKeyMap.get("start")));
		ancEntity.setEnd(DateUtil.getDateTimeFromString(ancVisit, ancVisitKeyMap.get("end")));
		ancEntity.setToday(DateUtil.getDateFromString(ancVisit, ancVisitKeyMap.get("today")));
		ancEntity.setClientVersion(Long.parseLong(ancVisit.getString(ancVisitKeyMap.get("clientVersion"))));
		
		ancEntity.setReceived_time(DateUtil.getDateFromString(ancVisit, ancVisitKeyMap.get("received_time")));
		
		ancEntity.setTimeStamp(Long.parseLong(ancVisit.getString(ancVisitKeyMap.get("timeStamp"))));
		
		return ancEntity;
		
	}
}
