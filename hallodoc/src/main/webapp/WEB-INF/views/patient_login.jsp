<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>  
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

<body >

    <div class="container " >
        <div class="row w-100">
        
    
            <div class="col-md-4"></div>
            <div class="col-md-4  col-12" style="">
                <img src="<c:url value="/resources/images/Hallo Doc-Photoroom.png-Photoroom.svg" />" class="img-fluid" alt="">
                <div class="d-flex mb-3">

                    <div class="mr-auto p-3"> <a href="javascript: history.go(-1)" type="button" class="btn-lg btn   text-info ">
                            < Back</a>
                    </div>
                </div>

                <h2>Login To Your Account</h2>
                <form class="w-100" action="handleform" onsubmit=" " method="post" name="myform">
                    <div class="form-group form-floating mt-3 uname">
                        <input class="form-control" type="text" name="UserEmail" id="uname" placeholder="Username">
                        <label class="lab" for="uname">Username</label>
                        <img style="border: 1px solid rgb(68, 59, 59);  border-radius: 5rem;" class="bg-white uicon1"
                            src="<c:url value="/resources/images/person-circle.svg"/>" alt="">
                    </div>

                    <div class="form-group form-floating my-4 uname">
                        <input class="form-control" type="password" name="UserPassword" id="pswd" placeholder="Password">
                        <label for="pswd">Password</label>
                        <img class="bg-white uicon" src="<c:url value="/resources/images/eye.svg"/>" alt=""></img>
                    </div>
                    <h6 class="text-danger text-center">${message }</h6>

                    <button style="height: 50px; background-color: rgb(81, 188, 230); text-decoration: none;"
                        type="submit" class="btn btn-link w-100 text-white my-3">Log In</button>

                    <a href="forgot" style="color: rgb(81, 188, 230); font-weight: 500; text-decoration: none;"
                        class="btn btn-link w-100 ">Forgot Password?
                    </a>

                </form>
                <div class="d-flex ju]stify-content-center align-items-end  ">
                    <footer class="text-muted ">Terms of Conditions | Privacy Policy</footer>
                </div>
                <div hidden>hjytjyujyuhjujygj</div>
                <div></div>
                <div></div>
    
            </div>
            <div class="col-md-4"></div>

            
            
       
            
        </div>

    </div>
    <script>  
        function validateform(){  
        var name=document.myform.name.value;  
        var password=document.myform.password.value;  
          
        if (name==null || name==""){  
          alert("Name can't be blank");  
          return false;  
        }else if(password.length<6){  
          alert("Password must be at least 6 characters long.");  
          return false;  
          }  
        }  
        </script>  
        
        <script>
    const toastTrigger = document.getElementById('liveToastBtn')
const toastLiveExample = document.getElementById('liveToast')

if (toastTrigger) {
  const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
  toastTrigger.addEventListener('click', () => {
    toastBootstrap.show()
  })
}
</script>

</body>

</html>