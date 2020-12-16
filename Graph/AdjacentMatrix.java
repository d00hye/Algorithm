package week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacentMatrix {
	int Node;
	int matrix[][];
	boolean[] marked;

	private Stack<Integer> stack;

	public AdjacentMatrix(int Node) {
		this.Node = Node;
		this.matrix = new int[Node][Node];
		this.marked = new boolean[Node];
	}

	void addEdge(int r, int c) {
		matrix[c][r] = 1;
		matrix[r][c] = 1;
	}

	void matrix() {
		for (int i = 0; i < Node; i++) {
			for (int j = 0; j < Node; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	void link() {
		for (int i = 0; i < Node; i++) {
			System.out.print("Node " + i + " - ");
			for (int j = 0; j < Node; j++) {
				if (matrix[i][j] == 1) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}

	void clearVisitArr() {
		for (int i = 0; i < marked.length; i++) {
			this.marked[i] = false;
		}
		System.out.println();
	}

	void dfs() {
		dfs(0);
	}
	
	void dfsR() {
		dfsR(0);
	}

	void dfsR(int index){
		marked[index] = true;
		visit(index);
	    for(int i = 0; i < this.Node ; i++)
	    {
	    	if(matrix[index][i] == 1 && !marked[i])
	        	dfsR(i);
	    }
	}

	public void dfs(int index) {
		stack = new Stack<Integer>();
		stack.push(index);
		marked[index] = true;
		visit(index);

		while(!stack.isEmpty()) {
			int k = stack.peek();
			boolean flag = false; 

			for(int i = 0; i < Node; i++) {
				if(matrix[k][i] == 1 && !marked[i]) {
					stack.push(i);
					System.out.print(i + " ");
					marked[i] = true;
					flag = true;
					break;
				}
			}

			if(!flag) {
				stack.pop();
			}
		}
	}

	void bfs() {
		bfs(0);
	}

	void bfs(int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(index);
		marked[index] = true;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			visit(temp);
			for (int k = 0; k < Node; k++) {
				if (matrix[temp][k] == 1 && !marked[k]) {
					marked[k] = true;
					queue.offer(k);
				}
			}
		}
	}

	private void visit(int i) {
		System.out.print(i + " ");
	}

	public static void main(String[] args) {

		/*	graph
		 * 		0
		 * 	   /
		 * 	  1 -- 3    7
		 * 	    び    / び\ / 
		 * 	    び  /  び  5
		 * 	    び/   び    \
		 * 	  2 -- 4	6 - 8
		 */

		// graph 姥失
		AdjacentMatrix g = new AdjacentMatrix(9);
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

		System.out.println("---- Graph Matrix ----");
		g.matrix();
		System.out.println();

		System.out.println("Link: ");
		g.link();
		g.clearVisitArr();

		System.out.println("----- DFS(0) -----");
		g.dfs();
		g.clearVisitArr();

		System.out.println("----- BFS(0) -----");
		g.bfs();
		g.clearVisitArr();
		
		System.out.println("----- DFS(0)-Recursive -----");
		g.dfsR();
		g.clearVisitArr();
		
		System.out.println("----- DFS(3) -----");
		g.dfs(3);
		g.clearVisitArr();

		System.out.println("----- BFS(3) -----");
		g.bfs(3);
		g.clearVisitArr();

		System.out.println("----- DFS(3)-Recursive -----");
		g.dfsR(3);
		g.clearVisitArr();
	}
}
