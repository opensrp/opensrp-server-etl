package org.mpower.visualization;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mcare.params.builder.SearchBuilder;
import org.mcare.visualization.DataVisualization;
import org.mcare.visualization.highchart.HighChart;
import org.mcare.visualization.service.VisualizationService;
import org.mcare.visualization.service.impl.HouseholdDataVisualizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:couchdb-connection-context.xml", "classpath:etl-bean-context.xml",
        "classpath:hibernate-hbm.xml", "classpath:listener-context.xml", "classpath:mvc-context.xml",
        "classpath:spring-security.xml" })
public class HouseholdDataVisualize {
	
	@Autowired
	private DataVisualization dataVisualization;
	
	@Autowired
	private HouseholdDataVisualizeServiceImpl householdDataVisualizeServiceImpl;
	
	public VisualizationService visualizationService;
	
	@Autowired
	private SearchBuilder searchBuilder;
	
	@Test
	public void getDayWiseData() throws JSONException {
		visualizationService = householdDataVisualizeServiceImpl;
		searchBuilder.setYear("2018");
		List<Object[]> dayWiseData = dataVisualization.getDayWiseData(searchBuilder, visualizationService);
		
		for (Object[] row : dayWiseData) {
			//System.err.println("" + row[0] + ": " + row[1]);
		}
		//System.err.println(HighChart.getDayWiseDataAsGroup(dayWiseData).toString());
		
		JSONArray dataJsonArray = HighChart.getDayWiseDrilldownSeriesData(dayWiseData);
		System.err.println("DDD:" + dataJsonArray.toString());
		/*[
		 {
		     "name": "Chrome",
		     "id": "Chrome",
		     "data": [
		         [
		             "v65.0",
		             0.1
		         ],
		         [
		             "v64.0",
		             1.3
		         ],
		         [
		             "v63.0",
		             53.02
		         ],
		         [
		             "v62.0",
		             1.4
		         ],
		         [
		             "v61.0",
		             0.88
		         ],
		         [
		             "v60.0",
		             0.56
		         ],
		         [
		             "v59.0",
		             0.45
		         ],
		         [
		             "v58.0",
		             0.49
		         ],
		         [
		             "v57.0",
		             0.32
		         ],
		         [
		             "v56.0",
		             0.29
		         ],
		         [
		             "v55.0",
		             0.79
		         ],
		         [
		             "v54.0",
		             0.18
		         ],
		         [
		             "v51.0",
		             0.13
		         ],
		         [
		             "v49.0",
		             2.16
		         ],
		         [
		             "v48.0",
		             0.13
		         ],
		         [
		             "v47.0",
		             0.11
		         ],
		         [
		             "v43.0",
		             0.17
		         ],
		         [
		             "v29.0",
		             0.26
		         ]
		     ]
		 },
		 {
		     "name": "Firefox",
		     "id": "Firefox",
		     "data": [
		         [
		             "v58.0",
		             1.02
		         ],
		         [
		             "v57.0",
		             7.36
		         ],
		         [
		             "v56.0",
		             0.35
		         ],
		         [
		             "v55.0",
		             0.11
		         ],
		         [
		             "v54.0",
		             0.1
		         ],
		         [
		             "v52.0",
		             0.95
		         ],
		         [
		             "v51.0",
		             0.15
		         ],
		         [
		             "v50.0",
		             0.1
		         ],
		         [
		             "v48.0",
		             0.31
		         ],
		         [
		             "v47.0",
		             0.12
		         ]
		     ]
		 },]*/
	}
}
