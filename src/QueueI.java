
public interface QueueI<T extends Object> {
	// Only static, default methods and constant members are allowed to be defined

	boolean enqueue(T item);

	T dequeue();

	T peekFront();

	T peekBack();

	int len();

	boolean isEmpty();
}
