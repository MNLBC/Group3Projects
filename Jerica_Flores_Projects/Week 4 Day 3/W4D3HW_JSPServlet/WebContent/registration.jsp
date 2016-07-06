<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body bgcolor="gren">
<center><h1>Registration Form</h1>

<form method="POST" action="RegisterServlet">
<table style="with: 50%" border="1">
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="fullname" required/></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="texRDt" name="username" required/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required/></td>
				</tr>
				<tr>
					<td>Email address</td>
					<td><input type="email" name="email" required/></td>
				</tr>
			</table>
<input type="submit" name="btnSubmit" value="Register"/>
<input type="reset" value="Clear">
</form>
</center>
</body>
</html>