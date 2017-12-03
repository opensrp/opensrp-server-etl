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
import org.mcare.common.util.FormName;
import org.mcare.data.export.entity.DataExportEntity;
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
	public List<Object[]> getData(Date start, Date end, String provider) {
		String condition = "";
		
		if (start != null) {
			condition = "anc.fwancdate between '" + start + "'and'" + end + "' ";
		}
		
		if (!provider.isEmpty()) {
			condition = condition + "and mother.provider=:provider";
		}
		String sqlQuery = "select mother.case_id,anc.fwancanm,anc.fwancbld,anc.fwancblrvis,anc.fwancconvl,anc.fwancdate,anc.fwancdbt,anc.fwancds1,anc.fwancds2 ,"
		        + "anc.fwancds3 , anc.fwancds4 , anc.fwancds5 , anc.fwancds6 , anc.fwanchbp , anc.fwanchead , anc.fwancint , anc.fwancknwprvdr ,anc.fwancprob ,anc.fwancremsts ,"
		        + "anc.fwancswlng ,anc.fwancthy ,anc.fwbpcasstlab ,anc.fwbpcblddnr , anc.fwbpcbldgrp , anc.fwbpcfinargmt ,anc.fwbpclocofdel , anc.fwbpctrnsprt ,"
		        + "anc.fwconfirmation ,anc.fwdangervalue ,anc.fwedd  ,anc.fwflagvalue ,anc.fwgestationalage,anc.fwhrp ,anc.fwhr_anc , anc.fwhr_psr ,anc.fwhusname ,"
		        + "anc.fwnoteligible,anc.fwsortvalue ,anc.fwvg ,anc.fwwombid ,anc.fwwomfname ,anc.fwwomnid ,anc.fw_gobhhid ,anc.fw_jivitahhid , anc.ancname , anc.anc_current_formstatus ,"
		        + "anc.end_time , anc.mauza ,anc.received_time , anc.start , anc.today, anc.user_type from anc inner join mother on anc.relationalid =mother.case_id where "
		        + condition;
		
		return dataExportRepository.executeSelectQuery(provider, sqlQuery);
		
	}
	
	@SuppressWarnings("resource")
	@Transactional
	@Override
	public String createCSVAndSave(List<Object[]> dataSets, HttpServletResponse response) {
		String reportName = "anc" + System.currentTimeMillis() + ".csv";
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
		
		dataExportEntity.setFormName(FormName.ANC.name());
		dataExportEntity.setReportName(reportName);
		dataExportEntity.setUser("Admin");
		databaseRepositoryImpl.save(dataExportEntity);
		return reportName;
	}
	
}
