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

	<jsp:include page="Navbar.jsp" />
<body class="bg-light">

	
	 <div class="foot" >
    <div class="bg-light  ">

        <div class="container bg-light mt-3">
            <div class="  d-flex p-4  ">
                <h3 class="mx-2 mt-3">Account Access</h3>
                <div class="ms-auto mt-3"> <a href="createRole" type="button"
                        class="btn btn-outline-info mx-2 ">
                        create</a>
                </div>

            </div>


        </div>

        <div class="container bg-white ">

            <div class="lo">
                <table class="table">
                    <thead class="bg-light">
                        <tr>
                            <th scope="col " class="col-md-4">Name </th>
                            <th scope="col" class="col-md-4">Account Type</th>

                            <th scope="col" class="col-md-4">Actions</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>


                            <td>Nikunj 643</td>
                            <td>Admin</td>

                            <td> <button type="button" class="btn btn-outline-info mx-2 ">
                                    Delete </button>
                                <a  href="editRole" type="button" class="btn btn-outline-info mx-2  ">
                                    Edit </a>
                            </td>
                        </tr>
                       



                    </tbody>
                </table>
            </div>

        </div>

        <div class="accordion lo-btn" id="accordionPanelsStayOpenExample">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="false"
                        aria-controls="panelsStayOpen-collapseOne">
                        Name: Nikunj
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <div class="mb-2">Account type: Admin</div>

                        <div class="mt-2"><button type="button" class="btn btn-outline-info mx-2 ">
                                Delete </button>
                                <a  href="editRole" type="button" class="btn btn-outline-info mx-2  ">
                                    Edit </a>
                        </div>

                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                            data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false"
                            aria-controls="panelsStayOpen-collapseTwo">
                            Name: Nikunj
                        </button>
                    </h2>
                    <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse">
                        <div class="accordion-body">
                            Account type: Admin
                            <div class="mt-2"><button type="button" class="btn btn-outline-info mx-2 ">
                                    Delete </button>
                                    <a  href="edit_role.html" type="button" class="btn btn-outline-info mx-2  ">
                                        Edit </a>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false"
                                aria-controls="panelsStayOpen-collapseThree">
                                Name: Nikunj
                            </button>
                        </h2>
                        <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse">
                            <div class="accordion-body">
                                Account type: Admin
                                <div class="mt-2"><button type="button" class="btn btn-outline-info mx-2 ">
                                        Delete </button>
                                        <a  href="edit_role.html" type="button" class="btn btn-outline-info mx-2  ">
                                            Edit </a>
                                </div>
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
    <div class="footer d-flex  align-items-center justify-content-end mt-3 ">
        <p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions | privacy policy</p>
      </div>
      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
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


    </script>

</body>

</html>



	