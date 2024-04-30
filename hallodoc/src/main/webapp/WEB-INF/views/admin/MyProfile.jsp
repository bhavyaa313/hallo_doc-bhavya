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
</script> <script src="<c:url value="/resources/js/script.js" />"></script> <script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script> <script
	src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<style>
.hide {
	display: none;
}

.hide1 {
	display: none;
}

.hide2 {
	display: none;
}

.hide3 {
	display: none;
}
</style>
</head>

<body class="bg-light">




	<jsp:include page="Navbar.jsp" />
	<div class="foot">
		<div class="container-fluid bg-light ">
			<div class="row">
				<div class=" col-md-2"></div>
				<div class="col-12 col-md-8 ">
					<div class="container-fluid bg-light">
						<div class="d-flex mb-3">
							<h3 class="mt-3">My Profile</h3>
							<div class="ms-auto p-3">
								<a href="javascript: history.go(-1)" type="button"
									class="btn btn-outline-info mx-2 "> < Back</a>
							</div>
						</div>

					</div>
					<div class="bg-white p-3">

						<h4 class="mb-2">Account Information</h4>

						<form
							action="${pageContext.request.contextPath}/resetPassword/${users[0].aspnetUserId.id }/${users[0].userID }"
							method="post">
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control " id="floatingInput"
											placeholder="name" value="${users[0].aspnetUserId.userName }"
											disabled> <label for="floatingInput" class="dm">User
											Name</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="password" class="form-control enable"
											id="floatingInput" placeholder="name" name="password"
											disabled> <label for="floatingInput" class="dm">Password</label>
									</div>
								</div>
							</div>
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating ">
										<select class="form-select " id="floatingSelect"
											aria-label="Floating label select example" disabled>
											<option selected>Active</option>
											<option value="1">Pending</option>
											<option value="2">Closed</option>
											<option value="3">Unpaid</option>
										</select> <label for="floatingSelect">Status</label>
									</div>
								</div>

								<div class="col-md">
									<div class="form-floating">
										<select class="form-select " id="floatingSelect"
											aria-label="Floating label select example " disabled>
											<option selected>Mater Admin</option>
											<option value="1">Admin</option>
											<option value="2">Provider</option>
											<option value="3">Patient</option>
										</select> <label for="floatingSelect">Role</label>
									</div>
								</div>
							</div>
							<div class="mt-4 d-flex flex-row-reverse mb-3 ">


								<button type="button"
									class="btn btn-info btn-lg mx-3 random xx  " onclick="show()">Reset
									Password</button>
								<button type="button"
									class="btn btn-danger btn-lg mx-2 hide see come"
									onclick="show2()" hidden>Cancel</button>
								<button type="submit"
									class="btn btn-success btn-lg mx-2 hide see come "
									onclick="show2()" hidden>Save</button>


							</div>
						</form>





						<!-- <input type="tel" class="form-control pt-3 pb-3  " id="phone"> -->
						<h4 class="mt-5">Administrator Information</h4>

						<form action="${pageContext.request.contextPath}/adminEdit/${users[0].aspnetUserId.id }/${users[0].userID }" method="post">
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control enable2"
											id="floatingInput" placeholder="name" name="firstName"
											value="${users[0].firstName }" disabled> <label
											for="floatingInput" class="dm">First Name</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control enable2"
											id="floatingInput" placeholder="name" name="lastName"
											value="${users[0].lastName }" disabled> <label
											for="floatingInput" class="dm">Last Name</label>
									</div>
								</div>
							</div>


							<div class="row g-2">
								<div class="col-md ">
									<div class="form-floating mb-3">
										<input type="email" class="form-control enable2"
											id="floatingInput" placeholder="name@example.com"
											name="email" value="${users[0].email }" disabled> <label
											for="floatingInput" class="dm">Email</label>
									</div>
								</div>


								<div class="col-md ">
									<div class="form-floating mb-3">
										<input type="email" class="form-control enable2"
											id="floatingInput" placeholder="name@example.com"
											name="cemail" value="${users[0].email }" disabled> <label
											for="floatingInput" class="dm">Confirm Email</label>
									</div>
								</div>


							</div>

							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3 enable1">
										<input type="tel"
											class="form-control pt-3 pb-3  enable2 iti iti__country-list"
											name="phone" value="${users[0].mobile }" id="phone" disabled>

									</div>
								</div>

								<div class="col-md">
									<div class="d-flex flex-wrap mt-2">
										<div class="form-check mr-5">
											<input class="form-check-input part1 enable2" type="radio"
												onclick="stateSelect()" name="state" value="1" disabled>
											<label class="form-check-label"> GUJARAT </label>
										</div>
										<div class="form-check mr-5">
											<input class="form-check-input part1 enable2" type="radio"
												onclick="stateSelect()" name="state" value="2" disabled>
											<label class="form-check-label"> MAHARASHTRA </label>
										</div>
										<div class="form-check mr-5">
											<input class="form-check-input part1 enable2" type="radio"
												onclick="stateSelect()" name="state" value="3" disabled>
											<label class="form-check-label"> MADHYAPRADESH </label>
										</div>
										<div class="form-check mr-4">
											<input class="form-check-input part1 enable2" type="radio"
												onclick="stateSelect()" name="state" value="4" disabled>
											<label class="form-check-label"> RAJASTHAN </label>
										</div>
										<input type="text" name="region" id="region" hidden>

									</div>
									</div>


									<div class="mt-4 d-flex flex-row-reverse mb-3 ">

										<button type="button"
											class="btn btn-info btn-lg mx-3 random2 xx2  "
											onclick="show3()">Edit</button>
										<button type="button"
											class="btn btn-danger btn-lg mx-2 hide2 see2 come2"
											onclick="show4()" hidden>Cancel</button>
										<button type="submit"
											class="btn btn-success btn-lg mx-2 hide2 see2 come2 "
											onclick="show4()" hidden>Save</button>



									</div>
						</form>


					</div>



				</div>




				<h4>Mailing & Billing Information</h4>
				<form action = "${pageContext.request.contextPath}/editBilling/${users[0].aspnetUserId.id }/${users[0].userID }" method="post" >
				<div class="row g-2">
					<div class="col-md">
						<div class="form-floating mb-3">
							<input type="text" class="form-control enable1"
								id="floatingInput" placeholder="name"
								value="${admins[0].addressOne }" name="address1" disabled> <label
								for="floatingInput" class="dm">Address 1</label>
						</div>
					</div>
					<div class="col-md">
						<div class="form-floating mb-3">
							<input type="text" class="form-control enable1" value=" "
								id="floatingInput" placeholder="name" name="address2" name="${admins[0].addressTwo }" disabled> <label
								for="floatingInput" class="dm" >Address 2</label>
						</div>
					</div>
				</div>

				<div class="row g-2">
					<div class="col-md">
						<div class="form-floating mb-3">
							<input type="text" class="form-control enable1"
								id="floatingInput" placeholder="name"  value=" ${users[0].city } " name="city"
								disabled> <label for="floatingInput" class="dm">City</label>
						</div>
					</div>
					<div class="col-md">
						<div class="form-floating mb-3">
							<input type="text" class="form-control enable1"
								id="floatingInput" placeholder="name" value="${users[0].state }" name="state"
								disabled> <label for="floatingInput" class="dm">State</label>
						</div>
					</div>
				</div>

				<div class="row g-2">
					<div class="col-md">
						<div class="form-floating mb-3">
							<input type="text" class="form-control enable1"
								id="floatingInput" placeholder="name"
								value="${users[0].zipcode }" name="zip" disabled> <label
								for="floatingInput" class="dm">Zip</label>
						</div>
					</div>
					<div class="col-md">


						<div class="form-floating mb-3">
							<input type="tel"
								class="form-control pt-3 pb-3  iti iti__country-list enable1"
								id="phone1" value="${users[0].mobile }" name="phone" disabled>

						</div>


					</div>
				</div>

				<div class="mt-4 d-flex flex-row-reverse mb-3 ">
					<button type="button"
						class="btn btn-info btn-lg mx-3 random1 xx1 mb-2  "
						onclick="show5()">Edit</button>
					<button type="button"
						class="btn btn-danger btn-lg mx-2 hide1 see1 come1 mb-2"
						onclick="show6()" hidden>Cancel</button>
					<button type="submit"
						class="btn btn-success btn-lg mx-2 hide1 see1 come1 mb-2"
						onclick="show6()" hidden>Save</button>



				</div>
