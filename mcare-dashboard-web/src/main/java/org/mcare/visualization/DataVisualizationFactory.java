package org.mcare.visualization;

import org.mcare.visualization.service.VisualizationService;
import org.mcare.visualization.service.impl.HouseholdDataVisualizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataVisualizationFactory {
	
	public VisualizationService visualizationService;
	
	@Autowired
	public HouseholdDataVisualizeServiceImpl householdDataVisualizeServiceImpl;
	
	public VisualizationService getVisualizeDataType(String visualizeDataType) {
		if ("household".equalsIgnoreCase(visualizeDataType)) {
			visualizationService = householdDataVisualizeServiceImpl;
		}
		return visualizationService;
	}
	
}
