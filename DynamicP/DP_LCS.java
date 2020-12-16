package week7;

public class DP_LCS {

	String a = "abcbdab";
	String b = "bdcaba";
	int[][] LCS = new int[a.length() + 1][b.length() + 1];

	// Longest Common Subsequence - dynamic programming
	public int lcs() {
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				} else {
					LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);
				}
			}

		}
		return LCS[a.length()][b.length()];
	}

	// find String
	public void findlcs() {
		int i = a.length();
		int j = b.length();
		int index = LCS[i][j];
		int n = index;
		char[] lcs = new char[index + 1];
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				lcs[index - 1] = a.charAt(i - 1);
				i--;
				j--;
				index--;
			} else if (LCS[i - 1][j] > LCS[i][j - 1])
				i--;
			else
				j--;
		}
		System.out.print(a + " & " + b + " lcs: ");
		for (int k = 0; k <= n; k++)
			System.out.print(lcs[k]);
	}

	// Main
	public static void main(String[] args) {
		DP_LCS l = new DP_LCS();

		int length = l.lcs();
		System.out.println("length: " + length);
		l.findlcs();
	}
}