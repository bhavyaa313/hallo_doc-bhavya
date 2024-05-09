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
<title>Provider Dasdhboard</title>

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
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
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
</style>
</head>

<body>

	<jsp:include page="Navbar.jsp" />


	<div class="foot" style="padding-bottom: 17%;">
		<div class="container-fluid my-4">
			<div class="row w-100">

				<button type="button" class="btn btn-link col-md-2 col-4 bt-badge"
					id="new"
					onclick="myFunction('blue','blu1', 'bluecol', 'blue-icon-white', 'blue-icon')">
					<img src="<c:url value="/resources/images/tri-blue.svg" />" alt=""
						class="dnone" id="blu1"> <span class="badge bdg-1 w-100"
						id="blue"> <img class="new-badge m-2"
						src="<c:url value="/resources/images/new.svg" />" alt=""
						id="blue-icon"> <img class="new-badge m-2 dnone"
						src="<c:url value="/resources/images/new - Copy.svg" />" alt=""
						id="blue-icon-white"> <span class="h6 ">NEW</span>



						<p class="h4 ml-2 fw-bold ">${counts[0] }</p>

					</span>
				</button>

				<button type="button" class="btn btn-link col-md-2 col-4 bt-badge"
					onclick="myFunction('sky','sky1', 'skycol','sky1-icon-white', 'sky-icon')">
					<img src="<c:url value="/resources/images/tri-sky.svg" />" alt=""
						class="dnone" id="sky1"> <span
						class="badge bdg-2 bg-info-subtle text-info w-100" id="sky">
						<img class="new-badge m-2"
						src="<c:url value="/resources/images/pending.svg" />" alt=""
						id="sky-icon"> <img class="new-badge  m-2 dnone"
						src="<c:url value="/resources/images/pending - Copy.svg" />"
						alt="" id="sky1-icon-white"> <span class="h6">PENDING</span>

						<p class="h4 ml-2 fw-bold ">${counts[1] }</p>

					</span>
				</button>

				<button type="button" class="btn btn-link col-md-2 col-4 bt-badge"
					onclick="myFunction('green','grn1','grncol','grn1-icon-white','grn-icon')">
					<img src="<c:url value="/resources/images/tri-green.svg" />" alt=""
						class="dnone" id="grn1"> <span
						class="badge bdg-3 bg-success-subtle text-success w-100"
						id="green"> <img class="new-badge m-2"
						src="<c:url value="/resources/images/active.svg" />" alt=""
						id="grn-icon"> <img class="new-badge m-2 dnone"
						src="<c:url value="/resources/images/active - Copy.svg" />" alt=""
						id="grn1-icon-white"> <span class="h6">ACTIVE</span>
						<p class="h4 ml-2 fw-bold">${counts[2] }</p>
					</span>
				</button>

				<button type="button" class="btn btn-link col-md-2 col-4 bt-badge"
					onclick="myFunction('pink','pink1','pinkcol','pink1-icon-white','pink-icon')">
					<img src="<c:url value="/resources/images/tri-pink.svg" />" alt=""
						class="dnone" id="pink1"> <span class="badge bdg-4 w-100"
						id="pink"> <img class="new-badge m-2"
						src="<c:url value="/resources/images/conclude.svg" />" alt=""
						id="pink-icon"> <img class="new-badge m-2 dnone"
						src="<c:url value="/resources/images/conclude - Copy.svg" />"
						alt="" id="pink1-icon-white"> <span class="h6">CONCLUDE</span>
						<p class="h4 ml-2 fw-bold">${counts[3] }</p>
					</span>
				</button>





			</div>

			<div class="d-flex flex-row mt-4">

				<span class="h3 fs-6-sm lo">Patients <span>(New)</span></span> <span
					class="h6 lo-btn">Patients <span>(New)</span></span>
				<button type="button" class="btn btn-info ml-auto mx-2"
					data-bs-toggle="modal" data-bs-target="#send_mail">
					<img src="<c:url value="/resources/images/link.svg" />" alt="">
					<span class="btn-span">Send Link</span>
				</button>
				<a href="createReq/${userList[0].userID}/${id}" type="button"
					class="btn btn-info mr-2"> <img
					src="<c:url value="/resources/images/req.svg" />" alt=""> <span
					class="btn-span text-white">Create Requests</span>
				</a>



			</div>
		</div>
		<div class="container-fluid px-3">

			<div class="row m-0 p-2 bg-white">

				<div class="col-lg-4 d-md-flex d-block">





					<div class="input-group border me-2 rounded-0 mb-2 form-control">
						<div class="input-group-append">
							<button class="btn text-secondary border border-0 bg-white"
								type="button">
								<i class="bi bi-search"></i>
							</button>
						</div>


						<input type="text" id="search-input"
							class="form-control border-0  shadow-none"
							placeholder="Search Patients">
					</div>



				</div>
				<div class="col-lg-8 pt-2">
					<div
						class="d-lg-flex d-none justify-content-end align-items-center">
						<div class="me-4">
							<button type="button"
								class="btn btn-outline-secondary bt-badge-role ">All</button>
						</div>
						<button type="button" class="bt-badge-role border-0 bg-white">
							<div class="me-2 d-sm-flex align-items-center" id="Patient">

								<div class="rounded-circle me-1"
									style="height: 15px; width: 15px; background-color: rgb(15, 189, 64);">
								</div>
								<p class="my-auto">Patients</p>

							</div>
						</button>
						<button type="button" class="bt-badge-role border-0 bg-white">
							<div class="me-2 d-sm-flex align-items-center" id="Family">

								<div class="rounded-circle me-1"
									style="height: 15px; width: 15px; background-color: rgb(212, 107, 21);">
								</div>
								<p class="my-auto">Family/Friend</p>

							</div>
						</button>
						<button type="button" class="bt-badge-role border-0 bg-white">
							<div class="me-2 d-sm-flex align-items-center" id="Business">

								<div class="rounded-circle me-1"
									style="height: 15px; width: 15px; background-color: rgb(203, 22, 134);">
								</div>
								<p class="my-auto">Business</p>

							</div>
						</button>
						<button type="button" class="bt-badge-role border-0 bg-white">
							<div class="me-2 d-sm-flex align-items-center" id="Concierge">

								<div class="rounded-circle me-1"
									style="height: 15px; width: 15px; background-color: rgb(65, 65, 232);">
								</div>
								<p class="my-auto">Concierge</p>

							</div>
						</button>

					</div>


					<div
						class="d-lg-none d-flex align-items-center justify-content-around">
						<div class="me-4 d-sm-block d-none">
							<button class="btn btn-outline-secondary">All</button>
						</div>
						<div class="me-1 d-sm-flex align-items-center">
							<div class="rounded-circle mx-auto"
								style="height: 12px; width: 12px; background-color: rgb(15, 189, 64);"></div>
							<p class="my-auto ps-1" style="font-size: small;">Patients</p>
						</div>
						<div class="me-1 d-sm-flex align-items-center">
							<div class="rounded-circle mx-auto"
								style="height: 12px; width: 12px; background-color: rgb(212, 107, 21);"></div>
							<p class="my-auto ps-1" style="font-size: small;">Family/Friend</p>
						</div>
						<div class="me-1 d-sm-flex align-items-center">
							<div class="rounded-circle mx-auto"
								style="height: 12px; width: 12px; background-color: rgb(203, 22, 134);"></div>
							<p class="my-auto ps-1" style="font-size: small;">Business</p>
						</div>
						<div class="me-1 d-sm-flex align-items-center">
							<div class="rounded-circle mx-auto"
								style="height: 12px; width: 12px; background-color: rgb(65, 65, 232);"></div>
							<p class="my-auto ps-1" style="font-size: small;">Concierge</p>
						</div>

					</div>
				</div>

			</div>
			</form>








			<div class="d-md-block d-none">
				<table class="table" id="myTable">



					<thead class="table-secondary t-header">
						<!-- <tr > -->
						<!-- <th scope="col"
							class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">Name</th>
						<th scope="col"
							class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction"></th>

						<th scope="col"
							class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction">Date
							of Birth</th>
						<th scope="col"
							class="PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">Physician
							Name</th>
						<th scope="col"
							class="PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">Date
							of Service</th>
						<th scope="col" class="ToCloseAction">Region</th>
						<th scope="col" class="NewAction PendingAction ActiveAction">Requestor</th>
						<th scope="col" class="NewAction">Requested Date</th>
						<th scope="col"
							class="NewAction PendingAction ActiveAction ConcludeAction UnpaidAction">Phone</th>
						<th scope="col"
							class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">Address</th>
						<th scope="col"
							class="NewAction PendingAction ActiveAction ToCloseAction">Notes</th>

						<th scope="col"
							class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">Actions</th> -->
						<!-- </tr> -->
					</thead>

					<%-- <c:forEach items="${adminDashboardDtos}" var="r"> --%>

					<tbody class="table-success t-data">
						<!-- <tr > -->
						<%-- <td class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction"> ${r.name}</td>
						<td class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">E</td>
						
						<td class="NewAction ActiveAction ConcludeAction ToCloseAction PendingAction">${r.dob}</td>
						<td class="PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">docter</td>
						<td class="PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">DOS</td>
						<td class="ToCloseAction">${r.region }</td>
						<td class="NewAction PendingAction ActiveAction">${requestor }</td>
						
						<td class="NewAction PendingAction ActiveAction ConcludeAction UnpaidAction">${r.phone }</td>
						<td class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction">${r.address }</td>
						<td class="NewAction PendingAction ActiveAction ToCloseAction">${r.notes }</td>
						<td class="NewAction PendingAction ActiveAction ConcludeAction ToCloseAction UnpaidAction"><a class=" dropdown-toggle btn-sm btn  "
							style="border: 1px solid rgb(12, 12, 12); border-radius: 3px;"
							href="#" role="button" data-bs-toggle="dropdown"
							aria-expanded="false"> Actions </a>


						<ul class="dropdown-menu text-muted">
							<li class="NewAction"><a class="dropdown-item " data-bs-toggle="modal"
								data-bs-target="#assign"><i
									class="bi bi-card-checklist mx-2"></i>assign Case</a></li>
							<li class="NewAction"><a class="dropdown-item" data-bs-toggle="modal"
								data-bs-target="#cancel"><i class="bi bi-x-circle mx-2"></i>cancel
									case</a></li>
							<li class="PendingAction NewAction ActiveAction ConcludeAction ToCloseAction UnpaidAction"><a class="dropdown-item text-secondary"
								href="view_case.html"><i class="bi bi-card-heading mx-2"></i>view
									case</a></li>
							<li class="PendingAction ToCloseAction"><a class="dropdown-item" data-bs-toggle="modal"
								data-bs-target="#clear"><i class="bi bi-x-circle mx-2"></i>clear
									case</a></li>
							<li class="ToCloseAction"><a class="dropdown-item text-secondary"
								href="close_case.html"><i class="bi bi-x-circle mx-2"></i>close
									case</a></li>
							<li class="PendingAction NewAction ActiveAction ConcludeAction ToCloseAction UnpaidAction"><a class="dropdown-item text-secondary"
								href="view_notes.html"><i class="bi bi-journal-medical mx-2 "></i>view
									notes</a></li>
							<li class="NewAction"><a class="dropdown-item text-secondary"
								data-bs-toggle="modal" data-bs-target="#block"><i
									class="bi bi-ban mx-2"></i>Block Patients</a></li>
							<li class="PendingAction ActiveAction ConcludeAction"><a class="dropdown-item text-secondary"
								href="View_uploads.html"><i
									class="bi bi-file-earmark-arrow-up mx-2 ToCloseAction UnpaidAction"></i> view uploads</a></li>
							<li class="PendingAction"><a class="dropdown-item" data-bs-toggle="modal"
								data-bs-target="#transfer"><i
									class="bi bi-card-checklist mx-2"></i>transfer</a></li>
							<li class="PendingAction"><a class="dropdown-item" data-bs-toggle="modal"
								data-bs-target="#send"> <i
									class="bi bi-file-earmark-slides mx-2 "></i>send agreement
							</a></li>
							<li class="ActiveAction ConcludeAction ToCloseAction"><a class="dropdown-item text-secondary"
								href="orders.html"><i
									class="bi bi-clipboard-check-fill mx-2"></i>orders</a></li>
							<li class="ActiveAction ConcludeAction ToCloseAction"><a class="dropdown-item text-secondary" href="#"><i
									class="bi bi-file-earmark-richtext mx-2"></i>doctors notes</a></li>

							<li class="ActiveAction ConcludeAction ToCloseAction"><a class="dropdown-item text-secondary" href="#"><i
									class="bi bi-file-earmark-richtext mx-2"></i>encounter</a></li>
						</ul>
						</td> --%>




						<!-- </tr> -->
					</tbody>
					<%-- </c:forEach> --%>



				</table>

			</div>







			<!-- mobile view for table -->
			<div class="d-md-none">
				<div class="accordion accordion-flush " id="a-data">
					<!-- 				 <div class="accordion-item">
						<h2 class="accordion-header">
							<div class="accordion-button collapsed bg-primary-subtle"
								type="button" data-bs-toggle="collapse"
								data-bs-target="#flush-collapseOne" aria-expanded="false"
								aria-controls="flush-collapseOne">
								<div class="container-fluid">
									<div class="d-flex justify-content-between mb-3">
										<div class="">
											<h6>Patel, Sahil</h6>
										</div>
										<div class="d-flex justify-content-center">
											<h6 class="me-1">Patients</h6>
											<div class="rounded-circle mt-1"
												style="height: 12px; width: 12px; background-color: rgb(15, 189, 64);">
											</div>
										</div>
									</div>
									<div class="d-flex justify-content-between">
										<div class="">
											<p class="fw-normal mb-0">Maryland Maryland,</p>
											<p class="fw-normal">Maryland 2121</p>
										</div>
										<div class="">
											<button
												class="btn btn-outline-info btn-sm rounded-pill maploc">Map
												Location</button>
										</div>
									</div>
									<div class="d-flex">
										<img src="" alt="">
										<p class="text-secondary fw-small" style="font-size: 0.8rem;">
											Wait Time: <span class="fw-small">Dec 5,2023 08:52AM
												(641.59)</span>
										</p>
									</div>
								</div>
							</div>

						</h2>
						<div id="flush-collapseOne" class="accordion-collapse collapse"
							data-bs-parent="#accordionFlushExample">

							<hr class="m-0">
							<div class="d-flex justify-content-end"
								style="margin-top: -12px;">
								<button
									class="btn text-primary btn-outline-primary rounded-pill bg-white py-0 px-2 me-4 z-3"
									style="font-size: small; position: absolute;">View
									Case</button>
							</div>


							<div class="accordion-body container-fluid mt-2">
								<div class="d-flex">
									<div class="me-1">
										<i class="bi bi-calendar-event"></i>
									</div>
									<label for="" class="me-2 text-secondary">Date of
										birth:</label>
									<p>Jun 28, 1991(33)</p>
								</div>
								<div class="d-flex">
									<div class="me-1">
										<i class="bi bi-envelope"></i>
									</div>
									<label for="" class="me-2 text-secondary">Email:</label>
									<p>sahil.patel@gmail.com</p>
								</div>
								<div class="d-flex">
									<div class="me-1">
										<i class="bi bi-telephone"></i>
									</div>
									<label for="" class="me-2 text-secondary">Patient:</label>
									<p>2-23-1991(33)</p>
								</div>
								<div class="d-flex">
									<div class="me-1">
										<i class="bi bi-person"></i>
									</div>
									<label for="" class="me-2 text-secondary">Requestor:</label>
									<p>Patient Patel,sahil</p>
								</div>
								<div>
									<div class="row mb-2 ">
										<div class="col-6">
											<button class="btn text-white rounded-pill w-100"
												data-bs-toggle="modal" data-bs-target="#assign"
												style="background-color: purple; font-size: small;">Assign
												Case</button>
										</div>
										<div class="col-6">
											<button
												class="btn bg-danger border-0 text-white rounded-pill w-100"
												style="font-size: small;" data-bs-target="#cancel"
												data-bs-toggle="modal">Cancel Case</button>
										</div>


									</div>
									<div class="row mb-2">
										<div class="col-6">
											<a class="btn bg-success text-white rounded-pill w-100"
												style="font-size: small;" href="view_notes.html">View
												Notes</a>
										</div>
										<div class="col-6">
											<button
												class="btn bg-danger border-0 text-white rounded-pill w-100"
												style="font-size: small;" data-bs-toggle="modal"
												data-bs-target="#block">Block Patients</button>
										</div>
									</div>
									<div class="row mb-2">
										<div class="col-6">
											<button class="btn bg-success text-white rounded-pill w-100"
												style="font-size: small;">Email</button>
										</div>

									</div>
								</div>

							</div>
						</div>
					</div>
 -->
				</div>
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
							<input type="text" id="reqId33" name="reqId3" hidden> <input
								type="text" name="phyId" id="phyId" hidden>

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

		<div class="modal fade" id="cancel" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog  modal-dialog-centered">
				<div class="modal-content">
					<form action="cancelCaseAction/${userList[0].userID}" method="post">
						<div class="modal-header bg-info text-white">
							<h1 class="modal-title fs-5 " id="exampleModalLabel">Confirm
								Cancellation</h1>
							<button type="button" class="btn-close btn-close-white"
								data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<p mb-3>
								Patient Name: <span class="text-info " id="pname"></span>
							</p>



							<div class="form-floating mb-3">

								<select class="form-select" id="floatingSelect"
									aria-label="Floating label select example" name="reasonString">
									<c:forEach items="${reasonsList}" var="r">

										<option value="${r.id }">${r.reason}</option>

									</c:forEach>
								</select> <label for="floatingSelect">Reasons for Cancellation</label>
							</div>

							<div class="form-floating mb-3">
								<textarea class="form-control"
									placeholder="Leave a comment here" id="floatingTextarea2"
									style="height: 100px" name="additionalNoteString"></textarea>
								<label for="floatingTextarea2">Provide Additional Notes</label>
							</div>


						</div>
						<input type="text" id="reqId" name="reqId" hidden>
						<div class="modal-footer">

							<button type="submit" class="btn btn-info">Confirm</button>
							<button type="button" class="btn btn-outline-info"
								data-bs-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>


		<div class="modal fade" id="accept" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog  modal-dialog-centered">

				<div class="modal-content rounded-4">
					<form action="acceptCaseAction" method="post">
						<div class="modal-body text-center">

							<p style="margin-top: 30px;" class="fw-bold fs-4">Accept Case</p>

							<p style="font-size: 13px; margin: 0;">Are you sure you want
								to Accept this request?</p>

							<p style="font-size: 13px;">Once Accept this request then you
								are not able to Decline this request.</p>

							<input type="text" id="reqId5" name="reqId5"> <input
								type="text" name="phyId" value="${id }" hidden>
						</div>
						<div
							class="modal-footer border-top-0 pb-5 d-flex justify-content-center">

							<button type="submit" class="btn btn-info  text-white btn-lg "
								data-bs-dismiss="modal">Accept</button>
							<button type="button" class="btn btn-info  text-white btn-lg "
								data-bs-dismiss="modal">Cancel</button>
						</div>
					</form>
				</div>

			</div>
		</div>

		<div class="modal fade" id="block" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog  modal-dialog-centered">
				<div class="modal-content">
					<form action="blockCaseAction/${userList[0].userID}" method="post">
						<div class="modal-header bg-info text-white">
							<h1 class="modal-title fs-5 " id="exampleModalLabel">Block
								Case</h1>
							<button type="button" class="btn-close btn-close-white"
								data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<p mb-3>
								Patient Name: <span class="text-info" id="pname2"></span>
							</p>


							<div class="form-floating mb-3">
								<textarea class="form-control"
									placeholder="Leave a comment here" id="floatingTextarea2"
									style="height: 100px" name="additionalNoteString2"></textarea>
								<label for="floatingTextarea2">Reason for Block Request</label>
							</div>
							<input type="text" id="reqId2" name="reqId2">

						</div>
						<div class="modal-footer">

							<button type="submit" class="btn btn-info">Confirm</button>
							<button type="button" class="btn btn-outline-info"
								data-bs-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>


		<div class="modal fade" id="transfer" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog  modal-dialog-centered">
				<div class="modal-content">
					<form
						action="${pageContext.request.contextPath}/transferCaseActionProvider/${userList[0].userID}/${id }"
						method="post">
						<div class="modal-header bg-info text-white">
							<h1 class="modal-title fs-5 " id="exampleModalLabel">Transfer
								Request</h1>
							<button type="button" class="btn-close btn-close-white"
								data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<p mb-3>To transfer this request back to admin</p>




							<div class="form-floating mb-3">
								<textarea class="form-control"
									placeholder="Leave a comment here" id="floatingTextarea2"
									style="height: 100px" name="notes1"></textarea>
								<label for="floatingTextarea2">Description</label>
							</div>
							<input type="text" id="reqId4" name="reqId4" hidden> <input
								type="text" name="phyId1" value="${id }" hidden>

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
		<div class="modal fade" id="care11" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Select
							Type of care</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					
					<div class="modal-body">
						<div class="mx-3 d-flex justify-content-center">
						<input id="reqId10" name="reqId10" value="" hidden>
							<input id="reqId10" name="reqId11" value="" hidden>
							<button href="" type="button" id="mev"
								class="btn btn-outline-info mx-2">HouseCall</button>
							<button type="button" class="btn btn-outline-info mx-2 "
								id="elsev">Consult</button>
						</div>
					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-outline-info mx-2"
							id="continue">
							Save</a>
							<button type="button" class="btn btn-outline-info mx-2 "
								data-bs-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="send" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog  modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header bg-info text-white">
						<h1 class="modal-title fs-5 " id="exampleModalLabel">Send
							Agreement</h1>
						<button type="button" class="btn-close btn-close-white"
							data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<form action="sendAgreementAction" method="post">
						<div class="modal-body">


							<div class="form-check mb-3">
								<input class="form-check-input" type="radio"
									name="flexRadioDefault" id="flexRadioDefault2" checked>
								<label class="form-check-label" for="flexRadioDefault2">
									Patient </label>
							</div>
							<p>To Send Agreement please make sure you are updating the
								current contact information below for the responsible party.</p>


							<div class="form-floating mb-3">
								<input type="number" class="form-control" placeholder="Number"
									id="phone1"> <label for="floatingPassword">Phone
									Number</label>
							</div>
							<div class="form-floating mb-3">
								<input type="email" class="form-control" id="email1"
									placeholder="name@example.com" name="email23"> <label
									for="floatingInput">Email address</label>
							</div>
							<input type="text" id="reqId6" name="reqId6" hidden> <input
								type="text" name="phyId" value="${id }" hidden>





						</div>
						<div class="modal-footer">

							<button type="submit" class="btn btn-info">Send</button>
							<button type="button" class="btn btn-outline-info"
								data-bs-dismiss="modal">Cancel</button>
						</div>
					</form>
				</div>
			</div>
		</div>


		<div class="modal fade" id="req" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog  modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header bg-info text-white">
						<h1 class="modal-title fs-5 " id="exampleModalLabel">Request
							Support</h1>
						<button type="button" class="btn-close btn-close-white"
							data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<p mb-3>To all unscheduled Physicians: We are short on
							coverage and needs additional support On call to respond to
							requests.</p>


						<div class="form-floating mb-3">
							<textarea class="form-control" placeholder="Leave a comment here"
								id="floatingTextarea2" style="height: 100px"></textarea>
							<label for="floatingTextarea2">Message</label>
						</div>

					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-info">Send</button>
						<button type="button" class="btn btn-outline-info"
							data-bs-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="send_mail" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog  modal-dialog-centered">
				<div class="modal-content">
					<form action="${pageContext.request.contextPath}/send/${id }"
						method="POST">
						<div class="modal-header bg-info text-white">
							<h3 class="modal-title fs-5 " id="exampleModalLabel">Send
								mail to patient for submitting request</h3>
							<button type="button" class="btn-close btn-close-white"
								data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">


							<div class="form-floating mb-3">
								<input type="text" class="form-control" id="floatingPassword"
									placeholder="name"> <label for="floatingInput">First
									Name</label>
							</div>
							<div class="form-floating mb-3">
								<input type="text" class="form-control" id="floatingPassword"
									placeholder="name"> <label for="floatingInput">last
									Name</label>
							</div>



							<div class="form-floating mb-3">
								<input type="tel"
									class="form-control pt-3 pb-3  iti iti__country-list"
									placeholder="Mobile Number" id="phone2">

							</div>

							<div class="form-floating mb-3">
								<input type="email" class="form-control" id="floatingInput"
									placeholder="name@example.com" name="emailsend"> <label
									for="floatingInput">Email address</label>
							</div>






						</div>
						<div class="modal-footer">

							<button type="submit" class="btn btn-info">Send</button>
							<button type="button" class="btn btn-outline-info"
								data-bs-dismiss="modal">Cancel</button>
						</div>
					</form>
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
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>



	<script>
	
	
	
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
	console.log("transfer case")
	$('#regionSelector1').change(function () {
	    console.log(this);
	    let region = this.value;
	    console.log(region)
		$.ajax({
			
			
			
			url: "ajaxForTransferCase",
			type: "get",
			data: {
				region:region
			},
			success: function(data) {
				
				$("#physicians1").empty();
				for(var i=0; i<data.length; i++){
					console.log(data);
					var row = `<option>`+data[i][0]+`</option>`
					$("#phyId4").attr('value' , data[i][2]);
					$("#physicians1").append(row);
				}
				
			}
				
			})
		
	})
	</script>

	<script>
	<script>
	$(".exportajax").click(function(){
		
		let table = $('.maintable').clone();
		table.find(".no-export").each(function(){
			$(this).remove();
		});
		table.find(".d-none").each(function(){
			$(this).remove();
		})

		  TableToExcel.convert(table[0], { // html code may contain multiple tables so here we are refering to 1st table tag
		    name: $('#stateInfo').text()+`State.xlsx`, // fileName you could use any name
		    sheet: {
		      name: 'Sheet 1' // sheetName
		    }
		  });
		
	});


	</script>

	<script type="text/javascript">
	console.log("eportt")
	$(".exportAll").click(function(){
		console.log("export all")
		
		$.ajax({
			url:"exportAll",
			method:"post",
			xhrFields: {
				responseType: 'blob'
			},
	 	 	contentType:"application/json",
			success:function(data){
				 var blob = new Blob([data]);
			      var url = window.URL.createObjectURL(blob);
			      var a = document.createElement('a');
			      a.href = url;
			      a.download = "export.xlsx"; // Set your desired filename
			      a.click();
			      window.URL.revokeObjectURL(url);
			},
		 error: function(error) {
		      console.error("Error exporting data:", error);
		      // Handle the error here, like displaying an error message to the user
		    }
			
		});
		
	});
	


