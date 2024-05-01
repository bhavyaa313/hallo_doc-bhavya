<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css" />
<link href="<c:url value="/resources/css/bootstrap.min.css"/> "
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css"/> " rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js">
	
</script>
<script src="<c:url value="/resources/js/script.js" />"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<style>
</style>

</head>

<body class="bg-light">

	<jsp:include page="Navbar.jsp" />


	<div class="container ">
		<div class="  d-flex p-4  ">
			<h3 class="mx-2">Create Role</h3>
			<div class="ms-auto ">
				<a href="javascript: history.go(-1)" type="button"
					class="btn btn-outline-info mx-2 "> < Back</a>
			</div>

		</div>


	</div>

	<div class="container bg-light ">
		<div class=" p-3   ">
			<div class=" p-1 mx-2 fs-4 mb-3">Details</div>

			<div class="row g-2">
				<div class="col-md">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="name"
							placeholder="name"> <label for="floatingInput" class="dm">Role
							Name</label>
					</div>
				</div>
				<div class="col-md">
					<div class="form-floating">
						<select class="form-select dropdwn" id="AccountType"
							aria-label="Floating label select example">
							<option selected value="0">All</option>
							<option  value="1">Admin</option>

							<option value="2">Provider</option>
						</select> <label for="AccountType">Account Type</label>
					</div>
				</div>
			</div>
			<div id="roles" class="d-flex flex-wrap"></div>







			<div id="roles_provider"></div>






		</div>
		<div class="mt-4 d-flex flex-row-reverse mb-3 ">
				<input type="text" id="SelectedRegionEdit" value="" />

			<button type="submit" class="btn btn-info btn-lg" id="save">Save</button>
			<button type="submit" class="btn btn-outline-info btn-lg">Cancel</button>


		</div>






	</div>
	</div>

	<div
		class="footer d-flex  align-items-center justify-content-end mt-3 ">
		<p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions |
			privacy policy</p>
	</div>

	</div>
	<script>
		function myFunctions() {
			var element = document.body;

			element.classList.toggle("dark-mode");

			var navbarElements = document
					.querySelectorAll('.navbar-nav a.nav-link, .navbar-nav .btn');
			navbarElements.forEach(function(element) {
				element.classList.toggle("text-dark");
			});
		}
	</script>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
		integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			debugger
			
			accountType = $("#AccountType").val();
			AccountTypeAjax(accountType)
			
			$("#AccountType").on("change", function(){
				accountType = $("#AccountType").val();
				AccountTypeAjax(accountType)
			
			
			})
			/* $(".Change1").on("change", function() {
				  var selectedRegions = []; // Clear any previous selections

				  document.querySelectorAll('input[type="checkbox"]:checked').forEach(checkbox => {
				    selectedRegions.push(parseInt(checkbox.value));
				    console.log(selectedRegions);
				  });

				  $('#SelectedRegionEdit').val(selectedRegions.join(','));
				 
				});
 */
			
		
		})
		function AddSelectedRole() {
			debugger
    var selectedRoles = []; // Clear any previous selections
    document.querySelectorAll('input[type="checkbox"]:checked').forEach(checkbox => {
    	selectedRoles.push(parseInt(checkbox.value));
    });

    $('#SelectedRegionEdit').val(selectedRoles.join(','));
}
		
		
		function AccountTypeAjax(accountType){
			$("#roles").empty();
			$.ajax({
			    method: "GET",
			    url: "GetFilteredMenus/"+accountType,
			    
			    success: function (result) {
			    	debugger
			    	console.log(result);
			  
			        let str="";
			         for (let i = 0; i < result.length; i++)
			        {
			            str = `<div class=" ms-3 form-check">
			                <input class="form-check-input Change1 me-3" type="checkbox" value=`+result[i].menuId+`
		                       id=`+result[i].menuId+` name="checkbox_group" onclick="AddSelectedRole()"
		                   />
		                <label class="form-check-label me-3" for=`+result[i].menuId+`>`+result[i].name+`</label>
		            </div>`;
			            $("#roles").append(str);
			        } 
			         
			    }
			})
		}
		
		
		 $("#save").click(function(e) {
			    e.preventDefault(); // Prevent default form submission if the button is inside a form
				
			    var name = $("#name").val();
			    var role = $("#AccountType").val();
			    var list = $("#SelectedRegionEdit").val();
			    
			    $.ajax({
			      url: "saveAjax", // Replace with the actual URL of your server-side script
			      type: "POST", // Change to "GET" if your endpoint expects a GET request
			      data: { // Optional data to send to the server
			        name:name,
			        role:role,
			        list:list
			      },
			      success: function() {
			     
			        console.log("Success!");
			     
			      },
	
			    });
			  });
	</script>
	
	

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
		integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>


	<script>
		document.getElementsByClassName('drill_cursor')[0].addEventListener(
				'click', function(event) {
					// do something
					document.getElementById('input_file').click();
					changePlaceholder();

				})
		function changePlaceholder() {
			$('input[type="file"]').change(function(e) {
				const names = e.target.files[0].name;

				$('#txt').attr('placeholder', names);
			});
		}
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

	</script>

</body>

</html>