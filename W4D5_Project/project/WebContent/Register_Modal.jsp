<!DOCTYPE html>
<html lang="en">
<head>
<title>Create Account</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
 -->

<!-- 	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>	
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script> -->

<script>
	$(document).ready(function() {

		$('#btnRegister').click(function(e) {
			e.preventDefault();

			var usernameTakenDiv = document.getElementById("usernametaken");
			if (usernameTakenDiv != null) {
				usernameTakenDiv.parentNode.removeChild(usernameTakenDiv);
			}

			var emailTakenDiv = document.getElementById("emailtaken");
			if (emailTakenDiv != null) {
				emailTakenDiv.parentNode.removeChild(emailTakenDiv);
			}

			 var accountRegisteredDiv = document
					.getElementById("accountregistered");
			if (accountRegisteredDiv != null) {
				accountRegisteredDiv.parentNode
						.removeChild(accountRegisteredDiv);
			} 

			var userName = $('#txtUsername').val();
			var userPassword = $('#txtPassword').val();
			var fullName = $('#txtFullName').val();
			var email = $('#txtEmail').val();
			var deliveryAddress = $('#txtDeliveryAddress').val();
			var mobileNumber = $('#txtMobileNumber').val();

			$.ajax({
				url : 'user',
				data : {
					userName : userName,
					userPassword : userPassword,
					fullName : fullName,
					email : email,
					deliveryAddress : deliveryAddress,
					mobileNumber : mobileNumber,
					method : 'registerUser'
				},
				method : 'POST',
				complete : function(responseText) {
					displayResults(responseText);

				}

			});

		});

	});

	function displayResults(responseText) {
		var response = JSON.parse(responseText.responseText);

		if (response.data.errormsg.indexOf('usernametaken') > -1) {
			var usernameExistDiv = document.createElement('div');
			var registrationForm = $('#registrationForm');

			usernameExistDiv.id = 'usernametaken';
			usernameExistDiv.className = 'alert alert-danger';
			usernameExistDiv.textContent = 'The username has already been taken.';
			registrationForm.append(usernameExistDiv);
		}

		if (response.data.errormsg.indexOf('emailtaken') > -1) {
			var emailExistDiv = document.createElement('div');
			var registrationForm = $('#registrationForm');

			emailExistDiv.id = 'emailtaken';
			emailExistDiv.className = 'alert alert-danger';
			emailExistDiv.textContent = 'The email has already been taken.';
			registrationForm.append(emailExistDiv);
		}

		 if (response.data.errormsg.indexOf('none') > -1) {
			var registrationSuccessDiv = document.createElement('div');
			var registrationForm = $('#registrationForm');

			registrationSuccessDiv.id = 'accountregistered';
			registrationSuccessDiv.className = 'alert alert-success';
			registrationSuccessDiv.textContent = 'Account registered successfully.';
			registrationForm.append(registrationSuccessDiv);
		} 

		return;
	};
</script>

</head>
<body>
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Register</h4>
        </div>
        <div class="modal-body">
		
<form class="form-horizontal" action="">
<fieldset>

				<!-- Form Name -->
			<!--	<legend>Create Account</legend>-->

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtUsername" >Username:</label>
					<div class="col-md-7">
						<input id="txtUsername" name="txtUsername" type="text"
							placeholder="" class="form-control input-md" required>

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtPassword">Password:</label>
					<div class="col-md-7">
						<input id="txtPassword" name="txtPassword" type="password"
							placeholder="" class="form-control input-md" required>

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtConfirmPassword">Confirm
						Password:</label>
					<div class="col-md-7">
						<input id="txtConfirmPassword" name="txtConfirmPassword"
							type="password" placeholder="" class="form-control input-md" required>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtFullName">Full
						Name:</label>
					<div class="col-md-7">
						<input id="txtFullName" name="txtFullName" type="text"
							placeholder="" class="form-control input-md" required>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtEmail">Email:</label>
					<div class="col-md-7">
						<input id="txtEmail" name="txtEmail" type="email" placeholder=""
							class="form-control input-md" required>

					</div>
				</div>

				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtDeliveryAddress">Delivery
						Address</label>
					<div class="col-md-7">
						<textarea class="form-control" id="txtDeliveryAddress"
							name="txtDeliveryAddress" required></textarea>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="txtMobileNumber">Mobile
						Number:</label>
					<div class="col-md-7">
						<input id="txtMobileNumber" name="txtMobileNumber" type="text"
							placeholder="" class="form-control input-md" required>

					</div>
				</div>

				<!-- Button (Double) -->
				<!--
				<div class="form-group">
					<label class="col-md-4 control-label" for="btnRegister"></label>
					<div class="col-md-8">
						<button id="btnRegister" name="btnRegister"
							class="btn btn-primary">Create Account</button>
						<button id="btnRegisterCancel" name="btnRegisterCancel"
							class="btn btn-danger">Cancel</button>
					</div>
				</div>
				-->

			</fieldset>
		</form>
		</div>
 <div>
        <div class="modal-footer">
		<button id="btnRegister" name="btnRegister" class="btn btn-primary">Create Account</button>
		<button id="btnRegisterCancel" name="btnRegisterCancel" class="btn btn-danger" data-dismiss="modal">Cancel</button>
        </div>
</div>
		
</body>
</html>