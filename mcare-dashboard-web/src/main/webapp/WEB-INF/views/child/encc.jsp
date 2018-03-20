<%@page import="org.mcare.etl.entity.ENCCEntity"%>
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

	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> <a href="/child.html">Child List</a> /
					${encclist.size()} ENCC of ${child.getFirstName()}
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
													style="width: 140px;">ENCC Name</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Current Form Status</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Received Time</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">Start Date</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 106px;">End Date</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 106px;">ENCC Date</th>
											</tr>
										</thead>
										<tbody>
											<%
												List<ENCCEntity> enccList = (List<ENCCEntity>) session
														.getAttribute("encclist");
												for (ENCCEntity encc : enccList) {
											%>
											<tr class="even">
												<td><%=encc.getEnccName()%></td>
												<td><%=encc.getEncc_current_formStatus()%></td>
												<td><%=encc.getReceived_time()%></td>
												<td><%=encc.getSTART_DATE()%></td>
												<td><%=encc.getEND_DATE()%></td>
												<td><%=encc.getFWENCCDATE()%></td>
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
				<div class="card-footer small text-muted"></div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>