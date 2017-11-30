package org.mcare.data.export.service;

import java.io.FileWriter;
import java.util.List;

public interface CoreExportService {
	
	public FileWriter createHeader(FileWriter writer, List<String> headerKeys);
	
	public FileWriter createContent(FileWriter writer, List<Object[]> dataSets);
	
}
