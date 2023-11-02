
public class LinkedListStack<T extends Comparable<T>> implements StackI<T> {
	int length = 0;
	DoublyLinkedList<T> data;

	LinkedListStack() {
		data = new DoublyLinkedList<T>();
	}

	@Override
	public T pop() {
		if (length == 0)
			return null;

		length -= 1;
		return data.removeLast().item_;
	}

	@Override
	public boolean push(T item) {
		data.append(item);
		length += 1;
		return true;
	}

	@Override
	public T peek() {
		return data.tail_.item_;
	}

	@Override
	public int len() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	public String toString() {
		return data.toString();
	}

	public static void main(String[] args) {
		// Test push
		// Test pop
		// Test len()
		// Test isEmpty()
	}

}
