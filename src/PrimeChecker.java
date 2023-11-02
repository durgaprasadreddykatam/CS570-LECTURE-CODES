public class PrimeChecker {

	public static boolean primeChecker(int n) { // Outer method which calls a truly recursive function
		int largestDivisor = (int) Math.sqrt(n);
		// long largestDivisor = n - 1;
		return isPrime(n, largestDivisor);

		// return isPrime(n);
	}

	static boolean isPrime(int target, int currentDivisor) { // The recursive function which actually accomplishes the
																// task
		if (target == 0 || target == 1)
			return false;

		if (currentDivisor == 1)
			return true;

		if (target % currentDivisor == 0) {
			System.out.println("Found divisor: " + currentDivisor);
			return false;
		} else {

			return isPrime(target, currentDivisor - 1);
		}
	}

	/* Iterative implementation */
	static boolean isPrime(int n) { // Iterative implementation of isPrime
		int largestDivisor = (int) Math.sqrt(n);
		for (int s = 2; s <= largestDivisor; s++) {
			if (n % s == 0) {
				System.out.println("Found divisor: " + s);
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int n = 83000041;

		System.out.println(PrimeChecker.primeChecker(n));

	}

}
