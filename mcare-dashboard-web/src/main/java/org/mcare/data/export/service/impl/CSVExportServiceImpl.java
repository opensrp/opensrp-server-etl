/**
 * 
 */
package org.mcare.data.export.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.mcare.data.export.service.CoreExportService;
import org.springframework.stereotype.Service;

/**
 * @author proshanto
 */
@Service
public class CSVExportServiceImpl implements CoreExportService {
	
	@Override
	public FileWriter createHeader(FileWriter writer, List<String> headerKeys) {
		int headerSize = 0;
		for (String headerKey : headerKeys) {
			headerSize++;
			try {
				if (headerSize == headerKeys.size()) {
					writer.append(headerKey);
				} else {
					writer.append(headerKey);
					writer.append(',');
				}
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return writer;
	}
	
	@Override
	public FileWriter createContent(FileWriter writer, List<Object[]> dataSets) throws IOException {
		
		for (Object[] objects : dataSets) {
			for (int i = 0; i < objects.length; i++) {
				if (i == objects.length - 1) {
					writer.append(objects[i] + "");
					writer.append('\n');
				} else {
					
					writer.append(objects[i] + "");
					writer.append(',');
				}
			}
			
		}
		
		return writer;
	}
	
}
