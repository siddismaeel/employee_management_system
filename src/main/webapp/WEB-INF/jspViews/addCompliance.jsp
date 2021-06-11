<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Add Compliance</h2>
		<form:form modelAttribute="compliance" method="POST"
			action="${pageContext.request.contextPath}/createRL.html" enctype="multipart/form-data">

			<br>

			<table class="table">
				<tr>
					<th>RL Type</th>
					<td><form:input path="rlType" id="rlType" /></td>
				</tr>

				<tr>
					<th>RL Title:</th>
					<td><form:input path="fileTitle" id="details" /></td>
				</tr>

				<tr>
					<th>Chose File::</th>
					<td><form:input type="file" path="file" id="file" /></td>
				</tr>

				<tr>

					<th>Department</th>
					<td><form:select path="departmentId" id="rlDepartmentId">

							<form:option value="0">Select Department</form:option>
							<c:forEach var="entry" items="${sessionScope.allDepartments}">


								<form:option value="${entry.key}">${entry.value.departmentName}</form:option>

							</c:forEach>

						</form:select>
			</table>

			<input type="submit" id="addRl" value="Add">

		</form:form>

		${departments[0].departmentName}

	</center>

	<script type="text/javascript">
		$(document).ready(
				function() {
					$("#addRl").submit(
							function() {
								var rlType = $("#rlType").val();
								var details = $("#details").val();
								var departmentId = $("#rlDepartmentId").val();

								if ((rlType === '' && 
										details === ''
										&& departmentId === '0') 
										|| (rlType === 'Enter RL Type'
										&& details === 'Enter Details'
										&& departmentId === '0')){
									alert("Please Enter Right Credentials.");
									return false;
								} else if (rlType === '' ||  rlType === 'Enter RL Type') {
									alert("Please Enter RL Type");
									return false;
								} else if (details === '' || details === 'Enter Details') {
									alert("Please Enter Right Details");
									return false;
								} else if (departmentId === '0') {
									alert("Please Select DepartmentId");
									return false;
								}
							});
				});
		
	</script>

</body>
</html>