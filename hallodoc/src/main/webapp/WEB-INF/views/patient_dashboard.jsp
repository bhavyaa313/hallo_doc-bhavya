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
    <title>Bootstrap Example</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css" />
   <link href="<c:url value="/resources/css/bootstrap.min.css"/> "  rel="stylesheet">
  <link href="<c:url value="/resources/css/style.css"/> "  rel="stylesheet">
<script src="<c:url value="/resources/js/script.js"/>"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>

      <link href="<c:url value="/resources/css/bootstrap.min.css"/> "  rel="stylesheet">
  <link href="<c:url value="/resources/css/style.css"/> "  rel="stylesheet">
<script src="<c:url value="/resources/js/script.js"/>"></script>
   
  
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

                <button class="btn btn-outline-info d-lg-none d-inline" type="button" data-bs-toggle="offcanvas"
                    data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                    <img src="<c:url value="/resources/images/Hallo Doc-Photoroom.png-Photoroom.svg" />" alt="">
                </button>

                <li class="nav-item">
                    <img class="hello-logo1 m-2" src="images/hellodoc-logo.png" alt="">
                </li>

                <li class="nav-item navbar-right ml-auto">

                    <span class="wlcm lo">Welcome <span style="font-weight: 500;">${uname }</span></span>

                    <button type="button" class="btn btn-outline-info mx-2 lo">Logout</button>

                    <button type="button" class="btn btn-outline-info mx-2 lo-btn ">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                            <path fill-rule="evenodd"
                                d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                        </svg>
                    </button>

                    <button type="button" class="btn btn-outline-info px-0 moon-img" onclick="myFunctions()">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-moon" viewBox="0 0 16 16">
                            <path
                                d="M6 .278a.77.77 0 0 1 .08.858 7.2 7.2 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277q.792-.001 1.533-.16a.79.79 0 0 1 .81.316.73.73 0 0 1-.031.893A8.35 8.35 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.75.75 0 0 1 6 .278M4.858 1.311A7.27 7.27 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.32 7.32 0 0 0 5.205-2.162q-.506.063-1.029.063c-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286" />
                        </svg>
                    </button>
                </li>
            </ul>

            <hr class="bg-dark"> 

            <div class="collapse navbar-collapse w-100 d-none d-lg-inline" id="navbarSupportedContent">
                <ul class="navbar-nav nav-underline">
                    <li class="nav-item mx-2">
                        <a href="patient_dashboard.html" class="nav-link active  text-info">Dashboard</a>
                    </li>

                    <li class="nav-item mx-2">
                        <a href="user_profile.html" class="nav-link ">My Profile</a>
                    </li>




                </ul>
            </div>


            <div class=" offcanvas offcanvas-start d-sm-block d-lg-none bg-white" tabindex="-1" id="offcanvasExample"
                aria-labelledby="offcanvasExampleLabel">
                <div class="offcanvas-body">
                  <span class="wlcm lo-btn">Welcome <span style="font-weight: 500;">${uname }</span></span>
                    <ul class="navbar-nav nav-underline mt-3">
                        <li class="nav-item mx-2">
                            <a href="patient_dashboard.html" class="nav-link active  text-info">Dashboard</a>
                        </li>

                        <li class="nav-item mx-2">
                            <a href="user_profile.html" class="nav-link">My Profile</a>
                        </li>



                    </ul>
                </div>
            </div>



        </div>

    </nav>

    <div class="foot" style="padding-bottom: 200px;">
        <div class="d-flex p-4 ">
            <h3 class="mx-2">Medical History</h3>
        </div>
        <div class="d-flex p-2 justify-content-end mx-3"> <!-- Button trigger modal -->
            <button type="button" class="btn btn-outline-info mx-2 lo" data-bs-toggle="modal"
                data-bs-target="#exampleModal">
                Create New Request
            </button>
            <button type="button" class="btn btn-outline-info mx-1 lo-btn"><b>
                    <h3>+</h3>
                </b>
            </button>

        
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Create New Request</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p class=""> Here, I want to create new request for.. </p>
                            <div class="mx-3 d-flex justify-content-center"> <button href="patient_info.html"
                                    type="button" id="mev" class="btn btn-outline-info mx-2">Me
                                </button>
                                <button type="button" class="btn btn-outline-info mx-2 " id="elsev">Some One
                                    Else </button>
                            </div>
                        </div>
                        <div class="modal-footer">

                            <button type="button" class="btn btn-outline-info mx-2" id="continue">continue</a>
                                <button type="button" class="btn btn-outline-info mx-2 "
                                    data-bs-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        




        <div class="">
       <%--         <c:forEach var="item" items="${requestsList }">
