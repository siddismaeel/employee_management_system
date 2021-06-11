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
		<h2>Add Employee</h2>
		<form:form modelAttribute="employee" method="POST"
			action="${pageContext.request.contextPath}/addEmployee.html">

			<br>

			<table class="table">
				<tr>
					<th>First Name</th>
					<td><form:input path="firstName" id="firstname"/></td>
					<td><form:errors path="firstName"/></td>
				</tr>
				
				<tr>
					<th>Last Name</th>
					<td>
					<form:input path="lastName" id="lastname"/>
					
					<form:errors path="lastName"/>
					
					</td>
				</tr>
				
				<tr>
					<th>DOB</th>
					<td>
						<form:input path="dob" id="dob"/>
						<form:errors path="dob"/>
					</td>
					
				</tr>
				
				<tr>
					<th>Email ID</th>
					<td>
						<form:input path="email" id="email"/>
					</td>
					<td><form:errors path="email"/></td>
				</tr>
				
				<tr>
					<th>Role</th>
					<td>
						<form:select path="role" id="role">
							<form:option value="" label="--Select--" />
							<form:option value="TL" label="TeamLead" />
							<form:option value="M" label="Manager" />
							<form:option value="SE" label="Software Engineer" />
							<form:option value="HOD" label="Head Of Department" />
						</form:select>
						
					</td>
					<td><form:errors path="role"/></td>
				</tr>
				<tr>
				
				<td>Select Department</td>
				<td>
				<form:select path="departmentId" id="EmployeeDepartmentId">
						<form:option value="0">Select Department</form:option>	
						<c:forEach var="entry" items="${sessionScope.allDepartments}">
						
							<form:option value="${entry.key }">${entry.value.departmentName}</form:option>
							
						</c:forEach>
					</form:select>	
					</td>
					</tr>	
			</table>

		<input type="submit" value="Add" id="addEmployee"/>

		</form:form>
		
		${departments[0].departmentName}
		
	</center>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$("#addEmployee").submit(function() {
			var firstName = $("#firstname").val();
			var lastName = $("#lastname").val();
			var dob = $("#dob").val();
			var email = $("#email").val();
			var role = $("#role").val();
			var departmentId = $("#EmployeeDepartmentId").val();
			
			
			
			 if (firstName === '' && lastName === '' && dob===''&& email === ''&& role === ''&& department === '0') {
				alert("Please Enter Right Credentials.");
				return false;
			} else if (firstName === '') {
				alert("Please Enter First Name");
				return false;
			} else if (lastName === '') {
				alert("Please Enter last Name");
				return false;
			} else if (dob === '') {
				alert("Please Enter Date-Of-Birth");
				return false;
			}else if (email === '') {
				alert("Please Enter Correct Email");
				return false;
			}else if (role === '') {
				alert("Please Select Role");
				return false;
			}else if (departmentId === '0') {
				alert("Please Select Department");
				return false;
			}

		});
	});
	
	</script> 
</body>
</html>