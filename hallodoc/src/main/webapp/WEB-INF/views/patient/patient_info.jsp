<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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


</head>

<body>
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

<body class="bg-light">
	<div class="foot">
		<div class="container-fluid  kok bg-light">

			<div class="d-flex justify-content-between bg-light">
				<div class="">
					<img class="hello-logo1 mt-2"
						src="<c:url value="/resources/images/Hallo Doc-Photoroom.png-Photoroom.svg" />"
						alt="">
				</div>

				<div>
					<button type="button"
						class="btn btn-outline-info px-0 moon-img mt-2"
						onclick="myFunctions()">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-moon" viewBox="0 0 16 16">
                            <path
								d="M6 .278a.77.77 0 0 1 .08.858 7.2 7.2 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277q.792-.001 1.533-.16a.79.79 0 0 1 .81.316.73.73 0 0 1-.031.893A8.35 8.35 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.75.75 0 0 1 6 .278M4.858 1.311A7.27 7.27 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.32 7.32 0 0 0 5.205-2.162q-.506.063-1.029.063c-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286" />
                        </svg>
					</button>
				</div>
			</div>
		</div>

		<div class="container-fluid ">
			<div class="row">
				<div class=" col-md-3"></div>
				<div class="col-12 col-md-6 bg-white ">
					<div class="d-flex mb-3">

						<div class="ms-auto p-3">
							<a href="javascript: history.go(-1)" type="button"
								class="btn btn-outline-info mx-2 lo"> < Back</a>
						</div>
					</div>
					<form action="insert" method="post" enctype="multipart/form-data">
						<h4>Patient Information</h4>
						<div class="form-floating mb-3">
							<textarea class="form-control "
								placeholder="Leave a comment here" id="floatingTextarea2"
								name="sympton" style="height: 100px"></textarea>
							<label for="floatingTextarea2" class="dm"> Enter brief
								details of symptons (optional)</label>
						</div>
						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										name="firstName" placeholder="name"> <label
										for="floatingInput" class="dm">First Name</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										name="lastName" placeholder="name"> <label
										for="floatingInput" class="dm">Last Name</label>
								</div>
							</div>
						</div>
						<div class="row g-2">
							<div class="col-md-6">
								<div class="form-floating mb-3">

									<input type="date" id="" class="form-control"
										placeholder="Date Of Birth" onfocus="(this.type='date')"
										name="DOB"></input> <label for="floatingInput" class="dm">Date
										of Birth</label>
								</div>
							</div>
						</div>
						<!-- <input type="tel" class="form-control pt-3 pb-3  " id="phone"> -->
						<h4>Patient Contact Information</h4>
						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="email" class="form-control" id="emailCheck"
										name="email" placeholder=""> <label
										for="floatingInput" class="dm">Email</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="tel"
										class="form-control pt-3 pb-3  iti iti__country-list"
										name="mobile" id="phone">

								</div>
							</div>

						</div>
						<div class="row g-2 d-none" id="temp">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="password" class="form-control pc" id="p"
										placeholder="" name="password"> <label
										for="floatingInput" class="dm">Password</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="password" class="form-control pc" id="confirmp"
										placeholder=""> <label for="floatingInput" class="dm">Confirm
										Password</label>
								</div>
							</div>
						</div>
						<h4>Patient Location</h4>
						<div class="row g-2">
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										name="street" placeholder="rttttttth"> <label
										for="floatingInput" class="dm">Street</label>
								</div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										name="city" placeholder="trr"> <label
										for="floatingInput" class="dm">City</label>
								</div>
							</div>
						</div>
						<div class="row g-2">
							<div class="col-md">
								 <div class="form-floating mb-3">
                                    <select class="form-select" aria-label="Default select example" placeholder="tre" name="state">
                                        <!-- <option selected>State</option> -->
                                        <option >GUJARAT</option>
                                        <option >MAHARASHTRA</option>
                                        <option >MADHYAPRADESH</option>
                                        <option >RAJASTHAN</option>

                                    </select>
                                    <label for="floatingInput" class="dm">State</label>
                                </div>
							</div>
							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										name="zipcode" placeholder="tre"> <label
										for="floatingInput" class="dm">Zip Code</label>
								</div>
							</div>
						</div>

						<div class="row g-2">
							<div class="col-md-6">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										name="room" placeholder="trrrrrrrrrr"> <label
										for="floatingInput" class="dm">Room #/ Suite
										(Optional)</label>
								</div>
							</div>
						</div>
						<h4>(Optional) Upload Photo or Document</h4>



						<div class="row">
							<div class="col">
								<div class="input-group mb-3 drill_cursor mt-3">
									<input type="file" name="file_name" id="input_file" hidden>
									<input type="text" class="form-control col-form-label-lg "
										id="txt" onclick="open_file" placeholder="Upload "
										aria-label="Upload" aria-describedby="button-addon2">
									<button class="btn btn-outline-info bg-info" type="button"
										onclick="open_file()" id="button-addon2">
										<img src="images/cloud-arrow-up.svg" alt=""> <span
											style="color: white;">Upload</span>
									</button>
								</div>
							</div>
						</div>


						<div class="mt-4 d-flex flex-row-reverse mb-5 ">

							<button type="submit" class="btn btn-outline-info btn-lg">cancel</button>
							<button type="submit" class="btn btn-info mx-2 btn-lg">Submit</button>
							<!-- <button type="button" class="btn btn-primary btn-lg" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                           Submit
                          </button>
                          <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                            <div class="modal-dialog">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                  ...
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                  <button type="button" class="btn btn-primary">Understood</button>
                                </div>
                              </div>
                            </div>
                          </div>
                        -->
						</div>
					</form>








				</div>








				<div class="col-md-3"></div>
			</div>

			<div
				class="footer d-flex  align-items-center justify-content-end mt-3 ">
				<p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions |
					privacy policy</p>
			</div>
		</div>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>






		<script>
            $(document).ready(function () {
                $('#yourModalId').modal('show');
            });
        </script>
		<script>
            const phoneInputField = document.querySelector("#phone");
            const phoneInput = window.intlTelInput(phoneInputField, {
                utilsScript:
                    "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js",
            });
        </script>
		<script>
                const phoneInputField1 = document.querySelector("#phone1");
                const phoneInput1 = window.intlTelInput(phoneInputField1, {
                    utilsScript:
                        "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js",
                });
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

const myModal = document.getElementById('myModal')
const myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', () => {
  myInput.focus()
})
            </script>


		<script>
	console.log("Hello");

		
		   $("#emailCheck").blur(function(){

		      var uname = $("#emailCheck").val().trim();

		      if(uname != ''){

		         

		         $.ajax({
		            url: 'ajax',
		            type: 'post',
		             dataType: 'text',
		            data: { name : uname} ,
		            success: function(data){
						console.log(data);
		                if(data == "unsuccess"){
		                	$("#temp").removeClass("d-none");
		                	
		                }
		                else{
		                	$("#temp").addClass("d-none");
		                }
		                
		                
		             }
		          });
		      }else{
		       
		      }

		    })
		    

		


</script>

		<script>

			console.log("dcds")
		    $(".pc").blur(function(){
		 
		 console.log("Gfvdfgg");
		  var p1 = $("#p").val().trim();
		  var p2 = $("#confirmp").val().trim();



		if(p1!=p2 && p2!='')
		{
		alert("password is not matching");
		}
		})
		
</script>
</body>

</html>