<h1>${item }</h1>
</c:forEach>  --%>
        
            <table class="table">
               <thead class="bg-light">
                  <tr>
                    <th  scope="col">Created Date</th>
                   
                    <th scope="col">Current Status</th>
                    <th scope="col" class="col-md-2"></th>
                   
                   
                  </tr>
                </thead>
                
          
                
                <tbody>
               <c:forEach var="r" items="${requestsList }">
                  
                  <tr>
                     <td>${r.createdDate }</td>
                   
                    <td>${r.firstName }</td>
                    <td>  <a  href="document_view.html" type="button" class="btn btn-outline-info mx-2  " >
                      View Uploads </a></td>
                  
                   
                  </tr>
                  
             </c:forEach> 
                </tbody>
                   
              </table>


        </div> 


        <div class="accordion lo-btn bg-info-subtle" id="accordionPanelsStayOpenExample">
            <div class="accordion-item">
              <h2 class="accordion-header bg-info-subtle">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="false" aria-controls="panelsStayOpen-collapseOne">
                <b>Created Date</b>  :  Aug 1, 2023
                </button>
              </h2>
              <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse" >
                <div class="accordion-body bg-info-subtle">
                  <strong><span class="mx-2"><button class="btn btn-outline-info rounded-circle  btn-sm">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-stopwatch" viewBox="0 0 16 16">
                        <path d="M8.5 5.6a.5.5 0 1 0-1 0v2.9h-3a.5.5 0 0 0 0 1H8a.5.5 0 0 0 .5-.5z"/>
                        <path d="M6.5 1A.5.5 0 0 1 7 .5h2a.5.5 0 0 1 0 1v.57c1.36.196 2.594.78 3.584 1.64l.012-.013.354-.354-.354-.353a.5.5 0 0 1 .707-.708l1.414 1.415a.5.5 0 1 1-.707.707l-.353-.354-.354.354-.013.012A7 7 0 1 1 7 2.071V1.5a.5.5 0 0 1-.5-.5M8 3a6 6 0 1 0 .001 12A6 6 0 0 0 8 3"/>
                      </svg>
                 </button></span>Provider:</strong> <SPAN>ABC</SPAN>
                  <div>
                  <strong><span class="mx-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
                        <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425z"/>
                      </svg>
                 </button></span>Status:</strong> <SPAN>Active</SPAN></div>
                </div>
              </div>
            </div>
            <div class="accordion-item">
              <h2 class="accordion-header bg-info-subtle">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
                  <b>Created Date</b>  :  Aug 1, 2023
                </button>
              </h2>
              <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse" >
                <div class="accordion-body bg-info-subtle">
                  <strong><span class="mx-2"><button class="btn btn-outline-info  btn-sm">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-stopwatch" viewBox="0 0 16 16">
                        <path d="M8.5 5.6a.5.5 0 1 0-1 0v2.9h-3a.5.5 0 0 0 0 1H8a.5.5 0 0 0 .5-.5z"/>
                        <path d="M6.5 1A.5.5 0 0 1 7 .5h2a.5.5 0 0 1 0 1v.57c1.36.196 2.594.78 3.584 1.64l.012-.013.354-.354-.354-.353a.5.5 0 0 1 .707-.708l1.414 1.415a.5.5 0 1 1-.707.707l-.353-.354-.354.354-.013.012A7 7 0 1 1 7 2.071V1.5a.5.5 0 0 1-.5-.5M8 3a6 6 0 1 0 .001 12A6 6 0 0 0 8 3"/>
                      </svg>
                 </button></span>Provider:</strong> <SPAN>ABC</SPAN>
                  <div>
                  <strong><span class="mx-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
                        <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425z"/>
                      </svg>
                 </button></span>Status:</strong> <SPAN>Active</SPAN></div>
                </div>
              </div>
            </div>
            <div class="accordion-item">
              <h2 class="accordion-header bg-info-subtle">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false" aria-controls="panelsStayOpen-collapseThree">
                  <b>Created Date</b>  :  Aug 1, 2023
                </button>
              </h2>
              <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse" >
                <div class="accordion-body bg-info-subtle">
                  <strong><span class="mx-2"><button class="btn btn-outline-info  btn-sm">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-stopwatch" viewBox="0 0 16 16">
                        <path d="M8.5 5.6a.5.5 0 1 0-1 0v2.9h-3a.5.5 0 0 0 0 1H8a.5.5 0 0 0 .5-.5z"/>
                        <path d="M6.5 1A.5.5 0 0 1 7 .5h2a.5.5 0 0 1 0 1v.57c1.36.196 2.594.78 3.584 1.64l.012-.013.354-.354-.354-.353a.5.5 0 0 1 .707-.708l1.414 1.415a.5.5 0 1 1-.707.707l-.353-.354-.354.354-.013.012A7 7 0 1 1 7 2.071V1.5a.5.5 0 0 1-.5-.5M8 3a6 6 0 1 0 .001 12A6 6 0 0 0 8 3"/>
                      </svg>
                 </button></span>Provider:</strong> <SPAN>ABC</SPAN>
                    <div>
                    <strong><span class="mx-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
                            <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425z"/>
                          </svg>
                     </button></span>Status:</strong> <SPAN>Active</SPAN></div>
                </div>
              </div>
            </div>
          </div>


          

    </div>

    <!-- <div class="footer d-flex  align-items-center justify-content-end mt-3 ">
        <p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions | privacy policy</p>
      </div> -->
    <script src="accordian.js"></script>
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
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
      <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
      
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
   
    <script>





        let metemp = false;
        let elsetemp = false;

        $('#mev').on('click', function () {
            // $('#me').click();
            metemp = true;
            elsetemp = false;
            console.log(metemp);
        })
        $('#elsev').on('click', function () {
            // $('#else').click();
            elsetemp = true;
            metemp = false;
            console.log(elsetemp);
        })
        $('#continue').on('click', function () {
            if (metemp == true) {
                document.location.href = 'submit_info_patient.html'
                console.log("me")
            }
            else if (elsetemp == true) {
                document.location.href = 'submit_info_else.html'
                console.log("else")
            }
        })



    </script>
 

    

</body>

</html> 



