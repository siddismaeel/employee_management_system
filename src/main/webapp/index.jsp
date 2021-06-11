<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/assets/css/login.css">

<!--  employee_management/src/main/webapp/resources/assets/css/login.css-->

<title>Login Page</title>
</head>
<body>

<div class="sidenav">
         <div class="login-main-text">
            <h2>Employee Management<br> Login Page</h2>
            <p>Login from here to access.</p>
         </div>
      </div>
		
		<div class="main">
         <div class="col-md-8 ">
            <div class="login-form">
               <form action="validateLogin.html" method="POST">
                  <div class="form-group">
                     <label>User ID:</label>
                     <input type="text" id="name" name="userId" class="form-control" placeholder="Enter User-ID">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" id="password" name="password" class="form-control" placeholder="Enter Password">
                  
                  </div>
                  <button type="submit" id="button" class="btn btn-black">Login</button>
                  <a href="${pageContext.request.contextPath }/forgotpassword.html">Forgot Password</a>
               </form>
            </div>
         </div>
      </div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#button").click(function() {
				var name = $("#name").val();
				var password = $("#password").val();
				if (name === '' && password === '') {
					alert("Please Enter Right Credentials.");
					return false;
				} else if (name === '') {
					alert("Please Enter Right UserID");
					return false;
				} else if (password === '') {
					alert("Please Enter Right Password");
					return false;
				}

			});
		});
	</script>
</body>
</html>