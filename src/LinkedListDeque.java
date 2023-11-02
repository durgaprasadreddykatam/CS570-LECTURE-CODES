
public class LinkedListDeque<T extends Comparable<T>> implements DequeI<T> {

	DoublyLinkedList<T> data;
	int length = 0;

	public LinkedListDeque() {
		data = new DoublyLinkedList<T>();
	}

	@Override
	public boolean pushFront(T item) {
		// Write your code here
		return false;
	}

	@Override
	public T popFront() {
		// Write your code here
		return null;
	}

	@Override
	public boolean pushBack(T item) {
		// Write your code here
		return false;
	}

	@Override
	public T popBack() {
		// Write your code here
		return null;
	}

	@Override
	public T peekFront() {
		return data.head_.item_;
	}

	@Override
	public T peekBack() {
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
		LinkedListDeque<String> sD = new LinkedListDeque();

		for (int s = 0; s < 5; s++) {
			sD.pushFront(Integer.toString(s));
		}

		for (int s = 10; s < 15; s++) {
			sD.pushBack(Integer.toString(s));
		}

		// Test pushFront/pushBack, peekFront/peekBack
	}

}
