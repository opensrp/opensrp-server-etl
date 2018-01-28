package org.opensrp.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
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

    private static final Logger logger = Logger.getLogger(MisReportController.class);
    
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;

	@ResponseBody
	@RequestMapping("/misreport")
	public <T> List<T> getMIS1Report(FilterCriteria filterCriteria) {
		List<T> findAllByCriteria = commonDatabaseRepository.findAllByCriteria(MIS1ReportEntity.class, filterCriteria);
        if (!findAllByCriteria.isEmpty()) {
            logger.info("web service successfully executed");
            return findAllByCriteria;
        } else {
            logger.info("missing criteria!");
            return commonDatabaseRepository.checkEmptyCriteria(filterCriteria);
        }
	}
}