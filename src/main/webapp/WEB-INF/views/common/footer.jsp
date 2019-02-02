<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
<script type="text/javascript">
$(document).ready( function () {
    $('#tableResult').DataTable({
    	
    	"paging":   false,
        "ordering": false,
        "filter":false, 
        "info":     false
    });
} );



$(document).ready( function () {
    $('#tableTrade').DataTable({
    	
    	"paging":   false,
        "ordering": false,
        "search":     false,
        "filter":false, 
        "info":     false
    	
    });
} );

$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})
	
	$(document).ready(function() {
    $('.js-example-basic-multiple').select2();
});
	
</script>
</body>
</html>