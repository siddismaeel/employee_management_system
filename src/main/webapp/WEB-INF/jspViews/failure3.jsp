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
<h2>faliure 3 to check logout</h2>
<c:out value="No userId = ${userId}"></c:out>
<c:out value="No Employee = ${eBean}"></c:out>
<h1>you have been logged out</h1>

</body>
</html>