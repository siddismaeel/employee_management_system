<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Admin Dashboard</title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href='http://localhost:8080/employee_management/resources/assets/materialize/css/materialize.min.css'
	media="screen,projection" />
<!-- Bootstrap Styles-->
<link
	href="http://localhost:8080/employee_management/resources/assets/css/bootstrap.css"
	rel="stylesheet" />
<!-- FontAwesome Styles-->
<link
	href="http://localhost:8080/employee_management/resources/assets/css/font-awesome.css"
	rel="stylesheet" />
<!-- Morris Chart Styles-->
<link
	href="http://localhost:8080/employee_management/resources/assets/js/morris/morris-0.4.3.min.css"
	rel="stylesheet" />
<!-- Custom Styles-->
<link
	href="http://localhost:8080/employee_management/resources/assets/css/custom-styles.css"
	rel="stylesheet" />
<!-- Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet"
	href="http://localhost:8080/employee_management/resources/assets/js/Lightweight-Chart/cssCharts.css">
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand waves-effect waves-dark" href="index.html"><i
					class="large material-icons">track_changes</i> <strong>REALCODERZ</strong></a>

				<div id="sideNav" href="">
					<i class="material-icons dp48">toc</i>
				</div>
			</div>

			<ul class="nav navbar-top-links navbar-right">

				<li><a class="dropdown-button waves-effect waves-dark"
					href="#!" data-activates="dropdown1"><i
						class="fa fa-user fa-fw"></i> <b>${sessionScope.employee.firstName} ${sessionScope.employee.lastName}</b> <i
						class="material-icons right">arrow_drop_down</i></a></li>
			</ul>
		</nav>
		<!-- Dropdown Structure -->
		<ul id="dropdown1" class="dropdown-content">
			<li><a href="#"><i class="fa fa-user fa-fw"></i> My Profile</a>
			</li>
			<li><a href="${pageContext.request.contextPath}/logout.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
			</li>
		</ul>

		<!--/. NAV TOP  -->
		<!--/. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">

					<li><a href="./admin.html" class="waves-effect waves-dark" style="color:white"><i
							class="fa fa-dashboard"></i> Dashboard</a></li>
					<li><a href="${pageContext.request.contextPath}/showAddEmloyee.html" class="waves-effect waves-dark" style="color:white"><i
							class="fa fa-user"></i> Add Employee</a></li>
					<li><a href="chart.html" class="waves-effect waves-dark" style="color:white"><i
							class="fa fa-user"></i> Update Employee</a></li>
					<li><a href="${pageContext.request.contextPath}/addCompliancePage.html"
						class="active-menu waves-effect waves-dark" style="color:white"><i
							class="fa fa-qrcode"></i> Add New RL</a></li>

				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">Logged In As Admin</h1>
				<span>${message}</span>

			</div>

			<div id="page-inner">

				<div class="row">
					<div class="col-md-7 col-sm-7">
						<div class="card teal">
							<div class="card-content white-text">
								<span class="card-title">All Employees</span>

								<c:if test="${not empty allEmployees}">
									<table class="table">
										<tr>
											
											<th>First Name</th>
											<th>Last Name</th>
											<th>Email</th>
											<th>DOB</th>
											<td>Action</td>
											<td>Action</td>

										</tr>


										<c:forEach var="emp" items="${allEmployees}">
											<tr>
												
												<td>${emp.firstName}</td>
												<td>${emp.lastName}</td>
												<td>${emp.email}</td>
												<td>${emp.dob}</td>
												<td><a href="${pageContext.request.contextPath}/editForm.html?empId=${emp.empId}" style="color:white">Edit</a></td>
												<td><a href="${pageContext.request.contextPath}/deleteEmployee.html?empId=${emp.empId}" style="color:white">Delete</a></td>
												
											</tr>
										</c:forEach>

									</table>

								</c:if>
								<c:if test="${empty allEmployees}">

									<h2>No Employees Available</h2>

								</c:if>


								<div class="card-action">
									<a href="#"></a> <a href="#"></a>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-5 col-sm-5">
							<div class="card teal">
								<div class="card-content white-text">
									<span class="card-title">Add Employee</span>

									<form:form modelAttribute="employee"
										action="${pageContext.request.contextPath}/addEmployee.html"
										method="post">
										<table>

											<form:hidden path="empId" />
											<tr>
												<td>Emplyee First Name</td>
												<td><form:input path="firstName" /></td>
											</tr>
											<tr>
												<td>Emplyee Last Name</td>
												<td><form:input path="lastName" /></td>
											</tr>
											<tr>
												<td>DOB</td>
												<td><form:input path="dob" /></td>
											</tr>
											<tr>
												<td>Email</td>
												<td><form:input path="email" /></td>
											</tr>
											<form:hidden path="departmentId"/>
											<tr>
												<td>Department</td>
												<td><form:input path="departmentName" /></td>
											</tr>
											
											<tr>
												<td>Role</td>
												<td><form:input path="role" /></td>
											</tr>

											
											
										</table>
								</div>
								
									<input type="submit" value="Add" class="btn-success"> <input
										type="reset" value="Cancel" class="btn-danger">

								</form:form>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 col-sm-6">
							<div class="card teal">
								<div class="card-content white-text">
									<span class="card-title">Create DepartmentL</span>
									 <form:form modelAttribute="department" action="${pageContext.request.contextPath}/createDepartment.html" method="post">
									<table>
										
										<form:hidden path="departmentId" />
											<tr>
												<td>Department Name</td>
												<td><form:input path="departmentName"/></td>
											</tr>

											<form:hidden path="departmentId"/>
											
									</table>
									<input type="submit" value="Add" class="btn-success"> <input
										type="reset" value="Cancel" class="btn-danger">
								
								</form:form>
								</div>
								
									
							</div>
						</div>
						
						
						
						<div class="col-md-6 col-sm-6">
							<div class="card teal">
								<div class="card-content white-text">
									<span class="card-title">Regulations</span>
									<c:if test="${not empty allCompliance}"> 
									<table class="table">
										<tr>
										<th>RL ID</th>
										<th>RL Type</th>
										<th>Details</th>
										<th>Create Date</th>
										<th>Department Name</th>
										<th>Action</th>
										</tr>
										<c:forEach var="rl" items="${allCompliance}">
										
										<tr>
											<td>${rl.complianceId}</td>
											<td>${rl.rlType}</td>
											<td>${rl.details}</td>
											<td>${rl.createDate}</td>
											<td>${rl.departmentName}</td>
											<td>
											
												<a href="${pageContext.request.contextPath}/statusReport.html?complianceId=${rl.complianceId}">Show Comments</a>
											
											</td>
											
										</tr>
										
										</c:forEach>
										
											
									</table>
								</c:if>
										<c:if test="${empty allCompliance}">

									<h2>No Compliance Available</h2>

								</c:if>
									
								</div>
								
								
								
							</div>
						</div>
						
					</div>
					<td>
					
					
					<footer>
							<p>
								All right reserved. Template by: <a href="#">REALCODERZ</a>
							</p>
						</footer>
				</div>
				<!-- /. PAGE INNER  -->
			</div>
			<!-- /. PAGE WRAPPER  -->

			<!-- /. WRAPPER  -->
			<!-- JS Scripts-->
			<!-- jQuery Js -->
			<script
				src="http://localhost:8080/employee_management/resources/assets/js/jquery-1.10.2.js"></script>

			<!-- Bootstrap Js -->
			<script
				src="http://localhost:8080/employee_management/resources/assets/js/bootstrap.min.js"></script>

			<script
				src="http://localhost:8080/employee_management/resources/assets/materialize/js/materialize.min.js"></script>

			<!-- Metis Menu Js -->
			<script
				src="http://localhost:8080/employee_management/resources/assets/js/jquery.metisMenu.js"></script>
			<!-- Morris Chart Js -->
			<script
				src="http://localhost:8080/employee_management/resources/assets/js/morris/raphael-2.1.0.min.js"></script>
			<script
				src="http://localhost:8080/employee_management/resources/assets/js/morris/morris.js"></script>


			<script
				src="http://localhost:8080/employee_management/resources/assets/js/easypiechart.js"></script>
			<script
				src="http://localhost:8080/employee_management/resources/assets/js/easypiechart-data.js"></script>

			<script
				src="http://localhost:8080/employee_management/resources/assets/js/Lightweight-Chart/jquery.chart.js"></script>

			<!-- Custom Js -->
			<script
				src="http://localhost:8080/employee_management/resources/assets/js/custom-scripts.js"></script>
			<script>
				$(document).ready(function() {
					$('ul.tabs').tabs();
					$('.collapsible').collapsible({
						accordion : false, // A setting that changes the collapsible behavior to expandable instead of the default accordion style
						onOpen : function(el) {
							alert('Open');
						}, // Callback for Collapsible open
						onClose : function(el) {
							alert('Closed');
						} // Callback for Collapsible close
					});
				});
			</script>
</body>

</html>
