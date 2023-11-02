
public class Pair<K, V> {
	public K k;
	public V v;

	public Pair(K key, V val) {
		k = key;
		v = val;
	}

	public String toString() {
		return k.toString() + " " + v.toString();

	}

}