<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>task</title>


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

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

</head>



<body>
	<div class="container-fluid  ">

		<div class="d-flex bg-success-subtle  ">
			<h3 class="text-center mx-auto mt-2 text-white">Task Management</h3>
		</div>

		<div class="d-flex mx-3 mt-3">
			<button type="button" class="btn btn-success mx-3"
				data-bs-toggle="modal" data-bs-target="#add">Add Task</button>
			<div class="col-lg-4 d-md-flex d-block ms-auto">

				<div class="input-group border me-2 rounded-0 mb-2 form-control">
					<div class="input-group-append">
						<button class="btn text-secondary border border-0 bg-white"
							type="button">
							<i class="bi bi-search"></i>
						</button>
					</div>
					<input type="text" id="myInput" onkeyup="search()"
						class="form-control border-0  shadow-none" placeholder="Search Assignee ">
				</div>

			</div>
				<!-- <div class="col-lg-4 d-md-flex d-block ms-auto">

				<div class="input-group border me-2 rounded-0 mb-2 form-control">
					<div class="input-group-append">
						<button class="btn text-secondary border border-0 bg-white"
							type="button">
							<i class="bi bi-search"></i>
						</button>
					</div>
					<input type="text" id="myInput1" onkeyup="search1()"
						class="form-control border-0  shadow-none" placeholder="Search by priority ">
				</div>

			</div> -->

		</div>

		<table class="table mt-3" id="myTable">
			<thead>
				<tr>

					<th scope="col">Task Id</th>
					<th scope="col">Task Name</th>
					<th scope="col">Assignee</th>
					<th scope="col">Discription</th>
					<th scope="col">Due Date</th>
					<th scope="col">Category</th>
					<th scope="col">City</th>
					<th scope="col">Action</th>



				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="t">

					<tr>
						<td>${t.id }</td>
						<td>${t.name }</td>
						<td>${t.assignee }</td>
						<td>${t.discription }</td>
						<td>${t.dueDate }</td>
						<td>${t.category }</td>
						<td>${t.city }</td>
						<td>
							<a type="button" href="delete/${t.id }" class="btn btn-danger mx-3">
								Delete</a>
							<button type="button" class="btn btn-success "
								data-bs-toggle="modal" data-bs-target="#edit"
								onclick="updateTask(${t.id },`${t.name }`,`${t.assignee }`,`${t.discription }`,`${t.dueDate }`,`${t.city }`,`${t.category }`)">
								Edit</button>
								
						</td>
					

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	</div>
	<div class="modal fade" id="add" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog  modal-dialog-centered">

			<div class="modal-content rounded-4">
				<div class="container-fluid  ">

					<div class="d-flex bg-success mt-1  ">
						<h3 class="text-center mx-auto mt-2 text-white">Task Form</h3>
					</div>
				</div>
				<form action="addTask" onsubmit="return validateForm()" name="myForm" method="post">
					<div class="modal-body">


						<div class="row g-2">

							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="name" name="taskName" required required title="Please enter your name" > <label
										for="floatingInput">Task Name</label>
								</div>
							</div>



							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="name" name="assignee"> <label
										for="floatingInput" class="dm">Assignee</label>
								</div>
							</div>
						</div>

						<div class="row g-2">

							<div class="col-md">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="name" name="discription"> <label
										for="floatingInput" class="dm">Discription</label>
								</div>
							</div>



							<div class="col-md">
								<div class="form-floating mb-3">

									<input type="text" id="uname" class="form-control"
										placeholder="Due date" onfocus="(this.type='date')"
										name="date"></input> <label for="floatingInput" class="dm">Due
										Date</label>
								</div>
							</div>
						</div>

						<div class="row g-2">

							<div class="col-md">
								<div class="form-floating mb-3">
									<select class="form-select" id="floatingSelect"
										aria-label="Floating label select example" name="city">
										<option selected>Select</option>
										<option value="Mumbai">Mumbai</option>
										<option value="Indore">Indore</option>
										<option value="Pune">Pune</option>
									</select> <label for="floatingSelect">Select City</label>
								</div>
							</div>



							<div class="col-md">
								<div class="form-floating mb-3">
										<select class="form-select" id="floatingSelect"
										aria-label="Floating label select example" name="priority">
										<option selected></option>
										<option value="High Priority">High Priority</option>
										<option value="Low Priority">Low Priority</option>
										<option value="Medium Priority">Medium Priority</option>
									</select> <label for="floatingSelect">Select Category</label>
								</div>
							</div>
						</div>



					</div>
					<div
						class="modal-footer border-top-0 pb-5 d-flex justify-content-center">

						<button type="submit" class="btn btn-success  text-white btn-lg "
							data-bs-dismiss="modal">Save</button>
						<button type="button" class="btn btn-info  text-white btn-lg "
							data-bs-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>


		</div>
	</div>
		<div class="modal fade" id="edit" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog  modal-dialog-centered">

								<div class="modal-content rounded-4">
									<div class="container-fluid  ">

										<div class="d-flex bg-success mt-1  ">
											<h3 class="text-center mx-auto mt-2 text-white">Task
												Form</h3>
										</div>
									</div>
									<form action="updateTask" method="post">
										<div class="modal-body">


											<div class="row g-2">
												<input type="text" value="" id="aa" name="taskid" hidden>
												<div class="col-md">
													<div class="form-floating mb-3">
														<input type="text" class="form-control" id="bb"
															placeholder="name" name="taskName" value="">
														<label for="floatingInput">Task Name</label>
													</div>
												</div>



												<div class="col-md">
													<div class="form-floating mb-3">
														<input type="text" class="form-control" id="cc"
															placeholder="name" name="assignee" value="">
														<label for="floatingInput" class="dm">Assignee</label>
													</div>
												</div>
											</div>

											<div class="row g-2">

												<div class="col-md">
													<div class="form-floating mb-3">
														<input type="text" class="form-control" id="dd"
															placeholder="name" name="discription"
															value=""> <label
															for="floatingInput" class="dm">Discription</label>
													</div>
												</div>



												<div class="col-md">
													<div class="form-floating mb-3">

														<input type="text" id="ee" class="form-control"
															placeholder="Due date" onfocus="(this.type='date')"
															name="date" value=""></input> <label for="floatingInput"
															class="dm">Due Date</label>
													</div>
												</div>
											</div>

											<div class="row g-2">

												<div class="col-md">
													<div class="form-floating mb-3">
														<select class="form-select" id="ff"
															aria-label="Floating label select example" name="city">
															<option selected></option>
															<option value="Mumbai">Mumbai</option>
															<option value="Indore">Indore</option>
															<option value="Pune">Pune</option>
														</select> <label for="floatingSelect">Select City</label>
													</div>
												</div>



												<div class="col-md">
													<div class="form-floating mb-3">
														<input type="text" class="form-control" id="gg"
															placeholder="name" name="priority" value="">
														<label for="floatingInput" class="dm">Priority</label>
													</div>
												</div>
											</div>



										</div>
										<div
											class="modal-footer border-top-0 pb-5 d-flex justify-content-center">

											<button type="submit"
												class="btn btn-success  text-white btn-lg "
												data-bs-dismiss="modal">Save</button>
											<button type="button"
												class="btn btn-info  text-white btn-lg "
												data-bs-dismiss="modal">Cancel</button>
										</div>
									</form>
								</div>


							</div>
						</div>

	<script>
	
	console.log("yeahhhhhhkkkk")
	function updateTask(id, name, assignee, discription ,duedate, city, priority) {
  console.log("Success!");  


  

  
  $('#aa').attr('value' , id);
  $('#bb').attr('value' , name);
  $('#cc').attr('value' , assignee);
  $('#dd').attr('value' , discription);
  $('#ee').attr('value' , duedate);
  $('#ff').attr('value' , city);
  $('#gg').attr('value' , priority);
  
  

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
        td = tr[i].getElementsByTagName("td")[2];
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
    
/*     function search1() {
    	console.log("fddsfds")
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("myInput1");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
          td = tr[i].getElementsByTagName("td")[4];
          if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
              tr[i].style.display = "";
            } else {
              tr[i].style.display = "none";
            }
          }
        }
      } */
    
    
    function validateForm() {
    	  let x = document.forms["myForm"]["taskName"].value;
    	  if (x == "") {
    	    alert(" taskname must be filled out");
    	    return false;
    	  }
    	}
  </script>


</body>

</html>
</body>
</html>