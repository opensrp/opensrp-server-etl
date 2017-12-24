package org.unicef.data.export.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.common.util.FormName;
import org.unicef.data.export.service.DataExportService;

@Service
public class DataExportServiceFactory {
	
	@Autowired
	private ANCDataExportServiceImpl ancDataExportServiceImpl;
	
	@Autowired
	private PNCDataExportServiceImpl pncDataExportServiceImpl;
	
	@Autowired
	private ENCCDataExportServiceImpl enccDataExportServiceImpl;
	
	private DataExportService dataExportService;
	
	public DataExportServiceFactory() {
		
	}
	
	private DataExportService setDataExportServiceWithFormName(String formName) {
		if (FormName.ancVisitOne.name().equalsIgnoreCase(formName) || FormName.ancVisitTwo.name().equalsIgnoreCase(formName)
		        || FormName.ancVisitThree.name().equalsIgnoreCase(formName)
		        || FormName.ancVisitFour.name().equalsIgnoreCase(formName)) {
			dataExportService = ancDataExportServiceImpl;
		} else if (FormName.pncVisitOne.name().equalsIgnoreCase(formName)
		        || FormName.pncVisitTwo.name().equalsIgnoreCase(formName)
		        || FormName.pncVisitThree.name().equalsIgnoreCase(formName)) {
			dataExportService = pncDataExportServiceImpl;
		} else if (FormName.enccVisitOne.name().equalsIgnoreCase(formName)
		        || FormName.enccVisitTwo.name().equalsIgnoreCase(formName)
		        || FormName.enccVisitThree.name().equalsIgnoreCase(formName)) {
			dataExportService = enccDataExportServiceImpl;
		} else {
			
		}
		
		return dataExportService;
		
	}
	
	public DataExportService getDataExportServiceWithFormName(String formName) {
		System.err.println("setDataExportServiceWithFormName(formName);" + setDataExportServiceWithFormName(formName));
		return setDataExportServiceWithFormName(formName);
	}
}
