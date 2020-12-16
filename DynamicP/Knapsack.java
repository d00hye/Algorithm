package week8;

public class Knapsack {
	private int unbounded(int M, int[] p, int m, int[] w) {
		int dp[] = new int[M + 1];

		for (int i = 0; i <= M; i++) {
			for (int j = 0; j < m; j++) {
				if (w[j] <= i) {
					dp[i] = Math.max(dp[i], dp[i - w[j]] + p[j]);
				}
			}
		}
		return dp[M];
	}

	public static void main(String[] args) {
		int M = 100;
		int p[] = { 10, 20, 30 };
		int m = p.length;
		int w[] = { 5, 10, 13 };
		

		Knapsack k = new Knapsack();
		int answer = k.unbounded(M, p, m, w);
		System.out.println("최대 가격: "+ answer + " 만원");
	}
}
