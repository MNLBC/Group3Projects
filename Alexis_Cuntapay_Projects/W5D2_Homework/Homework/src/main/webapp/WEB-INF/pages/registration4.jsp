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

<center>
	<body>
		<fieldset>
			<legend>Registration</legend>
			<div style="height: 623px; width: 411px">
				<form:form method="POST" commandName="userForm">
					<form:errors path="*" cssClass="errorblock" element="div" />
					<table>
						<tr>
							<td>Address :</td>
							<td><form:input path="address" /></td>
							<td><form:errors path="address" cssClass="error" /></td>
						</tr>
						<tr>
						<tr>
							<td colspan="3"><input type="submit" value="Previous"
								name="_target2" /> <input type="submit" value="Next"
								name="_target4" /> <input type="submit" value="Cancel"
								name="_cancel" /></td>
						</tr>

					</table>
				</form:form>
			</div>
</center>
</fieldset>
</body>
</html>