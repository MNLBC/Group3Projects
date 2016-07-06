<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<center>
	<h3>Register an Account!</h3>
	<form action="user">
	
		Username &nbsp;<input type="text" name="userName"> <br/>
		Password &nbsp;<input type="password" name="userPassword"> <br/>
		
		<input type="hidden" name="method" value="validateLogin"> <br/>
		
		<input type="submit" value="Login">
		
	</form>
	</center>
	
</body>
</html>