
function getLocationHierarchy(url,id) { 
  $.ajax({
   type : "GET",
   contentType : "application/json",
   url : url,
 
   dataType : 'html',
   timeout : 100000,
   beforeSend: function() {
    
   
   },
   success : function(data) {
   
    $("#"+id).html(data);
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