import java.util.ArrayList;

public class HashTable<K, V> implements HashADT<K, V> {
	int nBuckets = INIT_BUCKET_NUM;
	ArrayList<ArrayList<Pair<K, V>>> buckets;
	int numItems = 0;

	public HashTable() {
		buckets = new ArrayList<ArrayList<Pair<K, V>>>();
		for (int s = 0; s < nBuckets; s++) {
			buckets.add(new ArrayList<Pair<K, V>>());
		}

	}

	int hash(K key) {
		return Math.abs(key.hashCode()) % nBuckets;
	}

	@Override
	public void insert(K key, V value) {
		int bIndex = hash(key);

		ArrayList<Pair<K, V>> bucket = buckets.get(bIndex);

		for (Pair<K, V> p : bucket) {
			if (p.k == key) {
				p.v = value;
				return;
			}
		}

		bucket.add(new Pair<K, V>(key, value));
		numItems += 1;

		if (loadFactor() >= 0.5) {
			rehash();

		}
	}

	@Override
	public V search(K key) {
		int bIndex = hash(key);

		ArrayList<Pair<K, V>> bucket = buckets.get(bIndex);

		for (Pair<K, V> p : bucket) {
			if (p.k == key) {
				return p.v;
			}
		}

		System.err.println("No item with key " + key.toString());
		return null;
	}

	@Override
	public boolean remove(K key) {

		int bIndex = hash(key);

		ArrayList<Pair<K, V>> bucket = buckets.get(bIndex);

		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i).k == key) {
				bucket.remove(i);
				numItems -= 1;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contains(K key) {
		return (search(key) == null);
	}

	@Override
	public double loadFactor() {

		return ((double) numItems) / nBuckets;
	}

	@Override
	public double numItems() {
		return numItems;
	}

	public String toString() {
		String outStr = "";
		for (int s = 0; s < buckets.size(); s++) {
			outStr += "bucket No. " + Integer.toString(s) + ":\n";
			for (Pair<K, V> p : buckets.get(s)) {
				outStr += "key: " + p.k.toString() + ", " + "value: " + p.v.toString() + "\n";
			}
			outStr += "\n";
		}
		return outStr;
	}

	void rehash() {
		nBuckets *= 2;

		ArrayList<ArrayList<Pair<K, V>>> newBuckets = new ArrayList<ArrayList<Pair<K, V>>>();

		for (int s = 0; s < nBuckets; s++)
			newBuckets.add(new ArrayList<Pair<K, V>>());

		for (int s = 0; s < buckets.size(); s++) {
			ArrayList<Pair<K, V>> bucket = buckets.get(s);
			for (Pair<K, V> p : bucket) {
				int newIndex = hash(p.k); // we're rehashing here
				ArrayList<Pair<K, V>> newBucket = newBuckets.get(newIndex);
				newBucket.add(p);
			}
		}

		buckets = newBuckets;

	}

	public static void main1(String[] args) {
		HashTable<Integer, String> hT = new HashTable<Integer, String>();

		int N = 11;

		for (int s = 0; s < N; s++) {
			hT.insert(s, Integer.toBinaryString(s));
		}

		System.out.println(hT);
		System.out.println("*****************************************************" + hT.loadFactor());
	}

	public static void main(String[] args) {
		HashTable<String, String> hT = new HashTable<String, String>();

		int N = 11;

		for (int s = 0; s < N; s++) {
			hT.insert(Integer.toString(s) + "alpha", Integer.toBinaryString(s));
		}

		System.out.println(hT);
		System.out.println("*****************************************************" + hT.loadFactor());

		ArrayList<String> myKeys = hT.keys();

		System.out.println("+++++++++++++++++++++++++++++++++++++++++\n" + myKeys);
	}

	@Override
	public ArrayList<K> keys() {

		ArrayList<K> retVal = new ArrayList<K>();

		for (int s = 0; s < buckets.size(); s++) {
			ArrayList<Pair<K, V>> bucket = buckets.get(s);
			for (Pair<K, V> p : bucket) {
				retVal.add(p.k);
			}
		}

		return retVal;

	}

}
