package com.oocl.mnlbc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

public class UserValidator implements Validator {

	public boolean supports(Class clazz) {
		// just validate the User instances
		return User.class.isAssignableFrom(clazz);
	}

	// validate page 1, userName
	public void validateregistration1(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", "Field name is required.");
	}

	// validate page 2, password
	public void validateregistration2(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required.");
	}

	// validate page 3, email
	public void validateregistration3(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Field name is required.");
	}

	// validate page 4, email
	public void validateregistration4(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required.address", "Field name is required.");
	}

	// validate page 5, email
	public void validateregistration5(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "required.mobile", "Field name is required.");
	}

	public void validate(Object target, Errors errors) {

		validateregistration1(target, errors);
		validateregistration2(target, errors);
		validateregistration3(target, errors);
		validateregistration4(target, errors);
		validateregistration5(target, errors);

	}

}