<%@page import="hallodoc.dto.enums.StatusEnum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="hallodoc.model.Request"%>
<%@page import="java.util.List"%>


<%@page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Patient Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">


<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/a07e852713.js"
	crossorigin="anonymous"></script>

<style>
.accordion-flush .accordion-item {
	margin-top: 0px !important;
	margin-bottom: 0px !important;
}
</style>

</head>

<body style="position: relative;">

	<nav class="navbar navbar-expand-lg navbar-toggler">

		<div class="container-fluid flex-column">

			<ul class="navbar-nav w-100 flex-row">

				<button class="navbar-toggler navbar-light nav-tog-btn px-0 mb-2"
					type="button" data-bs-toggle="offcanvas"
					data-bs-target="#navbarSupportedContent">
					<i class="fa-solid fa-bars"></i>
				</button>


				<li class="nav-item"><img class="hello-logo1 m-2"
					src="<c:url value="/resources/images/hellodoc-logo.png" />" alt="">
				</li>

				<li class="nav-item navbar-right ml-auto"><span class="wlcm">Welcome
						<span style="font-weight: 500;">${userList[0].firstName} ${userList[0].lastName}
							</span>
				</span> <a style="text-decoration: none;" href="logout">
						<button type="button" class="btn btn-outline-info mx-2 lo">Logout</button>
				</a> <a href="login_patient.html" type="button"
					class="btn btn-outline-info mx-2 lo-btn"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-box-arrow-right"
							viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
								d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                            <path fill-rule="evenodd"
								d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                        </svg>
				</a>

					<button type="button" class="btn btn-outline-info px-0 moon-img"
						onclick="myFunctions()">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-moon" viewBox="0 0 16 16">
                            <path
								d="M6 .278a.77.77 0 0 1 .08.858 7.2 7.2 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277q.792-.001 1.533-.16a.79.79 0 0 1 .81.316.73.73 0 0 1-.031.893A8.35 8.35 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.75.75 0 0 1 6 .278M4.858 1.311A7.27 7.27 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.32 7.32 0 0 0 5.205-2.162q-.506.063-1.029.063c-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286" />
                        </svg>
					</button></li>
			</ul>

			<hr style="border: 1px solid grey; width: 100%;">

			<div class="w-50 dash-nav offcanvas offcanvas-start mr-auto"
				id="navbarSupportedContent">
				<ul class="navbar-nav nav-underline offcanvas-body">
					<li class="nav-item mx-2 lo-btn"><span>Welcome <span
							class="fw-bold">${userList[0].firstName} ${userList[0].lastName}</span></span></li>
					<li class="nav-item mx-2 d-flex justify-content-between"><a
						href="" class="nav-link active  text-info">Dashboard</a></li>
					<li class="nav-item mx-2"><a href="edit/${userList[0].userID}"
						class="nav-link">Profile</a></li>
				</ul>
			</div>


		</div>

	</nav>

	<hr class="hr">

	<div class="container-fluid bg-light">

		<h4 class="mt-5 pl-4">Medical History</h4>

		<div class="container-fluid bg-white px-1 border rounded-2">

			<div class="flex-row d-flex my-3">


				<button type="button" class="btn btn-outline-info ml-auto"
					data-bs-toggle="modal" data-bs-target="#staticBackdrop">
					<span class="lo-btn">+</span> <span class="lo">Create New
						Request</span>
				</button>

				<div class="modal fade" id="staticBackdrop"
					data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
					aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header bg-info text-white">
								<h1 class="modal-title fs-5 mt-1" id="staticBackdropLabel">
									Create New Request</h1>
								<button type="button" class="btn" data-bs-dismiss="modal"
									aria-label="Close">
									<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
										fill="#ffffff" class="bi bi-x" viewBox="0 0 16 16">
                                        <path
											d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
								</button>
							</div>
							<div class="modal-body">
								<p>Here, I want to create new request for...</p>
								<div class="text-center">
									<button id="mev" type="button" class="btn btn-outline-info">Me</button>
									<button id="elsev" type="button" class="btn btn-outline-info">Some
										One Else</button>
								</div>

							</div>
							<div class="modal-footer">
								<button id="cont" type="button" class="btn btn-outline-info">Continue</button>
								<button type="button" class="btn btn btn-outline-info "
									data-bs-dismiss="modal" aria-label="Close">Cancel</button>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="table-responsive lo">

				<table class="table table-hover">
					<thead>
						<tr class="table-secondary">
							<td scope="col">Created Date</td>
							<td scope="col">Current Status</td>
							<td scope="col">Document</td>
						</tr>
					</thead>
					<tbody>


						<%
						List<Request> list = (List<Request>) request.getAttribute("requestsList");
						%>
						
						<%
						for(int i = 0; i<list.size(); i++)
						{
							


						
							LocalDateTime createdDate = list.get(i).getCreatedDate();
							int status = list.get(i).getStatus();
							String status1 = StatusEnum.getNameById(status);
							int requestId = list.get(i).getRequestId();
							String requestId1 = String.valueOf(requestId);
						
						
							%>


						<tr>
								<td scope="row"><%= createdDate %>
								</td>
								<td><%= status1%></td>
								<td><a href="showDocs/<%=requestId1 %>/${userList[0].firstName}/${userList[0].lastName}">
										<button type="button" class="btn btn-outline-info">(1)Documents</button>
								</a></td>
							</tr>
						
				<%} %>
					</tbody>

				</table>

			</div>

			<div class="accordion accordion-flush lo-btn">
				<div style="margin-bottom: 0px;" class="accordion-item">
					<button style="padding-right: 0;"
						class="accordion-button collapsed bg-info-subtle" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapseSix"
						aria-expanded="false" aria-controls="flush-collapseSix">

						<div style="font-size: small;" class="row w-100">

							<div class="col-8">
								<i class="fa-regular fa-clock text-info"></i> <span
									class="fw-bold">Created Date:</span> <span> Dec 5, 2023</span>
							</div>

						</div>

					</button>

					<div id="flush-collapseSix"
						class="accordion-collapse collapse bg-info-subtle"
						aria-labelledby="flush-headingOne"
						data-bs-parent="#accordionFlushExample">

						<div style="font-size: small;" class="accordion-body">
							<div class="row">
								<div class="col-12 pb-1 my-1">
									<i
										class="fa fa-user-md border border-info rounded-circle p-2 text-info"></i>
									<span class="text-muted fw-bold">Provider: - </span>
								</div>
								<div class="col-12 pb-1 my-1">
									<i
										class="fa fa-user-md border border-info rounded-circle p-2 text-info"></i>
									<span class="text-muted fw-bold">CurrentStatus:
										Cancelled By Admin </span>
								</div>
								<div class="col-12 my-1">
									<a style="font-size: small;" href="view-doc-patient.html"
										type="button" class="btn btn-outline-info ml-1 py-1 w-100">
										(1) Documents </a>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>

			<div class="accordion accordion-flush lo-btn">
				<div class="accordion-item">
					<button style="padding-right: 0;"
						class="accordion-button collapsed bg-info-subtle" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
						aria-expanded="false" aria-controls="flush-collapseOne">

						<div style="font-size: small;" class="row w-100">

							<div class="col-8">
								<i class="fa-regular fa-clock text-info"></i> <span
									class="fw-bold">Created Date:</span> <span> Dec 5, 2023</span>
							</div>

						</div>

					</button>

					<div id="flush-collapseOne"
						class="accordion-collapse collapse bg-info-subtle"
						aria-labelledby="flush-headingOne"
						data-bs-parent="#accordionFlushExample">

						<div style="font-size: small;" class="accordion-body">
							<div class="row">
								<div class="col-12 pb-1 my-1">
									<i
										class="fa fa-user-md border border-info rounded-circle p-2 text-info"></i>
									<span class="text-muted fw-bold">Provider: - </span>
								</div>
								<div class="col-12 pb-1 my-1">
									<i
										class="fa fa-user-md border border-info rounded-circle p-2 text-info"></i>
									<span class="text-muted fw-bold">CurrentStatus:
										Cancelled By Admin </span>
								</div>
								<div class="col-12 my-1">
									<a style="font-size: small;" href="view-doc-patient.html"
										type="button" class="btn btn-outline-info ml-1 py-1 w-100">
										(1) Documents </a>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>

		</div>

	</div>

	<div style="text-align: end; position: absolute;"
		class="container-fluid bg-dark text-white w-100 pl-1 mt-5">
		<span>Terms of Conditions | Privacy Policy</span>
	</div>

	<script src="<c:url value="/resources/js/custom.js" />"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

	<script>
		let metemp = false;
		let elsetemp = false;

		$('#mev').on('click', function() {
			metemp = true;
			elsetemp = false;
		})
		$('#elsev').on('click', function() {
			elsetemp = true;
			metemp = false;
		})
		$('#cont').on('click', function() {
			console.log("here");
			if (metemp == true) {
				let url = "me/"+${userList[0].userID}; 
				document.location.href = url;
			} else if (elsetemp == true) {
				console.log("${userList}")
				let url = "someone/"+${userList[0].userID}; 
				console.log(url);
				document.location.href = url;
				
				
			}
		})
	</script>

</body>

</html>



