<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Comment</title>
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
	href="http://localhost:8080/employee_management/resources/css/styles.css"
	rel="stylesheet" />


<style>
	#card-table
{
     width: 200px;
    height: 240px;
    overflow:scroll;
}

</style>

</head>
<body>



	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<div class="border-end" id="sidebar-wrapper">
			<div class="sidebar-heading border-bottom bg-dark text-white">REALCODERZ</div>
			<div class="list-group list-group-flush ">
				<a
					class="list-group-item list-group-item-action list-group-item-light p-3 bg-dark text-white"
					href="${pageContext.request.contextPath}/employee.html">Dashboard</a>


				<!--for Admin specific functionality starts-->


				<!--for Admin specific functionality starts-->

				
				<!--for admin specific functionality ends-->

				<!--for admin specific functionality ends-->

			</div>
		</div>
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<nav
				class="navbar navbar-expand-lg navbar-dark bg-dark border-bottom">
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
						<li class="nav-item active"><a class="nav-link text-white"
							href="#!">Home</a></li>

						<li class="nav-item dropdown text-white"><a
							class="nav-link dropdown-toggle text-white" id="navbarDropdown"
							href="#" role="button" data-bs-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">${sessionScop.employee.firstName } ${sessionScope.employee.lastName}</a>
							<div class="dropdown-menu dropdown-menu-end bg-dark"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item text-white" href="#!">Profile</a> <a
									class="dropdown-item text-white" href="${pageContext.request.contextPath}/logout.html">Logout</a>


							</div></li>
					</ul>
				</div>
			</div>
			</nav>
			<!-- Page content-->
			<div class="container-fluid">


				<!--   form starts here -->
		<table class="table">
				<form:form modelAttribute="statusReport" action="${pageContext.request.contextPath}/commentsEdit.html" method="post">
									
									
									<form:hidden path="statusReportId"/>
									
										<tr>
										<td>Comments</td>
										<td><form:textarea path="comments"/></td>
									</tr>
									
									<tr>

									<td><input type="submit" value="Add" class="btn-success"> </td>
								
									<td><inputtype="reset" value="Cancel" class="btn-danger"/></td>
										
								</tr>
								</form:form>
				
		</table>
					<!--   form ends here -->
				</div>
			</div>
		</div>
		
		
		<!--Start Modal Add Employee -->

		
		
		<!-- Bootstrap core JS-->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js">
        
             $("#department").submit(function(e){
                 
                 console.log('function called')
               $.ajax({
                    url: 'http://localhost:8080/employee_management/saveDepartment.html',
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
		<!-- Core theme JS-->
		<script
		src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>

</body>
</html>