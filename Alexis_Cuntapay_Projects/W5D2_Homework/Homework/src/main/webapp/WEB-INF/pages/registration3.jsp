<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Registration</title>
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
	<fieldset>
		<legend>Registration</legend>
		<center>

			<form:form method="POST" commandName="userForm">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table>
					<tr>
						<td>Email :</td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="error" /></td>
					</tr>
					<tr>
					<tr>
						<td colspan="3"><input type="submit" value="Previous"
							name="_target1" /> <input type="submit" value="Next"
							name="_target3" /> <input type="submit" value="Cancel"
							name="_cancel" /></td>
					</tr>
				</table>
			</form:form>
	</fieldset>
	</center>

</body>
</html>