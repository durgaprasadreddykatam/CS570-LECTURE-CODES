
public class LinkedListQueue<T extends Comparable<T>> implements QueueI<T> {
	DoublyLinkedList<T> data;
	int length = 0;

	public LinkedListQueue() {
		data = new DoublyLinkedList<T>();
		length = 0;
	}

	public boolean enqueue(T item) {
		Node<T> node = new Node<T>(item);
		// Write your code here
		return true;
	}

	public T dequeue() {
		// Write your code here
		return null;
	}

	public T peekFront() {
		return data.head_.item_;
	}

	public T peekBack() {
		// Write your code here
		return null;
	}

	public int len() {
		// Write your code here
		return 0;
	}

	public boolean isEmpty() {
		// Write your code here
		return true;
	}

	public String toString() {
		String retStr = "";
		retStr += "length = " + Integer.toString(length) + "\n----------------------------------\n";
		retStr += data.toString();
		return retStr;
	}

	public static void main(String[] args) {
		LinkedListQueue<String> sQueue = new LinkedListQueue<String>();
		// Test enqueue/dequeue, len, isEmpty

	}
}
