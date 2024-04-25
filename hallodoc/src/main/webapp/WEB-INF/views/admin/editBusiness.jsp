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

.hide1 {
	display: none;
}

.hide2 {
	display: none;
}

.hide3 {
	display: none;
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




	<jsp:include page="Navbar.jsp" />
	
	<div class="foot" style="padding-bottom: 180px;">
        <div class="container-fluid bg-light ">
            <div class="row">
                <div class=" col-md-2"></div>
                <div class="col-12 col-md-8 ">
                    <div class="container-fluid bg-light">
                        <div class="d-flex mb-3">
                            <h3 class="mt-3">Update Business</h3>
                            <div class="ms-auto p-3"> <a href="javascript: history.go(-1)" type="button"
                                    class="btn btn-outline-info mx-2 ">
                                    < Back</a>
                            </div>
                        </div>

                    </div>
                    <div class="bg-white p-3">

                        <h4 class="mb-2">Submit Information</h4>


                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="name">
                                    <label for="floatingInput" class="dm">Business Name</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating">
                                    <select class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                        <option selected>Select Profession</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                    <label for="floatingSelect">Profession</label>
                                </div>
                            </div>
                        </div>
                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="name">
                                    <label for="floatingInput" class="dm">Fax Number</label>
                                </div>
                            </div>

                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="tel" class="form-control pt-3 pb-3  iti iti__country-list" id="phone">

                                </div>
                            </div>
                        </div>
                      





                       


                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="email" class="form-control" id="floatingInput" placeholder="name">
                                    <label for="floatingInput" class="dm">Email</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="name">
                                    <label for="floatingInput" class="dm">Business Contact</label>
                                </div>
                            </div>
                        </div>


                       



                       
                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="name">
                                    <label for="floatingInput" class="dm">Street</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="name">
                                    <label for="floatingInput" class="dm">City</label>
                                </div>
                            </div>
                        </div>

                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="name">
                                    <label for="floatingInput" class="dm">State</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="name">
                                    <label for="floatingInput" class="dm">Zip/postal</label>
                                </div>
                            </div>
                        </div>


                        <div class="mt-4 d-flex flex-row-reverse mb-3  ">

                            <button type="submit" class="btn btn-outline-info btn-lg mx-2">Cancel</button>
                            <button type="submit" class="btn btn-info btn-lg">Save</button>


                        </div>










                        <div class="col-md-2"></div>
                    </div>
                    </div>
                    </div>
                    </div>
                    <div class="footer d-flex  align-items-center justify-content-end mt-3 ">
                        <p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions | privacy policy</p>
                      </div>
                      </div>
                    <script
                        src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>
                    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

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


    </body>




</html>