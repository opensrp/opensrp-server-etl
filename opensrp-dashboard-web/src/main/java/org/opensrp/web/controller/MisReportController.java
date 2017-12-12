package org.opensrp.web.controller;

import java.util.Map;

import org.opensrp.etl.report.FamilyPlanningReport;
import org.opensrp.etl.report.MIS1Report;
import org.opensrp.etl.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MisReportController {

    @Autowired
    private QueryRepository queryRepository;

    @ResponseBody
    @RequestMapping("/misreport/familyplanning")
    public MIS1Report getMIS1Report(@RequestParam Map<String, String> queryMap) {

        // http://192.168.19.112:9979/report/mis1?district=Gaibandha&year=2017&month=10&upazilla=Gaibandha%20Sadar%202%20&union=Kuptala&ward=Ward-3&unit=3-Kha&worker=abc
        // month, year
        String district = "";
        int year = 0;
        int month = 0;
        for (Map.Entry<String, String> param : queryMap.entrySet()) {

            if (param.getKey() != null
                    && param.getKey().equalsIgnoreCase("district")) {
                district = param.getValue();
            } else if (param.getKey() != null
                    && param.getKey().equalsIgnoreCase("year")) {
                year = Integer.parseInt(param.getValue());
            } else if (param.getKey() != null
                    && param.getKey().equalsIgnoreCase("month")) {
                month = Integer.parseInt(param.getValue());
            }
        }

        System.out.println("district: " + district + " month: " + month
                + " year: " + year);

        FamilyPlanningReport fpr = new FamilyPlanningReport();
        fpr.setNewPillUsages(queryRepository.calculateNewPillUsages(district,
                year, month));
        fpr.setOldCondomUsages(queryRepository.calculateOldCondomUsages());
        fpr.setOldFemalePermanentMethodUsages(queryRepository
                .calculatePermanentMethodUsages());
        fpr.setLeftPillAndStartedNone(queryRepository
                .calculateLeftMethodAndStartedNone());
        MIS1Report mr = new MIS1Report();
        mr.setFamilyPlanningReport(fpr);

        return mr;
    }
}