<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<form class="form-horizontal" action="user" onsubmit="return validateRegistrationForm()">
			<fieldset>

				<!-- Form Name -->
				<legend>Create Account</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtUsername">Username:</label>
					<div class="col-md-4">
						<input id="txtUsername" name="userName" type="text"
							placeholder="" class="form-control input-md" required>

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtPassword">Password:</label>
					<div class="col-md-4">
						<input id="txtPassword" name="userPassword" type="password"
							placeholder="" class="form-control input-md" required>

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtConfirmPassword">Confirm
						Password:</label>
					<div class="col-md-4">
						<input id="txtConfirmPassword" name="txtConfirmPassword"
							type="password" placeholder="" class="form-control input-md" required>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtFullName">Full
						Name:</label>
					<div class="col-md-4">
						<input id="txtFullName" name="fullName" type="text"
							placeholder="" class="form-control input-md" required>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtEmail">Email:</label>
					<div class="col-md-4">
						<input id="txtEmail" name="email" type="email" placeholder=""
							class="form-control input-md" required>

					</div>
				</div>

				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtDeliveryAddress">Delivery
						Address</label>
					<div class="col-md-4">
						<textarea class="form-control" id="txtDeliveryAddress"
							name="deliverAddress" required></textarea>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtMobileNumber">Mobile
						Number:</label>
					<div class="col-md-4">
						<input id="txtMobileNumber" name="txtMobileNumber" type="text"
							placeholder="" class="form-control input-md" required>

					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="btnRegister"></label>
					<div class="col-md-8">
						<button id="btnRegister" name="btnRegister"
							class="btn btn-primary">Create Account</button>
						<button id="btnRegisterCancel" name="btnRegisterCancel"
							class="btn btn-danger">Cancel</button>
					</div>
				</div>

			</fieldset>
			
			<input type="hidden" name="method" value=registerUser>
		</form>

	</div>
</body>
</html>