package com.krzysztofziomek.dynamic;

/**
 * @author Krzysztof Ziomek
 * @since 23/01/2021.
 * <p>
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 */
public class LongestIncreasingSubsequence {

    // Recursive
    public int recLis(int[] a) {
        int lis = 0;
        for (int i = 0; i < a.length; i++) {
            lis = Math.max(lis, recLis(a, i));
        }
        return lis;
    }

    public int recLis(int[] a, int i) {
        int lis = 1;
        int jLis = 0;
        for (int j = 0; j < i; j++) {
            if (a[j] < a[i]) {
                jLis = Math.max(jLis, recLis(a, j));
            }
        }
        return lis + jLis;
    }

    // Dynamic programming
    public int dpLis(int[] a) {
        int[] lis = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        int max = 0;
        for (int l : lis) {
            max = Math.max(max, l);
        }
        return max;
    }
}