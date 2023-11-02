
public interface StackI<T> {

	// Only static & default methods and constant members can be defined here

	T pop(); // Removes the top element of the stack and returns it

	boolean push(T item);

	T peek(); // Provides the reference to the top element of the stack without removing it

	int len();

	boolean isEmpty();

}
