import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heap<K extends Comparable<K>, V> implements PriorityQueueI<K, V> {
	ArrayList<Pair<K, V>> data;

	public Heap() {
		data = new ArrayList<Pair<K, V>>();
	}

	void swap(int i, int j) {
		if (i == j)
			return;

		Pair<K, V> tmp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, tmp);
	}

	// Warning: make sure i and j are valid indexes
	int indexOfHigherPriority(int i, int j) {
		if (i == j)
			return i;

		if (data.get(i).k.compareTo(data.get(j).k) >= 0)
			return i;
		else
			return j;
	}

	void percolateDown(int itemIndex) {
		if (isEmpty())
			return;

		K parentPriority = data.get(itemIndex).k;

		int lastIndex = data.size() - 1;
		int leftChild = 2 * itemIndex + 1;
		int rightChild = 2 * itemIndex + 2;

		if (leftChild > lastIndex && rightChild > lastIndex) {
			// the index is a leaf -- nothing to do
			return;

		} else if (leftChild > lastIndex) {
			// swap with the right child if needed

			K rChildPriority = data.get(rightChild).k;

			if (parentPriority.compareTo(rChildPriority) < 0) {
				swap(itemIndex, rightChild);
				percolateDown(rightChild);
			}

		} else if (rightChild > lastIndex) {

			// swap with the left child if needed

			K lChildPriority = data.get(leftChild).k;

			if (parentPriority.compareTo(lChildPriority) < 0) {
				swap(itemIndex, leftChild);
				percolateDown(leftChild);
			}

		} else {

			int hChild = indexOfHigherPriority(leftChild, rightChild);

			Pair<K, V> hC = data.get(hChild);
			if (parentPriority.compareTo(hC.k) < 0) {
				swap(itemIndex, hChild);
				percolateDown(hChild);
			}

		}
	}

	void percolateUp(int itemIndex) {
		if (itemIndex == 0) {
			return;
		}
		K myPriority = data.get(itemIndex).k;

		int parentIndex = (itemIndex - 1) / 2;
		K parentPriority = data.get(parentIndex).k;

		if (parentPriority.compareTo(myPriority) < 0) {
			swap(parentIndex, itemIndex);
			percolateUp(parentIndex);
		}
	}

	public String toString() {
		return toStringR(0);
	}

	public String toStringR(int j) {

		String retStr = "";

		String leftStr = "";
		String rightStr = "";
		String myStr = "";

		int lastIndex = data.size() - 1;
		int leftChild = 2 * j + 1;
		int rightChild = 2 * j + 2;

		if (leftChild <= lastIndex)
			leftStr = toStringR(leftChild);

		if (rightChild <= lastIndex)
			rightStr = toStringR(rightChild);

		myStr = data.get(j).k.toString();
//		int parentIndex = (j - 1) / 2;
//		if (j == 2 * parentIndex + 1)
//			myStr += "L";
//		else
//			myStr += "R";

		int myDepth = (int) (Math.log10(j + 1) / Math.log10(2));

		String nodeDepthOnScreen = " ".repeat(32 * myDepth);

		retStr += rightStr + "\n".repeat(2) + nodeDepthOnScreen + myStr + "\n".repeat(2) + leftStr;

		return retStr;
	}

	public static Heap heapify(List dataItems) { // List will be ArrayList< Pair<K, V> >

		return null;
	}

	@Override
	public void insert(K priority, V item) {
		Pair<K, V> newPair = new Pair<K, V>(priority, item);
		data.add(newPair);
		percolateUp(data.size() - 1);
	}

	@Override
	public Pair<K, V> removeMax() {
		int lastIndex = data.size() - 1;

		Pair<K, V> retVal = data.get(0); // Save the top node before modification
		data.set(0, data.get(lastIndex));
		data.remove(lastIndex);

		percolateDown(0);

		return retVal;
	}

	@Override
	public Pair<K, V> findMax() {
		return data.get(0);
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public int getLength() {
		return data.size();
	}

	ArrayList<K> heapSort() {
		ArrayList<K> retList = new ArrayList<K>();
		int K = data.size();
		for (int s = 0; s < K; s++) {
			K key = removeMax().k;
			retList.add(key);
		}

		return retList;
	}

	public static String generateRandomString() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;
	}

	public static void main(String[] args) {

		int N = 16;
		int[] intL = new int[N];
		int minimum = 1;
		int maximum = 100;
		int rN = 0;
		for (int s = 0; s < N; s++) {
			rN = minimum + (int) (Math.random() * maximum);
			intL[s] = rN;
		}

		int[] intL3 = { 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		Heap<Integer, String> h = new Heap<Integer, String>();

		for (int s = 0; s < intL.length; s++) {
			h.insert(intL3[s], Integer.toString(intL3[s]));
		}

		System.out.println(h + "\n*******************************************\n");

		Pair<Integer, String> p = h.removeMax();
		System.out.println("Removing " + p + "\n******************************************************\n");

		System.out.println(h + "\n*******************************************\n");

		ArrayList<Integer> sorted = h.heapSort();

		System.out.println(sorted + "\n*******************************************\n");

		/*******************************************/

		Heap<String, Integer> hS = new Heap<String, Integer>();
		ArrayList<String> randomStrings = new ArrayList<String>();

		for (int s = 0; s < N; s++) {
			String str = generateRandomString();
			hS.insert(str, str.length());
		}

		System.out.println(hS);

		ArrayList<String> sorted2 = hS.heapSort();

		System.out.println(sorted2 + "\n*******************************************\n");

	}

}
