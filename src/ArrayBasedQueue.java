
public class ArrayBasedQueue<T> implements QueueI<T> {
	int maxAllocationSize;
	int allocationSize = 1;
	int length = 0;
	int frontIndex = 0;
	Object[] data;

	public ArrayBasedQueue(int maxAllocSize) {
		maxAllocationSize = maxAllocSize;

		if (maxAllocationSize <= 0) {
			maxAllocationSize = -1;
		}

		data = (T[]) new Object[allocationSize];
	}

	// Convert from logical index to actual index
	int cvtFromLogical(int logicalIdx) {

		return 0;
	}

	void resize() {
		int oldAllocationSize = allocationSize;
		allocationSize *= 2;

		allocationSize = Math.max(allocationSize, maxAllocationSize);

		Object[] newData = (T[]) new Object[allocationSize];

		// Now copy the data to the new location with every item sitting in its logical
		// index

	}

	public boolean enqueue(T item) {

		// Write your code here
		return false;
	}

	public T dequeue() {

		// Write your own code here
		return null;
	}

	public T peekFront() {
		return (T) data[frontIndex];
	}

	public T peekBack() {
		// Write your own code here
		int actualIndex = -1;
		return (T) data[actualIndex];
	}

	public int len() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public String toString() {
		String retStr = "";
		for (int s = 0; s < length; s++) {
			int actualIndex = cvtFromLogical(s);
			retStr += data[actualIndex].toString() + '\n';
		}

		return retStr + "++++++++++++++++++++\n";
	}

	public static void main(String[] args) {

		ArrayBasedQueue<String> iQ = new ArrayBasedQueue<String>(10);
		// Test enqueue/dequeue; see if the underlying array looks good.

	}
}
