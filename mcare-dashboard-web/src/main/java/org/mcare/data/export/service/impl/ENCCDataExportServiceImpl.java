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

@Service
public class ENCCDataExportServiceImpl implements DataExportService {
	
	@Autowired
	private DataExportRepository dataExportRepository;
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Autowired
	private DataExportEntity dataExportEntity;
	
	@Autowired
	private CSVExportServiceImpl csvExportServiceImpl;
	
	public ENCCDataExportServiceImpl() {
		
	}
	
	@Override
	public void export(List<Object[]> dataSets, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public List<Object[]> getData(Date start, Date end, String provider, String formName) {
		String condition = "";
		
		condition = "encc.fwenccdate between '" + start + "'and'" + end + "' ";
		condition = condition + " and encc.enccname = :formName ";
		
		if (!provider.isEmpty()) {
			condition = condition + "and child.provider=:provider";
		}
		String sqlQuery = "select encc.start_date,encc.end_date,encc.today,encc.fwenccdate,encc.fwenccsts,encc.fwenccbfintn,encc.fwenccprlctl,encc.fwenccdrywm ,"
		        + "encc.fwencchdcov , encc.fwenccbthd , encc.fwenccumbs , encc.fwencctemp , encc.fwenccdsfoulumbs , encc.fwenccdslimblue , encc.fwenccdssknylw , encc.fwenccdsleth ,encc.fwenccdsdifbrth ,encc.fwenccdsconvl ,"
		        + "encc.fwenccdelcomp ,encc.encc_current_formstatus "
		        + " from encc inner join child on encc.relationalid =child.case_id where " + condition;
		
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
			
			writer = csvExportServiceImpl.createHeader(writer, ExportKeyMapperSetup.ENCC);
			
			writer.append('\n');
			writer = csvExportServiceImpl.createContent(writer, dataSets);
			
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			
		}
		
		dataExportEntity.setFormName(formName);
		dataExportEntity.setReportName(reportName);
		dataExportEntity.setUser(SecurityContextHolder.getContext().getAuthentication().getName());
		databaseRepositoryImpl.save(dataExportEntity);
		return reportName;
		
	}
	
}
