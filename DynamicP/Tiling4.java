package week8;

// 크기가 2 X N인 직사각형을 1 X 1, 1 X 2, 2 X 1 타일로 채우는 경우의 수
public class Tiling4 {
	public int[][] memo = new int[1000][2]; 

	public int tiling(int n) {

		memo[0][0] = 0;
		memo[1][0] = 2;
		memo[2][0] = 7;
		memo[2][1] = 1;
		for (int i = 3; i <= n; i++) {
			memo[i][1] = (memo[i - 1][1] + memo[i - 3][0]);
			memo[i][0] = 2 * memo[i - 1][0] + 3 * memo[i - 2][0] + 2 * memo[i][1];
		}

		return memo[n][0];
	}

	public static void main(String[] args) {

		int n = 3;
		
		Tiling4 t = new Tiling4();
		int answer = t.tiling(n);

		System.out.println("크기가 2 X N인 직사각형을 1 X 1, 1 X 2, 2 X 1 타일로 채우는 방법의 수");
		System.out.println("N이 " + n + "인 경우: " + answer);
	}
}
