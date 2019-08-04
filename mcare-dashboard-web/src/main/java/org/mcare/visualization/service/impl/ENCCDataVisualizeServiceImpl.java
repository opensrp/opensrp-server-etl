package org.mcare.visualization.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.params.builder.SearchBuilder;
import org.mcare.visualization.service.VisualizationService;
import org.mcare.visualization.utils.DataVisualizationQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ENCCDataVisualizeServiceImpl implements VisualizationService{

    @Autowired
    private DatabaseRepositoryImpl databaseRepositoryImpl;
    @Autowired
    private LocationServiceImpl locationService;

    @Transactional
    @Override
    public List<Object[]> getMonthWiseData(SearchBuilder searchBuilder) {
        String filterString = locationService.getFilterString(searchBuilder);
        String sqlQuery = DataVisualizationQueryBuilder.getMonthWiseDataFromProcedure(searchBuilder, filterString, "encc");
        return databaseRepositoryImpl.executeQueryForMonth(searchBuilder, sqlQuery);
    }

    @Transactional
    @Override
    public List<Object[]> getDayWiseData(SearchBuilder searchBuilder) {
        String year = searchBuilder.getYear();
        String filterString = locationService.getFilterString(searchBuilder);
        //String sqlQuery = DataVisualizationQueryBuilder.getDayWiseDataQuery(searchBuilder, "encc", "child");
//        String sqlQuery = "select * from daywise_data_encc(array[:division,:district,:upazila"
//                + ",:union,:ward,:subunit,:mauzapara,:provider,:year])";
        String sqlQuery = "select day, sum(submitted) as submitted, sum(expired) as expired, sum(due) as due" +
                " from schedule_summary where date_part('year', day) = '"+year+"' and visit_type like 'encc%' "+filterString+" group by day order by day;";

        return databaseRepositoryImpl.executeQueryForDay(searchBuilder, sqlQuery);
    }

}
