import java.util.Scanner;

public class FactorialApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		n = scan.nextInt();

		System.out.println("The Factorial of " + n + " is " + doFactorial(n));

	}

	public static int doFactorial(int n) {

		if (n == 0 || n == 1) {
			return 1;
		}
		return n * doFactorial(n - 1);
	}
}
