package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ChildEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ChildService;
import org.opensrp.etl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildDataConverterService implements DataConverterService {
	
	@Autowired
	private ChildEntity childEntity;
	
	@Autowired
	private ChildService childService;
	
	@Autowired
	private ChildToENCCConverter childToENCCConverter;
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		try {
			JSONObject details = new JSONObject(doc.getString("details"));
			
			childEntity.setBirthDate(DateUtil.getDateFromString(details.getString("FWBNFDOB")));
			
			childEntity.setClientVersion(doc.getLong("clientVersion"));
			
			childEntity.setSubmissionTime(doc.getLong("SUBMISSIONDATE"));
			
			childEntity.setEnd(DateUtil.getDateTimeFromString(doc.getString("END")));
			
			childEntity.setStart(DateUtil.getDateTimeFromString(doc.getString("START")));
			
			childEntity.setToday(DateUtil.getDateFromString(doc.getString("TODAY")));
			
			// ? childEntity.setFirstName(doc.getString("mother_first_name"));
			
			childEntity.setCaseId(doc.getString("caseId"));
			
			childEntity.setInstanceId(doc.getString("INSTANCEID"));
			
			// ? childEntity.setLocationId(doc.getString("LOCATIONID"));
			
			childEntity.setProvider(doc.getString("PROVIDERID"));
			
			childEntity.setExternalUserId(details.getString("external_user_ID"));
			
			// ?  childEntity.setDistrict(doc.getString("district"));
			
			// ? childEntity.setMauzaPara(doc.getString("mouzaPara"));
			
			// ? childEntity.setSubunit(doc.getString("unit"));
			
			// ? childEntity.setUnion(doc.getString("union"));
			
			// ? childEntity.setUpazila(doc.getString("upazilla"));
			
			// ? childEntity.setWard(doc.getString("ward"));
			
			childEntity.setFWBNFCHLDVITSTS(details.getString("FWBNFCHLDVITSTS"));
			
			childEntity.setFWBNFNAME(details.getString("FWBNFNAME"));
			
			childEntity.setFWBNFGEN(details.getString("FWBNFGEN"));
			
			childEntity.setFWWOMFNAME(details.getString("FWWOMFNAME"));
			
			childEntity.setMotherWomAge(details.getString("mother_wom_age"));
			
			childEntity.setFWBNFCHILDNAME(details.getString("FWBNFCHILDNAME"));
			
			childEntity.setFWWOMBID(details.getString("FWWOMBID"));
			
			childEntity.setWBNFDOB(DateUtil.getDateFromString(details.getString("FWBNFDOB")));
			
			childEntity.setGOBHHID(details.getString("GOBHHID"));
			
			// ? childEntity.setJIVITAHHID(details.getString("JIVITAHHID"));
			
			childEntity.setFWBNFNAMECHECK(details.getString("FWBNFNAMECHECK"));
			
			childEntity.setFWWOMNID(details.getString("FWWOMNID"));
			
			childEntity.setFWHUSNAME(details.getString("FWHUSNAME"));
			
			childEntity.setRelationalId(details.getString("relationalid"));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		childService.save(childEntity);
		childToENCCConverter.enccVisitSave(doc);
		
	}
	
}
