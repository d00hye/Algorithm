package week11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
	Queue<Integer> q = new LinkedList<Integer>();
	Queue<Integer> result = new LinkedList<Integer>();

	static int vertex = 7; // vertex 수
	static int edge = 9; // 간선 갯수

	void topologicalSort(int[] indegree, List<List<Integer>> array) {
		for (int i = 0; i < vertex + 1; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();
			result.offer(node);

			for (Integer i : array.get(node)) {
				indegree[i]--;

				if (indegree[i] == 0) {
					q.offer(i);
				}
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		int[] indegree = new int[vertex + 1];
		List<List<Integer>> array = new ArrayList<List<Integer>>();

		for (int i = 0; i < vertex + 1; i++)
			array.add(new ArrayList<Integer>());

		// 간선 정보
		int[] v1 = { 1, 1, 2, 4, 3, 3, 5, 2, 5 };
		int[] v2 = { 2, 3, 5, 6, 4, 7, 6, 4, 4 };

		for (int i = 0; i < edge; i++) {
			int c1 = v1[i];
			int c2 = v2[i];

			array.get(c1).add(c2);
			indegree[c2]++;
		}

		TopologicalSort t = new TopologicalSort();
		t.topologicalSort(indegree, array);
	}

}