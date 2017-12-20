package org.unicef.data.export.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public interface CoreExportService {
	
	public FileWriter createHeader(FileWriter writer, List<String> headerKeys);
	
	public FileWriter createContent(FileWriter writer, List<Object[]> dataSets) throws IOException;
	
}
