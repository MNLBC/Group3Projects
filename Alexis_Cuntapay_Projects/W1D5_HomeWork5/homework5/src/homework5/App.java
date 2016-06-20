package homework5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author cuntaal
 * @version 1
 */
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String today;
		String username;

		System.out.println("Please Enter Name:");
		// input name here
		Scanner input = new Scanner(System.in);
		username = input.next();
		SimpleDateFormat dateformat1 = new SimpleDateFormat(
				" yyyy.dd.mm, EEE, HH:MM:sS");
		Date date = new Date();
		today = dateformat1.format(date);
		// Will prompt the schedule foe today
		if (today.contains("Mon")) {
			System.out.println(username + "," + "you to have a check up today"
					+ today);

		} else if (today.contains("Tue")) {
			System.out.println(username + ","
					+ "you have to attend Business Meeting today" + today);

		} else if (today.contains("Wed")) {
			System.out.println(username + "," + "you have to Workout today"
					+ today);

		} else if (today.contains("Thur")) {
			System.out.println(username + "," + "Throwback today" + today);

		} else if (today.contains("Fri")) {
			System.out.println(username + ","
					+ "you to have attend Weekly Checkup today" + today);

		} else if (today.contains("Sat")) {
			System.out.println(username + "," + "take some rest" + today);

		} else if (today.contains("Sun")) {
			System.out.println(username + "," + "take some rest" + today);

		} else {
			System.out.println("Invalid Date");
		}

	}
}
