
console.log("orders")
	$('#professionSelector').change(function () {
	    console.log(this);
	    let profession = this.value;
	    console.log(profession)
		$.ajax({
			
			
			
			url: "ajaxForOrders",
			type: "get",
			data: {
				profession:profession
			},
			success: function(data) {
				debugger
				console.log(data);
				
				$("#vendors").empty();
				for(var i=0; i<data.length; i++){
					console.log(data);
					var row = `<option>`+data[i][1]+`</option>`
					/* $("#vendorId").attr('value' , data[i][2]); */ //remember
					$("#vendors").append(row);
				}
				
			}
				
			})
		
	})