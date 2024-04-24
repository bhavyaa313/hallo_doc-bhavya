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

.hidee {
	display: none;
}
</style>
</head>
<body class="bg-light">




	<jsp:include page="Navbar.jsp" />
	<div class="foot" style="padding-bottom: 50px;">
		<div class="container bg-white">
			<div class="  d-flex p-4  ">
				<h3 class="mx-2">Close Case</h3>
				<div class="ms-auto ">
					<a href="javascript: history.go(-1)" type="button"
						class="btn btn-outline-info mx-2 "> < Back</a>
				</div>

			</div>




			<div class="container bg-light">

				<div class="  d-flex p-1 bg-light  ">
					<div class="text-muted p-2  mx-3 fs-4">Patient Name</div>

					<div class="ms-auto p-2">










						<button type="button" class="btn btn-outline-info mx-2 lo-btn">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
                <path
									d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76z" />
              </svg>
						</button>
					</div>


				</div>
				<div class="text-info fs-3  mx-4 mt-0 bg-light">${requestClients[0].firstName}
					${requestClients[0].lastName} <span class="text-muted fs-4">
						${confirmString }</span>
				</div>
				<h4 class="mx-3 p-4">Documents</h4>
				<div class="lo">
					<table class="table">
						<thead>
							<tr>

								<th scope="col">File Name</th>
								<th scope="col">Uploader</th>
								<th scope="col">Upload Date</th>
								<th scope="col">Action</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestWiseFiles}" var="f">

								<tr>
									<td></td>
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
									</a></td>
								</tr>
							</c:forEach>
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
								Encounter</button>
						</h2>
						<div id="panelsStayOpen-collapseOne"
							class="accordion-collapse collapse show">
							<div class="accordion-body">
								2 aug, 2023
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
								</div>
							</div>
						</div>
					</div>

				</div>











				<form action="update/${requestId }" method="post">
					<div class="p-3 mx-3 ">
						<h4>Patient Information</h4>
					</div>
					<div class="row g-2 p-1 bg-light">
						<div class="col-md">
							<div class="form-floating mb-3">
								<input type="text" class="form-control enable"
									id="floatingInput" placeholder="name"
									value="${requestClients[0].firstName}" name="firstName"
									disabled> <label for="floatingInput" class="dm">First
									Name</label>
							</div>
						</div>
						<div class="col-md">
							<div class="form-floating mb-3">
								<input type="text" class="form-control enable"
									id="floatingInput" placeholder="name"
									value="${requestClients[0].lastName}" name="lastName" disabled>
								<label for="floatingInput" class="dm">Last Name</label>
							</div>
						</div>
					</div>
					<div class="row g-2 p-1 bg-light">
						<div class="col-md">
							<div class="form-floating mb-3">
								<!-- <input type="date" class="form-control" id="floatingInput"
                            mailto:placeholder="name@example.com">
                        <label for="floatingInput">Date of Birth</label> -->
								<input type="text" id="uname" class="form-control enable"
									placeholder="Date Of Birth" onfocus="(this.type='date')"
									value="${fullDate}" name="dob" disabled></input> <label
									for="floatingInput" class="dm">Date of Birth</label>
							</div>


						</div>

						<div class="col-md-5 col-9">
							<div class="form-floating mb-3">
								<input type="tel" class="form-control enable " id="phone"
									placeholder="phone" value="${requestClients[0].phoneNumber}"
									name="phone" disabled> <label for="floatingInput"
									class="dm">Phone Number</label>
							</div>
						</div>
						<div class="col-md-1 col-3">
							<div class="  highlight">
								<a href="" type="button"
									class="btn btn-outline-info btn-lg   highlight"> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-telephone-fill"
										viewBox="0 0 16 16">
                  <path fill-rule="evenodd"
											d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z" />
                </svg>
								</a>
							</div>
						</div>



					</div>
					<!-- <input type="tel" class="form-control pt-3 pb-3  " id="phone"> -->

					<div class="row g-2 bg-light">
						<div class="col-md ">
							<div class="form-floating mb-3">
								<input type="email" class="form-control enable"
									id="floatingInput" placeholder="email"
									value="${requestClients[0].email}" disabled> <label
									for="floatingInput" class="dm">Email</label>
							</div>
						</div>

					</div>














					<div class="mt-4 d-flex flex-row-reverse mb-5 ">


						<!-- <button type="submit" class="btn btn-info btn-lg mx-3 random  "
						onclick="show()">Edit</button> -->
						<button type="button"
							class="btn btn-outline-info btn-lg mx-3 random xx ">Close
							Case</button>
						<!-- <button type="submit" class="btn btn-danger btn-lg mx-2 hide "
						onclick="show2()" >Cancel</button>
					<button type="submit" class="btn btn-success btn-lg mx-2 hide "
						onclick="show2()" >Save</button> -->
						<button type="button" class="btn btn-info btn-lg mx-3 random xx  "
							onclick="show()">Edit</button>
						<button type="button"
							class="btn btn-danger btn-lg mx-2 hide see come"
							onclick="show2()" hidden>Cancel</button>
						<button type="submit"
							class="btn btn-success btn-lg mx-2 hide see come "
							onclick="show2()" hidden>Save</button>


					</div>

				</form>



			</div>


		</div>


		<div
			class="footer d-flex  align-items-center justify-content-end mt-3 ">
			<p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions |
				privacy policy</p>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
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


	</script>
	<script>
		/* 	function show() {
				console.log("clicked")
				$('.hide').removeClass("hide");
				$('.random').addClass("hide");
				$('.enable').removeAttr("disabled");

			}

			function show2() {
				$('.hide').removeClass("hide");
				$('.see').addClass("hide");
				$('.enable').attr("disabled", "disabled");

			} */

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

</body>

</html>