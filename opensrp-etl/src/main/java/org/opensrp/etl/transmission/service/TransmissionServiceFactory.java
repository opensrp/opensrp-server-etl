package org.opensrp.etl.transmission.service;

import org.opensrp.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;

public class TransmissionServiceFactory {
	
	@Autowired
	private HouseholdTransmissionService householdTransmissionService;
	
	@Autowired
	private ElcoTransmissionService elcoTransmissionService;
	
	@Autowired
	private MotherTransmissionService motherTransmissionService;
	
	@Autowired
	private ChildTransmissionService childTransmissionService;
	
	@Autowired
	private ActionTransmissionService actionTransmissionService;
	
	private TransmissionServices transmissionServices;
	
	private TransmissionServices getTransmissionService(String transmissionServiceType) {
		if (transmissionServiceType.equals("HouseHold"))
			transmissionServices = householdTransmissionService;
		else if (transmissionServiceType.equals("Elco"))
			transmissionServices = elcoTransmissionService;
		else if (transmissionServiceType.equals("Mother"))
			transmissionServices = motherTransmissionService;
		else if (transmissionServiceType.equals("Child"))
			transmissionServices = childTransmissionService;
		else if (transmissionServiceType.equals("Action"))
			transmissionServices = actionTransmissionService;
		return transmissionServices;
		
	}
	
	public TransmissionServices getTransmissionType(String transmissionType) {
		return getTransmissionService(transmissionType);
	}
	
}
