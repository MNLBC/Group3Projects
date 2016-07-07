<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<center>
	<h2>Register an Account!</h2>
	</center>
	<form id="loginForm" name="loginForm" action="user" class="mainForm"
		onsubmit="return validateRegistrationForm()">

		Username &nbsp;<input type="text" name="userName"> <br />
		Password &nbsp;<input type="password" name="userPassword"> <br />
		Confirm Password &nbsp;<input type="password" name="confirmPassword">
		<br /> Full Name &nbsp;<input type="text" name="fullName"> <br />
		Email Address &nbsp;<input type="text" name="email"> <br />
		Address &nbsp;<input type="text" name="address"> <br />
		Mobile Number &nbsp;<input type="text" name="mobileNumber"> <br />


		<input type="hidden" name="userRole" value="customer"> <br />
		<input type="hidden" name="method" value=registerUser> <br />

		<input type="submit" value="Register">
	</form>
</body>
<script src="js/validateRegistrationForm.js"></script>
</html>