package com.mnlbc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.mnlbc.model.User;
import com.mnlbc.validator.RegistrationValidator;

/**
 * Registration Controller
 * 
 *
 *
 */
public class RegisterController extends AbstractWizardFormController {

	public RegisterController() {
		setCommandName("userForm");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		return new User();

	}

	@Override
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		User user = (User) command;
		System.out.println(user);
		return new ModelAndView("ResultForm", "user", user);

	}

	@Override
	protected void validatePage(Object command, Errors errors, int page) {
		RegistrationValidator validator = (RegistrationValidator) getValidator();

		switch (page) {
		case 0:
			validator.validateRegistrationForm1(command, errors);
			break;
		case 1:
			validator.validateRegistrationForm2(command, errors);
			break;
		case 2:
			validator.validateRegistrationForm3(command, errors);
			break;
		}

	}
}