package com.oocl.mnlbc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.template.UserJDBCTemplate;
import com.oocl.mnlbc.validator.RegisterValidator;

public class RegisterController extends AbstractWizardFormController{
	RegisterValidator validator;
	public RegisterController(){
		setCommandName("userForm");
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		
		return new User();
		
	}
	@Override
	protected ModelAndView processFinish(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		//Get the data from command object
		User user = (User)command;
		System.out.println(user);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/oocl/mnlbc/beans/Beans.xml");

		UserJDBCTemplate userJDBC = (UserJDBCTemplate) context.getBean("userJDBCTemplate");
		
		userJDBC.create(user.getUsername(), user.getPassword(), user.getFullname(), user.getMobile(), user.getEmail());
		//where is the finish page?
		return new ModelAndView("ResultForm", "user", user);
		
	}

	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		//where is the cancel page?
		return new ModelAndView("WelcomePage");
	}
	
	@Override
	protected void validatePage(Object command, Errors errors, int page) {
		
		validator = (RegisterValidator) getValidator();
		
		//page is 0-indexed
		switch (page) {
			case 0: //if page 1 , go validate with validatePage1Form
				validator.validateFullname(command, errors);
				break;
			case 1: //if page 2 , go validate with validatePage2Form
				validator.validateUsername(command, errors);
				break;
			case 2: //if page 3 , go validate with validatePage3Form
				validator.validatePassword(command, errors);
				break;
			case 3: //if page 2 , go validate with validatePage2Form
				validator.validateEmail(command, errors);
				break;
			case 4: //if page 3 , go validate with validatePage3Form
				validator.validateMobile(command, errors);
				break;
		}
			
	}
}