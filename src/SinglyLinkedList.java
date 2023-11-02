
public class SinglyLinkedList<T extends Comparable<T>> {

	Node<T> head_;
	Node<T> tail_;

	SinglyLinkedList() {
		head_ = null;
		tail_ = null;
	}

	public void prepend(T item) {
		Node<T> node = new Node<T>(item);
		if (head_ == null) {
			head_ = node;
			tail_ = node;
		} else {
			node.next_ = head_;
			head_ = node;
		}
	}

	public void append(T item) {
		Node<T> node = new Node<T>(item);

		if (tail_ == null) {
			head_ = node;
			tail_ = node;
		} else {
			tail_.next_ = node;
			tail_ = node;
		}
	}

	public Node<T> search(T item) {

		Node<T> node = head_;
		while (node != null) {
			if (node.item_ == item) {
				return node;
			}

			node = node.next_;
		}

		return null;
	}

	/*
	 * If curNode is not on the list behavior is undefined.
	 */
	public void insertAfter(Node<T> curNode, T item) {
		Node<T> newNode = new Node<T>(item);

		if (head_ == null) { // the list is empty
			head_ = newNode;
			tail_ = newNode;
		} else if (curNode == null) {
			prepend(item);
		} else if (curNode.next_ == null) { // we're at the end of the list
			tail_.next_ = newNode;
			tail_ = newNode;
		} else {
			newNode.next_ = curNode.next_;
			curNode.next_ = newNode;
		}
	}

	/*
	 * When given a node, curNode = null we decide to remove the head (as if at the
	 * start of the list we had a null, and we remove next element after that -- the
	 * head)
	 */

	public void removeAfter2(Node<T> curNode) throws Exception {
		if (head_ == null) {
			throw new Exception("Trying to remove from an empty list.");
		}

		if (curNode == null) {
			head_ = head_.next_;
			if (head_ == null) // We've removed the last element on the list
				tail_ = null;
		} else if (curNode == tail_) { // Default comparison for Node should work fine
			return;
		} else {
			Node<T> sucNode = curNode.next_.next_;
			curNode.next_ = sucNode;
			if (curNode.next_ == null)
				tail_ = curNode;
		}
	}

	public Node<T> removeAfter(Node<T> curNode) throws Exception {
		if (head_ == null) {
			throw new Exception("Trying to remove from an empty list.");
		}

		if (curNode == null) {
			return removeFirst();
		} else if (curNode == tail_) { // Default comparison for Node should work fine
			return null;
		} else {
			Node<T> retNode = curNode.next_;
			Node<T> sucNode = curNode.next_.next_;
			curNode.next_ = sucNode;
			if (curNode.next_ == null)
				tail_ = curNode;
			return retNode;
		}
	}

	public Node<T> removeFirst() throws Exception {
		if (head_ == null) {
			throw new Exception("Trying to remove from an empty list.");
		}

		Node<T> retNode = head_;
		head_ = head_.next_;
		if (head_ == null) {
			tail_ = null;
		}

		return retNode;
	}

	public Node<T> removeLast() throws Exception {
		if (head_ == null) {
			throw new Exception("Cannot remove from empty list!");
		}

		if (head_.next_ == null) {
			Node<T> first = head_;
			head_ = null;
			tail_ = null;
			return first;
		}

		Node<T> node = head_;
		Node<T> retNode = tail_;

		while (node != null) {
			if (node.next_ == tail_) {
				node.next_ = null;
				tail_ = node;
			}

			node = node.next_; // performance = proportional to the length of the list -> O(n)
		}

		return retNode;
	}

	/* Printing in order */
	public String toStringO() {
		String outStr = "";
		Node<T> node = head_;
		while (node != null) {
			outStr += node.item_.toString() + " ->  \n";
			node = node.next_;
		}

		outStr += " null";
		return outStr;
	}

	/* Printing in reversed order */
	public String toStringR() {
		String outStr = "";

		if (head_ == null)
			return "";

		outStr += tail_.item_.toString() + "->\n";
		try {

			removeLast();
			outStr += toStringR();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return outStr;
	}

	public void recursiveReverseTraversal() {
		recursiveReverseTraversal(head_);
	}

	// Process every node from the end up to and including the given node
	public void recursiveReverseTraversal(Node<T> node) {

		if (node == null)
			return;

		recursiveReverseTraversal(node.next_);

		System.out.println(node);

	}

	public String toString() {
		return toStringO();
	}

	public static void main(String[] args) {

		SinglyLinkedList<String> sList = new SinglyLinkedList<String>();

		for (int i = 20; i < 30; i++) {
			sList.append(Integer.toString(i));
		}

		System.out.println(
				"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" + sList + "\n---------------------------------------\n");

		sList.recursiveReverseTraversal();

	}

}
