import java.util.regex.*;

public class AppRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		checkEmail("yu_melvinrobert@outlook.com");
		checkMobile("605-8889");
		replaceLetterA("kanen");
		getSpecificWord("Tue Jun 14 21:30:31 CST 2016");
		
		
	}
	
	public static void checkEmail(String email){//To check an email if it is valid or not.
		String Regex_Email="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern=  Pattern.compile(Regex_Email);
		Matcher match = pattern.matcher(email);
		
		if(match.matches()){
			
			System.out.println("This email is valid");
		}
		else{
			
			System.out.println("This is an invalid email");
		}
		
		
	}
	
	public static void checkMobile(String number){
		
		Pattern pattern=  Pattern.compile("\\d{4}-\\d{7}");
		Matcher match = pattern.matcher(number);
		
	if(match.matches()){
			
			System.out.println("This Phone number is valid");
		}
		else{
			
			System.out.println("This is an invalid Phone number");
		}

	}
	
	public static void replaceLetterA(String word){
		System.out.println("Word Before: "+word);
		Pattern pattern=  Pattern.compile("[a]");

		word = pattern.matcher(word).replaceAll("A");
		
		System.out.println("Word After: "+word);
		
	}
	
	public static void getSpecificWord(String date){
		
		String mydata = date;
		Pattern pattern = Pattern.compile("(Jun)");
		Matcher matcher = pattern.matcher(mydata);
		if (matcher.find())
		{
		    System.out.println(matcher.group(1));
		}
		
		
	}

}
