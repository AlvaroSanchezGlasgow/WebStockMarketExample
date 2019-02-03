<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>


</head>
<body>

	<jsp:include page="common/header.jsp" />
	<div class="container"
		style="border: solid 0.5px; border-color: #A4A4A4;">
		<h1 class="display-4">Select Products and Price to add:</h1>

		<p></p>
		<p></p>
		<form class="form-inline" id="formShares" name="formShares"
			style="width: 55%; margin: auto; text-align: center;">

			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<label >&nbsp;Operation Type:&nbsp;
				</label> <select class="form-control" name="operationType"
					id="operationType" style="width: 140px; height: 35px;">
					<option value="BUY" selected>Buy</option>

					<option value="SELL">Sell</option>
				</select>
			</div>
			<div class="form-group" style="margin: 0 auto; padding: 4px;visibility:hidden;">
				<input type="checkbox" id="hiddenInputCheck" name="hiddenInputCheck" value="TEA"
					checked disabled /> - TEA &nbsp;<input type="number"
					id="hiddenInput" name="hiddenInput" class="form-control"
					placeholder="" pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" value="">
			</div>
			
			
			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<b>TEA -</b> &nbsp;<input type="number"
					id="TeaAmmount" name="TeaAmmount" class="form-control"
					placeholder="Ammount of TEA" pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" value="">
			</div>
			-
			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<input type="number" id="TeaPrice" name="TeaPrice"
					class="form-control" placeholder="TEA Price"
					pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" value="" min="0" step="any">
			</div>
			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<b>POP -</b> &nbsp;<input type="number"
					id="PopAmmount" name="PopAmmount" class="form-control"
					placeholder="Ammount of POP" pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" min="0" value="">
			</div>
			-
			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<input type="number" id="PopPrice" name="PopPrice"
					class="form-control" placeholder="POP Price"
					pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" value="" min="0" step="any">
			</div>
			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<b>ALE -</b> &nbsp;<input type="number"
					id="AleAmmount" name="AleAmmount" class="form-control"
					placeholder="Ammount of ALE" pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" min="0" value="">
			</div>
			-
			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<input type="number" id="AlePrice" name="AlePrice"
					class="form-control" placeholder="ALE Price"
					pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" value="" min="0" step="any">
			</div>

			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<b>GIN - </b>&nbsp;<input type="number"
					id="GinAmmount" name="GinAmmount" class="form-control"
					placeholder="Ammount of GIN" pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" value="">
			</div>
			-
			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<input type="number" id="GinPrice" name="GinPrice"
					class="form-control" placeholder="GIN Price"
					pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" value="" min="0" step="any">
			</div>
			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<b>JOE -</b> &nbsp;<input type="number"
					id="JoeAmmount" name="JoeAmmount" class="form-control"
					placeholder="Ammount of JOE" pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" value="">
			</div>
			-
			<div class="form-group" style="margin: 0 auto; padding: 4px;">
				<input type="number" id="JoePrice" name="JoePrice"
					class="form-control" placeholder="JOE Price"
					pattern="/^-?\d+\.?\d*$/"
					onKeyPress="if(this.value.length==9) return false;"
					style="width: 200px; height: 30px;" min="0" value="" min="0" step="any">
			</div>

			
		</form>
		<div class="col-sm-4"
			style="text-align: center; margin: 0 auto; padding: 2%;">
			<p></p>
			<button type="button" class="btn btn-primary btn-lg"
				data-toggle="tooltip" data-placement="top" title="Clear Form"
				onclick="javascript:location.reload();">Clear Form</button>
			<button type="button" class="btn btn-primary btn-lg"
				data-toggle="tooltip" data-placement="top" title="New Operation"
				onclick="javascript:setAjax('formShares','<c:url value="/createTrade"/>');">New
				Operation</button>
			<p></p>
		</div>
	</div>
	<p></p>
	<div class="container">
		<hr></hr>
	</div>
	<div class="container">
		<button type="button" class="btn btn-link" title="Print Report"
			onclick="javascript:window.print();" style="margin-left: 90%;">Print
			Report</button>
	</div>
	<div class="container" style="border: solid 1px; overflow: auto;">
		<h1 class="display-3">Result</h1>

		<div class="row" style="padding: 5px;">

			<div class="col-sm-4">
				<h4>
					Volume Weigh Stock: <span class="badge badge-secondary"><div
							id="volWeighSt">0</div></span>
				</h4>
			</div>
			<div class="col-sm-4">
				<h4>
					GBCE All Share Index: <span class="badge badge-secondary"><div
							id="gbceIndex">0</div></span>
				</h4>
			</div>

		</div>
		<div class="row" style="padding: 5px;">

			<div class="col-8"
				style="border: solid 0.5; border-color: #A4A4A4; padding: 10px;">
				<div class="table-responsive" style="text-align: center;">

					<table id="tableTrade" border="0.2" style="margin: 0 auto;">
						<thead style="background-color: #0063be; color: #e8e9e9;">

							<th>Operation Type</th>
							<th>Timestamp</th>
							<th>TEA</th>
							<th>POP</th>
							<th>ALE</th>
							<th>GIN</th>
							<th>JOE</th>
							<th>TOTAL</th>
						</thead>
						<tbody style="">

						</tbody>
					</table>

				</div>
			</div>
			<div class="col-4" style="border: solid 0.5;">
				<h6>See your Basket:</h6>
				<canvas id="myChart"></canvas>
			</div>
		</div>
		<hr></hr>
		<div class="row" style="padding: 5px;">

			<div class="table-responsive" style="text-align: center;">

				<table id="tableResult" class="table-striped" border="0.2"
					style="margin: 0 auto;">
					<thead style="background-color: #0063be; color: #e8e9e9;">

						<th>Stock Symbol</th>
						<th>Type</th>
						<th>Dividend Yield</th>
						<th>P/E Ratio</th>
					</thead>
					<tbody style="">



					</tbody>
				</table>

				<p></p>

			</div>

		</div>
	</div>
	<hr></hr>
	<jsp:include page="common/footer.jsp" />
	<script>
		//var value = "<c:out value='${data}'/>";
		//var dataValues = JSON.parse(value);
	</script>
</body>
</html>
