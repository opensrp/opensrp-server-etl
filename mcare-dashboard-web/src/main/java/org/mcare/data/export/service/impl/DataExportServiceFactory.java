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
		if (FormName.ancrv_1.name().equalsIgnoreCase(formName) || FormName.ancrv_2.name().equalsIgnoreCase(formName)
		        || FormName.ancrv_3.name().equalsIgnoreCase(formName) || FormName.ancrv_4.name().equalsIgnoreCase(formName)) {
			dataExportService = ancDataExportServiceImpl;
		} else if (FormName.pncrv_1.name().equalsIgnoreCase(formName) || FormName.pncrv_2.name().equalsIgnoreCase(formName)
		        || FormName.pncrv_3.name().equalsIgnoreCase(formName)) {
			dataExportService = pncDataExportServiceImpl;
		} else if (FormName.enccrv_1.name().equalsIgnoreCase(formName)
		        || FormName.enccrv_2.name().equalsIgnoreCase(formName)
		        || FormName.enccrv_3.name().equalsIgnoreCase(formName)) {
			dataExportService = enccDataExportServiceImpl;
		} else {
			
		}
		
		return dataExportService;
		
	}
	
	public DataExportService getDataExportServiceWithFormName(String formName) {
		return setDataExportServiceWithFormName(formName);
	}
}
