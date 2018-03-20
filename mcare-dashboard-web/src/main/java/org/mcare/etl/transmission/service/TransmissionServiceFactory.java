package org.mcare.etl.transmission.service;

import org.mcare.etl.interfaces.TransmissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransmissionServiceFactory {
	public TransmissionServiceFactory(){

	}
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
		if (transmissionServiceType.equals("HouseHold")) {
			transmissionServices = householdTransmissionService;
		}
		else if (transmissionServiceType.equals("Elco")) {
			transmissionServices = elcoTransmissionService;
		}
		else if (transmissionServiceType.equals("Mother")) {
			transmissionServices = motherTransmissionService;
		}
		else if (transmissionServiceType.equals("Child")) {
			transmissionServices = childTransmissionService;
		}
		else if (transmissionServiceType.equals("Action")) {
			transmissionServices = actionTransmissionService;
		}
		else {
			transmissionServices=null;

		}

		return transmissionServices;

	}

	public TransmissionServices getTransmissionType(String transmissionType) {
		return getTransmissionService(transmissionType);
	}

}
