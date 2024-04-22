<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My_profile</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style1.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/custom.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script>
        $(document).ready(function () {
            $('#yourModalId').modal('show');
        });
        // const myModal = document.getElementById('myModal')
        // const myInput = document.getElementById('myInput')

        myModal.addEventListener('shown.bs.modal', () => {
            myInput.focus()
        })
    </script>



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
        body  .bg-light  {

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

            &:focus {
                outline: none;
            }
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

                        <button type="button" class="btn btn-outline-info mx-2 lo">Logout</button>

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
                    <ul class="navbar-nav nav-underline">
                        <li class="nav-item mx-2">
                            <a href="dashboard.html" class="nav-link ">Dashboard</a>
                        </li>
                        <li class="nav-item mx-2">
                            <a href="provider_location.html" class="nav-link">Provider Location</a>
                        </li>
                        <li class="nav-item mx-2">
                            <a href="my_profile.html" class="nav-link active  text-info">My Profile</a>
                        </li>
                        <li class="nav-item dropdown mx-2">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                providers
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="provider_menu.html">Provider</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="day_wise_scheduling.html">Scheduling</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#">Invoicing</a></li>
                            </ul>
                        </li>
                        <li class="nav-item mx-2">
                            <a href="vendor.html" class="nav-link">Partners</a>
                        </li>
                        <li class="nav-item dropdown mx-2">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                Access
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="account_access.html">Account Access</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="user_access.html">User Access</a></li>

                            </ul>
                        </li>
                        <li class="nav-item dropdown mx-2">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                Records
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="search_records.html">Search Records</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="email_logs.html">Email Logs</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="sms_logs.html">SMS Logs</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="patient_record.html">Patient Records</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="block_history.html">Block History</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>


                <div class=" offcanvas offcanvas-start d-sm-block d-lg-none bg-white" tabindex="-1"
                    id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
                    <div class="offcanvas-body">
                        <ul class="navbar-nav nav-underline">
                            <li class="nav-item mx-2">
                                <a href="dashboard.html" class="nav-link ">Dashboard</a>
                            </li>
                            <li class="nav-item mx-2">
                                <a href="provider_location.html" class="nav-link">Provider Location</a>
                            </li>
                            <li class="nav-item mx-2">
                                <a href="my_profile.html" class="nav-link active  text-info">My Profile</a>
                            </li>
                            <li class="nav-item dropdown mx-2">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                    aria-expanded="false">
                                    Providers
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="provider_menu.html">Provider</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="day_wise_scheduling.html">Scheduling</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Invoicing</a></li>
                                </ul>
                            </li>
                            <li class="nav-item mx-2">
                                <a href="vendor.html" class="nav-link">Partners</a>
                            </li>
                            <li class="nav-item dropdown mx-2">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                    aria-expanded="false">
                                    Access
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="account_access.html">Account Access</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="user_access.html">User Access</a></li>

                                </ul>
                            </li>
                            <li class="nav-item dropdown mx-2">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                    aria-expanded="false">
                                    Records
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="search_records.html">Search Records</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="email_logs.html">Email Logs</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="sms_logs.html">SMS Logs</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="patient_record.html">Patient Records</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="block_history.html">Block History</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="patient_history.html">Block History</a></li>

                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>



            </div>

        </nav>

<div class="foot">
        <div class="container-fluid bg-light ">
            <div class="row">
                <div class=" col-md-2"></div>
                <div class="col-12 col-md-8 ">
                    <div class="container-fluid bg-light">
                        <div class="d-flex mb-3">
                            <h3 class="mt-3">My Profile</h3>
                            <div class="ms-auto p-3"> <a href="javascript: history.go(-1)" type="button"
                                    class="btn btn-outline-info mx-2 ">
                                    < Back</a>
                            </div>
                        </div>

                    </div>
                    <div class="bg-white p-3">

                        <h4 class="mb-2">Account Information</h4>


                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control enable" id="floatingInput" placeholder="name" disabled>
                                    <label for="floatingInput" class="dm">User Name</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="password" class="form-control enable" id="floatingInput" placeholder="name" disabled>
                                    <label for="floatingInput" class="dm">Password</label>
                                </div>
                            </div>
                        </div>
                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating " >
                                    <select class="form-select enable" id="floatingSelect"
                                        aria-label="Floating label select example" disabled>
                                        <option selected>Active</option>
                                        <option value="1">Pending</option>
                                        <option value="2">Closed</option>
                                        <option value="3">Unpaid</option>
                                    </select>
                                    <label for="floatingSelect">Status</label>
                                </div>
                            </div>

                            <div class="col-md">
                                <div class="form-floating">
                                    <select class="form-select enable" id="floatingSelect"
                                        aria-label="Floating label select example " disabled>
                                        <option selected>Mater Admin</option>
                                        <option value="1">Admin</option>
                                        <option value="2">Provider</option>
                                        <option value="3">Patient</option>
                                    </select>
                                    <label for="floatingSelect">Role</label>
                                </div>
                            </div>
                        </div>
                        <div class="mt-4 d-flex flex-row-reverse mb-3 ">

                        
                            <button type="submit" class="btn btn-info btn-lg mx-3 random  " onclick="show()">Edit</button>
                            <button type="submit" class="btn btn-danger btn-lg mx-2 hide see"  onclick="show2()">Cancel</button>
                            <button type="submit" class="btn btn-success btn-lg mx-2 hide see " onclick="show2()">Save</button>

                        </div>





                        <!-- <input type="tel" class="form-control pt-3 pb-3  " id="phone"> -->
                        <h4 class="mt-5">Administrator Information</h4>


                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control enable1" id="floatingInput" placeholder="name" disabled>
                                    <label for="floatingInput" class="dm">First Name</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control enable1" id="floatingInput" placeholder="name" disabled>
                                    <label for="floatingInput" class="dm">Last Name</label>
                                </div>
                            </div>
                        </div>


                        <div class="row g-2">
                            <div class="col-md ">
                                <div class="form-floating mb-3">
                                    <input type="email" class="form-control enable1" id="floatingInput"
                                        placeholder="name@example.com" disabled>
                                    <label for="floatingInput" class="dm">Email</label>
                                </div>
                            </div>


                            <div class="col-md ">
                                <div class="form-floating mb-3">
                                    <input type="email" class="form-control enable1" id="floatingInput"
                                        placeholder="name@example.com" disabled>
                                    <label for="floatingInput" class="dm">Confirm Email</label>
                                </div>
                            </div>


                        </div>

                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3 enable1">
                                    <input type="tel" class="form-control pt-3 pb-3  enable2 iti iti__country-list" id="phone" disabled>

                                </div>
                            </div>

                            <div class="col-md">


                                <div class="d-flex flex-row  ">
                                    <div class="p-2 mx-3">
                                        <div class="form-check">
                                            <input class="form-check-input enable1" type="checkbox" value=""
                                                id="flexCheckDefault" disabled>
                                            <label class="form-check-label" for="flexCheckDefault">
                                                District Of Columbia
                                            </label>

                                        </div>
                                    </div>
                                    <div class="p-2 mx-3">
                                        <div class="form-check">
                                            <input class="form-check-input enable1" type="checkbox" value=""
                                                id="flexCheckChecked" checked disabled>
                                            <label class="form-check-label" for="flexCheckChecked">
                                                New York
                                            </label>
                                        </div>
                                    </div>
                                    <div class="p-2 mx-3">
                                        <div class="form-check">
                                            <input class="form-check-input enable1" type="checkbox" value=""
                                                id="flexCheckChecked" checked disabled>
                                            <label class="form-check-label" for="flexCheckChecked">
                                                Virginia
                                            </label>
                                        </div>
                                    </div>

                                </div>
                                <div class="d-flex flex-row mb-3 ">
                                    <div class="p-2 mx-3">
                                        <div class="form-check">
                                            <input class="form-check-input enable1" type="checkbox" value=""
                                                id="flexCheckDefault" disabled>
                                            <label class="form-check-label" for="flexCheckDefault">
                                                Maryland
                                            </label>

                                        </div>
                                    </div>


                                </div>
                            </div>


















                            <div class="mt-4 d-flex flex-row-reverse mb-3 ">

                                <button type="submit" class="btn btn-info btn-lg mx-2 random1" onclick="show3()">Edit</button>
                                <button type="submit" class="btn btn-danger btn-lg mx-2 hide1 see1" onclick="show4()">Cancel</button>
                                <button type="submit" class="btn btn-success btn-lg mx-2 hide1 see1" onclick="show4()">Save</button>


                            </div>








                        </div>



                        <h4>Mailing & Billing Information</h4>
                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control enable2" id="floatingInput" placeholder="name" disabled>
                                    <label for="floatingInput" class="dm">Address 1</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control enable2" id="floatingInput" placeholder="name" disabled>
                                    <label for="floatingInput" class="dm">Address 2</label>
                                </div>
                            </div>
                        </div>

                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control enable2" id="floatingInput" placeholder="name" disabled>
                                    <label for="floatingInput" class="dm">City</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control enable2" id="floatingInput" placeholder="name" disabled>
                                    <label for="floatingInput" class="dm">State</label>
                                </div>
                            </div>
                        </div>

                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control enable2" id="floatingInput" placeholder="name" disabled>
                                    <label for="floatingInput" class="dm">Zip</label>
                                </div>
                            </div>
                            <div class="col-md">


                                <div class="form-floating mb-3">
                                    <input type="tel" class="form-control pt-3 pb-3  iti iti__country-list enable2" id="phone1" disabled>

                                </div>


                            </div>
                        </div>

                        <div class="mt-4 d-flex flex-row-reverse mb-3 ">

                            <button type="submit" class="btn btn-info btn-lg random2  mb-4" onclick="show5()">Edit</button>
                            <button type="submit" class="btn btn-danger btn-lg mx-2 hide2 see2" onclick="show6()">Cancel</button>
                            <button type="submit" class="btn btn-success btn-lg mx-2 hide2 see2 mb-4" onclick="show6()">Save</button>


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
    function show()
    {
        $('.hide').removeClass("hide");
        $('.random').addClass("hide");
        $('.enable').removeAttr("disabled");

    }

    function show2()
    {
        $('.hide').removeClass("hide");
        $('.see').addClass("hide");
        $('.enable').attr("disabled" ,"disabled" );

    }


</script>

<script>
function show3()
{
$('.hide1').removeClass("hide1");
$('.random1').addClass("hide1");
$('.enable1').removeAttr("disabled");

}

function show4()
{
$('.hide1').removeClass("hide1");
$('.see1').addClass("hide1");
$('.enable1').attr("disabled" ,"disabled" );

}


</script>

<script>
function show5()
{
$('.hide2').removeClass("hide2");
$('.random2').addClass("hide2");
$('.enable2').removeAttr("disabled");

}

function show6()
{
$('.hide2').removeClass("hide2");
$('.see2').addClass("hide2");
$('.enable2').attr("disabled" ,"disabled" );

}


</script>


    </body>




</html>