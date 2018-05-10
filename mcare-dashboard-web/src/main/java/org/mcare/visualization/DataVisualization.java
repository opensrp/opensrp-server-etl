package org.mcare.visualization;

import java.util.List;

import org.mcare.params.builder.SearchBuilder;
import org.mcare.visualization.service.VisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataVisualization {
	
	@Autowired
	public DataVisualizationFactory dataVisualizationFactory;
	
	public List<Object[]> getMonthWiseData(SearchBuilder searchBuilder, VisualizationService visualizationService) {
		return visualizationService.getMonthWiseData(searchBuilder);
	}
	
	public List<Object[]> getDayWiseData(SearchBuilder searchBuilder, VisualizationService visualizationService) {
		return visualizationService.getDayWiseData(searchBuilder);
	}
	
}
