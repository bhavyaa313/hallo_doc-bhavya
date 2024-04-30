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
							<h3 class="mt-3">Edit Physician Account</h3>
							<div class="ms-auto p-3">
								<a href="javascript: history.go(-1)" type="button"
									class="btn btn-outline-info mx-2 "> < Back</a>
							</div>
						</div>

					</div>
					<div class="bg-white p-3">

						<h4 class="mb-2">Account Information</h4>

						<form
							action="${pageContext.request.contextPath}/resetPhy/${p[0].physicianId }/${p[0].aspnetUserId.id}" method="post">
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control " id="floatingInput"
											placeholder="name" value="${p[0].aspnetUserId.userName }"
											disabled> <label for="floatingInput" class="dm">User
											Name</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="password" class="form-control "
											id="floatingInput" placeholder="name" name="pswd"> <label
											for="floatingInput" class="dm">Password</label>
									</div>
								</div>
							</div>
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating">
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
											aria-label="Floating label select example" disabled>

											<option value="2">Provider</option>

										</select> <label for="floatingSelect">Role</label>
									</div>
								</div>
							</div>
							<div class="mt-4 d-flex flex-row-reverse mb-3 ">


								<button type="button"
									class="btn btn-info btn-lg mx-3 random xx enable "
									onclick="show()">Reset Password</button>
								<button type="button"
									class="btn btn-danger btn-lg mx-2 hide see come"
									onclick="show2()" hidden>Cancel</button>
								<button type="submit"
									class="btn btn-success btn-lg mx-2 hide see come "
									onclick="show2()" hidden>Save</button>




							</div>
						</form>





						<!-- <input type="tel" class="form-control pt-3 pb-3  " id="phone"> -->
						<h4 class="mt-5">Physician Information</h4>
						<form
							action="${pageContext.request.contextPath}/resetPhy1/${p[0].physicianId }/${p[0].aspnetUserId.id}" method="post">

							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control enable2"
											id="floatingInput" placeholder="name" name="fName"
											value="${p[0].firstName }" disabled> <label
											for="floatingInput" class="dm">First Name</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control enable2"
											id="floatingInput" placeholder="name" name="lName"
											value="${p[0].lastName }" disabled> <label
											for="floatingInput" class="dm">Last Name</label>
									</div>
								</div>
							</div>


							<div class="row g-2">
								<div class="col-md ">
									<div class="form-floating mb-3">
										<input type="email" class="form-control enable2"
											id="floatingInput" placeholder="name@example.com"
											name="email" value="${p[0].email }" disabled> <label
											for="floatingInput" class="dm">Email</label>
									</div>
								</div>


								<div class="col-md ">
									<div class="form-floating mb-3">
										<input type="tel"
											class="form-control pt-3 pb-3  iti iti__country-list enable2"
											id="phone" value="${p[0].mobile }" name="phone" disabled>

									</div>
								</div>


							</div>

							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control enable2"
											id="floatingInput" placeholder="name" name="medicalLi"
											value="${p[0].medicalLiscense }" disabled> <label
											for="floatingInput" class="dm">Medical License #</label>
									</div>
								</div>

								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control enable2"
											id="floatingInput" placeholder="name" name="npiNum"
											value="${p[0].npiNumber }" disabled> <label
											for="floatingInput" class="dm">NPI Number</label>
									</div>
								</div>
							</div>
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control enable2"
											id="floatingInput" placeholder="name" name=""
											value="${p[0].syncEmailAddress }" disabled> <label
											for="floatingInput" class="dm">Synchronization Email
											Address </label>
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
										<input type="text" name="state" id="region" hidden>

									</div>


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



					
					<h4>Mailing & Billing Information</h4>
					<form action="${pageContext.request.contextPath}/resetPhy2/${p[0].physicianId }/${p[0].aspnetUserId.id}" method="post">
					
					<div class="row g-2">
						<div class="col-md">
							<div class="form-floating mb-3">
								<input type="text" class="form-control enable1"
									id="floatingInput" placeholder="name"
									value="${p[0].addressOne }" name="addrOne" disabled> <label
									for="floatingInput" class="dm">Address 1</label>
							</div>
						</div>
						<div class="col-md">
							<div class="form-floating mb-3">
								<input type="text" class="form-control enable2"
									id="floatingInput" placeholder="name" name="addrTwo"
									value="${p[0].addressTwo }" disabled> <label
									for="floatingInput" class="dm">Address 2</label>
							</div>
						</div>
					</div>

					<div class="row g-2">
						<div class="col-md">
							<div class="form-floating mb-3">
								<input type="text" class="form-control enable1"
									id="floatingInput" placeholder="name" name="city"
									value="${p[0].city }" disabled> <label
									for="floatingInput" class="dm">City</label>
							</div>
						</div>

					</div>

					<div class="row g-2">
						<div class="col-md">
							<div class="form-floating mb-3">
								<input type="text" class="form-control enable2"
									id="floatingInput" placeholder="name" value="${p[0].zip }"
									name="zip" disabled> <label for="floatingInput"
									class="dm">Zip</label>
							</div>
						</div>
						<div class="col-md">


							<div class="form-floating mb-3">
								<input type="tel"
									class="form-control pt-3 pb-3  iti iti__country-list enable1"
									value="${p[0].altPhone }" id="phone1" disabled>

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
					
					

					<h4>Provider Profile</h4>
					<form action="${pageContext.request.contextPath}/resetPhy3/${p[0].physicianId }/${p[0].aspnetUserId.id}" method="post">
					<div class="row g-2">
						<div class="col-md">
							<div class="form-floating mb-3">
								<input type="text" class="form-control enable5"
									id="floatingInput" placeholder="name" name="bName"
									value="${p[0].businessName }" disabled> <label
									for="floatingInput" class="dm">Business Name</label>
							</div>
						</div>

						<div class="col-md">
							<div class="form-floating mb-3">
								<input type="text" class="form-control enable5"
									id="floatingInput" placeholder="name" name="bWebsite"
									value="${p[0].businessWebsite }" disabled> <label
									for="floatingInput" class="dm">Business Website</label>
							</div>
						</div>
					</div>


					<div class="row g-2">
						<div class="col-md">
							<div class="input-group mb-3 drill_cursor mt-3">
								<input type="file" name="" id="input_file" hidden> <input
									type="text" class="form-control col-form-label-lg enable5"
									value="${p[0].photo }" id="txt" onclick="open_file" name="photo"
									placeholder="Upload " aria-label="Upload"
									aria-describedby="button-addon2" disabled>
								<button class="btn btn-outline-info bg-info enable3"
									type="button" onclick="open_file()" id="button-addon2" disabled>
									<img src="images/cloud-arrow-up.svg" alt=""> <span
										style="color: white;" class="lo enable3">Select Photo</span>
								</button>

							</div>


						</div>

						<div class="col-md-4 col-9">
							<div class="input-group mb-3 drill_cursor mt-3">
								<input type="file" name="" id="input_file1" hidden> <input
									type="text" class="form-control col-form-label-lg enable3 "
									value="${p[0].signature }" id="txt" onclick="open_file"
									placeholder="Upload " aria-label="Upload" name="sign"
									aria-describedby="button-addon2" disabled>
								<button class="btn btn-outline-info bg-info enable3"
									type="button" onclick="open_file()" id="button-addon2" disabled>
									<img src="images/cloud-arrow-up.svg" alt=""> <span
										style="color: white;" class="lo enable5" enable3>Select
										Signature</span>
								</button>

							</div>

						</div>

					</div>

					<div class="form-floating">
						<textarea class="form-control enable5"
							placeholder="Leave a comment here" id="floatingTextarea2" name="adminNotes" 
							style="height: 200px" disabled>${p[0].adminNotes }</textarea>
						<label for="floatingTextarea2">Comments</label>
					</div>


					<div class="mt-4 d-flex flex-row-reverse mb-3 ">
						<button type="button"
							class="btn btn-info btn-lg mx-3 random5 xx5 mb-2  "
							onclick="show7()">Edit</button>
						<button type="button"
							class="btn btn-danger btn-lg mx-2 hide5 see5 come5 mb-2"
							onclick="show8()" hidden>Cancel</button>
						<button type="submit"
							class="btn btn-success btn-lg mx-2 hide5 see5 come5 mb-2"
							onclick="show8()" hidden>Save</button>
					</div>
					</form>

					<table class="table table-sm ">
						<h4>Onboarding</h4>
						<thead>
							<tr>
								<th scope="col" class="col-sm-1"></th>
								<th scope="col " class=" col-sm-4"></th>
								<th scope="col" class="col-sm-5"></th>


							</tr>
						</thead>
						<tbody>
							<tr>

								<td>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value=""
											id="flexCheckChecked" checked> <label
											class="form-check-label" for="flexCheckChecked"> </label>
									</div>
								</td>
								<td>Independent Contractor Agreement</td>

								<td><input type="file" name="" id="input_file" hidden>


									<button type="button" class="btn btn-outline-info mx-2 ">
										View</button></td>
							</tr>
							<tr>

								<td>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value=""
											id="flexCheckChecked" checked> <label
											class="form-check-label" for="flexCheckChecked"> </label>
									</div>
								</td>
								<td>Background Check</td>

								<td>
									<button class="btn btn-outline-info mx-2" type="button"
										onclick="open_file()" id="button-addon2">
										<img class="lo-btn" src="images/cloud-arrow-up.svg" alt="">
										<span class="lo">Upload</span>
									</button>
									<button type="button" class="btn btn-outline-info mx-2 ">
										View</button>
								</td>
							</tr>
							<tr>

								<td>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value=""
											id="flexCheckChecked" checked> <label
											class="form-check-label" for="flexCheckChecked"> </label>
									</div>
								</td>
								<td>HIPPA Compliance</td>

								<td>
									<button class="btn btn-outline-info mx-2" type="button"
										onclick="open_file()" id="button-addon2">
										<img class="lo-btn" src="images/cloud-arrow-up.svg" alt="">
										<span class="lo">Upload</span>
									</button>
									<button type="button" class="btn btn-outline-info mx-2 ">
										View</button>
								</td>
							</tr>
							<tr>

								<td>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value=""
											id="flexCheckChecked" checked> <label
											class="form-check-label" for="flexCheckChecked"> </label>
									</div>
								</td>
								<td>Non-disclosure Agreement</td>

								<td>
									<button class="btn btn-outline-info mx-2" type="button"
										onclick="open_file()" id="button-addon2">
										<img class="lo-btn" src="images/cloud-arrow-up.svg" alt="">
										<span class="lo">Upload</span>
									</button>
									<button type="button" class="btn btn-outline-info mx-2 ">
										View</button>
								</td>
							</tr>
							<tr class="">

								<td class="">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value=""
											id="flexCheckChecked" checked> <label
											class="form-check-label" for="flexCheckChecked"> </label>
									</div>
								</td>
								<td class="">License Document</td>

								<td class="">
									<button class="btn btn-outline-info mx-2 mb-3" type="button"
										onclick="open_file()" id="button-addon2">
										<img class="lo-btn" src="images/cloud-arrow-up.svg" alt="">
										<span class="lo">Upload</span>
									</button>
									<button type="button" class="btn btn-outline-info mx-2 mb-3 ">
										View</button>
								</td>

							</tr>

						</tbody>
					</table>
				</div>




				<div class="col-md-2"></div>
			</div>
			<div
				class="footer d-flex  align-items-center justify-content-end mt-3 ">
				<p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions |
					privacy policy</p>
			</div>
		</div>
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

		document.getElementsByClassName('drill_cursor')[0].addEventListener(
				'click', function(event) {
					// do something
					document.getElementById('input_file1').click();
					changePlaceholder();

				})
		function changePlaceholder() {
			$('input[type="file"]').change(function(e) {
				const names = e.target.files[0].name;

				$('#txt').attr('placeholder', names);
			});
		}
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
		function show7() {

			console.log("clicked")
			$('.hide5').removeClass("hide5");
			$('.random5').addClass("hide5");
			$('.enable5').removeAttr("disabled");
			$('.come5').removeAttr("hidden");
			$('.xx5').attr("hidden", "hidden");

		}

		function show8() {
			$('.hide5').removeClass("hide5");
			$('.see5').addClass("hide5");
			$('.enable5').attr("disabled", "disabled");
			$('.come5').attr("hidden", "hidden");
			$('.xx5').removeAttr("hidden");

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
		$('input:radio[value="${p[0].regionId }"]').attr('checked', 'checked');

		function stateSelect() {
			var regionId = $('input[name="state"]:checked').val();
			$("#region").attr("value", regionId);
		}
	</script>
</body>




</html>
