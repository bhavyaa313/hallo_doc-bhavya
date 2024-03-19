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

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style1.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css" />
  <link href="<c:url value="/resources/css/bootstrap.min.css"/> "  rel="stylesheet">
  <link href="<c:url value="/resources/css/style.css"/> "  rel="stylesheet">
<script src="<c:url value="/resources/js/script.js"/>"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>

<style>
    body{
        background-image: linear-gradient(rgba(255,255,255,.9), rgba(255,255,255,.9)), url("<c:url value="/resources/images/bg.jpg" />") ;
            height: 930px; background-position: center; background-size: 100% 100%;   background-repeat: no-repeat; 
        }
     @media only screen and (max-width: 767px) {
            body {
                background-image: linear-gradient(rgba(255,255,255,.9), rgba(255,255,255,.9)), url("<c:url value="/resources/images/imgpsh_fullsize_anim.jfif"/>");
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: 100% 100%;
            background-position: center;
            background-attachment: fixed;
            }

        }

        

        
</style>
</head>

<body>

    <div class="container">
        <div class="row w-100">
            <div class="col-md-4"></div>
            <div class="col-md-4 ">
                <img src="<c:url value="/resources/images/Hallo Doc-Photoroom.png-Photoroom.svg" />" class="img-fluid" alt="">
                <div class="d-flex mb-3">

                    <div class="mr-auto p-3"> <a  href="javascript: history.go(-1)" type="button" class="btn-lg btn   text-info ">
                            < Back</a>
                    </div>
                </div>

                <h2>Reset Your Password</h2>
                <form class="w-100" action="sendEmail" method="post">
                    <div class="form-group form-floating mt-3 uname">
                        <input class="form-control" type="email" name="recipient" id="uname" placeholder="Username">
                        <label class="lab" for="uname">Email</label>
                        <img style="border: 1px solid rgb(68, 59, 59);  border-radius: 5rem;" class="bg-white uicon1"
                                src="<c:url value="/resources/images/person-circle.svg"/>" alt="">
                    </div>

                   

                    <button style="height: 50px; background-color: rgb(81, 188, 230); text-decoration: none;"
                        type="submit" class="btn btn-link w-100 text-white my-3">Reset Your Password</button>

                    <a href="patient_login.html" style="color: rgb(81, 188, 230); font-weight: 500; text-decoration: none;"
                        class="btn btn-link w-100 ">< Back to Login
                    </a>

                </form>
            </div>
            <div class="col-md-4"></div>

            <div class="d-flex justify-content-center align-items-end mt-5 ">
                <footer class="text-muted ">Terms of Conditions | Privacy Policy</footer>
            </div>

            
       
            
        </div>

    </div>


</body>

</html>