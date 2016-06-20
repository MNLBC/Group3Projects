import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Weekday.WeekDay;

public class EnumApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DateFormat dateformat;
		String today;
		WeekDay day;

		dateformat = new SimpleDateFormat("yyyy.dd.mm, EEE HH:MM:sS");
		Date date = new Date();
		today = dateformat.format(date);
		System.out.println(today);

		if (today.contains("Mon") || today.contains("Tue")
				|| today.contains("Wed") || today.contains("Thu")
				|| today.contains("Fri")) {
			System.out.println("Its a Weekday!! Please Attend the ITA");
		} else if (today.contains("Sat")) {
			System.out.println("Its Saturday!! Please rest in the Hotel");
		} else if (today.contains("Sun")) {
			System.out.println("Its Sunday!! Go to Church");
		} else {
			System.out.println("Day Invalid!");
		}
	}
}
