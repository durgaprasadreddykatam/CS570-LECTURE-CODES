
public class BSTree<K extends Comparable<K>, V> {
	BSTNode<K, V> root_;

	public BSTree() {
		root_ = null;
	}

	public BSTNode<K, V> search(K key) {
		return searchRecursive(root_, key);
	}

	public BSTNode<K, V> searchRecursive(BSTNode<K, V> parent, K key) {

		if (parent.k.compareTo(key) == 0) // we've found the node
			return parent;

		if (parent.k.compareTo(key) > 0) { // the node should be on the left of the parent
			if (parent.left == null) {
				return null;
			}

			return searchRecursive(parent.left, key);

		} else { // the node should be to the right of the parent
			if (parent.right == null) {
				return null;
			}

			return searchRecursive(parent.right, key);
		}
	}

	public void insert(K key, V value) {
		BSTNode<K, V> n = new BSTNode<K, V>(key, value);

		if (root_ != null)
			insertRecursive(root_, n);
		else {
			root_ = n;
			return;
		}
	}

	void insertRecursive(BSTNode<K, V> parent, BSTNode<K, V> nodeToInsert) {

		if (parent.k.compareTo(nodeToInsert.k) > 0) { // the node should be placed in the left subtree
			if (parent.left == null) {
				parent.left = nodeToInsert;
				nodeToInsert.parent = parent;
			} else
				insertRecursive(parent.left, nodeToInsert);

		} else { // the node should be placed in the left subtree

			if (parent.right == null) {
				parent.right = nodeToInsert;
				nodeToInsert.parent = parent;
			} else
				insertRecursive(parent.right, nodeToInsert);
		}
	}

	// Auxiliary function which replaces a parent's child
	// with another. Depending whether the currentChild
	// is a left or a right child of the parent, the code is slightly different.
	// Hence this function to simplify the code for removeRecursive
	public boolean replaceChild(BSTNode<K, V> parent, BSTNode<K, V> currentChild, BSTNode<K, V> newChild) {
		if (parent.left != currentChild && parent.right != currentChild)
			return false;

		if (parent.left == currentChild) {
			parent.left = newChild;
		} else {
			parent.right = newChild;
		}

		if (newChild != null)
			newChild.parent = parent;

		return true;
	}

	public boolean remove(K key) {
		BSTNode<K, V> node = search(key);
		if (node == null) {
			return false;
		}

		return removeRecursive(node);
	}

	public boolean removeRecursive(BSTNode<K, V> node) {

		if (node == null)
			return false;

		if (node.left != null && node.right != null) {

			// Find the successor node

			BSTNode<K, V> succNode = node.right;
			while (succNode.left != null) {
				succNode = succNode.left;
			}

			node.k = succNode.k;
			node.v = succNode.v;

			removeRecursive(succNode);

		} else if (node == root_) {

			if (root_.left != null) {
				root_ = root_.left;
				root_.parent = null;
			} else if (root_.right != null) {
				root_ = root_.right;
				root_.parent = null;
			} else
				root_ = null;

		} else if (node.left != null) {

			BSTNode<K, V> parent = node.parent;
			return replaceChild(parent, node, node.left);

		} else { // node.left is null or both of the children are null

			BSTNode<K, V> parent = node.parent;
			return replaceChild(parent, node, node.right);
		}

		return true;

	}

	public String toString() {
		return root_.toString();
	}

	public void inOrderTraversal() {
		inOrderTraversalR(root_);
	}

	public void inOrderTraversalR(BSTNode<K, V> node) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			inOrderTraversalR(node.left);
		}

		System.out.println(node.k + "[" + node.v + "]");

		if (node.left != null) {
			inOrderTraversalR(node.right);
		}

	}

	public int getHeight() {
		return getHeightR(root_);
	}

	int getHeightR(BSTNode<K, V> node) {

		if (node == null) {
			return -1;
		}
		int leftHeight = getHeightR(node.left);
		int rightHeight = getHeightR(node.right);

		return 1 + Math.max(leftHeight, rightHeight);

	}

	public static void main(String[] args) {
		// int[] intL = { 8, 4, 12, 2, 6, 10, 15, 1, 3, 5, 7, 9, 11, 14, 16 };

		// int[] intL = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

		// int[] intL = { 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		int N = 16;
		int[] intL = new int[N];
		int minimum = 1;
		int maximum = 100;
		int rN = 0;
		for (int s = 0; s < N; s++) {
			rN = minimum + (int) (Math.random() * maximum);
			intL[s] = rN;

		}

		BSTree<Integer, String> b = new BSTree<Integer, String>();

		for (int s = 0; s < intL.length; s++) {
			b.insert(intL[s], Integer.toString(intL[s]));
		}

		System.out.println(b);

		BSTNode<Integer, String> node6 = b.search(6);

		System.out.println("**************************************\n" + node6);

		b.remove(6);

		System.out
				.println("**************************************\n" + b + "\n***************************************");

		b.inOrderTraversal();
		System.out.println("\n**************************************\n" + b.getHeight());

	}

}
