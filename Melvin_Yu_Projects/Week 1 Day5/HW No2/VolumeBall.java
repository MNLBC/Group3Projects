import java.text.DecimalFormat;
import java.util.Scanner;

public class VolumeBall {
	
	public static final double PI =3.141592653589793238462643383279502884197169399375105;

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radius;
		
		Scanner input = new Scanner(System.in);
		radius=input.nextDouble();
		System.out.println("Volume of the ball is: "+computeVolume(radius));
		

	}
	
	/**
	 * this computes the volume of the ball
	 * @param radius
	 * @return
	 */
	
	public static String computeVolume(double radius){
		
		double volume=0;
		volume=(4/3)*PI*(Math.pow(radius, 3));
	
		return String.format("%.16f", volume);
	}
	


}
