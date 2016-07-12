<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<center>
	<h4>Enter needed credentials</h4>
	<fieldset>
	<form:form method="POST" commandName="userForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Username : <input type="text" name="userName" /></td>
				<td>Password: <input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="Register"
					name="_finish" /></td>
				<td colspan="1"><input type="submit" value="Back"
					name="_target0" /></td>
				<td colspan="1"><input type="submit" value="Cancel"
					name="_cancel" /></td>
			</tr>
		</table>
	</form:form>
	</fieldset>
</center>
</body>
</html>