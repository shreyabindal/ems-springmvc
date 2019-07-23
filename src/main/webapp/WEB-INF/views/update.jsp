<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees Info</title>
<%@ page isELIgnored="false"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<h3 id="form_header" class="text-warning" align="center">Employee
			Form</h3>
		<div></div>

		<!-- User input form to add a new user or update the existing user-->

		<form:form id="employee_form" modelAttribute="employee"
			method="POST" action="./save">
			<div class="form-group">
				<label for="name">Id: </label>
				<form:input id="id" cssClass="form-control" path="id" />
				<font color="red"><form:errors path="id"></form:errors></font>
			</div>
			<div class="form-group">
				<label for="name">Name: </label>
				<form:input id="name" cssClass="form-control" path="name" />
				<font color="red"><form:errors path="name"></form:errors></font>
			</div>

			<div class="form-group">
				<label for="lastName">Last Name: </label>
				<form:input id="lastName" cssClass="form-control" path="lastName" />
				<font color="red"><form:errors path="lastName"></form:errors></font>
			</div>

			<div class="form-group">
				<label for="birthDate">Birth Date: </label>
				<form:input id="birthDate" cssClass="form-control" path="birthDate" />
				<font color="red"><form:errors path="birthDate"></form:errors></font>
			</div>

			<div class="form-group">
				<label for="role">Role: </label>
				<form:input id="role" cssClass="form-control" path="role" />
				<font color="red"><form:errors path="role"></form:errors></font>
			</div>

			<div class="form-group">
				<label for="department">Department: </label>
				<form:input id="department" cssClass="form-control"
					path="department" />
				<font color="red"><form:errors path="role"></form:errors></font>
			</div>

			<div class="form-group">
				<label for="email">Email: </label>
				<form:input id="email" cssClass="form-control" path="email" />
				<font color="red"><form:errors path="email"></form:errors></font>
			</div>

			<button id="updateBtn" type="submit" class="btn btn-primary">Update</button>
		</form:form>
	</div>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>