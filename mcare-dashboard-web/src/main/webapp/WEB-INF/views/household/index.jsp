 <%@page import="org.mcare.etl.entity.HouseholdEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="__csrf_parameter" content="${__csrf_parameter}"/>
    <title>Household information</title>
    
    <link  type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
  
    <link  type="text/css" href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <link  type="text/css" href="<c:url value="/resources/datatables/dataTables.bootstrap4.css"/>" rel="stylesheet">
    <link  type="text/css" href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">
    
  </head>
  <%
    List<HouseholdEntity>  households = (List<HouseholdEntity>)session.getAttribute("dataList");
    List<Integer>  pageList = (List<Integer>)session.getAttribute("pageList");
    String offSet = request.getParameter("offSet");
     /* disabledLINK has been used to to make current page number nonhiperlink i.e unclickable
     e.g if user is at page number 15 then page number 15 should not be clickable*/
    int disabledLINK = 0;
    if(offSet!=null){
     disabledLINK = Integer.parseInt(offSet);
    }
    /* size is used for moving user to end page  by clicking on END link*/
    int   size = Integer.parseInt(session.getAttribute("size").toString());
      
    List<Object[]>  parentDataList = (List<Object[]>)session.getAttribute("parentData");
 %>
  
  
  
<body>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <jsp:include page="/WEB-INF/views/navbar.jsp"/>
  
  <div class="content-wrapper">    
      
        <div class="card-header">
          <i class="fa fa-table"></i> Household list</div>
        <div class="card-body">
          <div class="table-responsive">
            <div id="dataTable_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
            <div class="row">  
               <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Division 
                       <select id="division" name="dataTable_length" aria-controls="dataTable" class="form-control form-control-sm">
                        <option value="">Please Select </option>
  <%                    for (Object[] objects : parentDataList) {
                             %>
                              <option value=<%=objects[1]%>><%=objects[0]%></option>
   <% 
                        }
   %>
                           
                       </select> </label>
                
                   </div>
                </div>
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>District 
                     
                      <select id="district" name="dataTable_length" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="10">Please Select</option>
                           
                       </select>
                      
                      
                      </label>
                
                   </div>
                </div>  
                
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Upazilla                   
                      <select id="upazila" name="dataTable_length" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0">Please Select</option>                           
                       </select>                     
                       </label>
                
                   </div>
                </div>  
                
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Union 
                       <select id="union" name="dataTable_length" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0">Please Select</option>                           
                       </select>  </label>
                
                   </div>
                </div> 
             </div> 
             <div class="row">
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Ward 
                      <select id="ward" name="dataTable_length" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0">Please Select</option>                           
                       </select> </label>
                
                   </div>
                </div>  
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Subunit 
                       <select id="subunit" name="dataTable_length" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0">Please Select</option>                           
                       </select> </label>
                
                   </div>
                </div>  
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Mauzapara 
                       <select id="mauzapara" name="dataTable_length" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0">Please Select</option>                           
                       </select> </label>
                
                   </div>
                </div>  
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Provider 
                       <select name="dataTable_length" aria-controls="dataTable" class="form-control form-control-sm">
                          <option value="">Please Select Provider</option>
                          <c:forEach items="${providers}" var="provider">    
                              <option value="${provider.getProvider()}">${provider.getProvider()}</option>
                          </c:forEach>
                       </select> </label>
                
                   </div>
                </div> 
              </div>   
               <div class="row">        
                <div class="col-sm-12 col-md-3">
                    <div id="dataTable_filter" class="dataTables_filter"><label>Search:<input class="form-control form-control-sm" placeholder="" aria-controls="dataTable" type="search"></label></div>
                </div>
                </div>
            </div>
            
            <div class="row">
            <div class="col-sm-12">
            
            <table class="table table-bordered dataTable" id="dataTable" role="grid" aria-describedby="dataTable_info" style="width: 100%;" cellspacing="0" width="100%">
              
              
              <thead>
                <tr role="row"><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width: 140px;">Name</th><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width: 79px;">Provider</th><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width: 106px;">FWGOBHHID</th><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width: 43px;">FWJIVHHID</th><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width: 140px;" >Registration Date</th><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width:  225px;" >Case Id</th></tr>
              </thead>
              
              <tbody>
                <%
                for(HouseholdEntity household:households){ %>
                    <tr role="row" class="even">
                        <td><%=household.getFirstName()%></td>
                        <td><%=household.getProvider()%></td>                       
                        <td><%=household.getFWGOBHHID()%></td>
                        <td><%=household.getFWJIVHHID()%></td>
                        <td><%=household.getRegistrationDate()%></td>
                         <td><%=household.getCaseId()%></td>
                    </tr>
                <%} %>
                
                </tbody>
            </table>
            </div>
            </div>
            <div class="row">
              
                   <div class="col-sm-12 col-md-7"><div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
                       <ul class="pagination">
                       
                       <%if(disabledLINK != 0){ %>
                        <li class="paginate_button page-item previous" id="dataTable_previous">
                           <a aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link" href="household.html?offSet=<%=0%>">Start</a>
                           </li>  
                           
                           <li class="paginate_button page-item previous" id="dataTable_previous">
                           <a aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link" href="household.html?offSet=<%=disabledLINK-1%>">Previous</a>
                           </li>   
                       <%} %>
                                               
                       <%
                          for(Integer i:pageList) {
                              if(disabledLINK == i ){
                                  if(disabledLINK!=size){%>
                                      <li class="paginate_button page-item disabled">                              
                                  <a aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link" href="household.html?offSet=<%=i%>"><%=i+"" %></a></li>
                      <%          }
                              }else{ %>
                              <li class="paginate_button page-item active">                              
                                  <a aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link" href="household.html?offSet=<%=i%>"><%=i+"" %></a></li><%                                  
                              } 
                          } %>                        
                           <%
                               if(disabledLINK == size){ %>
                               
               <%
                               }else{
                           %> 
                            <li class="paginate_button page-item next" id="dataTable_next">
                                  <a aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link" href="household.html?offSet=<%=disabledLINK+1%>">Next</a>
                                  </li>
                            <li class="paginate_button page-item next" id="dataTable_next">
                                  <a aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link" href="household.html?offSet=<%=size%>">End</a>
                                  </li>
                         <%
                               } %>
                                         
                          
                      
                       </ul>
                    </div>
               </div>
               </div>
               </div>
          </div>
        </div>
       
      
   
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright � Your Website 2018</small>
        </div>
      </div>
    </footer>
   
<script src="<c:url value='/resources/js/jquery.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.bundle.min.js' />"></script>
<script src="<c:url value='/resources/js/location.js' />"></script>

</body>

 <script>
 jQuery(document).ready(function($) {
  	$("#division").change(function(event) {   
		//event.preventDefault();
		getLocationHireachy("/location?id="+$("#division").val(),"district") ;
  	});
  
  	$("#district").change(function(event) {   
		//event.preventDefault(); 
		getLocationHireachy("/location?id="+$("#district").val(),"upazila") ;
	});
  	$("#upazila").change(function(event) {   
		//event.preventDefault(); 
		getLocationHireachy("/location?id="+$("#upazila").val(),"union") ;
	});
  	$("#union").change(function(event) {   
		//event.preventDefault(); 
		getLocationHireachy("/location?id="+$("#union").val(),"ward") ;
	});
  	$("#ward").change(function(event) {   
		//event.preventDefault(); 
		getLocationHireachy("/location?id="+$("#ward").val(),"subunit") ;
	});
  	$("#subunit").change(function(event) {   
		//event.preventDefault(); 
		getLocationHireachy("/location?id="+$("#subunit").val(),"mauzapara") ;
	});

 });
 </script>


</html> 