
public interface ArrayBasedList<T> {

	void prepend(T item);

	void append(T item);

	T get(int idx);

	void set(int idx, T value);

	void insertAfter(int idx, T item);

	int search(T item);

	T removeAt(int idx);

}
