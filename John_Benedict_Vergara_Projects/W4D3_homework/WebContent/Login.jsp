<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">





<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
<style type="text/css">
body {
	font: 16px Arial ;

}


form {
	border-style: ridge;
	font: Arial;
    width: 20%;
    align: center;
    padding: 15px;
}
footer{
    height: 100px; 
    width:100%;
    position: absolute;
    bottom: 0; 
    text-align: center;

}

container {
width: 300px;
margin: 0 auto;
padding: 10px;
border: 1px;
border-style: solid;
border-color: gray;
}
</style>
</head>

<body id="w2d4"><center>
<marquee><h1>Register Account Now!</h1></marquee><hr><br>
<br><br><br>
<div id = "container">
<form method = "POST" action="myFormAction"  style="border-radius:4px" width="100">

<div align="center"><h1>Create Account</h1></div>
<div align="left"><label><b>First Name:&nbsp;&nbsp;</label></b>
<span class="col2"><input name="fname" type="text" id="name" size="50%" tabindex="1" style="border-radius:4px; width:80%" required /></span>
</div><br>
<div align="left"><label><b>Last Name:&nbsp;&nbsp;</label></b>
<span class="col2"><input name="lname" type="text" id="name" size=50% tabindex="1" style="border-radius:4px; width:80%" required/></span>
</div><br>
<div align="left"><label><b>Username:&nbsp;&nbsp;</label></b>
<span class="col2"><input name="uname" type="text" id="name" size=50% tabindex="1" style="border-radius:4px; width:80%" required/></span>
</div><br>
<div align="left""><label><b>E-mail:&nbsp;&nbsp;</label></b>
<span><input name="email" class="input" type="email"  size="50" tabindex="2" style="border-radius:4px; width:80%" required/></span><br>
</div><br>
<div align="left"><label><b>Password:&nbsp;&nbsp;</label></b>
<span><input name="pword" class="input" type="password" size="50" tabindex="3" placeholder="at least 6 characters" style="border-radius:4px; width:80%" required/></span><br>
</div><br>	
<div align="left"><label><b>Confirm Password:&nbsp;&nbsp;</label></b>
<span><input name="cpword" class="input" type="password" size="50" tabindex="3"  style="border-radius:4px; width:80%"  required/></span>
</div>
<div align="center" ><input style="border-radius:5px; width:100%; height:30px; margin-top:20px; background-color:#FFCC00" type = "submit" value="Register account">
</div><br>

</form></center>
</div>

<footer><hr><br>&copy; 1996-2016, Fansclub.com, Inc. or its affiliates</footer><br><br>
</body>

</html>
