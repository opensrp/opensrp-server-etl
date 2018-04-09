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
	public <T> List<T> findScheduledVisits(String visitCode) {
		return databaseRepositoryImpl.findScheduledVisits(visitCode);
	}

	@Transactional
	public List<Object> findAllCompletedVisits(String className, String fieldName,
			String value) {
		return databaseRepositoryImpl.findAllCompletedVisits(className, fieldName, value);
	}

	@Transactional
	public List<Object> findAllANC1Data(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFormData("ancrv_1", reportSearchBuilder, "anc", "ancname", "mother");
	}

	@Transactional
	public List<Object> findAllANC2Data(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFormData("ancrv_2", reportSearchBuilder, "anc", "ancname", "mother");
	}

	@Transactional
	public List<Object> findAllANC3Data(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFormData("ancrv_3", reportSearchBuilder, "anc", "ancname", "mother");
	}

	@Transactional
	public List<Object> findAllANC4Data(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFormData("ancrv_4", reportSearchBuilder, "anc", "ancname", "mother");
	}

	public List<Object> findAllPNC1Data(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFormData("pncrv_1", reportSearchBuilder, "pnc", "pncname", "mother");
	}

	public List<Object> findAllPNC2Data(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFormData("pncrv_2", reportSearchBuilder, "pnc", "pncname", "mother");
	}

	public List<Object> findAllPNC3Data(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFormData("pncrv_3", reportSearchBuilder, "pnc", "pncname", "mother");
	}

	public List<Object> findAllENCC1Data(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFormData("enccrv_1", reportSearchBuilder, "encc", "enccname", "child");
	}

	public List<Object> findAllENCC2Data(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFormData("enccrv_2", reportSearchBuilder, "encc", "enccname", "child");
	}

	public List<Object> findAllENCC3Data(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFormData("enccrv_3", reportSearchBuilder, "encc", "enccname", "child");
	}

	public List<Object> findAllBNFData(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFDData("BirthNotificationPregnancyStatusFollowUp", reportSearchBuilder, "bnf");
	}

	public List<Object> findAllPSRFData(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.findAllFDData("ELCO PSRF", reportSearchBuilder, "psrf");
	}

	@Transactional
	public List<Object> findCountReport(ReportSearchBuilder reportSearchBuilder) {
		return reportRepository.getCountReport(reportSearchBuilder);
	}
}
