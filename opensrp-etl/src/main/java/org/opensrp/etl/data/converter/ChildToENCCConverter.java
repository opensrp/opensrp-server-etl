/**
 * 
 */
package org.opensrp.etl.data.converter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ENCCEntity;
import org.opensrp.etl.service.ENCCService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sohel
 * @author proshanto
 */
public class ChildToENCCConverter {
	
	private static final String ENCC = "ENC";
	
	private static final String ENCC_Visit_One = "enccVisitOne";
	
	private static final String ENCC_Visit_Two = "enccVisitTwo";
	
	private static final String ENCC_Visit_Three = "enccVisitThree";
	
	private ArrayList<String> enccKeys = new ArrayList<String>();
	
	private Map<String, String> enccVisitKeyMap = new HashMap<String, String>();
	
	@Autowired
	private ENCCEntity enccEntity;
	
	@Autowired
	private ENCCService enccService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	private void setENCCKeys() {
		enccKeys.add("enccName");
		
		enccKeys.add("FWENCDATE");
		
		enccKeys.add("encc_current_formStatus");
		
		enccKeys.add("FWENCSTS");
		enccKeys.add("FWENCBFINTN");
		enccKeys.add("FWENCPRLCTL");
		enccKeys.add("FWENCDRYWM");
		enccKeys.add("FWENCHDCOV");
		enccKeys.add("FWENCBTHD");
		enccKeys.add("FWENCUMBS");
		enccKeys.add("FWENCDSFVRCLD");
		enccKeys.add("FWENCTEMP");
		enccKeys.add("FWENCDSFOULUMBS");
		enccKeys.add("FWENCDSLIMBLUE");
		enccKeys.add("FWENCDSSKNYLW");
		enccKeys.add("FWENCDSLETH");
		enccKeys.add("FWENCDSDIFBRTH");
		
		enccKeys.add("FWENCDSCONVL");
		enccKeys.add("FWENCDELCOMP");
		enccKeys.add("FWENCDELCOMP");
		enccKeys.add("start");
		
		enccKeys.add("end");
		
		enccKeys.add("clientVersion");
		
		enccKeys.add("received_time");
		
		enccKeys.add("timeStamp");
		enccKeys.add("today");
	}
	
	private Map<String, String> getENCCVisitKeys(String visitNo) {
		for (String enccKey : enccKeys) {
			if (enccKey.toUpperCase().contains(ENCC)) {
				String encc = enccKey
				        .substring(enccKey.toUpperCase().indexOf(ENCC), enccKey.toUpperCase().indexOf(ENCC) + 3);
				enccVisitKeyMap.put(enccKey, enccKey.replaceFirst(encc, encc.concat(visitNo)));
			} else {
				enccVisitKeyMap.put(enccKey, enccKey);
			}
		}
		return enccVisitKeyMap;
	}
	
	public void enccVisitSave(JSONObject mdoc) throws JSONException, ParseException {
		setENCCKeys();
		try {
			
			if (mdoc.has(ENCC_Visit_One) && mdoc.isNull(ENCC_Visit_One) || mdoc.getJSONObject(ENCC_Visit_One).length() == 0) {
				
			} else {
				JSONObject enccVisitOne = new JSONObject(mdoc.getString(ENCC_Visit_One));
				Map<String, String> enccVisitKeyMap = new HashMap<String, String>();
				enccVisitKeyMap = getENCCVisitKeys("1");
				enccEntity.setEnccName(ENCC_Visit_One);
				enccService.save(convertToAncEntity(enccVisitOne, enccVisitKeyMap, mdoc.get("caseId").toString()));
				
			}
			
			if (mdoc.has(ENCC_Visit_Two) && mdoc.isNull(ENCC_Visit_Two) || mdoc.getJSONObject(ENCC_Visit_Two).length() == 0) {
				
			} else {
				JSONObject enccVisitOne = new JSONObject(mdoc.getString(ENCC_Visit_Two));
				Map<String, String> enccVisitKeyMap = new HashMap<String, String>();
				enccVisitKeyMap = getENCCVisitKeys("2");
				enccEntity.setEnccName(ENCC_Visit_Two);
				enccService.save(convertToAncEntity(enccVisitOne, enccVisitKeyMap, mdoc.get("caseId").toString()));
				
			}
			
			if (mdoc.has(ENCC_Visit_Three) && mdoc.isNull(ENCC_Visit_Three)
			        || mdoc.getJSONObject(ENCC_Visit_Three).length() == 0) {
				
			} else {
				JSONObject enccVisit = new JSONObject(mdoc.getString(ENCC_Visit_Three));
				Map<String, String> enccVisitKeyMap = new HashMap<String, String>();
				enccVisitKeyMap = getENCCVisitKeys("3");
				enccEntity.setEnccName(ENCC_Visit_Three);
				enccService.save(convertToAncEntity(enccVisit, enccVisitKeyMap, mdoc.get("caseId").toString()));
				
			}
			
		}
		catch (JSONException e) {
			exceptionService.generatedEntityAndSave(mdoc, e.fillInStackTrace().toString(), "ENCC");
		}
		catch (ParseException e) {
			exceptionService.generatedEntityAndSave(mdoc, e.fillInStackTrace().toString(), "ENCC");
		}
		catch (NumberFormatException e) {
			exceptionService.generatedEntityAndSave(mdoc, e.fillInStackTrace().toString(), "ENCC");
		}
		
	}
	
