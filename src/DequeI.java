
public interface DequeI<T> {
	// Only static, default methods and constants can be defined here
	boolean pushFront(T item);

	T popFront();

	boolean pushBack(T item);

	T popBack();

	T peekFront();

	T peekBack();

	int len();

	boolean isEmpty();
}
