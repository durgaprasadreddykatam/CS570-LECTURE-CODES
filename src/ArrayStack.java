public class ArrayStack<T extends Object> implements StackI<T> {

	Object[] data;
	int maxAllocationSize;
	int allocationSize = 1;
	int length = 0;

	public ArrayStack(int maxAllocSize) {
		// Write your code
	}

	void resize() {

		// Write your code

	}

	public String toString() {
		String retStr = "";
		for (int s = length - 1; s >= 0; s--) {
			retStr += data[s].toString() + "\n";
		}

		retStr += "+++++++++++++++++++++++";
		return retStr;
	}

	@Override
	public T pop() {

		// Write your code

		return null;
	}

	@Override
	public boolean push(T item) {
		if (length == maxAllocationSize) // Cannot add anymore
			return false;

		if (length == allocationSize) {
			resize();
		}

		// Write the rest of the code
		return true;
	}

	@Override
	public T peek() {
		return null;
	}

	@Override
	public int len() {

		return 0;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	public static void main(String[] args) {
		// Test push
		// Test pop
		// Test len()
		// Test isEmpty()

	}

}
