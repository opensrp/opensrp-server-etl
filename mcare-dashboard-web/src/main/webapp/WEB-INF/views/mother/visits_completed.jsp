<%@page import="org.mcare.etl.entity.ANCEntity"%>
<%@page import="org.mcare.etl.entity.BNFEntity"%>
<%@page import="org.mcare.etl.entity.PNCEntity"%>
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
					<i class="fa fa-table"></i> <a href="/mother.html">Mother List</a>
					/ Completed Visits of ${mother.getFirstName()} ( ${anclist.size()}
					ANC, ${bnflist.size()} BNF, ${pnclist.size()} PNC )
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<div id="dataTable_wrapper"
							class="dataTables_wrapper container-fluid dt-bootstrap4">


							<div class="row">
								<div class="card mb-3">
									<div class="card-header">
										<i class="fa fa-table"></i> ${anclist.size()} Completed ANC
										Visits
									</div>
									<div class="card-body">
										<div class="table-responsive">
											<div id="dataTable_wrapper"
												class="dataTables_wrapper container-fluid dt-bootstrap4">
												<div class="row">
													<div class="col-sm-12">
														<table class="table table-bordered dataTable"
															id="dataTable" style="width: 100%;">
															<thead>
																<tr>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 140px;">ANC Name</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 140px;">Current Form Status</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 140px;">Received Time</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 79px;">Start Date</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 106px;">End Date</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 106px;">ANC Date</th>
																</tr>
															</thead>
															<tbody>
																<%
																	List<ANCEntity> anclist = (List<ANCEntity>) session
																			.getAttribute("anclist");
																	for (ANCEntity anc : anclist) {
																%>
																<tr class="even">
																	<td><%=anc.getAncName()%></td>
																	<td><%=anc.getAnc_current_formStatus()%></td>
																	<td><%=anc.getReceived_time()%></td>
																	<td><%=anc.getStart()%></td>
																	<td><%=anc.getEnd()%></td>
																	<td><%=anc.getFWANCDATE()%></td>
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



							<div class="row">
								<%
									List<BNFEntity> bnflist = (List<BNFEntity>) session
											.getAttribute("bnflist");
									if (bnflist != null && !bnflist.isEmpty()) {
								%>
								<div class="card mb-3">
									<div class="card-header">
										<i class="fa fa-table"></i> ${bnflist.size()} Completed BNF
										Visits
									</div>
									<div class="card-body">
										<div class="table-responsive">
											<div id="dataTable_wrapper"
												class="dataTables_wrapper container-fluid dt-bootstrap4">
												<div class="row">
													<div class="col-sm-12">
														<table class="table table-bordered dataTable"
															id="dataTable" style="width: 100%;">
															<thead>
																<tr>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 140px;">Date of Outcome</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 140px;">BNF Status</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 140px;">User Type</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 140px;">Received Time</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 79px;">Start Date</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 106px;">End Date</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 106px;">BNF Date</th>
																</tr>
															</thead>
															<tbody>
																<%
																	for (BNFEntity bnf : bnflist) {
																%>
																<tr class="even">
																	<td><%=bnf.getFWBNFDTOO()%></td>
																	<td><%=bnf.getFWBNFSTS()%></td>
																	<td><%=bnf.getUser_type()%></td>
																	<td><%=bnf.getReceived_time()%></td>
																	<td><%=bnf.getStart()%></td>
																	<td><%=bnf.getEnd()%></td>
																	<td><%=bnf.getFWBNFDATE()%></td>
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
								<%
									}
								%>
							</div>


							<div class="row">
								<%
									List<PNCEntity> pnclist = (List<PNCEntity>) session
											.getAttribute("pnclist");
									if (pnclist != null && !pnclist.isEmpty()) {
								%>
								<div class="card mb-3">
									<div class="card-header">
										<i class="fa fa-table"></i> ${pnclist.size()} Completed PNC
										Visits
									</div>
									<div class="card-body">
										<div class="table-responsive">
											<div id="dataTable_wrapper"
												class="dataTables_wrapper container-fluid dt-bootstrap4">
												<div class="row">
													<div class="col-sm-12">
														<table class="table table-bordered dataTable"
															id="dataTable" style="width: 100%;">
															<thead>
																<tr>

																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 140px;">PNC Name</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 140px;">Current Form Status</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 140px;">Received Time</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 79px;">Start Date</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 106px;">End Date</th>
																	<th tabindex="0" rowspan="1" colspan="1"
																		style="width: 106px;">PNC Date</th>
																</tr>
															</thead>
															<tbody>
																<%
																	for (PNCEntity pnc : pnclist) {
																%>
																<tr class="even">
																	<td><%=pnc.getPncName()%></td>
																	<td><%=pnc.getPnc_current_formStatus()%></td>
																	<td><%=pnc.getReceived_time()%></td>
																	<td><%=pnc.getStart()%></td>
																	<td><%=pnc.getEnd()%></td>
																	<td><%=pnc.getFWPNCDATE()%></td>
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
								<%
									}
								%>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>