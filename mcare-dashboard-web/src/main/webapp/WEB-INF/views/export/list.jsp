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

<title>Export List</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
</head>
<c:url var="saveUrl" value="/role/add" />
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />

	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Export List
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>User</th>
									<th>File Name</th>
									<th>Created Date</th>
									<th>Action</th>

								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>User</th>
									<th>File Name</th>
									<th>Created Date</th>
									<th>Action</th>

								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${exports}" var="export">
									<tr>
										<td>${export.getUser()}</td>
										<td>${export.getReportName()}</td>
										<td>${export.getCraeted()}</td>
										<td><a
											href="/opt/multimedia/export/${export.getReportName()}">Download</a></td>
									</tr>
								</c:forEach>
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
	</div>
</body>
<script src="<c:url value='/resources/js/jquery-1.12.4.js' />"></script>
<script src="<c:url value='/resources/js/jquery-ui.js' />"></script>
<script src="<c:url value='/resources/js/datepicker.js' />"></script>
<script>
	jQuery(document).ready(function($) {

		$("#search-form").submit(function(event) {

			// Disble the search button
			// enableSearchButton(false);

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			// window.location = "/log?roleName=name"; 
			searchViaAjax();
		});

	});

	function searchViaAjax() {

		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "${homeUrl}search?start=" + $("#start").val() + "&end="
					+ $("#end").val() + "&provider=" + $("#provider").val()
					+ "&formName=" + $("#formName").val(),
			//  data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			beforeSend : function() {

				$('#dev-table').hide();
				$('#loader').show();
			},
			success : function(data) {
				console.log("SUCCESS: ", data);
				$('#loader').hide();
				$('#dev-table').show();
				$('#download').show();
				$('#fileName').html(data);
				$("a#download").attr('href', '/opt/multimedia/export/' + data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {

				console.log("DONE");
				//enableSearchButton(true);
			}
		});

	}

	function enableSearchButton(flag) {
		$("#btn-search").prop("disabled", flag);
	}

	function display(data) {
		var json = "<h4>Ajax Response</h4><pre>"
				+ JSON.stringify(data, null, 4) + "</pre>";
		$('#feedback').html(json);
	}
</script>

</html>