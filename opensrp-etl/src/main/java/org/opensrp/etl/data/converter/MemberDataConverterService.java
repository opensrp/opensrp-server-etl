package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.ANCEntity;
import org.opensrp.etl.entity.MemberEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ANCService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.MemberService;
import org.opensrp.etl.util.DateUtil;
import org.opensrp.etl.util.Keys;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDataConverterService implements DataConverterService {
	
	@Autowired
	private MemberEntity memberEntity;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PSRFDataConverterService psrfDataConverterService;

	@Autowired
	private BNFDataConverterService bnfDataConverterService;

	@Autowired
	private ChildDataConverterService childDataConverterService;

	@Autowired
	private AdolescentDataConverterService adolescentDataConverterService;

	@Autowired
	private InjectableDataConverterService injectableDataConverterService;

	@Autowired
	private ExceptionService exceptionService;

	@Autowired
	private DataConverter dataConverter;

	@Autowired
	private ANCService ancService;

	@Autowired
	private ANCEntity ancEntity;

	@Autowired
	private PNCDataConverterService pncDataConverterService;

	@Autowired
	private NutritionDataConverterService nutritionDataConverterService;

	public MemberDataConverterService() {
		
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		
		/*Class<MemberEntity> className = MemberEntity.class;
		Object object = memberEntity;
		memberEntity = (MemberEntity) dataConverter.convert(doc, className, object);
		try {
			JSONObject details = doc.getJSONObject("details");
			memberEntity.setStart(DateUtil.getDateTimeFromString(details, "start"));
			memberEntity.setEnd(DateUtil.getDateTimeFromString(details, "end"));
			memberEntity.setRelationalid(details.getString("womanrelationalid"));
			memberService.save(memberEntity);
			
		}
		catch (Exception e) {
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), Keys.MEMBER.name());
		}
		
		Class<ANCEntity> ANCEntity = ANCEntity.class;
		Object ancObject = ancEntity;
		
		JSONObject anc1VisitDoc = new JSONObject(doc.getString("ANCVisit1").toString());
		
		if (anc1VisitDoc.length() != 0) {
			
			ancEntity = (ANCEntity) dataConverter.convert(anc1VisitDoc, ANCEntity, ancObject);
			
			ancEntity.setAncName(Keys.ANC1.name());
			ancEntity.setrelationalid(doc.getString("caseId"));
			ancService.save(ancEntity);
		}
		JSONObject anc2VisitDoc = new JSONObject(doc.getJSONObject("ANCVisit2").toString());
		
		if (anc2VisitDoc.length() != 0) {
			ancEntity = (ANCEntity) dataConverter.convert(anc2VisitDoc, ANCEntity, ancObject);
			ancEntity.setAncName(Keys.ANC2.name());
			ancEntity.setrelationalid(doc.getString("caseId"));
			ancService.save(ancEntity);
		}
		JSONObject anc3VisitDoc = new JSONObject(doc.getJSONObject("ANCVisit3").toString());
		
		if (anc3VisitDoc.length() != 0) {
			ancEntity = (ANCEntity) dataConverter.convert(anc3VisitDoc, ANCEntity, ancObject);
			ancEntity.setAncName(Keys.ANC3.name());
			ancEntity.setrelationalid(doc.getString("caseId"));
			ancService.save(ancEntity);
		}
		JSONObject anc4VisitDoc = new JSONObject(doc.getJSONObject("ANCVisit4").toString());
		
		if (anc4VisitDoc.length() != 0) {
			ancEntity = (ANCEntity) dataConverter.convert(anc4VisitDoc, ANCEntity, ancObject);
			ancEntity.setAncName(Keys.ANC4.name());
			ancEntity.setrelationalid(doc.getString("caseId"));
			ancService.save(ancEntity);
		}*/

		//pncDataConverterService.convertToEntityAndSave(doc);
		//nutritionDataConverterService.convertToEntityAndSave(doc);
		//psrfDataConverterService.convertToEntityAndSave(doc);
		//bnfDataConverterService.convertToEntityAndSave(doc);
		//childDataConverterService.convertToEntityAndSave(doc);
		//adolescentDataConverterService.convertToEntityAndSave(doc);
		injectableDataConverterService.convertToEntityAndSave(doc);
	}
	
}
