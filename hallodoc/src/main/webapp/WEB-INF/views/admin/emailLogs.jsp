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
	<div class="foot" style="padding-bottom: 380px;">
		<div class="bg-light">

			<div class="container-fluid bg-light mt-3">
				<div class="  d-flex p-4  ">
					<h3 class="mx-2 mt-3">Email Logs (Gmail)</h3>
					<div class="ms-auto ">
						<a href="javascript: history.go(-1)" type="button"
							class="btn btn-outline-info mx-2 "> Back</a>
					</div>

				</div>


			</div>



			<div class="container-fluid">
				<div class="row g-2">
					<div class="col-md">
						<div class="form-floating mb-3">
							<select class="form-select" id="role"
								aria-label="Floating label select example">
								<option value="empty" selected>All</option>
								<option value="1">Admin</option>
								<option value="2">Provider</option>
								<option value="3">Patient</option>

							</select> <label for="floatingSelect">Search by role</label>
						</div>


					</div>
					<div class="col-md">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" id="name"
								placeholder="name"> <label for="floatingInput"
								class="dm">Receiver Name</label>
						</div>
					</div>
					<div class="col-md">
						<div class="form-floating mb-3">
							<input type="email" class="form-control" id="email"
								placeholder="name"> <label for="floatingInput"
								class="dm">Email </label>
						</div>
					</div>


					<div class="col-md">
						<div class="form-floating mb-3">
							<input type="date" class="form-control" id="createdDate"
								placeholder="name"> <label for="floatingInput"
								class="dm">Created Date </label>
						</div>
					</div>
					<div class="col-md">
						<div class="form-floating mb-3">
							<input type="date" class="form-control" id="sentDate"
								placeholder="name"> <label for="floatingInput"
								class="dm">Sent Date</label>
						</div>
					</div>



					<div class="col-md">
						<div class="  d-flex p-2  ">


							<div class="ms-auto ">

								<button type="button" class="btn btn-outline-info mr-2 clear">Clear
								</button>
								<button type="button" class="btn btn-info search">Search</button>
								<button type="button" id="clear" value="clear" hidden></button>




							</div>

						</div>

					</div>
				</div>
				<div class="container-fluid bg-white ">


					<div class="lo">
						<table class="table">
							<thead>
								<tr>

									<th scope="col">Recipient</th>
									<th scope="col">Action</th>
									<th scope="col">Role Name</th>

									<th scope="col">Email id</th>
									<th scope="col">Created Date</th>
									<th scope="col">Send date</th>
									<th scope="col">Sent</th>
									<th scope="col">Sent Tries</th>
									<th scope="col">Confirmation Number</th>


								</tr>
							</thead>

							<tbody id="tableData">
							</tbody>
							
						</table>
					</div>


					<div class="accordion lo-btn" id="accordionPanelsStayOpenExample">
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button" type="button"
									data-bs-toggle="collapse"
									data-bs-target="#panelsStayOpen-collapseOne"
									aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
									<div class="row w-100">
										<div class="col-12">Testing</div>
										<div class="col-12"></div>
										<div class="col-12">
											Action Name: <b>Rew monthly data</b>
										</div>

										<div class="col-12">
											Email: <b> test@gmail.com </b>
										</div>





									</div>


								</button>
							</h2>
							<div id="panelsStayOpen-collapseOne"
								class="accordion-collapse collapse show">
								<div class="accordion-body">
									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-person"
													viewBox="0 0 16 16">
                                                    <path
														d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z" />
                                                </svg>
											</button></span> Role Name: <b>Physician</b>
									</div>








									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-calendar4"
													viewBox="0 0 16 16">
                                                    <path
														d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                                </svg>
											</button></span> Create Date: <b>jan 1, 2023</b>
									</div>
									<div class="mt-1">
										<span class="mx-2 "><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-calendar4"
													viewBox="0 0 16 16">
                                                    <path
														d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                                </svg>
											</button></span>Sent Date: <b>jan 1, 2023</b>
									</div>



									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-check-lg"
													viewBox="0 0 16 16">
                                                    <path
														d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425z" />
                                                </svg>
											</button></span> Sent: <b>yes</b>
									</div>

									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-envelope"
													viewBox="0 0 16 16">
                                                    <path
														d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z" />
                                                </svg>
											</button></span> Sent Tries: <b>1</b>
									</div>


									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-check-lg"
													viewBox="0 0 16 16">
                                                    <path
														d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425z" />
                                                </svg>
											</button></span> Confirmation Number: <b>-</b>
									</div>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse"
									data-bs-target="#panelsStayOpen-collapseTwo"
									aria-expanded="false"
									aria-controls="panelsStayOpen-collapseTwo">
									<div class="row w-100">
										<div class="col-12">Testing</div>
										<div class="col-12"></div>
										<div class="col-12">
											Action Name: <b>Rew monthly data</b>
										</div>

										<div class="col-12">
											Email: <b> test@gmail.com </b>
										</div>





									</div>

								</button>
							</h2>
							<div id="panelsStayOpen-collapseTwo"
								class="accordion-collapse collapse">
								<div class="accordion-body">
									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-person"
													viewBox="0 0 16 16">
                                                    <path
														d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z" />
                                                </svg>
											</button></span> Role Name: <b>Physician</b>
									</div>








									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-calendar4"
													viewBox="0 0 16 16">
                                                    <path
														d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                                </svg>
											</button></span> Create Date: <b>jan 1, 2023</b>
									</div>
									<div class="mt-1">
										<span class="mx-2 "><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-calendar4"
													viewBox="0 0 16 16">
                                                    <path
														d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                                </svg>
											</button></span>Sent Date: <b>jan 1, 2023</b>
									</div>



									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-check-lg"
													viewBox="0 0 16 16">
                                                    <path
														d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425z" />
                                                </svg>
											</button></span> Sent: <b>yes</b>
									</div>

									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-envelope"
													viewBox="0 0 16 16">
                                                    <path
														d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z" />
                                                </svg>
											</button></span> Sent Tries: <b>1</b>
									</div>


									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-check-lg"
													viewBox="0 0 16 16">
                                                    <path
														d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425z" />
                                                </svg>
											</button></span> Confirmation Number: <b>-</b>
									</div>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse"
									data-bs-target="#panelsStayOpen-collapseThree"
									aria-expanded="false"
									aria-controls="panelsStayOpen-collapseThree">
									<div class="row w-100">
										<div class="col-12">Testing</div>
										<div class="col-12"></div>
										<div class="col-12">
											Action Name: <b>Rew monthly data</b>
										</div>

										<div class="col-12">
											Email: <b> test@gmail.com </b>
										</div>





									</div>
								</button>
							</h2>
							<div id="panelsStayOpen-collapseThree"
								class="accordion-collapse collapse">
								<div class="accordion-body">
									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-person"
													viewBox="0 0 16 16">
                                                    <path
														d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z" />
                                                </svg>
											</button></span> Role Name: <b>Physician</b>
									</div>








									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-calendar4"
													viewBox="0 0 16 16">
                                                    <path
														d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                                </svg>
											</button></span> Create Date: <b>jan 1, 2023</b>
									</div>
									<div class="mt-1">
										<span class="mx-2 "><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-calendar4"
													viewBox="0 0 16 16">
                                                    <path
														d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                                </svg>
											</button></span>Sent Date: <b>jan 1, 2023</b>
									</div>



									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-check-lg"
													viewBox="0 0 16 16">
                                                    <path
														d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425z" />
                                                </svg>
											</button></span> Sent: <b>yes</b>
									</div>

									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-envelope"
													viewBox="0 0 16 16">
                                                    <path
														d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z" />
                                                </svg>
											</button></span> Sent Tries: <b>1</b>
									</div>


									<div>
										<span class="mx-2"><button
												class="btn btn-outline-info rounded-circle btn-sm">
												<svg xmlns="http://www.w3.org/2000/svg" width="16"
													height="16" fill="currentColor" class="bi bi-check-lg"
													viewBox="0 0 16 16">
                                                    <path
														d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425z" />
                                                </svg>
											</button></span> Confirmation Number: <b>-</b>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>
		</div>
		<div class="footer d-flex  align-items-center justify-content-end ">
			<p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions |
				privacy policy</p>
		</div>
	</div>
	<script>
        function myFunctions() {
            var element = document.body;

            element.classList.toggle("dark-mode");

            var navbarElements = document.querySelectorAll('.navbar-nav a.nav-link, .navbar-nav .btn');
            navbarElements.forEach(function (element) {
                element.classList.toggle("text-dark");
            });
        }
    </script>

	<script>

        document.getElementsByClassName('drill_cursor')[0]
            .addEventListener('click', function (event) {
                // do something
                document.getElementById('input_file').click();
                changePlaceholder();

            })
        function changePlaceholder() {
            $('input[type="file"]').change(function (e) {
                const names = e.target.files[0].name;

                $('#txt').attr('placeholder', names);
            });
        } 
    </script>

	<script>
		$(document).ready(function() {
		console.log("searchhhhhhh")
			$('.search').click();
			
		})
	</script>
	<script>
		$(".search").on("click", function() {
			var role
			var name;
			var email;
			var createdDate;
			var sentDate;
			
			if ($("#clear").hasClass("search")) {
				
				role = "";
				name = "";
				email = "";
				createdDate = "";
				sentDate = "";
				
				$("#role").attr("value","");
				$("#name").attr("value","");
				$("#email").attr("value","");
				$("#createdDate").attr("value","");
				$("#sentDate").attr("value","");
				
				$("#clear").removeClass("search"); 
				
			}
			
			else {
				
				role = $("#role").val();
				name = $("#name").val();
				email = $("#email").val();
			createdDate = $("#createdDate").val();
			sentDate = $("#sentDate").val();
				
			}
			
		
			
			$.ajax({
				
				url : "ajaxforEmailLogs",
				type : "post",
				data : {
					role:role,
					name:name,
					email:email,
					createdDate:createdDate,
					sentDate:sentDate
				},
				success : function(data) {
					
					$("#tableData").empty();
					
					for(let i=0; i<data.length; i++) {
						
						var e = data[i];
						
						var row = `<tr>

							<td>`+e.recipientName+`</td>
							<td>`+e.action+`</td>
							<td>`+e.role+`</td>
							<td>`+e.emailId+`</td>
							<td>`+e.createdDate+`</td>
							<td>`+e.sentDate+`</td>
							<td>`+e.sent+`</td>
							<td>`+e.sentTries+`</td>
							<td>`+e.confirmationNumber+`</td>




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