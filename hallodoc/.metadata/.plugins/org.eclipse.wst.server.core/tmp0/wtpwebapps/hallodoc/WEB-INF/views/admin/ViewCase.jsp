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
<title>new_req</title>


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
<script src="<c:url value="/resources/js/script.js"/>"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>





<style>
.hide {
	display: none;
}

.hidee {
	display: none;
}

body {
	background-color: white;
	color: black;
}

.dark-mode {
	background-color: black !important;
	color: white !important;
}

.text-dark {
	color: #f5f0f0 !important;
}

.kok {
	background-color: white !important;
}

.kok2 {
	height: 80vh;
	width: 100%;
}

.iti {
	width: 100% !important;
	display: inline-block;
}

.iti__country-list {
	z-index: 100;
	width: 600%;
}

img.highlight:hover {
	color: #fbfbfb !important;
}

#txt {
	color: transparent;
	&:
	focus
	{
	outline
	:
	none;
}

}
img.highlight:hover {
	color: #fbfbfb !important;
}
</style>

</head>

<body class="bg-light">
	<jsp:include page="Navbar.jsp" />




	<div class="foot">
		<div class="container-fluid ">
			<div class="row">
				<div class=" col-md-2"></div>
				<div class="col-12 col-md-8 ">
					<div class="container-fluid bg-light">
						<div class="d-flex mb-3">
							<h3 class="mt-3 seee">
								View Reservation<span
									class="badge rounded-pill text-bg-success fs-5">Patient</span>
							</h3>
							<h3 class="mt-3 hidee">
								New Request<span class="badge rounded-pill text-bg-success fs-5">Patient</span>
							</h3>
							<div class="ms-auto p-3">
								<a href="javascript: history.go(-1)" type="button"
									class="btn btn-outline-info mx-2 "> < Back</a>
							</div>
						</div>

					</div>
					<div class="bg-white p-3">

						<h4 class="mb-2">Patient Information</h4>
						<p class="text-muted">Confirmation Number</p>
						<h4 class="text-info mb-3">${confirmString }</h4>
						<form action="update/${requestId}" method="post">
							<div class="form-floating mb-3">
								<textarea class="form-control enable "
									placeholder="${requestClients[0].notes}" id="floatingTextarea2"
									style="height: 100px" value="" name="notes" disabled></textarea>
								<label for="floatingTextarea2" class="dm"> Patient Notes</label>
								<hr>
							</div>
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control enable"
											id="floatingInput" placeholder="name" name="firstName"
											value="${requestClients[0].firstName}" disabled> <label
											for="floatingInput" class="dm">First Name</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control enable"
											value="${requestClients[0].lastName}" id="floatingInput"
											placeholder="name" name="lastName" disabled> <label
											for="floatingInput" class="dm">Last Name</label>
									</div>
								</div>
							</div>
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<!-- <input type="date" class="form-control" id="floatingInput"
                                    mailto:placeholder="name@example.com">
                                <label for="floatingInput">Date of Birth</label> -->
										<input type="text" id="uname" class="form-control enable"
											placeholder="Date Of Birth" onfocus="(this.type='date')"
											value="${fullDate}" name="dob" disabled></input> <label
											for="floatingInput" class="dm">Date of Birth</label>
									</div>


								</div>

								<div class="col-md-5">
									<div class="form-floating mb-3">
										<input type="tel"
											class="form-control pt-3 pb-3 enable  iti iti__country-list"
											id="phone" name="phone"
											value="${requestClients[0].phoneNumber}" disabled>

									</div>
								</div>
								<div class="col-md-1">
									<div class="mb-3 mt-2 highlight">
										<a href="" type="button"
											class="btn btn-outline-info mx-2 p-2 highlight"> <svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-telephone-fill"
												viewBox="0 0 16 16">
                                        <path fill-rule="evenodd"
													d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z" />
                                    </svg>
										</a>
									</div>
								</div>



							</div>
							<!-- <input type="tel" class="form-control pt-3 pb-3  " id="phone"> -->

							<div class="row g-2">
								<div class="col-md-6 ">
									<div class="form-floating mb-3">
										<input type="email" class="form-control " id="floatingInput"
											placeholder="name@example.com"
											value="${requestClients[0].email}" disabled> <label
											for="floatingInput" class="dm">Email</label>
									</div>
								</div>
								<div class="col-md seee ">
									<button type="button"
										class="btn btn-info btn-lg mx-3 random xx  " onclick="show()">Edit</button>
									<button type="button"
										class="btn btn-danger btn-lg mx-2 hide see come"
										onclick="show2()" hidden>Cancel</button>
									<button type="submit"
										class="btn btn-success btn-lg mx-2 hide see come "
										onclick="show2()" hidden>Save</button>
								</div>


							</div>

						</form>
						<h4>Location Information</h4>
						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="rttttttth" value="${requestClients[0].state}"
										disabled> <label for="floatingInput" class="dm">Region</label>
								</div>
							</div>
							<div class="col-md-5">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="trr" value="${requestClients[0].street}" disabled>
									<label for="floatingInput" class="dm">Business
										Name/Address</label>
								</div>
							</div>
							<div class="col-md-1">
								<div class="mb-3 mt-2 highlight">
									<a href="" type="button"
										class="btn btn-outline-info mx-2 p-2 highlight"> <svg
											xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
                                        <path
												d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A32 32 0 0 1 8 14.58a32 32 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10" />
                                        <path
												d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4m0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6" />
                                    </svg>
									</a>
								</div>
							</div>
						</div>
						<div class="row g-2">
							<div class="col-md-6 col-6">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="yhht" disabled> <label
										for="floatingInput" class="dm">Room #</label>
								</div>
							</div>

						</div>













						<div class="mt-4 d-flex flex-row-reverse mb-3 ">

							<button type="button" class="btn btn-danger btn-lg mb-3">cancel</button>
							<a href="viewNotes/${requestId }" type="button"
								class="btn btn-info mx-2 btn-lg mb-3">View Notes</a>
							<button type="button"
								class="btn btn-info mx-2 btn-lg mb-3 enabled"
								data-bs-toggle="modal" data-bs-target="#assign" onClick="assigncase(${requestId})" hidden>Assign
								Case</button>



						</div>








					</div>







					<div class="col-md-2"></div>
				</div>
				<div
					class="footer d-flex  align-items-center justify-content-end mt-3 ">
					<p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions |
						privacy policy</p>
				</div>
			</div>
			<div class="modal fade" id="assign" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog  modal-dialog-centered">
				<div class="modal-content">
					<form action="assignCaseAction/${userList[0].userID}" method="post">

						<div class="modal-header bg-info text-white">
							<h1 class="modal-title fs-5 " id="exampleModalLabel">Assign
								Case</h1>
							<button type="button" class="btn-close btn-close-white"
								data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<p mb-3>To assign this request search and select another
								Physician</p>


							<div class="form-floating mb-3">
								<select class="form-select" id="regionSelector"
									aria-label="Floating label select example">
									<option value="1">GUJARAT</option>
									<option value="2">MAHARASHTRA</option>
									<option value="3">MADHYA PRADESH</option>
									<option value="4">RAJASTHAN</option>
								</select> <label for="floatingSelect">Narrow Search By region</label>
							</div>

							<div class="form-floating mb-3">
								<select class="form-select" id="physicians"
									aria-label="Floating label select example">




								</select> <label for="floatingSelect">Select Physician</label>
							</div>

							<div class="form-floating mb-3">
								<textarea class="form-control"
									placeholder="Leave a comment here" id="floatingTextarea2"
									style="height: 100px" name="notes"></textarea>
								<label for="floatingTextarea2">Description</label>
							</div>
							<input type="text" id="reqId33" name="reqId3" >
							 <input
								type="text" name="phyId" id="phyId" >

						</div>
						<div class="modal-footer">

							<button type="submit" class="btn btn-info">Submit</button>
							<button type="button" class="btn btn-outline-info"
								data-bs-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>

			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>

			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
			<script
				src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

			<script>
				$(document).ready(function() {
					$('#yourModalId').modal('show');
				});
			</script>
			<script>
				const phoneInputField = document.querySelector("#phone");
				const phoneInput = window
						.intlTelInput(
								phoneInputField,
								{
									utilsScript : "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js",
								});
			</script>
			<script>
				const phoneInputField1 = document.querySelector("#phone1");
				const phoneInput1 = window
						.intlTelInput(
								phoneInputField1,
								{
									utilsScript : "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js",
								});
			</script>


			<script>
				function show() {
					$('.hide').removeClass("hide");
					$('.random').addClass("hide");
					$('.enable').removeAttr("disabled");
					$('.come').removeAttr("hidden");
					$('.xx').attr("hidden", "hidden");

				}

				function show2() {
					$('.hide').removeClass("hide");
					$('.see').addClass("hide");
					$('.enable').attr("disabled", "disabled");
					$('.come').attr("hidden", "hidden");
					$('.xx').removeAttr("hidden");

				}
				
				console.log("challll")

				var status = ${status};
			
				console.log(status)
				if (status == 1) {
					$('.enabled').removeAttr("hidden");

					$('.hidee').removeClass("hidee")
					$('.seee').addClass("hidee");

				}
			</script>

			<script>
				$('form').submit(function(e) {
					$(':disabled').each(function(e) {
						$(this).removeAttr('disabled');
					})
				});
			</script>
			<script>
	console.log("assign case")
	$('#regionSelector').change(function () {
	    console.log(this);
	    let region = this.value;
	    console.log(region)
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
		
	})
	</script>
		<script>
	
	console.log("yeahhhhhh")
	function assigncase(requestId) {
  console.log("Success!"); 


  
  
 
  $('#reqId33').attr('value' , requestId);
  
  
}
	</script>
	
</body>

</html>