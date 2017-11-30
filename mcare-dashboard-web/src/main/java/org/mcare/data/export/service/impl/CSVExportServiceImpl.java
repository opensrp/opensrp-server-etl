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
		for (String headerKey : headerKeys) {
			try {
				writer.append(headerKey);
				writer.append(',');
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return writer;
	}
	
	@Override
	public FileWriter createContent(FileWriter writer, List<Object[]> dataSets) {
		
		for (Object[] objects : dataSets) {
			for (int i = 0; i < objects.length; i++) {
				try {
					writer.append(objects[i].toString());
					writer.append(',');
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			//cleanedResults.add(objects);
		}
		
		return writer;
	}
	
}
