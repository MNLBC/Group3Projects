<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
body {
	background: #66d9ff;
}

h2 {
	color: black;
	text-transform: uppercase;
	font-family: 'Open Sans Condensed', sans-serif;
}

input[type=text]:focus, textarea:focus, input[type=password]:focus {
	box-shadow: 0 0 5px rgba(240, 131, 15, 1);
	padding: 3px 0px 3px 3px;
	margin: 10px 1px 3px 0px;
	border: 1px solid rgba(240, 131, 15, 1);
}

.mainForm {
	font-family: 'Open Sans Condensed', arial, sans;
	width: 500px;
	padding: 30px;
	background: #FFFFFF;
	margin: 50px auto;
	box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
	-moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
	-webkit-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
}

.mainForm h2 {
	background: #4D4D4D;
	text-transform: uppercase;
	font-family: 'Open Sans Condensed', sans-serif;
	color: #797979;
	font-size: 18px;
	font-weight: 100;
	padding: 20px;
	margin: -30px -30px 30px -30px;
}

.mainForm input[type="text"], .mainForm input[type="date"], .mainForm input[type="datetime"],
	.mainForm input[type="email"], .mainForm input[type="number"],
	.mainForm input[type="search"], .mainForm input[type="time"], .mainForm input[type="url"],
	.mainForm input[type="password"], .mainForm textarea, .mainForm select
	{
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	outline: none;
	display: block;
	width: 100%;
	padding: 7px;
	border: none;
	border-bottom: 1px solid #ddd;
	background: transparent;
	margin-bottom: 10px;
	font: 16px Arial, Helvetica, sans-serif;
	height: 45px;
}

.mainForm textarea {
	resize: none;
	overflow: hidden;
}

.mainForm input[type="button"], .mainForm input[type="submit"] {
	-moz-box-shadow: inset 0px 1px 0px 0px #45D6D6;
	-webkit-box-shadow: inset 0px 1px 0px 0px #45D6D6;
	box-shadow: inset 0px 1px 0px 0px #45D6D6;
	background-color: #2CBBBB;
	border: 1px solid #27A0A0;
	display: inline-block;
	cursor: pointer;
	color: #FFFFFF;
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 14px;
	padding: 8px 18px;
	text-decoration: none;
	text-transform: uppercase;
}

.mainForm input[type="button"]:hover, .mainForm input[type="submit"]:hover
	{
	background: linear-gradient(to bottom, #34CACA 5%, #30C9C9 100%);
	background-color: #34CACA;
}
</style>
</head>

<body>
	<h2>Enter credentials:</h2>

	<form:form method="POST" commandName="userForm">
		<form:errors path="*" cssClass="mainform" element="div" />
		<table>
			<tr>
				<td>Username :</td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="mainform" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="mainform" /></td>
			</tr>
			<tr>
				<td>Confirm password :</td>
				<td><form:password path="confirmPassword" /></td>
				<td><form:errors path="confirmPassword" cssClass="mainform" /></td>
			</tr>
			<tr>
			<tr>
				<td colspan="3"><input type="submit" value="Next"
					name="_target1" /> <input type="submit" value="Cancel"
					name="_cancel" /></td>
			</tr>

		</table>
	</form:form>

</body>
</html>