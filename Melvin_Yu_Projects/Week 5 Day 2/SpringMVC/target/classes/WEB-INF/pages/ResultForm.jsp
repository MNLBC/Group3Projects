<html>
<head><style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
input, textarea {
	padding: 9px;
	border: solid 1px #999999;
	outline: 0;
	font: normal 13px/100% Verdana, Tahoma, sans-serif;
	width: 85%;
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
	width: auto;
	padding: 9px 15px;
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
</style></head>
<body>
<h2>ResultForm.jsp</h2>

<table>
<tr>
<tr>
<td>Fullname :</td><td>${user.fullname}</td>
</tr>
<tr>
<td>UserName :</td><td>${user.username}</td>
</tr>
<tr>
<td>Password :</td><td>${user.password}</td>
</tr>
<tr>
<td>Email :</td><td>${user.email}</td>
</tr>
<tr>
<td>Mobile :</td><td>${user.mobile}</td>
</tr>

</table>

</body>
</html>