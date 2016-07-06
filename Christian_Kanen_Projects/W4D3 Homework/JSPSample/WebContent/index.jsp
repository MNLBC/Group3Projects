<!doctype html>
<html>
<title>W4D3 Homework # 1</title>
<head>
<script type = "text/javascript">

function validateStr(){
	
	var pw1 = document.getElementById("password").value;
	var pw2 = document.getElementById("password1").value;
	
	if (!(pw1===pw2)){
		alert("Password mismatched!");
		return false;
	}else{
		return true;
	}
}

</script>

<style type="text/css">
body {
	font-family: Arial, Sans-Serif;
}

#container {
	width: 300px;
	margin: 0 auto;
	padding: 10px;
	border: 1px;
	border-style: solid;
	border-color: gray;
}

/* Nicely lines up the labels. */
form label {
	display: inline-block;
	width: 140px;
}

/* You could add a class to all the input boxes instead, if you like. That would be safer, and more backwards-compatible */
form input[type="text"], form input[type="password"], form input[type="email"]
	{
	width: 160px;
}

form .line {

	clear: both;
	padding: 10px;
}

form .line.submit {
	text-align: left;
"
}

button {
	color: black;
	background: #ffe85b;
	height: 30px;
	width: 250px;
	cursor: pointer;
}

#footer {
	background-color: #f5f2e5;
	color: blue;
	font-size: 15px;
	clear: both;
	text-align: center;
	padding: 5px;
}

input {;
	
}
</style>
</head>
<body>
	<div id="container">
		<form ACTION = "threeParams" onsubmit = "return validateStr()">
			<h2>Create account</h2>
			<div class="line">
				<label for="username"><b>Userame </b> </label> <input type="text"
					name="uname" placeholder="Enter your username" style="width: 100%" required />
			</div>
			<div class="line">
				<label for="password"><b>Password </b></label><input type="password"
					name = "pword" placeholder="***************" id="password" style="width: 100%" required/>
			</div>
			<div class="line">
				<label for="password"><b>Re-enter Password </b></label><input type="password"
					name = "pword1" placeholder="***************" id="password1" style="width: 100%" required/>
			</div>
			<div class="line">
				<label for="fname"><b>Your Name</b> </label> <input type="text"
					name="fname" placeholder="Enter your name" style="width: 100%" required/>
			</div>
			<div class="line">
				<label for="address"><b>Address</b> </label> <input type="text"
					name="add" placeholder="Enter your address" style="width: 100%" required/>
			</div>
			<div class="line">
				<label for="cnt"><b>Contact #</b> </label> <input type="text"
					name="cnt" placeholder="Enter your contact #" style="width: 100%" required/>
			</div>

			<div class="line">
				<label for="email"><b>Email </b></label><input type="email"
					name="email" placeholder="Enter your e-mail address"
					style="width: 100%" required/>
			</div>
			<br>
			<div align="center" class="line">
				<button type="submit" value="Submit">Create your amazon
					account</button>
			</div>
			<p>
				By creating an Account, you agree to Amazon's <font color="blue">
					Conditions of use </font> and <font color="blue"> Privacy Notice </font>.
			</p>

			<hr>
			<p>
				Already have an account? <font color="blue"> Sign in </font>
		</form>
	</div>
	<div id="footer">
		<p>Conditions of Use &nbsp;&nbsp;&nbsp; Privacy
			Notice&nbsp;&nbsp;&nbsp;&nbsp;Help</p>
		<p>
			<font color="black ">&copy;&nbsp;&nbsp; 1996-2016, Amazon.com,
				Inc or its affiliates </font>
		</p>
		<br> <br>
	</div>
</body>
</html>