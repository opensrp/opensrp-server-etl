package org.mcare.visualization;

import java.util.List;

import org.mcare.params.builder.SearchBuilder;
import org.mcare.visualization.service.VisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataVisualization {
	
	public VisualizationService visualizationService;
	
	@Autowired
	public DataVisualizationFactory dataVisualizationFactory;
	
	public List<Object[]> getData(String visualizeDataType, SearchBuilder searchBuilder) {
		visualizationService = dataVisualizationFactory.getVisualizeDataType(visualizeDataType);
		return visualizationService.getData(searchBuilder);
	}
	
}
