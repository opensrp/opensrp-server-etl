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

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.common.util.ExportKeyMapperSetup;
import org.mcare.data.export.entity.DataExportEntity;
import org.mcare.data.export.service.DataExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author proshanto
 */

@Service
public class ANCDataExportServiceImpl implements DataExportService {
	
	@Autowired
	private DataExportRepository dataExportRepository;
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Autowired
	private DataExportEntity dataExportEntity;
	
	@Autowired
	private CSVExportServiceImpl csvExportServiceImpl;
	
	@Override
	public void export(List<Object[]> dataSets, HttpServletResponse response) {
		String reportName = "anc" + System.currentTimeMillis() + ".csv";
		response.setContentType("text/csv");
		response.setHeader("Content-disposition", "attachment; " + "filename=" + "a");
		FileWriter writer;
		
		try {
			writer = new FileWriter("/opt/multimedia" + "/export/" + reportName);
			csvExportServiceImpl.createHeader(writer, ExportKeyMapperSetup.ANC);
			
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
	public List<Object[]> getData(Date start, Date end, String provider, String formName) {
		String condition = "";
		
		condition = "anc.fwancdate between '" + start + "'and'" + end + "' ";
		condition = condition + " and anc.ancname = :formName ";
		
		if (!provider.isEmpty()) {
			condition = condition + "and mother.provider=:provider";
		}
		String sqlQuery = "select anc.fw_gobhhid,anc.fw_jivitahhid,anc.fwwombid,anc.fwwomnid,anc.fwwomfname,anc.fwhusname,mother.motherwomlmp,anc.fwvg ,"
		        + "anc.fwhr_psr , anc.fwhrp , anc.fwdangervalue , anc.existing_elco , anc.today , anc.start , anc.end_time , anc.fwancdate ,anc.fwgestationalage ,anc.fwedd ,"
		        + "anc.fwancremsts ,anc.fwancint ,anc.fwancknwprvdr  ,anc.fwancanm ,anc.fwanchbp,anc.fwancdbt ,anc.fwancthy , anc.fwancprob ,anc.fwanchead ,"
		        + "anc.fwancblrvis ,anc.fwancswlng ,anc.fwancbld ,anc.fwancconvl , anc.fwancds1 , anc.fwancds2 ,anc.fwancds3 , anc.fwancds4,anc.fwancds5,anc.fwancds6 ,"
		        
		        + "anc.fwnoteligible ,anc.fwhr_anc ,anc.fwflagvalue ,anc.fwsortvalue ,anc.user_type ,anc.external_user_id , anc.anc_current_formstatus , anc.relationalid "
		        + " from anc inner join mother on anc.relationalid =mother.case_id where " + condition;
		
		return dataExportRepository.executeSelectQuery(provider, formName, sqlQuery);
		
	}
	
	@SuppressWarnings("resource")
	@Transactional
	@Override
	public String createCSVAndSave(List<Object[]> dataSets, HttpServletResponse response, String formName) {
		String reportName = formName + System.currentTimeMillis() + ".csv";
		response.setContentType("text/csv");
		response.setHeader("Content-disposition", "attachment; " + "filename=" + "a");
		FileWriter writer;
		
		try {
			writer = new FileWriter("/opt/multimedia" + "/export/" + reportName);
			
			writer = csvExportServiceImpl.createHeader(writer, ExportKeyMapperSetup.ANC);
			
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
		dataExportEntity.setUser(SecurityContextHolder.getContext().getAuthentication().getName());
		databaseRepositoryImpl.save(dataExportEntity);
		return reportName;
	}
	
}
