/**
 * 
 */
package com.oocl.mnlbc;

import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Scanner;

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
		double radius;
		double volume;

		System.out.println("Calculate for the Ball Volume");
		System.out.print("Ball Radius: ");
		Scanner scan = new Scanner(System.in);
		radius = scan.nextDouble();

		//this will compute for the volume of the ball
		volume = (4 * Math.PI * Math.pow(radius, 3)) / 3;

		//this will format the volume to 16 decimal places and display it
		Formatter fmt = new Formatter();
		System.out.println("The Volume of the Ball is: " + fmt.format("%.16f", volume));

	}

}
