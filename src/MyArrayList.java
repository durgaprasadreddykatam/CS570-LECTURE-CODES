
public class MyArrayList<T> implements ArrayBasedList<T> {

	Object[] data;
	int allocationSize;
	int length;

	MyArrayList() {
		allocationSize = 1;
		length = 0;

		data = new Object[allocationSize];
	}

	public String toString() {
		String outStr = "";
		outStr += "allocationSize = " + allocationSize + "\n";
		outStr += "length = " + length + "\n";
		outStr += "data:\n";
		for (int s = 0; s < length; s++) {
			outStr += data[s].toString() + ", ";
		}

		return outStr;
	}

	void resize() {
		allocationSize *= 2;
		Object[] tmp = new Object[allocationSize];

		for (int s = 0; s < length; s++) {
			tmp[s] = (T) data[s];
		}

		data = tmp;
	}

	public void prepend(T item) {

	}

	public void append(T item) {
		if (length == allocationSize) {
			resize();
		}

		data[length] = item;

		length += 1;
	}

	public T get(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	public void set(int idx, T value) {
		// TODO Auto-generated method stub

	}

	public void insertAfter(int idx, T item) {
		if (length == allocationSize) {
			resize();
		}

		for (int s = length; s > idx + 1; s--) {
			data[s] = data[s - 1];
		}

		data[idx + 1] = item;

		length += 1;

	}

	public int search(T item) {
		// TODO Auto-generated method stub
		return 0;
	}

	public T removeAt(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

		MyArrayList<String> mL = new MyArrayList<String>();

		mL.append("alpha");
		mL.append("beta");
		mL.append("gamma");

		System.out.println(mL);

		MyArrayList<Integer> iL = new MyArrayList<Integer>();

		for (int s = 1; s <= 10; s++) {
			iL.append(s);
		}

		System.out.println("*************************\n" + iL);

		iL.insertAfter(7, 91);

		System.out.println("*************************\n" + iL);

	}

}
