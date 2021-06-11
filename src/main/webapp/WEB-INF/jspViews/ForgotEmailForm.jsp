<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/assets/css/login.css">
<title>Insert title here</title>
</head>
<body>
<div class="sidenav">
         <div class="login-main-text">
            <h2>Employee Management<br> Forgot Password</h2>
           <p>Enter your registered email address</p>
         </div>
      </div>


<div class="main">
         <div class="col-md-8 ">
            <div class="login-form">
               <form action="sendOTP.html" method="post">
                  <div class="form-group">
                     <label>Email Address:</label>
                     <input type="email" name="email" placeholder="Enter your email">
                  </div>
                  
                  <button type="submit" id="button" class="btn btn-black">Send Otp</button>
                  
               </form>
            </div>
         </div>
      </div>


<!--<form:form action="sendOTP.html" method="post">
<table>
<tr>
<th>Email Address:</th>

    <td><input type="email" name="email" placeholder="Enter your email"></td> 

</tr>
</table>
<input type="submit" value="Send OTP">
</form:form>
-->
</body>

</html>