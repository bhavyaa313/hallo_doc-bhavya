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

	<div class="foot">
		<div class="container-fluid bg-light ">
			<div class="row">
				<div class=" col-md-2"></div>
				<div class="col-12 col-md-8 ">
					<div class="container-fluid bg-light">
						<div class="d-flex mb-3">
							<h3 class="mt-3">Encounter Form</h3>
							<div class="ms-auto p-3">
								<a href="javascript: history.go(-1)" type="button"
									class="btn btn-outline-info mx-2 lo"> < Back</a>
							</div>
						</div>

					</div>
					<div class="bg-white p-3">

						<h2 class="mb-2 text-info text-center lo">Medical Report
							Confidential</h2>
						<h2 class="mb-4 text-info text-center  lo-btn fs-5">Medical
							Report Confidential</h2>

						<form action="${pageContext.request.contextPath}/submitEncounterProvider/${reqId }" method="post">
							<div class="row g-2 mt-3">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="floatingInput"
											placeholder="name" value="${requestClients[0].firstName}"
											disabled> <label for="floatingInput" class="dm">First
											Name</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="floatingInput"
											placeholder="name" value="${requestClients[0].lastName}"
											disabled> <label for="floatingInput" class="dm">Last
											Name</label>
									</div>
								</div>
							</div>
							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="floatingInput"
											placeholder="name" value="${requestClients[0].city}" disabled>
										<label for="floatingInput" class="dm">Location</label>
									</div>
								</div>

							</div>

							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="floatingInput"
											placeholder="name" value="${fullDate }" disabled> <label
											for="floatingInput" class="dm">Date Of Birth</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="floatingInput"
											value="${DOS }" placeholder="name" disabled> <label
											for="floatingInput" class="dm">date</label>
									</div>
								</div>
							</div>


							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="email" class="form-control" id="floatingInput"
											value="${requestClients[0].email}" placeholder="name"
											disabled> <label for="floatingInput" class="dm">Email</label>
									</div>
								</div>

								<div class="col-md">
									<div class="form-floating mb-3">
										<input type="tel"
											class="form-control pt-3 pb-3  iti iti__country-list"
											id="phone" value="${requestClients[0].phoneNumber}" disabled>

									</div>
								</div>
							</div>

							<div class="row g-2 mb-3">
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control flex-wrap enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="history1" disabled>${encounterList[0].historyOfIllness}</textarea>
										<label for="floatingTextarea2">History Of Present
											Illness or Injury</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="" style="height: 75px"
											name="history2" disabled>${encounterList[0].medicalHistory}</textarea>
										<label for="floatingTextarea2">Medical History</label>
									</div>
								</div>
							</div>

							<div class="row g-2">
								<div class="col-md">
									<div class="form-floating mb-3 ">
										<input type="text" class="form-control enable" id="floatingInput"
											placeholder="name" name="temp"
											value="${encounterList[0].temp} " disabled> <label
											for="floatingInput" class="dm">Temp</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3 ">
										<input type="text" class="form-control enable" id="floatingInput"
											placeholder="name" name="hr" value="${encounterList[0].hr}"
											disabled> <label for="floatingInput" class="dm">HR</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3 ">
										<input type="text" class="form-control enable" id="floatingInput"
											placeholder="name" name="rr" value="${encounterList[0].rr}"
											disabled> <label for="floatingInput" class="dm">RR</label>
									</div>
								</div>
							</div>

							<div class="row g-2">
								<div class="col-md-2">
									<div class="form-floating mb-3 ">
										<input type="text" class="form-control enable" id="floatingInput"
											placeholder="name" name="bloodPressurePlus"
											value="${encounterList[0].bloodPressurePlus}" disabled>
										<label for="floatingInput" class="dm">BP-1</label>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-floating mb-3 ">
										<input type="text" class="form-control enable" id="floatingInput"
											placeholder="name" name="bloodPressureNeg"
											value="${encounterList[0].bloodPressureNeg}" disabled>
										<label for="floatingInput" class="dm">BP-2</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3 ">
										<input type="text" class="form-control enable" id="floatingInput"
											placeholder="name" name="o2" value="${encounterList[0].o2}"
											disabled> <label for="floatingInput" class="dm">02</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating mb-3 ">
										<input type="text" class="form-control enable" id="floatingInput"
											placeholder="name" name="pain"
											value="${encounterList[0].pain}" disabled> <label
											for="floatingInput" class="dm">Pain</label>
									</div>
								</div>
							</div>

							<div class="row g-2 mb-3">
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="heent" disabled>${encounterList[0].heent}</textarea>
										<label for="floatingTextarea2">Heent</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="cv" disabled>${encounterList[0].cv}</textarea>
										<label for="floatingTextarea2">CV</label>
									</div>
								</div>
							</div>

							<div class="row g-2 mb-3">
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="chest" disabled>${encounterList[0].chest}</textarea>
										<label for="floatingTextarea2">Chest</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="abd" disabled>${encounterList[0].abd}</textarea>
										<label for="floatingTextarea2">ABd</label>
									</div>
								</div>
							</div>


							<div class="row g-2 mb-3">
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="extr" disabled>${encounterList[0].extr}</textarea>
										<label for="floatingTextarea2">Extr</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="skin" disabled>${encounterList[0].skin}</textarea>
										<label for="floatingTextarea2">skin</label>
									</div>
								</div>
							</div>


							<div class="row g-2 mb-3">
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="neuro" disabled>${encounterList[0].neuro}</textarea>
										<label for="floatingTextarea2">Neuro</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="other" disabled>${encounterList[0].other}</textarea>
										<label for="floatingTextarea2">Other</label>
									</div>
								</div>
							</div>


							<div class="row g-2 mb-3">
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="diagnosis" disabled>${encounterList[0].diagnosis}</textarea>
										<label for="floatingTextarea2">Diagnosis</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="treatmentPlan" disabled>${encounterList[0].treatmentPlan}</textarea>
										<label for="floatingTextarea2">Treatment Plan</label>
									</div>
								</div>
							</div>


							<div class="row g-2 mb-3">
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="medicationsDespensed" disabled>${encounterList[0].medicationsDespensed}</textarea>
										<label for="floatingTextarea2">Medications Dispensed</label>
									</div>
								</div>
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="procedures" disabled>${encounterList[0].procedures}</textarea>
										<label for="floatingTextarea2">Procedures</label>
									</div>
								</div>
							</div>


							<div class="row g-2 mb-3">
								<div class="col-md">
									<div class="form-floating">
										<textarea class="form-control enable"
											placeholder="Leave a comment here" id="floatingTextarea2"
											style="height: 75px" name="followUp" disabled>${encounterList[0].followUp} </textarea>
										<label for="floatingTextarea2">Followup</label>
									</div>
								</div>

							</div>
							<input type="text" value="${phyID }" name="phyID" hidden>















							<div class="mt-4 d-flex flex-row-reverse mb-3  ">

								<a href="javascript: history.go(-1)" type="button"
									class="btn btn-outline-info btn mx-2 mb-3" id="close">Close</a>
								<button type="submit" class="btn btn-info btn mx-2 mb-3" onclick="show2()"
									id="savechanges" hidden>Save Changes</button>
								<button type="button" class="btn btn-outline-info btn mx-2 mb-3"
									onclick="show()" id="edit">Edit</button>
									<a type="button" href="${pageContext.request.contextPath}/finalize/${reqId }/${phyID}" class="btn btn-success btn mx-2 mb-3"
									id="show1" >finalize</a>
								<!-- <button type="submit" class="btn btn-success btn mx-2 mb-3"
									id="show1" data-bs-toggle="modal" data-bs-target="#ec" >finalize</button> -->



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

	<div class="modal fade" id="ec" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog  modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header bg-info text-white">
					<h1 class="modal-title fs-5 " id="exampleModalLabel">Transfer
						Request</h1>
					<button type="button" class="btn-close btn-close-white"
						data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<p class="fs-5">Encounter form is finalized successfully!</p>

					<div class="mt-5 mx-auto text-center">
						<button type="button" class="btn btn-info btn-lg ">Download</button>

					</div>
				</div>

			</div>
		</div>
	</div>



<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

	<script>

		function show(){
	$('.enable').removeAttr("disabled");
	$('#savechanges').removeAttr("hidden");
	/* $('#show1').removeAttr("hidden"); */
	$('#edit').hide();
	$('#show1').hide();
	$('#close').hide();
}

/* function show2()
{
	$('.enable').attr("disabled", true);
	$('#edit').removeAttr("hidden");
	$('#close').show(); 
	$('savechanges').attr("hidden", true);
	$('#show1').hide();
	
	} */

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



</body>




</html>