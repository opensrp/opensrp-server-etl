/**
 * 
 */
package org.opensrp.etl.data.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ENCCEntity;
import org.opensrp.etl.service.ENCCService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sohel
 */
public class ChildToENCCConverter {
	
	private static final String ENCC = "ENCC";
	
	private static final String ENCC_Visit_One = "enccVisitOne";
	
	private static final String ENCC_Visit_Two = "enccVisitTwo";
	
	private static final String ENCC_Visit_Three = "enccVisitThree";
	
	private ArrayList<String> enccKeys = new ArrayList<String>();
	
	private Map<String, String> enccVisitKeyMap = new HashMap<String, String>();
	
	@Autowired
	private ENCCEntity enccEntity;
	
	@Autowired
	private ENCCService enccService;
	
	private void setENCCKeys() {
		enccKeys.add("enccName");
		
		enccKeys.add("FWENCCDATE");
		
		enccKeys.add("encc_current_formStatus");
		
		enccKeys.add("FWCONFIRMATION");
		
		enccKeys.add("FWGESTATIONALAGE");
		
		enccKeys.add("FWEDD");
		
		enccKeys.add("FWENCCREMSTS");
		
		enccKeys.add("FWENCCINT");
		
		enccKeys.add("FWENCCKNWPRVDR");
		
		enccKeys.add("FWENCCANM");
		
		enccKeys.add("FWENCCHBP");
		
		enccKeys.add("FWENCCDBT");
		
		enccKeys.add("FWENCCTHY");
		
		enccKeys.add("FWENCCPROB");
		
		enccKeys.add("FWENCCHEAD");
		
		enccKeys.add("FWBPC1LOCOFDEL");
		
		enccKeys.add("FWBPC1ASSTLAB");
		
		enccKeys.add("FWBPC1TRNSPRT");
		
		enccKeys.add("FWBPC1BLDGRP");
		
		enccKeys.add("FWBPC1BLDDNR");
		
		enccKeys.add("FWBPC1FINARGMT");
		
		enccKeys.add("mauza");
		
		enccKeys.add("FWVG");
		
		enccKeys.add("FWHR_PSR");
		
		enccKeys.add("FWHRP");
		
		enccKeys.add("existing_ELCO");
		
		enccKeys.add("FWENCCBLRVIS");
		
		enccKeys.add("FWENCCSWLNG");
		
		enccKeys.add("FWENCCCONVL");
		
		enccKeys.add("FWENCCBLD");
		
		enccKeys.add("FWENCCDS1");
		
		enccKeys.add("FWENCCDS2");
		
		enccKeys.add("FWENCCDS3");
		
		enccKeys.add("FWENCCDS4");
		
		enccKeys.add("FWENCCDS5");
		
		enccKeys.add("FWENCCDS6");
		
		enccKeys.add("FWDANGERVALUE");
		
		enccKeys.add("FWNOTELIGIBLE");
		
		enccKeys.add("ELCO");
		
		enccKeys.add("FWHR_ENCC");
		
		enccKeys.add("FWFLAGVALUE");
		
		enccKeys.add("FWSORTVALUE");
		
		enccKeys.add("user_type");
		
		enccKeys.add("external_user_ID");
		
		enccKeys.add("relationalid");
		
		enccKeys.add("GOBHHID");
		
		enccKeys.add("FW_JiVitAHHID");
		
		enccKeys.add("FW_WOMBID");
		
		enccKeys.add("FW_WOMNID");
		
		enccKeys.add("FW_WOMFNAME");
		
		enccKeys.add("FW_HUSNAME");
		
		enccKeys.add("MOTHER_REFERENCE_DATE");
		
		enccKeys.add("REFERENCE_DATE");
		
		enccKeys.add("start");
		
		enccKeys.add("end");
		
		enccKeys.add("clientVersion");
		
		enccKeys.add("received_time");
		
		enccKeys.add("timeStamp");
	}
	
	private Map<String, String> getENCCVisitKeys(String visitNo) {
		for (String enccKey : enccKeys) {
			if (enccKey.toUpperCase().contains(ENCC)) {
				String encc = enccKey.substring(enccKey.toUpperCase().indexOf(ENCC),
				    enccKey.toUpperCase().indexOf(ENCC) + 3);
				enccVisitKeyMap.put(enccKey, enccKey.replaceFirst(encc, encc.concat(visitNo)));
			} else {
				enccVisitKeyMap.put(enccKey, enccKey);
			}
		}
		return enccVisitKeyMap;
	}
	
