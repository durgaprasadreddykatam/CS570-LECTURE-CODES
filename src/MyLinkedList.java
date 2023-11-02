
public class MyLinkedList<T> {

	Node<T> head_;
	Node<T> tail_;

	MyLinkedList() {
		head_ = null;
		tail_ = null;
	}

	public void append(T item) {

		Node<T> node = new Node<T>(item);

		if (head_ == null) {
			head_ = node;
			tail_ = node;
			return;
		}

		tail_.next_ = node;
		tail_ = node;
	}

	public void prepend(T item) {
		Node<T> node = new Node<T>(item);

		if (head_ == null) {
			head_ = node;
			tail_ = node;
			return;
		}

		node.next_ = head_;
		head_ = node;
	}

	public String toString() {

		String strOut = "";

		Node<T> scanNode = head_;
		while (scanNode != null) {
			strOut += scanNode.item_.toString() + "-->\n";
			scanNode = scanNode.next_;
		}

		strOut += "--> null\n";

		return strOut;
	}

	public Node<T> removeFirst() throws Exception {

		if (head_ == null) {
			throw new Exception("You're trying to remove stuff from an empty list!");
		}

		if (head_.next_ == null) {
			Node<T> retNode = head_;
			head_ = null;
			tail_ = null;
			return retNode;
		}

		Node<T> retNode = head_;
		head_ = head_.next_;
		return retNode;
	}

	public Node<T> removeLast() throws Exception {

		if (head_ == null) {
			throw new Exception("You're trying to remove stuff from an empty list!");
		}

		if (head_.next_ == null) {
			Node<T> retNode = head_;
			head_ = null;
			tail_ = null;
			return retNode;
		}

		Node<T> retNode = tail_;

		Node<T> scanNode = head_;

		while (scanNode.next_ != tail_) {
			scanNode = scanNode.next_;
		}

		scanNode.next_ = null;
		tail_ = scanNode;

		return retNode;
	}

	Node<T> search(T item) {

		Node<T> scanNode = head_;

		while (scanNode != null) {
			if (scanNode.item_ == item) {
				return scanNode;
			}

			scanNode = scanNode.next_;
		}

		return null;

	}

	public static void main(String[] array) {

		MyLinkedList<String> sList = new MyLinkedList<String>();

		sList.prepend("alpha");
		sList.prepend("beta");
		sList.prepend("gamma");
		sList.prepend("delta");
		sList.prepend("theta");

		sList.append("kappa");
		sList.append("epsilon");
		sList.append("mu");

		System.out.println(sList);
		System.out.println("****************************\n" + sList.head_);

		try {
			Node<String> first = sList.removeFirst();
			System.out.println("*********************************\n" + sList);
			System.out.println(first);

			Node<String> last = sList.removeLast();
			System.out.println("*********************************\n" + sList);
			System.out.println(last);

			Node<String> kappaNode = sList.search("epsilon");
			System.out.println("*******************************\n" + kappaNode);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}

}
