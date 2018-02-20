 <%@page import="org.mcare.acl.entity.ProviderEntity"%>
<%@page import="org.mcare.etl.entity.HouseholdEntity"%>
  <%@page import="org.mcare.common.util.PaginationHelperUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
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
    List<ProviderEntity>  providers = (List<ProviderEntity>)session.getAttribute("providers");
    List<Integer>  pageList = (List<Integer>)session.getAttribute("pageList");
    String offSet = request.getParameter("offSet");
    
    Map<String,String>  paginationAtributes = (Map<String,String>)session.getAttribute("paginationAtributes");
    String division ="";
    int divId =  0;
    if(paginationAtributes.containsKey("divId")){
        divId = Integer.parseInt(paginationAtributes.get("divId"));
    }
   
    int distId =0;
    if(paginationAtributes.containsKey("distId")){
        distId = Integer.parseInt(paginationAtributes.get("distId"));
    }
  
    int upzilaId =0;
    if(paginationAtributes.containsKey("upzilaId")){
    	upzilaId = Integer.parseInt(paginationAtributes.get("upzilaId"));
    }
    String union="";
    int unionId =0;
    if(paginationAtributes.containsKey("unionId")){
    	unionId = Integer.parseInt(paginationAtributes.get("unionId"));
    }
   
    int wardId =0;
    if(paginationAtributes.containsKey("wardId")){
    	wardId = Integer.parseInt(paginationAtributes.get("wardId"));
    }
   
    int subunitId =0;
    if(paginationAtributes.containsKey("subunitId")){
    	subunitId = Integer.parseInt(paginationAtributes.get("subunitId"));
    }
   
    int mauzaparaId =0;
    if(paginationAtributes.containsKey("mauzaparaId")){
    	mauzaparaId = Integer.parseInt(paginationAtributes.get("mauzaparaId"));
    }
    
    String provider="";
    if(paginationAtributes.containsKey("provider")){
    	provider = paginationAtributes.get("provider");
    }
       
    String name="";
    if(paginationAtributes.containsKey("name")){
    	name = paginationAtributes.get("name");
    }
   
    
   // String paginationLink = divisionLink+districtLink+upazilaLink+unionLink + subunitLink+mauzaparaLink+providerLink+nameLink+searchLink;
     /* disabledLINK has been used to to make current page number nonhiperlink i.e unclickable
     e.g if user is at page number 15 then page number 15 should not be clickable*/
     String paginationLink = "";
     if(paginationAtributes.containsKey("paginationLink")){
      paginationLink = paginationAtributes.get("paginationLink");
     }
     int disabledLINK = 0;
    if(offSet!=null){
     disabledLINK = Integer.parseInt(offSet);
    }
    /* size is used for moving user to end page  by clicking on END link*/
    int   size = Integer.parseInt(session.getAttribute("size").toString());
    
    List<Object[]>  parentDataList = (List<Object[]>)session.getAttribute("parentData");
    List<Object[]>  districts = (List<Object[]>)session.getAttribute("districtListByParent");
    List<Object[]>  upazilas = (List<Object[]>)session.getAttribute("upazilasListByParent");
    List<Object[]>  unions = (List<Object[]>)session.getAttribute("unionsListByParent");
    List<Object[]>  wards = (List<Object[]>)session.getAttribute("wardsListByParent");
    List<Object[]>  subuits = (List<Object[]>)session.getAttribute("subunitListByParent");
    List<Object[]>  mauzaparas = (List<Object[]>)session.getAttribute("mauzaparaListByParent");
   
 %>
  
  
  

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <jsp:include page="/WEB-INF/views/navbar.jsp"/>
  
  <div class="content-wrapper">    
      
        <div class="card-header">
          <i class="fa fa-table"></i> Household list <%=divId%></div>
        <div class="card-body">
          <div class="table-responsive">
           <form  id="search-form">
            <div id="dataTable_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
              <div class="row">  
               <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Division 
                       <select id="division" name="division" aria-controls="dataTable" class="form-control form-control-sm">
                        <option value="0?">Please Select </option>
  <%                    for (Object[] objects : parentDataList) { 
                            if(divId ==((Integer) objects[1]).intValue()){ %>
                            	<option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>   
                            	<%   }else{
                         %>
                             <option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>   <% 
                           }
                         }
   %>
                           
                       </select> </label>
                
                   </div>
                </div>
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>District 
                     
                      <select id="district" name="district" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0?">Please Select</option>
        <%                  if(districts!=null){ 
                                for (Object[] objects : districts) { 
                                     if(distId ==((Integer) objects[1]).intValue()){ %>
                                      <option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>   
                                      <%   }else{
                                  %>
                                      <option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>   <% 
                                    }
                                }
                            }
        %>
       
                           
                       </select>
                      
                      
                      </label>
                
                   </div>
                </div>  
                
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Upazilla                   
                      <select id="upazila" name="upazila" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0?">Please Select</option>
  <%                      if(upazilas!=null){ 
                                  for (Object[] objects : upazilas) { 
                                       if(upzilaId ==((Integer) objects[1]).intValue()){ %>
                                        <option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>   
                                        <%   }else{
                                    %>
                                        <option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>   <% 
                                      }
                                  }
                              }
   %>                       </select>                     
                       </label>
                
                   </div>
                </div>  
                
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Union 
                       <select id="union" name="union" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0?">Please Select</option>
   <%                      if(unions!=null){ 
                                  for (Object[] objects : unions) { 
                                       if(unionId ==((Integer) objects[1]).intValue()){ %>
                                        <option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>   
                                        <%   }else{
                                    %>
                                        <option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>   <% 
                                      }
                                  }
                              }
   %>                              
                       </select>  </label>
                
                   </div>
                </div> 
             </div> 
             <div class="row">
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Ward 
                      <select id="ward" name="ward" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0?">Please Select</option>  
  <%                      if(wards!=null){ 
                                  for (Object[] objects : wards) { 
                                       if(wardId ==((Integer) objects[1]).intValue()){ %>
                                        <option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>   
                                        <%   }else{
                                    %>
                                        <option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>   <% 
                                      }
                                  }
                              }
   %>                           
                       </select> </label>
                
                   </div>
                </div>  
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Subunit 
                       <select id="subunit" name="subunit" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0?">Please Select</option>  
  <%                      if(subuits!=null){ 
                                  for (Object[] objects : subuits) { 
                                       if(subunitId ==((Integer) objects[1]).intValue()){ %>
                                        <option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>   
                                        <%   }else{
                                    %>
                                        <option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>   <% 
                                      }
                                  }
                              }
   %>                                                    
                       </select> </label>
                
                   </div>
                </div>  
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Mauzapara 
                       <select id="mauzapara" name="mauzapara" aria-controls="dataTable" class="form-control form-control-sm">
                           <option value="0?">Please Select</option>
 <%                         if(mauzaparas!=null){ 
                                  for (Object[] objects : mauzaparas) { 
                                       if(mauzaparaId ==((Integer) objects[1]).intValue()){ %>
                                        <option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>   
                                        <%   }else{
                                    %>
                                        <option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>   <% 
                                      }
                                  }
                              }
   %>                             
                       </select> </label>
                
                   </div>
                </div>  
                 <div class="col-sm-12 col-md-3">
                   <div class="dataTables_length" id="dataTable_length"><label>Provider 
                       <select name="provider" aria-controls="dataTable" class="form-control form-control-sm">
                          <option value="">Please Select</option>
  <%                         if(providers!=null){ 
                                  for (ProviderEntity objects : providers) { 
                                       if(provider.equalsIgnoreCase(objects.getProvider())){ %>
                                        <option value="<%=objects.getProvider()%>" selected><%=objects.getProvider()%></option>   
                                        <%   }else{
                                    %>
                                        <option value="<%=objects.getProvider()%>"><%=objects.getProvider()%></option>   <% 
                                      }
                                  }
                              }
   %> 
                       </select> </label>
                
                   </div>
                </div> 
              </div>   
               <div class="row">        
                 <div class="col-sm-12 col-md-8">
                     <div id="name" class="name"><label>Name <input name="name" class="form-control form-control-sm" value="<%=name%>" placeholder="" aria-controls="dataTable" type="search"></label></div>
                 </div>
                 <div class="col-sm-12 col-md-4">
                    <div class="col-sm-offset-2 col-sm-4">
 					<button name="search" type="submit" id="bth-search"
 						class="btn btn-primary btn-lg" value="search">Search</button>
 				   </div>
                 </div>
                </div>
            </div>
          </form>
            
            
            
            <div class="row">
            <div class="col-sm-12">
            
            <table class="table table-bordered dataTable" id="dataTable" role="grid" aria-describedby="dataTable_info" style="width: 100%;" cellspacing="0" width="100%">
              
              
              <thead>
                <tr role="row"><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width: 140px;">Name</th><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width: 79px;">Provider</th><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width: 106px;">FWGOBHHID</th><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width: 43px;">FWJIVHHID</th><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width: 140px;" >Registration Date</th><th  tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" style="width:  225px;" >Case Id</th></tr>
              </thead>
              
              <tbody>
             
                <%
                for(HouseholdEntity household:households){                 	
                	pageContext.setAttribute("id", household.getId());
                %>
                    <tr role="row" class="even">
                        <td><a href="<c:url value="/${id}/view.html"/>"><%=household.getFirstName()%></a></td>
                      <td> <%=household.getProvider()%></td>             
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
                           <a aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link" href="?offSet=<%=0%><%=paginationLink%>">Start</a>
                           </li>  
                           
                           <li class="paginate_button page-item previous" id="dataTable_previous">
                           <a aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link" href="?offSet=<%=disabledLINK-1%><%=paginationLink%>">Previous</a>
                           </li>   
                       <%} %>
                                               
                       <%
                          for(Integer i:pageList) {
                              if(disabledLINK == i ){
                                  if(disabledLINK!=size){%>
                                      <li class="paginate_button page-item disabled">                              
                                  <a aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link" href="household.html?offSet=<%=i%><%=paginationLink%>"><%=i+"" %></a></li>
                      <%          }
                              }else{ %>
                              <li class="paginate_button page-item active">                              
                                  <a aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link" href="household.html?offSet=<%=i%><%=paginationLink%>"><%=i+"" %></a></li><%                                  
                              } 
                          } %>                        
                           <%
                               if(disabledLINK == size){ %>
                               
               <%
                               }else{
                           %> 
                            <li class="paginate_button page-item next" id="dataTable_next">
                                  <a aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link" href="household.html?offSet=<%=disabledLINK+1%><%=paginationLink%>">Next</a>
                                  </li>
                            <li class="paginate_button page-item next" id="dataTable_next">
                                  <a aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link" href="household.html?offSet=<%=size%><%=paginationLink%>">End</a>
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
          <small>Copyright © mpower-social enterprise ltd 2018</small>
        </div>
      </div>
    </footer>
   
<script src="<c:url value='/resources/js/jquery.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.bundle.min.js' />"></script>
<script src="<c:url value='/resources/js/location.js' />"></script>

</body>

 


</html> 