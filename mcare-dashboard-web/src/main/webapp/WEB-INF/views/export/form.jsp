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
 <div th:fragment="header">
    <!-- this is header -->
    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
               <a href = "<c:url value = "/"/>">Home</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <a href = "<c:url value = "/"/>">Home</a>
                </ul>
            </div>
        </div>
    </nav>
</div>
 <div class="container">
     <div class="row">               
         <div class="col-md-12">
             <form class="form-horizontal" id="search-form">
             <div class="form-group form-group-lg">
              <label class="col-sm-2 control-label">FormName</label>
              <div class="col-sm-10">
               <input type="text" name="formName" class="form-control" id="formName">
              </div>
            </div>
            <div class="form-group form-group-lg">
              <label class="col-sm-2 control-label">Provider</label>
              <div class="col-sm-10">
               <input type="text" name="provider" class="form-control" id="provider">
              </div>
            </div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Start</label>
				<div class="col-sm-10">
					<input type=text name="start"  class="form-control" id="start">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">End</label>
				<div class="col-sm-10">
					<input type="text" name="end" class="form-control" id="end">
				</div>
			</div>
   

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="bth-search"
						class="btn btn-primary btn-lg">Search</button>
				</div>
			</div>
		</form>

        </div>
              
    </div>
 </div> 

 <a href="" id="download">Download</a>
   
  </body>
  
  <script src="<c:url value='/resources/js/jquery-1.12.4.js' />"></script>
    <script src="<c:url value='/resources/js/jquery-ui.js' />"></script>
    
    
    
     <script>
  $( function() {
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
  } ); 
  </script>
  
  
  
  <script>
 jQuery(document).ready(function($) {

  $("#search-form").submit(function(event) {
	 
   // Disble the search button
  // enableSearchButton(false);

   // Prevent the form from submitting via the browser.
   event.preventDefault();
  /* $("p").text( "Hiiiiiiiiiiiiiii");
   window.location = "/log?roleName=name"; */
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
   
   success : function(data) {
    console.log("SUCCESS: ", data);
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