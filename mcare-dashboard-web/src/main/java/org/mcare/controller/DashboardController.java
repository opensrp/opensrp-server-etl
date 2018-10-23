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
import org.mcare.reports.service.SearchFilterBuilder;
import org.mcare.visualization.DataVisualization;
import org.mcare.visualization.highchart.HighChart;
import org.mcare.visualization.service.VisualizationService;
import org.mcare.visualization.service.impl.ANCDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.BNFDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.ChildDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.ENCCDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.ElcoDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.HouseholdDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.MotherDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.PNCDataVisualizeServiceImpl;
import org.mcare.visualization.service.impl.PSRFDataVisualizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
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

    @Autowired
    private ANCDataVisualizeServiceImpl ancDataVisualizeServiceImpl;

    @Autowired
    private PNCDataVisualizeServiceImpl pncDataVisualizeServiceImpl;

    @Autowired
    private ENCCDataVisualizeServiceImpl enccDataVisualizeServiceImpl;

    @Autowired
    private PSRFDataVisualizeServiceImpl psrfDataVisualizeServiceImpl;

    @Autowired
    private BNFDataVisualizeServiceImpl bnfDataVisualizeServiceImpl;

    public VisualizationService visualizationService;

    @PostAuthorize("hasPermission(returnObject, 'PERM_VISIT_HOME')")
    @RequestMapping("/")
    public String showHome(Model model, HttpSession session) {
        List<Object> dashboardDataCountList = (List<Object>) databaseServiceImpl.getDataFromSQLFunction(
                "fn_dashboard_data_count", "");

        session.setAttribute("dashboardDataCount", dashboardDataCountList);
        return "home";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_VISIT_VISUALIZATION_DETAILS')")
    @RequestMapping(value = "visualize/household.html", method = RequestMethod.GET)
    public String visualizeHousehold(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        visualizationService = householdDataVisualizeServiceImpl;
        setHighChartData(request, session);
        setTitles(model, session, "Household");
        return "visualization/visualization";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_VISIT_VISUALIZATION_DETAILS')")
    @RequestMapping(value = "visualize/elco.html", method = RequestMethod.GET)
    public String visualizeElco(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        visualizationService = elcoDataVisualizeServiceImpl;
        setHighChartData(request, session);
        setTitles(model, session, "Eligible Couple");
        return "visualization/visualization";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_VISIT_VISUALIZATION_DETAILS')")
    @RequestMapping(value = "visualize/mother.html", method = RequestMethod.GET)
    public String visualizeMother(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        visualizationService = motherDataVisualizeServiceImpl;
        setHighChartData(request, session);
        setTitles(model, session, "Mother");
        return "visualization/visualization";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_VISIT_VISUALIZATION_DETAILS')")
    @RequestMapping(value = "visualize/child.html", method = RequestMethod.GET)
    public String visualizeChild(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        visualizationService = childDataVisualizeServiceImpl;
        setHighChartData(request, session);
        setTitles(model, session, "Child");
        return "visualization/visualization";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_VISIT_VISUALIZATION_DETAILS')")
    @RequestMapping(value = "visualize/anc.html", method = RequestMethod.GET)
    public String visualizeANC(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        visualizationService = ancDataVisualizeServiceImpl;
        setHighChartDataForAnc(request, session);
        setTitles(model, session, "ANC");
        return "visualization/visualizationForANC";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_VISIT_VISUALIZATION_DETAILS')")
    @RequestMapping(value = "visualize/pnc.html", method = RequestMethod.GET)
    public String visualizePNC(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        visualizationService = pncDataVisualizeServiceImpl;
        setHighChartDataForAnc(request, session);
        setTitles(model, session, "PNC");
        return "visualization/visualizationForANC";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_VISIT_VISUALIZATION_DETAILS')")
    @RequestMapping(value = "visualize/encc.html", method = RequestMethod.GET)
    public String visualizeENCC(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        visualizationService = enccDataVisualizeServiceImpl;
        setHighChartDataForAnc(request, session);
        setTitles(model, session, "ENCC");
        return "visualization/visualizationForANC";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_VISIT_VISUALIZATION_DETAILS')")
    @RequestMapping(value = "visualize/psrf.html", method = RequestMethod.GET)
    public String visualizePSRF(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        visualizationService = psrfDataVisualizeServiceImpl;
        setHighChartDataForAnc(request, session);
        setTitles(model, session, "PSRF");
        return "visualization/visualizationForANC";
    }

    @PostAuthorize("hasPermission(returnObject, 'PERM_VISIT_VISUALIZATION_DETAILS')")
    @RequestMapping(value = "visualize/bnf.html", method = RequestMethod.GET)
    public String visualizeBNF(HttpServletRequest request, Model model, HttpSession session) throws JSONException {
        visualizationService = bnfDataVisualizeServiceImpl;
        setHighChartDataForAnc(request, session);
        setTitles(model, session, "BNF");
        return "visualization/visualizationForANC";
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

    private void setHighChartDataForAnc(HttpServletRequest request, HttpSession session)
            throws JSONException {
        searchBuilder = searchUtil.generateSearchBuilderParams(request, session);
        if (searchBuilder.getYear() == null || searchBuilder.getYear().isEmpty()) {
            System.out.println("current empty");
            searchBuilder.setYear(currentYear.toString());
        }
        searchUtil.setProviderAttribute(session);
        searchUtil.setDivisionAttribute(session);
        searchUtil.setSelectedfilter(request, session);

        List<Object[]> monthWiseData = dataVisualization.getMonthWiseData(searchBuilder, visualizationService);
        JSONArray monthWiseSeriesData = HighChart.getMonthWiseSeriesDataForMultiBarWithDrillDown(monthWiseData);

        List<Object[]> dayWiseData = dataVisualization.getDayWiseData(searchBuilder, visualizationService);
        JSONArray dataJsonArray = HighChart.getDayWiseDrilldownSeriesData(dayWiseData);

        JSONArray lineChartData = HighChart.getMultiLineChartData(monthWiseData, searchBuilder.getYear());
        JSONArray lineChartCategory = HighChart.getMultiLineChartCategory(monthWiseData);
        session.setAttribute("lineChartData", lineChartData);
        session.setAttribute("lineChartCategory", lineChartCategory);

        session.setAttribute("dayWiseData", dataJsonArray);
        session.setAttribute("monthWiseSeriesData", monthWiseSeriesData);
    }

    private void setTitles(Model model, HttpSession session, String title) {
        model.addAttribute("title", title + " Search Criteria");
        session.setAttribute("chatTitle", title + " Data Visualization");
    }
}
