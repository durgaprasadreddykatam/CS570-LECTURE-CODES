import java.util.ArrayList;

public interface HashADT<K, V> {

	public final int INIT_BUCKET_NUM = 5;

	// Only static, default methods and constants can be implemented in an interface

	void insert(K key, V value);

	V search(K key);

	ArrayList<K> keys();

	boolean remove(K key);

	boolean contains(K key);

	double loadFactor();

	double numItems();

}
