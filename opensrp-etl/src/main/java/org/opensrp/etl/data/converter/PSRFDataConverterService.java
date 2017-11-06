package org.opensrp.etl.data.converter;

import java.text.ParseException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.PSRFEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.PSRFService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class PSRFDataConverterService implements DataConverterService {
	
	@Autowired
	private PSRFEntity psrfEntity;
	
	@Autowired
	private PSRFService psrfService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Override
	public void convertToEntityAndSave(JSONObject elco) throws JSONException {
		JSONArray psrf = new JSONArray();
		psrf = elco.getJSONArray("PSRFDETAILS");
		
		for (int i = 0; i < psrf.length(); i++) {
			JSONObject doc = psrf.getJSONObject(i);
			
			try {
				psrfEntity.setRelationalId(elco.getString("caseId"));
				psrfEntity.setExternalUserId(elco.getString("external_user_ID"));
				psrfEntity.setProvider(elco.getString("PROVIDERID"));
				psrfEntity.setUserType(elco.getString("user_type"));
				psrfEntity.setFWPSRSTS(doc.getString("FWPSRSTS"));
				
				psrfEntity.setFWPSRDATE(DateUtil.getDateFromString(doc, "FWPSRDATE"));
				
				psrfEntity.setFWCONFIRMATION(doc.getString("FWCONFIRMATION"));
				psrfEntity.setFWPSRPREGSTS(doc.getString("FWPSRPREGSTS"));
				psrfEntity.setFWPSRPREGWTD(doc.getString("FWPSRPREGWTD"));
				psrfEntity.setFWPSREVRPREG(doc.getString("FWPSREVRPREG"));
				psrfEntity.setFWPSRTOTBIRTH(doc.getString("FWPSRTOTBIRTH"));
				psrfEntity.setFWPSRNBDTH(doc.getString("FWPSRNBDTH"));
				psrfEntity.setFWPSRPRSB(doc.getString("FWPSRPRSB"));
				psrfEntity.setFWPSRPRMC(doc.getString("FWPSRPRMC"));
				psrfEntity.setFWPSRPREGTWYRS(doc.getString("FWPSRPREGTWYRS"));
				psrfEntity.setFWPSRPRVPREGCOMP(doc.getString("FWPSRPRVPREGCOMP"));
				psrfEntity.setFWPSRPRCHECKS(doc.getString("FWPSRPRCHECKS"));
				psrfEntity.setFWPSRVDGMEM(doc.getString("FWPSRVDGMEM"));
				psrfEntity.setFWPSRWOMEDU(doc.getString("FWPSRWOMEDU"));
				psrfEntity.setFWPSRHHLAT(doc.getString("FWPSRHHLAT"));
				psrfEntity.setFWPSRHHRICE(doc.getString("FWPSRHHRICE"));
				psrfEntity.setFWPSRANM(doc.getString("FWPSRANM"));
				psrfEntity.setFWPSRHBP(doc.getString("FWPSRHBP"));
				psrfEntity.setFWPSRDBT(doc.getString("FWPSRDBT"));
				psrfEntity.setFWPSRTHY(doc.getString("FWPSRTHY"));
				psrfEntity.setFWPSRHGT(doc.getString("FWPSRHGT"));
				psrfEntity.setFWPSRMUAC(doc.getString("FWPSRMUAC"));
				psrfEntity.setFWPSRPHONE(doc.getString("FWPSRPHONE"));
				psrfEntity.setFWPSRPHONENUM(doc.getString("FWPSRPHONENUM"));
				psrfEntity.setFWVG(doc.getString("FWVG"));
				psrfEntity.setFWHRP(doc.getString("FWHRP"));
				psrfEntity.setFWHRPSR(doc.getString("FWHR_PSR"));
				psrfEntity.setFWFLAGVALUE(doc.getString("FWFLAGVALUE"));
				psrfEntity.setFWSORTVALUE(doc.getString("FWSORTVALUE"));
				
				psrfEntity.setFWPSRLMP(DateUtil.getDateFromString(doc, "FWPSRLMP"));
				psrfEntity.setStart(DateUtil.getDateTimeFromString(doc, "start"));
				psrfEntity.setFWPSRHUSPREGWTD(doc.getString("FWPSRHUSPREGWTD"));
				psrfEntity.setEnd(DateUtil.getDateTimeFromString(doc, "end"));
				psrfEntity.setToday(DateUtil.getDateFromString(doc, "today"));
				psrfEntity.setExisting_ELCO(Integer.parseInt(doc.getString("existing_ELCO")));
				psrfEntity.setFWNOTELIGIBLE(doc.getString("FWNOTELIGIBLE"));
				psrfEntity.setELCO(Integer.parseInt(doc.getString("ELCO")));
				psrfEntity.setFWELIGIBLE(doc.getString("FWELIGIBLE"));
				psrfEntity.setCurrent_formStatus(doc.getString("current_formStatus"));
				psrfEntity.setClientVersion(Long.parseLong(doc.getString("clientVersion")));
				if (doc.has("received_time") && !doc.getString("received_time").isEmpty()) {
					psrfEntity.setReceived_time(doc.getString("received_time"));
				} else {
					psrfEntity.setReceived_time(null);
				}
				psrfEntity.setTimeStamp(Long.parseLong(doc.getString("timeStamp")));
				psrfService.save(psrfEntity);
			}
			catch (NumberFormatException e) {
				exceptionService.generatedEntityAndSave(elco, e.fillInStackTrace().toString(), "psrf");
			}
			catch (ParseException e) {
				exceptionService.generatedEntityAndSave(elco, e.fillInStackTrace().toString(), "psrf");
			}
			
		}
		
	}
}
