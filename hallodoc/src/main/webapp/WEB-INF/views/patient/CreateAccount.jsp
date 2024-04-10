<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>  
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>

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
               
<div class="container d-flex justify-content-center mb-4"><h2 >Create Account</h2></div>
                
                <form class="w-100" action="createAccount" method="post" name="myform">
                    <div class="form-group form-floating mt-3 uname">
                        <input class="form-control" type="text" name="email" id="uname" placeholder="Username">
                        <label class="lab" for="uname">Username</label>
                        <img style="border: 1px solid rgb(68, 59, 59);  border-radius: 5rem;" class="bg-white uicon1"
                            src="images/person-circle.svg" alt="">
                    </div>

                    <div class="form-group form-floating my-4 uname">
                        <input class="form-control" type="password" name="password"  id="myInput" placeholder="Password" >
                        <label for="pswd">Password</label>
                        <img class="bg-white uicon" src="images/eye.svg" alt=""  id="i1" onclick="pas()  "></img>
                        <img class="bg-white uicon d-none" src="images/eye-slash (1).svg" alt="" id="i2"  ></img>
                        
                       
                    </div>


                    <div class="form-group form-floating my-4 uname">
                        <input class="form-control" type="password" name="ConfirmPassword" id="myInput1" placeholder="Password">
                        <label for="pswd">Password</label>
                        <img class="bg-white uicon" src="images/eye.svg" alt=""  onclick="pas()"></img>
                    </div>
                    
                        
                    <h6>${success }</h6>
                     <h6>${invalid }</h6>

                    <button style="height: 50px; background-color: rgb(81, 188, 230); text-decoration: none;"
                        type="submit" class="btn btn-link w-100 text-white my-3">Create</button>

                </form>
                
            </div>
            <div class="col-md-4"></div>

            <!-- <div class="d-flex align-items-end text-center" style="height: 250px; position: absolute; bottom: 0; width: 100%;">
                <footer class="text-muted text-center"><p class="text-center">Terms of Conditions | Privacy Policy </p></footer>
            </div> -->

<div class="container" style="position: absolute; bottom: 0; width: 100%;">
    <div class="text-muted text-center">
        <p class="">Terms of Conditions | Privacy Policy </p>
    </div>
</div>


        </div>

    </div>


    <script>
        function pas() {
          var x = document.getElementById("myInput");
          var y = document.getElementById("myInput1");
          console.log("djwie")
          if (x.type == "password") {
           x.type = "text";
           document.getElementById("imgClickAndChange").src = "http://www.userinterfaceicons.com/80x80/maximize.png";
    
          } else {
            x.type = "password";
          }
       
        if (y.type == "password") {
           y.type = "text";
          } else {
            y.type = "password";
          }
        }


        // $("i1").click(function(){
        // $(i1).hide();
        // $(i2).show();            });
        </script>

</body>

</html>








    