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
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js">
</script> <script src="<c:url value="/resources/js/script.js" />"></script> <script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script> <script
	src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<style>

    </style>

</head>

<body class="bg-light">

	<jsp:include page="Navbar.jsp" />
	
	   <div class="foot" style="padding-bottom: 250px;">
    <div class="bg-light">

        <div class="container bg-light mt-3">
            <div class="  d-flex p-4  ">
                <h3 class="mx-2 mt-3">User Access</h3>
                <div class="ms-auto "> <a href="javascript: history.go(-1)" type="button" class="btn btn-outline-info mx-2 ">
                        < Back</a>
                </div>

            </div>


        </div>

        <div class="container bg-white ">

            <div class="  d-flex p-4  ">
                <div class="col-lg-7 d-md-flex d-block ">

                    <div class="input-group border me-2 rounded-0 mb-2 form-control">
                        <div class="input-group-append">
                            <button class="btn text-secondary border border-0 bg-white" type="button">
                                <i class="bi bi-search"></i>
                            </button>
                        </div>
                        <input type="text" class="form-control border-0  shadow-none" placeholder="Search Patients" id="myInput" onkeyup="search()">
                    </div>

                    <div class="input-group border me-2 rounded-0 mb-2 form-control">
                        <div class="input-group-append">
                            <button class="btn text-secondary border border-0 bg-white" type="button">
                                <i class="bi bi-search"></i>
                            </button>
                        </div>
                        <input type="search" class="form-control border-0  shadow-none" placeholder="Search Regions" list="data" id="myInput2" onkeyup="searchRegion()">
                        <datalist class=" border-0  shadow-none" aria-label="Default select example" id="data">
                      
                            <option value="mumbai">
                            <option value="kolkata"></option>
                            <option value="banglore"></option>
                          </datalist>
                    </div>
                </div>




            </div>
            <div class="lo">
                <table class="table" id="myTable">
                    <thead>
                        <tr>
                            <th scope="col">Account Type </th>
                            <th scope="col">Account POC</th>
                            <th scope="col">Phone</th>
                            <th scope="col">City</th>

                            <th scope="col">Status</th>
                            <th scope="col">Open Requests</th>
                            <th scope="col">Actions</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>

                            <td>
                                Admin
                            </td>
                            <td>saloni</td>
                            <td>+919426144202</td>
                            <td>mumbai</td>
                            <td>Active</td>
                            <td>200</td>
                            <td>
                                <button type="button" class="btn btn-outline-info mx-2 ">
                                    Edit </button>
                            </td>
                        </tr>
                        <tr>

                            <td>
                                Admin
                            </td>
                            <td>Nikunj 643</td>
                            <td>+919426144202</td>
                            <td>kolkata</td>
                            <td>Active</td>
                            <td>200</td>
                            <td>
                                <button type="button" class="btn btn-outline-info mx-2 ">
                                    Edit </button>
                            </td>
                        </tr>


                        <tr>

                            <td>
                                Admin
                            </td>
                            <td>bhavya</td>
                            <td>+919426144202</td>
                            <td>banglore</td>
                            <td>Active</td>
                            <td>200</td>
                            <td>
                                <button type="button" class="btn btn-outline-info mx-2 ">
                                    Edit </button>
                            </td>
                        </tr>
                        <tr>

                            <td>
                                Admin
                            </td>
                            <td>sweta</td>
                            <td>+919426144202</td>
                            <td>mumbai</td>
                            <td>Active</td>
                            <td>200</td>
                            <td>
                                <button type="button" class="btn btn-outline-info mx-2 ">
                                    Edit </button>
                            </td>
                        </tr>

                    </tbody>
                </table>
            </div>


            <div class="accordion lo-btn" id="accordionPanelsStayOpenExample">
                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button" type="button" data-bs-toggle="collapse"
                            data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true"
                            aria-controls="panelsStayOpen-collapseOne">
                            <div class="mx-3">Nikunj </div>
                            <div>Account Type: Admin</div>
                        </button>

                    </h2>
                    <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show">
                        <div class="accordion-body">
                            <div class="mb-2"><span class="mx-2 mb-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                                            <path
                                                d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.6 17.6 0 0 0 4.168 6.608 17.6 17.6 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.68.68 0 0 0-.58-.122l-2.19.547a1.75 1.75 0 0 1-1.657-.459L5.482 8.062a1.75 1.75 0 0 1-.46-1.657l.548-2.19a.68.68 0 0 0-.122-.58zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z" />
                                        </svg>
                                    </button></span>phone: <b>+919426144202</b></div>
                            <div class="mb-2"><span class="mx-2 mb-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
                                            <path
                                                d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425z" />
                                        </svg>
                                    </button></span>status: <b>Active</b></div>
                            <div class="mb-2"><span class="mx-2 mb-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-folder2-open" viewBox="0 0 16 16">
                                            <path
                                                d="M1 3.5A1.5 1.5 0 0 1 2.5 2h2.764c.958 0 1.76.56 2.311 1.184C7.985 3.648 8.48 4 9 4h4.5A1.5 1.5 0 0 1 15 5.5v.64c.57.265.94.876.856 1.546l-.64 5.124A2.5 2.5 0 0 1 12.733 15H3.266a2.5 2.5 0 0 1-2.481-2.19l-.64-5.124A1.5 1.5 0 0 1 1 6.14zM2 6h12v-.5a.5.5 0 0 0-.5-.5H9c-.964 0-1.71-.629-2.174-1.154C6.374 3.334 5.82 3 5.264 3H2.5a.5.5 0 0 0-.5.5zm-.367 1a.5.5 0 0 0-.496.562l.64 5.124A1.5 1.5 0 0 0 3.266 14h9.468a1.5 1.5 0 0 0 1.489-1.314l.64-5.124A.5.5 0 0 0 14.367 7z" />
                                        </svg>
                                    </button></span>open requests: <b>200</b></div>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                            data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false"
                            aria-controls="panelsStayOpen-collapseTwo">
                            <div class="mx-3">Nikunj </div>
                            <div>Account Type: Admin</div>
                        </button>
                    </h2>
                    <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse">
                        <div class="accordion-body">

                            <div class="mb-2"><span class="mx-2 mb-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                                            <path
                                                d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.6 17.6 0 0 0 4.168 6.608 17.6 17.6 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.68.68 0 0 0-.58-.122l-2.19.547a1.75 1.75 0 0 1-1.657-.459L5.482 8.062a1.75 1.75 0 0 1-.46-1.657l.548-2.19a.68.68 0 0 0-.122-.58zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z" />
                                        </svg>
                                    </button></span>phone: <b>+919426144202</b></div>
                            <div class="mb-2"><span class="mx-2 mb-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
                                            <path
                                                d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425z" />
                                        </svg>
                                    </button></span>status: <b>Active</b></div>
                            <div class="mb-2"><span class="mx-2 mb-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-folder2-open" viewBox="0 0 16 16">
                                            <path
                                                d="M1 3.5A1.5 1.5 0 0 1 2.5 2h2.764c.958 0 1.76.56 2.311 1.184C7.985 3.648 8.48 4 9 4h4.5A1.5 1.5 0 0 1 15 5.5v.64c.57.265.94.876.856 1.546l-.64 5.124A2.5 2.5 0 0 1 12.733 15H3.266a2.5 2.5 0 0 1-2.481-2.19l-.64-5.124A1.5 1.5 0 0 1 1 6.14zM2 6h12v-.5a.5.5 0 0 0-.5-.5H9c-.964 0-1.71-.629-2.174-1.154C6.374 3.334 5.82 3 5.264 3H2.5a.5.5 0 0 0-.5.5zm-.367 1a.5.5 0 0 0-.496.562l.64 5.124A1.5 1.5 0 0 0 3.266 14h9.468a1.5 1.5 0 0 0 1.489-1.314l.64-5.124A.5.5 0 0 0 14.367 7z" />
                                        </svg>
                                    </button></span>open requests: <b>200</b></div>

                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                            data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false"
                            aria-controls="panelsStayOpen-collapseThree">
                            <div class="mx-3">Nikunj </div>
                            <div>Account Type: Admin</div>
                        </button>
                    </h2>
                    <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse">
                        <div class="accordion-body">

                            <div class="mb-2"><span class="mx-2 mb-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                                            <path
                                                d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.6 17.6 0 0 0 4.168 6.608 17.6 17.6 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.68.68 0 0 0-.58-.122l-2.19.547a1.75 1.75 0 0 1-1.657-.459L5.482 8.062a1.75 1.75 0 0 1-.46-1.657l.548-2.19a.68.68 0 0 0-.122-.58zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z" />
                                        </svg>
                                    </button></span>phone: <b>+919426144202</b></div>
                            <div class="mb-2"><span class="mx-2 mb-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
                                            <path
                                                d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425z" />
                                        </svg>
                                    </button></span>status: <b>Active</b></div>
                            <div class="mb-2"><span class="mx-2 mb-2"><button class="btn btn-outline-info rounded-circle btn-sm">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                            fill="currentColor" class="bi bi-folder2-open" viewBox="0 0 16 16">
                                            <path
                                                d="M1 3.5A1.5 1.5 0 0 1 2.5 2h2.764c.958 0 1.76.56 2.311 1.184C7.985 3.648 8.48 4 9 4h4.5A1.5 1.5 0 0 1 15 5.5v.64c.57.265.94.876.856 1.546l-.64 5.124A2.5 2.5 0 0 1 12.733 15H3.266a2.5 2.5 0 0 1-2.481-2.19l-.64-5.124A1.5 1.5 0 0 1 1 6.14zM2 6h12v-.5a.5.5 0 0 0-.5-.5H9c-.964 0-1.71-.629-2.174-1.154C6.374 3.334 5.82 3 5.264 3H2.5a.5.5 0 0 0-.5.5zm-.367 1a.5.5 0 0 0-.496.562l.64 5.124A1.5 1.5 0 0 0 3.266 14h9.468a1.5 1.5 0 0 0 1.489-1.314l.64-5.124A.5.5 0 0 0 14.367 7z" />
                                        </svg>
                                    </button></span>open requests: <b>200</b></div>

                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="footer d-flex  align-items-center justify-content-end mt-3 ">
        <p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions | privacy policy</p>
      </div>
      </div>
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
    </script>
    <script>
        function search() {
          var input, filter, table, tr, td, i, txtValue;
          input = document.getElementById("myInput");
          filter = input.value.toUpperCase();
          table = document.getElementById("myTable");
          tr = table.getElementsByTagName("tr");
          for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[1];
            if (td) {
              txtValue = td.textContent || td.innerText;
              if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }       
          }
        }


        function searchRegion() {
          var input, filter, table, tr, td, i, txtValue;
          input = document.getElementById("myInput2");
          filter = input.value.toUpperCase();
          table = document.getElementById("myTable");
          tr = table.getElementsByTagName("tr");
          for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[3];
            if (td) {
              txtValue = td.textContent || td.innerText;
              if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }       
          }
        }
        </script>

</body>

</html>
	