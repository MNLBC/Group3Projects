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
							<td>Mobile :</td>
							<td><form:input path="mobile" /></td>
							<td><form:errors path="mobile" cssClass="error" /></td>
						</tr>
						<tr>
						<tr>
							<td colspan="3"><input type="submit" value="Next"
								name="_target3" /> <input type="submit" value="Finish"
								name="_finish" /> <input type="submit" value="Cancel"
								name="_cancel" /></td>
						</tr>

					</table>
				</form:form>
			</div>
		</fieldset>
	</body>
</center>


</html>