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


						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control enable"
										id="floatingInput" placeholder="name" disabled> <label
										for="floatingInput" class="dm">User Name</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="password" class="form-control enable"
										id="floatingInput" placeholder="name" disabled> <label
										for="floatingInput" class="dm">Password</label>
								</div>
							</div>
						</div>
						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating ">
									<select class="form-select enable" id="floatingSelect"
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
									<select class="form-select enable" id="floatingSelect"
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


							<button type="submit" class="btn btn-info btn-lg mx-3 random  "
								onclick="show()">Edit</button>
							<button type="submit" class="btn btn-danger btn-lg mx-2 hide see"
								onclick="show2()">Cancel</button>
							<button type="submit"
								class="btn btn-success btn-lg mx-2 hide see " onclick="show2()">Save</button>

						</div>





						<!-- <input type="tel" class="form-control pt-3 pb-3  " id="phone"> -->
						<h4 class="mt-5">Administrator Information</h4>


						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control enable1"
										id="floatingInput" placeholder="name" disabled> <label
										for="floatingInput" class="dm">First Name</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control enable1"
										id="floatingInput" placeholder="name" disabled> <label
										for="floatingInput" class="dm">Last Name</label>
								</div>
							</div>
						</div>


						<div class="row g-2">
							<div class="col-md ">
								<div class="form-floating mb-3">
									<input type="email" class="form-control enable1"
										id="floatingInput" placeholder="name@example.com" disabled>
									<label for="floatingInput" class="dm">Email</label>
								</div>
							</div>


							<div class="col-md ">
								<div class="form-floating mb-3">
									<input type="email" class="form-control enable1"
										id="floatingInput" placeholder="name@example.com" disabled>
									<label for="floatingInput" class="dm">Confirm Email</label>
								</div>
							</div>


						</div>

						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3 enable1">
									<input type="tel"
										class="form-control pt-3 pb-3  enable2 iti iti__country-list"
										id="phone" disabled>

								</div>
							</div>

							<div class="col-md">


								<div class="d-flex flex-row  ">
									<div class="p-2 mx-3">
										<div class="form-check">
											<input class="form-check-input enable1" type="checkbox"
												value="" id="flexCheckDefault" disabled> <label
												class="form-check-label" for="flexCheckDefault">
												District Of Columbia </label>

										</div>
									</div>
									<div class="p-2 mx-3">
										<div class="form-check">
											<input class="form-check-input enable1" type="checkbox"
												value="" id="flexCheckChecked" checked disabled> <label
												class="form-check-label" for="flexCheckChecked"> New
												York </label>
										</div>
									</div>
									<div class="p-2 mx-3">
										<div class="form-check">
											<input class="form-check-input enable1" type="checkbox"
												value="" id="flexCheckChecked" checked disabled> <label
												class="form-check-label" for="flexCheckChecked">
												Virginia </label>
										</div>
									</div>

								</div>
								<div class="d-flex flex-row mb-3 ">
									<div class="p-2 mx-3">
										<div class="form-check">
											<input class="form-check-input enable1" type="checkbox"
												value="" id="flexCheckDefault" disabled> <label
												class="form-check-label" for="flexCheckDefault">
												Maryland </label>

										</div>
									</div>


								</div>
							</div>


















							<div class="mt-4 d-flex flex-row-reverse mb-3 ">

								<button type="submit" class="btn btn-info btn-lg mx-2 random1"
									onclick="show3()">Edit</button>
								<button type="submit"
									class="btn btn-danger btn-lg mx-2 hide1 see1" onclick="show4()">Cancel</button>
								<button type="submit"
									class="btn btn-success btn-lg mx-2 hide1 see1"
									onclick="show4()">Save</button>


							</div>








						</div>



						<h4>Mailing & Billing Information</h4>
						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control enable2"
										id="floatingInput" placeholder="name" disabled> <label
										for="floatingInput" class="dm">Address 1</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control enable2"
										id="floatingInput" placeholder="name" disabled> <label
										for="floatingInput" class="dm">Address 2</label>
								</div>
							</div>
						</div>

						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control enable2"
										id="floatingInput" placeholder="name" disabled> <label
										for="floatingInput" class="dm">City</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control enable2"
										id="floatingInput" placeholder="name" disabled> <label
										for="floatingInput" class="dm">State</label>
								</div>
							</div>
						</div>

						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control enable2"
										id="floatingInput" placeholder="name" disabled> <label
										for="floatingInput" class="dm">Zip</label>
								</div>
							</div>
							<div class="col-md">


								<div class="form-floating mb-3">
									<input type="tel"
										class="form-control pt-3 pb-3  iti iti__country-list enable2"
										id="phone1" disabled>

								</div>


							</div>
						</div>

						<div class="mt-4 d-flex flex-row-reverse mb-3 ">

							<button type="submit" class="btn btn-info btn-lg random2  mb-4"
								onclick="show5()">Edit</button>
							<button type="submit"
								class="btn btn-danger btn-lg mx-2 hide2 see2" onclick="show6()">Cancel</button>
							<button type="submit"
								class="btn btn-success btn-lg mx-2 hide2 see2 mb-4"
								onclick="show6()">Save</button>


						</div>










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
			$('.hide').removeClass("hide");
			$('.random').addClass("hide");
			$('.enable').removeAttr("disabled");

		}

		function show2() {
			$('.hide').removeClass("hide");
			$('.see').addClass("hide");
			$('.enable').attr("disabled", "disabled");

		}
	</script>

	<script>
		function show3() {
			$('.hide1').removeClass("hide1");
			$('.random1').addClass("hide1");
			$('.enable1').removeAttr("disabled");

		}

		function show4() {
			$('.hide1').removeClass("hide1");
			$('.see1').addClass("hide1");
			$('.enable1').attr("disabled", "disabled");

		}
	</script>

	<script>
		function show5() {
			$('.hide2').removeClass("hide2");
			$('.random2').addClass("hide2");
			$('.enable2').removeAttr("disabled");

		}

		function show6() {
			$('.hide2').removeClass("hide2");
			$('.see2').addClass("hide2");
			$('.enable2').attr("disabled", "disabled");

		}
	</script>


</body>




</html>