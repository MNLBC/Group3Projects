/**
 * 
 */
package com.oocl.mnlbc;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.oocl.mnlbc.enums.Days;

/**
 * @author vergajo
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String day;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd EEE HH:mm:ss");
		SimpleDateFormat dateDay = new SimpleDateFormat("EEE");
		System.out.println("Current date and time: " + dateFormat.format(date));
		day = dateDay.format(date);
		System.out.print("Appointment(s): ");

		switch (day) {
		case "Sun":
			System.out.print(Days.SUNDAY.toString());
			break;
		case "Mon":
			System.out.print(Days.MONDAY.toString());
			break;
		case "Tue":
			System.out.print(Days.TUESDAY.toString());
			break;
		case "Wed":
			System.out.print(Days.WEDNESDAY.toString());
			break;
		case "Thu":
			System.out.print(Days.THURSDAY.toString());
			break;
		case "Fri":
			System.out.print(Days.FRIDAY.toString());
			break;
		case "Sat":
			System.out.print(Days.SATURDAY.toString());
			break;
		default:
			System.out.print("Invalid date format");
			break;
		}

	}
}
