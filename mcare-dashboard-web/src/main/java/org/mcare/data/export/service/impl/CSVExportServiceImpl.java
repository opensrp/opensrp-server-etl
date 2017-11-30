/**
 * 
 */
package org.mcare.data.export.service.impl;

import java.io.FileWriter;
import java.util.Map;

import org.mcare.data.export.service.CoreExportService;

/**
 * @author proshanto
 */
public class CSVExportServiceImpl implements CoreExportService {
	
	@Override
	public FileWriter createHeader(FileWriter writer, Map<String, String> headerKeys) {
		for (int i = 0; i < headerKeys.size(); i++) {
			
		}
		return writer;
	}
	
	@Override
	public FileWriter createContent(FileWriter writer, Map<String, String> headerKeys) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
