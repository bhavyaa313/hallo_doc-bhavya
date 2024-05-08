<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Dasdhboard New</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
 <link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
  <script src="<c:url value="/resources/js/script.js" />"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
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
          <img src="images/icons8-menu.svg" alt="">
        </button>

        <li class="nav-item">
          <img class="hello-logo1 m-2" src="<c:url value="/resources/images/hellodoc-logo.png" />" alt="">
        </li>

        <li class="nav-item navbar-right ml-auto">

          <span class="wlcm lo">Welcome <span style="font-weight: 500;">${userList[0].firstName} ${userList[0].lastName}</span></span>

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
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-moon"
              viewBox="0 0 16 16">
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
            <a href="${pageContext.request.contextPath}/admin" class="nav-link ${activeString }">Dashboard</a>
          </li>
          <li class="nav-item mx-2">
            <a href="provider_location.html" class="nav-link">Provider Location</a>
          </li>
          <li class="nav-item mx-2">
            <a href="${pageContext.request.contextPath}/myProfile/${userList[0].userID}" class="nav-link ${activeString1 }">My Profile</a>
          </li>
          <li class="nav-item dropdown mx-2">
            <a class="nav-link dropdown-toggle ${active }" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Providers
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/providerMenu">Provider</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="day_wise_scheduling.html">Scheduling</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
             
            </ul>
          </li>
          <li class="nav-item mx-2">
            <a href="${pageContext.request.contextPath}/partners" class="nav-link ${active2 } ">Partners</a>
          </li>
          <li class="nav-item dropdown mx-2">
            <a class="nav-link dropdown-toggle ${active3 }" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Access
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/accountAccess">Account Access</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="userAccess">User Access</a></li>

            </ul>
          </li>
          <li class="nav-item dropdown mx-2">
            <a class="nav-link dropdown-toggle ${active4 }" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Records
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/searchRecords">Search Records</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/emailLogs">Email Logs</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/smsLogs">SMS Logs</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/patientRecords">Patient Records</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/blockHistory">Block History</a></li>
            </ul>
          </li>
        </ul>
      </div>


      <div class=" offcanvas offcanvas-start d-sm-block d-lg-none bg-white" tabindex="-1" id="offcanvasExample"
        aria-labelledby="offcanvasExampleLabel">
        <div class="offcanvas-body">
          <span class="wlcm lo-btn">Welcome <span style="font-weight: 500;">Admin admin2</span></span>
          <ul class="navbar-nav nav-underline mt-3">
            <li class="nav-item mx-2">
              <a href="dashboard.html" class="nav-link active  text-info">Dashboard</a>
            </li>
            <li class="nav-item mx-2">
              <a href="provider_location.html" class="nav-link">Provider Location</a>
            </li>
            <li class="nav-item mx-2">
              <a href="my_profile.html" class="nav-link">My Profile</a>
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

</body>
</html>