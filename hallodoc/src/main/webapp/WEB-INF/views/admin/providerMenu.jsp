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
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>

</head>

<body class="bg-light">




	<jsp:include page="Navbar.jsp" />
	  <div >
    <div class="bg-light">
    
    <div class="container bg-light mt-3">
        <div class="  d-flex p-4  ">
            <h3 class="mx-2 mt-3">Provider Menu</h3>
            <div class="ms-auto "> <a href="javascript: history.go(-1)" type="button" class="btn btn-outline-info mx-2 mt-3 ">
                    < Back</a>
            </div>

        </div>


    </div>

    <div class="container bg-white ">
        
            <div class="  d-flex p-4  ">
                <div class="col-lg-4 d-md-flex d-block">

                  
          
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
            <!-- <img class="uicon3" src="images/search.svg" alt=""> -->
           
                <div class="ms-auto "> <a href="addProvider" type="button" class="btn btn-info mx-2 lo">
                        Create Provider Account</a>

                    <button type="button" class="btn btn-outline-info mx-2 lo-btn">
                        <img src="images/download-svgrepo-com.svg" alt="">
                    </button>
                </div>

            </div>
<div class="lo">
            <table class="table" id="myTable">
                <thead>
                    <tr>
                        <th scope="col" class="col-md-1">Stop Notification </th>
                        <th scope="col">Provider Name</th>
                        <th scope="col">Role</th>
                        <th scope="col">City</th>
                        <th scope="col">On-call-Status</th>
                        <th scope="col">Status</th>
                        <th scope="col">Actions</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>

                        <td>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                                <label class="form-check-label" for="flexCheckChecked">

                                </label>
                            </div>
                        </td>
                        <td>Nikunj 643</td>
                        <td>Admin</td>
                        <td>mumbai</td>
                        <td>Un-Available</td>
                        <td>Pending</td>
                        <td> <button type="button" class="btn btn-outline-info mx-2 " data-bs-toggle="modal" data-bs-target="#contact">
                                Contact </button>
                                <a href="editProvider" type="button" class="btn btn-outline-info mx-2 text-info">
                                    Edit </a></td>
                    </tr>
                 

                   
                </tbody>
            </table>
        </div>


        <div class="accordion lo-btn" id="accordionPanelsStayOpenExample">
            <div class="accordion-item">
              <h2 class="accordion-header">
                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" >
                        <label class="form-check-label" for="flexCheckChecked">

                        </label>     Nikunj
                    </div>
                 
                 
                </button>
              </h2>
              <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show">
                <div class="accordion-body">
                on call status : <b>available</b>
                </div>
              </div>
            </div>
            <div class="accordion-item">
              <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" >
                        <label class="form-check-label" for="flexCheckChecked">

                        </label>     Nikunj
                    </div>
                 
                </button>
              </h2>
              <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse">
                <div class="accordion-body">
                    on call status : <b>available</b>
                </div>
              </div>
            </div>
            <div class="accordion-item">
              <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false" aria-controls="panelsStayOpen-collapseThree">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" >
                        <label class="form-check-label" for="flexCheckChecked">

                        </label>     Nikunj
                    </div>
                 
                </button>
              </h2>
              <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse">
                <div class="accordion-body">
                    on call status : <b>available</b>
              </div>
            </div>
          </div>


        </div>
    </div>


    <div class="modal fade" id="contact" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog  modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-info text-white">
                    <h1 class="modal-title fs-5 " id="exampleModalLabel">Contact Your Provider</h1>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"
                        aria-label="Close"></button>
                </div>
                <div class="modal-body">

                    <p mb-3>Choose communication to send message </p>
                    <div class="form-check p-2 mx-4">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"
                            checked>
                        <label class="form-check-label" for="flexRadioDefault2">
                            SMS
                        </label>
                    </div>
                    <div class="form-check p-2 mx-4">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                            Email
                        </label>
                    </div>
                    <div class="form-check p-2 mx-4">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                            Both
                        </label>
                    </div>
                    
                    


                    <div class="form-floating mb-3 p-2 mx-2">
                        <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2"
                            style="height: 100px"></textarea>
                        <label for="floatingTextarea2">Description</label>
                    </div>

                </div>
                <div class="modal-footer">

                    <button type="button" class="btn btn-info">Send</button>
                    <button type="button" class="btn btn-outline-info" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <div class="footer d-flex  align-items-center justify-content-end mt-3 ">
        <p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions | privacy policy</p>
      </div>
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

</body>
</html>