package org.opensrp.etl.data.converter;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.MemberEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDataConverterService implements DataConverterService {
	
	private static final Logger logger = Logger.getLogger(MemberDataConverterService.class);
	
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
	private DeathRegDataConverterService deathRegDataConverterService;
	
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
		Object object = new MemberEntity();
		memberEntity = (MemberEntity) dataConverter.convert(doc, className, object);
		try {
			memberService.save(memberEntity);
		}
		catch (Exception e) {
			logger.error(e);
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), "member");
		}
		
		pncDataConverterService.convertToEntityAndSave(doc);
		nutritionDataConverterService.convertToEntityAndSave(doc);
		psrfDataConverterService.convertToEntityAndSave(doc);
		bnfDataConverterService.convertToEntityAndSave(doc);
		childDataConverterService.convertToEntityAndSave(doc);
		adolescentDataConverterService.convertToEntityAndSave(doc);
		injectableDataConverterService.convertToEntityAndSave(doc);
		ancDataConverterService.convertToEntityAndSave(doc);
		deathRegDataConverterService.convertToEntityAndSave(doc);
	}
	
}
