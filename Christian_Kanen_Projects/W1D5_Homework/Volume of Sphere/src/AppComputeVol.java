import java.math.BigDecimal;
import java.util.Scanner;

/**
 * This Program calculates Volume of a Sphere
 * Uses BigDecimal
 * @author KANENCH
 *
 */
public class AppComputeVol {

	public static void main(String[] args) {
		String volume;
		double radius;
		Scanner scan = new Scanner(System.in);

		System.out.println("Volume Calculator (Sphere)");
		do {
			System.out.println("Enter Radius: ");
			radius = scan.nextInt();
		} while (radius < 0);

		volume = computeVolume((double) radius);
		System.out.println("Volume of the Ball is : " + volume);
	}
	
	/**
	 * This Function generates the volume of a Sphere
	 * @param r
	 * @return v 
	 */
	public static String computeVolume(double r) {
		double cons = 4;
		cons /= 3;
		BigDecimal v = new BigDecimal(cons * Math.PI * Math.pow(r, 3));
		return String.format("%.16f", v);
	}
}
