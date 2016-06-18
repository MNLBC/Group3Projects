import java.math.BigDecimal;
import java.util.Scanner;

public class VolumeOfBall {

	public static void main(String[] args) {
		double radius;
		double volume;
		
		System.out.println("------- Calculate the volume of the ball -------");
		System.out.println("Enter the radius of the ball: ");
		Scanner input = new Scanner(System.in);
		radius = input.nextDouble();
		volume = ( 4.0 / 3.0 ) * Math.PI * Math.pow( radius, 3 );
	
		BigDecimal result= new BigDecimal(volume);
		System.out.println("The volume of the ball is: " + result);
	}
}
