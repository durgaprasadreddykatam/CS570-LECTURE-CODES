
import java.util.ArrayList;
import java.util.List;

public class MyBinarySearch {

	/*
	 * We are assuming here that lst is sorted; we are going to return the index of
	 * the item searched for. If the item is not on the list we're going to return
	 * -1
	 */
	public static int myBinarySearch(List<Double> lst, double item) {

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

	public static void main(String[] args) {

		ArrayList<Double> lst = new ArrayList<Double>();

		double[] numbers = { 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29 };

		for (double s : numbers) {
			lst.add(s);
		}

		double x = 13;

		int idx = myBinarySearch(lst, x);
		System.out.println(lst);
		System.out.println(idx);
	}

}
