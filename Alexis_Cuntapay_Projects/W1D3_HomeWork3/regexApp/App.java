package regexApp;

import java.util.Scanner;
import java.util.regex.*;

public class App {

	public static void main(String[] args) {
		testEmail1();
		testMobile();
		testReplace();
	}

	

	public static void testEmail1() {
		String email1;
		System.out.println("Enter Email:");
		Pattern p = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
		Scanner input = new Scanner(System.in);
		email1 = input.next();
		Matcher matcher = p.matcher(email1);

		if (matcher.matches()) {
			System.out.println(email1 + " " + "is valid");
		} else {
			System.out.println(email1 + " " + "is not valid");
		}
	}
	public static void testMobile(){
		String mobile;
		System.out.println("Enter Mobile Number:");
		Pattern m = Pattern.compile("\\d{4}-\\d{7}");
		Scanner input = new Scanner(System.in);
		mobile = input.next();
		Matcher matcher = m.matcher(mobile);
		if (matcher.matches()) {
			System.out.println(mobile + " " + "is valid");
		} else {
			System.out.println(mobile + " " + "is not valid");
		
	}

	}
	private static void testReplace() {
			String input =  "AAAAAAlexis Cuntapay";
            Pattern p = Pattern.compile("[A]");
			String matcher = p.matcher(input).replaceAll("a");
			System.out.println(matcher);

		
		
	}
	}
	

