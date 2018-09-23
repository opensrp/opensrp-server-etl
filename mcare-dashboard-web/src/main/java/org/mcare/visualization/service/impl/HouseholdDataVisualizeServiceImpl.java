package org.mcare.visualization.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.params.builder.SearchBuilder;
import org.mcare.visualization.service.VisualizationService;
import org.mcare.visualization.utils.DataVisualizationQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdDataVisualizeServiceImpl implements VisualizationService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Transactional
	@Override
	public List<Object[]> getMonthWiseData(SearchBuilder searchBuilder) {
		
		String sqlQuery = DataVisualizationQueryBuilder.getMonthWiseDataQuery(searchBuilder, "household");
		return databaseRepositoryImpl.executeRawQuery(searchBuilder, sqlQuery);
	}
	
	@Transactional
	@Override
	public List<Object[]> getDayWiseData(SearchBuilder searchBuilder) {
		
		String sqlQuery = DataVisualizationQueryBuilder.getDayWiseDataQuery(searchBuilder, "household");
		return databaseRepositoryImpl.executeRawQuery(searchBuilder, sqlQuery);
	}
}
