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
<title>Block records</title>

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
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
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

	<div class="foot" style="padding-bottom: 340px;">
		<div class="bg-light">

			<div class="container-fluid bg-light mt-3">
				<div class="  d-flex p-4  ">
					<h3 class="mx-2 mt-3">Block History</h3>
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
							<input type="text" class="form-control" id="name"
								placeholder="name"> <label for="floatingInput"
								class="dm"> Name</label>
						</div>
					</div>



					<div class="col-md">
						<div class="form-floating mb-3">
							<input type="date" class="form-control" id="date"
								placeholder="name"> <label for="floatingInput"
								class="dm">Date </label>
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
							<input type="number" class="form-control" id="phone"
								placeholder="name"> <label for="floatingInput"
								class="dm">Phone Number</label>
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

									<th scope="col">Patient Name</th>
									<th scope="col">Phone Number</th>
									<th scope="col">Email</th>


									<th scope="col">Created Date</th>
									<th scope="col">Notes</th>
									<th scope="col">is Active</th>
									<th scope="col">Action</th>



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


										<div class="col-12">
											test@gmail.com </b>
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
													height="16" fill="currentColor" class="bi bi-telephone"
													viewBox="0 0 16 16">
                                        <path
														d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.6 17.6 0 0 0 4.168 6.608 17.6 17.6 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.68.68 0 0 0-.58-.122l-2.19.547a1.75 1.75 0 0 1-1.657-.459L5.482 8.062a1.75 1.75 0 0 1-.46-1.657l.548-2.19a.68.68 0 0 0-.122-.58zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z" />
                                      </svg>
											</button></span> Phone: 982894208







										<div>
											<span class="mx-2"><button
													class="btn btn-outline-info rounded-circle btn-sm">
													<svg xmlns="http://www.w3.org/2000/svg" width="16"
														height="16" fill="currentColor" class="bi bi-calendar4"
														viewBox="0 0 16 16">
                                                    <path
															d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                                </svg>
												</button></span> Create Date:jan 1, 2023
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
												</button></span>Notes: 3456789
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
												</button></span> is Active: yes
										</div>

										<div class="ms-auto mt-3">
											<a href="" type="button" class="btn btn-outline-info mx-2 ">
												Block</a>
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


											<div class="col-12">
												test@gmail.com </b>
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
														height="16" fill="currentColor" class="bi bi-telephone"
														viewBox="0 0 16 16">
                                            <path
															d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.6 17.6 0 0 0 4.168 6.608 17.6 17.6 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.68.68 0 0 0-.58-.122l-2.19.547a1.75 1.75 0 0 1-1.657-.459L5.482 8.062a1.75 1.75 0 0 1-.46-1.657l.548-2.19a.68.68 0 0 0-.122-.58zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z" />
                                          </svg>
												</button></span> Phone: 982894208







											<div>
												<span class="mx-2"><button
														class="btn btn-outline-info rounded-circle btn-sm">
														<svg xmlns="http://www.w3.org/2000/svg" width="16"
															height="16" fill="currentColor" class="bi bi-calendar4"
															viewBox="0 0 16 16">
                                                        <path
																d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                                    </svg>
													</button></span> Create Date:jan 1, 2023
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
													</button></span>Notes: 3456789
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
													</button></span> is Active: yes
											</div>

											<div class="ms-auto mt-2">
												<a href="" type="button" class="btn btn-outline-info mx-2 ">
													Block</a>
											</div>





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


											<div class="col-12">test@gmail.com</div>





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
														height="16" fill="currentColor" class="bi bi-telephone"
														viewBox="0 0 16 16">
                                            <path
															d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.6 17.6 0 0 0 4.168 6.608 17.6 17.6 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.68.68 0 0 0-.58-.122l-2.19.547a1.75 1.75 0 0 1-1.657-.459L5.482 8.062a1.75 1.75 0 0 1-.46-1.657l.548-2.19a.68.68 0 0 0-.122-.58zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z" />
                                          </svg>
												</button></span> Phone: 982894208







											<div>
												<span class="mx-2"><button
														class="btn btn-outline-info rounded-circle btn-sm">
														<svg xmlns="http://www.w3.org/2000/svg" width="16"
															height="16" fill="currentColor" class="bi bi-calendar4"
															viewBox="0 0 16 16">
                                                        <path
																d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                                    </svg>
													</button></span> Create Date:jan 1, 2023
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
													</button></span>Notes: 3456789
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
													</button></span> is Active: yes
											</div>

											<div class="ms-auto mt-2 ">
												<a href="" type="button" class="btn btn-outline-info mx-2 ">
													Block</a>
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
                $(document).ready(function() {
                    // Event delegation to handle dynamically added elements
                    $(document).on('change', 'input[type="checkbox"]', function() {
                        var checkboxValue = $(this).val();
                        console.log(checkboxValue)
                        var checkboxId = $(this).attr('id');
                        console.log(checkboxId)

                        if (checkboxValue === "true") {
                            $(this).prop('checked', true);
                            
                            $(this).closest('tr').find('.unblock-button').hide();
                        }
                    });
                    $('input[type="checkbox"]').trigger('change');
                    // Trigger the change event for already existing checkboxes
                });

            </script>


		<script>
		$(document).ready(function() {
		console.log("searchhhhhhh")
			$('.search').click();
		console.log("hello")
			
		})
	</script>
		<script>
		$(".search").on("click", function() {
			console.log("clicekd")
			
			var name;
			var date;
			var email;
			var phone;
		
			
			if ($("#clear").hasClass("search")) {
				
				
				name = "";
				date = "";
				email = "";
				phone = "";
				
			
				$("#name").attr("value","");
				$("#date").attr("value","");
				$("#email").attr("value","");				
				$("#phone").attr("value","");
				
			
				
			}
			
			else {
				
				
				name = $("#name").val();
				date = $("#date").val();
				email = $("#email").val();
				phone = $("#phone").val();
				
			}
			
		
			
			$.ajax({
				
				url : "ajaxforBlock",
				type : "post",
				data : {
					
					name:name,
					date:date,
					email:email,
					phone:phone
				},
				success : function(data) {
					
					$("#tableData").empty();
					
					for(let i=0; i<data.length; i++) {
						
						var b = data[i];
						
						var row = `<tr>

							
							
							 <td>`+b.name+`</td>
                             <td>`+b.phone+`</td>

                             <td>`+b.email+`</td>

                             <td>`+b.date+`</td>


                             <td>`+b.note+`</td>
                             <td>
                                 <div class="form-check">
                                     <input class="form-check-input" type="checkbox" value="`+b.isActive+`" id="block`+b.bId+`">

                                 </div>
                             </td>
                             <td> <a href="${pageContext.request.contextPath}/unblock/`+b.reqId+`/`+b.bId+`" type="button" class="btn btn-outline-info mx-2 unblock" >
                                     Unblock</a>
                                     <span class="unblocked-text"></span></td>




						</tr>`
						
						$("#tableData").append(row);
						var temp = b.isActive;
						
						
						if (temp === true) {
							console.log(temp)
							
							$('input[type="checkbox"]').prop('checked', true);

							$('input[type="checkbox"]').closest('tr').find('.unblock').hide();
						}
						
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
	
<!-- 	<script>
                $(document).ready(function() {
                    // Event delegation to handle dynamically added elements
                    $(document).on('change', 'input[type="checkbox"]', function() {
                        var checkboxValue = $(this).val();
                        console.log(checkboxValue)
                        var checkboxId = $(this).attr('id');
                        console.log(checkboxId)

                        if (checkboxValue === "true") {
                            $(this).prop('checked', true);
                            
                            $(this).closest('tr').find('.unblock-button').hide();
                        }
                    });
                    $('input[type="checkbox"]').trigger('change');
                    // Trigger the change event for already existing checkboxes
                });

            </script> -->
</body>

</html>