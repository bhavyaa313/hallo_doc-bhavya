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
</style>
</head>

<body class="bg-light">
  <div class="foot" style="padding-bottom: 395px;">
        <div class="bg-light">

            <div class="container-fluid bg-light mt-3">
                <div class="  d-flex p-4  ">
                    <h3 class="mx-2 mt-3">Patient Record</h3>
                    <div class="ms-auto "> <a href="javascript: history.go(-1)" type="button"
                            class="btn btn-outline-info mx-2 ">
                            < Back</a>
                    </div>

                </div>


            </div>




            <div class="container-fluid bg-white ">


                <div class="lo">
                    <table class="table">
                        <thead>
                            <tr>

                                <th scope="col">Client/Member</th>
                                <th scope="col">Created Date </th>
                                <th scope="col">Confirmation</th>

                                <th scope="col">Provider Name</th>
                                <th scope="col">Concluded Date</th>
                                <th scope="col">Status</th>
                                <th scope="col">Final Report</th>
                                <th scope="col">Actions</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr>

                                <td>Testing</td>
                                <td>jun 24, 2023</td>
                                <td>0987654321876</td>

                                <td>Dr. Parekh</td>
                                <td>july 7, 2023</td>
                                <td>Accepted</td>
                                <td>

                                    <a class=" dropdown-toggle btn btn-outline-info mx-2" href="#" role="button"
                                        data-bs-toggle="dropdown" aria-expanded="false">
                                        view
                                    </a>


                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">View Case</a></li>
                                        <li><a class="dropdown-item" href="#">Chat/a></li>

                                        <li><a class="dropdown-item" href="#">Document</a></li>
                                    </ul>



                                </td>
                                <td>
                                    <button type="button" class="btn btn-outline-info mx-2 ">
                                        Actions </button>
                                </td>
                            </tr>
                            <tr>

                                <td>Testing</td>
                                <td>jun 24, 2023</td>
                                <td>0987654321876</td>

                                <td>Dr. Parekh</td>
                                <td>july 7, 2023</td>
                                <td>Accepted</td>
                                <td>

                                    <a class=" dropdown-toggle btn btn-outline-info mx-2" href="#" role="button"
                                        data-bs-toggle="dropdown" aria-expanded="false">
                                        view
                                    </a>


                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">View Case</a></li>
                                        <li><a class="dropdown-item" href="#">Chat/a></li>

                                        <li><a class="dropdown-item" href="#">Document</a></li>
                                    </ul>



                                </td>
                                <td>
                                    <button type="button" class="btn btn-outline-info mx-2 ">
                                        Actions </button>
                                </td>
                            </tr>


                            <tr>

                                <td>Testing</td>
                                <td>jun 24, 2023</td>
                                <td>0987654321876</td>

                                <td>Dr. Parekh</td>
                                <td>july 7, 2023</td>
                                <td>Accepted</td>
                                <td>

                                    <a class=" dropdown-toggle btn btn-outline-info mx-2" href="#" role="button"
                                        data-bs-toggle="dropdown" aria-expanded="false">
                                        view
                                    </a>


                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">View Case</a></li>
                                        <li><a class="dropdown-item" href="#">Chat/a></li>

                                        <li><a class="dropdown-item" href="#">Document</a></li>
                                    </ul>



                                </td>
                                <td>
                                    <button type="button" class="btn btn-outline-info mx-2 ">
                                        Actions </button>
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
                                <div class="row w-100">
                                    <div class="col-12">
                                        Testing
                                    </div>



                                    <div class="col-12">
                                        942613402
                                    </div>


                                </div>


                            </button>
                        </h2>
                        <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show">
                            <div class="accordion-body">
                                <div><span class="mx-2"><button class="btn btn-outline-info rounded-circle btn-sm"><svg
                                                xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                fill="currentColor" class="bi bi-calendar4" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                            </svg></button></span> test@gmail.com</div>
                                <div class="mt-1"> <span class="mx-2 "><button
                                            class="btn btn-outline-info rounded-circle btn-sm"><svg
                                                xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                fill="currentColor" class="bi bi-calendar4" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                            </svg></button></span>942613402</div>
                                <div class="mt-2"><button type="button" class="btn btn-outline-info mx-2 ">
                                        Explore </button></div>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false"
                                aria-controls="panelsStayOpen-collapseTwo">
                                <div class="row w-100">
                                    <div class="col-12">

                                        Testing
                                    </div>



                                    <div class="col-12">
                                        942613402
                                    </div>


                                </div>
                            </button>
                        </h2>
                        <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse">
                            <div class="accordion-body">
                                <div><span class="mx-2"><button class="btn btn-outline-info rounded-circle btn-sm"><svg
                                                xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                fill="currentColor" class="bi bi-calendar4" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                            </svg></button></span> test@gmail.com</div>
                                <div class="mt-1"> <span class="mx-2 "><button
                                            class="btn btn-outline-info rounded-circle btn-sm"><svg
                                                xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                fill="currentColor" class="bi bi-calendar4" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                            </svg></button></span>942613402</div>
                                <div class="mt-2"><button type="button" class="btn btn-outline-info mx-2 ">
                                        Explore </button></div>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false"
                                aria-controls="panelsStayOpen-collapseThree">
                                <div class="row w-100">
                                    <div class="col-12">
                                        Testing
                                    </div>



                                    <div class="col-12">
                                        942613402
                                    </div>


                                </div>

                            </button>
                        </h2>
                        <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse">
                            <div class="accordion-body">
                                <div><span class="mx-2"><button class="btn btn-outline-info rounded-circle btn-sm"><svg
                                                xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                fill="currentColor" class="bi bi-calendar4" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                            </svg></button></span> test@gmail.com</div>
                                <div class="mt-1 mb-2"> <span class="mx-2 "><button
                                            class="btn btn-outline-info rounded-circle btn-sm"><svg
                                                xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                fill="currentColor" class="bi bi-calendar4" viewBox="0 0 16 16">
                                                <path
                                                    d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v1h14V3a1 1 0 0 0-1-1zm13 3H1v9a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1z" />
                                            </svg></button></span>942613402</div>
                                <div class="mt-2"><button type="button" class="btn btn-outline-info mx-2 ">
                                        Explore </button></div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    
    <div class="footer d-flex  align-items-center justify-content-end mt-3 ">
        <p class="mx-3 text-center mb-2 mt-2  ">Terms & conditions | privacy policy</p>
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

</body>

</html>




	<jsp:include page="Navbar.jsp" />