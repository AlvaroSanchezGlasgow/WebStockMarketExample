<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>


<jsp:include page="common/header.jsp" />

<div class="container" style="margin:auto;text-align: center;">

		<h1>
			Error <small> - Something was wrong!!</small>
		</h1>

<div class="row">
			<div class="table-responsive" style="text-align: center;">
 <table id="tableError" class="table-striped" border="0.2" style="margin: 0 auto;">
        <tr>
            <td>Date</td>
            <td>${timestamp}</td>
        </tr>
        <tr>
            <td>Error</td>
            <td>${error}</td>
        </tr>
        <tr>
            <td>Status</td>
            <td>${status}</td>
        </tr>
        <tr>
            <td>Message</td>
            <td>${message}</td>
        </tr>
        <tr>
            <td>Cause</td>
            <td>${trace}</td>
        </tr>
       <!--   <tr>
            <td>Trace</td>
            <td>
                <pre>${trace}</pre>
            </td>
        </tr>-->
    </table>
</div>
</div>
<br></br>

<button type="button" class="btn btn-danger btn-lg" data-toggle="tooltip" data-placement="top" title="Return to the previous page"  onclick="javascript:window.history.go(-1)">Return to the previous page</button>
  	</div>
  
  
<hr></hr>

<script type="text/javascript">

$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})
	
</script>
</body>
</html>