package com.krzysztofziomek.dynamic;

/**
 * @author Krzysztof Ziomek
 * @since 08/05/2017.
 */
public class LCS {

    // recursive
    public int lcs(char[] x, char[] y, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (x[m] == y[n]) {
            return 1 + lcs(x, y, m - 1, n - 1);
        } else {
            return Math.max(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
        }
    }

    // dynamic programming
    public int getLongestCommonSubsequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(j - 1) == Y.charAt(i - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        System.out.println(new LCS().getLongestCommonSubsequence(X, Y));
        System.out.println(new LCS().lcs(X.toCharArray(), Y.toCharArray(), X.length() - 1, Y.length() - 1));
    }
}
