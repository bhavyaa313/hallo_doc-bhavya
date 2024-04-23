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
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>

<body class="bg-light">




	<jsp:include page="Navbar.jsp" />
	<div class="foot" style="padding-bottom: 170px;">
		<div class="container-fluid ">
			<div class="row">
				<div class=" col-md-2"></div>
				<div class="col-12 col-md-8 ">
					<div class="container-fluid bg-light">
						<div class="d-flex mb-3">
							<h3 class="mt-4">Send Order</h3>
							<div class="ms-auto p-3">
								<a href="javascript: history.go(-1)" type="button"
									class="btn btn-outline-info mx-2 "> < Back</a>
							</div>
						</div>

					</div>
					<div class="bg-white p-3">
						<form action="sendOrders" method="post">
							<div class="row g-2 mb-3">
								<div class="col-md ">
									<div class="form-floating mb-2">
										<select class="form-select" id="professionSelector"
											aria-label="Floating label select example">
											<option selected></option>
											<option value="1">Cardiology</option>
											<option value="2">Wound Care Nursing</option>
											<option value="3">Pharmacy</option>
											<option value="4">ENT</option>
											<option value="5">Dentist</option>
											<option value="6">Inaging- XRAY, CT, MRI</option>

										</select> <label for="floatingSelect">Select Profession</label>
									</div>

								</div>
								<div class="col-md ">
									<div class="form-floating mb-2">
										<select class="form-select" id="vendors"
											aria-label="Floating label select example">


										</select> <label for="floatingSelect">Select Profession</label>
									</div>
									<input type="text" name="vendorId1" id="vendorId" hidden>
									<input type="text" name="reqId" value="${reqId }"  hidden>

								</div>
							</div>



							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-2">
										<input type="text" class="form-control" id="businessContact"
											placeholder="name" name="businessContact"> <label
											for="floatingInput" class="dm">Business Contact</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-2">
										<input type="email" class="form-control" id="emailContact"
											placeholder="name" name="email"> <label
											for="floatingInput" class="dm">Email</label>
									</div>
								</div>
							</div>

							<!-- <input type="tel" class="form-control pt-3 pb-3  " id="phone"> -->

							<div class="row g-2">
								<div class="col-md-6 col-6">
									<div class="form-floating mb-2">
										<input type="number" class="form-control" id="faxNo"
											placeholder="nvfnkiefvkn" name="faxNumber"> <label
											for="floatingInput" class="dm">Fax Number</label>
									</div>
								</div>

							</div>

							<div class="form-floating mb-2">
								<textarea class="form-control "
									placeholder="Leave a comment here" id="floatingTextarea2"
									style="height: 100px" name="prescription"></textarea>
								<label for="floatingTextarea2" class="dm"> Prescription
									or Order details</label>
								<hr>
							</div>


							<div class="row g-2">
								<div class="col-md-6 col-6">

									<div class="form-floating">
										<select class="form-select" id="floatingSelect"
											aria-label="Floating label select example"
											name="numberOfrefill">
											<option selected>Not required</option>
											<option value="1">One</option>
											<option value="2">Two</option>
											<option value="3">Three</option>
										</select> <label for="floatingSelect">Number Of Refill</label>
									</div>


								</div>

							</div>













							<div class="mt-4 d-flex flex-row-reverse mb-3 ">

								<button type="cancel" class="btn btn-outline-info  mx-2 btn-lg">cancel</button>

								<button type="submit" class="btn btn-info mx-2 btn-lg">Submit</button>

							</div>






						</form>

					</div>







					<div class="col-md-2"></div>
				</div>


			</div>
		</div>
		<div
			class="footer d-flex  align-items-center justify-content-end mt-3 ">
			<p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions |
				privacy policy</p>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

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
		console.log("orders")
		$('#professionSelector').change(function() {
			console.log(this);
			let profession = this.value;
			console.log("abc", profession)
			$.ajax({
				url : "ajaxForOrders",
				type : "get",
				data : {
					profession : profession
				},
				success : function(data) {
					debugger
					console.log(data);

					$("#vendors").empty();
					for (var i = 0; i < data.length; i++) {
						console.log(data);
						var row = `<option>` + data[i][1] + `</option>`
						$("#vendorId").attr('value', data[i][0]);
						$("#faxNo").attr('value', data[i][2]);
						$("#emailContact").attr('value', data[i][3]);
						$("#businessContact").attr('value', data[i][4]);
						$("#vendors").append(row);
					}

				}

			})

		})
	</script>

</body>

</html>