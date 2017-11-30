package org.mcare.data.export.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mcare.data.export.service.DataExportService;
import org.springframework.stereotype.Service;

@Service
public class ENCCDataExportServiceImpl implements DataExportService {
	
	@Override
	public void export(List<Object[]> dataSets, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Object[]> getData(Date start, Date end, String provider) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String createCSVAndSave(List<Object[]> dataSets, HttpServletResponse response) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
}
