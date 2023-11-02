
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	/*
	 * We are assuming here that lst is sorted; we are going to return the index of
	 * the item searched for. If the item is not on the list we're going to return
	 * -1
	 */
	public static int binarySearch(List<Double> lst, double item) {
		int lo = 0;
		int hi = lst.size() - 1;

		while (hi >= lo) {
			int median = (hi + lo) / 2;

			if (item == lst.get(median)) {
				return median;
			}

			if (item > lst.get(median)) {
				lo = median + 1;
			} else {
				hi = median - 1;
			}
		}
		return -1;
	}

	public static int binarySearchR1(List<Double> lst, int lo, int hi, double item) {

		int median = (lo + hi) / 2;

		if (item == lst.get(median)) {
			return median;
		}

		if (lo == hi) {
			return -1;
		}

		if (item > lst.get(median)) {
			lo = median + 1;
		} else {
			hi = median - 1;
		}

		return binarySearchR1(lst, lo, hi, item);
	}

	public static int binarySearchR2(List<Double> lst, double item) throws Exception {
		// TODO: implement this recursive version

		return 0;
	}

	public static void main(String[] args) {
		ArrayList<Double> lst = new ArrayList<Double>();
		double[] numbers = { 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29 };
		for (double s : numbers) {
			lst.add(s);
		}
		double x = 13;
		int idx = binarySearchR1(lst, 0, lst.size() - 1, x);
		System.out.println(lst);
		System.out.println(idx);

	}
}