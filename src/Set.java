import java.util.ArrayList;
import java.util.function.Predicate;

public class Set<K> {

	HashTable<K, Byte> elements;

	Set() {
		elements = new HashTable<K, Byte>();
	}

	public void add(K item) {
		elements.insert(item, null);
	}

	public boolean isElement(K item) {
		return (elements.search(item) != null);
	}

	public ArrayList<K> members() {

		return elements.keys();
	}

	public Set<K> union(Set<K> other) {

		Set<K> retSet = new Set<K>();

		for (K k : elements.keys()) {
			retSet.add(k);
		}

		for (K k : other.members()) {
			retSet.add(k);
		}

		return retSet;
	}

	public Set<K> intersection(Set<K> other) {
		ArrayList<K> otherElts = other.elements.keys();
		Set<K> retSet = new Set<K>();

		for (K k : otherElts) {
			if (this.isElement(k)) {
				retSet.add(k);
			}
		}

		return retSet;
	}

	public Set<K> filter(Predicate<K> pred) {

		Predicate<K> pred2 = Predicate.not(pred);

		Set<K> retSet = new Set<K>();

		ArrayList<K> filtered = new ArrayList<K>(elements.keys());

		filtered.removeIf(pred2);

		for (K k : filtered) {
			retSet.add(k);
		}

		return retSet;

	}

	public Set<K> difference(Set<K> other) {
		ArrayList<K> myElems = elements.keys();
		Set<K> retSet = new Set<K>();

		for (K k : elements.keys()) {
			if (other.isElement(k) == false) {
				retSet.add(k);
			}
		}
		return retSet;
	}

	public static void main(String[] args) {
		Set<Integer> mS = new Set<Integer>();

		int N = 26;
		ArrayList<Integer> intL = new ArrayList<Integer>();
		int minimum = 1;
		int maximum = 10;
		int rN = 0;
		for (int s = 0; s < N; s++) {
			rN = minimum + (int) (Math.random() * maximum);
			intL.add(rN);
		}

		for (Integer i : intL) {
			mS.add(i);
		}

		System.out.println("****************************\n" + intL);

		System.err.println("\n***************************\n" + mS.members());

		Set<Integer> filtered = mS.filter(x -> x % 2 == 0);

		System.err.println("\n+++++++++++++++++++++++\n" + filtered.members());

		Set<String> A = new Set<String>();

		A.add("alpha");
		A.add("Beta");
		A.add("gamma");
		A.add("delta");

		Set<String> B = new Set<String>();

		B.add("kappa");
		B.add("epsilon");
		B.add("gamma");
		B.add("delta");

		Set<String> C = A.union(B);

		System.out.println("*************" + C.members());

	}

}
