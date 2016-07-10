<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">


<!-- Latest compiled and minified CSS -->

<!-- 
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
 -->


<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>	
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script> -->

<script>
	$(document).ready(function() {

		$('#btnLogin').click(function(e) {
			e.preventDefault();

			var usernameLogin = document.getElementById("incorrectcredentials");
			if (usernameLogin != null) {
				usernameLogin.parentNode.removeChild(incorrectcredentials);
			}
 

			var userName = $('#username').val();
			var userPassword = $('#password').val();

			$.ajax({
				url : 'user',
				data : {
					userName : userName,
					userPassword : userPassword,
					method : 'loginUser'
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

		if (response.data.errormsg.indexOf('incorrectcredentials') > -1) {
			var usernameExistDiv = document.createElement('div');
			var registrationForm = $('#loginForm');

			usernameExistDiv.id = 'incorrectcredentials';
			usernameExistDiv.className = 'alert alert-danger';
			usernameExistDiv.textContent = 'Credential that has been input is invalid.';
			registrationForm.append(usernameExistDiv);
		}

		return;
	};
</script>
</head>
<body>
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Login</h4>
        </div>
        <div class="modal-body">
		
		<form id="loginForm" class="form-horizontal" action="">
<fieldset>

			<!-- Form Name -->
			<!--<legend>Login</legend>-->

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="username">Username:</label>
				<div class="col-md-8">
					<input id="username" name="username" placeholder="Username"
						class="form-control input-md" required="" type="text">

				</div>
			</div>

			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="password">Password</label>
				<div class="col-md-8">
					<input id="password" name="password" placeholder="Password"
						class="form-control input-md" required="" type="password">

				</div>
			</div>

			<!-- Button (Double) -->
			<!--
			<div class="form-group">
				<label class="col-md-8 control-label" for="btnLogin"></label>
				<div class="col-md-8">
					<button id="btnLogin" name="btnLogin" class="btn btn-success">Login</button>
					<button id="btnCancel" name="btnCancel" class="btn btn-danger">Cancel</button>
				</div>
			</div>
			-->
</fieldset>
</form>
</div>
     <div>
        <div class="modal-footer">
		  <button id="btnLogin" name="btnLogin" class="btn btn-success">Login</button>
		  <button id="btnCancel" name="btnCancel" class="btn btn-danger" data-dismiss="modal">Cancel</button>
        </div>
	</div>


</body>
</html>
 