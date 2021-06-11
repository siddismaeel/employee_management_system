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

<center>

<form:form modelAttribute="storedFile" action="savefile.html" enctype="multipart/form-data" method="post">
	
	<form:input path="fileTitle"/>
	<form:input type="file" path="file"/>
	
<input type="submit"
				value="Upload File" />
		
</form:form>
		<%-- <form action="savefile.html" method="post" enctype="multipart/form-data">
		
		<input type="text" name="fileTitle">
			Select File: <input type="file" name="file" /> <input type="submit"
				value="Upload File" />
		</form>
		 --%>
		
	</center>
</body>
</html>