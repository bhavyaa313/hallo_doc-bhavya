<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

        img.highlight:hover {
            color: #fbfbfb !important;

        }

        #txt {
            color: transparent;

            &:focus {
                outline: none;
            }
        }
    </style>
    <style>
        img.highlight:hover {
            color: #fbfbfb !important;

        }
    </style>
    </head>

    <body class="bg-light">

        <nav class="navbar navbar-expand-lg navbar-toggler">

            <div class="container-fluid flex-column">
    
                <ul class="navbar-nav w-100 flex-row">
    
                    <button class="btn btn-outline-info d-lg-none d-inline" type="button" data-bs-toggle="offcanvas"
                        data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                        <img src="images/icons8-menu.svg" alt="">
                    </button>
    
                    <li class="nav-item">
                        <img class="hello-logo1 m-2" src="images/hellodoc-logo.png" alt="">
                    </li>
    
                    <li class="nav-item navbar-right ml-auto">
    
                        <span class="wlcm">Welcome <span style="font-weight: 500;">Admin admin2</span></span>
    
                        <a type="button" href="logout" class="btn btn-outline-info mx-2 lo">Logout</a>
    
                        <button type="button" class="btn btn-outline-info mx-2 lo-btn">
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
    
                <!-- <hr class="bg-dark"> -->
    
                <div class="collapse navbar-collapse w-100 d-none d-lg-inline" id="navbarSupportedContent">
                    <ul class="navbar-nav nav-underline text-info">
                        <li class="nav-item mx-2">
                            <a href="handleform" class="nav-link ">Dashboard</a>
                        </li>
    
                        <li class="nav-item mx-2">
                            <a href="user_profile.html" class="nav-link  active text-info">My Profile</a>
                        </li>
    
    
    
    
                    </ul>
                </div>
    
    
                <div class=" offcanvas offcanvas-start d-sm-block d-lg-none bg-white" tabindex="-1" id="offcanvasExample"
                    aria-labelledby="offcanvasExampleLabel">
                    <div class="offcanvas-body">
                        <ul class="navbar-nav nav-underline ">
                            <li class="nav-item mx-2">
                                <a href="patient_dashboard.html" class="nav-link  ">Dashboard</a>
                            </li>
    
                            <li class="nav-item mx-2">
                                <a href="user_profile.html" class="nav-link active text-info">My Profile</a>
                            </li>
    
    
    
                        </ul>
                    </div>
                </div>
    
    
    
            </div>
    
        </nav>
        <!-- <h2>User Profile</h2> -->
        <div class="foot" style="padding-bottom: 100px;">
        <div class="container-fluid  kok bg-light">

        </div>

        <div class="container-fluid bg-light">
            <div class="row">
                <div class=" col-md-3"></div>

                <div class="col-12 col-md-6  ">
                    <div class="container-fluid bg-light">
                        <div class="d-flex mb-3">
                            <h2 class="mt-3">User Profile</h2>
                            <div class="ms-auto p-3"> <a href="javascript: history.go(-1)" type="button"
                                    class="btn btn-outline-info mx-2 lo">
                                    < Back</a>
                            </div>
                        </div>

                    </div>
                    <div class="bg-white p-3">
                        <h4>General Information</h4>

                        <div class="row g-2 bg-white">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="name">
                                    <label for="floatingInput" class="dm">First Name</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="name">
                                    <label for="floatingInput" class="dm">Last Name</label>
                                </div>
                            </div>
                        </div>
                        <div class="row g-2 bg-white">
                            <div class="col-md-6">
                                <div class="form-floating mb-3">
                                    <!-- <input type="date" class="form-control" id="floatingInput"
                                    mailto:placeholder="name@example.com">
                                <label for="floatingInput">Date of Birth</label> -->
                                    <input type="text" id="uname" class="form-control" placeholder="Date Of Birth"
                                        onfocus="(this.type='date')"></input>
                                    <label for="floatingInput" class="dm">Date of Birth</label>
                                </div>
                            </div>
                        </div>
                        <!-- <input type="tel" class="form-control pt-3 pb-3  " id="phone"> -->
                        <h4> Contact Information</h4>
                        <div class="row g-2 bg-white">
                            <div class="col-md-2 col-4">
                                <div class="form-floating">
                                    <select class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                        <option selected>Mobile</option>
                                        <option value="1">Phone</option>
                                        <option value="2">Landline</option>

                                    </select>
                                    <label for="floatingSelect">Type</label>
                                </div>
                            </div>
                            <div class="col-md col-8">
                                <div class="form-floating mb-3">
                                    <input type="tel" class="form-control pt-3 pb-3  iti iti__country-list" id="phone">

                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="email" class="form-control" id="floatingInput"
                                        placeholder="name@example.com">
                                    <label for="floatingInput" class="dm">Email</label>
                                </div>
                            </div>


                        </div>
                        <h4> Location Information</h4>
                        <div class="row g-2 bg-white">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="street" placeholder="rttttttth">
                                    <label for="floatingInput" class="dm">Street</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="city" placeholder="trr">
                                    <label for="floatingInput" class="dm">City</label>
                                </div>
                            </div>
                        </div>
                        <div class="row g-2 bg-white">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="state" placeholder="yhht">
                                    <label for="floatingInput" class="dm">State</label>
                                </div>
                            </div>
                            <div class="col-md-3 col-9">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="map" placeholder="tre" >
                                    <label for="floatingInput" class="dm">Zip Code</label>
                                </div>
                            </div>
                            <div class="col-md-3 col-3">
                                <div class="mb-3 mt-2 highlight"> <button type="button"
                                        class="btn btn-outline-info mx-2 p-2 highlight btn-lg" onclick="searchAddress()">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
                                            <path
                                                d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A32 32 0 0 1 8 14.58a32 32 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10" />
                                            <path
                                                d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4m0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6" />
                                        </svg>
                                        Map</button>
                                </div>
                            </div>
                        </div>











                       





                        <div class="mt-4 d-flex flex-row-reverse mb-3 bg-white">


                            <button type="submit" class="btn btn-info mx-2 btn-lg">Edit</button>

                        </div>
                    </div>







                </div>







                <div class="col-md-3"></div>
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
   
    function searchAddress() {
      const Street = document.getElementById('street').value;
      const City = document.getElementById('city').value;
      const State = document.getElementById('state').value;
      const Zip = document.getElementById('map').value;
      const address = Street + " " + City  + " " + State  + " " + Zip;
      window.open(`https://www.google.com/maps/search/?api=1&query=${encodeURIComponent(address)}`, '_blank');
    }
  </script>



    </body>

</html>