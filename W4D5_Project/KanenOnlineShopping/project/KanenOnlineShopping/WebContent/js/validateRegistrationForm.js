/**
 * Validates the Login form.
 */

function validateRegistrationForm() {

	var userPassword = document.forms["loginForm"]["userPassword"].value;
	var confirmPassword = document.forms["loginForm"]["confirmPassword"].value;
	var mobileNumber = document.forms["loginForm"]["mobileNumber"].value;

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

function isPhoneNumberValid(mobileNumber) {

	var reg = /^\d+$/;
	if (reg.test(mobileNumber)) {
		return true;
	} else {
		return false;
	}
}