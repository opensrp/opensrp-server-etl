package org.opensrp.web.controller;

import java.util.List;

import org.opensrp.etl.entity.FilterCriteria;
import org.opensrp.etl.entity.MIS1ReportEntity;
import org.opensrp.etl.report.MIS1Report;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MisReportController {

	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;

	@ResponseBody
	@RequestMapping("/misreport")
	public List<MIS1Report> getMIS1Report(FilterCriteria filterCriteria) {
		return commonDatabaseRepository.findAllByCriteria(MIS1ReportEntity.class, filterCriteria);

	}
}