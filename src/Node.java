
public class Node<T> {

	public T item_;
	public Node<T> next_;
	public Node<T> prev_;

    Node(T item) {
		item_ = item;
		next_ = null;
	}

	public String toString() {

		String outStr = "";

		if (item_ != null) {
			outStr += "item = " + item_.toString() + "\n";
		} else {
			outStr += "item =  null\n";
		}

		if (next_ != null) {
			outStr += "next hash code = " + next_.hashCode();
		} else {
			outStr += "next hash code = null";
		}

		return outStr;
	}

}
