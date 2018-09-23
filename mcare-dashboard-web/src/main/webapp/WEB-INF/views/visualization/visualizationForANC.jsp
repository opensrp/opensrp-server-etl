<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="org.json.JSONObject" %>
<%@page import="org.json.JSONArray" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.mcare.visualization.highchart.HighChart"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
    uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>mCare2 Dashboard Home</title>

<jsp:include page="/WEB-INF/views/css.jsp" />

</head>
<c:url var="saveUrl" value="/role/add" />
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
    <jsp:include page="/WEB-INF/views/navbar.jsp" />


    <div class="content-wrapper">
        <div class="container-fluid">
            <jsp:include page="/WEB-INF/views/visualization/visualizeSearchPanel.jsp" />
                
        
        
            <div class="row">
                <div id="barChartDirlled" style="width: 100%; height: 250px; margin: 0 auto"></div>
            </div> <!-- row -->
            <hr />
            <div class="row">
                <div class="col-lg-6 col-xs-6"> 
                    <div id="pieDrilled" style="width: 100%; height: 250px; margin: 0 auto"></div>
                </div>
                <div class="col-lg-6 col-xs-6"> 
                    <div id="lineChart" style="width: 100%; height: 250px; margin: 0 auto"></div>
                </div>
            </div> <!-- row -->
            
                
        </div>
        <% 
        JSONArray monthWiseSeriesData = (JSONArray)session.getAttribute("monthWiseSeriesData");     
        JSONArray dayWiseData = (JSONArray)session.getAttribute("dayWiseData");

        String chartTitle = (String)session.getAttribute("chatTitle");
        
        %>
        <jsp:include page="/WEB-INF/views/footer.jsp" />
    </div>
    <script src="<c:url value='/resources/chart/highcharts.js'/>"></script>
    <script src="<c:url value='/resources/chart/data.js'/>"></script>
    <script src="<c:url value='/resources/chart/drilldown.js'/>"></script>

    <script type="text/javascript">
    // Create the chart
    
    Highcharts.chart('barChartDirlled', {
        chart: {
            type: 'column'
        },
        title: {
            text: '<%=chartTitle%>'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
        	categories: [
        	             'Jan',
        	             'Feb',
        	             'Mar',
        	             'Apr',
        	             'May',
        	             'Jun',
        	             'Jul',
        	             'Aug',
        	             'Sep',
        	             'Oct',
        	             'Nov',
        	             'Dec'
        	         ],
        	         crosshair: true
        },
        yAxis: {
            title: {
                text: 'Percentage'
            }

        },
        credits: {
            enabled: false
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.0f}'
                }
            }
        },

        tooltip: {
        	headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} % </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },

        "series": <%=monthWiseSeriesData%>,
        "drilldown": {
            "series": <%=dayWiseData%>
        }
    });
    
    </script>
    
</body>
</html>