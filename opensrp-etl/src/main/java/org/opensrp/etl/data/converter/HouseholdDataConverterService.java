package org.opensrp.etl.data.converter;

import org.json.JSONObject;
import org.opensrp.etl.entity.HouseholdEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.HouseholdService;
import org.opensrp.etl.util.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdDataConverterService implements DataConverterService {
	
	public HouseholdDataConverterService() {
		
	}
	
	@Autowired
	private HouseholdService householdService;
	
	@Autowired
	private HouseholdEntity householdEntity;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) {
		Class<HouseholdEntity> className = HouseholdEntity.class;
		Object object = householdEntity;
		householdEntity = (HouseholdEntity) dataConverter.convert(doc, className, object);
		try {
			householdService.save(householdEntity);
		}
		catch (Exception e) {
		    e.printStackTrace();
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), Keys.HOUSEHOLD.name());
		}
	}
}
