<%@page import="org.mcare.etl.entity.MotherEntity"%>
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
					<i class="fa fa-table"></i> Mother List
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
													style="width: 140px;">Mother Name</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">Provider</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 43px;">JIVITA HHID</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Registration Date</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 225px;">Mother LMP</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 225px;">Visits (Completed)</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 225px;">Visits (Pending)</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Mother Name</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">Provider</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 43px;">JIVITA HHID</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Registration Date</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 225px;">Mother LMP</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 225px;">Visits (Completed)</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 225px;">Visits (Pending)</th>
											</tr>
										</tfoot>
										<tbody>
											<%
												List<MotherEntity> mothers = (List<MotherEntity>) session
														.getAttribute("dataList");
												for (MotherEntity mother : mothers) {
													pageContext.setAttribute("id", mother.getId());
											%>
											<tr class="even">
												<td><a href="<c:url value="mother/${id}/view.html"/>"><%=mother.getFirstName()%></a></td>
												<td><%=mother.getProvider()%></td>
												<td><%=mother.getMotherJIVIHID()%></td>
												<td><%=mother.getRegistrationDate()%></td>
												<td><%=mother.getMotherWomLMP()%></td>
												<td><a
													href="<c:url value="mother/${id}/visits_completed.html"/>">View
														Details</a></td>
												<td><a
													href="<c:url value="mother/${id}/visits_pending.html"/>">View
														Details</a>
														<!-- <div class="row"> test1 </div>
														<div class="row"> test2</div> -->
														</td>
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