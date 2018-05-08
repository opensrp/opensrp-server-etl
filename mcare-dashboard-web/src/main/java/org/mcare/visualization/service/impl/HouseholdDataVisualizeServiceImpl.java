package org.mcare.visualization.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.params.builder.SearchBuilder;
import org.mcare.visualization.service.VisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdDataVisualizeServiceImpl implements VisualizationService {
	
	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;
	
	@Transactional
	@Override
	public List<Object[]> getData(SearchBuilder searchBuilder) {
		
		String queryCOndition = "";
		
		if (searchBuilder.getDivision() != null && !searchBuilder.getDivision().isEmpty()) {
			queryCOndition += " and division = :division ";
		}
		if (searchBuilder.getDistrict() != null && !searchBuilder.getDistrict().isEmpty()) {
			queryCOndition += " and district = :district ";
		}
		if (searchBuilder.getUpazila() != null && !searchBuilder.getUpazila().isEmpty()) {
			queryCOndition += " and upazila = :upazila ";
		}
		if (searchBuilder.getUnion() != null && !searchBuilder.getUnion().isEmpty()) {
			queryCOndition += " and unions = :unions ";
		}
		if (searchBuilder.getWard() != null && !searchBuilder.getWard().isEmpty()) {
			queryCOndition += " and ward = :ward ";
		}
		if (searchBuilder.getMauzapara() != null && !searchBuilder.getMauzapara().isEmpty()) {
			queryCOndition += " and mauza_para = :mauza_para ";
		}
		if (searchBuilder.getSubunit() != null && !searchBuilder.getSubunit().isEmpty()) {
			queryCOndition += " and subunit = :subunit";
		}
		if (searchBuilder.getProvider() != null && !searchBuilder.getProvider().isEmpty()) {
			queryCOndition += " and provider = :provider ";
		}
		
		String sqlQuery = "select   date_part('month', date(received_time)),count(date_part('month', date(received_time)))"
		        + " from mother where date_part('year', date(received_time)) = " + searchBuilder.getYear() + " "
		        + queryCOndition + " group by  date_part('month', date(received_time)) "
		        + " order by date_part('month', date(received_time)) asc";
		return databaseRepositoryImpl.executeRawQuery(searchBuilder, sqlQuery);
		
	}
}
