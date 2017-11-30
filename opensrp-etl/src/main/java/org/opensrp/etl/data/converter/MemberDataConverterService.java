package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.MemberEntity;
import org.opensrp.etl.interfaces.DataConverterService;
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
	private ANCDataConverterService ancDataConverterService;

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
	private PNCDataConverterService pncDataConverterService;

	@Autowired
	private NutritionDataConverterService nutritionDataConverterService;

	public MemberDataConverterService() {
		
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		Class<MemberEntity> className = MemberEntity.class;
		Object object = memberEntity;
		memberEntity = (MemberEntity) dataConverter.convert(doc, className, object);
		memberEntity.setcaseId(doc.getString("caseId"));
		try {
			memberService.save(memberEntity);
		}
		catch (Exception e) {
			//exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), Keys.HOUSEHOLD.name());
		}

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
		}*/

		pncDataConverterService.convertToEntityAndSave(doc);
		nutritionDataConverterService.convertToEntityAndSave(doc);
		psrfDataConverterService.convertToEntityAndSave(doc);
		bnfDataConverterService.convertToEntityAndSave(doc);
		childDataConverterService.convertToEntityAndSave(doc);
		adolescentDataConverterService.convertToEntityAndSave(doc);
		injectableDataConverterService.convertToEntityAndSave(doc);
		ancDataConverterService.convertToEntityAndSave(doc);
	}
	
}
