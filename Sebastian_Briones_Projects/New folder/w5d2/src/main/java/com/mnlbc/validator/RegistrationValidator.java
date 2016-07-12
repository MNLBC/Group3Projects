package com.mnlbc.validator;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;


import com.mnlbc.model.User;
/**
 * Validator for User Registration
 * 
 *
 */
public class RegistrationValidator implements Validator {

	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	/**
	 * Validate User credentials
	 * 
	 **/
	public void validateRegistrationForm1(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", "Username cannot be blank.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Password cannot be blank.");
	}

	/**
	 * Contact details
	 * 
	 * `
	 **/
	public void validateRegistrationForm2(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Email is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "required.mobileNumber", "Mobile Number.");
	}

	/**
	 * RegistrationForm3 Address
	 * 
	 **/
	public void validateRegistrationForm3(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", "Address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remark", "required.remark", "Field name is required.");
	}

	public void validate(Object target, Errors errors) {

		validateRegistrationForm1(target, errors);
		validateRegistrationForm2(target, errors);
		validateRegistrationForm3(target, errors);

	}

}