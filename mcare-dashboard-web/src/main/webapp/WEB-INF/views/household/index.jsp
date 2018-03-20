<%@page import="org.mcare.etl.entity.HouseholdEntity"%>
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

			<jsp:include page="/WEB-INF/views/searchPanel.jsp" />

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Household List
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
													style="width: 140px;">Household Head Name</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">Provider</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 106px;">GOB HHID</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 43px;">JIVITA HHID</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Registration Date</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 225px;">Case Id</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Household Head Name</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">Provider</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 106px;">GOB HHID</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 43px;">JIVITA HHID</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Registration Date</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 225px;">Case Id</th>
											</tr>
										</tfoot>
										<tbody>
											<%
												List<HouseholdEntity> households = (List<HouseholdEntity>) session
														.getAttribute("dataList");
												for (HouseholdEntity household : households) {
													pageContext.setAttribute("id", household.getId());
											%>
											<tr class="even">
												<td><a
													href="<c:url value="household/${id}/view.html"/>"><%=household.getFirstName()%></a></td>
												<td><%=household.getProvider()%></td>
												<td><%=household.getFWGOBHHID()%></td>
												<td><%=household.getFWJIVHHID()%></td>
												<td><%=household.getRegistrationDate()%></td>
												<td><%=household.getCaseId()%></td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>

								</div>
							</div>

							<jsp:include page="/WEB-INF/views/pager.jsp" />

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