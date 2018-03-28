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

<script>
	$(document).ready(function() {
		$('#dataTable').DataTable({
			"paging":   false,
	        "ordering": false,
	        "info":     false
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

		for ( var i = 0; i < rows.length; i++) {
			var row = [], cols = rows[i].querySelectorAll("th, td");
			for ( var j = 0; j < cols.length; j++)
				row.push(cols[j].innerText);
			csv.push(row.join(","));
		}

		download_csv(csv.join("\n"), "table.csv");
	}
</script>

<title>${title.toString()}</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
<link rel="stylesheet" href="/resources/css/jquery-ui.css">
<link rel="stylesheet" href="/resources/css/dataTables.jqueryui.min.css">
</head>


<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />
	<div class="content-wrapper">
		<div class="container-fluid">

			<jsp:include page="/WEB-INF/views/searchPanel.jsp" />

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Report
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<div id="dataTable_wrapper"
							class="dataTables_wrapper container-fluid dt-bootstrap4">
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered dataTable" id="dataTable"
										style="width: 100%;">
										<thead>
											<tr>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Form</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">Scheduled</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Completed</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">Expired</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">% of Expired</th>
											</tr>
										</thead>
										<tbody>
											<%
												List<Object> ANC1List = (List<Object>) session
														.getAttribute("ANC1List");
												Iterator itr = ANC1List.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>ANCRV1</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> ANC2List = (List<Object>) session
														.getAttribute("ANC2List");
												itr = ANC2List.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>ANCRV2</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> ANC3List = (List<Object>) session
														.getAttribute("ANC3List");
												itr = ANC3List.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>ANCRV3</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> ANC4List = (List<Object>) session
														.getAttribute("ANC4List");
												itr = ANC4List.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>ANCRV4</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> PNC1List = (List<Object>) session
														.getAttribute("PNC1List");
												itr = PNC1List.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>PNC1</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> PNC2List = (List<Object>) session
														.getAttribute("PNC2List");
												itr = PNC2List.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>PNC2</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> PNC3List = (List<Object>) session
														.getAttribute("PNC3List");
												itr = PNC3List.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>PNC3</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> ENCC1List = (List<Object>) session
														.getAttribute("ENCC1List");
												itr = ENCC1List.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>ENCC1</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> ENCC2List = (List<Object>) session
														.getAttribute("ENCC2List");
												itr = ENCC2List.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>ENCC2</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> ENCC3List = (List<Object>) session
														.getAttribute("ENCC3List");
												itr = ENCC3List.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>ENCC3</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> BNFList = (List<Object>) session
														.getAttribute("BNFList");
												itr = BNFList.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>BNF</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
												List<Object> PSRFList = (List<Object>) session
														.getAttribute("PSRFList");
												itr = PSRFList.iterator();
												while (itr.hasNext()) {
													Object[] obj = (Object[]) itr.next();
													Integer scheduled = Integer.parseInt(String.valueOf(obj[0]));
													Integer completed = Integer.parseInt(String.valueOf(obj[1]));
													Integer expired = Integer.parseInt(String.valueOf(obj[2]));
													Double expiredPercentage = (expired.doubleValue() / scheduled
															.doubleValue()) * 100;
													DecimalFormat df = new DecimalFormat("0.00");
													df.setRoundingMode(RoundingMode.CEILING);
											%>
											<tr class="even">
												<td>PSRF</td>
												<td><%=scheduled.toString()%></td>
												<td><%=completed.toString()%></td>
												<td><%=expired.toString()%></td>
												<td><%=df.format(expiredPercentage)%></td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>
							</div>
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
</html>