package com.krzysztofziomek.codility.dynamic;

import java.util.Arrays;

/**
 * @author Krzysztof Ziomek
 * @since 21/05/2017.
 */
public class MinAbsSum {

    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        A[0] = abs(A[0]);
        int sum = A[0];
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            A[i] = abs(A[i]);
            max = max(max, A[i]);
            sum += A[i];
        }

        int[] counter = new int[max + 1];
        for (int i = 0; i < A.length; i++) {
            counter[A[i]]++;
        }

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int a = 0; a < counter.length; a++) {
            if (counter[a] > 0) {
                for (int j = 0; j <= dp.length / 2; j++) {
                    if (dp[j] >= 0) {
                        dp[j] = counter[a];
                    } else if (j >= a && dp[j - a] > 0) {
                        dp[j] = dp[j - a] - 1;
                    }
                }
            }
        }


        int maxIdx = 0;
        for (int j = 0; j < sum / 2 + 1; j++) {
            if (dp[j] >= 0) {
                maxIdx = j;
            }
        }

        return sum - 2 * maxIdx;

    }

    private int abs(int n) {
        if (n >= 0) {
            return n;
        } else {
            return -n;
        }
    }

    private int max(int a, int b) {
        return a >= b ? a : b;
    }
}
