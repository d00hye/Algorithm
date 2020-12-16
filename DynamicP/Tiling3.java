package week8;

// 크기가 3 X N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수
// n이 짝수일 경우에만 완벽히 채워짐
public class Tiling3 {
	public static int[] memo;

	public int tiling(int n) {

		// 짝수 조건
		if (n > 1 && n % 2 == 0) {
			memo[0] = 1;
			memo[2] = 3;

			for (int i = 4; i < n + 1; i += 2) {
				memo[i] = memo[2] * memo[i - 2];
				for (int j = 4; j <= i; j += 2)
					memo[i] += 2 * memo[i - j];
			}
		}
		return memo[n];
	}

	public static void main(String[] args) {

		int n = 6;
		memo = new int[n + 1];

		Tiling3 t = new Tiling3();
		int answer = t.tiling(n);

		System.out.println("크기가 3 X N인 직사각형을 1 X 2, 2 X 1 타일로 채우는 방법의 수");
		System.out.println("N이 " + n + "인 경우: " + answer);
	}

}
