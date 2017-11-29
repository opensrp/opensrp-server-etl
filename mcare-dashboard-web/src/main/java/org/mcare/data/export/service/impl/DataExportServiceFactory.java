package org.mcare.data.export.service.impl;

import org.mcare.common.util.FormName;
import org.mcare.data.export.service.DataExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		if (FormName.ANC.name().equalsIgnoreCase(formName)) {
			dataExportService = ancDataExportServiceImpl;
		} else if (FormName.PNC.name().equalsIgnoreCase(formName)) {
			dataExportService = pncDataExportServiceImpl;
		} else if (FormName.ENCC.name().equalsIgnoreCase(formName)) {
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
