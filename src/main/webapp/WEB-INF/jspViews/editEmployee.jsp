<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" />
<script src="https://cdn.fancygrid.com/fancy.min.js"></script>

<style>
	#card-table
{
     width: 200px;
    height: 240px;
    overflow:scroll;
}

</style>

</head>
<body class="bg-lightgrey">

	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<div class="border-end bg-lightgrey" id="sidebar-wrapper">
			<div class="sidebar-heading border-bottom bg-dark text-white">
			<img alt="realcoderz" src="${pageContext.request.contextPath}/resources/assets/cropped-logowhitetexttransparent.png" style="height: 50px">
			</div>
			<div class="list-group list-group-flush ">
				<a
					class="list-group-item list-group-item-action list-group-item-light p-3 bg-dark text-active"
					href="${pageContext.request.contextPath}/admin.html">Dashboard</a>

				<a
					class="list-group-item list-group-item-action list-group-item-light p-3 bg-dark text-white"
					href="#addEmployee" data-toggle="modal" data-target="#addEmployee">Add
					Employee</a> <a
					class="list-group-item list-group-item-action list-group-item-light p-3 bg-dark text-white"
					href="#addCompliance" data-toggle="modal"
					data-target="#addCompliance">Add New RL</a>  


				<!--for Admin specific functionality starts-->

				<a href="#department-list"
					class="list-group-item list-group-item-action list-group-item-light p-3 bg-dark text-white"
					data-toggle="collapse">Departments</a>

				<div id="department-list" class="collapse  bg-dark text-white">
					<ul class="">


						<c:forEach var="entry"  items="${sessionScope.allDepartments}">


							<li><a href="#"
								class="list-group-item list-group-item-action list-group-item-light p-3 bg-dark text-white">${entry.value.departmentName}</a></li>
						</c:forEach>

						<li><form:form modelAttribute="department"
								action="${pageContext.request.contextPath}/createDepartment.html"
								method="post">


								<form:hidden path="departmentId" />


								<form:input path="departmentName" id="departmentName" />
								<form:errors path="departmentName" />

								<form:hidden path="departmentId" id="departmentId" />


								<input type="submit"  value="Add" class="btn-success">


							</form:form></li>

					</ul>
				</div>

				<!--for admin specific functionality ends-->

				

				
			</div>
		</div>
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<nav
				class="navbar navbar-expand-lg navbar-dark bg-primary border-bottom">
				<div class="container-fluid">
					<button class="btn btn-primary" id="sidebarToggle">Menu</button>
					<button class="navbar-toggler text-white" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon navbar-light"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ms-auto mt-2 mt-lg-0 ">
							

							<li class="nav-item active">
							</li>

							<li class="nav-item dropdown text-white"><a
								class="nav-link dropdown-toggle text-white" id="navbarDropdown"
								href="#" role="button" data-bs-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">${sessionScope.employee.firstName } ${sessionScope.employee.lastName}</a>
								<div class="dropdown-menu dropdown-menu-end bg-dark"
									aria-labelledby="navbarDropdown">
									<a class="dropdown-item text-white" href="${pageContext.request.contextPath}/adminProfile.html">Profile</a> <a
										class="dropdown-item text-white" href="${pageContext.request.contextPath}/logout.html">Logout</a>


								</div></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Page content-->


			<!-- 	 Cards starts here -->

			
			<div class="container-fluid bg-lightgrey">
<h2 align="center" class="text-active">Logged in as Admin</h4> 	 <h5 class="text-active">${sessionScope.message}</h5>	
			<br>			
			

				<div class="row">
					
					<div class="col-sm-12">
						<!-- <div class="card">
							<div class="card-body">
								<h5 class="card-title bg-dark" style="color: #fecb32">All Compliance</h5> Card Starting tags commented-->
								
								<!-- Card content -->



							<table class="table" align="center"
								style="width: 40%; margin-top: 40px;">
								<form:form modelAttribute="employee"
									action="${pageContext.request.contextPath}/updateEmployee.html"
									method="post">
									<form:hidden path="empId" />
									<form:hidden path="dob" />
									<form:hidden path="email" />
									<form:hidden path="departmentName" />
									<form:hidden path="departmentId" />
									<form:hidden path="userId" />
									<form:hidden path="password" />
									<form:hidden path="role" />
									<tr>
										<th>First Name</th>
										<td>
										<form:input path="firstName" />
										<form:errors path="firstName" />
											
										</td>


						</tr>

						<tr>
							<th>Last Name</th>
							<td>
							<form:input path="lastName" id="lastname" /> 
							<form:errors path="lastName" />
							</td>
						</tr>

						<tr>
					<th>DOB</th>
					<td>
						<form:input path="dob" id="dob" />
						<form:errors path="dob" />
					</td>
					
				</tr>

									<tr>
									<td><input type="submit" value="Update"
											class="btn-success"></td>
									<td><input type="reset" value="Cancel" class="btn-danger"></td>
									
									
									</tr>
								</form:form>
								
								
				
					</table>




									
									
								
							<!-- </div>
						</div> cards ending tags commented --></div>
										
				</div>

				<div id="container"></div>

			</div>
		</div>
	</div>



	<!-- 	Cards end here -->

	<!--Start Modal Add Employee -->
<div id="addEmployee" class="modal fade bg-lightgrey" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Employee</h4>
      </div>
      <div class="modal-body">
        <jsp:include page="addEmployee.jsp"></jsp:include>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
	<!--ends Modal Add Employee -->
	
	
	<div id="addCompliance" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Employee</h4>
      </div>
      <div class="modal-body">
        <jsp:include page="addCompliance.jsp"></jsp:include>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>


<%-- <div id="profile" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Employee</h4>
      </div>
      <div class="modal-body">
        <jsp:include page="profile.jsp"></jsp:include>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div> --%>
	
	
	<script type="text/javascript">
	
	$("#submit").submit(function(e){
        
        console.log('function called')
      $.ajax({
           url: 'http://localhost:8082/employee_management/saveDepartment.html',
           type: 'post',
           data:$(this).serialize(),
           success: function() {
               alert('success');
           },
          error: function(){
              alert('failed');
          }
       })        
  });
	
	

	
	</script>
	
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"> </script>
	<!-- Core theme JS-->
	<script
		src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>


</body>
</html>