	public void enccVisitSave(JSONObject mdoc) throws JSONException {
		setENCCKeys();
		try {
			
			if (mdoc.has(ENCC_Visit_One) && mdoc.isNull(ENCC_Visit_One)
			        || mdoc.getJSONObject(ENCC_Visit_One).length() == 0) {
				System.out.println("enccVisitOne does not exist caseId:" + mdoc.getString("caseId"));
			} else {
				System.out.println("enccVisitOne  exist caseId:" + mdoc.getString("caseId"));
				JSONObject enccVisitOne = new JSONObject(mdoc.getString(ENCC_Visit_One));
				Map<String, String> enccVisitKeyMap = new HashMap<String, String>();
				enccVisitKeyMap = getENCCVisitKeys("1");
				enccEntity.setEnccName(ENCC_Visit_One);
				enccService.save(convertToAncEntity(enccVisitOne, enccVisitKeyMap));
				System.out.println("enccVisitOne saved successfully entity: " + enccEntity.toString());
			}
			
			if (mdoc.has(ENCC_Visit_Two) && mdoc.isNull(ENCC_Visit_Two)
			        || mdoc.getJSONObject(ENCC_Visit_Two).length() == 0) {
				System.out.println("enccVisitTwo does not exist caseId:" + mdoc.getString("caseId"));
			} else {
				System.out.println("enccVisitTwo  exist caseId:" + mdoc.getString("caseId"));
				JSONObject enccVisitOne = new JSONObject(mdoc.getString(ENCC_Visit_Two));
				Map<String, String> enccVisitKeyMap = new HashMap<String, String>();
				enccVisitKeyMap = getENCCVisitKeys("2");
				enccEntity.setEnccName(ENCC_Visit_Two);
				enccService.save(convertToAncEntity(enccVisitOne, enccVisitKeyMap));
				System.out.println("enccVisitTwo saved successfully entity: " + enccEntity.toString());
			}
			
			if (mdoc.has(ENCC_Visit_Three) && mdoc.isNull(ENCC_Visit_Three)
			        || mdoc.getJSONObject(ENCC_Visit_Three).length() == 0) {
				System.out.println("enccVisitThree does not exist caseId:" + mdoc.getString("caseId"));
			} else {
				System.out.println("enccVisitThree  exist caseId:" + mdoc.getString("caseId"));
				JSONObject enccVisit = new JSONObject(mdoc.getString(ENCC_Visit_Three));
				Map<String, String> enccVisitKeyMap = new HashMap<String, String>();
				enccVisitKeyMap = getENCCVisitKeys("3");
				enccEntity.setEnccName(ENCC_Visit_Three);
				enccService.save(convertToAncEntity(enccVisit, enccVisitKeyMap));
				System.out.println("enccVisitThree saved successfully entity: " + enccEntity.toString());
			}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(mdoc.getString("caseId"));
			e.printStackTrace();
		}
		
	}
	
