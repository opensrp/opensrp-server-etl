package org.mcare.data.export.service;

import java.io.FileWriter;
import java.util.Map;

public interface CoreExportService {
	
	public FileWriter createHeader(FileWriter writer, Map<String, String> headerKeys);
	
	public FileWriter createContent(FileWriter writer, Map<String, String> headerKeys);
	
}
