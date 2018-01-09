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
    <title>Data Export</title>
    
   <link  type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
   <link  type="text/css" href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
   <link  type="text/css" href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">
    <link  type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet">

  </head>
 <%--  <c:set var="url" value="<c:url value="/" />" /> --%>
 <body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <c:url var="saveUrl" value="/export" />
  <c:url var="homeUrl" value="/" />
  <c:url var="home" value="/log" scope="request" />
 
 
 
 
  <!-- Navigation-->
  <jsp:include page="/WEB-INF/views/navbar.jsp"/>
  <div class="content-wrapper">    
   
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Data Export</div>
      <div class="card-body">
        <form class="form-horizontal" id="search-form">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                
                <label for="exampleInputPassword1">End Date</label>
                <input class="form-control" type="text" name="end" required id="end">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Start Date</label>
                <input  class="form-control" type=text name="start"  required id="start">
                
              </div>
            </div>
          </div>
          
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
               <label for="exampleInputName">FormName</label>
                 <select name="formName" id="formName" required>
                <option value="">Please Select FormName</option>
                 <c:forEach items="${formNames}" var="formName">    
                   <option value="${formName}">${formName}</option>
                 </c:forEach>
              
               </select>
              </div>
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Provider</label>
                <select name="provider"id="provider">
                <option value="">Please Select Provider</option>
                 <c:forEach items="${providers}" var="provider">    
                   <option value="${provider.getProvider()}">${provider.getProvider()}</option>
                 </c:forEach>
              
               </select>
              </div>
            </div>
          </div>
         <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="bth-search"
						class="btn btn-primary btn-lg">Generate CSV</button>
				</div>
			</div>
        </form>
       
      </div>
   
  </div>
       <img id="loader" src="<c:url value="/"/>resources/images/loading-middle.gif" style="display: none;" />
  <table class="table table-hover" id="dev-table" style="display: none;">
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
       
      
  </div>
  <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2018</small>
        </div>
      </div>
    </footer>
   


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
   url : "${homeUrl}search?start="+$("#start").val()+"&end="+$("#end").val()+"&provider="+$("#provider").val()+"&formName="+$("#formName").val(),
 //  data : JSON.stringify(search),
   dataType : 'json',
   timeout : 100000,
   beforeSend: function() {
    
    $('#dev-table').hide(); 
    $('#loader').show(); 
   },
   success : function(data) {
    console.log("SUCCESS: ", data);
    $('#loader').hide();
    $('#dev-table').show(); 
    $('#download').show();
    $('#fileName').html(data);
    $("a#download").attr('href', 
    '/opt/multimedia/export/'+data);
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
 
 
    <script src="<c:url value='/resources/js/bootstrap.bundle.min.js' />"></script>
 
</html>