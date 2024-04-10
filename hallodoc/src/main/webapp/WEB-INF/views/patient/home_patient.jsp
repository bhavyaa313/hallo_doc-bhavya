<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
 <link href="<c:url value="/resources/css/bootstrap.min.css"/> "  rel="stylesheet">
   <link href="<c:url value="/resources/css/style.css"/> "  rel="stylesheet">
<script src="<c:url value="/resources/js/script.js"/>"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</head>

<body>



    <div class="d-flex flex-column justify-content-center align-items-center">

        <div class="d-inline-flex ">
            <img class="img-fluid mx-auto mb-5 hello-logo mt-5 flex-grow-1" src="<c:url value="/resources/images/Hallo Doc-Photoroom.png-Photoroom.svg" />" alt="">
                <button type="button" class="btn btn-outline-info px-0 moon-img mt-3 mx-5" onclick="myFunctions()">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                    class="bi bi-moon" viewBox="0 0 16 16">
                    <path
                        d="M6 .278a.77.77 0 0 1 .08.858 7.2 7.2 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277q.792-.001 1.533-.16a.79.79 0 0 1 .81.316.73.73 0 0 1-.031.893A8.35 8.35 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.75.75 0 0 1 6 .278M4.858 1.311A7.27 7.27 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.32 7.32 0 0 0 5.205-2.162q-.506.063-1.029.063c-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286" />
                </svg>
            </button>
        </div>


        <div class="d-grid gap-2 col-xl-5 col-md-7 col-sm-10  mx-auto mt-5 ">
            <a   href="select" class="btn btn-info mb-4 p-3 fs-4 btn-lg text-white " type="button">Submit Request</a>
            <a   href="login" class="btn btn-primary p-3 fs-4 mb-5 btn-lg" type="button">Registered Patients</a>
            <p></p>
            <p></p>
                
       
            <footer class="text-muted pt-5 ">Terms of Conditions | Privacy Policy</footer>
        </div>
       
    </div>





    </div>









</body>

</html>