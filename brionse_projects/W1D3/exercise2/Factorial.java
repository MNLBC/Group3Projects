package com.w1d3;

import junit.framework.TestCase;

public class Factorial{


	public  int factorial(int n){
		int factorial = 1;
		while(n >0){
			factorial *= n;
			n -= 1;
		}
		return factorial;
	}
	

	
}