</script>


	<script type="text/javascript">
	

	$(document).ready(function() {
		console.log("docss-----------");
	  	$("#new").click();  
	});
	
	</script>

	<script>
	
	console.log("yeahhhhhh")
	function cancelCase(pname, reqId) {
  console.log("Success!"); 


  $('#pname').text(pname);
  $('#pname2').text(pname);
  console.log(pname)

  
  $('#reqId').attr('value' , reqId);
  $('#reqId2').attr('value' , reqId);
  $('#reqId33').attr('value' , reqId);
  $('#reqId4').attr('value' , reqId);
  $('#reqId5').attr('value' , reqId);
  $('#reqId6').attr('value' , reqId);
  $('#reqId10').attr('value' , reqId);
  $('#reqId11').attr('value' , reqId);
  console.log(reqId)
}
	</script>

	<script>
	
	console.log("yeahhhhhh")
	function sendAgreement(email, phone, reqId) {
  console.log("Success!"); 


  

  
  $('#email1').attr('value' , email);
  $('#phone1').attr('value' , phone);
  $('#reqId6').attr('value' , reqId);
  

}
	</script>




	<script>
		//for click prevention of map location button 
		let mapbtn = [];
		mapbtn = document.getElementsByClassName("maploc");

		function stop() {
			window.location.href = "dashboard.html";

		}

		for (let i = 0; i < mapbtn.length; i++) {
			mapbtn[i].addEventListener('click', function(e) {
				e.stopPropagation();
				stop();
				console.log("hello");
			});
		}
	</script>

	<script>

		  
	function search(){
		 if (event.keyCode === 13) { // Check for Enter key (keyCode 13)
		      var input = $("#myInput");
		      var filter = input.val().toLowerCase();
		      console.log(filter);
		    }
			 

		  };

		

		 
		
	</script>
	<script>
		 console.log("cisdfsrfchsdefuo")
                const phoneInputField = document.querySelector("#phone2");
                const phoneInput = window.intlTelInput(phoneInputField, {
                    utilsScript:
                        "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js",
                });
            </script>

	<script>
		$(".bt-badge").click(function() {
			
			console.log("hii");

			var class1 = $(this).children('span').attr('id');
			
			
			$("#myTable").show();

			 if(class1 == "blue"){
				 $(".PendingAction").hide();
				 $(".ActiveAction").hide();
				 $(".ConcludeAction").hide();
				 $(".ToCloseAction").hide();
				 $(".UnpaidAction").hide();
				 $(".NewAction").show();
			 }
			 else if(class1 == "sky") {
				 $(".NewAction").hide();
				 $(".ActiveAction").hide();
				 $(".ConcludeAction").hide();
				 $(".ToCloseAction").hide();
				 $(".UnpaidAction").hide();
				 $(".PendingAction").show();
			 }
			 else if(class1 == "green") {
				 $(".NewAction").hide();
				 $(".PendingAction").hide();
				 $(".ConcludeAction").hide();
				 $(".ToCloseAction").hide();
				 $(".UnpaidAction").hide();
				 $(".ActiveAction").show();
			 }
			 else if(class1 == "pink") {
				 $(".NewAction").hide();
				 $(".PendingAction").hide();
				 $(".ActiveAction").hide();
				 $(".ToCloseAction").hide();
				 $(".UnpaidAction").hide();
				 $(".ConcludeAction").show();
			 }
			 else if(class1 == "light-blue") {
				 $(".NewAction").hide();
				 $(".PendingAction").hide();
				 $(".ActiveAction").hide();
				 $(".ConcludeAction").hide();
				 $(".UnpaidAction").hide();
				 $(".ToCloseAction").show();
			 }
			 else if(class1 == "purple") {
				 $(".NewAction").hide();
				 $(".PendingAction").hide();
				 $(".ActiveAction").hide();
				 $(".ConcludeAction").hide();
				 $(".ToCloseAction").hide();
				 $(".UnpaidAction").show();
			 }

		})
	</script>
	<script>
	
	console.log("jdisujo")
	$(".bt-badge").on('click', onBadgeClick);
	$(".bt-badge-role").on('click', onBadgeClick);
	$("#search-input").on('keyup', onBadgeClick); 
	
	
	
	var qForclas1 =[];
