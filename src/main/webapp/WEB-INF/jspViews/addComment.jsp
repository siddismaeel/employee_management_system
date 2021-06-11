<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Employee Dashboard</title>

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
						class="fa fa-user fa-fw"></i><b>${sessionScope.employee.firstName} ${sessionScope.employee.lastName}</b> <i
						class="material-icons right"></i></a></li>
			</ul>
		</nav>
		<!-- Dropdown Structure -->
		<ul id="dropdown1" class="dropdown-content">
			<li><a href="#"><i class="fa fa-user fa-fw"></i> My Profile</a>
			</li>
			<li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
			</li>
		</ul>

		<!--/. NAV TOP  -->
		<!--/. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">

					<li><a href="index.html" class="waves-effect waves-dark"><i
							class="fa fa-dashboard"></i> Dashboard</a></li>
					

				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">Logged In As Employee</h1>
				<span></span>

			</div>

			<div id="page-inner">

				<div class="row">
					<div class="col-md-12 col-sm-12">
							<div class="card teal">
								<div class="card-content white-text">
									<span class="card-title">Add Comments</span>
								<form:form modelAttribute="statusReport" action="${pageContext.request.contextPath}/addComment.html" method="post">
									<form:hidden path="empId"/>
									<form:hidden path="departmentId"/>
									<form:hidden path="complianceId"/>		
										<tr>
										<td>Comments</td>
										<td><form:input path="comments"/></td>
									</tr>
									
									

								<input type="submit" value="Add" class="btn-success"> <input
										type="reset" value="Cancel" class="btn-danger">
								</form:form>
									
								</div>
								
									

							
							</div>
						</div>
					</div>

					
					
					</div>
					
					
					
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
