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

	<nav class="navbar navbar-expand-lg navbar-toggler">

		<div class="container-fluid flex-column">

			<ul class="navbar-nav w-100 flex-row">

				<button class="btn btn-outline-info d-lg-none d-inline"
					type="button" data-bs-toggle="offcanvas"
					data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
					<img src="images/icons8-menu.svg" alt="">
				</button>

				<li class="nav-item"><img class="hello-logo1 mt-2"
						src="<c:url value="/resources/images/hellodoc-logo.png" />"
						alt=""></li>

				<li class="nav-item navbar-right ml-auto"><span class="wlcm">Welcome
						<span style="font-weight: 500;">${uname }</span>
				</span>

					<button type="button" class="btn btn-outline-info mx-2 lo">Logout</button>

					<button type="button" class="btn btn-outline-info mx-2 lo-btn">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-box-arrow-right"
							viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
								d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                            <path fill-rule="evenodd"
								d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                        </svg>
					</button>

					<button type="button" class="btn btn-outline-info px-0 moon-img"
						onclick="myFunctions()">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-moon" viewBox="0 0 16 16">
                            <path
								d="M6 .278a.77.77 0 0 1 .08.858 7.2 7.2 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277q.792-.001 1.533-.16a.79.79 0 0 1 .81.316.73.73 0 0 1-.031.893A8.35 8.35 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.75.75 0 0 1 6 .278M4.858 1.311A7.27 7.27 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.32 7.32 0 0 0 5.205-2.162q-.506.063-1.029.063c-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286" />
                        </svg>
					</button></li>
			</ul>

			<!-- <hr class="bg-dark"> -->

			<div class="collapse navbar-collapse w-100 d-none d-lg-inline"
				id="navbarSupportedContent">
				<ul class="navbar-nav nav-underline">
					<li class="nav-item mx-2"><a href=""
						class="nav-link active  text-info">Dashboard</a></li>

					<li class="nav-item mx-2"><a href="" class="nav-link">My
							Profile</a></li>




				</ul>
			</div>


			<div class=" offcanvas offcanvas-start d-sm-block d-lg-none bg-white"
				tabindex="-1" id="offcanvasExample"
				aria-labelledby="offcanvasExampleLabel">
				<div class="offcanvas-body">
					<ul class="navbar-nav nav-underline">
						<li class="nav-item mx-2"><a href=""
							class="nav-link active  text-info">Dashboard</a></li>

						<li class="nav-item mx-2"><a href="" class="nav-link">My
								Profile</a></li>



					</ul>
				</div>
			</div>



		</div>

	</nav>
	<div class="foot" style="padding-bottom: 150px;">
		<div class="container ">
			<div class="  d-flex p-4  ">
				<h3 class="mx-2">Documents</h3>
				<div class="ms-auto ">
					<a href="javascript: history.go(-1)" type="button"
						class="btn btn-outline-info mx-2 lo"> < Back</a>
				</div>

			</div>


		</div>

		<div class="container bg-light ">
			<div class=" p-3   ">
				<div class="text-muted p-1 mx-2 fs-4">Patient Name</div>
				<div class="text-info fs-3 p-1 mx-2">
					${firstName } ${lastName } <span class="text-muted fs-4"> (MCD86543092)</span>
				</div>
				<div class="text-muted p-1 mx-2">Check here for any files that
					you or the doctors of your subsequents have attached for you to
					review.</div>]
					
					<form action="${pageContext.request.contextPath}/showDocs/${rId}/${firstName}/${lastName}/uploadFile" method="post" enctype="multipart/form-data">
				<div class="row mx-2  p-1">
					<div class="col">
						<div class="input-group mb-3 drill_cursor mt-3">
							<input type="file" name="file_name" id="input_file"  hidden> <input
								type="text" class="form-control col-form-label-lg " id="txt"
								onclick="open_file" placeholder="Upload " aria-label="Upload"
								aria-describedby="button-addon2">
							

						</div>
						<button class="btn btn-outline-info bg-info " type="submit"
								 id="button-addon2">
								<img src="images/cloud-arrow-up.svg" alt=""> <span
									style="color: white;" class="lo">Upload</span>
							</button>
					</div>
				</div>
				</form>
				<div class="  d-flex p-4  ">
					<h4 class="mx-2">Documents</h4>
					<div class="ms-auto ">
						<a 
							class="btn btn-outline-info mx-2 lo" id="downloadAll"> Download all</a>

						<button type="button" class="btn btn-outline-info mx-2 lo-btn">
							<img src="images/download-svgrepo-com.svg" alt="">
						</button>
					</div>

				</div>

				<table class="table">
					<thead>
						<tr>
							<th scope="col"></th>
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
									<div class="form-check ">
										<input class="form-check-inpu d" type="checkbox" value="" name="checkBox"
											id="flexCheckChecked" checked> <label
											class="form-check-label " for="flexCheckChecked"> </label>
									</div>
									
								</td>
								<td>${f.fileName }</td>
								<td>${f.uploader}</td>
								<td>${f.createDate}</td>
								<td>
									<a href="${ f.filePath} " download="${f.fileName }" class="btn btn-outline-info mx-2 download ">
										<img src="<c:url value="/resources/images/download-svgrepo-com.svg" />" alt="">
									</a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>


			</div>

			<div
				class="footer d-flex  align-items-center justify-content-end mt-3 ">
				<p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions |
					privacy policy</p>
			</div>
		</div>
			
		
				<script>
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
			document.getElementsByClassName('drill_cursor')[0]
					.addEventListener('click', function(event) {
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
>
