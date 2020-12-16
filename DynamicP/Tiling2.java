package week8;

// 크기가 2 X N인 직사각형을 1 X 2, 2 X 1, 2x2 타일로 채우는 경우의 수
public class Tiling2 {
	public static int[] memo;
	
	public int tiling(int n) {

		// 1가지 경우 1*2
		if (n == 1) {
			memo[n] = 1;
		}

		// 3가지 경우 (1*2) (2*1) 2*2
		if (n == 2) {
			memo[n] = 3;
		}

		// 메모된 값이 있으면 메모된 값 출력
		if (memo[n] > 0) {
			return memo[n];
		}

		// 점화식 tilling(n) = tilling(n - 1) + (2 * tilling(n - 2))
		memo[n] = tiling(n - 1) + (2 * tiling(n - 2));
		return memo[n];
	}
	
	public static void main(String[] args) {
		
		int n = 10;
		memo = new int[n + 1];
		
		Tiling2 t = new Tiling2();
		int answer = t.tiling(n);
		
		System.out.println("크기가 2 X N인 직사각형을 1 X 2, 2 X 1, 2x2 타일로 채우는 방법의 수");
		System.out.println("N이 " + n + "인 경우: " + answer);
	}

}
