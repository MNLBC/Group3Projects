package factorial;

import java.util.Scanner;

public class App {
	public static void main(String[] arg) {
		int num;
		System.out.println("Enter Number Here:");
		Scanner input = new Scanner(System.in);
		num = input.nextInt();
		System.out.println("Factorial is = " + doFactorial(num));
	}

	public static int doFactorial(int num) {
		int cal;
		int n = 1;
		for (cal = 1; cal <= num; cal++)
			n = n * cal;
		return n;
	}

}
