package org.mcare.reports.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.reports.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;

	@Autowired
	private ReportRepository reportRepository;

	public ReportService() {
	}

	@Transactional
	public List<Object> findFormWiseReport(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findFormWiseReport(reportSearchBuilder);
	}
}
