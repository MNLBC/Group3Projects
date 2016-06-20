package com.oocl.w1d5.exercise1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author BRIONSE
 *
 *         Reads date information of today and outputs the current time
 *         Depending on the day of the week, may prompt the user to do certain
 *         things
 */

public class Scheduler {

	/**
	 * 
	 * @param args
	 *            Creates a new dateFormat prints the time the program is run
	 */
	public static void main(String[] args) {

		// create a new Date object and format
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd EEE HH:mm:ss");
		Date date = new Date();

		System.out.println(dateFormat.format(date));

		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		String today = dateFormat.format(cal.getTime());

		for (Weekday day : Weekday.values()) {
			if (today.contains(day.toString())) {
				weeklySchedule(day.toString());
			}
		}

	}

	/**
	 * 
	 * @param day
	 *            accepts a day String and does an appropriate action
	 */
	public static void weeklySchedule(String day) {

		switch (day) {
		case "Mon":
			System.out.println("Appointment to the dentist");
			break;
		case "Tue":
			System.out.println("Attending ITAcademy");
			break;
		case "Wed":
			System.out.println("More work to do!");
			break;
		case "Thu":
			System.out.println("No appointment had been made ");
			break;
		case "Fri":
			System.out.println("Friday Night out");
			break;
		case "Sat":
			System.out.println("Need to go to the doctors.");
			break;
		case "Sun":
			System.out.println("Family day");
			break;
		default:
			System.out.println("Too lazy to go out.");
			break;

		}

	}

}
