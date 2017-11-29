/**
 * 
 */
package org.mcare.data.export.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.mcare.data.export.service.DataExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author proshanto
 */

@Service
public class ANCDataExportServiceImpl implements DataExportService {
	
	@Autowired
	private DataExportRepository dataExportRepository;
	
	@Override
	public void export(List<Object[]> dataSets, HttpServletResponse response) {
		String reportName = "anc" + System.currentTimeMillis() + ".csv";
		response.setContentType("text/csv");
		response.setHeader("Content-disposition", "attachment; " + "filename=" + "a");
		FileWriter writer;
		
		try {
			writer = new FileWriter("/opt/multimedia" + "/export/" + reportName);
			writer.append("Beneficiary Name");
			writer.append(',');// 1
			writer.append("Identifier");
			writer.append(',');// 1
			writer.append("Schedule Status");
			writer.append(',');// 4
			writer.append("FWA Name");
			writer.append(',');// 5
			writer.append("Upazilla");
			writer.append(',');// 6
			
			writer.append('\n'); // 22
			
			writer.append("Beneficiary Name");
			writer.append(',');
			writer.append("Identifier Name");
			writer.append(',');
			writer.append("Schedule Name");
			writer.append(',');
			writer.append("FWA Name");
			writer.append(',');
			writer.append("Upazilla Name");
			writer.append('\n');
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Transactional
	@Override
	public List<Object[]> getData(Date start, Date end, String provider) {
		return dataExportRepository.executeSelectQuery("");
		
	}
	
}
