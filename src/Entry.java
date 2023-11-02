
public class Entry<K, V> {

	public K k;
	public V v;
	public Integer e;

	// emptyInidator values:
	// -1 -- empty after removal
	// 0 -- originally empty
	// 1 -- occupied

	public Entry(K key, V val, Integer emptyIndicator) {
		k = key;
		v = val;
		e = emptyIndicator;
	}

	public String toString() {

		String outStr = "";

		String kStr = "null";
		String vStr = "null";

		if (k != null)
			kStr = k.toString();

		if (v != null)
			vStr = v.toString();

		return kStr + " " + vStr + " " + e.toString();

	}

}
