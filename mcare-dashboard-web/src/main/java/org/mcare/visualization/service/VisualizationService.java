package org.mcare.visualization.service;

import java.util.List;

import org.mcare.params.builder.SearchBuilder;

public interface VisualizationService {
	
	public List<Object[]> getData(SearchBuilder searchBuilder);
	
}