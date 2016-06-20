
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInformation {

	public static void main(String[] args) {
		String day;

		Date date = new Date();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd EEE HH:mm:ss");
		SimpleDateFormat dateDay = new SimpleDateFormat("EEE");
		System.out.println("Date and time today: " + dateFormat.format(date)); 
		System.out.println("----- What to do today? -----");
		day = dateDay.format(date);
		
		
		switch (day) {
		
		case "Mon":
			System.out.println(ActivityDaily.Mon.toString());
			break;
		case "Tue":
			System.out.println(ActivityDaily.Tue.toString());
			break;
		case "Wed":
			System.out.println(ActivityDaily.Wed.toString());
			break;
		case "Thu":
			System.out.println(ActivityDaily.Thu.toString());
			break;
		case "Fri":
			System.out.println(ActivityDaily.Fri.toString());
			break;
		case "Sat":
			System.out.println(ActivityDaily.Sat.toString());
			break;
		case "Sun":
			System.out.println(ActivityDaily.Sun.toString());
			break;

		}
	}
}
