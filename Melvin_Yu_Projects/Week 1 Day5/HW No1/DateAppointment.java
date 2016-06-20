import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateAppointment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateformat;
		dateformat = new SimpleDateFormat("yyyy.dd.mm EEE HH:MM:sS");
		Calendar cal = Calendar.getInstance();
		String currentDay = (String)dateformat.format(cal.getTime()).toString();  
System.out.println("Date today is " + currentDay);

dateformat = new SimpleDateFormat("EE");
System.out.print("My appointment for today is ");
String day= (String)dateformat.format(cal.getTime()).toString();  

switch (EnumDays.valueOf(day)) {
case Mon:
System.out.print("Go to the cinema");
break;
case Tue:
System.out.print("Play games all day");
break;
case Wed:
System.out.print("Eat Play Sleep");
break;
case Thu:
System.out.print("Meet with President of US");
break;
case Fri:
System.out.print("TGIF");
break;
case Sat:
System.out.print("Do nothing");
break;
case Sun:
System.out.print("Family Day");
break;
default:
throw new AssertionError("No appointment has been made");
}

		
		
	}

}
