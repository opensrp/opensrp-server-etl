package org.mcare.reports.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.params.builder.SearchBuilder;
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
		return reportRepository.findAllFormData("ancrv_1", searchBuilder, "anc", "ancname", "mother");
	}

	@Transactional
	public List<Object> findAllANC2Data(SearchBuilder searchBuilder) {
		return reportRepository.findAllFormData("ancrv_2", searchBuilder, "anc", "ancname", "mother");
	}

	@Transactional
	public List<Object> findAllANC3Data(SearchBuilder searchBuilder) {
		return reportRepository.findAllFormData("ancrv_3", searchBuilder, "anc", "ancname", "mother");
	}

	@Transactional
	public List<Object> findAllANC4Data(SearchBuilder searchBuilder) {
		return reportRepository.findAllFormData("ancrv_4", searchBuilder, "anc", "ancname", "mother");
	}

	public List<Object> findAllPNC1Data(SearchBuilder searchBuilder) {
		return reportRepository.findAllFormData("pncrv_1", searchBuilder, "pnc", "pncname", "mother");
	}

	public List<Object> findAllPNC2Data(SearchBuilder searchBuilder) {
		return reportRepository.findAllFormData("pncrv_2", searchBuilder, "pnc", "pncname", "mother");
	}

	public List<Object> findAllPNC3Data(SearchBuilder searchBuilder) {
		return reportRepository.findAllFormData("pncrv_3", searchBuilder, "pnc", "pncname", "mother");
	}

	public List<Object> findAllENCC1Data(SearchBuilder searchBuilder) {
		return reportRepository.findAllFormData("enccrv_1", searchBuilder, "encc", "enccname", "child");
	}

	public List<Object> findAllENCC2Data(SearchBuilder searchBuilder) {
		return reportRepository.findAllFormData("enccrv_2", searchBuilder, "encc", "enccname", "child");
	}

	public List<Object> findAllENCC3Data(SearchBuilder searchBuilder) {
		return reportRepository.findAllFormData("enccrv_3", searchBuilder, "encc", "enccname", "child");
	}

	public List<Object> findAllBNFData(SearchBuilder searchBuilder) {
		return reportRepository.findAllFDData("BirthNotificationPregnancyStatusFollowUp", searchBuilder, "bnf");
	}

	public List<Object> findAllPSRFData(SearchBuilder searchBuilder) {
		return reportRepository.findAllFDData("ELCO PSRF", searchBuilder, "psrf");
	}
}
