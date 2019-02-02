<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=yes">
<meta name="Description" content="Allocation Information." />
<meta name="Distribution" content="internal" />
<meta name="Author" content="Alvaro" />

<title>Index - Stock Market</title>

<script src="js/jquery/jquery-3.3.1.js"></script>
<script src="js/jquery/jquery-3.3.1.slim.min.js"></script>
<script src="js/jquery/jquery-3.3.1.min.js"></script>
<script src="js/popper/popper.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>

<script src="js/jquery-confirm/jquery-confirm.js"></script>

<script src="js/datatable/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="css/datatable/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-confirm/jquery-confirm.css">


<!-- Select 2 -->
<link href="css/select2/select2.min.css" rel="stylesheet" />
<script src="js/select2/select2.min.js"></script>

<script src="js/generics/drawAjaxResponse.js"></script>
<script src="js/generics/genericFunctions.js"></script>
<script src="js/generics/app-ajax.js"></script>



<!-- Graphs Library -->
<script
	src="js/chartjs/Chart.bundle.js"></script>
<script
	src="hjs/chartjs/Chart.bundle.min.js"></script>
<script
	src="js/chartjs/Chart.js"></script>
<script
	src="js/chartjs/Chart.min.js"></script>

<script>
function stockPricesPopUp(){
	
	var f = new Date();
	var sDate = f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear();
	
	var string="<p></p><p></p><p></p><table id='tablePrices' class='table-striped' border='0.2' style='margin: 0 auto;'>"+
	"<thead style='background-color: #0063be; color: #e8e9e9;'>"+
		"<th>Stock Symbol</th>"+
		"<th>Type</th>"+
		"<th>Last Dividend</th>"+
		"<th>Fixed Dividend</th>"+
		"<th>Par Value</th>"+
		
	"</thead>"+
	"<tbody>"+
		
			"<tr>"+
			"	<td><b>TEA</b></td>"+
			"	<td>COMMON</td>"+
			"	<td>0</td>"+
			"	<td></td>"+
			"	<td>100</td>"+
			
			"</tr>"+
			"<tr>"+
			"	<td><b>POP</b></td>"+
			"	<td>COMMON</td>"+
			"	<td>8</td>"+
			"	<td></td>"+
			"	<td>100</td>"+
			
			"</tr>"+
			"<tr>"+
			"	<td><b>ALE</b></td>"+
			"	<td>COMMON</td>"+
			"	<td>23</td>"+
			"	<td></td>"+
			"	<td>60</td>"+
			
			"</tr>"+
			"<tr>"+
			"	<td><b>GIN</b></td>"+
			"	<td>PREFERRED</td>"+
			"	<td>8</td>"+
			"	<td>2%</td>"+
			"	<td>100</td>"+
			
			"</tr>"+
			"<tr>"+
			"	<td><b>JOE</b></td>"+
			"	<td>COMMON</td>"+
			"	<td>13</td>"+
			"	<td></td>"+
			"	<td>250</td>"+
		
			"</tr>"+
		
	"</tbody>"+
"</table>";
$.confirm({
	    title: 'Market Prices - '+sDate,
	    content: string,
	    buttons: {
	        formSubmit: {
	            text: 'Ok',
	            btnClass: 'btn-blue',
	            action: function () {
	            	
	               // $.alert('Your name is ' + name);
	            }
	        },
	        
	    }

	});
	
	
}
</script>
</head>
<body>
<div class="row" >
<div class="container">
			
			<div class="span4">
				<h1 class="display-1" style="color:red;">Stock Market</h1>
				<p>Manage your financial products online</p>
			</div>
			<div class="span4">
						</div>
	

		<div class="span12">
			<ul class="breadcrumb">
				<li class="breadcrumb-item" aria-current="page"><a
					href="${pageContext.request.contextPath}/">Index</a> </li>
				
					<li class="breadcrumb-item"><a href="javascript:stockPricesPopUp();">Consult the Stock Data/Indexes for Today</a>
						</li>
				
			</ul>
		</div>
	</div>
</div>
</body>
</html>