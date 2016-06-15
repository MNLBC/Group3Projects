package com.oocl.mnlbc.factorial;


public class Factorial {

	public static void main(String[] args) {

		System.out.println("Hi. This is factorial exercise.");
	}

	public int factorial(int j) {
		int val = 0;
		int res = 0;
		
		val = 5;
		res = val;
		for (int i = val - 1; i > 0; i--) {

			res = res * i;
		}
		return res;
	
}

}
