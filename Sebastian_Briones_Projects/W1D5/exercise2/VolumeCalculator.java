package com.oocl.w1d5.exercise2;

import java.math.BigDecimal;

/**
 * 
 * @author BRIONSE A class that calculates the volume of a ball given its radius
 * 
 */
public class VolumeCalculator {

	/*
	 * Fixed constants
	 */
	public final static BigDecimal pie = new BigDecimal(Math.PI);
	public final static BigDecimal fourThirds = new BigDecimal("1.3333333333333333333333333333333");

	public static void main(String[] args) {

		Ball bigBall = new Ball(27.1234567890123456);

		BigDecimal radius = new BigDecimal(bigBall.getRadius());
		System.out.println(calculateVolume(radius).toString());

	}

	/**
	 * 
	 * @param radius
	 * @return volume of the ball with high precision
	 * 
	 */
	public static BigDecimal calculateVolume(BigDecimal radius) {

		return radius.pow(3).multiply(pie).multiply(fourThirds);

	}
}
