package org.mcare.reports.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;

	public ReportService() {
		// TODO Auto-generated constructor stub
	}


	@Transactional
	public <T> List<T> findScheduledVisits(String visitCode) {
		return databaseRepositoryImpl.findScheduledVisits(visitCode);
	}

	@Transactional
	public List<Object> findAllCompletedVisits(String className, String fieldName,
			String value) {
		return databaseRepositoryImpl.findAllCompletedVisits(className, fieldName, value);
	}

	@Transactional
	public List<Object> findAllANC1Data(SearchBuilder searchBuilder) {
		return databaseRepositoryImpl.findAllANCData("ancrv_1", searchBuilder);
	}

	@Transactional
	public List<Object> findAllANC2Data(SearchBuilder searchBuilder) {
		return databaseRepositoryImpl.findAllANCData("ancrv_2", searchBuilder);
	}

	@Transactional
	public List<Object> findAllANC3Data(SearchBuilder searchBuilder) {
		return databaseRepositoryImpl.findAllANCData("ancrv_3", searchBuilder);
	}

	@Transactional
	public List<Object> findAllANC4Data(SearchBuilder searchBuilder) {
		return databaseRepositoryImpl.findAllANCData("ancrv_4", searchBuilder);
	}
}
