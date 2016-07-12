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
		<h2>Enter needed credentials</h2>
		<fieldset>
			<form:form method="POST" commandName="userForm">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table>
					<tr>
						<td>Fullname : <input type="text" name="name" /></td>
						<td>Address: <input type="text" name="address"></td>
						<td>Email: <input type="email" name="email"></td>
					</tr>
					<tr>
						<td colspan="1"><input type="submit" value="Next"
							name="_target1" /> </td> 
							<td colspan="1"><input type="submit" value="Cancel"
							name="_cancel" /></td>
					</tr>
				</table>
			</form:form>
		</fieldset>
	</center>
</body>
</html>