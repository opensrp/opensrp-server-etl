package org.mcare.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.mcare.common.util.SearchUtil;
import org.mcare.params.builder.SearchBuilder;
import org.mcare.visualization.DataVisualization;
import org.mcare.visualization.highchart.HighChart;
import org.mcare.visualization.service.VisualizationService;
import org.mcare.visualization.service.impl.ChildDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.ElcoDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.HouseholdDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.MotherDataVisualizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

    private static final Logger logger = Logger.getLogger(DashboardController.class);

    private Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);

    @Autowired
    private DatabaseServiceImpl databaseServiceImpl;

    @Autowired
    private SearchUtil searchUtil;

    @Autowired
    private SearchBuilder searchBuilder;

    @Autowired
    private DataVisualization dataVisualization;

    @Autowired
    private HouseholdDataVisualizeServiceImpl householdDataVisualizeServiceImpl;

    @Autowired
    private ElcoDataVisualizeServiceImpl elcoDataVisualizeServiceImpl;
    
    @Autowired
    private MotherDataVisualizeServiceImpl motherDataVisualizeServiceImpl;
    
    @Autowired
    private ChildDataVisualizeServiceImpl childDataVisualizeServiceImpl;

    public VisualizationService visualizationService;

    @RequestMapping("/")
    public String showHome(Model model, HttpSession session) {
        List<Object> dashboardDataCountList = (List<Object>) databaseServiceImpl.getDataFromSQLFunction(
                "fn_dashboard_data_count", "");

        session.setAttribute("dashboardDataCount", dashboardDataCountList);
        return "home";
    }

    @RequestMapping(value = "visualize/household.html", method = RequestMethod.GET)
    public String visualizeHousehold(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        model.addAttribute("title", "Household search criteria");

        visualizationService = householdDataVisualizeServiceImpl;
        setHighChartData(request, session);
        session.setAttribute("chatTitle", "Household data visualization");
        return "visualization/visualization";

    }

    @RequestMapping(value = "visualize/elco.html", method = RequestMethod.GET)
    public String visualizeElco(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        model.addAttribute("title", "Eligible Couple search criteria");

        visualizationService = elcoDataVisualizeServiceImpl;
        setHighChartData(request, session);
        session.setAttribute("chatTitle", "Eligible Couple data visualization");
        return "visualization/visualization";

    }

    @RequestMapping(value = "visualize/mother.html", method = RequestMethod.GET)
    public String visualizeMother(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        model.addAttribute("title", "Mother search criteria");

        visualizationService = motherDataVisualizeServiceImpl;
        setHighChartData(request, session);
        session.setAttribute("chatTitle", "Mother data visualization");
        return "visualization/visualization";

    }

    @RequestMapping(value = "visualize/child.html", method = RequestMethod.GET)
    public String visualizeChild(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        model.addAttribute("title", "Child search criteria");

        visualizationService = childDataVisualizeServiceImpl;
        setHighChartData(request, session);
        session.setAttribute("chatTitle", "Child data visualization");
        return "visualization/visualization";

    }

    @RequestMapping(value = "visualize/anc.html", method = RequestMethod.GET)
    public String visualizeANC(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        model.addAttribute("title", "Child search criteria");

        visualizationService = childDataVisualizeServiceImpl;
        setHighChartData(request, session);
        session.setAttribute("chatTitle", "Child data visualization");
        return "visualization/visualization";

    }

    private void setHighChartData(HttpServletRequest request, HttpSession session)
            throws JSONException {
        searchBuilder = searchUtil.generateSearchBuilderParams(request, session);
        if (searchBuilder.getYear() == null || searchBuilder.getYear().isEmpty()) {
            searchBuilder.setYear(currentYear.toString());
        }
        searchUtil.setProviderAttribute(session);
        searchUtil.setDivisionAttribute(session);
        searchUtil.setSelectedfilter(request, session);

        List<Object[]> monthWiseData = dataVisualization.getMonthWiseData(searchBuilder, visualizationService);
        JSONArray monthWiseSeriesData = HighChart.getMonthWiseSeriesData(monthWiseData);

        List<Object[]> dayWiseData = dataVisualization.getDayWiseData(searchBuilder, visualizationService);
        JSONArray dataJsonArray = HighChart.getDayWiseDrilldownSeriesData(dayWiseData);
        JSONArray lineChartData = HighChart.getLineChartData(monthWiseData, searchBuilder.getYear());
        JSONArray lineChartCategory = HighChart.getLineChartCategory(monthWiseData);
        session.setAttribute("dayWiseData", dataJsonArray);
        session.setAttribute("lineChartData", lineChartData);
        session.setAttribute("monthWiseSeriesData", monthWiseSeriesData);
        session.setAttribute("lineChartCategory", lineChartCategory);
    }
}
