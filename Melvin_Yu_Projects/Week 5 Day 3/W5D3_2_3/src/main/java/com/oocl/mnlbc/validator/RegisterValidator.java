package com.oocl.mnlbc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.oocl.mnlbc.model.User;

public class RegisterValidator implements Validator {
	User user;

	public boolean supports(Class clazz) {
		// just validate the User instances
		return User.class.isAssignableFrom(clazz);
	}

	// validate page 1, fullname
	public void validateFullname(Object target, Errors errors) {
		user = (User) target;
		if (user.getFullname() != null) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(user.getFullname());
			if (!matcher.matches()) {
				errors.rejectValue("fullname", "fullname.containNonChar", "This contains non Character! Enter a valid name");
			}

		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname", "required.fullname",
					"Field name is required.");
		}
	}

	// validate page 2, password
	public void validatePassword(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required.");
	}

	// validate page 3, username
	public void validateUsername(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.username", "Field name is required.");
	}

	// validate page 3, email
	public void validateEmail(Object target, Errors errors) {
		user = (User) target;
		if (user.getEmail() != null) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(user.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "email.incorrect", "Enter a correct email(eg. melvin@yahoo.com)");
			}

		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "Field name is required.");
		}
	}

	// validate page 3, mobile
	public void validateMobile(Object target, Errors errors) {
		user = (User) target;
		if (user.getMobile() != null) {
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(user.getMobile());
			if (!matcher.matches()) {
				errors.rejectValue("mobile", "mobile.incorrect", "Enter a correct phone number(11 Digits)");
			}
		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "required.mobile", "Field name is required.");
		}
	}

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String STRING_PATTERN = "[a-zA-Z]+";
	private static final String MOBILE_PATTERN = "[0-9]{11}";
	private Pattern pattern;
	private Matcher matcher;

	public void validate(Object target, Errors errors) {

		validateFullname(target, errors);
		validatePassword(target, errors);
		validateUsername(target, errors);
		validateEmail(target, errors);
		validateMobile(target, errors);

	}

}