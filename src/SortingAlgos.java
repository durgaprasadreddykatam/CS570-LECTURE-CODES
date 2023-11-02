import java.util.ArrayList;
import java.util.List;

public class SortingAlgos {
	static int compCounter = 0;

	static void merge(int[] numbers, int leftFirst, int leftLast, int rightLast) {

		// Initialize position variables
		int leftPos = leftFirst;
		int rightPos = leftLast + 1;
		int mergePos = 0;

		// Create temporary array mergedNumbers
		int mergedSize = rightLast - leftFirst + 1;
		int[] mergedNumbers = new int[mergedSize];

		// Start the merging process
		while (leftPos <= leftLast && rightPos <= rightLast) {
			if (numbers[leftPos] <= numbers[rightPos]) {
				mergedNumbers[mergePos] = numbers[leftPos];
				leftPos += 1;

			} else {
				mergedNumbers[mergePos] = numbers[rightPos];
				rightPos += 1;
			}

			mergePos += 1;
		}

		// If left partition not empty, add remaining elements

		while (leftPos <= leftLast) {
			mergedNumbers[mergePos] = numbers[leftPos];
			leftPos += 1;
			mergePos += 1;
		}

		// If right partition not empty, add remaining elements
		while (rightPos <= rightLast) {
			mergedNumbers[mergePos] = numbers[rightPos];
			rightPos++;
			mergePos++;
		}

		// Copy mergedNumbers back to numbers
		for (mergePos = 0; mergePos < mergedSize; mergePos++) {
			numbers[leftFirst + mergePos] = mergedNumbers[mergePos];
		}
	}

	static void mergesort(int[] numbers, int i, int j) {
		if (i >= j)
			return;

		int mid = (i + j) / 2;

		mergesort(numbers, i, mid);
		mergesort(numbers, mid + 1, j);

		merge(numbers, i, mid, j);
	}

	static int partition(int[] numbers, int lowIndex, int highIndex) {

		int pivotIdx = highIndex;

		int pivotValue = numbers[pivotIdx];

		while (lowIndex < highIndex) {
			// Two step iteration:
			// the left part --> search for the first index i
			// where numbers[i] >= than the pivotValue (= numbers[pivotIdx])
			while (numbers[lowIndex] < pivotValue) {
				lowIndex += 1;
			}

			// The right part --> search for the last (first from
			// the right) index j where numbers[j] < the pivotValue
			while ((lowIndex < highIndex) && pivotValue <= numbers[highIndex]) {
				highIndex -= 1;
			}

			if (lowIndex < highIndex) { // if you found (i, j) -- the violating pair, swap
				int temp = numbers[lowIndex];
				numbers[lowIndex] = numbers[highIndex];
				numbers[highIndex] = temp;
			}
		}

		// Now i = j, everything to the left of i is < the pivot value
		// everything to the right of i is >= the pivot value.
		// Pivot value final position should be i, so place it there.
		if (numbers[pivotIdx] < numbers[lowIndex]) {
			int temp = numbers[pivotIdx];
			numbers[pivotIdx] = numbers[lowIndex];
			numbers[lowIndex] = temp;

		}

		return lowIndex;
	}

	public static void quicksort(int[] numbers, int lowIndex, int highIndex) {

		if (highIndex <= lowIndex)
			return;

		int pivotIdx = partition(numbers, lowIndex, highIndex);

		// We are using the fact that the pivotValue
		// is now in the correct position
		quicksort(numbers, lowIndex, pivotIdx - 1);
		quicksort(numbers, pivotIdx + 1, highIndex);
	}

	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void bubblesort(int[] numbers) {
		int numbersSize = numbers.length;

		for (int i = 0; i < numbersSize - 1; i++) {

			for (int j = 0; j < numbersSize - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					swap(numbers, j, j + 1);
				}

			}
		}

	}

	public static void bubblesort2(int[] numbers) {

		int numbersSize = numbers.length;

		for (int i = 0; i < numbersSize - 1; i++) {

			boolean violation = false;
			for (int j = 0; j < numbersSize - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					violation = true;
					swap(numbers, j, j + 1);
				}
			}

			if (violation == false) {
				return;
			}
		}

	}

	public static void main(String[] args) {
		int[] numbers = { 4, 5, 8, 3, 2, 1, 7, 9, 10, 11, 12, 13, 14, 7 };

		int lidx = partition(numbers, 0, numbers.length - 1);

		List<Integer> intList = new ArrayList<Integer>();
		for (int i : numbers) {
			intList.add(i);
		}

		System.out.println(lidx);
		System.out.println(intList);

		// System.exit(0);

		int[] numbers2 = { 4, 5, 8, 3, 2, 1, 7, 100, 9, 10, 11, 12, 13, 14, 1 };

		quicksort(numbers2, 0, numbers2.length - 1);

		List<Integer> intList2 = new ArrayList<Integer>();
		for (int i : numbers2) {
			intList2.add(i);
		}

		System.out.println("\n********************\n" + intList2);

		int[] numbers3 = { 100, 4, 5, 8, 3, 2, 1, 7, 100, 9, 10, 11, 12, 13, 14, 7 };

		mergesort(numbers3, 0, numbers3.length - 1);

		List<Integer> intList3 = new ArrayList<Integer>();
		for (int i : numbers3) {
			intList3.add(i);
		}

		System.out.println("\n********************\n" + intList3);

		// int[] numbers4 = { 100, 4, 5, 8, 3, 2, 1, 7, 100, 9, 10, 11, 12, 13, 14, 7 };
		int[] numbers4 = { 1, 2, 3, 4, 5, 7, 7, 8, 9, 10, 11, 12, 13, 14, 100, 100 };

		bubblesort2(numbers4);

		List<Integer> intList4 = new ArrayList<Integer>();
		for (int i : numbers4) {
			intList4.add(i);
		}

		System.out.println("\n********************\n" + intList4);

	}

}
