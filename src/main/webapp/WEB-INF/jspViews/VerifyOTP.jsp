<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
	th:replace="base::layout(~{::section})">
<head>
<meta charset="UTF-8">
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
            <h2>Employee Management<br> One Time Password Verification</h2>
            <p>Enter otp to verify</p>
         </div>
      </div>

<div class="main">
         <div class="col-md-8 ">
            <div class="login-form">
<form action="verify.html">
                  <div class="form-group">
                     <label>Enter One time password:</label>
                     <input type="text" name="otp" placeholder="Enter your One Time Password">
                  </div>
                  
                  <button type="submit" id="button" class="btn btn-black">Verify</button>
                  
               </form>
            </div>
         </div>
      </div>



<!--  <form action="verify.html">
<table>
<tr>

<td><input type="text" name="otp" placeholder="Enter your One Time Password"></td>

</tr>
</table>
<input type="submit" value="Verify">
</form>
-->

</body>
</html>