<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<form action="update" method="post">

		<input type="hidden" value="${employee.id}" name="id" /> <input
			type="text" value="${employee.employeeCode}" name="employeeCode"
			readonly="readonly" /> <input type="text"
			value="${employee.employeeName}" name="employeeName" /> <input
			type="text" value="${employee.location}" name="location" /> <input
			type="email" value="${employee.email}" name="email" /> <input
			type="date" value="${employee.dateOfBirth}" name="dateOfBirth" /> <input
			type="submit" value="SAVE">

	</form>
</body>
</html>