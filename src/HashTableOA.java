import java.util.ArrayList;

public class HashTableOA<K, V> {

	int nBuckets = 5;
	ArrayList<Entry<K, V>> buckets;
	int numItems = 0;

	public HashTableOA() {

		buckets = new ArrayList<Entry<K, V>>();
		for (int s = 0; s < nBuckets; s++) {
			buckets.add(new Entry<K, V>(null, null, 0));
		}
	}

	int hash(K key) {
		return key.hashCode() % nBuckets;
	}

	void rehash() {
		// TODO: implement
	}

	public boolean insert(K key, V value) {

		int firstIndex = hash(key);

		int numTries = 1;
		int index = firstIndex;

		while (numTries <= nBuckets) {
			// Check if the given spot is empty
			Entry<K, V> entry = buckets.get(index);
			if (entry.e <= 0) { // -1 --> empty after removal, 0 --> never occupied, 1--> occupied
				entry.k = key;
				entry.v = value;
				entry.e = 1;

				numItems += 1;
				if (numTries > nBuckets / 3) {
					rehash();
				}
				return true;
			}

			numTries += 1;
			index = (index + 1) % nBuckets;
		}

		return false;
	}

	public V search(K key) {

		int firstIndex = hash(key);

		int numTries = 1;
		int index = firstIndex;
		Entry<K, V> entry = buckets.get(index);

		while (numTries <= nBuckets && entry.e != 0) {

			if (entry.k == key) {
				return entry.v;
			}

			numTries += 1;
			index = (index + 1) % nBuckets;
			entry = buckets.get(index);
		}

		return null;
	}

	public boolean remove(K key) {

		int firstIndex = hash(key);

		int numTries = 1;
		int index = firstIndex;

		while (numTries <= nBuckets) {

			// Check if the given spot does not contain our item
			Entry<K, V> entry = buckets.get(index);

			if (entry.k == key) {
				entry.k = null;
				entry.v = null;
				entry.e = -1;
				numItems -= 1;
				return true;
			}

			numTries += 1;
			index = (index + 1) % nBuckets;
		}

		return false;
	}

	public String toString() {
		String outStr = "";
		for (int s = 0; s < buckets.size(); s++) {
			outStr += "bucket No. " + Integer.toString(s) + ": " + buckets.get(s).toString() + "\n";
		}
		return outStr;
	}

	public boolean contains(K key) {
		return (search(key) != null);
	}

	public double loadFactor() {

		return ((double) numItems) / nBuckets;
	}

	public double numItems() {
		return numItems;
	}

	public static void main(String[] args) {

		HashTableOA<Integer, String> hT = new HashTableOA<Integer, String>();

		int N = 11;

		for (int s = 0; s < N; s++) {
			if (hT.insert(s, Integer.toBinaryString(s))) {

			} else {
				System.err.println("Failed to enter the pair with the key " + s);

			}
		}

		System.out.println(hT);
		System.out.println("*****************************************************" + hT.loadFactor());

		hT.remove(3);

		System.out.println(hT);
		System.out.println("*****************************************************" + hT.loadFactor());

		hT.insert(9, Integer.toBinaryString(9));

		System.out.println(hT);
		System.out.println("*****************************************************" + hT.loadFactor()
				+ "\n-----------------------------");

		String v = hT.search(9);

		System.out.println(v);

		hT.remove(4);
		System.out.println(hT);
		System.out.println("*****************************************************" + hT.loadFactor());

		hT.insert(12, Integer.toBinaryString(12));
		System.out.println(hT);
		System.out.println("*****************************************************" + hT.loadFactor()
				+ "\n-----------------------------");

	}

}
