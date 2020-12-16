package week7;

public class DP_Path {

	int n = 4;
	int m[][] = { { 6, 7, 12, 5 }, { 5, 3, 11, 18 }, { 7, 17, 3, 3 }, { 8, 10, 14, 9 } };
	int c[][] = new int[n][n];
	String P[][] = new String[n][n];

	
	// 최솟값 구하기 - dynamic programming
	public int dp() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					c[i][j] = m[0][0];
				else if (i == 0)
					c[i][j] = c[0][j - 1] + m[i][j];
				else if (j == 0)
					c[i][j] = c[i - 1][0] + m[i][j];
				else
					c[i][j] = m[i][j] + Math.min(c[i - 1][j], c[i][j - 1]);
			}
		}
		return c[n - 1][n - 1];
	}

	// 경로
	int path() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					c[i][j] = m[0][0];
					P[i][j] = "-";
				} else if (i == 0) {
					c[i][j] = c[0][j - 1] + m[i][j];
					P[i][j] = "←";
				} else if (j == 0) {
					c[i][j] = c[i - 1][0] + m[i][j];
					P[i][j] = "↑";
				} else {
					if (c[i - 1][j] < c[i][j - 1]) {
						c[i][j] = m[i][j] + c[i - 1][j];
						P[i][j] = "↑";
					} else {
						c[i][j] = m[i][j] + c[i][j - 1];
						P[i][j] = "←";
					}
				}
			}
		}
		return c[n - 1][n - 1];
	}

	void printPath() {
		int i = n - 1, j = n - 1;
		while (P[i][j] != "-") {
			System.out.print(i + "," + j + " -> ");
			if (P[i][j].equals("←"))
				j--;
			else
				i--;
		}
		System.out.print(i + "," + j + " (원점)");
	}
	
	// 각각의 배열들
	private void arrayM(){
		for(var i=0; i<n; i++){
			  for(var j=0; j<n; j++){
			System.out.print(m[i][j]+" ");
		}
			  System.out.println();
		}
		}
	
	private void arrayC(){
		for(var i=0; i<n; i++){
			  for(var j=0; j<n; j++){
			System.out.print(c[i][j]+" ");
		}
			  System.out.println();
		}
		}
	
	private void arrayP(){
		for(var i=0; i<n; i++){
			  for(var j=0; j<n; j++){
			System.out.print(P[i][j]+" ");
		}
			  System.out.println();
		}
		}
	
	// Main
	public static void main(String[] args) {
		DP_Path dP = new DP_Path();
		int path = dP.dp();
		
		System.out.println("기존: ");
		dP.arrayM();
		System.out.println();
		System.out.println("Calculate:");
		dP.arrayC();
		System.out.println();
		System.out.println("Minimum: " + path);
		System.out.println();
		System.out.println("path: ");
		dP.path();
		dP.printPath();
		System.out.println();
		System.out.println();
		System.out.println("화살표로 살펴보기:");
		dP.arrayP();

	}

}
