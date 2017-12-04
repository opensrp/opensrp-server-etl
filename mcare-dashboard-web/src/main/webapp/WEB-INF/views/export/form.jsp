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
    <title>Add user information</title>
    
    <link  type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link  type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet">

  </head>
  <body>
  <c:url var="saveUrl" value="/export" />
  <c:url var="home" value="/log" scope="request" />
 <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">mCare2 Dashboard</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Home</a></li>
      <li><a href="/logout">Logout</a></li>
      
    </ul>
  </div>
</nav>

 <%-- <c:out value="${name}" /> --%>
 
  
 <div class="container">
     <div class="row">               
         <div class="col-md-8">
             <form class="form-horizontal" id="search-form">
             <div class="form-group form-group-lg">
              <label class="col-sm-2 control-label">FormName</label>
              <div class="col-sm-10">
              <!--  <input type="text" name="formName" class="form-control" > -->
               <select name="formName" id="formName" required>
                <option value="">Please Select FormName</option>
                 <c:forEach items="${formNames}" var="formName">    
                   <option value="${formName}">${formName}</option>
                 </c:forEach>
              
               </select>
              </div>
            </div>
           
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Start Date</label>
				<div class="col-sm-10">
					<input type=text name="start"  required id="start">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">End Date</label>
				<div class="col-sm-10">
					<input type="text" name="end" required id="end">
				</div>
			</div>
            <div class="form-group form-group-lg">
              <label class="col-sm-2 control-label">Provider</label>
              <div class="col-sm-10">              
               <select name="provider"id="provider">
                <option value="">Please Select Provider</option>
                 <c:forEach items="${providers}" var="provider">    
                   <option value="${provider.getProvider()}">${provider.getProvider()}</option>
                 </c:forEach>
              
               </select>
              </div>
            </div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="bth-search"
						class="btn btn-primary btn-lg">Search</button>
				</div>
			</div>
		</form>
  
  <img id="loader" src="/resources/images/loading-middle.gif" style="display: none;" />
  <table class="table table-hover" id="dev-table">
      <thead>
       <tr>        
        <th>File Name</th>
        <th>Action</th>
        
       </tr>
      </thead>
      <tbody>
       <tr>        
        <td><p id ="fileName"> </p></td>
        <td> <a  href="" id="download" style="display: none;">Download</a></td>
       </tr>
      
      </tbody>
     </table>
     
         
         <a  href="" id="download" style="display: none;">Download</a>
        </div>
         <div class="col-md-4">
       
   
         </div>
              
    </div>
 </div> 

  </body>
  
  <script src="<c:url value='/resources/js/jquery-1.12.4.js' />"></script>
    <script src="<c:url value='/resources/js/jquery-ui.js' />"></script>
    
    
    
     <script>
     
     $(function () {
         $("#start").datepicker({
        	 dateFormat: "yy-mm-dd",
        	 maxDate: new Date,
             onSelect: function (selectedDate) {
                 var orginalDate = new Date(selectedDate);
                 var monthsAddedDate = new Date(new Date(orginalDate).setMonth(orginalDate.getMonth() + 3));
                 
                 $("#end").datepicker("option", 'minDate', selectedDate);
                 $("#end").datepicker("option", 'maxDate', monthsAddedDate);
             }
         });

         $("#end").datepicker({
        	 dateFormat: "yy-mm-dd",
        	 maxDate: new Date,
             onSelect: function (selectedDate) {
                 var orginalDate = new Date(selectedDate);
                 var monthsAddedDate = new Date(new Date(orginalDate).setMonth(orginalDate.getMonth() - 3));
               
                 $("#start").datepicker("option", 'minDate', monthsAddedDate);
                 $("#start").datepicker("option", 'maxDate', selectedDate);
             }
         })
     });
 /*  $( function() {
	  var dateToday = new Date();
	     $('#start').datepicker({
	        dateFormat: "yy-mm-dd",
	         minDate: null,
	         maxDate: dateToday,
	           onSelect: function(selected) {
	             $('#end').datepicker("option", "minDate",  
	            		 $("#start").datepicker('getDate') );
	          } 
	     });

	     $('#end').datepicker({
	        dateFormat: "yy-mm-dd",
	         minDate: null,
	         maxDate: dateToday,
	     });  
  } );  */
  </script>
  
  
  
  <script>
 jQuery(document).ready(function($) {

  $("#search-form").submit(function(event) {
	 
   // Disble the search button
  // enableSearchButton(false);

   // Prevent the form from submitting via the browser.
   event.preventDefault();
  
  // window.location = "/log?roleName=name"; 
   searchViaAjax() ;
  });

 });

 function searchViaAjax() {

 
  $.ajax({
   type : "GET",
   contentType : "application/json",
   url : "/search?start="+$("#start").val()+"&end="+$("#end").val()+"&provider="+$("#provider").val()+"&formName="+$("#formName").val(),
 //  data : JSON.stringify(search),
   dataType : 'json',
   timeout : 100000,
   beforeSend: function() {
	   $('#loader').show(); 
   },
   success : function(data) {
    console.log("SUCCESS: ", data);
    $('#loader').hide();
    $('#download').show();
    $('#fileName').html(data);
    $("a#download").attr('href', 
    '/multimedia/export/'+data);
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