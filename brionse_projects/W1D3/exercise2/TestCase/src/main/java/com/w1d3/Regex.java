package com.w1d3;
import java.util.regex.*;
public class Regex {
	
	private Pattern pattern;
	private Matcher matcher;
	
	private String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	
	private String mobileNumberPattern = "\\d{11}";
	
	public boolean isValidEmail(String email){
		pattern = Pattern.compile(emailPattern);
		matcher = pattern.matcher(email);
	    return matcher.matches();
	}
	
	public boolean isValidMobileNumber(String phoneNumber){
		pattern = Pattern.compile(mobileNumberPattern);
		matcher = pattern.matcher(phoneNumber);
	    return matcher.matches();
	}
	
	
}
