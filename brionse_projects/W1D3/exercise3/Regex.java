package com.w1d3;
import java.util.regex.*;
public class Regex {
	
	private Pattern pattern;
	private Matcher matcher;
	
	private String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	
	private String mobileNumberPattern = "\\d{11}";
	
	private String replacePattern = "a";
	
	private String [] monthsPattern = {"Jan","Feb","Jun","Dec"};
	
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
	
	public String replaceWithA(String original){
		pattern = Pattern.compile(replacePattern);
		matcher = pattern.matcher(original);
		return matcher.replaceAll("A");
	}
	
	public String getMonth(String param){
		String result="";
		for(int i=0; i < monthsPattern.length; i++){
			pattern = Pattern.compile(monthsPattern[i]);
			
			matcher = pattern.matcher(param);
			
			if(matcher.find()){
				result = monthsPattern[i];
				break;
			}
		}
		
		return result;
	}
	
}
