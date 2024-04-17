<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>new_req</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


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
</style>
</head>

<body>

	<jsp:include page="Navbar.jsp" />




	<div class="foot mt-3 bg-light">

		<div class="container-fluid ">
			<div class="row">
				<div class=" col-md-2"></div>
				<div class="col-12 col-md-8 ">
					<div class="container-fluid bg-light">
						<div class="d-flex mb-3">
							<h3 class="mt-3">Submit Information</h3>
							<div class="ms-auto p-3">
								<a href="javascript: history.go(-1)" type="button"
									class="btn btn-outline-info mx-2 "> < Back</a>
							</div>
						</div>

					</div>
					<div class="bg-white p-3">

						<h4 class="mb-2">Patient</h4>

						<form action="new/${userID}" method="POST">
							<div class="form-floating mb-3">
								<textarea class="form-control "
									placeholder="Leave a comment here" id="floatingTextarea2"
									style="height: 100px" name="notes"></textarea>
								<label for="floatingTextarea2" class="dm"> Patient Notes</label>
								<hr>
							</div>
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="floatingInput"
											placeholder="name" name="firstName"> <label
											for="floatingInput" class="dm">First Name</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="floatingInput"
											placeholder="name" name="lastName"> <label
											for="floatingInput" class="dm">Last Name</label>
									</div>
								</div>
							</div>

							<div class="row g-2">
								<div class="col-md-6 col-6">
									<div class="form-floating mb-3">
										<input type="email" class="form-control" id="floatingInput"
											placeholder="name@example.com" name="email"> <label
											for="floatingInput" class="dm">Email</label>
									</div>
								</div>


								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="tel"
											class="form-control pt-3 pb-3  iti iti__country-list"
											id="phone" name="mobile">

									</div>
								</div>



							</div>
							<!-- <input type="tel" class="form-control pt-3 pb-3  " id="phone"> -->
							<h4>Patient Contact Information</h4>
							<div class="row g-2">
								<div class="col-md-6 ">
									<div class="form-floating mb-3">
										<!-- <input type="date" class="form-control" id="floatingInput"
                                    mailto:placeholder="name@example.com">
                                <label for="floatingInput">Date of Birth</label> -->
										<input type="text" id="uname" class="form-control"
											placeholder="Date Of Birth" name="DOB"
											onfocus="(this.type='date')"></input> <label
											for="floatingInput" class="dm">Date of Birth</label>
									</div>


								</div>

							</div>
							<h4>Location</h4>
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="street1"
											placeholder="rttttttth" name="street"> <label
											for="floatingInput" class="dm">Street</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="city"
											placeholder="trr" name="city"> <label
											for="floatingInput" class="dm">City</label>
									</div>
								</div>

							</div>

							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<select class="form-select"
											aria-label="Default select example" placeholder="tre"
											name="state">
											<!-- <option selected>State</option> -->
											<option>GUJARAT</option>
											<option>MAHARASHTRA</option>
											<option>MADHYAPRADESH</option>
											<option>RAJASTHAN</option>

										</select> <label for="floatingInput" class="dm">State</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="map"
											placeholder="trr" name="zipcode"> <label
											for="floatingInput" class="dm">Zip Code</label>
									</div>
								</div>

							</div>
							<div class="row g-2">
								<div class="col-md-6 col-6">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="floatingInput"
											placeholder="yhht"> <label for="floatingInput"
											class="dm">Room #</label>
									</div>
								</div>
								<div class="col-md">
									<button type="submit" class="btn btn-info mx-2 btn-lg ">Verify</button>
									<button type="button"
										class="btn btn-outline-info mx-2 p-2 highlight btn-lg"
										onclick="searchAddress()">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
                                        <path
												d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A32 32 0 0 1 8 14.58a32 32 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10" />
                                        <path
												d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4m0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6" />
                                    </svg>
										Map
									</button>
								</div>
							</div>


							<h4 class="mb-2">Notes</h4>

							<div class="form-floating mb-3">
								<textarea class="form-control "
									placeholder="Leave a comment here" id="floatingTextarea2"
									style="height: 100px" name="adminNotes"></textarea>
								<label for="floatingTextarea2" class="dm"> Admin Notes <span
									class="text-muted">(optional)</span></label>
								<hr>
							</div>










							<div class="mt-4 d-flex flex-row-reverse mb-3 ">

								<button type="button" class="btn btn-outline-info btn-lg mb-5">Cancel</button>

								<button type="submit" class="btn btn-info mx-2 btn-lg mb-5">Save</button>

							</div>










						</form>

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
	<script>
		console.log("Iwill not")
		function searchAddress() {
			console.log("shutupppppppppp")
			
			 const streetInput = document.getElementsByName('street')[0].value;
			  const cityInput = document.getElementsByName('city')[0].value;
			  const stateInput = document.getElementsByName('state')[0].value;
			const address = streetInput + " " + cityInput + " " + stateInput ;
			console.log(address);
			
		}
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




</body>


</html>