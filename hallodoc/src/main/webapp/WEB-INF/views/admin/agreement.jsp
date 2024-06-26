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
<script src="<c:url value="/resources/js/script.js"/>"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>

<body class="bg-light mt-5">

	<form action="reviewAgreementAction/${requestId }" method="post">
		<div class="container mt-5">
			<p>To provide best medical service, we cannot determinbe the cost
				right way, If you agree to our service, so we will provide care and
				follow-up untill all care is completed. So with this points, if you
				like us to provide care to you click on 'Agree' and we'll grt
				started immediately, if you do not agree simply click 'Cancel'.</p>
			<div class="d-flex justify-content-between">
				<button type="submit" class="btn btn-success p-2 mx-5">I
					Agree</button>
				
					
				<button type="button" class="btn btn-danger p-2 mx-5 " data-bs-toggle="modal"
					data-bs-target="#cancel">Cancel</button>
			</div>
		</div>
		</form>






	<div class="modal fade" id="cancel" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog  modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header bg-info text-white">
					<h1 class="modal-title fs-5 " id="exampleModalLabel">Cancel
						Confirmation</h1>
					<button type="button" class="btn-close btn-close-white"
						data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<form action="cancelAgreementAction/${requestId }" method="post">
					<div class="modal-body">

						<p mb-3>${name }</p>





						<div class="form-floating mb-3">
							<textarea class="form-control" placeholder="Leave a comment here"
								id="floatingTextarea2" name="notes" style="height: 100px"></textarea>
							<label for="floatingTextarea2">Please provide a brief
								explaination forn your cancellation</label>
						</div>

					</div>
					<div class="modal-footer">

						<button type="submit" class="btn btn-info">Confirm</button>
						<button type="button" class="btn btn-outline-info"
							data-bs-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>