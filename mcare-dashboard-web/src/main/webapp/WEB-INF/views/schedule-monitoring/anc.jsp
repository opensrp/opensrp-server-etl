<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.mcare.acl.entity.ProviderEntity"%>
<%@page import="org.mcare.schedule.monitoring.utils.ScheduleMonitoringUtil"%>
<%@page import="org.mcare.schedule.monitoring.service.ScheduleMonitoringService"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.Map"%>
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

<meta http-equiv="refresh" content="<%=session.getMaxInactiveInterval()%>;url=/login"/>

<title> ANC Work monitoring</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
<link type="text/css"
	href="<c:url value="/resources/css/dataTables.jqueryui.min.css"/>" rel="stylesheet">
</head>

<c:url var="saveUrl" value="/role/add" />
<%
List<ProviderEntity> providers = (List<ProviderEntity>) session
			.getAttribute("providers");
ScheduleMonitoringService scheduleMonitoringService = (ScheduleMonitoringService)session.getAttribute("scheduleMonitoringService");
String provider = (String)session.getAttribute("provider");
List<Object[]> data = (List<Object[]>) session.getAttribute("data");

%>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Example DataTables Card-->
			
			<div class="card mb-3">
				
				<div class="card-body">
					<form id="search-form">
						<div class="row">
							<div class="col-3">
								<select class="custom-select custom-select-lg mb-3" name="provider">
									<option value="">Please Select Provider</option>
									<%
										if (providers != null) {
											for (ProviderEntity objects : providers) {
												if (provider.equalsIgnoreCase(objects.getProvider())) {
												%>
												<option value="<%=objects.getProvider()%>" selected><%=objects.getProvider()%></option>
												<%
													} else {
												%>
													<option value="<%=objects.getProvider()%>"><%=objects.getProvider()%></option>
													<%
													}
											}
										}
												%>
								</select>
							</div>
							<div class="col-6">
								<button name="search" type="submit" id="bth-search"
									class="btn btn-primary" value="search">Search</button>
							</div>
						</div>			
					</form>
				</div>
				<div class="card-footer small text-muted"></div>
			</div>
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> ANC Work monitoring of  <%=provider %>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable">
							<thead>
								<tr>
									<th>FullName</th>
									<th>Unique Id</th>
									<th>LMP/GA</th>
									<th>Shedule Status</th>
									<th>Schedule Due</th>
								</tr>
							</thead>
							
							
							<tfoot>
								<tr>
									<th>FullName</th>
									<th>Unique Id</th>
									<th>LMP/GA</th>
									<th>Shedule Status</th>
									<th>Schedule Due</th>
								</tr>
							</tfoot>
							<tbody id="tableBody">	
								
								<%
								if (data != null) {
									
								for (Object[] row : data) {
									List<Object[]> ancs= new ArrayList<Object[]>();
									
									String schedule ="";
									if(row[9]!=null){
										 schedule = row[10].toString();
									}else{
										schedule="";
									}
									Map<String, String> map = ScheduleMonitoringUtil.getScheduleStatus(schedule); 
									try{
										String case_id= row[9].toString();
									 ancs =  new ScheduleMonitoringUtil().getSubmittedScheduleData(provider,case_id,scheduleMonitoringService);
									}catch(Exception e){
										
									}
									
									String name = row[0].toString();
									String husbandName = row[1].toString();
									String jivitaHHID = row[2].toString();
									String goHHID = row[3].toString();
									String mouzaPara = row[4].toString();
									String nid = row[5].toString();
									String brid = row[6].toString();
									String lmp = row[7].toString();
									String ga = row[8].toString();
									
									StringBuilder noScheduleSubmissionMessage= new StringBuilder();
									if(ancs.size() ==0){
										noScheduleSubmissionMessage = ScheduleMonitoringUtil.generateMessageForNoScheduleSubmittions(schedule);
									}
								%>
									<tr id="">						                
						                <td><%=name%><br/>
						               <%=husbandName%><br/>
						                 <%=jivitaHHID%>,
						                  <%=goHHID%>
						                 <br/>
						                 <%=mouzaPara%>
						                </td>
						                <td> NID:<%=nid%><br /> BRID: <%=brid%></td>
						                <td> <%=lmp%><br/> <%=ga%></td>
						                <td>
						                 <%=noScheduleSubmissionMessage %>
						                <%=ScheduleMonitoringUtil.generateMessageForScheduleSubmittions(ancs,"ancrv_1",1) %>
						                <%=ScheduleMonitoringUtil.generateMessageForScheduleSubmittions(ancs,"ancrv_2",2) %>
						                <%=ScheduleMonitoringUtil.generateMessageForScheduleSubmittions(ancs,"ancrv_3",3) %>
						                <%=ScheduleMonitoringUtil.generateMessageForScheduleSubmittions(ancs,"ancrv_4",4) %>
						                
						                </td>
						                <td bgcolor="<%=map.get("bgColor") %>"><%=map.get("message") %>
						                <br /><%=map.get("date") %><br /><%=map.get("visitCode") %></td>
						                
					           		</tr>
				           	<% }	
						}%>
							</tbody>
						</table>
					</div>
				</div>
				<div class="card-footer small text-muted"></div>
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<jsp:include page="/WEB-INF/views/footer.jsp" />
		<script src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
		<script src="<c:url value='/resources/js/dataTables.jqueryui.min.js'/>"></script>
		<script type="text/javascript">
		$(document).ready(function() {
		    $('#dataTable').DataTable();
		} );
		</script>
	</div>
</body>
</html>