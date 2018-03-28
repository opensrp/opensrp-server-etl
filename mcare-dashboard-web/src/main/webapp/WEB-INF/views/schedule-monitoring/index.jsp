<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.mcare.acl.entity.ProviderEntity"%>
<%@page import="org.mcare.schedule.monitoring.utils.ScheduleMonitoringUtil"%>
<%@page import="org.mcare.schedule.monitoring.service.impl.ANCScheduleMonitoringServiceImpl"%>

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

<title> ANC Work monitoring</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
<link type="text/css"
	href="<c:url value="/resources/css/dataTables.jqueryui.min.css"/>" rel="stylesheet">
</head>

<c:url var="saveUrl" value="/role/add" />
<%
List<ProviderEntity> providers = (List<ProviderEntity>) session
			.getAttribute("providers");
ANCScheduleMonitoringServiceImpl ancScheduleMonitoringServiceImpl = (ANCScheduleMonitoringServiceImpl)session.getAttribute("ancScheduleMonitoringServiceImpl");
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
									Map<String, String> map = ScheduleMonitoringUtil.getScheduleStatus(row[10].toString()); 
									try{
									 ancs =  new ScheduleMonitoringUtil().getSubmittedScheduleData(provider,row[9].toString(),ancScheduleMonitoringServiceImpl);
									}catch(Exception e){
										
									}
								%>
									<tr id="">						                
						               <td><%=row[0]%><br/>
						               <%=row[1]%><br/>
						                 <%=row[2]%>,
						                  <%=row[3]%>
						                 <br/>
						                 <%=row[4]%>
						                </td>
						                <td> NID:<%=row[5]%><br /> BRID: <%=row[6]%></td>
						                <td> <%=row[7]%><br/> <%=row[8]%></td>
						                <td>
						                <%=ScheduleMonitoringUtil.getScheduleDate(ancs) %>
						                
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