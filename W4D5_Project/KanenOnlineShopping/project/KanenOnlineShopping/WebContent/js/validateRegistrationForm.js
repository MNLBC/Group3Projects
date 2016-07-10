/**
 * Validates the Login form.
 */

function validateRegistrationForm() {

	var userPassword = document.forms["registrationFormModal"]["txtPassword"].value;
	var confirmPassword = document.forms["registrationFormModal"]["txtConfirmPassword"].value;
	var mobileNumber = document.forms["registrationFormModal"]["txtMobileNumber"].value;

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