	private String replace(String str) {
		str = str.replace("enc", "encc");
		str = str.replace("c_current", "_current");
		return str;
	}
	
	private ENCCEntity convertToAncEntity(JSONObject enccVisit, Map<String, String> enccVisitKeyMap, String caseId)
	    throws JSONException, ParseException {
		enccEntity.setFWENCCDATE(DateUtil.getDateFromString(enccVisit, enccVisitKeyMap.get("FWENCDATE")));
		
		enccEntity.setEncc_current_formStatus(enccVisit.getString(replace(enccVisitKeyMap.get("encc_current_formStatus"))));
		enccEntity.setFWENCCSTS(enccVisit.getString(enccVisitKeyMap.get("FWENCSTS")));
		enccEntity.setFWENCCBFINTN(enccVisit.getString(enccVisitKeyMap.get("FWENCBFINTN")));
		enccEntity.setFWENCCPRLCTL(enccVisit.getString(enccVisitKeyMap.get("FWENCPRLCTL")));
		enccEntity.setFWENCCDRYWM(enccVisit.getString(enccVisitKeyMap.get("FWENCDRYWM")));
		
		enccEntity.setFWENCCHDCOV(enccVisit.getString(enccVisitKeyMap.get("FWENCHDCOV")));
		enccEntity.setFWENCCBTHD(enccVisit.getString(enccVisitKeyMap.get("FWENCBTHD")));
		
		enccEntity.setFWENCCUMBS(enccVisit.getString(enccVisitKeyMap.get("FWENCUMBS")));
		enccEntity.setFWENCCDSFVRCLD(enccVisit.getString(enccVisitKeyMap.get("FWENCDSFVRCLD")));
		enccEntity.setFWENCCTEMP(enccVisit.getString(enccVisitKeyMap.get("FWENCTEMP")));
		enccEntity.setFWENCCDSFOULUMBS(enccVisit.getString(enccVisitKeyMap.get("FWENCDSFOULUMBS")));
		
		enccEntity.setFWENCCDSLIMBLUE(enccVisit.getString(enccVisitKeyMap.get("FWENCDSLIMBLUE")));
		enccEntity.setFWENCCDSSKNYLW(enccVisit.getString(enccVisitKeyMap.get("FWENCDSSKNYLW")));
		enccEntity.setFWENCCDSLETH(enccVisit.getString(enccVisitKeyMap.get("FWENCDSLETH")));
		
		enccEntity.setFWENCCDSDIFBRTH(enccVisit.getString(enccVisitKeyMap.get("FWENCDSDIFBRTH")));
		enccEntity.setFWENCCDSCONVL(enccVisit.getString(enccVisitKeyMap.get("FWENCDSCONVL")));
		enccEntity.setFWENCCDELCOMP(enccVisit.getString(enccVisitKeyMap.get("FWENCDELCOMP")));
		enccEntity.setFWENCCDELCOMP(enccVisit.getString(enccVisitKeyMap.get("FWENCDELCOMP")));
		
		enccEntity.setSTART_DATE(DateUtil.getDateTimeFromString(enccVisit, enccVisitKeyMap.get("start")));
		enccEntity.setEND_DATE(DateUtil.getDateTimeFromString(enccVisit, enccVisitKeyMap.get("end")));
		enccEntity.setClientVersion(Long.parseLong(enccVisit.getString(enccVisitKeyMap.get("clientVersion"))));
		enccEntity.setReceived_time(enccVisit.getString(enccVisitKeyMap.get("received_time")));
		enccEntity.setTimeStamp(Long.parseLong(enccVisit.getString(enccVisitKeyMap.get("timeStamp"))));
		enccEntity.setToday(DateUtil.getDateFromString(enccVisit, "today"));
		enccEntity.setRelationalId(caseId);
		
		return enccEntity;
		
	}
}
