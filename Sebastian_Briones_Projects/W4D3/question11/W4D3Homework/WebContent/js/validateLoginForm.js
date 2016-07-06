/**
 * Validates the Login form.
 */

function validateLoginForm() {

	var userName = document.forms["loginForm"]["userName"].value;
	var userPassword = document.forms["loginForm"]["userPassword"].value;
	var confirmPassword = document.forms["loginForm"]["confirmPassword"].value;
	var fullName = document.forms["loginForm"]["fullName"].value;
	var email = document.forms["loginForm"]["email"].value;
	var address = document.forms["loginForm"]["address"].value;
	var mobileNumber = document.forms["loginForm"]["mobileNumber"].value;

	if (userName == null || userName == "") {
		alert("Username cannot be blank");
		return false;
	}

	if (userPassword == null || userPassword == "") {
		alert("Password cannot be blank");
		return false;
	}

	if (confirmPassword == null || confirmPassword == "") {
		alert("Please confirm password.");
		return false;
	}

	if (fullName == null || fullName == "") {
		alert("Name cannot be blank.");
		return false;
	}

	if (email == null || email == "") {
		alert("Email cannot be blank.");
		return false;
	}

	if (address == null || address == "") {
		alert("Address cannot be blank.");
		return false;
	}

	if (mobileNumber == null || mobileNumber == "") {
		alert("Mobile number cannot be blank.");
		return false;
	}

	if (userPassword != confirmPassword) {
		alert("Passwords do not match.");
		return false;
	}

	if (!isEmailValid(email)) {
		alert("Please enter a valid email!");
		return false;
	}

	if (!isPhoneNumberValid(mobileNumber)) {
		alert("Please enter a valid mobile number!");
		return false;
	} 
}

function isEmailValid(email) {

	var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (reg.test(email)) {
		return true;
	} else {
		return false;
	}
}

function isPhoneNumberValid(mobileNumber) {

	var reg = /^\d+$/;
	if (reg.test(mobileNumber)) {
		return true;
	} else {
		return false;
	}
}