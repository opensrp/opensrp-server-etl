<%@page import="org.mcare.etl.entity.ChildEntity"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

<title>Form Wise Report Status</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
<link rel="stylesheet" href="/resources/css/jquery-ui.css">
<link rel="stylesheet" href="/resources/css/dataTables.jqueryui.min.css">
</head>


<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />
	<div class="content-wrapper">
		<div class="container-fluid">

			<jsp:include page="/WEB-INF/views/reportSearchPanel.jsp" />

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Form Wise Report Status
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-sm-12">
							<table class="display" id="formWiseAggregatedListTable" style="width: 100%;">
								<thead>
									<tr>
										<th>Form</th>
										<th>Scheduled</th>
										<th>Completed</th>
										<th>Expired</th>
										<th>% of Expired</th>
									</tr>
								</thead>
								<tbody>
									<%
										if(session.getAttribute("formWiseAggregatedList") != null){
										List<Object> formWiseAggregatedList = (List<Object>) session.getAttribute("formWiseAggregatedList");
										Iterator formWiseAggregatedListIterator = formWiseAggregatedList.iterator();
										while (formWiseAggregatedListIterator.hasNext()) {
											Object[] formWiseObject = (Object[]) formWiseAggregatedListIterator.next();
											String formName = String.valueOf(formWiseObject[0]);
											String scheduled = String.valueOf(formWiseObject[1]);
											String completed = String.valueOf(formWiseObject[2]);
											String expired = String.valueOf(formWiseObject[3]);
											String expiredPercentage = String.valueOf(formWiseObject[4]);
									%>
									<tr>
										<td><%=formName%></td>
										<td><%=scheduled%></td>
										<td><%=completed%></td>
										<td><%=expired%></td>
										<td><%=expiredPercentage%>%</td>
									</tr>
									<%
										}
										}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12" align="right">
						<button onclick="export_table_to_csv()">Export CSV file</button>
					</div>
				</div>
				<div class="card-footer small text-muted"></div>
			</div>
		</div>

		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
<script src="<c:url value='/resources/js/jquery-1.12.4.js' />"></script>
<script src="<c:url value='/resources/js/jquery.dataTables.min.js' />"></script>
<script src="<c:url value='/resources/js/dataTables.jqueryui.min.js' />"></script>
<script src="<c:url value='/resources/js/jquery-ui.js' />"></script>
<script src="<c:url value='/resources/js/datepicker.js' />"></script>
<script>
	$(document).ready(function() {
		$('#formWiseAggregatedListTable').DataTable({
			"paginate" : false
		});
	});

	function download_csv(csv, filename) {
		var csvFile;
		var downloadLink;

		// CSV FILE
		csvFile = new Blob([ csv ], {
			type : "text/csv"
		});

		// Download link
		downloadLink = document.createElement("a");
		downloadLink.download = filename;

		// We have to create a link to the file
		downloadLink.href = window.URL.createObjectURL(csvFile);

		// Make sure that the link is not displayed
		downloadLink.style.display = "none";

		// Add the link to your DOM
		document.body.appendChild(downloadLink);
		downloadLink.click();
	}

	function export_table_to_csv() {
		var csv = [];
		var rows = document.querySelectorAll("table thead tr, table tbody tr");

		//document.write(rows.length);
		//console.log("length: " + rows.length);

		for ( var i = 0; i < rows.length; i++) {
			var row = [], cols = rows[i].querySelectorAll("th, td");
			for ( var j = 0; j < cols.length; j++)
				row.push(cols[j].innerText);
			csv.push(row.join(","));
		}

		download_csv(csv.join("\n"), "table.csv");
	}
</script>
</html>