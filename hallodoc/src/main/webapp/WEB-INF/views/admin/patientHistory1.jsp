<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="hallodoc.model.Request"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dasdhboard New</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<link

 rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js">
</script> <script src="<c:url value="/resources/js/script.js" />"></script> <script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script> <script
	src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>



</head>

<body class="bg-light">

	<%@ include file="Navbar.jsp"%>

	<div class="container-fluid mb-3">
		<div class="flex-row d-flex py-3 mr-2">

			<div>
				<h3>Patient History</h3>
			</div>

		  <div class="ms-auto "> <a href="javascript: history.go(-1)"href="dashboard.html" type="button" class="btn btn-outline-info mx-2 ">
                        Back</a>
                </div>

		</div>

		<div style="border: 5px solid #edf4f4;"
			class="bg-white pb-3 border-4 rounded">

			<div class="row pt-2 px-3">

				<div class="col-md-3 col-12 pt-2">
					<div class="form-group form-floating w-100">
						<input type="text" class="form-control" id="fName" placeholder="First Name"></input>
						<label>First Name</label>
					</div>
				</div>

				<div class="col-md-3 col-12 pt-2">
					<div class="form-group form-floating w-100">
						<input type="text" class="form-control" id="lName" placeholder="Last Name"></input>
						<label>Last Name</label>
					</div>
				</div>

				<div class="col-md-3 col-12 pt-2">
					<div class="form-group form-floating w-100">
						<input type="email" class="form-control" id="email" placeholder="Email"></input>
						<label>Email</label>
					</div>
				</div>

				<div class="col-md-3 col-12 pt-2">
					<div class="form-group form-floating w-100">
						<input type="text" class="form-control" id="phone" placeholder="Phone Number"></input>
						<label>Phone Number</label>
					</div>
				</div>

			</div>

			<div class="flex-row d-flex pt-2 px-3 justify-content-end">
				<button type="button" class="btn btn-outline-info mr-2 clear">Clear
				</button>
				<button type="button" class="btn btn-info search">Search</button>
				<button type="button" id="clear" value="clear" hidden></button>
			</div>



			<div class="lo mt-3 px-3">
				<table class="table table-hover">
					<thead>
						<tr class="table-secondary">
							<td scope="col">First Name</td>
							<td scope="col">Last Name</td>
							<td scope="col">Email</td>
							<td scope="col">Phone</td>
							<td class="w-25" scope="col">Address</td>
							<td scope="col">Actions</td>
						</tr>
					</thead>
					<tbody id="tableData">
					</tbody>
				</table>
			</div>

			<div class="accordion accordion-flush lo-btn border my-2"
				id="new-mob">
				<div class="accordion-item">
					<button style="padding-right: 0; padding-left: 30px;"
						class="accordion-button collapsed bg-info-subtle" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapseSix"
						aria-expanded="false" aria-controls="flush-collapseSix">

						<div style="font-size: small;" class="row w-100">

							<div class="col-4 p-0">
								<p class="text-muted">Takishi Dorimi</p>
							</div>
							<div class="col-8 p-0"></div>
							<div class="col-6 p-0">
								<p class="text-muted">(434) 384 - 3646</p>
							</div>

						</div>

					</button>

					<div id="flush-collapseSix"
						class="accordion-collapse collapse bg-info-subtle"
						aria-labelledby="flush-headingOne"
						data-bs-parent="#accordionFlushExample">

						<div style="font-size: small; padding-left: 30px;"
							class="accordion-body">
							<div class="row pl-3">
								<div class="col-12 px-0 pb-1 my-1">
									<i
										class="fa-solid fa-envelope text-info border border-info rounded-circle p-2"></i>
									<span class="text-muted">Email:</span> mailto:test123@mailinator.com
								</div>
								<div class="col-12 px-0 pb-1 my-1">
									<i
										class="fa-solid fa-phone text-info border border-info rounded-circle p-2"></i>
									<span class="text-muted">Phone Number:</span> (123) 456-7890
								</div>
								<div style="text-align: end;" class="col-12 pr-3 pb-1 my-1">
									<a style="text-decoration: none;" href="patient-record.html">
										<button type="button" class="btn btn-outline-info mr-1 py-0">Explore
										</button>
									</a>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>

		</div>

	</div>

	 <div class="footer d-flex  align-items-center justify-content-end mt-3 ">
                <p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions | privacy policy</p>
              </div>


	

		
 	<script>
		$(document).ready(function() {
		console.log("searchhhhhhh")
			$('.search').click();
		
		})
	</script>
		<script>
		$(".search").on("click", function() {
			
			var fName;
			var lName;
			var email;
			var phone;
			
			if ($("#clear").hasClass("search")) {
				
				fName = "";
				email = "";
				lName = "";
				phone = "";
				
				$("#fName").attr("value","");
				$("#email").attr("value","");
				$("#lName").attr("value","");
				$("#phone").attr("value","");
				
				$("#clear").removeClass("search"); 
				
			}
			
			else {
				
				fName = $("#fName").val();
				email = $("#email").val();
				lName = $("#lName").val();
				phone = $("#phone").val();
				
			}
			
			console.log(fName);
			console.log(email);
			console.log(lName);
			console.log(phone);
			
			$.ajax({
				
				url : "ajaxforPatientHistory",
				type : "post",
				data : {
					fName:fName,
					email:email,
					lName:lName,
					phone:phone
				},
				success : function(data) {
					
					$("#tableData").empty();
					
					for(let i=0; i<data.length; i++) {
						
						var patientHistory = data[i];
						
						var row = `<tr>
							<td scope="row">`+patientHistory.fname+`</td>
							<td>`+patientHistory.lname+`</td>
							<td>`+patientHistory.emailString+`</td>
							<td>`+patientHistory.phoneString+`</td>
							<td>`+patientHistory.address+`</td>
							<td><a style="text-decoration: none;"
								href="patientRecords1/`+patientHistory.uId+`">
									<button type="button" class="btn btn-outline-info">Explore</button>
							</a></td>
						</tr>`
						
						$("#tableData").append(row);
						
					}
					
				}
				
			})
			
		})
		
		
		
	</script>

	<script>
	
	$(".clear").on("click", function() {
		
		$("#clear").addClass("search");
		
		$(".search").click();
		
	})
	
	</script>
	

</body>

</html>