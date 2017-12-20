package org.unicef.etl.transmission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.etl.interfaces.TransmissionServices;

@Service
public class TransmissionServiceFactory {
	
	public TransmissionServiceFactory() {
		
	}
	
	@Autowired
	private ActionTransmissionService actionTransmissionService;
	
	@Autowired
	private ClientTransmissionService clientTransmissionService;
	
	@Autowired
	private EventTransmissionService eventTransmissionService;
	
	private TransmissionServices transmissionServices;
	
	private TransmissionServices getTransmissionService(String transmissionServiceType) {
		if (transmissionServiceType.equals("Client")) {
			transmissionServices = clientTransmissionService;
		} else if (transmissionServiceType.equals("Event")) {
			transmissionServices = eventTransmissionService;
		} else if (transmissionServiceType.equals("Action")) {
			transmissionServices = actionTransmissionService;
		} else {
			transmissionServices = null;
			
		}
		return transmissionServices;
		
	}
	
	public TransmissionServices getTransmissionType(String transmissionType) {
		return getTransmissionService(transmissionType);
	}
	
}
