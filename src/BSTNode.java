
public class BSTNode<K, V> {
	public K k;
	public V v;
	public BSTNode<K, V> left;
	public BSTNode<K, V> right;
	public BSTNode<K, V> parent;

	BSTNode(K key, V value) {
		k = key;
		v = value;
		left = null;
		right = null;
		parent = null;
	}

	void setParent(BSTNode<K, V> n, boolean left) {
		parent = n;
		if (left == true) {
			parent.left = this;
		} else {
			parent.right = this;
		}
	}

	int depth() {
		if (parent == null)
			return 0;
		return 1 + parent.depth();
	}

	public String toString() {
		String retStr = "";

		String leftStr = "";
		String rightStr = "";
		String myStr = "";

		if (left != null)
			leftStr = left.toString();

		if (right != null)
			rightStr = right.toString();

		myStr = k.toString();
		int myDepth = depth();

		retStr += rightStr + " ".repeat((int) (6 + 15 * (1 - 1 / ((double) myDepth * myDepth)) * myDepth)) + myStr
				+ "\n".repeat(2) + leftStr;

		return retStr;
	}

	public static void main(String[] args) {

		BSTNode<Integer, String> b1 = new BSTNode<Integer, String>(1, Integer.toString(1));
		BSTNode<Integer, String> b2 = new BSTNode<Integer, String>(2, Integer.toString(2));
		BSTNode<Integer, String> b3 = new BSTNode<Integer, String>(3, Integer.toString(3));

		b2.setParent(b1, true);
		b3.setParent(b1, false);

		System.out.println(b1);
	}

}
