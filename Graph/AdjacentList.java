package week9;

import java.util.LinkedList;
import java.util.Stack;
import java.util.NoSuchElementException;

// Queue
class Queue<T> {
	@SuppressWarnings("hiding")
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	private Node<T> first;
	private Node<T> last;
	
	public void enqueue(T item) {
		Node<T> t = new Node<T>(item);
		
		if(last != null) {
			last.next= t;
		}
		last = t;
		if(first == null) {
			first = last;
		}
	}
	public T dequeue() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public boolean isEmpty() {
		return first == null;	
	}
}

// Graph
class Graph {
	class Node {
		int data;
		LinkedList<Node> adjacent;
		// marking
		boolean marked;

		Node(int data) {
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}

	// 노드 개수만큼 노드들을 저장 - 배열
	Node[] nodes;

	Graph(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void clearVisit() {
		for (int i = 0; i < nodes.length; i++) {
			Node root = nodes[i];
			root.marked = false;
		}
		System.out.println();
	}

	void dfs() {
		dfs(0);
	}

	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;
		while (!stack.isEmpty()) {
			Node r = stack.pop();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}

	void bfs() {
		bfs(0);
	}

	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new Queue<Node>();
		queue.enqueue(root);
		root.marked = true;
		while (!queue.isEmpty()) {
			Node r = queue.dequeue();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					queue.enqueue(n);
				}
			}
			visit(r);
		}
	}
	
	void dfsR(Node r) {
		if (r == null) return;
		r.marked= true;
		visit(r);
		for (Node n : r.adjacent) {
			if (n.marked == false) {
				dfsR(n);
				}
			}
	}
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	void dfsR() {
		dfsR(0);
	}
	
	private void visit(Node n) {
		System.out.print(n.data+ " ");
	}
}

public class AdjacentList {
	public static void main(String[] args) {
		
		/*	graph
		 * 		0
		 * 	   /
		 * 	  1 -- 3    7
		 * 	    ㅣ    / ㅣ\ / 
		 * 	    ㅣ  /  ㅣ  5
		 * 	    ㅣ/   ㅣ    \
		 * 	  2 -- 4	6 - 8
		 */
		
		// graph 구성
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);

		// 하나씩 실행해야 합니다 
		
		System.out.println("----- DFS(0) -----");
		g.dfs();
		g.clearVisit();

		System.out.println("----- BFS(0) -----");
		g.bfs();
		g.clearVisit();
		
		System.out.println("----- DFS(0)-Recursive -----");
		g.dfsR();
		g.clearVisit();
		
		System.out.println("----- DFS(3) -----");
		g.dfs(3);
		g.clearVisit();

		System.out.println("----- BFS(3) -----");
		g.bfs(3);
		g.clearVisit();

		System.out.println("----- DFS(3)-Recursive -----");
		g.dfsR(3);
		g.clearVisit();

	}

}
