import java.util.regex.*;

public class RegexApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pattern p;
		// Matcher matcher;
		checkEmail();
		checkPhone();
		replaceA();
		dateExtract();

	}

	public static void checkEmail() {
		String input = "cjkanen29@.gmail.com";
		Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = p.matcher(input);
		if (matcher.matches()) {
			System.out.println("Valid Email Format ");
		} else {
			System.out.println("Invalid Email Format ");
		}
	}

	public static void checkPhone() {
		String input = "0975-5132643";
		Pattern p = Pattern.compile("\\d{4}-\\d{7}");
		Matcher matcher = p.matcher(input);
		if (matcher.matches()) {
			System.out.println("Valid Phone Number ");
		} else {
			System.out.println("Invalid Phone Number ");
		}
	}

	public static void replaceA() {
		String input = "adamson asia pacific";
		Pattern p = Pattern.compile("[a]");

		String matcher = p.matcher(input).replaceAll("A");
		System.out.println(matcher);

	}

	public static void dateExtract() {

		String input = "Tue Jun 14 21:30:31 CST 2016";
		Pattern p = Pattern
				.compile("Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec");

		Matcher m = p.matcher(input);
		if (m.find()) {
			System.out.println(m.group());
		}
	}

}