</form>









				<div class="col-md-2"></div>
			</div>



		</div>

	</div>




	</div>
	<div
		class="footer d-flex  align-items-center justify-content-end mt-3 ">
		<p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions |
			privacy policy</p>
	</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
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

			console.log("clicked")
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
	</script>

	<script>
		function show3() {

			console.log("clicked")
			$('.hide2').removeClass("hide2");
			$('.random2').addClass("hide2");
			$('.enable2').removeAttr("disabled");
			$('.come2').removeAttr("hidden");
			$('.xx2').attr("hidden", "hidden");

		}

		function show4() {
			$('.hide2').removeClass("hide2");
			$('.see2').addClass("hide2");
			$('.enable2').attr("disabled", "disabled");
			$('.come2').attr("hidden", "hidden");
			$('.xx2').removeAttr("hidden");

		}
	</script>


	<script>
		function show5() {

			console.log("clicked")
			$('.hide1').removeClass("hide1");
			$('.random1').addClass("hide1");
			$('.enable1').removeAttr("disabled");
			$('.come1').removeAttr("hidden");
			$('.xx1').attr("hidden", "hidden");

		}

		function show6() {
			$('.hide1').removeClass("hide1");
			$('.see1').addClass("hide1");
			$('.enable1').attr("disabled", "disabled");
			$('.come1').attr("hidden", "hidden");
			$('.xx1').removeAttr("hidden");

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
		$('input:radio[value="${users[0].regionId }"]').attr('checked',
				'checked');

		function stateSelect() {
			var regionId = $('input[name="state"]:checked').val();
			$("#region").attr("value", regionId);
		}
	</script>
</body>




</html>