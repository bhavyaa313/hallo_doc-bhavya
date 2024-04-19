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




	<div class="foot " style="padding-bottom: 200px;">
		<div class="container ">
			<div class="  d-flex p-4  ">
				<h3 class="mx-2">Documents</h3>
				<div class="ms-auto ">
					<a href="javascript: history.go(-1)" type="button"
						class="btn btn-outline-info mx-2 "> < Back</a>
				</div>

			</div>


		</div>

		<div class="container bg-light ">
			<div class=" p-3   ">
				<div class="text-muted p-1 mx-2 fs-4">Patient Name</div>
				<div class="text-info fs-3 p-1 mx-2">${requestClients[0].firstName}
					${requestClients[0].lastName} <span class="text-muted fs-4">${confirmString}</span>
				</div>
				<div class="text-muted p-1 mx-2">Check here for any files that
					you or the Client/Member have attached to the request.</div>

				<form
					action="${pageContext.request.contextPath}/viewDocs/${requestId}/${userList[0].userID}/uploadFile"
					method="post" enctype="multipart/form-data">
					<div class="row   p-1">
						<div class="col-md-10 col-10">
							<div class="input-group mb-3 drill_cursor mt-3">
								<input type="file" name="file_name" id="input_file" hidden>
								<input type="text" class="form-control col-form-label-lg "
									id="txt" onclick="open_file" placeholder="Upload "
									aria-label="Upload" aria-describedby="button-addon2">


							</div>
						</div>
						<div class="col-md-2 col-2 mt-3">

							<button class="btn btn-outline-info bg-info btn-lg " type="submit"
								id="button-addon2">
								<img src="images/cloud-arrow-up.svg" alt=""> <span
									style="color: white;" class="lo">Upload</span>
							</button>
						</div>
					</div>
			
			</form>
			<div class="  d-flex p-2  ">
				<h4 class="mx-2">Documents</h4>
				<div class="ms-auto lo ">

					<button href="" type="button" class="btn btn-outline-info mx-2 lo"
						id="downloadAll">Download all</button>

					<button type="button" class="btn btn-outline-info mx-2 lo-btn">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-cloud-download"
							viewBox="0 0 16 16">
                            <path
								d="M4.406 1.342A5.53 5.53 0 0 1 8 0c2.69 0 4.923 2 5.166 4.579C14.758 4.804 16 6.137 16 7.773 16 9.569 14.502 11 12.687 11H10a.5.5 0 0 1 0-1h2.688C13.979 10 15 8.988 15 7.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 2.825 10.328 1 8 1a4.53 4.53 0 0 0-2.941 1.1c-.757.652-1.153 1.438-1.153 2.055v.448l-.445.049C2.064 4.805 1 5.952 1 7.318 1 8.785 2.23 10 3.781 10H6a.5.5 0 0 1 0 1H3.781C1.708 11 0 9.366 0 7.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383" />
                            <path
								d="M7.646 15.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 14.293V5.5a.5.5 0 0 0-1 0v8.793l-2.146-2.147a.5.5 0 0 0-.708.708z" />
                        </svg>
					</button>


					<button type="button" class="btn btn-outline-info mx-2 lo">
						Delete all</button>

					<button type="button" class="btn btn-outline-info mx-2 lo-btn">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
                            <path
								d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5zm13-3H1v2h14zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5" />
                        </svg>
					</button>

					<button type="button" class="btn btn-outline-info mx-2 lo">
						Send Mail</button>

					<button type="button" class="btn btn-outline-info mx-2 lo-btn">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
                            <path
								d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76z" />
                        </svg>
					</button>
				</div>





			</div>
			<div class="mb-3 lo-btn ">

				<button type="button" class="btn btn-outline-info mx-2 lo">
					Download all</button>

				<button type="button" class="btn btn-outline-info mx-2 lo-btn">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-cloud-download"
						viewBox="0 0 16 16">
                        <path
							d="M4.406 1.342A5.53 5.53 0 0 1 8 0c2.69 0 4.923 2 5.166 4.579C14.758 4.804 16 6.137 16 7.773 16 9.569 14.502 11 12.687 11H10a.5.5 0 0 1 0-1h2.688C13.979 10 15 8.988 15 7.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 2.825 10.328 1 8 1a4.53 4.53 0 0 0-2.941 1.1c-.757.652-1.153 1.438-1.153 2.055v.448l-.445.049C2.064 4.805 1 5.952 1 7.318 1 8.785 2.23 10 3.781 10H6a.5.5 0 0 1 0 1H3.781C1.708 11 0 9.366 0 7.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383" />
                        <path
							d="M7.646 15.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 14.293V5.5a.5.5 0 0 0-1 0v8.793l-2.146-2.147a.5.5 0 0 0-.708.708z" />
                    </svg>
				</button>


				<button type="button" class="btn btn-outline-info mx-2 lo">
					Delete all</button>

				<button type="button" class="btn btn-outline-info mx-2 lo-btn">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
                        <path
							d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5zm13-3H1v2h14zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5" />
                    </svg>
				</button>

				<button type="button" class="btn btn-outline-info mx-2 lo">
					Send Mail</button>

				<button type="button" class="btn btn-outline-info mx-2 lo-btn">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
                        <path
							d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76z" />
                    </svg>
				</button>
			</div>






			<div class="lo">

				<table class="table">
					<thead>
						<tr>
							<th scope="col"><div class="form-check ">
									<input class="form-check-input selectall" type="checkbox"
										value="" id="flexCheckChecked" checked> <label
										class="form-check-label" for="flexCheckChecked"> </label>
								</div></th>
							<th scope="col">File Name</th>
							<th scope="col">Uploader</th>
							<th scope="col">Upload Date</th>
							<th scope="col">Action</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestWiseFiles}" var="f">

							<tr>
								<td>
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value=""
											id="flexCheckChecked" name="checkBox" checked> <label
											class="form-check-label"
											 for="flexCheckChecked"> </label>
									</div>
								</td>
								<td>${f.fileName }</td>
								<td>${f.uploader}</td>
								<td>${f.createDate}</td>
								<td><a href="${ f.filePath} " download="${f.fileName }"
									class="btn btn-outline-info mx-2 download "> <svg
											xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-cloud-download"
											viewBox="0 0 16 16">
                                        <path
												d="M4.406 1.342A5.53 5.53 0 0 1 8 0c2.69 0 4.923 2 5.166 4.579C14.758 4.804 16 6.137 16 7.773 16 9.569 14.502 11 12.687 11H10a.5.5 0 0 1 0-1h2.688C13.979 10 15 8.988 15 7.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 2.825 10.328 1 8 1a4.53 4.53 0 0 0-2.941 1.1c-.757.652-1.153 1.438-1.153 2.055v.448l-.445.049C2.064 4.805 1 5.952 1 7.318 1 8.785 2.23 10 3.781 10H6a.5.5 0 0 1 0 1H3.781C1.708 11 0 9.366 0 7.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383" />
                                        <path
												d="M7.646 15.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 14.293V5.5a.5.5 0 0 0-1 0v8.793l-2.146-2.147a.5.5 0 0 0-.708.708z" />
                                    </svg>
								</a> <a type="button" href="" class="btn btn-outline-info mx-2 ">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
                                        <path
												d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5zm13-3H1v2h14zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5" />
                                    </svg>

								</a>
									<button type="button" class="btn btn-outline-info mx-2 ">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
                                        <path
												d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76z" />
                                    </svg>
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>


			<div class="accordion lo-btn mt-3"
				id="accordionPanelsStayOpenExample">
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true"
							aria-controls="panelsStayOpen-collapseOne">Test</button>
					</h2>
					<div id="panelsStayOpen-collapseOne"
						class="accordion-collapse collapse show">
						<div class="accordion-body">
							<div>2 aug, 2023</div>
							<div class="mt-3">
								<button type="button" class="btn btn-outline-info mx-2 ">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-cloud-download"
										viewBox="0 0 16 16">
                                        <path
											d="M4.406 1.342A5.53 5.53 0 0 1 8 0c2.69 0 4.923 2 5.166 4.579C14.758 4.804 16 6.137 16 7.773 16 9.569 14.502 11 12.687 11H10a.5.5 0 0 1 0-1h2.688C13.979 10 15 8.988 15 7.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 2.825 10.328 1 8 1a4.53 4.53 0 0 0-2.941 1.1c-.757.652-1.153 1.438-1.153 2.055v.448l-.445.049C2.064 4.805 1 5.952 1 7.318 1 8.785 2.23 10 3.781 10H6a.5.5 0 0 1 0 1H3.781C1.708 11 0 9.366 0 7.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383" />
                                        <path
											d="M7.646 15.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 14.293V5.5a.5.5 0 0 0-1 0v8.793l-2.146-2.147a.5.5 0 0 0-.708.708z" />
                                    </svg>


								</button>
								<button type="button" class="btn btn-outline-info mx-2 ">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
                                        <path
											d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5zm13-3H1v2h14zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5" />
                                    </svg>

								</button>
								<button type="button" class="btn btn-outline-info mx-2 ">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
                                        <path
											d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76z" />
                                    </svg>
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="accordion-item mt-5">
					<h2 class="accordion-header">
						<button class="accordion-button collapsed" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#panelsStayOpen-collapseTwo"
							aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
							Test</button>
					</h2>
					<div id="panelsStayOpen-collapseTwo"
						class="accordion-collapse collapse">
						<div class="accordion-body">
							<div>2 aug, 2023</div>
							<div class="mt-3">
								<button type="button" class="btn btn-outline-info mx-2 ">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-cloud-download"
										viewBox="0 0 16 16">
                                        <path
											d="M4.406 1.342A5.53 5.53 0 0 1 8 0c2.69 0 4.923 2 5.166 4.579C14.758 4.804 16 6.137 16 7.773 16 9.569 14.502 11 12.687 11H10a.5.5 0 0 1 0-1h2.688C13.979 10 15 8.988 15 7.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 2.825 10.328 1 8 1a4.53 4.53 0 0 0-2.941 1.1c-.757.652-1.153 1.438-1.153 2.055v.448l-.445.049C2.064 4.805 1 5.952 1 7.318 1 8.785 2.23 10 3.781 10H6a.5.5 0 0 1 0 1H3.781C1.708 11 0 9.366 0 7.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723 1.464-2.383" />
                                        <path
											d="M7.646 15.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 14.293V5.5a.5.5 0 0 0-1 0v8.793l-2.146-2.147a.5.5 0 0 0-.708.708z" />
                                    </svg>


								</button>
								<button type="button" class="btn btn-outline-info mx-2 ">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
                                        <path
											d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5zm13-3H1v2h14zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5" />
                                    </svg>

								</button>
								<button type="button" class="btn btn-outline-info mx-2 ">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
                                        <path
											d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76z" />
                                    </svg>
								</button>
							</div>
						</div>
					</div>
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
	<script>
		function myFunctions() {
			var element = document.body;

			element.classList.toggle("dark-mode");

			var navbarElements = document
					.querySelectorAll('.navbar-nav a.nav-link, .navbar-nav .btn');
			navbarElements.forEach(function(element) {
				element.classList.toggle("text-dark");
			});
		}
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
	</script>
	<script>
		$('.selectall').click(function() {
			if ($(this).is(':checked')) {
				$('input:checkbox').prop('checked', true);
			} else {
				$('input:checkbox').prop('checked', false);
			}
		});

		$("input[type='checkbox'].justone").change(function() {
			var a = $("input[type='checkbox'].justone");
			if (a.length == a.filter(":checked").length) {
				$('.selectall').prop('checked', true);
			} else {
				$('.selectall').prop('checked', false);
			}
		});
	</script>
	<script>
		console.log("downlaod all")
		$(document).ready(function() {
			$("#downloadAll").click(function() {

				console.log("working.....");
				var checked = [];

				$("input[name='checkBox']:checked").each(function() {
					checked.push($(this).val());
				});

				var btnlist = $(".download");

				for (var i = 0; i < checked.length; i++) {
					btnlist[i].click();
				}

			});

		});
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

	</script>




</body>


</html>