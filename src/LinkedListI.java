
public interface LinkedListI<T> {

	// Only static, default methods and constants can be implemented here (nothing
	// else)

	void prepend(T item);

	void append(T item);

	Node<T> removeFirst();

	Node<T> removeLast();

	void insertAfter(Node<T> location, T item);

	Node<T> removeAfter(Node<T> location);

	Node<T> search(T item);

	void insertionSort();

}
