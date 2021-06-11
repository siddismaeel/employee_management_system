<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="employee" modelAttribute="department" action="${pageContext.request.contextPath}/addEmployee.html" method="post">
	<table>
	
	<form:hidden path="empId"/>
	<tr>
		<td>Emplyee First Name</td>
		<td><form:input path="firstName"/></td>
	</tr>
	<tr>
		<td>Emplyee Last Name</td>
		<td><form:input path="lastName"/></td>
	</tr>
	<tr>
		<td>DOB</td>
		<td><form:input path="dob"/></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><form:input path="email"/></td>
	</tr>
	
	<%-- <tr>
		<td>Department Name</td>
		<td><form:input path="departmentBean.departmentName"/></td>
	</tr> --%>
	
	<tr>
		<td><input type="submit"></td>
		<td></td>
	</tr>
	</table>
	
	</form:form>
	
	
</body>
</html>