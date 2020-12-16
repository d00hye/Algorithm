package week6;

public class DisjointSetList {

	class Node {
		int data;
		Node head;
		Node next;
		int weight;

		public Node(int i) {
			data = i;
			head = this;
			next = null;
			weight = 1;
		}

		public String toString() {
			return "" + data + "(" + weight + ")";
		}
	}

	Node tail;

	public DisjointSetList() {
		tail = null;
	}

	public DisjointSetList makeSet(int i) {
		Node newNode = new Node(i);
		DisjointSetList newSet = new DisjointSetList();
		newSet.tail = newNode;
		return newSet;
	}

	public Node findSet() {
		if (this.tail == this.tail.head) {
			return this.tail;
		} else {
			return this.tail.head;
		}
	}

	public DisjointSetList union(DisjointSetList u) {
		if (this.tail == null)
			return u;
		if (u.tail == null)
			return this;
		Node x = this.tail.head;
		Node y = u.tail.head;
		// by weight
		if (x.weight >= y.weight) {
			Node temp = y;
			while (temp != null) {
				temp.head = x;
				temp = temp.next;
			}
			this.tail.next = y;
			this.tail = u.tail;
			x.weight += y.weight;
			y.weight = 1;
			return this;
		} else {
			Node temp = x;
			while (temp != null) {
				temp.head = y;
				temp = temp.next;
			}
			u.tail.next = x;
			u.tail = this.tail;
			return u;
		}
	}

	public String toString() {
		if (this.tail == null)
			return null;
		Node temp = tail.head;
		String rV = "" + temp.toString();
		while (temp.next != null) {
			temp = temp.next;
			rV = rV + "->" + temp.toString();
		}
		return rV;
	}

	public static void main(String[] args) {
		DisjointSetList l = new DisjointSetList();
		DisjointSetList s1 = l.makeSet(1);
		DisjointSetList s2 = l.makeSet(2);
		DisjointSetList s3 = l.makeSet(3);
		DisjointSetList s4 = l.makeSet(4);
		DisjointSetList s5 = l.makeSet(5);

		System.out.println("Head of s5 : " + s5.findSet());

		System.out.println(s1);
		s1.union(s2);
		System.out.println(s1);
		System.out.println(s2);

		s1.union(s5);
		s3.union(s4);
		System.out.println(s5);
		System.out.println(s1);
		System.out.println(s3);

		System.out.println("Head of s5 : " + s5.findSet());
		System.out.println("Head of s4 : " + s4.findSet());
	}

}