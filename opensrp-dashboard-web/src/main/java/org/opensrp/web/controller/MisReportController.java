package org.opensrp.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.opensrp.etl.entity.FilterCriteria;
import org.opensrp.etl.entity.MIS1ReportEntity;
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
	public <T> List<T> getMIS1Report(FilterCriteria filterCriteria) {
		List<T> findAllByCriteria = commonDatabaseRepository.findAllByCriteria(MIS1ReportEntity.class, filterCriteria);
        if (!findAllByCriteria.isEmpty()) {
            return findAllByCriteria;
        } else {
            return commonDatabaseRepository.checkEmptyCriteria(filterCriteria);
        }
	}
}