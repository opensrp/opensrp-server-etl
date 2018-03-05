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

<title>User List</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
</head>
<c:url var="saveUrl" value="/role/add" />
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />

	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Export CSV
				</div>
				<div class="card-body">
					<form id="search-form">

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
										<option value="">Please Select FormName</option>
										<c:forEach items="${formNames}" var="formName">
											<option value="${formName}">${formName}</option>
										</c:forEach>

									</select>
								</div>

								<div class="col-3">
									<select class="custom-select custom-select-lg mb-3"
										name="provider" id="provider">
										<option value="">Please Select Provider</option>
										<c:forEach items="${providers}" var="provider">
											<option value="${provider.getProvider()}">${provider.getProvider()}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<button type="submit" id="bth-search" class="btn btn-primary">Generate
										CSV</button>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="card-footer small text-muted"></div>
			</div>
			<img id="loader"
				src="<c:url value="/"/>resources/images/loading-middle.gif"
				style="display: none;" />
			<table class="table table-hover" id="dev-table"
				style="display: none;">
				<thead>
					<tr>
						<th>File Name</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td><p id="fileName"></p></td>
						<td><a href="" id="download" style="display: none;">Download</a></td>
					</tr>

				</tbody>
			</table>


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