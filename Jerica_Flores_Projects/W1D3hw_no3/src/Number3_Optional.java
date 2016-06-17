import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Number3_Optional {
	  public static void main( String[] args )
	    {
		 validateEmail();
		 validatePhone();
		 replaceAlla();
		 fetchMonth();
		  
	    }
 public static void validateEmail(){
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("Enter an email address: ");
	  String email = scanner.nextLine();
	  String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
	  
      if (matcher.find()) {
    	  System.out.println("Email Address is valid");
      }
      else
      {
    	  System.out.println("Email Address is not valid");
      }
	  }
	  
	  public static void validatePhone(){
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("Enter a number: ");
		  String  phoneNo = scanner.nextLine();
		  
		  String regex = "[0-9]{11}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(phoneNo);
			
			if(matcher.find()){
				 System.out.println("Phone Number Valid");
			}else
		      {
		    	  System.out.println("Phone Number must be 11 number digits.");
		      }
	  }
	  
	  public static void replaceAlla(){
		  String sampleStr = "Jerica and Aica";
		  sampleStr = sampleStr.replaceAll("a", "A");
	  }
	  
	  public static void fetchMonth(){
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("Enter a date: ");
		  String  date = scanner.nextLine();
		  
		  String regex = "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Oct|Nov|Dec|jan|feb|mar|apr|may|jun|jul|aug|sept|oct|nov|dec";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(date);
			
			if(matcher.find()){
		
				 System.out.println("The month is "+matcher.group());
			}else
		      {
				System.out.println("No month found");
		      }
		  
	  }
	  
	  
}
