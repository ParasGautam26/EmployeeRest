<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.nagarro.dto.Employee"%>
<%@ page import="java.util.*"%>
<%@page import="com.nagarro.dto.LoginUser"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="homepage.jsp">HR Management</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="logout.jsp"> ${param.username} Logout</a></li>
		</ul>
	</div>
	</nav>

	<br>
	<div class="container">
		<p>Upload in CSV format to upload employee details</p>
		<form method="post" action="employee" enctype="multipart/form-data">
			<input type="file" name="file" required="required" /> <input
				type="submit" value="UPLOAD">
		</form>
		<br />
		<p>Click to Download all employee details</p>
		<form method="post" action="employee/download"
			enctype="multipart/form-data">
			<input type="submit" value="DOWNLOAD">
		</form>
	</div>
	<div class="container">
		<div class="row">


			<div class="col-md-12">
				<center><h4>Employee Details</h4></center>
				<div class="table-responsive">


					<table border="1" align="center">
						<tr>
							<th>Serial no.</th>
							<th>Employee Code</th>
							<th>Employee Name</th>
							<th>Location</th>
							<th>Email</th>
							<th>Date of Birth</th>
							<th>Action</th>
						</tr>
						<c:forEach items="${employees}" var="employee">
							<tr>
								<td>${employee.id}</td>
								<td>${employee.employeeCode}</td>
								<td>${employee.employeeName}</td>
								<td>${employee.location}</td>
								<td>${employee.email}</td>
								<td>${employee.dateOfBirth}</td>
								<td>
									<form method="post" action="employee/edit">
										<input type="hidden" value="${employee.id}" name="id" /> <input
											type="hidden" value="${employee.employeeCode}"
											name="employeeCode" /> <input type="hidden"
											value="${employee.employeeName}" name="employeeName" /> <input
											type="hidden" value="${employee.location}" name="location" />
										<input type="hidden" value="${employee.email}" name="email" />
										<input type="hidden" value="${employee.dateOfBirth}"
											name="dateOfBirth" /> <input type="submit" value="EDIT">
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>

	<br />

</body>
</html>