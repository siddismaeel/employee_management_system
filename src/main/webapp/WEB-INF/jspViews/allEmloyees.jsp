<div>
	<h3>All Employees</h3>

	<c:if test="${not empty allEmployees}">
		<table border="2" class>
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>DOB</th>


			</tr>


			<c:forEach var="emp" items="${allEmployees}">
				<tr>
					<td>${emp.empId}</td>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<td>${emp.dob}</td>
				</tr>
			</c:forEach>

		</table>

	</c:if>
	<c:if test="${empty allEmployees}">

		<h2>No Employees Available</h2>

	</c:if>

</div>