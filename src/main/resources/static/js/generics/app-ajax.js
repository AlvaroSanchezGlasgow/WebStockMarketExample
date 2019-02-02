

function setAjax(formId,url) {
	
	
	$.ajax({
			type: "POST",
			url : url,
			dataType: "html",
			data :  $("#" + formId).serialize(),
			async:false, // not recommended!!!!!!!!
            cache:false,
            
           success : function(data) {
        	  
        	   drawTables(data);
        	   // var jsonData = JSON.parse(data);
    		//   manageAjaxResponse(formId,data);
    	   
			},
	        error: function (err) {
	        	
	        	
	        	$.confirm({
	        	    title: 'Ups!! Something was wrong',
	        	    content: "<p></p><p></p><p></p>Error in Ajax Call!!!!!!!!!!!<p></p><p></p>",
	        	    type: 'red',
	        	    typeAnimated: true,
	        	    buttons: {
	        	        tryAgain: {
	        	            text: 'Try again',
	        	            btnClass: 'btn-red',
	        	            action: function(){
	        	            }
	        	        },
	        	       /* close: function () {
	        	        }*/
	        	    }
	        	});
	
	        }
    });

}


