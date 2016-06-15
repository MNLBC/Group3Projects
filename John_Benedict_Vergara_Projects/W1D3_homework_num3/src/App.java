import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("(1)	To check an email if it is valid or not.");
		System.out.println("(2)	To check a mobile phone number if it is valid or not.");
		System.out.println("(3)	Given a string, replace all the char “a” with “A”.");

		int choice;
		System.out.print("Enter your choice: ");
		choice = scan.nextInt();
		if (choice == 3) {
			replaceAllA();
		} else if (choice == 2) {
			checkMobileNumber();
		} else if (choice == 1) {
			checkEmail();
		}

	}

	public static String replaceAllA() {
		System.out.print("Enter a String: ");
		Scanner scan = new Scanner(System.in);
		String sample = scan.nextLine();

		sample = sample.replace("a", "A");
		System.out.println("Result: " + sample);
		return sample;
	}

	public static String checkMobileNumber() {
		Scanner scan = new Scanner(System.in);
		String number;
		System.out.print("Enter your phone number: ");
		number = scan.nextLine();

		// Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
		Pattern pattern = Pattern.compile("[0-9]{11}");

		Matcher matcher = pattern.matcher(number);

		if (matcher.matches()) {
			System.out.println("Phone Number Valid");
		} else {
			System.out.println("Phone number must be 11 digits and 0-9 only.");
		}
		return "number";
	}

	public static String checkEmail() {
		Scanner scan = new Scanner(System.in);
		String number;
		System.out.print("Enter your E-mail: ");
		number = scan.nextLine();

		// Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher matcher = pattern.matcher(number);

		if (matcher.matches()) {
			System.out.println("E-mail is Valid");
		} else {
			System.out.println("Invalid E-mail.");
		}
		return "number";

	}

}
