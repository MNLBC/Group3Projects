package com.oocl.mnlbc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

public class RegisterValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the User instances
		return User.class.isAssignableFrom(clazz);
	}
	
	//validate page 1, userName
	public void validateFullname(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname",
				"required.fullname", "Field name is required.");
	}
	
	//validate page 2, password
	public void validatePassword(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");
	}
	
	//validate page 3, remark
	public void validateUsername(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				"required.username", "Field name is required.");
	}
	//validate page 3, remark
	public void validateEmail(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "Field name is required.");
	}
	//validate page 3, remark
	public void validateMobile(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile",
				"required.mobile", "Field name is required.");
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		
		validateFullname(target, errors);
		validatePassword(target, errors);
		validateUsername(target, errors);
		validateEmail(target, errors);
		validateMobile(target, errors);
	
	}
	
}