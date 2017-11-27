package org.opensrp.etl.transmission.service;

import org.opensrp.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

public class TransmissionServiceFactory {
	
	@Autowired
	private HouseholdTransmissionService householdTransmissionService;
	
	@Autowired
	private MemberTransmissionService memberTransmissionService;
	
	@Autowired
	private ActionTransmissionService actionTransmissionService;
	
	private TransmissionServices transmissionServices;
	
	private TransmissionServices getTransmissionService(String transmissionServiceType) {
		if (transmissionServiceType.equals("HouseHold"))
			transmissionServices = householdTransmissionService;
		else if (transmissionServiceType.equals("Members"))
			transmissionServices = memberTransmissionService;
		else if (transmissionServiceType.equals("Action"))
			transmissionServices = actionTransmissionService;
		return transmissionServices;
		
	}
	
	public TransmissionServices getTransmissionType(String transmissionType) {
		return getTransmissionService(transmissionType);
	}
	
}
