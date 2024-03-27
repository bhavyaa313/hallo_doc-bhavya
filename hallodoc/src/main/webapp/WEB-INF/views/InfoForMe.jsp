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




<div class="foot">

        <div class="container-fluid ">
            <div class="row">
                <div class=" col-md-3"></div>
                <div class="col-12 col-md-6 ">
                    <div class="container-fluid bg-light">
                        <div class="d-flex mb-3">
                            <h2 class="mt-3">Submit Information</h2>
                            <div class="ms-auto p-3"> <a href="javascript: history.go(-1)" type="button"
                                    class="btn btn-outline-info mx-2 lo">
                                    < Back</a>
                            </div>
                        </div>

                    </div>
                    <div class="bg-white p-3">
                        <h4>Patient Information</h4>
                        <div class="form-floating mb-3">
                            <textarea class="form-control " placeholder="Leave a comment here" id="floatingTextarea2"
                                style="height: 100px"></textarea>
                            <label for="floatingTextarea2" class="dm"> Enter brief details of symptons
                                (optional)</label>
                        </div>
                        <div class="row g-2">
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
                        <div class="row g-2">
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
                        <h4>Patient Contact Information</h4>
                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="email" class="form-control" id="floatingInput"
                                        placeholder="name@example.com">
                                    <label for="floatingInput" class="dm">Email</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="tel" class="form-control pt-3 pb-3  iti iti__country-list" id="phone">

                                </div>
                            </div>

                        </div>
                        <h4>Patient Location</h4>
                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="rttttttth">
                                    <label for="floatingInput" class="dm">Street</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="trr">
                                    <label for="floatingInput" class="dm">City</label>
                                </div>
                            </div>
                        </div>
                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="yhht">
                                    <label for="floatingInput" class="dm">State</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="tre">
                                    <label for="floatingInput" class="dm">Zip Code</label>
                                </div>
                            </div>
                        </div>




                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="floatingInput"
                                        placeholder="trrrrrrrrrr">
                                    <label for="floatingInput" class="dm">Room #/ Suite (Optional)</label>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="mb-3 mt-2 highlight"> <a href="" type="button"
                                        class="btn btn-outline-info mx-2 p-2 highlight">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
                                            <path
                                                d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A32 32 0 0 1 8 14.58a32 32 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10" />
                                            <path
                                                d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4m0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6" />
                                        </svg>
                                        Map</a>
                                </div>
                            </div>
                        </div>






                        <h4>(Optional) Upload Photo or Document</h4>



                        <div class="row">
                            <div class="col">
                                <div class="input-group mb-3 drill_cursor mt-3">
                                    <input type="file" name="" id="input_file" hidden>
                                    <input type="text" class="form-control col-form-label-lg " id="txt"
                                        onclick="open_file" placeholder="Upload " aria-label="Upload"
                                        aria-describedby="button-addon2">
                                    <button class="btn btn-outline-info bg-info" type="button" onclick="open_file()"
                                        id="button-addon2">
                                        <img src="images/cloud-arrow-up.svg" alt="">
                                        <span style="color: white;">Upload</span>
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








                    </div>







                    <div class="col-md-3"></div>
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



    </body>

</html>