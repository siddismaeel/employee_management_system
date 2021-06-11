<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>

	<table class="table">
	<tr>
		<th>Name:</th>
		<td>${sessionScope.employee.firstName} ${sessionScople.employee.lasttName}</td>
	</tr>
	
	<tr>
		<th>Email:</th>
		<td>${sessionScope.employee.email}</td>
	</tr>
	
	<tr>
		<th>Department:</th>
		<td>${sessionScope.employee.departmentName}</td>
	</tr>
	
	
	<tr>
		<th>User ID:</th>
		<td>${sessionScope.employee.userId}</td>
	</tr>
	
	</table>

</center>

</body>
</html>