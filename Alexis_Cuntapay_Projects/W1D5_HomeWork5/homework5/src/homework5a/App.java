package homework5a;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 
 * @author cuntaal
 * @version 1
 * 
 */
public class App {

	public static void main(String[] args) {

		double radius = 0;
		double volume = 0;

		System.out.print("Enter the radius of Ball: ");
		Scanner input = new Scanner(System.in);
		radius = input.nextDouble();
		// Ouput Valume of radius
		System.out.println("The valume of the radius is" + " "
				+ getValue(radius));

	}

	// Formala to get the volume
	private static String getValue(double radius) {
		double dec = 4;
		dec /= 3;
		BigDecimal v = new BigDecimal(dec * Math.PI * Math.pow(radius, 3));
		return String.format("%.16f", v);

	}
}