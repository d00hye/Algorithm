package week6;

public class DisjointSetTree {
	int[] rank, parent;
	int n;

	// Constructor - 바로 makeSet
	public DisjointSetTree(int n) {
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}

	// 배열 활용
	void makeSet() {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	// find, 경로 압축
	int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	// union, rank
	void union(int x, int y) {
		// Find
		int xRoot = find(x), yRoot = find(y);

		if (xRoot == yRoot)
			return;

		if (rank[xRoot] < rank[yRoot])
			parent[xRoot] = yRoot;

		else if (rank[yRoot] < rank[xRoot])
			parent[yRoot] = xRoot;

		else {
			if(x<y) {
				parent[yRoot] = xRoot;
				rank[xRoot] = rank[xRoot] + 1;
			}
			else {
				parent[xRoot] = yRoot;
				rank[yRoot] = rank[yRoot] + 1;
			}
			
		}
	}

	public static void main(String[] args) {

		int n = 10;
		DisjointSetTree dus = new DisjointSetTree(n);

		dus.union(0, 4);
		dus.union(8, 4);
		
		dus.union(3, 1);
		dus.union(3, 9);
		dus.union(7, 9);
		dus.union(1, 5);
		
		System.out.println("Union 결과 확인");
		System.out.println(dus.find(8));
		System.out.println(dus.find(4));
		
		System.out.println(dus.find(9));
		System.out.println(dus.find(3));
		System.out.println("----------------------");
		
		
		System.out.println("경로 압축 확인");
		if (dus.rank[8] == dus.rank[4])
			System.out.println("Yes");
		else
			System.out.println("No");

		if (dus.rank[3] == dus.rank[9])
			System.out.println("Yes");
		else
			System.out.println("No");
		
		
		System.out.println("--------두 집합 합치기----------");
		dus.union(3, 4);
		
		System.out.println(dus.find(4));
		System.out.println(dus.find(3));
		
		if (dus.rank[3] == dus.rank[4])
			System.out.println("Yes");
		else
			System.out.println("No");
		
		System.out.println("-----------연산 결과------------");
		for (int j = 0; j < n; j++) {
			System.out.println(dus.find(j));
		}
		
		
	}
}