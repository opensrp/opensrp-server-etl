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

import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.mcare.common.util.ExportKeyMapperSetup;
import org.mcare.data.export.entity.DataExportEntity;
import org.mcare.data.export.service.DataExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author proshanto
 */

@Service
public class PNCDataExportServiceImpl implements DataExportService {
	
	@Autowired
	private DataExportRepository dataExportRepository;
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Autowired
	private DataExportEntity dataExportEntity;
	
	@Autowired
	private CSVExportServiceImpl csvExportServiceImpl;
	
	public PNCDataExportServiceImpl() {
		
	}
	
	@Override
	public void export(List<Object[]> dataSets, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public List<Object[]> getData(Date start, Date end, String provider, String formName) {
		String condition = "";
		
		condition = "pnc.fwpncdate between '" + start + "'and'" + end + "' ";
		condition = condition + " and pnc.pncname = :formName ";
		
		if (!provider.isEmpty()) {
			condition = condition + "and mother.provider=:provider";
		}
		String sqlQuery = "select pnc.fw_gobhhid,pnc.fw_jivitahhid,pnc.fw_womfname,pnc.fw_husname,pnc.fw_womnid,pnc.fw_wombid,pnc.fwbnfdtoo,pnc.fwbnfsts ,"
		        + "pnc.today , pnc.start , pnc.end_time , pnc.fwpncdate , pnc.fwpncremsts , pnc.fwpncint , pnc.fwpncknwprvdr , pnc.fwpncdngrsign ,pnc.fwpncdelcomp ,pnc.fwpncdeltype, "
		        + "pnc.user_type ,pnc.pnc_current_formstatus ,pnc.relationalid  "
		        + " from pnc inner join mother on pnc.relationalid =mother.case_id where " + condition;
		
		return dataExportRepository.executeSelectQuery(provider, formName, sqlQuery);
	}
	
	@Transactional
	@SuppressWarnings("resource")
	@Override
	public String createCSVAndSave(List<Object[]> dataSets, HttpServletResponse response, String formName) {
		String reportName = formName + System.currentTimeMillis() + ".csv";
		response.setContentType("text/csv");
		response.setHeader("Content-disposition", "attachment; " + "filename=" + "a");
		FileWriter writer;
		
		try {
			writer = new FileWriter("/opt/multimedia" + "/export/" + reportName);
			
			writer = csvExportServiceImpl.createHeader(writer, ExportKeyMapperSetup.PNC);
			
			writer.append('\n'); // 22
			writer = csvExportServiceImpl.createContent(writer, dataSets);
			
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		dataExportEntity.setFormName(formName);
		dataExportEntity.setReportName(reportName);
		dataExportEntity.setUser("Admin");
		databaseRepositoryImpl.save(dataExportEntity);
		return reportName;
		
	}
	
}
