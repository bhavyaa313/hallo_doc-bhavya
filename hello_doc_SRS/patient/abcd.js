$.ajax({
			
			
			
	url: "ajaxForAssignCase",
	type: "get",
	data: {
		region:region
	},
	success: function(data) {
		
		$("#physicians").empty();
		for(var i=0; i<data.length; i++){
			console.log(data);
			var row = `<option>`+data[i][0]+`</option>`
			$("#phyId").attr('value' , data[i][2]);
			$("#physicians").append(row);
		}
		
	}
		
	})