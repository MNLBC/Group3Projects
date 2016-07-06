<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homework Week 4 Day 3</title>

<style type="text/css">
input, textarea {
	padding: 9px;
	border: solid 1px #999999;
	outline: 0;
	font: normal 13px/100% Verdana, Tahoma, sans-serif;
	width: 92%;
	background: #FFFFFF;
	border-radius: 4px;
}

textarea {
	width: 400px;
	max-width: 400px;
	height: 150px;
	line-height: 150%;
	border-radius: 4px;
}

input:hover, textarea:hover, input:focus, textarea:focus {
	border-color: #E77600; box-shadow : 0px 0px 3px 2px rgba( 228, 121, 17,
	0.5);
	border-radius: 5px;
	box-shadow: 0px 0px 3px 2px rgba(228, 121, 17, 0.5);
}

.form label {
	margin-left: 10px;
	color: #333333;
}

.submit input {
	width: 35%;
	padding: 9px 10px;
	background: #ffcc33;
	border: 1px;
	border-style: outset;
	font-size: 14px;
	color: #FFFFFF;
	outline-style: double;
	outline-color: 993300;
	border-radius: 5px;
}



form {
	
	padding: 15px;
	border: 1px;
	border-style: solid;
	border-color: #CCCCCC;
	border-radius: 5px;
	width: 20%;
	margin: 0 auto;
}
input[type='number'] {
    -moz-appearance:textfield;
}

</style>
</head>
<body style="background-color:darkblue; color:white">



<center>
<marquee><h1>Melvin Yu Fan Page</h1></marquee>
<form class="form" method="post" action="saveToDB"  >
<h2>Registration Form</h2>
<table>
<tr>
<td>
Fullname:
</td>
<td> 
<input type="text" name="fname" required/>
</td>
</tr>
<tr>
<td>
Username: 
</td>
<td><input type="text" name="uname" required/></td>
</tr>
<tr>
<td>
Password: </td><td><input type="password" name="pass" required/></td>
</tr>
<tr>
<td>
Email:
</td> 
<td><input type="email" name="email" required/></td>
</tr>
<tr>
<td>
Phone: 
</td>
<td><input type="number" name="phone" required/></td>
</tr>
</table>

<p class="submit"><input type="submit" name="btnSubmit" value="Register!" ><input  type="reset"></p>
</form>
</center>

</body>
</html>