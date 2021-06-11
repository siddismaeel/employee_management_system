<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>faliure 2 to check session</h2>
<c:out value="you entered userId = ${userId}"></c:out>
<c:out value="Employee = ${eBean}"></c:out>
<a href="logout.html">click me to logout</a>

</body>
</html>