	private ENCCEntity convertToAncEntity(JSONObject enccVisit, Map<String, String> enccVisitKeyMap) {
		try {
			enccEntity.setFWENCCDATE(DateUtil.getDateFromString(enccVisit.getString(enccVisitKeyMap.get("FWENCCDATE"))));
			enccEntity.setEncc_current_formStatus(enccVisit.getString(enccVisitKeyMap.get("encc_current_formStatus")));
			/*			enccEntity.setFWCONFIRMATION(enccVisit.getString(enccVisitKeyMap.get("FWCONFIRMATION")));
						enccEntity.setFWGESTATIONALAGE(enccVisit.getString(enccVisitKeyMap.get("FWGESTATIONALAGE")));
						enccEntity.setFWEDD(enccVisit.getString(enccVisitKeyMap.get("FWEDD")));
						enccEntity.setFWENCCREMSTS(enccVisit.getString(enccVisitKeyMap.get("FWENCCREMSTS")));
						enccEntity.setFWENCCINT(enccVisit.getString(enccVisitKeyMap.get("FWENCCINT")));
						enccEntity.setFWENCCANM(enccVisit.getString(enccVisitKeyMap.get("FWENCCANM")));
						enccEntity.setFWENCCHBP(enccVisit.getString(enccVisitKeyMap.get("FWENCCHBP")));
						enccEntity.setFWENCCDBT(enccVisit.getString(enccVisitKeyMap.get("FWENCCDBT")));
						enccEntity.setFWENCCTHY(enccVisit.getString(enccVisitKeyMap.get("FWENCCTHY")));
						enccEntity.setFWENCCPROB(enccVisit.getString(enccVisitKeyMap.get("FWENCCPROB")));
						enccEntity.setFWENCCHEAD(enccVisit.getString(enccVisitKeyMap.get("FWENCCHEAD")));
						enccEntity.setFWBPCLOCOFDEL(enccVisit.getString(enccVisitKeyMap.get("FWBPC1LOCOFDEL")));
						enccEntity.setFWBPCASSTLAB(enccVisit.getString(enccVisitKeyMap.get("FWBPC1ASSTLAB")));
						enccEntity.setFWBPCTRNSPRT(enccVisit.getString(enccVisitKeyMap.get("FWBPC1TRNSPRT")));
						enccEntity.setFWBPCBLDGRP(enccVisit.getString(enccVisitKeyMap.get("FWBPC1BLDGRP")));
						enccEntity.setFWBPCBLDDNR(enccVisit.getString(enccVisitKeyMap.get("FWBPC1BLDDNR")));
						enccEntity.setFWBPC1FINARGMT(enccVisit.getString(enccVisitKeyMap.get("FWBPC1FINARGMT")));
						enccEntity.setMauza(enccVisit.getString(enccVisitKeyMap.get("mauza")));
						enccEntity.setFWVG(enccVisit.getString(enccVisitKeyMap.get("FWVG")));
						enccEntity.setFWHR_PSR(enccVisit.getString(enccVisitKeyMap.get("FWHR_PSR")));
						enccEntity.setFWHRP(enccVisit.getString(enccVisitKeyMap.get("FWHRP")));
						enccEntity.setExisting_ELCO(enccVisit.getString(enccVisitKeyMap.get("existing_ELCO")));
						enccEntity.setFWENCCBLRVIS(enccVisit.getString(enccVisitKeyMap.get("FWENCCBLRVIS")));
						enccEntity.setFWENCCSWLNG(enccVisit.getString(enccVisitKeyMap.get("FWENCCSWLNG")));
						enccEntity.setFWENCCCONVL(enccVisit.getString(enccVisitKeyMap.get("FWENCCCONVL")));
						enccEntity.setFWENCCBLD(enccVisit.getString(enccVisitKeyMap.get("FWENCCBLD")));
						enccEntity.setFWENCCDS1(enccVisit.getString(enccVisitKeyMap.get("FWENCCDS1")));
						enccEntity.setFWENCCDS2(enccVisit.getString(enccVisitKeyMap.get("FWENCCDS2")));
						enccEntity.setFWENCCDS3(enccVisit.getString(enccVisitKeyMap.get("FWENCCDS3")));
						enccEntity.setFWENCCDS4(enccVisit.getString(enccVisitKeyMap.get("FWENCCDS4")));
						enccEntity.setFWENCCDS5(enccVisit.getString(enccVisitKeyMap.get("FWENCCDS5")));
						enccEntity.setFWENCCDS6(enccVisit.getString(enccVisitKeyMap.get("FWENCCDS6")));
						enccEntity.setFWDANGERVALUE(enccVisit.getString(enccVisitKeyMap.get("FWDANGERVALUE")));
						enccEntity.setFWNOTELIGIBLE(enccVisit.getString(enccVisitKeyMap.get("FWNOTELIGIBLE")));
						enccEntity.setELCO(enccVisit.getString(enccVisitKeyMap.get("ELCO")));
						enccEntity.setFWHR_ENCC(enccVisit.getString(enccVisitKeyMap.get("FWHR_ENCC")));
						enccEntity.setFWFLAGVALUE(enccVisit.getString(enccVisitKeyMap.get("FWFLAGVALUE")));
						enccEntity.setFWSORTVALUE(enccVisit.getString(enccVisitKeyMap.get("FWSORTVALUE")));
						enccEntity.setUser_type(enccVisit.getString(enccVisitKeyMap.get("user_type")));
						enccEntity.setExternal_user_ID(enccVisit.getString(enccVisitKeyMap.get("external_user_ID")));
						enccEntity.setRelationalid(enccVisit.getString(enccVisitKeyMap.get("relationalid")));
						enccEntity.setFW_GOBHHID(enccVisit.getString(enccVisitKeyMap.get("GOBHHID")));
						enccEntity.setFW_JiVitAHHID(enccVisit.getString(enccVisitKeyMap.get("FW_JiVitAHHID")));
						enccEntity.setFW_WOMBID(enccVisit.getString(enccVisitKeyMap.get("FW_WOMBID")));
						enccEntity.setFW_WOMNID(enccVisit.getString(enccVisitKeyMap.get("FW_WOMNID")));
						enccEntity.setFW_WOMFNAME(enccVisit.getString(enccVisitKeyMap.get("FW_WOMFNAME")));
						enccEntity.setFW_HUSNAME(enccVisit.getString(enccVisitKeyMap.get("FW_HUSNAME")));
						enccEntity.setMOTHER_REFERENCE_DATE(enccVisit.getString(enccVisitKeyMap.get("MOTHER_REFERENCE_DATE")));
						enccEntity.setMOTHER_REFERENCE_DATE(enccVisit.getString(enccVisitKeyMap.get("REFERENCE_DATE")));*/
			enccEntity.setSTART_DATE(DateUtil.getDateTimeFromString(enccVisit.getString(enccVisitKeyMap.get("start"))));
			enccEntity.setEND_DATE(DateUtil.getDateTimeFromString(enccVisit.getString(enccVisitKeyMap.get("end"))));
			enccEntity.setClientVersion(Long.parseLong(enccVisit.getString(enccVisitKeyMap.get("clientVersion"))));
			enccEntity.setReceived_time(enccVisit.getString(enccVisitKeyMap.get("received_time")));
			enccEntity.setTimeStamp(Long.parseLong(enccVisit.getString(enccVisitKeyMap.get("timeStamp"))));
		}
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return enccEntity;
		
	}
	
}
