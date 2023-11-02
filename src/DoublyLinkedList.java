
public class DoublyLinkedList<T extends Comparable<T>> implements LinkedListI<T> {

	Node<T> head_;
	Node<T> tail_;

	DoublyLinkedList() {
		head_ = null;
		tail_ = null;
	}

	public String toString() {
		String outStr = "";
		Node<T> node = head_;
		while (node != null) {
			outStr += node.item_.toString() + " ->  \n";
			node = node.next_;
		}
		outStr += "++++++++++++++";
		return outStr;
	}

	@Override
	public void prepend(T item) {
		Node<T> node = new Node<T>(item);

		if (head_ == null) {
			head_ = node;
			tail_ = node;
			return;
		}

		node.next_ = head_;
		head_.prev_ = node;
		head_ = node;
	}

	@Override
	public void append(T item) {

		Node<T> node = new Node<T>(item);

		if (head_ == null) {
			head_ = node;
			tail_ = node;
			return;
		}

		node.prev_ = tail_;
		tail_.next_ = node;
		tail_ = node;

	}

	@Override
	public Node<T> removeFirst() {
		if (head_ == null) {
			return head_;
		}

		Node<T> retNode = head_;

		if (head_.next_ == null) {
			head_ = null;
			tail_ = null;
			return retNode;
		}

		head_ = head_.next_;
		head_.prev_ = null;

		return retNode;
	}

	@Override
	public Node<T> removeLast() {

		// What if the list is empty
		if (head_ == null)
			return null;

		// Need to return a node
		Node<T> retNode = tail_;

		// What if there's only one node?
		if (head_.next_ == null) {
			head_ = null;
			tail_ = null;
			return retNode;
		}

		// Typical case
		Node<T> prev = tail_.prev_;
		prev.next_ = null;
		tail_ = prev;

		return retNode;
	}

	// We're expecting here a correct location
	@Override
	public void insertAfter(Node<T> location, T item) {

		// Convention: if location is null, prepend & return
		if (location == null) {
			prepend(item);
			return;
		}

		// If location is tail_ append and return
		if (location == tail_) {
			append(item);
			return;
		}

		// We have at least two nodes
		Node<T> node = new Node<T>(item);
		Node<T> sucNode = location.next_;

		node.next_ = sucNode;
		sucNode.prev_ = node;
		node.prev_ = location;
		location.next_ = node;

	}

	// We're expecting here a correct location

	@Override
	public Node<T> removeAfter(Node<T> location) {

		// Convention: if location is null, remove first and return
		if (location == null) {
			return removeFirst();
		}

		// if location is tail_, there's nothing to remove
		if (location == tail_)
			return null;

		// if location is penultimate node remove lastj
		if (location.next_ == tail_) {
			return removeLast();
		}

		// Finally, we have a typical case

		Node<T> retNode = location.next_;
		Node<T> sucNode = location.next_.next_;

		location.next_ = sucNode;
		sucNode.prev_ = location;

		return retNode;
	}

	@Override
	public Node<T> search(T item) {
		Node<T> scanNode = head_;

		while (scanNode != null) {
			if (scanNode.item_ == item) {
				return scanNode;
			}

			scanNode = scanNode.next_;
		}

		return null;
	}

	public void insertionSort() {

		// If we have no nodes or exactly one, there's nothing to do
		if (head_ == null || head_.next_ == null)
			return;

		// Start from the second node

		Node<T> curNode = head_.next_;

		while (curNode != null) {
			Node<T> prevCur = curNode.prev_;

			Node<T> scanNode = prevCur;

			while (scanNode != null) {
				T curItem = curNode.item_;
				T scanItem = scanNode.item_;

				if (scanItem.compareTo(curItem) <= 0) {
					// remove curNode
					// put curNode after scanNode
					Node<T> removedNode = removeAfter(prevCur);
					insertAfter(scanNode, removedNode.item_);
					break;
				}

				scanNode = scanNode.prev_;
			}

			if (scanNode == null) {
				Node<T> removedNode = removeAfter(prevCur);
				prepend(removedNode.item_);
			}

			curNode = curNode.next_;
		}

		// Scan rightward for a node that's <= than the node at the right edge of the
		// already sorted list; then swap

	}

	public static void main(String[] args) {

		DoublyLinkedList<String> sList = new DoublyLinkedList<String>();
		sList.append("alpha");
		sList.append("beta");
		sList.append("gamma");
		sList.append("delta");

		sList.prepend("epsilon");
		sList.prepend("phi");
		sList.prepend("kappa");
		sList.prepend("mu");

		System.out.println(sList);

		Node<String> alphaNode = sList.search("alpha");

		Node<String> removedNode = sList.removeAfter(alphaNode);
		System.out.println("***************************\n" + sList + "\n*******************\n" + removedNode
				+ "\n---------------------------\n");

		sList.insertionSort();

		System.out.println("\n***************************\n" + sList);

		// Test appending
		// Test prepending
		// Test remove last
		// Test remove first
		// Test search
		// Test remove after
		// Test insert after
		// Test insertion sort

	}

}
