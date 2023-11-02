import java.util.Scanner;

public class FibonacciSequence {
	public static void computeFibonacci(int f1, int f2, int howMany) { // 1) We calculate the first Fibonacci number
																		// 2) We repeat the whole process with n - 1
																		// numbers and so on ...
		if (howMany == 0)
			return;

		int f3 = f1 + f2;
		System.out.println(f1 + " + " + f2 + " = " + f3 + "\n");

		computeFibonacci(f2, f3, howMany - 1);
	}

	public static int computeFibonacci(int which) {
		// TODO: implement the classical recursion

		if (which <= 1)
			return 1;

		return computeFibonacci(which - 1) + computeFibonacci(which - 2);
	}

	public static long computeFibonacciO(int which) { // Outer function

//		long[] memo = new long[which + 1];
//		return computeFibonacciM(which, memo);

		return computeFibonacciIter(which);

	}

	public static long computeFibonacciM(int which, long[] memo) { // Truly recursive function

		if (which <= 1) {
			memo[which] = 1;
			return 1;
		}

		if (memo[which] != 0) {
			return memo[which];
		} else {
			long val = computeFibonacciM(which - 1, memo) + computeFibonacciM(which - 2, memo);
			memo[which] = val;
			return val;
		}

	}

	public static int computeFibonacciIter(int which) {

		if (which <= 1)
			return 1;

		int f0 = 1;
		int f1 = 1;
		int result = 0;
		for (int s = 2; s <= which; s++) {
			result = f0 + f1;
			f0 = f1;
			f1 = result;
		}

		return result;

	}

	public static void main(String[] args) {

		Scanner myInput = new Scanner(System.in);

		if (false) {
			System.out.println("Please enter how many fibs\nwould you like to see.");
			int howMany = myInput.nextInt();
			// TODO: test the first implementation of computeFibonnaci

			computeFibonacci(1, 1, howMany);
		}

		while (true) {
			System.out.println("Which individual Fibonacci number would you like to see?");
			int which = myInput.nextInt();
			System.out.println(computeFibonacciO(which) + "\n*****************");

		}

	}
}
