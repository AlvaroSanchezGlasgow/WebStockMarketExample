function drawTables(data){
	/* $.alert({
		   title: 'All Good!!!',
		 content: data,
		});*/
	 var jsonData = JSON.parse(data);
	drawStocksTable(jsonData);
	drawTradeTable(jsonData);
	drawTradeGraph(jsonData);
	drawVolWeighted(jsonData);
	gbceIndex(jsonData);
	
	$.alert({
		   title: 'Congratulations!!',
		 content: 'The operation has been successfully calculated',
		});
	
}

function drawStocksTable(data){
	
	$("#tableResult tbody").empty();
	
	 for (var i = 0; i < data.stocksList.length; i++) { 
    
     		 $("#tableResult tbody").append(
     	          "<tr>" +
     	          "  <td>"  + data.stocksList[i].stockSymbol + "</td>" +
     	          "  <td>"  + data.stocksList[i].type + "</td>" +
     	         "  <td>"  + data.stocksList[i].dividendYield + "  </td>" +
     	        "  <td>"  + data.stocksList[i].peRatio + "  </td>" +
     	       
     	          "</tr>"
     	        );
     	
    		 }
	
	 
}

function drawTradeTable(data){
	
	
	$("#tableTrade tbody").empty();
	 $("#tableTrade tbody").append(
			 "<td>"+data.trade.operationType+"</td>"+
				"<td>"+data.trade.tradeTime+"</td>"+
				"<td>"+data.trade.teaCost+"</td>"+
				"<td>"+data.trade.popCost+"</td>"+
				"<td>"+data.trade.aleCost+"</td>"+
				"<td>"+data.trade.ginCost+"</td>"+
				"<td>"+data.trade.joeCost+"</td>"+
				"<td>"+data.trade.totalTradedPrice+"</td>"
				
	        );
	
}

function drawTradeGraph(data){
	
	var values = "["+data.trade.teaCost+","+data.trade.popCost+","+data.trade.aleCost+","+data.trade.ginCost+","+data.trade.joeCost+"]";
	
	var jsonGraph = JSON.parse(values);
	var ctx = document.getElementById("myChart");
	var myChart = new Chart(ctx, {
		type : 'pie',
		data : {
			labels : ["TEA"," POP"," ALE","GIN","JOE"],
					datasets : [ {
				label : 'Trade 002',
				data : jsonGraph,
				backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)', 
						'rgba(255, 159, 64, 0.2)' ],
				borderColor : [ 'rgba(255,99,132,1)', 'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)', 'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)' ],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
}

function drawVolWeighted(data){
	$("#volWeighSt").text(data.volumeWeighStockPrice);
}
function gbceIndex(data){
	$("#gbceIndex").text(data.gbceIndex);
}