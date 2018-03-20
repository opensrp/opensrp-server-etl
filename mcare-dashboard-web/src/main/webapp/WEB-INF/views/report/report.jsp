<%@page import="org.mcare.etl.entity.ActionEntity"%>
<%@page import="java.util.List"%>
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

<jsp:include page="/WEB-INF/views/header.jsp" />

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />
	
	<script>

	function download_csv(csv, filename) {
	    var csvFile;
	    var downloadLink;

	    // CSV FILE
	    csvFile = new Blob([csv], {type: "text/csv"});

	    // Download link
	    downloadLink = document.createElement("a");

	    // File name
	    downloadLink.download = filename;

	    // We have to create a link to the file
	    downloadLink.href = window.URL.createObjectURL(csvFile);

	    // Make sure that the link is not displayed
	    downloadLink.style.display = "none";

	    // Add the link to your DOM
	    document.body.appendChild(downloadLink);

	    // Lanzamos
	    downloadLink.click();
	}

	function export_table_to_csv() {
		//document.write(5 + 6);
		var csv = [];
		var rows = document.querySelectorAll("table tbody tr");
		
		//document.write(rows.length);
		
	    for (var i = 0; i < rows.length; i++) {
			var row = [], cols = rows[i].querySelectorAll("td");
			
	        for (var j = 0; j < cols.length; j++) 
	            row.push(cols[j].innerText);
	        
			csv.push(row.join(","));		
		}

	    // Download CSV
	    download_csv(csv.join("\n"), "table.csv");
	}

	document.querySelector("button").addEventListener("click", function () {
	    var html = document.querySelector("table").outerHTML;
		export_table_to_csv();
	});


</script>

	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Report
				</div>
				<div class="card-body">




					<div class="form-group">
						<div class="row">
							<div class="col-3">
								<label>Start Date</label> <input class="form-control" type=text
									name="start" required id="start">
							</div>
							<div class="col-3">
								<label>End Date</label> <input class="form-control" type="text"
									name="end" required id="end">

							</div>
						</div>
					</div>


					<div class="form-group">
						<div class="row">
							<div class="col-3">
								<select class="custom-select custom-select-lg mb-3"
									name="formName" id="formName">
									<option value="">Upazila</option>
									<!-- <c:forEach items="${formNames}" var="formName">
											<option value="${formName}">${formName}</option>
										</c:forEach> -->

								</select>
							</div>

							<!-- <div class="col-3">
									<select class="custom-select custom-select-lg mb-3"
										name="provider" id="provider">
										<option value="">Please Select Provider</option>
										<c:forEach items="${providers}" var="provider">
											<option value="${provider.getProvider()}">${provider.getProvider()}</option>
										</c:forEach>
									</select>
								</div> -->
						</div>
					</div>


					<div class="table-responsive">
						<div id="dataTable_wrapper"
							class="dataTables_wrapper container-fluid dt-bootstrap4">
							<div class="row">
								<div class="col-sm-12">
									<table id="example1" class="table table-bordered dataTable"
										style="width: 100%;">
										<thead>
											<tr>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Form</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Scheduled</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Completed</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Expired</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">% of Expired</th>
											</tr>
										</thead>
										<tbody>
											<tr class="even">
												<td>ANCRV1</td>
												<td>${ANC1}</td>
												<td>${ANC1Completed}</td>
											</tr>
											<tr class="even">
												<td>ANCRV2</td>
												<td>${ANC2}</td>
											</tr>
											<tr class="even">
												<td>ANCRV3</td>
												<td>${ANC3}</td>
											</tr>
											<tr class="even">
												<td>ANCRV4</td>
												<td>${ANC4}</td>
											</tr>
										</tbody>
									</table>

								</div>
							</div>
						</div>
					</div>
					
<!-- <input value="Export as CSV 2" type="button" onclick="$('#example1').table2CSV({header:['Form','Scheduled','Completed']})">  -->
					
					
					
					<button onclick="export_table_to_csv()">Export HTML table to CSV file</button>
				</div>
				<div class="card-footer small text-muted"></div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>


<script src="<c:url value='/resources/js/jquery-ui.js' />"></script>
<script src="<c:url value='/resources/js/datepicker.js' />"></script>
<script src="<c:url value='/resources/js/html2csv.js' />"></script>
</html>