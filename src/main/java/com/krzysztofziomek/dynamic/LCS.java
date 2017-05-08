package com.krzysztofziomek.dynamic;

/**
 * @author Krzysztof Ziomek
 * @since 08/05/2017.
 */
public class LCS {

    public int getLongestCommonSubsequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        System.out.println(new LCS().getLongestCommonSubsequence(X, Y));
    }
}
