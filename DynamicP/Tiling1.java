package week8;

// 크기가 2 X N인 직사각형을 1 X 2, 2 X 1 타일로 채우는 경우의 수
public class Tiling1 {
	
	public static int[] memo;

	public int tiling(int n) {
		if (n >= 0 && n <= 2) {
			memo[n] = n;
		}

		if (memo[n] > 0) {
			return memo[n];
		}

		// 마지막에 1 x 2 타일 하나가 올 때 + 마지막에 2 X 1 타일 두개가 올 때
		memo[n] = tiling(n - 1) + tiling(n - 2);
		return memo[n];

	}
	

	public static void main(String[] args) {
		
		int n = 9;
		memo = new int[n + 1];
		
		Tiling1 t = new Tiling1();
		int answer = t.tiling(n);
	
		System.out.println("크기가 2 X N인 직사각형을 1 X 2, 2 X 1 타일로 채우는 방법의 수");
		System.out.println("N이 " + n + "인 경우: " + answer);
	}

}
