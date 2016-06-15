package com.oocl.mnlbc.w1d3;

public class App_Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5;
		int fact = 1;
		int ctr;

		for (ctr = 1; ctr <= num; ctr++) {
			fact = fact * ctr;
		}

		System.out.println("The Factorial of " + num + " is: " + fact);
	}

	public int factorial(int x) {
		int fact = 1;
		int ctr;

		for (ctr = 1; ctr <= x; ctr++) {
			fact = fact * ctr;
		}
		// System.out.println("The Factorial of " + x + " is: " + fact);
		return fact;
	}

}
