package org.mcare.visualization.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.common.util.SearchCriteria;
import org.mcare.params.builder.SearchBuilder;
import org.mcare.visualization.service.VisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildDataVisualizeServiceImpl implements VisualizationService{

    @Autowired
    private DatabaseRepositoryImpl databaseRepositoryImpl;

    @Transactional
    @Override
    public List<Object[]> getMonthWiseData(SearchBuilder searchBuilder) {
        String sqlQuery = "select date_part('month', date(received_time)),count(date_part('month', date(received_time)))"
                + " from child where date_part('year', date(received_time)) = " + searchBuilder.getYear() + " "
                + SearchCriteria.getSearchCriteria(searchBuilder) + " group by  date_part('month', date(received_time)) "
                + " order by date_part('month', date(received_time)) asc";
        return databaseRepositoryImpl.executeRawQuery(searchBuilder, sqlQuery);
    }

    @Transactional
    @Override
    public List<Object[]> getDayWiseData(SearchBuilder searchBuilder) {
        String sqlQuery = "select date(received_time) ,count(date(received_time))from child"
                + "  where date_part('year', date(received_time)) = " + searchBuilder.getYear() + " "
                + SearchCriteria.getSearchCriteria(searchBuilder) + " group by  date(received_time) "
                + " order by date(received_time) asc";
        return databaseRepositoryImpl.executeRawQuery(searchBuilder, sqlQuery);
    }

}
