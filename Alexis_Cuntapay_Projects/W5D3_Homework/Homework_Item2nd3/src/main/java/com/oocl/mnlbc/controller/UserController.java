package com.oocl.mnlbc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.oocl.mnlbc.dao.UserJDBCTemplate;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.validator.UserValidator;

public class UserController extends AbstractWizardFormController {

	public UserController() {
		setCommandName("userForm");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {

		return new User();

	}

	@Override
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		// Get the data from command object
		User user = (User) command;
		System.out.println(user);

		// where is the finish page?
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/oocl/beans/beans.xml");

		UserJDBCTemplate userDAO = (UserJDBCTemplate) context.getBean("userJDBCTemplate");
		userDAO.create(user);
		// where is the finish page?
		return new ModelAndView("ResultForm", "user", user);

	}

	@Override
	protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		// where is the cancel page?
		return new ModelAndView("WelcomePage");
	}

	@Override
	protected void validatePage(Object command, Errors errors, int page) {

		UserValidator validator = (UserValidator) getValidator();

		// page is 0-indexed
		switch (page) {
		case 0: // if page 1 , go validate with validatePage1Form
			validator.validateregistration1(command, errors);
			break;
		case 1: // if page 2 , go validate with validatePage2Form
			validator.validateregistration2(command, errors);
			break;
		case 2: // if page 3 , go validate with validatePage3Form
			validator.validateregistration3(command, errors);
			break;
		case 3: // if page 3 , go validate with validatePage3Form
			validator.validateregistration4(command, errors);
			break;
		case 4: // if page 3 , go validate with validatePage3Form
			validator.validateregistration5(command, errors);
			break;
		}

	}
}