function onBadgeClick(event) {
	debugger 
		
		console.log("hii");
		
		var class1 = $(this).children('span').attr('id');
		if(typeof(class1) == "undefined")
		{
				if(typeof($(".bt-badge span.bluecol")[0]) != "undefined"){
		console.log("blueeeee")
		class1 = "blue";
		}
		else if(typeof($(".bt-badge span.skycol")[0]) != "undefined"){
		console.log("skyyyy")
		class1="sky";
		}
		else if(typeof($(".bt-badge span.grncol")[0]) != "undefined"){
		class1="green";
		}
		else if(typeof($(".bt-badge span.pinkcol")[0]) != "undefined"){
		class1="pink";
		}
		else if(typeof($(".bt-badge span.l-bluecol")[0]) != "undefined"){
		class1="light-blue";
		}
		else if(typeof($(".bt-badge span.purplecol")[0]) != "undefined"){
		class1="purple";
		}
				}
		
		
		var valueofInput = $('#search-input').val();
		console.log(valueofInput);
		var check = $(this).children('div').attr('id');
		var roleWiseId = (($(this).children('div').attr('id')!= "" ? ($(this).children('div').attr('id')) : "undefined"));
		var phyID = ${id };
		  var userID = ${userList[0].userID};
		if(class1!=undefined){
			qForclas1.push(class1);
		}
		
		 if(valueofInput=="")
			{
			valueofInput="undefined";
			}
		 //console.log(valueofInput + " =====")
		
		else if(valueofInput!=undefined){
			class1 = qForclas1.at(qForclas1.length-1);
		}
		console.log(class1);
	debugger
	$.ajax({
		
		  url: "ajaxcallForProvider/"+class1+"/"+roleWiseId+"/"+valueofInput+"/"+phyID,// URL to make the request to
		  type: "GET",    // HTTP method (GET, POST, etc.) 
		  
		  dataType: "json", // Expected data type of the response (optional)
		  success: function(data) {
			  debugger
			  console.log(data);
			  console.log("jii")
			
			$(".t-header").empty();
			  
			
			  console.log("hearder-empty");
			  
			 $(".t-data").empty();
			 
			 var accbody = $("#a-data");
			 accbody.empty();
			 var th = `<tr>
			 <th scope="col" class="NewAction PendingAction ActiveAction ConcludeAction ">Name</th>
				
				
					
					<th scope="col" class="NewAction PendingAction ActiveAction ConcludeAction ">Phone</th>
					<th scope="col" class="NewAction PendingAction ActiveAction ConcludeAction ">Address</th>
					<th scope="col" class=" ActiveAction ">Status</th>
					<th scope="col" class="NewAction PendingAction ActiveAction ConcludeAction ">Actions</th>
				</tr>`
				
				$(".t-header").append(th);
				
				
				for(let i =0 ; i<data.length ; i++ )
					{
					
					var dataset = data[i];
					console.log(dataset)
					var id = dataset.requestId;
					var email = dataset.email;
					var phone = dataset.phone;
					console.log("hello")
					console.log(id);
					
				
			var rows = `<tr><td class="NewAction PendingAction ActiveAction ConcludeAction ">`+ dataset.name+`</td>
				
				<td class="NewAction PendingAction ActiveAction ConcludeAction ">`+ dataset.phone+`</td>
				<td class="NewAction PendingAction ActiveAction ConcludeAction ">`+ dataset.address+`</td>
				<td class="ActiveAction"><a href="housecalls/`+phyID+`/`+id+`" type="button" id="housecall"
					class="btn btn-outline-info mx-2"  >`+ dataset.housecall+`</a>
				</td>
				<td class="NewAction PendingAction ActiveAction ConcludeAction "><a class=" dropdown-toggle btn-sm btn text-white border border-white "
					style="border: 1px solid rgb(255, 255, 255); border-radius: 2px;"
					href="#" role="button" data-bs-toggle="dropdown"
					aria-expanded="false"> Actions </a>


				<ul class="dropdown-menu text-muted">
					
					
					<li class="NewAction PendingAction ActiveAction ConcludeAction "><a class="dropdown-item text-secondary"
						href="viewCase/`+id+`"><i class="bi bi-card-heading mx-2"></i>view
							case</a></li>
					
				
					<li class="NewAction PendingAction ActiveAction ConcludeAction "><a class="dropdown-item text-secondary"
						href="viewNotes/`+userID+`/`+id+`"><i class="bi bi-journal-medical mx-2 "></i>View
							Notes</a></li>
					
					<li class="PendingAction ActiveAction ConcludeAction"><a class="dropdown-item text-secondary"
						href="viewDocs/`+id+`""><i
							class="bi bi-file-earmark-arrow-up mx-2 ToCloseAction UnpaidAction"></i> View Uploads</a></li>
							
					<li class="NewAction PendingAction"><a class="dropdown-item" data-bs-toggle="modal"
						data-bs-target="#transfer" onclick="cancelCase('`+dataset.name+`', `+id+`)"><i
							class="bi bi-card-checklist mx-2"></i>Transfer</a></li>
							
					<li class="PendingAction"><a class="dropdown-item" onclick="sendAgreement('`+email+`', '`+phone+`',  `+id+`)" data-bs-toggle="modal"
						data-bs-target="#send"> <i
							class="bi bi-file-earmark-slides mx-2 "></i>Send Agreement
					</a></li>
					
					<li class="ActiveAction ConcludeAction "><a class="dropdown-item text-secondary"
						href="orders/`+id+`/`+phyID+`""><i
							class="bi bi-clipboard-check-fill mx-2"></i>Orders</a></li>
							
					<li class="NewAction"><a class="dropdown-item" onclick="cancelCase('`+dataset.name+`', `+id+`)" data-bs-toggle="modal"
						data-bs-target="#accept"><i class="bi bi-x-circle mx-2"></i>Accept
							Case</a></li>

					<li class=" ConcludeAction "><a class="dropdown-item text-secondary" href="encounter/`+id+`/`+phyID+`"><i
							class="bi bi-file-earmark-richtext mx-2"></i>Encounter Form</a></li>
							

			                  <li class="ActiveAction  "><a class="dropdown-item text-secondary" data-bs-toggle="modal" onclick="cancelCase('`+dataset.name+`', `+id+`)" data-bs-target="#care11"><i
			                        class="bi bi-file-earmark-richtext mx-2"></i>encounter</a></li>		
				</ul>
				</td></tr>`
				
				
			let id1 = "id" + i;
			var accordian = `<div class="accordion-item">
				<h2 class="accordion-header">
				<div class="accordion-button collapsed bg-primary-subtle"
					type="button" data-bs-toggle="collapse"
						data-bs-target="#` + id1 + `"  aria-expanded="false"
					aria-controls="` + id1 + `">
					<div class="container-fluid">
						<div class="d-flex justify-content-between mb-3">
							<div class="">
								<h6>`+ dataset.name +`</h6>
							</div>
							<div class="d-flex justify-content-center">
								<h6 class="me-1">Patients</h6>
								<div class="rounded-circle mt-1"
									style="height: 12px; width: 12px; background-color: rgb(15, 189, 64);">
								</div>
							</div>
						</div>
						<div class="d-flex justify-content-between">
							<div class="">
								<p class="fw-normal mb-0">`+ dataset.address +`</p>
								
							</div>
							<div class="">
								<button
									class="btn btn-outline-info btn-sm rounded-pill maploc">Map
									Location</button>
							</div>
						</div>
						<div class="d-flex">
							<img src="" alt="">
							<p class="text-secondary fw-small" style="font-size: 0.8rem;">
								Wait Time: <span class="fw-small">Dec 5,2023 08:52AM
									(641.59)</span>
							</p>
						</div>
					</div>
				</div>

			</h2>
			<div id="` + id1 + `" class="accordion-collapse collapse"
				data-bs-parent="#accordionFlushExample">

				<hr class="m-0">
				<div class="d-flex justify-content-end"
					style="margin-top: -12px;">
					<button
						class="btn text-primary btn-outline-primary rounded-pill bg-white py-0 px-2 me-4 z-3"
						style="font-size: small; position: absolute;">View
						Case</button>
				</div>


				<div class="accordion-body container-fluid mt-2">
					<div class="d-flex">
						<div class="me-1">
							<i class="bi bi-calendar-event"></i>
						</div>
						<label for="" class="me-2 text-secondary">Date of
							birth:</label>
						<p>`+ dataset.dob +`</p>
					</div>
					<div class="d-flex">
						<div class="me-1">
							<i class="bi bi-envelope"></i>
						</div>
						<label for="" class="me-2 text-secondary">Email:</label>
						<p>`+ dataset.email +`</p>
					</div>
					<div class="d-flex">
						<div class="me-1">
							<i class="bi bi-telephone"></i>
						</div>
						<label for="" class="me-2 text-secondary">Patient:</label>
						<p>`+ dataset.phone +`</p>
					</div>
					<div class="d-flex">
						<div class="me-1">
							<i class="bi bi-person"></i>
						</div>
						<label for="" class="me-2 text-secondary">Requestor:</label>
						<p>Patient `+ dataset.name +`</p>
					</div>
					<div>
						<div class="row mb-2 ">
							<div class="col-6">
								<button class="btn text-white rounded-pill w-100"
									data-bs-toggle="modal" data-bs-target="#assign"
									style="background-color: purple; font-size: small;">Assign
									Case</button>
							</div>
							<div class="col-6">
								<button
									class="btn bg-danger border-0 text-white rounded-pill w-100"
									style="font-size: small;" data-bs-target="#cancel"
									data-bs-toggle="modal">Cancel Case</button>
							</div>


						</div>
						<div class="row mb-2">
							<div class="col-6">
								<a class="btn bg-success text-white rounded-pill w-100"
									style="font-size: small;" href="view_notes.html">View
									Notes</a>
							</div>
							<div class="col-6">
								<button
									class="btn bg-danger border-0 text-white rounded-pill w-100"
									style="font-size: small;" data-bs-toggle="modal"
									data-bs-target="#block">Block Patients</button>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col-6">
								<button class="btn bg-success text-white rounded-pill w-100"
									style="font-size: small;">Email</button>
							</div>

						</div>
					</div>

				</div>
			</div>
		</div>` 
		
	
			
		$(".t-data").append(rows);
	

if(class1 == "blue" && dataset.status==1){
					console.log("iffff")
				
					$(accbody).append(accordian);
					
					
					if(dataset.requestTypeId==1){
						$('table tr:last td').css({"background-color": "#DC143C","color": "#ffffff"
                    });
					}
					else if(dataset.requestTypeId==2) {
						$('table tr:last td').css({"background-color": "#228C20" , "color": "#ffffff"
					});
					}
					else if(dataset.requestTypeId==3) {
						$('table tr:last td').css({"background-color": "#FF7600" , "color": "#ffffff"
					});
					}
					else if(dataset.requestTypeId==4) {
						$('table tr:last td').css({"background-color": "#0096FF", "color": "#ffffff"
					}); 
					}
					
					$(".PendingAction").hide();
		 			$(".ActiveAction").hide();
		 			$(".ConcludeAction").hide();
		 			$(".ToCloseAction").hide();
		 			$(".UnpaidAction").hide();
		 			$(".NewAction").show();
					
					
				}
			
				else if(class1 == "sky" && dataset.status==2){
						console.log("iffff")
					/* 	$(".t-data").append(rows); */
						$(accbody).append(accordian);
						
						if(dataset.requestTypeId==1){
							$('table tr:last td').css({"background-color": "#DC143C","color": "#ffffff"
	                    });
						}
						else if(dataset.requestTypeId==2) {
							$('table tr:last td').css({"background-color": "#228C20" , "color": "#ffffff"
						});
						}
						else if(dataset.requestTypeId==3) {
							$('table tr:last td').css({"background-color": "#FF7600" , "color": "#ffffff"
						});
						}
						else if(dataset.requestTypeId==4) {
							$('table tr:last td').css({"background-color": "#0096FF", "color": "#ffffff"
						});
						}
						
						$(".NewAction").hide();
						 $(".ActiveAction").hide();
						 $(".ConcludeAction").hide();
						
						 $(".PendingAction").show();
						
						
					}
			
				else if(class1 == "green" && (dataset.status==4 || dataset.status==5)){
					console.log("iffff")
			/* 		$(".t-data").append(rows); */
					$(accbody).append(accordian);
					
					if(dataset.requestTypeId==1){
						$('table tr:last td').css({"background-color": "#DC143C","color": "#ffffff"
                    });
					}
					else if(dataset.requestTypeId==2) {
						$('table tr:last td').css({"background-color": "#228C20" , "color": "#ffffff"
					});
					}
					else if(dataset.requestTypeId==3) {
						$('table tr:last td').css({"background-color": "#FF7600" , "color": "#ffffff"
					});
					}
					else if(dataset.requestTypeId==4) {
						$('table tr:last td').css({"background-color": "#0096FF", "color": "#ffffff"
					});
					}
					
					$(".NewAction").hide();
					 $(".PendingAction").hide();
					 $(".ConcludeAction").hide();
					 $(".ToCloseAction").hide();
					 $(".UnpaidAction").hide();
					 $(".ActiveAction").show();
					
					
				}
			
				else if(class1 == "pink" && dataset.status==6){
					console.log("iffff")
			/* 		$(".t-data").append(rows); */
					$(accbody).append(accordian);
					
					if(dataset.requestTypeId==1){
						$('table tr:last td').css({"background-color": "#DC143C","color": "#ffffff"
                    });
					}
					else if(dataset.requestTypeId==2) {
						$('table tr:last td').css({"background-color": "#228C20" , "color": "#ffffff"
					});
					}
					else if(dataset.requestTypeId==3) {
						$('table tr:last td').css({"background-color": "#FF7600" , "color": "#ffffff"
					});
					}
					else if(dataset.requestTypeId==4) {
						$('table tr:last td').css({"background-color": "#0096FF", "color": "#ffffff"
					});
					}
					
					 $(".NewAction").hide();
					 $(".PendingAction").hide();
					 $(".ActiveAction").hide();
					 $(".ToCloseAction").hide();
					 $(".UnpaidAction").hide();
					 $(".ConcludeAction").show();
					
					
				}
			
				
			
				
			
			
			
			
			
			
				
			
				
			
			}
				
			
			
		
			
			

	            
	            

				
				
		  },
		
		});
	}
	</script>






	<script>





      let metemp = false;
      let elsetemp = false;
     

      $('#mev').on('click', function () {
        // $('#me').click();
        metemp = true;
        elsetemp = false;
        console.log(metemp);
      })
      $('#elsev').on('click', function () {
        // $('#else').click();
        elsetemp = true;
        metemp = false;
        console.log(elsetemp);
      })
      $('#continue').on('click', function () {
        if (metemp == true) {
            var x =   $('#reqId10').val();
            let url = "housecall/${id}/"+ x; 
            document.location.href = url;
         
        	
          console.log("me")
        }
        else if (elsetemp == true) {
         
           alert("transferred to conclude state")
                var x =   $('#reqId10').val();
           let url = "consult/${id}/"+ x; 
           document.location.href = url;
          console.log("else")
        }
      })




    </script>




</body>

</html>