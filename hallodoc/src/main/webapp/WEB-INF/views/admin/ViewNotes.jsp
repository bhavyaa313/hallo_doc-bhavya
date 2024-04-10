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
<title>new_req</title>


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
    </style>
</head>

<body>
   <jsp:include page="Navbar.jsp" />

<div class="foot" style="padding-bottom: 190px;">
    <div class="container-fluid mt-5  ">
        <div class="row">
            <div class=" col-md-3"></div>
            <div class="col-12 col-md-6 ">
                <div class="container-fluid bg-light">
                    <div class="d-flex mb-3">
                        <h3 class="mt-3">Notes </h3>
                        <div class="ms-auto p-3"> <a href="javascript: history.go(-1)" type="button"
                                class="btn btn-outline-info mx-2 ">
                                < Back</a>
                        </div>
                    </div>
                    <div class="row d-flex justify-content-evenly mb-3">
                        <div class="card mt-3 " style="width: 27rem;">
                            <div class="row">

                                <div class="col-md-1 mt-3 col-2">
                                    <h3> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-arrow-left-right" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
                                                d="M1 11.5a.5.5 0 0 0 .5.5h11.793l-3.147 3.146a.5.5 0 0 0 .708.708l4-4a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 11H1.5a.5.5 0 0 0-.5.5m14-7a.5.5 0 0 1-.5.5H2.707l3.147 3.146a.5.5 0 1 1-.708.708l-4-4a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 4H14.5a.5.5 0 0 1 .5.5" />
                                        </svg></h3>
                                </div>
                                <div class="col-md-11 col-10">
                                    <div class="card-body">
                                        <h5 class="card-title">Transfer Notes</h5>

                                        <p class="card-text">Lorem ipsum dolor sit amet consectetur </p>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="card mt-3" style="width: 27rem;">
                            <div class="row">

                                <div class="col-md-1 mt-3 col-2">
                                    <h3><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                                            <path
                                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z" />
                                        </svg></h3>
                                </div>
                                <div class="col-md-11 col-10">
                                    <div class="card-body">
                                        <h5 class="card-title">Physician Notes</h5>

                                        <p class="card-text">Lorem ipsum dolor sit amet.</p>
                                    </div>
                                </div>
                            </div>

                        </div>


                    </div>

                    <div class="row d-flex justify-content-evenly mb-3">
                        <div class="card  " style="width: 27rem;">
                            <div class="row">

                                <div class="col-md-1 mt-3 col-2">
                                    <h3> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-arrow-left-right" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
                                                d="M1 11.5a.5.5 0 0 0 .5.5h11.793l-3.147 3.146a.5.5 0 0 0 .708.708l4-4a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 11H1.5a.5.5 0 0 0-.5.5m14-7a.5.5 0 0 1-.5.5H2.707l3.147 3.146a.5.5 0 1 1-.708.708l-4-4a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 4H14.5a.5.5 0 0 1 .5.5" />
                                        </svg></h3>
                                </div>
                                <div class="col-md-11 col-10">
                                    <div class="card-body">
                                        <h5 class="card-title">Transfer Notes</h5>

                                        <p class="card-text">Lorem ipsum dolor sit amet consectetur </p>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class=" bg-light " style="width: 27rem;">
                            <div class="row">

                                <div class="col-md-1 ">

                                </div>
                                <div class="col-md-11">
                                    <div class="card-body">
                                        <h5 class="card-title text-light"></h5>

                                        <p class="card-text text-light"></p>
                                    </div>
                                </div>
                            </div>

                        </div>


                    </div>



                    <div class="form-floating mb-3">
                        <textarea class="form-control " placeholder="Leave a comment here" id="floatingTextarea2"
                            style="height: 200px"></textarea>
                        <label for="floatingTextarea2" class="dm"> Enter</label>
                    </div>
                </div>

                <div class="col-md-3">

                </div>
            </div>
        </div>
        </div>

        <div class="footer d-flex  align-items-center justify-content-end mt-3 ">
            <p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions | privacy policy</p>
        </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>
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